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


    public String toString(){
       return String.format("%-11s : %s /n %-11s : %s /n %-11s : %f /n %-11s : %s /n %-11s : %s /n", "Title", title, "Author", author, "Price", price, "Publisher", publisher, "ISBN", isbn);
    }

    public boolean equals(Object anotherObject){
    //to write
     }


    public Book clone(){

        Book cloneBook = new Book();

        cloneBook.title = this.title;
        cloneBook.author = this.author;
        cloneBook.price = this.price;
        cloneBook.publisher = this.publisher;
        cloneBook.isbn = this.isbn;

        return cloneBook;
    }


    //Getters
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
    public long getIsbn(){
        return this.isbn;
    }


    //Setters
    public void setTitle(String anotherTitle){
        this.title = anotherTitle;
    }

    public void setAuthor(String anotherAuthor){
        this.author = anotherAuthor;
    }

    public void setPrice(int anotherPrice){
        this.price = anotherPrice;
    }

    public void setPublisher(String anotherPublisher){
        this.publisher = anotherPublisher;
    }

    public void setIsbn(long anotherIsbn){
        this.isbn = anotherIsbn;
    }
}
