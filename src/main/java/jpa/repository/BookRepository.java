package jpa.repository;

import jpa.entity.BookEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, Integer> {
    List<BookEntity> findByAuthor(String author);
    List<BookEntity> findByNameAndAuthor(String name, String author);
    List<BookEntity> findByNameOrAuthor(String name, String author);
    List<BookEntity> findByBookDetailsIsbn(String isbn);
    List<BookEntity> findByBookDetailsPriceLessThan(int price);
    List<BookEntity> findByBookDetailsPriceLessThanEqual(int price);
    List<BookEntity> findByBookDetailsPriceGreaterThanEqual(int price);
    List<BookEntity> findByNameContaining(String name);

    @Query("SELECT b FROM BookEntity b WHERE b.name LIKE ?1%")
    List<BookEntity> getBookNameStartWith(String name);

    @Query("SELECT b FROM BookEntity b WHERE b.bookDetails.price > ?1")
    List<BookEntity> getBookPriceGreaterThan(int price);

    // Thay đổi tên phương thức thành findAll() theo quy tắc của Spring Data JPA
    List<BookEntity> findAll();
}
