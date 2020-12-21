import java.util.LinkedList;

public class Shop {
    LinkedList<Book> books = new LinkedList<>();

    public void addBook(Book book){
        books.add(book);
    }

    public void showBooks(){
        for(Book s: books){
            System.out.println(s);
        }
    }
}
