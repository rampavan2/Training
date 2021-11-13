package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.ModelAndView;
import java.util.*;
import com.example.demo.dao.AlienRepo;
import com.example.demo.model.Alien;

@RestController
public class AlienController {
	@Autowired
	AlienRepo repo;
	
//	@RequestMapping("/")
//	public String home()
//	{
//		return "home.jsp";
//	}
	@PostMapping("/alien")
	public Alien addAlien( Alien alien)
	{
		repo.save(alien);
		return alien;
	}
	
//	@RequestMapping("/getAlien")
//	public ModelAndView getAlien(@RequestParam int aid)
//	{
//		ModelAndView mv=new ModelAndView("showAlien.jsp");
//	    Alien aa=repo.findById(aid).orElse(new Alien());
//		mv.addObject(aa);
//		return mv;
//	}
//	
//	
//	@RequestMapping("/delAlien")
//	public ModelAndView delAlien(@RequestParam int aid)
//	{
//		ModelAndView mv=new ModelAndView("showDelAlien.jsp");
//		Alien aa=repo.findById(aid).orElse(new Alien());
//		mv.addObject(aa);
//	    repo.deleteById(aid);
//	    mv.addObject(aa);
//	    return mv;
//	}
//	
//	@RequestMapping("/updateAlien")
//	public ModelAndView updateAlien(Alien alien)
//	{
//		ModelAndView mv=new ModelAndView("showUpdatedAlien.jsp");
//		//delete
//		int aid=alien.getAid();
//		repo.deleteById(aid);
//		//add new as update
//		repo.save(alien);
//		Alien aa=repo.findById(aid).orElse(new Alien());
//		mv.addObject(aa);
//		return mv;
//	}
//	
	@GetMapping(path="/aliens")
//	@ResponseBody
	public  List<Alien> getAliens()
	{
		return repo.findAll();
	}
	
	@RequestMapping(path="/aliens/{aid}",produces = "application/json")
//	@ResponseBody
	public  Optional<Alien> getAlien(@PathVariable("aid") int aid)
	{
		return repo.findById(aid);
	}
}
