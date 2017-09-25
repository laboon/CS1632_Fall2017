# Exercise 2 - JUnit and LaboonCoin 

You have probably heard of Bitcoin or another cryptocurrency such as Ethereum, Litecoin, or Monero.  Today we are going to make our own blockchain to create a very simple way of storing data and cryptographically verifying it.  We will do so by filling in a template program, LaboonCoin, and write tests to ensure that your methods are doing what you expect them to be doing.

Blockchains work by creating a "block" of data, and having computers "work" to provide a verification of that data.  This work involves finding a particular "nonce" value which will make the hash value of the data have a specific format (in our case, having _n_ zeros as its first _n_ hexits).  The data to be hashed also includes the previous hash, thus "linking" the two blocks.  By doing this repeatedly, a series of cryptographically signed blocks are formed.  These not only prove that the data is valid, but also that it was added to the blockchain at a certain time.

Hashing gives you a specific, finite value for a larger sequence of values.  It will allow us to compare data without looking at every single character.  Let us imagine an extremely simple hash function, which only accepts capital letters, and returns a single value between 0 and 25 for that string.  The function accepts a string (which consists only of capital letters), and converts each letter to an equivalent value based on its alphabetical location (e.g A = 1, B = 2, C = 3, ... Z = 26).  We now add each value, and then take that final value, modulo 26.

Let's walk through an example using the phrase "AVOCADOS".  We start with a counter - call it n - at 0.  A is equal to 1, so we add 1 to the counter.  V is equal to 22, and so on.  This can also be expressed as 1 + 22 + 15 + 3 + 1 + 4 + 15 + 19, or 80.  Remember that we are mapping to a finite range of 0..25, though, so we take 80 % 26 = 2.  The "hash" of the string is thus 2.  Modifying any character would give a different hash.  We can thus "prove" that the hash goes along with the data, or compare data by comparing hashes.  Although in our case there is a 1 in 26 chance of a "hash collision" (different data leading to the same hash), by increasing the size of the hash value, we can minimize that risk.  We will be using Java int values as the hash (thus 32-bit values, not 0..25).  Cryptographically secure hashes tend to be 256 bits or larger.

Now we want to ensure that the block we are creating has been created immediately AFTER the previous block.  We will then hash the previous block's hash value as part of our data string to prove that it comes right after it.

