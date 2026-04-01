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
            
// System.out.println();
// System.out.println();

//             UserProfile user = new UserProfile("johndoe", "secret123", "john@example.com");
//             System.out.println("Original User: " + user);

//             //serialise 
//             try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("resources/user.ser"))){
//                 out.writeObject(user);
//                 System.out.println("User has been serialised");
//             }catch(IOException e){
//                 e.printStackTrace();
//             }

//             //deserialise
//             try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("resources/user.ser"))){
//                 UserProfile deserialiseUser = (UserProfile) in.readObject();
//                 System.out.println("User has been deserialised");
//                 System.out.println("Deserialised user: "+ deserialiseUser);
//             }catch(IOException | ClassNotFoundException e){
//                 e.printStackTrace();
//             }

System.out.println();
System.out.println();

            BankAccount bank = new BankAccount("16052004", "Marin Kitagawa", 12500.78, "GojoLo12");
            System.out.println("Original Bank Account: " + bank);

            //serialise
            try(ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream("resources/bank.ser"))){
                oout.writeObject(bank);
                System.out.println("Bank Account has been serialised");
            }catch(IOException e){
                e.printStackTrace();
            }

            //deserialise
            try(ObjectInputStream inn = new ObjectInputStream(new FileInputStream("resources/bank.ser"))){
                BankAccount deserialisedBankAccount = (BankAccount) inn.readObject();
                System.out.println("Bank Account has been deserialised");
                System.out.println("Deserialised bank account: " + deserialisedBankAccount);
            }catch(IOException | ClassNotFoundException e){
                e.printStackTrace();
            }

System.out.println();
System.out.println();

            List<Product> products = new ArrayList<>();
            products.add(new Product("Laptop", 999.99));
            products.add(new Product("Mouse", 29.99));

            System.out.println("Original Products (Version 1): ");
            products.forEach(System.out::println);

            //serialise version 1
            serializeProducts(products, "resources/products_v1.ser");

            System.out.println("\nAttempting to deserialise with Version 2 class...");
            deserializeProducts("resources/products_v1.ser");
        }
            private static void serializeProducts(List<Product> products, String filename){
                try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))){
                    out.writeObject(products);
                    System.out.println("\nProducts have been serialised");
                }catch(IOException e){
                    e.printStackTrace();
                }
            }

            private static void deserializeProducts(String filename) {
            try (ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream(filename))) {
                List<Product> loadedProducts = (List<Product>) in.readObject();
                System.out.println("Products have been deserialized");
                loadedProducts.forEach(System.out::println);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
    }
}
