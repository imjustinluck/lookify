package com.jda.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jda.lookify.models.SongModel;
import com.jda.lookify.repository.SongRepository;

@Service
public class SongService {

	private final SongRepository repository;

	public SongService(SongRepository repository) {
		this.repository = repository;
	}

//	CREATE
	public SongModel create(SongModel song) {
		return repository.save(song);
	}

//	UPDATE
	public SongModel update(SongModel song) {
		return repository.save(song);
	}

//	GET ALL
	public List<SongModel> getAll() {
		return repository.findAll();
	}

//	GET TOP 10
	public List<SongModel> getTopTen() {
		return repository.findTop10ByOrderByRatingDesc();
	}
	
//	GET BY ARTIST
	public List<SongModel> getByArtist(String search) {
		return repository.findByArtist(search);
	}
	
//	READ
	public SongModel get(Long id) {
		Optional<SongModel> optional = repository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

//	DELETE
	public void delete(Long id) {
		Optional<SongModel> optional = repository.findById(id);
		if (optional.isPresent()) {
			repository.deleteById(id);
		}
	}
}
