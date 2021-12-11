package secondPart.bookTasks;

public class ProgrammerBook extends Book{

    private String language;
    private int level;

    @Override
    public int hashCode() {
        int h0 = 100;
        int n = 323;
        char[] mas = (getTitle() + getAuthor() + language).toCharArray();
        for (char ma : mas)
            h0 = (int) Math.pow((h0 + (int) ma), 2) % n;
        return h0+getPrice() + getLevel();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        ProgrammerBook newBook = (ProgrammerBook) obj;
        return getPrice() == newBook.getPrice()
                && getEdition() == Book.getEdition() &&
                (getTitle() !=null && getTitle().equals(newBook.getTitle()))
                && (getAuthor() != null && getAuthor().equals(newBook.getAuthor()))
                && (getLanguage() != null && getLanguage().equals(newBook.getLanguage()))
                && (getLevel() == newBook.getLevel());
    }

    @Override
    public String toString() {
        return "Title = " + getTitle() + ", Author = " + getAuthor() + ", Price = " + getPrice() + ", Edition = " + getEdition()
                + ", Language = " + getLanguage() + ", Level = " + getLevel();
    }

    public ProgrammerBook(String title, String author, int price, String language, int level) {
        super(title, author, price);
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
