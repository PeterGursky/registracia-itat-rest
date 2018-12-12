package sk.upjs.registracia_itat_rest;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sk.upjs.registracia_itat.entity.Participant;
import sk.upjs.registracia_itat.persitent.DaoFactory;
import sk.upjs.registracia_itat.persitent.ParticipantDao;
import sk.upjs.registracia_itat.persitent.ParticipantNotFoundException;

@CrossOrigin
@RestController
public class ParticipantRestController {

	private ParticipantDao participantDao = DaoFactory.INSTANCE.getParticipantDao(); 
	
	@RequestMapping("/participants")
	public List<Participant> getAll() {
		return participantDao.getAll();
	}
	
	@RequestMapping(value="/participants", method = RequestMethod.POST)
	public Participant addParticipant(@RequestBody Participant participant) throws DaoException{
		try {
			participantDao.add(participant);
			return participant;
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}
	
	@RequestMapping(value="/participants", method = RequestMethod.PUT)
	public void saveParticipant(@RequestBody Participant participant) throws DaoException {
		try {
			participantDao.save(participant);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}
	
	@RequestMapping(value="/participants/{id}", method = RequestMethod.DELETE)
	public void deleteParticipant(@PathVariable long id) throws ParticipantNotFoundException {
		participantDao.delete(id);
	}
}
