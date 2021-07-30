package com.neosoft.programs;
import java.util.*;

public class Movie {
	private int rating,year;
	private String name;
	
	public Movie(int rating,String name,int year) {
		this.rating=rating;
		this.name=name;
		this.year=year;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		/*Movie[] movie=new Movie[5];
		movie[0]=new Movie(4,"ranjhana","2019");
		movie[1]=new Movie(5,"Kedarnath","2018");
		movie[2]=new Movie(3,"Jab we met","2013");
		movie[3]=new Movie(5,"Om shanti Om","2012");
		movie[4]=new Movie(4,"Jai ho","2018");*/
		
		ArrayList<Movie> movie=new ArrayList<Movie>();
		movie.add(new Movie(4,"ranjhana",2019));
		movie.add(new Movie(5,"Kedarnath",2018));
		movie.add(new Movie(1,"Jab we met",2013));
		movie.add(new Movie(3,"Om shanti Om",2012));
		movie.add(new Movie(2,"Rangrez",2012));
		
		while(true) {
		System.out.println("\nEnter your choice: ");
		int choice=sc.nextInt();
		switch(choice) {
		
			
		case 1:
			Collections.sort(movie,new RatingCompare());
			for(Movie m:movie) {
				System.out.println(m.name+" "+m.rating+" "+m.year);
			}
			break;
		case 2:
			Collections.sort(movie,new MovieCompare());
			for(Movie m:movie) {
				System.out.println(m.name+" "+m.rating+" "+m.year);
			}
			break;
		case 3:
			Collections.sort(movie,new YearCompare());
			for(Movie m:movie) {
				System.out.println(m.name+" "+m.rating+" "+m.year);
			}
			break;
		case 4:
			Collections.sort(movie,new RatingCompare().reversed());
			for(Movie m:movie) {
				System.out.println(m.name+" "+m.rating+" "+m.year);
			}
			break;
		case 5:
			Collections.sort(movie,new MovieCompare().reversed());
			for(Movie m:movie) {
				System.out.println(m.name+" "+m.rating+" "+m.year);
			}
			break;
		case 6:
			Collections.sort(movie,new MovieCompare().reversed());
			for(Movie m:movie) {
				System.out.println(m.name+" "+m.rating+" "+m.year);
			}
			break;
		case 7:
			System.exit(0);
			
		}
		}
		
		
		
		//ArrayList<Movie> movieCollection=new ArrayList<Movie>(movie);
		
		
	
		/*for(int i=0;i<5;i++) {
			System.out.println(movie.get(i).name+" "+movie.get(i).rating+" "+movie.get(i).year);
		}*/
		
		
		
		
	}

}
class RatingCompare implements Comparator<Movie>{
	
	@Override
	public int compare(Movie o1, Movie o2) {
		if(o1.getRating()>o2.getRating()) {
			return 1;
		}
		else if(o1.getRating()<o2.getRating()) {
			
			//System.out.println(o1.getRating());
			return -1;
		}
		else
			return 0;
	}
	
}

class MovieCompare implements Comparator<Movie>{
	
	@Override
	public int compare(Movie o1, Movie o2) {
		return o1.getName().compareTo(o2.getName());
	}
	
}

class YearCompare implements Comparator<Movie>{
	
	@Override
	public int compare(Movie o1, Movie o2) {
		if(o1.getYear()>o2.getYear()) {
			return 1;
		}
		else if(o1.getYear()<o2.getYear()) {
			
			//System.out.println(o1.getRating());
			return -1;
		}
		else
			return 0;
	}
	
}