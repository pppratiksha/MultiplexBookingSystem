package com.example.demo.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.model.Show;
import com.example.demo.exceptions.MovieNotFoundException;
import com.example.demo.exceptions.ShowAlreadyExistException;
import com.example.demo.exceptions.ShowNotFoundException;
import com.example.demo.repository.MovieRepository;
import com.example.demo.repository.ShowRepository;


@Service
public class ShowService implements IShowService{
	
	@Autowired
	private ShowRepository showRepository;
	
	@Autowired
	private MovieRepository movieRepository;

	public ShowService() {
		
	}
	
	
	
	@Override
	public Show addShowDetails(Long movieid, Show show) throws ShowAlreadyExistException,MovieNotFoundException {
		
		List<Show> shows =showRepository.findAll();
		for(Show i : shows) {
			if(i.getSlotNo()==show.getSlotNo()) {
				throw new ShowAlreadyExistException("Show already exists...");
			}
		}
			return movieRepository.findById(movieid).map(movie ->{
			show.setMovie(movie);
			return showRepository.save(show);
		}).orElseThrow(() -> new MovieNotFoundException("Movie not found"));
	}

	
	
	@Override
	public Show updateShowDetails(Long movieid, Long showid,Show show) throws ShowNotFoundException,MovieNotFoundException {
		if(!movieRepository.existsById(movieid)) {
			throw new MovieNotFoundException("movie with id: "+movieid+" not found..!!");
		}
		return showRepository.findById(showid).map(updateshow -> {
				updateshow.setSlotNo(show.getSlotNo());
				updateshow.setFromDate(show.getFromDate());
				updateshow.setToDate(show.getToDate());
				return showRepository.save(updateshow);
		}).orElseThrow(() -> new ShowNotFoundException("Showid id not found"));

	}
	
	
	@Override
	public ResponseEntity<Show> viewShowDetails(Long showid) throws ShowNotFoundException {        
        Show show = showRepository.findById(showid)
				.orElseThrow(() -> new ShowNotFoundException("Show not found :: " +showid));
		return ResponseEntity.ok().body(show);
	}
	
	
	
	@Override
	public ResponseEntity<?> deleteShowDetails(Long movieid, Long showid) throws ShowNotFoundException,MovieNotFoundException {
		if(!movieRepository.existsById(movieid)) {
			throw new MovieNotFoundException("movie with id: "+movieid+" not found..!!");
		}
		return showRepository.findByShowidAndMovieId(showid, movieid)
				.map(show ->{
					showRepository.delete(show);
					return ResponseEntity.ok().build();
				}).orElseThrow(
					() -> new ShowNotFoundException
					("show not found with id " + showid + "and movie id"+movieid));
		}

	
	
	@Override
	public List<Show> getAllShows() {
		return showRepository.findAll();
	}
	

	
	@Override
	public List<Show> findByMovieId(Long movieid) throws MovieNotFoundException {
		if(!movieRepository.existsById(movieid)) {
			throw new MovieNotFoundException("movie with id: "+movieid+" not found..!!");
		}
		return showRepository.findByMovieId(movieid);
	}
	
	



	
	@Override
	public List<Show> findShowByMovieName(String movieName) throws MovieNotFoundException {
		if(movieRepository.findBymovieName(movieName) != null) {
			throw new MovieNotFoundException("movie with name: "+movieName+" not found..!!");
		}
		return showRepository.findByMovieMovieName(movieName);
	}
	

	
	@Override
	public List<Show> findSlotByslotNo(long slotNo) throws ShowNotFoundException {
		List<Show> lists = showRepository.findAll();
		for(Show i : lists) {
			if(i.getSlotNo()==slotNo) {
				return showRepository.findByslotNo(slotNo);
			}
		}
		
			throw new ShowNotFoundException("The show with Slot number: "+slotNo+" is not found");
	}

	
	
	@Override
	public List<Show> findByToDateContaining(String date) throws ShowNotFoundException{
		if(date.length()==0) {
			throw new ShowNotFoundException("The date entered by you is not in the correct format please try again..!!");
		}
		List<Show> list = showRepository.findByToDateContaining(date);
		if(list.isEmpty()) {
			throw new ShowNotFoundException("Sorry! No Show(s) available for this date. Please retry for another date.");
		}
		return list;
		
	}
	@Override
	public Optional<Show> findByMovieIdAndShowId(Long movieId, Long showId) {
		return null;
	}
}
