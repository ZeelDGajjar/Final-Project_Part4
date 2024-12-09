package org.example;

/**
 * The org.example.Book class represents a book with details such as title, author, price, publisher, and ISBN.
 * It includes constructors, getters, setters, and methods for ISBN validation, title case conversion, and book comparison.
 *
 * @author 2474008
 */
public class Book {

    private String title;
    private String author;
    private double price;
    private String publisher;
    private String isbn;

    // Default constructor
    public Book() {}

    // Constructor that only initializes the title
    public Book(String title) {
        this.title = title;
    }

    // Constructor that initializes all data members
    public Book(String title, String author, double price, String publisher, String isbn) {
        this.title = toTitleCase(title);
        this.author = toTitleCase(author);
        this.price = price;
        this.publisher = publisher;
        this.isbn = isbn;
    }

    // Copy constructor
    public Book(Book another) {
        this(another.title, another.author, another.price, another.publisher, another.isbn);
    }

    /**
     * Checks the validity and type of ISBN (either ISBN-10 or ISBN-13).
     * @param isbn The ISBN to be checked.
     * @return 0 if ISBN-10, 1 if ISBN-13, -1 if invalid.
     */
    public int checkIsbnStatus(String isbn) {
        // Check for ISBN-10
        if (isbn.startsWith("1-") && isbn.endsWith("-1") && isbn.length() == 13) {
            String[] parts = isbn.split("-");
            if (parts.length == 4 && !parts[1].isEmpty() && parts[1].length() <= 5 &&
                    !parts[2].isEmpty() && parts[2].length() <= 7) {
                return 0;
            }
        }

        // Check for ISBN-13
        else if (isbn.startsWith("978-1") && isbn.endsWith("-1") && isbn.length() == 17) {
            String[] parts = isbn.split("-");
            if (parts.length == 4 && !parts[1].isEmpty() && parts[1].length() <= 5 &&
                    !parts[2].isEmpty() && parts[2].length() <= 7) {
                return 1;
            }
        }

        return -1; // Invalid ISBN
    }

    // Converts a string to title case
    public String toTitleCase(String input) {
        String[] words = input.toLowerCase().split(" ");
        StringBuilder titleCase = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                titleCase.append(Character.toUpperCase(word.charAt(0)));
                titleCase.append(word.substring(1));
                titleCase.append(" ");
            }
        }
        return titleCase.toString().trim();  // Trim extra space
    }

    /**
     * Returns a string representation of the org.example.Book object.
     * @return A formatted string containing the book's title, author, price, publisher, and ISBN.
     */
    public String toString() {
        return String.format("%-11s : %s\n%-11s : %s\n%-11s : %.2f\n%-11s : %s\n%-11s : %s\n",
                "Title", title, "Author", author, "Price", price,
                "Publisher", publisher, "ISBN", isbn);
    }

    /**
     * Compares this book with another book.
     * @param anotherBook The book to compare with.
     * @return true if the books are equal, false otherwise.
     */
    public boolean equals(Book anotherBook) {
        return this.title.equals(anotherBook.title) &&
                this.author.equals(anotherBook.author) &&
                this.price == anotherBook.price &&
                this.publisher.equals(anotherBook.publisher) &&
                this.isbn.equals(anotherBook.isbn);
    }

    // Clones the current book object
    public Book clone() {
        return new Book(this.title, this.author, this.price, this.publisher, this.isbn);
    }

    // Getter methods
    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public double getPrice() {
        return this.price;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public String getIsbn() {
        return this.isbn;
    }

    // Setter methods
    public void setTitle(String anotherTitle) {
        this.title = toTitleCase(anotherTitle);
    }

    public void setAuthor(String anotherAuthor) {
        this.author = toTitleCase(anotherAuthor);
    }

    public void setPrice(double anotherPrice) {
        this.price = anotherPrice;
    }

    public void setPublisher(String anotherPublisher) {
        this.publisher = anotherPublisher;
    }

    public void setIsbn(String anotherIsbn) {
        this.isbn = anotherIsbn;
    }
}
