package sk.upjs.registracia_itat_rest;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sk.upjs.registracia_itat.entity.Participant;
import sk.upjs.registracia_itat.persitent.DaoFactory;
import sk.upjs.registracia_itat.persitent.ParticipantDao;

@RestController
public class ParticipantRestController {

	private ParticipantDao participantDao = DaoFactory.INSTANCE.getParticipantDao(); 
	
	@RequestMapping("/participants")
	public List<Participant> getAll() {
		return participantDao.getAll();
	}
	
	@RequestMapping(value="/participants", method = RequestMethod.POST)
	public Participant addParticipant(@RequestBody Participant participant) {
		participantDao.add(participant);
		return participant;
	}
}
