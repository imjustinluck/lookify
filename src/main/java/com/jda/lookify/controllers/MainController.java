package com.jda.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jda.lookify.models.SongModel;
import com.jda.lookify.services.SongService;

@Controller
public class MainController {

	private final SongService service;
	
	public MainController(SongService service) {
		this.service = service;
	}
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
		List<SongModel> songs = service.getAll();
		model.addAttribute("songs", songs);
		return "dashboard.jsp";
	}
	
	@RequestMapping("/songs/new")
	public String form(@ModelAttribute("song") SongModel song) {
		return "create.jsp";
	}
	
	@RequestMapping(value="songs", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("song") SongModel song, BindingResult result) {
		if(result.hasErrors()) {
			return "create.jsp";
		}
		else {
			service.create(song);
			return "redirect:/dashboard";
		}
	}
	
	@RequestMapping("/songs/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		SongModel song = service.get(id);
		model.addAttribute("song", song);
		return "show.jsp";
	}
	
	@RequestMapping("/search/top10")
	public String top10(Model model) {
		List<SongModel> songs = service.getTopTen();
		model.addAttribute("songs", songs);
		return "top.jsp";
	}
	
	@RequestMapping(value="/search/{artist}")
	public String search(@PathVariable("artist") String artist, Model model) {
		List<SongModel> songs = service.getByArtist(artist);
		model.addAttribute("artist", artist);
		model.addAttribute("songs", songs);
		return "artist.jsp";
	}
	
	@RequestMapping(value="/songs/{id}", method=RequestMethod.DELETE)
	public String delete(@PathVariable("id") Long id) {
		service.delete(id);
		return "redirect:/dashboard";
	}
}
