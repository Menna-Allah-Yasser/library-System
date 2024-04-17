package entity;

public class Book {

    private Long id;

    private String name;

    private String author_name;

    private boolean isBorrowed;

    public Book() {
    }

    public Book( String name, String author_name, boolean isBorrowed) {
        this.name = name;
        this.author_name = author_name;
        this.isBorrowed = isBorrowed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }


    public void display() {
        System.out.println( "Book{" +
                ", name='" + name + '\'' +
                ", author_name='" + author_name + '\'' +
                ", isBorrowed=" + isBorrowed +
                '}');
    }
}


