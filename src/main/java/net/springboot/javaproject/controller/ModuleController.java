package net.springboot.javaproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.springboot.javaproject.entity.Module;
import net.springboot.javaproject.repository.ModuleRepository;

@Controller
@RequestMapping("/modules/")
public class ModuleController {

	public @interface Valid {
	
	}

	@Autowired
	private ModuleRepository moduleRepository;	
	
	@GetMapping("showForm")
	public String showModuleForm(Module module) {
		return "add-module";
	}
	
	@GetMapping("list")
	public String modules(Model model) {
		model.addAttribute("modules", this.moduleRepository.findAll());
		return "listModule";
	}
	
	@PostMapping("add")
	public String addmodule(@Valid Module module, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "add-module";
		}
		
		this.moduleRepository.save(module);
		return "redirect:list";
	}
	
	
	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable ("id") long id, Model model) {
		Module module = this.moduleRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid module id : " + id));
		
		model.addAttribute("module", module);
		return "update-module";
	}
	
	@PostMapping("update/{id}")
	public String updateModule(@PathVariable("id") long id, @Valid Module module, BindingResult result, Model model) {
		if(result.hasErrors()) {
			module.setId(id);
			return "update-module";
		}
		
		// update module
		moduleRepository.save(module);
		
		// get all modules ( with update)
		model.addAttribute("modules", this.moduleRepository.findAll());
		return "listModule";
	}
	
	@GetMapping("delete/{id}")
	public String deletemodule(@PathVariable ("id") long id, Model model) {
		
		Module module = this.moduleRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid module id : " + id));
		
		this.moduleRepository.delete(module);
		model.addAttribute("modules", this.moduleRepository.findAll());
		return "listModule";
		
	}
}
