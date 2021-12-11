package secondPart.bookTasks;

import interfaces.TaskMethods;

import java.util.Comparator;
import java.util.TreeSet;

public class Book implements Comparable<Book>, TaskMethods {
    private String title;
    private String author;
    private int price;
    private int isbn;
    private static int edition;

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPrice() {
        return price;
    }

    public static int getEdition() {
        return edition;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static void setEdition(int edition) {
        Book.edition = edition;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }
    public Book(String title, String author, int price){
        setAuthor(author);
        setTitle(title);
        setPrice(price);
        isbn = hashCode();
    }
    public Book(){

    }
    @Override
    public int hashCode() {
        int h0 = 100;
        int n = 323;
        char[] mas = (title + author).toCharArray();
        for (char ma : mas)
            h0 = (int) Math.pow((h0 + (int) ma), 2) % n;
        return h0+price;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        Book newBook = (Book) obj;
        return price == newBook.price
                && edition == Book.getEdition() &&
                   (title !=null && title.equals(newBook.getTitle()))
                && (author != null && author.equals(newBook.getAuthor()));
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Book(title, author, price);
    }

    @Override
    public String toString() {
        return "Title = " + title + ", Author = " + author + ", Price = " + price + ", Edition = " + getEdition();
    }

    @Override
    public int compareTo(Book o) {
        return getIsbn() - o.getIsbn();
    }

    @Override
    public void doTask() {
        BookPriceComparator comparator = new BookPriceComparator();
        TreeSet<Book> set = new TreeSet<>(comparator);
        set.add(new Book("Math", "Mark", 100));
        set.add(new Book("English", "Alex", 85));
        set.add(new Book("Java", "Jerry", 185));
        set.add(new Book("Python", "Peter", 130));
        for(Book book: set){
            System.out.println(book);
        }
    }
}
class BookTitleComparator implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        for(int i = 0; i<o1.getTitle().length() && i<o2.getTitle().length(); i++){
            if((int)o1.getTitle().charAt(i) == (int)o2.getTitle().charAt(i)){
                continue;
            }else{
                return (int) o1.getTitle().charAt(i) - o2.getTitle().charAt(i);
            }
        }
        if(o1.getTitle().length() > o2.getTitle().length()){
            return o1.getTitle().length() - o2.getTitle().length();
        }else if (o1.getTitle().length() < o2.getTitle().length()){
            return  o1.getTitle().length() - o2.getTitle().length();
        }else{
            return 0;
        }
    }
}
class BookAuthorComparator implements Comparator<Book>{

    @Override
    public int compare(Book o1, Book o2) {
        for(int i = 0; i<o1.getAuthor().length() && i<o2.getAuthor().length(); i++){
            if((int)o1.getAuthor().charAt(i) == (int)o2.getAuthor().charAt(i)){
                continue;
            }else{
                return (int) o1.getAuthor().charAt(i) - o2.getAuthor().charAt(i);
            }
        }
        if(o1.getAuthor().length() > o2.getAuthor().length()){
            return o1.getAuthor().length() - o2.getAuthor().length();
        }else if (o1.getAuthor().length() < o2.getAuthor().length()){
            return  o1.getAuthor().length() - o2.getAuthor().length();
        }else{
            return 0;
        }
    }
}
class BookTitleAuthorComparator implements Comparator<Book>{

    @Override
    public int compare(Book o1, Book o2) {
        BookTitleComparator comp1 = new BookTitleComparator();
        BookAuthorComparator comp2 = new BookAuthorComparator();
        if(comp1.compare(o1,o2) >0){
            return 1;
        }else if(comp1.compare(o1, o2) < 0){
            return -1;
        }else{
            if(comp2.compare(o1, o2) > 0){
                return 1;
            }else if(comp2.compare(o1,o2) < 0){
                return -1;
            }else{
                return 0;
            }
        }
    }
}
class BookPriceComparator implements Comparator<Book>{

    @Override
    public int compare(Book o1, Book o2) {
        if(o1.getPrice() > o2.getPrice()){
            return o1.getPrice() - o2.getPrice();
        }else if(o1.getPrice() < o2.getPrice()){
            return o1.getPrice() - o2.getPrice();
        }else{
            return 0;
        }
    }
}
class BookAuthorTitleComparator implements Comparator<Book>{

    @Override
    public int compare(Book o1, Book o2) {
        BookTitleComparator comp1 = new BookTitleComparator();
        BookAuthorComparator comp2 = new BookAuthorComparator();
        if(comp2.compare(o1,o2) >0){
            return 1;
        }else if(comp2.compare(o1, o2) < 0){
            return -1;
        }else{
            if(comp1.compare(o1, o2) > 0){
                return 1;
            }else if(comp1.compare(o1,o2) < 0){
                return -1;
            }else{
                return 0;
            }
        }
    }
}
class BookAuthorTitlePriceComparator implements Comparator<Book>{

    @Override
    public int compare(Book o1, Book o2) {
        BookAuthorComparator comp1 = new BookAuthorComparator();
        BookTitleComparator comp2 = new BookTitleComparator();
        BookPriceComparator comp3 = new BookPriceComparator();
        if(comp2.compare(o1,o2) >0){
            return 1;
        }else if(comp2.compare(o1, o2) < 0){
            return -1;
        }else{
            if(comp1.compare(o1, o2) > 0){
                return 1;
            }else if(comp1.compare(o1,o2) < 0){
                return -1;
            }else{
                if(comp3.compare(o1,o2) > 0){
                    return 1;
                }else if(comp3.compare(o1,o2) < 0){
                    return -1;
                }else{
                    return 0;
                }
            }
        }
    }
}