package test;

import java.util.Date;

public class Book extends Lib{
	
	private int id;
	private String name;
	private Date dateOfRelease;
	private int numberOfPages;
	private int numberOfCopies;
	
	public Book(int id,String name,Date dateOfRelease, int numberOfPages, int numberOfCopies)
	{
		this.id = id;
		this.name=name;
		this.dateOfRelease = dateOfRelease;
		this.numberOfPages = numberOfPages;
		this.numberOfCopies = numberOfCopies;

	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDateOfRelease() {
		return dateOfRelease;
	}
	public void setDateOfRelease(Date dateOfRelease) {
		this.dateOfRelease = dateOfRelease;
	}
	public int getNumberOfPages() {
		return numberOfPages;
	}
	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
	public int getNumberOfCopies() {
		return numberOfCopies;
	}
	public void setNumberOfCopies(int numberOfCopies) {
		this.numberOfCopies = numberOfCopies;
	}
	public int getId() {
		return id;
	}
	
	
	
}
