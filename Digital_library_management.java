package java_Development;

import java.util.*;
import java.util.Scanner;

class methods {
	ArrayList<String> availableBooks = new ArrayList<>();
	ArrayList<String> bookNumber = new ArrayList<>();
	ArrayList<String> issuedBookNumber = new ArrayList<>();
	ArrayList<String> bookUserName = new ArrayList<>();
	ArrayList<String> issuedBooks = new ArrayList<>();

	methods() {
		availableBooks.add("Geeta");
		availableBooks.add("Ramayana");
		availableBooks.add("Gitanjali");
		availableBooks.add("Tamas");
		availableBooks.add("History");
		availableBooks.add("Constition");
		availableBooks.add("Godan");
		availableBooks.add("Madhusala");
		availableBooks.add("Nirmala");
		availableBooks.add("Rashmirathi");
		availableBooks.add("Pinjar");
		bookNumber.add("0201");
		bookNumber.add("0202");
		bookNumber.add("0203");
		bookNumber.add("0204");
		bookNumber.add("0205");
		bookNumber.add("0206");
		bookNumber.add("0207");
		bookNumber.add("0208");
		bookNumber.add("0209");
		bookNumber.add("0210");
		bookNumber.add("0211");
	}

	int userInput() {
		Scanner scan = new Scanner(System.in);
		System.out.println("\n1.To See Available books\n2.To Issue a book\n3.To Submit a book");
		System.out.print("4.To See Issued books\n5.To add new book\n0. to Close Library");
		System.out.println("Enter your choice :");
		int s;
		try {
			s = scan.nextInt();
		} catch (Exception e) {
			return 6;
		}
		return s;
	}

	void printAvailableBook() {
		int i = 0;
		for (; i < availableBooks.size(); i++) {
			System.out.println((i + 1) + ". " + bookNumber.get(i) + " " + availableBooks.get(i));
		}
		if (i == 0)
			System.out.println("No book Available in Library");
	}

	void issueBook() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the book number/name which to be issue ");
		String book = scan.next();
		int i;
		if (availableBooks.contains(book))
			i = availableBooks.indexOf(book);
		else if (bookNumber.contains(book))
			i = bookNumber.indexOf(book);
		else {
			System.out.println("\n" + book + " is not available in the library");
			return;
		}
		issuedBooks.add(availableBooks.get(i));
		issuedBookNumber.add(bookNumber.get(i));
		availableBooks.remove(i);
		bookNumber.remove(i);
		System.out.println("Name of person who issued the book ");
		scan.nextLine();
		bookUserName.add(scan.nextLine());
		System.out.println("Book Issued");
	}

	void returnBook() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the book number/name which to be submit ");
		String book = scan.next();
		int i;
		if (issuedBooks.contains(book))
			i = issuedBooks.indexOf(book);
		else if (issuedBookNumber.contains(book))
			i = issuedBookNumber.indexOf(book);
		else {
			System.out.println("\nThis book has not issued from this library.");
			return;
		}
		availableBooks.add(issuedBooks.get(i));
		bookNumber.add(issuedBookNumber.get(i));
		issuedBooks.remove(i);
		issuedBookNumber.remove(i);
		System.out.println("\nBook Submitted.");
	}

	void printIssuedBook() {
		int i = 0;
		for (; i < issuedBooks.size(); i++) {
			System.out.println((i + 1) + ". " + issuedBookNumber.get(i) + " " + issuedBooks.get(i) + "("
					+ bookUserName.get(i) + ")");
		}
		if (i == 0)
			System.out.println("No any book issued yet!");
	}

	void addBook() {
		Scanner scan = new Scanner(System.in);
		String newBookNumber;
		for (;;) {
			System.out.print("Enter the book number ");
			newBookNumber = scan.next();
			if ((bookNumber.contains(newBookNumber)) || (issuedBookNumber.contains(newBookNumber)))
				System.out.println("This book number already exist!");
			else
				break;
		}
		bookNumber.add(newBookNumber);
		System.out.print("Enter the book name ");
		scan.nextLine();
		availableBooks.add(scan.nextLine());
		System.out.println("Book Added.");
	}
}

public class Digital_library_management {
	public static void main(String[] args) {
		methods obj = new methods();
		for (;;) {
			int choice = obj.userInput();
			switch (choice) {
			case 0 -> {
				System.out.println("Library Closed!");
				System.exit(0);
			}
			case 1 -> obj.printAvailableBook();
			case 2 -> obj.issueBook();
			case 3 -> obj.returnBook();
			case 4 -> obj.printIssuedBook();
			case 5 -> obj.addBook();
			default -> System.out.println("Invalid Input!");
			}
		}
	}
}
