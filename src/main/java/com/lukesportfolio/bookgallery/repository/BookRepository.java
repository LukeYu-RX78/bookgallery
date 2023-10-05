package com.lukesportfolio.bookgallery.repository;

import com.lukesportfolio.bookgallery.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query(value = "SELECT * FROM bookgallery.book ORDER BY downloads DESC LIMIT 4",
           nativeQuery = true)
    List<Book> findBestSellers();

    List<Book> findByNameContaining(String bookName);

    List<Book> findByTag(String bookName);

    @Modifying
    @Transactional
    @Query("UPDATE Book b SET b.downloads = b.downloads + 1 WHERE b.id = :id")
    void addBookDownloadsNum(@Param("id") Integer id);
}
