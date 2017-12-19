package test;

import java.util.Date;

public class Author extends Lib {

	private int id;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private boolean isDead;
	private Date dateOfDeath;
	private int numberOfBooks;
	
	public Author(int id,String firstName, String lastName, Date dateOfBirth, boolean isDead, Date dateOfDeath, int numberOfBooks)
	{
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.isDead = isDead;
		this.dateOfDeath = dateOfDeath;
		this.numberOfBooks = numberOfBooks;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public boolean get_isDead() {
		return isDead;
	}
	public void set_isDead(boolean isDead) {
		this.isDead = isDead;
	}
	public Date getDateOfDeath() {
		return dateOfDeath;
	}
	public void setDateOfDeath(Date dateOfDeath) {
		this.dateOfDeath = dateOfDeath;
	}
	public int getNumberOfBooks() {
		return numberOfBooks;
	}
	public void setNumberOfBooks(int numberOfBooks) {
		this.numberOfBooks = numberOfBooks;
	}
	public int getId() {
		return id;
	}
	
	
	
}
