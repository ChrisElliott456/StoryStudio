package com.ss.StoryStudioApp;

import com.ss.StoryStudioApp.entity.Book;
import com.ss.StoryStudioApp.entity.Movie;
import com.ss.StoryStudioApp.entity.Profile;
import com.ss.StoryStudioApp.entity.User;
import com.ss.StoryStudioApp.repository.BookRepository;
import com.ss.StoryStudioApp.repository.MovieRepository;
import com.ss.StoryStudioApp.repository.ProfileRepository;
import com.ss.StoryStudioApp.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class StoryStudioAppApplication implements CommandLineRunner {
	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private ProfileRepository profileRepository;

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private UserRepository userRepository;

	private static final Logger logger = LoggerFactory.getLogger(StoryStudioAppApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(StoryStudioAppApplication.class, args);
		logger.info("Application started.");
	}

	@Override
	public void run(String... args) throws Exception {
		Profile profile1 = new Profile("Chris Elliott", "1996-05-05", "male");
		profileRepository.save(profile1);
		Profile profile2 = new Profile("Nellie Elliott", "1998-09-14", "female");
		profileRepository.save(profile2);

		List<Movie> movies = Arrays.asList(
				new Movie("Oppenheimer", "Christopoher Nolan", 2023, profile1),
				new Movie("Barbie", "Greta Gerwig", 2023, profile2),
				new Movie("Perfect Days", "Wim Wenders", 2023, profile1),
				new Movie("Past Lives", "Celine Song", 2023, profile2),
				new Movie("The Boy and the Heron", "Hayao Miyazaki", 2023, profile1),
				new Movie("Spider-Man: Across the Spider-Verse", "Joaquim Dos Santos, Justin K. Thompson, Kemp Powers", 2023, profile2),
				new Movie("The Holdovers", "Alexander Payne", 2023, profile1),
				new Movie("Underground", "Emir Kusturica", 1995, profile1),
				new Movie("A Touch of Zen", "King Hu", 1971, profile1),
				new Movie("Amélie", "Jean-Pierre Jeunet", 2001, profile1),
				new Movie("The Fifth Seal", "Zoltán Fábri", 1976, profile1),
				new Movie("Sunrise: A Song of Two Humans", "F. W. Murnau", 1927, profile1),
				new Movie("The Best of Youth", "Marco Tullio Giordana", 2003, profile1),
				new Movie("Tampopo", "Jūzō Itami", 1985, profile1),
				new Movie("The Pawnbroker", "Sidney Lumet", 1964, profile1),
				new Movie("Poetry", "Lee Chang-dong", 2010, profile1),
				new Movie("Cléo from 5 to 7", "Agnès Varda", 1962, profile1),
				new Movie("Diabolique", "Henri-Georges Clouzot", 1955, profile1),
				new Movie("EO", "Jerzy Skolimowski", 2022, profile1),
				new Movie("The Big City", "Satyajit Ray", 1963, profile1)
		);
		movieRepository.saveAll(movies);

		List<Book> books = Arrays.asList(
				new Book("A Wizard of Earthsea", "Ursula K. Le Guin", 1968, profile1),
				new Book("The Voyage of the Dawn Treader", "C. S. Lewis", 1952, profile2),
				new Book("The Lord of the Rings", "J. R. R. Tolkien", 1955, profile1),
				new Book("The Hobbit", "J. R. R. Tolkien", 1937, profile2),
				new Book("The High King", "Lloyd Alexander", 1968, profile1),
				new Book("The Warden and the Wolf King", "Andrew Peterson", 2014, profile2),
				new Book("The Last Olympian", "Rick Riordan", 2009, profile1),
				new Book("Harry Potter and the Order of the Phoenix", "J. K. Rowling", 2004, profile2),
				new Book("Inheritance", "Christopher Paolini", 2011, profile1),
				new Book("Till We Have Faces", "C. S. Lewis", 1956, profile1),
				new Book("The Ruins of Gorlan", "John Flanagan", 2006, profile1),
				new Book("Mythology", "Edith Hamilton", 1942, profile1),
				new Book("The Hero with a Thousand Faces", "Joseph Campbell", 1949, profile1),
				new Book("Ubik", "Philip K. Dick", 1969, profile1),
				new Book("Childhood's End", "Arthur C. Clarke", 1953, profile1),
				new Book("Henry and the Chalk Dragon", "Jennifer Trafton", 2017, profile2),
				new Book("Star Wars: Shadow of the Sith", "Adam Christopher", 2022, profile1)
		);
		bookRepository.saveAll(books);

		movieRepository
				.findAll().forEach(movie -> logger.info(movie.getTitle()+" "+movie.getYear()));
		bookRepository
				.findAll().forEach(book -> logger.info(book.getTitle()+" "+book.getAuthor()));
		profileRepository.findAll().forEach(profile -> logger.info(profile.getProfileName()));

		userRepository.save(new User("user", "$2y$10$A2DqILnGa7E8/f1bIdr8puZ6sNniXY0XPaBItIhFJbK8n6aqfZI6W", "USER"));
		userRepository.save(new User("admin", "$2y$10$fEMaHt.FUW3OzzfjxT.qleZk6gLJMq0awZeTmq2p8SRy7Qp0LzJAe", "ADMIN"));
	}



}
