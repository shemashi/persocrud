package net.springboot.javaproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.springboot.javaproject.entity.Todo;
import net.springboot.javaproject.repository.TodoRepository;

@Controller
@RequestMapping("/todo/")
public class TodoController {

	public @interface Valid {
	
	}

	@Autowired
	private TodoRepository todoRepository;	
	
	@GetMapping("showForm")
	public String showTodoForm(Todo todo) {
		return "add-todo";
	}
	
	@GetMapping("list")
	public String todo(Model model) {
		model.addAttribute("todo", this.todoRepository.findAll());
		return "listeTodo";
	}
	
	@PostMapping("add")
	public String addTodo(@Valid Todo todo, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "add-todo";
		}
		
		this.todoRepository.save(todo);
		return "redirect:list";
	}
	
	
	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable ("id") long id, Model model) {
		Todo todo = this.todoRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid todo id : " + id));
		
		model.addAttribute("todo", todo);
		return "update-todo";
	}
	
	@PostMapping("update/{id}")
	public String updatetodo(@PathVariable("id") long id, @Valid Todo todo, BindingResult result, Model model) {
		if(result.hasErrors()) {
			todo.setId(id);
			return "update-todo";
		}
		
		// update todo
		todoRepository.save(todo);
		
		// get all todo ( with update)
		model.addAttribute("todo", this.todoRepository.findAll());
		return "listeTodo";
	}
	
	@GetMapping("delete/{id}")
	public String deleteTodo(@PathVariable ("id") long id, Model model) {
		
		Todo todo = this.todoRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid todo id : " + id));
		
		this.todoRepository.delete(todo);
		model.addAttribute("todo", this.todoRepository.findAll());
		return "listeTodo";
		
	}
}
