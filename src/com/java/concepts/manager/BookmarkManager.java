package com.java.concepts.manager;

import com.java.concepts.dao.BookmarkDao;
import com.java.concepts.entity.Book;
import com.java.concepts.entity.Bookmark;
import com.java.concepts.entity.Movie;
import com.java.concepts.entity.WebLink;

public class BookmarkManager {

    private static BookmarkManager instance = new BookmarkManager();
    private static BookmarkDao bookmarkDao  = new BookmarkDao();

    private BookmarkManager() {
    }

    public static BookmarkManager getInstance() {
        return instance;
    }

    public Movie createMovie(long id, String title, String profileUrl, int releaseYear, String[] cast,
                             String[] directors, String genre, double imdbRating) {
        Movie movie = new Movie();
        movie.setId(id);
        movie.setTitle(title);
        movie.setProfileUrl(profileUrl);
        movie.setReleaseYear(releaseYear);
        movie.setCast(cast);
        movie.setDirectors(directors);
        movie.setGenre(genre);
        movie.setImdbRating(imdbRating);

        return movie;
    }

    public Book createBook(long id, String title, String profileUrl, int publicationYear, String publisher,
                           String[] authors, String genre, double amazonRating) {
        Book book = new Book();
        book.setId(id);
        book.setTitle(title);
        book.setProfileUrl(profileUrl);
        book.setPublicationYear(publicationYear);
        book.setPublisher(publisher);
        book.setAuthors(authors);
        book.setGenre(genre);
        book.setAmazonRating(amazonRating);

        return book;
    }

    public WebLink createWebLink(long id, String title, String profileUrl, String url, String host) {
        WebLink weblink = new WebLink();
        weblink.setId(id);
        weblink.setTitle(title);
        weblink.setProfileUrl(profileUrl);
        weblink.setUrl(url);
        weblink.setHost(host);

        return weblink;
    }

    public Bookmark[][] getBookmarks(){
        return bookmarkDao.getBookmarks();
    }
}