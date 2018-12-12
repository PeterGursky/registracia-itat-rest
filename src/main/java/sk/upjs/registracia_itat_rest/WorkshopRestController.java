package sk.upjs.registracia_itat_rest;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sk.upjs.registracia_itat.entity.Workshop;
import sk.upjs.registracia_itat.persitent.DaoFactory;
import sk.upjs.registracia_itat.persitent.WorkshopDao;

@RestController
public class WorkshopRestController {

	WorkshopDao workshopDao = DaoFactory.INSTANCE.getWorkshopDao();
	
	@CrossOrigin
	@RequestMapping("/workshops")
	public List<Workshop> getAll() {
		return workshopDao.getAll();
	}
	
}
