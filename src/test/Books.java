package test;

import java.util.ArrayList;
import java.util.List;

public class Books implements CRUD <Book> {

	private List<Book> books = new ArrayList<>();

	public List<Book> getBooks() {
		return books;
	}

	@Override
	public List GetAll() {
		
		return books;
	}

	@Override
	public Book GetOne(int id) {
		
		for(Book b:books)
		{
			if(b.getId()==id)
				return b;
		}
		
		return null;
	}

	@Override
	public boolean Add(Book obj) {
		if(obj==null)
			return false;
		for(Book b:books)
		{
			if(b.getId()==obj.getId())return false;
		}
				books.add(obj);
				return true;
	}

	@Override
	public boolean Update(Book obj) {
		
		for(Book b:books)
		{
			if(b.getId()==obj.getId())
			{
				b.setName(obj.getName());
				b.setDateOfRelease(obj.getDateOfRelease());
				b.setNumberOfPages(obj.getNumberOfPages());
				b.setNumberOfCopies(obj.getNumberOfCopies());
				return true;
			}
		}
		
		return false;
		
	}

	@Override
	public boolean Delete(int id) {
		
		int position,flag;
		flag = 0;position = -1;
		for(Book b:books)
		{
			if(b.getId()==id)
			{
				position = books.indexOf(b);
				flag=1;
				break;
			}
		}
		
		if(flag!=0)
		{
			books.remove(position);
			return true;
		}
		return false;
	}
	
	
	
}