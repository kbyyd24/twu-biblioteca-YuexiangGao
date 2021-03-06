package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BibliotecaLibraryTestForCheckOutMovie {

    private BibliotecaLibrary library;
    private String number;
    private String password;

    @Before
    public void setUp() throws Exception {
        library = new BibliotecaLibrary();
        number = "000-0001";
        password = "p1";
    }

    @Test
    public void should_set_movie_isCheckOut_to_be_true_when_check_out_movie_success() throws Exception {
        library.login(number, password);
        String movieName = "movie1";
        library.checkOutMovie(movieName);
        assertTrue(library.getMovies().get(0).isCheckOut());
    }

    @Test
    public void should_return_true_when_check_out_movie_success() throws Exception {
        library.login(number, password);
        assertTrue(library.checkOutMovie("movie1"));
    }

    @Test
    public void should_return_false_when_check_out_movie_failed() throws Exception {
        library.login(number, password);
        assertFalse(library.checkOutMovie("movieName"));
    }

    @Test
    public void should_check_out_fail_when_movie_isCheckOut_is_true() throws Exception {
        library.login(number, password);
        library.getMovies().get(0).setCheckOut(true);
        assertFalse(library.checkOutMovie("movie1"));
    }

    @Test
    public void should_return_false_when_login_use_is_null() throws Exception {
        assertFalse(library.checkOutMovie("movie1"));
    }
}