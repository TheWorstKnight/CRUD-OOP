package test;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Library {

	public static Map<Author,Books> lib;
	public static Authors authors;
	
	public static void main(String[] args) {

		Library.CreateLib();
		
		StringBuilder menu = new StringBuilder("Menu :\n");
		menu.append("1 - ShowActions\n");
		menu.append("2 - CreateActions\n");
		menu.append("3 - UpdateActions\n");
		menu.append("4 - DeleteActions\n");
		menu.append("5 - Exit\n");
		
		StringBuilder showActions = new StringBuilder("ShowActions :\n");
		showActions.append("1 - ShowLibrary\n");
		showActions.append("2 - ShowAuthor'sInfo\n");
		showActions.append("3 - ShowBook'sInfo\n");
		showActions.append("4 - Exit\n");
		
		StringBuilder createActions = new StringBuilder("CreateActions :\n");
		createActions.append("1 - CreateAuthor\n");
		createActions.append("2 - CreateBookForAuthor\n");
		createActions.append("3 - Exit\n");
		
		StringBuilder updateActions = new StringBuilder("UpdateActions :\n");
		updateActions.append("1 - UpdateAuthor\n");
		updateActions.append("2 - UpdateBookForAuthor\n");
		updateActions.append("3 - Exit\n");
		
		StringBuilder deleteActions = new StringBuilder("DeleteActions :\n");
		deleteActions.append("1 - DeleteAuthor\n");
		deleteActions.append("2 - DeleteBookOfAuthor\n");
		deleteActions.append("3 - Exit\n");
		
		Scanner input = new Scanner(System.in);
		boolean exit;
				
		while(true)
		{
			System.out.println(menu);exit = false;
			
			switch(input.nextLine())
			{
				case "1":
				{
					while(!exit)
					{
						System.out.println(showActions);
						
						switch(input.nextLine())
						{
							case "1":
							{
								if(!lib.isEmpty())
								{
									for(Map.Entry e :lib.entrySet())
									{
										Author a = (Author)e.getKey();
										Books books = (Books)e.getValue();
										System.out.println("\n"+a.getId()+" "+a.getFirstName()+" "+a.getLastName());
										List<Book> collection = books.GetAll();
										if(!collection.isEmpty())
										{
											for(Book b:collection)
											{
												System.out.println("\t"+b.getId()+" "+b.getName()+"\n");
											}
										}
										else System.out.println("\t no books \n");
									}
								}
								else System.out.println("The library is empty");
								break;
							}
							
							case "2":
							{
								System.out.println("\nEnter author id:");
								int id = Integer.parseInt(input.nextLine());int flag =0;
								for(Author key:lib.keySet())
								{
									if(key.getId()==id)
									{System.out.println("FirstName: "+key.getFirstName()+"\n");
									 System.out.println("LastName:"+key.getLastName()+"\n");
									 System.out.println("DateOfBirth: "+key.getDateOfBirth()+"\n");
									 System.out.println("IsDead: "+key.get_isDead()+"\n");
									 if(key.get_isDead()==true)
									 System.out.println("DateOfDeath: "+key.getDateOfDeath()+"\n");
									 System.out.println("NumberOfBooks: "+key.getNumberOfBooks()+"\n");
										flag=1;
										break;}	
								}
								if(flag==0)
								System.out.println("No such author found\n");
								break;
							}
							
							case "3":
							{
								System.out.println("\nEnter book id:");
								int id = Integer.parseInt(input.nextLine());int flag =0;
								for(Books value:lib.values())
								{
									if(value.GetOne(id)!=null)
										{System.out.println("BookName: "+value.GetOne(id).getName()+"\n");
										System.out.println("DateOfRelease: "+value.GetOne(id).getDateOfRelease()+"\n");
										System.out.println("NumberOfPages: "+value.GetOne(id).getNumberOfPages()+"\n");
										System.out.println("NumberOfCopies: "+value.GetOne(id).getNumberOfCopies()+"\n");
										 flag=1;break;}
									
								}
								if(flag==0)
								System.out.println("No such book found\n");
								break;
							}
							case "4":
							{
								exit = true;
								break;
							}
							default:
							{
								System.out.println("No such key found. Please, repeat the action.\n"); break;
							}
						}
					}
					break;
				}
				
				case "2":
				{
					while(!exit)
					{
						System.out.println(createActions);
						
						switch(input.nextLine())
						{
							case "1":
							{
								int id,numberOfBooks;boolean isDead;
								String firstName,lastName;
								Date dateOfBirth=null,dateOfDeath=null;
								
								System.out.println("Enter author information:");
								
								System.out.println("Enter id:");
								id=Integer.parseInt(input.nextLine());
								
								System.out.println("Enter first name:");
								firstName = input.nextLine();
								
								System.out.println("Enter last name:");
								lastName = input.nextLine();
								
								System.out.println("Enter date of birth:");
								String temp = input.nextLine();
								DateFormat format = new SimpleDateFormat("yyyy.MM.dd");
								try {
									dateOfBirth = format.parse(temp);
								} catch (ParseException e) {
									e.printStackTrace();
								}
								
								System.out.println("Enter death state:");
								
								temp = input.nextLine();
								if(temp.equals("true")) isDead = true;
								else if(temp.equals("false"))isDead = false;
								else {System.out.println("Unrecognized string");break;}
								
								if(isDead)
								{
									System.out.println("Enter date of death:");
									temp = input.nextLine();
									try {
										dateOfDeath = format.parse(temp);
									} catch (ParseException e) {
										e.printStackTrace();
									}
								}
								
								System.out.println("Enter number of written books:");
								numberOfBooks=Integer.parseInt(input.nextLine());
								
								Author author = new Author(id, firstName, lastName, dateOfBirth, isDead, dateOfDeath, numberOfBooks);

								authors.Add(author);
								
								lib.put(author, new Books());
								
								System.out.println("Success!\n");
								
								break;
							}
							
							case "2":
							{
								int id,auth_id,numberOfPages,numberOfCopies,flag=0;
								String name;Date dateOfRelease = null;
								
								System.out.println("Enter book information:");
								
								System.out.println("Enter book id:");
								id=Integer.parseInt(input.nextLine());
								
								System.out.println("Enter name:");
								name = input.nextLine();
								
								System.out.println("Enter date of release:");
								String temp = input.nextLine();
								DateFormat format = new SimpleDateFormat("yyyy.MM.dd");
								try {
									dateOfRelease = format.parse(temp);
								} catch (ParseException e) {
									e.printStackTrace();
								}
								
								System.out.println("Enter number of pages:");
								numberOfPages=Integer.parseInt(input.nextLine());
								
								System.out.println("Enter number of copies:");
								numberOfCopies=Integer.parseInt(input.nextLine());
								
								System.out.println("Enter author id:");
								auth_id=Integer.parseInt(input.nextLine());
								
								Book book = new Book(id, name, dateOfRelease, numberOfPages, numberOfCopies);
								
								for(Map.Entry e :lib.entrySet())
								{
									Author a = (Author)e.getKey();
									if(a.getId()==auth_id)
									{
										List<Book> books = lib.get(a).GetAll();
										for(Book b:books)
										{
											if(b.getId()==id)
											{
												System.out.println("Book with such id already exists\n");flag=2; break;
											}
										}
										if(flag==2) {flag=0;break;}
										lib.get(a).Add(book);flag=1;
										System.out.println("Success!\n"); flag = 1;break;
									}
								}
								
								if(flag==0)
								System.out.println("No author with such id found");
								break;
							}
							
							case "3":
							{
								exit=true; break;
							}
						}
					}
					break;
				}
				
				case "3":
				{
						while(!exit)
					{
							System.out.println(updateActions);
							
							switch(input.nextLine())
							{
								case "1":
								{
									int id,numberOfBooks,flag=0;boolean isDead;
									String firstName,lastName;
									Date dateOfBirth=null,dateOfDeath=null;
									
									System.out.println("Enter author information:");
									
									System.out.println("Enter id:");
									id=Integer.parseInt(input.nextLine());
									
									System.out.println("Enter first name:");
									firstName = input.nextLine();
									
									System.out.println("Enter last name:");
									lastName = input.nextLine();
									
									System.out.println("Enter date of birth:");
									String temp = input.nextLine();
									DateFormat format = new SimpleDateFormat("yyyy.MM.dd");
									try {
										dateOfBirth = format.parse(temp);
									} catch (ParseException e) {
										e.printStackTrace();
									}
									
									System.out.println("Enter death state:");
									temp = input.nextLine();
									if(temp.equals("true"))isDead = true;
									else if(temp.equals("false"))isDead = false;
									else {System.out.println("Unrecognized string");break;}
									
									if(isDead)
									{
										System.out.println("Enter date of death:");
										temp = input.nextLine();
										try {
											dateOfDeath = format.parse(temp);
										} catch (ParseException e) {
											e.printStackTrace();
										}
									}
									
									System.out.println("Enter number of written books:");
									numberOfBooks=Integer.parseInt(input.nextLine());
									
									Author author = new Author(id, firstName, lastName, dateOfBirth, isDead, dateOfDeath, numberOfBooks);

									authors.Update(author);
									
									for(Map.Entry e:lib.entrySet())
									{
										Author a = (Author)e.getKey();
										if(a.getId()==author.getId())
											{
												lib.put(author, lib.get(a));
												lib.remove(a);
												flag=1;
												System.out.println("Success!\n");
												break;
											}
									}
									
									if(flag==0)
									System.out.println("No author with such id found");
									break;
									
								}
								
								case "2":
								{
									int id,auth_id,numberOfPages,numberOfCopies,flag=0;
									String name;Date dateOfRelease = null;
									
									System.out.println("Enter book information:");
									
									System.out.println("Enter book id:");
									id=Integer.parseInt(input.nextLine());
									
									System.out.println("Enter name:");
									name = input.nextLine();
									
									System.out.println("Enter date of release:");
									String temp = input.nextLine();
									DateFormat format = new SimpleDateFormat("yyyy.MM.dd");
									try {
										dateOfRelease = format.parse(temp);
									} catch (ParseException e) {
										e.printStackTrace();
									}
									
									System.out.println("Enter number of pages:");
									numberOfPages=Integer.parseInt(input.nextLine());
									
									System.out.println("Enter number of copies:");
									numberOfCopies=Integer.parseInt(input.nextLine());
									
									System.out.println("Enter author id:");
									auth_id=Integer.parseInt(input.nextLine());
									
									Book book = new Book(id, name, dateOfRelease, numberOfPages, numberOfCopies);
									
									for(Map.Entry e :lib.entrySet())
									{
										Author a = (Author)e.getKey();
										if(a.getId()==auth_id)
										{
											List<Book> books = lib.get(a).GetAll();
											for(Book b:books)
											{
												if(b.getId()==book.getId())
												{
													lib.get(a).Update(book);flag=1;
													System.out.println("Success!\n"); break;
												}
											}
											if(flag==1)break;
										}
									}
									
									if(flag==0)
									System.out.println("No author with such id found");
									break;
								}
								
								case "3":
								{
									exit=true; break;
								}
							}
					}
						break;
				}
				
				case "4":
				{
					while(!exit)
					{
						System.out.println(deleteActions);
						
						switch(input.nextLine())
						{
							case "1":
							{
								int id,flag=0;
								System.out.println("Enter author id:");
								id=Integer.parseInt(input.nextLine());
								
								for(Map.Entry e:lib.entrySet())
								{
									Author a = (Author)e.getKey();
									if(a.getId()==id)
										{
											lib.remove(a);
											flag=1;
											System.out.println("Success!\n");
											break;
										}
								}
								
								if(flag==0)
								System.out.println("No author with such id found\n");
								
								authors.Delete(id);
								
								break;
							}
							case "2":
							{
								int id,id_auth,flag=0;
								System.out.println("Enter author id:");
								id_auth=Integer.parseInt(input.nextLine());
								
								System.out.println("Enter book id:");
								id=Integer.parseInt(input.nextLine());
								
								for(Map.Entry e:lib.entrySet())
								{
									Author a = (Author)e.getKey();
									if(a.getId()==id_auth)
									{
										lib.get(a).Delete(id);flag=1;
										System.out.println("Success!");break;
									}
								}
								
								System.out.println("No book with such id found\n");
								if(flag==0)
									System.out.println("No author with such id found");
									break;
							}
							case "3":
							{
								exit=true; break;
							}
						}
					}
					break;
				}
				
				case "5":
				{
					return;
				}
				
				default:
				{
					System.out.println("No such key found. Please, repeat the action.\n"); break;
				}
			}
		}
	}
	
	public static void CreateLib()
	{
		lib = new HashMap<>();
		
		boolean [] check = new boolean[15];
		
			Books booksLondon = new Books();
			check[0]=booksLondon.Add(new Book(101, "The Game", new Date(1905,8,8), 576, 375000));
			check[1]=booksLondon.Add(new Book(102, "Lost Face", new Date(1910,23,2), 911, 580000));
			check[2]=booksLondon.Add(new Book(103, "White Fang", new Date(1906,11,4), 367, 200000));
			check[3]=booksLondon.Add(new Book(104, "Martin Eden", new Date(1909,1,10), 1240, 290000));
			check[4]=booksLondon.Add(new Book(105, "The Son of the Wolf", new Date(1900,16,7), 344, 28000));
			
			Books booksKing = new Books();
			check[5]=booksKing.Add(new Book(106, "Carrie", new Date(1974,5,11), 716, 370000));
			check[6]=booksKing.Add(new Book(107, "Thinner", new Date(1984,28,3), 511, 650000));
			check[7]=booksKing.Add(new Book(108, "The Dark Half", new Date(1989,4,11), 728, 390000));
			check[8]=booksKing.Add(new Book(109, "Firestarter", new Date(1980,5,5), 689, 465000));
			check[9]=booksKing.Add(new Book(110, "The Dead Zone", new Date(1979,23,8), 789, 700000));
			
			Books booksBrown = new Books();
			check[10] = booksBrown.Add(new Book(112, "Angels & Demons", new Date(2000,16,2), 1200, 560000));
			check[11] = booksBrown.Add(new Book(113, "Inferno", new Date(2000,16,2), 1200, 560000));
			check[12] = booksBrown.Add(new Book(114, "The Da Vinci Code ", new Date(2003,7,5), 1348, 430000));
			check[13] = booksBrown.Add(new Book(115, "Digital Fortress ", new Date(1998,16,8), 1234, 480000));
			check[14] = booksBrown.Add(new Book(116, "Origin", new Date(2017,6,11), 1056, 635000));
			
		try (FileWriter writer = new FileWriter("C:\\Users\\Viper\\Desktop\\Log.txt",true))
		{
			writer.append('\n');
			for(int i=0;i<15;i++)
			{
				if(check[i]==false) {
					writer.write("Something's wrong with book "+i);
					writer.append('\n');
				}
			}
			writer.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		Library.CreateAuthors();
		
		lib.put(authors.GetOne(101), booksLondon);
		lib.put(authors.GetOne(102), booksKing);
		lib.put(authors.GetOne(103), booksBrown);
	}
	
	public static void CreateAuthors()
	{
		authors = new Authors();
		boolean [] check = new boolean[3];
		
		check[0]=authors.Add(
				new Author(101
						,"Jack"
						, "London"
						, new Date(1876,1,12)
						, true
						, new Date(1916,22,11)
						, 50));
		check[1]=authors.Add(
				new Author(102
						,"Stephen"
						, "King"
						, new Date(1947,21,9)
						, false
						, null
						, 59));
		check[2]=authors.Add(
				new Author(103
						,"Daniel"
						, "Brown"
						, new Date(1964,22,6)
						, false
						, null
						, 30));
		try (FileWriter writer = new FileWriter("C:\\Users\\Viper\\Desktop\\Log.txt",false))
		{
			for(int i=0;i<3;i++)
				{
					if(check[i]==false) {
						writer.write("Something's wrong with author "+i);
						writer.append('\n');
					}
				}
			writer.close();
		}
		catch(Exception ex)
		{ex.printStackTrace();}
		
	}

}
