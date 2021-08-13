package com.jda.lookify.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jda.lookify.models.SongModel;

public interface SongRepository extends CrudRepository<SongModel, Long> {

	List<SongModel> findAll();
	
	List<SongModel> findTop10ByOrderByRatingDesc();
				// find, top 10 BY, order BY, rating desc
	
	List<SongModel> findByArtist(String search);
}
