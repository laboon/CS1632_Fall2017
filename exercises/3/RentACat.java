import java.util.ArrayList;
import java.util.Scanner;

public class RentACat {

    public ArrayList<Cat> _cats = new ArrayList<Cat>();

    /**
     * Return a cat.
     * This should call the .returnCat() method on the passed-in
     * Cat object.
     * If the cat has *not* been rented out, then this method
     * should return false.  If the cat was already rented out,
     * this method should return true.
     * @param Cat the cat to return
     * @return boolean false if cat was not rented out, true otherwise
     */
    
    public boolean returnCat(Cat c) {
	// TODO
	return false;
    }

    /**
     * Rent a cat.
     * This should call the .rentCat() method on the passed-in
     * Cat object.
     * If the cat has *not* been rented out, then this method
     * should return true.  If the cat was already rented out,
     * this method should return false.
     * @param Cat the cat to rent
     * @return boolean false if cat was rented out, true otherwise
     */

    
    public boolean rentCat(Cat c) {
	// TODO
	return false;
    }


    /**
     * Given a list of cats, create a String list using the .toString()
     * method of each NON-RENTED Cat object in the list.  That is, 
     * it should only add cats who are available to be rented.
     * These cats should be separated by "\n" characters (line feeds).
     * Example:
     * ID 1. Jennyanydots
     * ID 2. Old Deuteronomy
     * ID 3. Mistoffelees
     * @param ArrayList<Cat> list of cats to print (filtering out rented ones)
     * @return "\n"-delimited list of rentable cats
     */
    
    public String listCats(ArrayList<Cat> catList) {
	// TODO
	return "WRITE CODE FOR THIS";
    }

    /**
     * Given a list of cats and id, return true if a cat exists in the list
     * or false if no cat with that ID number exists in the list.
     * If list is null or contains 0 elements, should always
     * return false.
     * @param int id ID of cat to search for
     * @param ArrayList<Cat> list of cats
     * @return true if cat exists in list, false otherwise
     */
    
    public boolean catExists(int id, ArrayList<Cat> catList) {
	// TODO
	return false;
    }

    /**
     * Given a list of cats and id, return true if a cat exists in the list
     * and is available for rent; otherwise return false.
     * If list is null or contains 0 elements, should always
     * return false.
     * @param int id ID of cat to search for
     * @param ArrayList<Cat> list of cats
     * @return true if cat available for rent, false otherwise
     */

    public boolean catAvailable(int id, ArrayList<Cat> catList) {
	// null / zero-element check
	if (catList == null || catList.size() == 0) {
	    return false;
	}
	Cat c = getCat(id, catList);
	if (c == null) {
	    // No cat of this ID exists, thus it is not available
	    return false;
	} else {
	    if (c.getRented()) {
		// This cat exists, but has already been rented
		return false;
	    }
	}

	// If cat exists and is not rented, then the cat
	// is available to rent
	return true;

    }

    /**
     * Given a list of cats and an id, return a reference to
     * the specified cat if a cat with that ID exists.
     * Return null if no cat of that ID exists in the list.
     * @param int id ID of cat to search for
     * @param ArrayList<Cat> catList - list of cats to search
     * @return Cat searched for if exists, null otherwise
     */
    
    public Cat getCat(int id, ArrayList<Cat> catList) {
	
	// null / zero-element check
	if (catList == null || catList.size() == 0) {
	    return null;
	}
	
	// Loop through every cat in the cat list
	for (Cat c : catList) {
	    // If we found a cat whose id matches the id
	    // of the argument, then we have a match and
	    // can thus return a reference to that cat
	    if (c.getId() == id) {
		return c;
	    }
	}
	// If we get all the way through the list and did
	// not find a cat whose ID matches the passed-in
	// ID, then the cat is not in the list
	return null;

    }

    /**
     * Main method
     * @param args - IGNORED, kept for compatibility
     */
    public static void main(String[] args) {

	RentACat rc = new RentACat();
	
	rc._cats.add(new Cat(1, "Jennyanydots"));
	rc._cats.add(new Cat(2, "Old Deuteronomy"));
	rc._cats.add(new Cat(3, "Mistoffelees"));

	// Create a local copy for this method
	ArrayList<Cat> cats = rc._cats;
	
	Scanner sc = new Scanner(System.in);
	boolean validCat = false;
	
	int option;
	boolean keepGoing = true;
	
	while (keepGoing) {
	    validCat = false;
	    System.out.print("Option [1,2,3,4] >");
	    try {
		option = sc.nextInt();
		switch (option) {
		case 1:
		    System.out.println("Cats for Rent");
		    System.out.println(rc.listCats(cats));
		    break;
		case 2:
		    validCat = false;
		    int catIdToRent;
		    while (!validCat) {
			System.out.print("Rent which cat? > ");
			try {
			    catIdToRent = sc.nextInt();
			    Cat c = rc.getCat(catIdToRent, cats);
			    if (c == null) {
				throw new NumberFormatException();
			    } else if (c.getRented()) {
				System.out.println("Sorry, " + c.getName() + " is not here!");
				validCat = true;
			    } else {
				rc.rentCat(c);
				System.out.println(c.getName() + " has been rented.");
				validCat = true;
			    }
			} catch (Exception nfex) {
			    System.err.println("Invalid cat ID.");
			}
		    }
		    break;
		case 3:
		    validCat = false;
		    int catIdToReturn;
		    while (!validCat) {
			System.out.print("Return which cat? > ");
			try {
			    catIdToReturn = sc.nextInt();
			    Cat c = rc.getCat(catIdToReturn, cats);
			    if (c == null) {
				throw new NumberFormatException();
			    } else if (!c.getRented()) {
				System.out.println(c.getName() + " is already here!");
				validCat = true;
			    } else {
				rc.returnCat(c);
				System.out.println("Welcome back," + c.getName() + "!");
				validCat = true;
			    }
			} catch (Exception nfex) {
			    System.err.println("Invalid cat ID.");
			}
		    }

		    break;
		case 4:
		    keepGoing = false;
		    break;
		default:
		    throw new NumberFormatException();
		}
	    } catch (Exception nfex) {
		System.err.println("Please enter 1, 2, 3 or 4");
		System.err.println("1. See list of cats for rent");
		System.err.println("2. Rent a cat to a customer");
		System.err.println("3. Return a cat");
		System.err.println("4. Quit");
		// Clear out the non-int in the scanner
		sc.next();
	    }
	}

	System.out.println("Closing up shop for the day!");
		  
    }
}

