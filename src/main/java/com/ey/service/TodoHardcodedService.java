package com.ey.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ey.dao.Todo;


/**
 * 
 * @author Amit B
 *
 */
@Service
public class TodoHardcodedService {

	
	private static List<Todo> todos = new ArrayList();
	private static long idCounter = 0;

	static {
		todos.add(new Todo(++idCounter, "Test", "Learn Angular- updated", new Date()));
		todos.add(new Todo(++idCounter, "Test", "Learn Java", new Date()));
		todos.add(new Todo(++idCounter, "Test", "Learn JavaScript", new Date()));
	}

	public List<Todo> finaAll() {
		return todos;
	}
	
	public Todo save(Todo todo) {
		if(todo.getId() == -1 || todo.getId() == 0) {
			todo.setId(++idCounter);
			todos.add(todo);
		} else {
			deleteById(todo.getId());
			todos.add(todo);
		}
		return todo;
		
	}

	public Todo deleteById(long id) {
		Todo todo = findById(id);
		if (todo == null)
			return null;

		if (todos.remove(todo)) {
			return todo;
		}
		return null;
	}

	public Todo findById(long id) {

		for (Todo todo : todos) {
			if (todo.getId() == id) {
				return todo;
			}
		}

		return null;
	}
}
