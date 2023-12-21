package jpa.main;

import jpa.config.SpringConfig;
import jpa.entity.BookDetailsEntity;
import jpa.entity.BookEntity;
import jpa.entity.CategoryEntity;
import jpa.repository.BookRepository;
import jpa.repository.CategoryRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;
import java.util.List;

public class Main {
    static ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    static BookRepository bookRepository = context.getBean(BookRepository.class);
    static CategoryRepository categoryRepository = context.getBean(CategoryRepository.class);

    public static void main(String[] args) {
        createNewBookEntryWithNewCategory();
        createNewBookEntry();
        findByAuthor("Roger");
        findByNameAndAuthor("Java A-Z", "Roger");
        findByNameOrAuthor("Java A-Z", "Roger");
        findByPriceLessThan(80);
        findByBookDetailsIsbn("ISIBF1219321");
        findByNameContaining("Nu");
        findAllBooks(); // Thêm phương thức này để lấy tất cả sách
    }

    public static void findByAuthor(String author) {
        List<BookEntity> bookEntityList = bookRepository.findByAuthor(author);
        displayBooks(bookEntityList, "Author", author);
    }

    public static void findByNameAndAuthor(String name, String author) {
        List<BookEntity> bookEntityList = bookRepository.findByNameAndAuthor(name, author);
        displayBooks(bookEntityList, "Name and Author", name + " - " + author);
    }

    public static void findByNameOrAuthor(String name, String author) {
        List<BookEntity> bookEntityList = bookRepository.findByNameOrAuthor(name, author);
        displayBooks(bookEntityList, "Name or Author", name + " - " + author);
    }

    public static void findByPriceLessThan(int price) {
        List<BookEntity> bookEntityList = bookRepository.findByBookDetailsPriceLessThan(price);
        displayBooks(bookEntityList, "Price less than", String.valueOf(price));
    }

    public static void findByNameContaining(String name) {
        List<BookEntity> bookEntityList = bookRepository.findByNameContaining(name);
        displayBooks(bookEntityList, "Containing name", name);
    }

    public static void findAllBooks() {
        List<BookEntity> bookEntityList = bookRepository.findAll();
        displayBooks(bookEntityList, "All books", "");
    }

    public static void findByBookDetailsIsbn(String isbn) {
        BookEntity bookEntity = bookRepository.findByBookDetailsIsbn(isbn);
        if (bookEntity != null) {
            System.out.println("\nFind book which isbn = " + isbn);
            System.out.println(bookEntity.toString());
        }
    }

    public static void createNewBookEntry() {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName("IT");
        categoryEntity.setDescription("IT books");
        categoryRepository.save(categoryEntity);

        BookEntity bookEntity = createNewBook();
        bookEntity.setCategory(categoryEntity);
        bookRepository.save(bookEntity);
    }

    public static void createNewBookEntryWithNewCategory() {
        CategoryEntity categoryEntity = createNewCategory();
        categoryRepository.save(categoryEntity);

        BookEntity bookEntity = createNewBook();
        bookEntity.setCategory(categoryEntity);
        bookRepository.save(bookEntity);
    }

    private static void displayBooks(List<BookEntity> bookEntityList, String criteria, String value) {
        if (bookEntityList != null) {
            System.out.println("\nFind " + bookEntityList.size() + " books by " + criteria + ": " + value);
            for (BookEntity bookEntity : bookEntityList) {
                System.out.println(bookEntity.toString());
            }
        }
    }

    private static CategoryEntity createNewCategory() {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName("IT");
        categoryEntity.setDescription("IT books");
        return categoryEntity;
    }

    private static BookEntity createNewBook() {
        BookDetailsEntity bookDetailsEntity = new BookDetailsEntity();
        bookDetailsEntity.setIsbn("ISIBF1219321");
        bookDetailsEntity.setNumberOfPage(23);
        bookDetailsEntity.setPrice(65);
        bookDetailsEntity.setPublishDate(LocalDate.now());

        BookEntity bookEntity = new BookEntity();
        bookEntity.setName("Java A-Z");
        bookEntity.setAuthor("Roger");
        bookEntity.setBookDetails(bookDetailsEntity);
        bookDetailsEntity.setBook(bookEntity);

        return bookEntity;
    }
}
