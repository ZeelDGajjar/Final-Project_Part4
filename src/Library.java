import java.util.*;

/**
 *
 * @author 2474008
 */

public class Library {

    private ArrayList<Book> book;

    // public Library() {}  //cant add empty constructor

    public Library(){
        book = new ArrayList<>(5);
        book.add(new Book("1984", "George Orwell", 9.99, "Penguin", "978-0-452-28423-4")); //do need to add these?
        book.add(new Book("To Kill a Mockingbird", "Harper Lee", 7.99, "J.B. Lippincott & Co.", "978-0-06-112008-4"));
        book.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", 10.99, "Scribner", "978-0-7432-7356-5"));
        book.add(new Book("Moby Dick", "Herman Melville", 12.99, "Harper & Brothers", "978-0-14-243724-7"));
        book.add(new Book("Pride and Prejudice", "Jane Austen", 8.99, "T. Egerton", "978-0-19-953556-9"));
    }

    public Library(ArrayList<Book> book){
        this.book = new ArrayList<>(book);
    }

    public Library(Library anotherLibrary){
        this.book = new ArrayList<>(anotherLibrary.book);
    }

    public ArrayList<Book> searchBook(String Keyword){
        ArrayList<Book> searchResult = new ArrayList<>();
        for (Book book : book) {
            if (book.getTitle().toLowerCase().contains(Keyword.toLowerCase()) || book.getAuthor().toLowerCase().contains(Keyword.toLowerCase())) {
                searchResult.add(book);
            }
        }
        return searchResult;
    }

    public boolean equals(Object obj){
        return this.book.equals(obj);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("BookCollection:\n");
        for (Book book : book) {
            sb.append(book.toString()).append("\n");
        }
        return sb.toString();
    }

    public ArrayList<Book> getBook(){
        return new ArrayList<>(book); // Return a copy to maintain encapsulation
    }

    public void setBook(ArrayList<Book> book){
        this.book = new ArrayList<>(book); // Create a copy to prevent external modifications
    }
}
