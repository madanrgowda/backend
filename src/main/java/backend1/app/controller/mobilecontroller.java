package backend1.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import backend1.app.entity.mobile;
import backend1.app.entity.register;
import backend1.app.response.ResoponseStructure;
import backend1.app.service.mobileservice;

@RestController
@RequestMapping("user")
public class mobilecontroller {
	
	
@Autowired
mobileservice custser;

	@PostMapping("add")
	public ResoponseStructure<mobile> save(@RequestBody mobile ms)
	{
		return custser.save(ms);
	}
	
	@PostMapping("otp/{otp}")
	public ResoponseStructure<mobile> verfiy(@PathVariable int otp) throws backend1.app.exception.myexception{
		return custser.verfiy(otp);
	}
	
	@PostMapping("referal")
	public ResoponseStructure<register> save(@RequestBody register mr)
	{
		return custser.save(mr);
	}
}