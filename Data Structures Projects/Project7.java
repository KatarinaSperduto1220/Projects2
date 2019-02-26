//Katarina Sperduto
//Project7

import java.io.*;
import java.util.*;

public class Project7{
  static Scanner s;
  static ArrayList<Movie> movies;
  static Movie m;

//Menu Loop
  public static void mainMenu(){
    int choice = 0;
        while (choice != 6){
          System.out.println('\n'+"Welcome!" +'\n'+ "Type 1 to Add a new movie" +'\n'+ "Type 2 to Watch a Movie" +'\n'+ "Type 3 to Update a rating" +'\n'+ "Type 4 to List the Movies by Rating " +'\n'+ "Type 5 to list the Movies by Most Watched " +'\n'+ "Type 6 to Quit" +'\n'+ "What would you like to do?");
          int choice2 = s.nextInt();
          choice = choice2;
          s.nextLine();

          if (choice == 1 ){
            addMovie();
          }
          else if (choice == 2) {
            watchMovie();
          }
          else if (choice == 3){
            updateRating();
          }
          else if(choice == 4){
            listByRating();
          }
          else if(choice == 5){
            listByWatched();
          }
          else if(choice == 6){
            System.out.println('\n'+"You have chosen to quit. Have a good day!"+'\n');
          }
          else{
            System.out.println("Please pick type a number between 1 and 6" +'\n');
          }
        }
      }

//Method to add a new moive
  public static void addMovie(){
    System.out.println('\n'+"Please enter the name of the Movie you would like to add ");
    String name = s.nextLine();
    System.out.println("Please enter the rating between 1 and 5 ");
    int r = s.nextInt();
    s.nextLine();
    if (r >= 1 && r <= 5){
      m = new Movie(name,r);
      movies.add(m);
      System.out.println(m.name +" has been added"+ '\n');
    }
    else{
      System.out.println("That rating is not between 1 and 5. Please try again");
    }
  }

//Method to watch a movie
  public static void watchMovie(){
    System.out.println('\n'+"Which movie would you like to watch?");
    String movieTitle = s.nextLine();
    boolean movieFound = false;
    //Searching for the name of the movie in the list
    for(Movie names:movies ){
      //If movie is found in the list
      if (movieTitle.equals(names.getName())){
        names.timesWatched += 1;
        System.out.println("Times Watched for "+ names.getName()+ " has been increased to "+ names.timesWatched);
        movieFound = true;
        break;
      }
    }

    // If movie not found do the other case
    if (!movieFound){
      System.out.println("This moves is not one you have previously watched. Please add it first.");
      }
     }

//Method to Update a current ranking
  public static void updateRating(){
    System.out.println('\n'+"Update Rating");
    System.out.println(movies);
    System.out.println('\n'+ "Which movies ratings would you like to update");
    String movieTitle = s.nextLine();
    boolean movieFound = false;
    // Searching for the name of the movie in the list
    for(Movie names:movies ){
      //if the movie title is in teh list change rating
      if (movieTitle.equals(names.getName())){
        System.out.println(names.getName() + " has a current rating of "+ names.getRating()+'\n'+ "What would you like to change it to?");
        double newRating = s.nextInt();
        s.nextLine();
        names.setRating(newRating);
        System.out.println("You have changed the rating of "+ names.getName()+ " to "+ names.getRating());
        movieFound = true;
        break;
      }
    }
    //if movie titile not in the current list
    if (!movieFound){
      System.out.println("This moves is not one you have previously watched. Please add it first.");
      }
  }

// Method to sort movies bay ratings
  public static void listByRating(){
    System.out.println('\n'+"List by Rating");
    CompareRatings compareRatings = new CompareRatings();
    Collections.sort(movies, compareRatings);
    for (Movie movie: movies){
      System.out.println('\n'+"Rating: "+ movie.getRating()+'\n'+"Title: "+ movie.getName()+'\n'+"Times Watched: "+ movie.getTimesWatched()+'\n');
    }
  }
//Method to sort movies by the amount of times watched
  public static void listByWatched(){
    System.out.println('\n'+"List by Watched");
    CompareWatched compareWatched = new CompareWatched();
    Collections.sort(movies, compareWatched);
    for (Movie watch:movies){
      System.out.println('\n'+"Times Watched "+ watch.getTimesWatched()+'\n'+"Title: "+ watch.getName()+'\n'+"Rating: "+ watch.getRating()+'\n');
    }
  }

//Main Method
  public static void main(String [] args){
    s = new Scanner(System.in);
    movies = new ArrayList<Movie>();
    mainMenu();
    }
  }

//Movie Class
class Movie{
    public String name;
    public double rating;
    public int timesWatched;

    public Movie(String name, double rating){
      this.name = name;
      this.rating = rating;
      timesWatched = 1;
    }

    public String toString(){
      String s = "Title: "+ name + "\n";
      s += "Rating: " + rating + "\n";
      s += "Times Watched: " + timesWatched + "\n";

      return s;
    }
    public String getName(){return name;}
    public double getRating(){return rating;}
    public  void setRating(double rating){
      this.rating = rating;
    }
    public int getTimesWatched(){return timesWatched;}
  }

//Comparator class for comparing ratings
  class CompareRatings implements Comparator<Movie>{
    public int compare(Movie m1, Movie m2){

      if(m1.getRating() < m2.getRating()) {
        return 1;
      }
      if(m1.getRating() > m2.getRating()) {
        return -1;
      }
      else{
       return 0;
     }
    }
  }

//Comparator Class for comparing amount of times watched
  class CompareWatched implements Comparator<Movie>{
    public int compare(Movie m1, Movie m2){
      if(m1.getTimesWatched() < m2.getTimesWatched()) return 1;
      if(m1.getTimesWatched() > m2.getTimesWatched()) return -1;
      else return 0;
    }
  }