However, this does not prove that much work has been done!  Calculating a hash value, even a cryptographically useful one (such as SHA256, the hash function used in Bitcoin - see http://www.xorbin.com/tools/sha256-hash-calculator), takes a minuscule fraction of a second on a modern computer.  However, trying to come up with a specific hash is very difficult and will require many attempts!

This is where the "nonce" value comes in.  This is a value added to the block, and hashed with it (along with the data and previous hash) to try and make a hash value with specific properties.  In our case, we are going to try to have our hash generate values with leading 0's.  We will have to try many, many nonce values to find a hash which meets these criteria!  Once we do, though, we have found what is called "the golden nonce" and get a reward of bitcoin from the network.  If someone else finds it before us, we start over again.  This is called "mining."

Let's give a full example of creating and mining a block.  Assume the previous block in the chain is valid and has a hash of 0x000ab43a.  You want to add the data "Alice gave Bob $10" to a block.  You add this data and then ask for it to be mined.  Miners will try many, many nonces to find one which creates a hash of the string "Alive gave Bob $10000ab43aXXXXXXXX" (the data appended with the previous hash appended with the nonce XXXXXXXX) which has at least three leading 0's (the current "difficulty").  Eventually, it finds that adding nonce 0x001aa59c ("Alive gave Bob $10000ab43a001aa59c") hashes to 0x000e854a, which meets our criteria.  A block has been mined and can be added to the blockchain.

You will fill in two methods (`hash()` and `validHash()`) that I currently have returning static values.  You should not need to modify any of the other methods (`main()`, `run()`, `mine()`, etc.) You will also write unit tests in LaboonCoinTest.  You should not need to modify TestRunner.  You should have at least three unit tests for each method, for a total of 2 * 3 or 6 unit tests.  Be sure to test edge cases and the happy path!

When complete, you should push up to GitHub (following the directions below) and email it to me.  It must be turned in by the next class.  Please be sure to note both your name and your partner's so that I give you both credit (or note that you worked alone if that is the case).

Note that this project is a very, very simple implementation of a blockchain, missing many important concepts (e.g. distributing transactions, creating a decent hash function, finding peers, dealing with forks in the chain, persistence, etc.).  If you are interested in a deeper understanding, I recommend the following resources:

1. "Bitcoin: A Peer-to-Peer Electronic Cash System" by Satoshi Nakomoto (alias) - (the original theory behind Bitcoin) - https://bitcoin.org/bitcoin.pdf
2. The Ethereum Whitepaper (the original theory behind Ethereum) - https://github.com/ethereum/wiki/wiki/White-Paper
3. The Ethereum Yellowpaper (the implementation of Ethereum) - https://github.com/ethereum/yellowpaper
4. "Mastering Bitcoin" by Andreas Antonopoulos (book on the technical details of Bitcoin)
5. "Introducing Ethereum and Solidity" by Chris Dannen (book introducing Ethereum)
6. "CryptoNote v2.0" by Nicolas van Saberhagen (alias) (article on the technology eventually implemented as the cryptocurrency Monero)

## Sample Output

Your output should look _exactly_ like this (everything is an entirely deterministic calculation based on the input).

```
(21410) $ java LaboonCoin
Enter data > boo
Hash (just data) = 551fda32
Mining..
Found nonce 000010bb!
Final hash 000b43be!
Enter data > boo
Hash (just data) = 551fda32
Mining..
Found nonce 000005a1!
Final hash 00075500!
Enter data > boo
Hash (just data) = 551fda32
Mining..
Found nonce 000016da!
Final hash 000f593c!
Enter data > quock
Hash (just data) = 7947a9e1
Mining..
Found nonce 00000229!
Final hash 000064f6!
Enter data > loop
Hash (just data) = c1a276b0
Mining..
Found nonce 00002815!
Final hash 00086d30!
Enter data > mars
Hash (just data) = 506f9b5d
Mining..
Found nonce 00004dfa!
Final hash 0008ff9f!
Enter data > mars
Hash (just data) = 506f9b5d
Mining..
Found nonce 00000513!
Final hash 00082253!
Enter data > q
Final Blockchain:
boo|00000000|000010bb|000b43be
boo|000b43be|000005a1|00075500
boo|00075500|000016da|000f593c
quock|000f593c|00000229|000064f6
loop|000064f6|00002815|00086d30
mars|00086d30|00004dfa|0008ff9f
mars|0008ff9f|00000513|00082253
```

Note that the initial "previous hash" is zero in the first transaction.

Note that although the some of the transactions are the same data, they require a different nonce because they included the previous hash as part of the block's data.

## Running Unit Tests

If you do this in an IDE such as Eclipse, or with a build tool such as Gradle, this can be handled automatically.  HOWEVER, please do not do this!  I want you to realize what is happening "behind the scenes".

First, we need to create a test runner.  I have created a simple one (TestRunner.java) for you, along with a very rudimentary unit test file.  They are located in the LaboonCoin subdirectory.  This will also include the two jar files you will need to use junit.  

To run it, you will need to compile it and ensure that the junit and hamcrest jars are in your classpath.  These are included in the repository for your convenience.

Note that the `$` is my command prompt.  Do not type that in.

```
$ javac -cp .:./junit-4.12.jar:./hamcrest-core-1.3.jar *.java

$ java -cp .:./junit-4.12.jar:./hamcrest-core-1.3.jar TestRunner
```

Replace ":" with ";" on Windows machines ( `java -cp .;./junit-4.12.jar;./hamcrest-core-1.3.jar TestRunner` ) .  If you are using Windows 7, you will also need to put the classpath argument entirely in quotes ( `java -cp ".;./junit-4.12.jar;./hamcrest-core-1.3.jar" TestRunner` )

Don't use "~" or other shortcuts when referring to the path that the `junit` and `hamcrest` jar files live.  Your Java files may compile but then won't run - the `-cp` option in `javac` parses paths different than the `-cp` option in `java`.  This is because LOL programming.

## Git / GitHub Basics

These are the basic steps for creating a repository and adding the files necessary for the project (and submitting them for grading). 

For a more detailed understanding, I recommend reading my "Friendly Introduction to Git" ( https://github.com/laboon/friendly_introduction_git ).  If you want a very detailed understanding, please read "Pro Git" by Scott Chacon and Ben Straub ( https://git-scm.com/book/en/v2 ).  Source control of one form or another is very important in software development, no matter what role you are in.

### Creating A Repository

1. Log in to GitHub at https://github.com
2. Click on "Repositories" tab
3. Click on the green "New" button
4. Name the repository CS1632_Exercise3
5. Ensure that the "public" radio button is selected
6. Check the checkbox to create a repository with a README.md file
7. Underneath that, select Add .gitignore: Java
8. Click the green "Create Repository" button

### Cloning It To Your Computer

1. Make sure you have git installed!
1. Navigate to https://github.com/YOUR_GITHUB_USERNAME/CS1632_Exercise3
2. Click on the green "Clone or Download" button
3. Make sure it says "Clone with HTTPS" (if it does not, click the "Use HTTPS" link)
4. Copy and paste the URL shown in the textbox
5. At the command line, or git command window if in Windows, navigate to the directory you want the repo to live under.
6. Type "git clone" and then paste the URL you copied.  This URL should end in .git, e.g., https://github.com/laboon/CS1632_Exercise3.git.
6. A copy of the repository is now located in a subdirectory called "CS1632_Exercise3" under the current directory.

### Adding Appropriate Files and Pushing Back To GitHub

1. Copy over all of the files from the exercises/2/LaboonCoin subdirectory.  You may do this by first cloning down my repository (see instructions above) or downloading each individual file using the GitHub web interface.
1. Ensure that you have completed the project - the 
2. Copy your files to the git repo's directory.
3. Type `git add .` (this will add all files to git)
4. Type `git commit -am "final"` (this will commit them all)
5. Type `git push origin master` (this will push your changes up to GitHub)
6. Go to https://github.com/YOUR_GITHUB_USERNAME/CS1632_Exercise2 in your browser and ensure that you see all of the files you expected to see.  If you are truly paranoid (always a good thing in a software tester!), you can try to clone down your finished repo to a different computer and ensure it works on that other computer first.

### Submission

Email me a link to repository (e.g., https://github.com/YOUR_GITHUB_USERNAME/CS1632_Exercise3) and the real names and github usernames of the people who worked on it.  This should be done _before_ next Monday's class class (i.e., you have one week to work on it).

```
Grading:
Blockchain code: 1 point
Tests: 1 point
```