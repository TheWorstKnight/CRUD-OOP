package test;

import java.util.ArrayList;
import java.util.List;

public class Authors implements CRUD <Author> {
	
	private List<Author> authors = new ArrayList<>();

	public List<Author> getAuthor() {
		return authors;
	}

	@Override
	public List GetAll() {
		
		return authors;
	}

	@Override
	public Author GetOne(int id) {
		
		for(Author a:authors)
		{
			if(a.getId()==id)
				return a;
		}
		
		return null;
	}

	@Override
	public boolean Add(Author obj) {
		
		if(obj==null)
			return false;
		for(Author a:authors)
		{
			if(a.getId()==obj.getId())return false;
		}
		if(obj.get_isDead()==false && obj.getDateOfDeath()!=null)return false;
		else
			{
				authors.add(obj);
				return true;
			}
	}

	@Override
	public boolean Update(Author obj) {
		
		for(Author a:authors)
		{
			if(a.getId()==obj.getId())
			{
				if(obj.get_isDead()==false && obj.getDateOfDeath()!=null)return false;
				a.setFirstName(obj.getFirstName());
				a.setLastName(obj.getLastName());
				a.setDateOfBirth(obj.getDateOfBirth());
				a.set_isDead(obj.get_isDead());
				a.setDateOfDeath(obj.getDateOfDeath());
				a.setNumberOfBooks(obj.getNumberOfBooks());
				return true;
			}
		}
		
		return false;
	}

	@Override
	public boolean Delete(int id) {
		int position,flag;
		flag = 0;position = -1;
		for(Author a:authors)
		{
			if(a.getId()==id)
			{
				position = authors.indexOf(a);
				flag=1;
				break;
			}
		}
		
		if(flag!=0)
		{
			authors.remove(position);
			return true;
		}
		return false;
	}
	
}
