package io.egen.rentalflix;

/**
 * Entity representing a movie.
 * Fields: id, title, year, language
 */
public class Movie {
	
private String id;
private String title;
private int year;
private String language;
private Boolean isRented;
private String rentedUser;

public Movie(String id,String title,int year,String language)
{
	this.id=id;
	this.title=title;
	this.year=year;
	this.language=language;
	this.setIsRented(Boolean.FALSE);
	this.setRentedUser(null);
}

public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public int getYear() {
	return year;
}
public void setYear(int year) {
	this.year = year;
}
public String getLanguage() {
	return language;
}
public void setLanguage(String language) {
	this.language = language;
}

public Boolean getIsRented() {
	return isRented;
}

public void setIsRented(Boolean isRented) {
	this.isRented = isRented;
}

public String getRentedUser() {
	return rentedUser;
}

public void setRentedUser(String rentedUser) {
	this.rentedUser = rentedUser;
}

@Override
public String toString() {
	return " \n  Movie ID   :" + this.id + "\n  Title      :" + this.title + "\n  Language   :" + this.language + 
			"\n  Year       :"+this.year+"\n  IsRented   :"+ this.isRented+"\n  RentedUser :"+this.rentedUser;
} 
	
}
