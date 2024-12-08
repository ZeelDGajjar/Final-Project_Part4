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

        if (isbn.matches("\\d{1}-\\d{2,7}-\\d{1}")){
            return 0; //ISBN10
        } else if (isbn.matches("978-\\d{1}-\\d{2,7}-\\d{1}")){
            return 1; //ISBN13
        } else {
            return -1; //Invalid ISBN
        }

    }

    //Make sure all the words are to titlecase
    public void toTitleCase(String title, String author){

        title =  title.substring(1).toUpperCase() + title.substring(2).toLowerCase();
        author = author.substring(1).toUpperCase() + author.substring(2). toLowerCase();
    }


    public void toString(String title, String author, int price, String publisher, long isbn){

        System.out.printf("%-11s : %s /n", "Title", title);
        System.out.printf("%-11s : %s /n", "Author", author);
        System.out.printf("%-11s : %d /n", " Price", price);
        System.out.printf("%-11s : %s /n", "Publisher", publisher);
        System.out.printf("%-11s : %o /n", "ISBN", isbn);

    }

    public boolean equals(){
        return true; //to write
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
