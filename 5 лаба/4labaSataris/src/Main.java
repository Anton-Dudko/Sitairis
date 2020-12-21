import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import javax.xml.parsers.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Main {
    private static LinkedList<Book> books = new LinkedList<>();

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        XMLHandler handler = new XMLHandler();
        parser.parse(new File("Book.xml"), handler);

        int count = 0;
        for (Book s : books){
            System.out.println(s);
            count++;
        }
        System.out.println("Всего книг: " + count);
        System.out.println("Общая стоимость: " + calc());

        addNewBook();




    }
    
    private static double calc(){
        double totalCost = 0;
        for (int i = 0; i <books.size() ; i++) {
            totalCost += books.get(i).getCost();
        }
        return totalCost;
    }


    private static class XMLHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("book")) {
                books.add(new Book( attributes.getValue("title"), attributes.getValue("author"),
                        attributes.getValue("year"), Double.parseDouble(attributes.getValue("cost"))));
            }
        }
    }

    private static void addNewBook(){
        BookFactory bookFactory = new BookFactory(books.get(1));
        Book book = bookFactory.copy();
        book.setCost(20.60);
        System.out.println("У книги новая цена: " + book);

        Shop shop = new Shop();
        shop.addBook(book);
        System.out.println("Книги в магазине: ");
        shop.showBooks();
    }
}
 class Book {
    private String title;
    private String author;
    private String year;
     private double cost ;

     public String getTitle() {
         return title;
     }

     public void setTitle(String title) {
         this.title = title;
     }

     public String getAuthor() {
         return author;
     }

     public void setAuthor(String author) {
         this.author = author;
     }

     public String getYear() {
         return year;
     }

     public void setYear(String year) {
         this.year = year;
     }

     public double getCost() {
         return cost;
     }

     public void setCost(double cost) {
         this.cost = cost;
     }



     public Book(String title, String author, String year, double cost) {
         this.title = title;
         this.author = author;
         this.year = year;
         this.cost = cost;
     }


     @Override
     public String toString() {
         return "Book{" +
                 "title='" + title + '\'' +
                 ", author='" + author + '\'' +
                 ", year='" + year + '\'' +
                 ", cost='" + cost + '\'' +
                 '}';
     }


 }
class BookFactory implements Copyable{
    private final Book book;

    public BookFactory(Book book) {
        this.book = book;
    }

    @Override
    public Book copy() {
        return book;
    }
}
interface Copyable{
    Book copy();
}

