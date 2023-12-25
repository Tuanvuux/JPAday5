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
//            findAll();
//            findByAuthor("Roger");
//            findByNameAndAuthor("Java A-Z", "Roger");
//            findByNameOrAuthor("Java A-Z", "Roger");
//            findByPriceLessThan(80);
//            findByBookDetailsIsbn("ISIBF1219321");
//            findByNameContaining("Nua");
//            getBookNameStartWith("J");
        getBookPriceGreaterThan(3);

    }

    public static void findAll(){
        List<BookEntity> bookEntityList=bookRepository.findAll();

        for (BookEntity C: bookEntityList){
            System.out.println(C.toString());
        }
    }

    public static void findByAuthor(String author){
        List<BookEntity> bookEntityList=bookRepository.findByAuthor(author);
        for (BookEntity C: bookEntityList){
            System.out.println(C.toString());
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


    public static void findByNameAndAuthor(String name,String author){
        List<BookEntity> bookEntityList=bookRepository.findByNameAndAuthor(author, name);
        for (BookEntity C: bookEntityList){
            System.out.println(C.toString());
        }
    }

    public static void findByNameOrAuthor(String name,String author){
        List<BookEntity> bookEntityList=bookRepository.findByNameOrAuthor(author, name);
        for (BookEntity C: bookEntityList){
            System.out.println(C.toString());
        }
    }

    public static void findByPriceLessThan(int price){
        List<BookEntity> bookEntityList=bookRepository.findByBookDetailsPriceLessThan(price);
        for (BookEntity C: bookEntityList){
            System.out.println(C.toString());
        }
    }

    public static void findByNameContaining(String Name){
        List<BookEntity> bookEntityList=bookRepository.findByNameContaining(Name);
        for (BookEntity C: bookEntityList){
            System.out.println(C.toString());
        }
    }





    public static void findByBookDetailsIsbn(String Isbn){
        List<BookEntity> bookEntityList=bookRepository.findByBookDetailsIsbn(Isbn);
        for (BookEntity C: bookEntityList){
            System.out.println(C.toString());
        }
    }

    public static void getBookNameStartWith(String name){
        List<BookEntity> bookEntityList=bookRepository.getBookNameStartWith(name);
        for (BookEntity C: bookEntityList){
            System.out.println(C.toString());
        }
    }

    public static void getBookPriceGreaterThan(Integer a){
        List<BookEntity> bookEntityList=bookRepository.getBookPriceGreaterThan(a);
        for (BookEntity C: bookEntityList){
            System.out.println(C.toString());
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
