package ie.atu.serialisation;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        System.out.println("Hello, Java Serialisation!");

        Book book = new Book("Java Fund.", "John Doe", 29.99);
        System.out.println("Original Book: " + book);

        //serialise
        try(FileOutputStream fileOut = new FileOutputStream("resources/book.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                out.writeObject(book);
                System.out.println("Book has been serialised ");

            }catch(IOException e){
                e.printStackTrace();
            }

        //deserialise
         try(FileInputStream fileIn = new FileInputStream("resources/book.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn)) {
                Book deserialisedBook = (Book) in.readObject();
                System.out.println("Book has been deserialised ");
                System.out.println("Deserialised book: " + deserialisedBook);
            }catch(IOException | ClassNotFoundException e){
                e.printStackTrace();
            }

System.out.println();
System.out.println();

        Movie movie = new Movie("Little Miss Sunshine", "Jonathan Dayton", 2006, 7.8);
        System.out.println("Perfect Movie: " + movie);
 //serialise
         try(FileOutputStream fileOutt = new FileOutputStream("resources/movie.ser");
            ObjectOutputStream outt = new ObjectOutputStream(fileOutt)) {
                outt.writeObject(movie);
                System.out.println("Movie has been serialised ");

            }catch(IOException e){
                e.printStackTrace();
            }

//deserialise
         try(FileInputStream fileInn = new FileInputStream("resources/movie.ser");
            ObjectInputStream inn = new ObjectInputStream(fileInn)) {
                Movie deserialisedMovie = (Movie) inn.readObject();
                System.out.println("Movie has been deserialised ");
                System.out.println("Deserialised movie: " + deserialisedMovie);
            }catch(IOException | ClassNotFoundException e){
                e.printStackTrace();
            }
System.out.println();
System.out.println();

        List<Movie> movies = new ArrayList<>();
            movies.add(new Movie("Train To Busan", "Yeon Sang-ho", 2016, 7.6));
            movies.add(new Movie("Hamnet", "Chloé Zhao", 2025, 7.9));
            movies.add(new Movie("Life as We Know It", "Greg Berlanti", 2010, 6.5));

            System.out.println("Original catalog: ");
            movies.forEach(System.out::println);

    //serialise list
            try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("resources/disk.ser"))){
                out.writeObject(movies);
                System.out.println("\nCatalog has been serialised");
            }catch(IOException e){
                e.printStackTrace();
            }
    //deserialise list
            List<Movie> loadedMovies = new ArrayList<>();
            try(ObjectInputStream iin = new ObjectInputStream(new FileInputStream("resources/disk.ser"))){
                loadedMovies = (List<Movie>) iin.readObject();
                System.out.println("Catalog has been deserialised");
            }catch(IOException | ClassNotFoundException e){
                 e.printStackTrace();
            }
            System.out.println("\nDeserialised catalog: ");
            loadedMovies.forEach(System.out::println);
            
    }
}
