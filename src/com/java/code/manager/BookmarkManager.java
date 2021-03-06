package com.java.code.manager;

import com.java.code.dao.BookmarkDao;
import com.java.code.entity.*;

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

    public void saveUserBookmark(User user, Bookmark bookmark) {
        UserBookmark userBookmark = new UserBookmark();
        userBookmark.setUser(user);
        userBookmark.setBookmark(bookmark);

        bookmarkDao.saveUserBookmark(userBookmark);
    }

    public void setKidFriendlyStatus(User user, String kidFriendlyDecision, Bookmark bookmark) {
        bookmark.setKidFriendlyStatus(kidFriendlyDecision);
        bookmark.setKidFriendlyMarkedBy(user);

        System.out.println("Kid friendly status "+ kidFriendlyDecision + " set by user "+user);
    }

    public void share(User user, Bookmark bookmark) {
        bookmark.setSharedBy(user);

        System.out.println("Data to be shared: ");
        if(bookmark instanceof Book){
            System.out.println(((Book) bookmark).getData());
        }else
        {
            System.out.println(((WebLink)bookmark).getData());
        }
    }
}
