package br.ufrn.imd.dao;

import java.util.ArrayList;

public abstract class BaseRepository<T> {
	
	protected ArrayList<T> entities;
	
	public abstract void seed();
	
	public abstract void write(T entity);
	
	public void add(T entity) {
		this.entities.add(entity);
	}
	
	public ArrayList<T> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<T> entities) {
		this.entities = entities;
	}
}
