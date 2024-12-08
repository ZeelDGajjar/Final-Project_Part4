import java.util.*;

public class Book {

    private String title;
    private String author;
    private double price;
    private String publisher;
    private String isbn;

    //Default Constructor
    public Book(){
    }


    public Book(String title){
        this.title = title;
    }


    public Book(String title, String author, double price, String publisher, String isbn){
        this.title = toTitleCase(title);
        this.author = toTitleCase(author);
        this.price = price;
        this.publisher = publisher;
        this.isbn = isbn;
    }


    public Book(Book another){
        this(another.title, another.author, another.price, another.publisher, another.isbn); ///not sure
    }

    //toWorkOn
    public int checkIsbnStatus(String isbn) {

        if (isbn.matches("\\d{1}-\\d{2,7}-\\d{1}")){ //not sure with the input strings
            return 0; //ISBN10
        } else if (isbn.matches("978-\\d{1}-\\d{2,7}-\\d{1}")){
            return 1; //ISBN13
        } else {
            return -1; //Invalid ISBN
        }

    }

    //Make sure all the words are to titlecase
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
        return titleCase.toString();
    }

    // toString method - to turn the information of a book to string and printing it
    public String toString(){
       return String.format("%-11s : %s /n %-11s : %s /n %-11s : %f /n %-11s : %s /n %-11s : %s /n", "Title", title, "Author", author, "Price", price, "Publisher", publisher, "ISBN", isbn);
    }

    // equals method - to check if two books are equal
    public boolean equals(Book anotherBook){
        return this.title.equals(anotherBook.title) && this.author.equals(anotherBook.author) && this.price == anotherBook.price && this.publisher.equals(anotherBook.publisher) && this.isbn.equals(anotherBook.isbn);
     }

    // clone method - cloning a book
    public Book clone(){
        return new Book(this.title, this.author, this.price, this.publisher, this.isbn);
    }


    //Getters - getting all the data members of the book
    public String getTitle(){
        return this.title;
    }

    public String getAuthor(){
        return this.author;
    }
    public double getPrice(){
        return this.price;
    }
    public String getPublisher(){
        return this.publisher;
    }
    public String getIsbn(){
        return this.isbn;
    }


    //Setters - setting all the data members of a book to another method
    public void setTitle(String anotherTitle){
        this.title = toTitleCase(anotherTitle);
    }

    public void setAuthor(String anotherAuthor){
        this.author = toTitleCase(anotherAuthor);
    }

    public void setPrice(int anotherPrice){
        this.price = anotherPrice;
    }

    public void setPublisher(String anotherPublisher){
        this.publisher = anotherPublisher;
    }

    public void setIsbn(String anotherIsbn){
        this.isbn = anotherIsbn;
    }
}
