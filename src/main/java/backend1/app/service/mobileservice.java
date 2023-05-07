package backend1.app.service;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import backend1.app.entity.mobile;
import backend1.app.entity.register;
import backend1.app.repository.mobilrrepository;
import backend1.app.repository.registerreponsitory;
import backend1.app.response.ResoponseStructure;
import backend1.app.response.mailverification;

@Service
public class mobileservice {
	@Autowired
	mobilrrepository custrepo;
	
	@Autowired
	registerreponsitory regirepo;
	
	@Autowired
	mailverification mailVerifaction1;
	
	@Autowired
	register rs;
@Autowired
mobile customer;

	public ResoponseStructure<mobile> save(mobile customer)
	{
		ResoponseStructure<mobile>  structure=new ResoponseStructure<>();
            Random random=new Random();
			int otp=random.nextInt(100000,999999);
			customer.setOtp(otp);
            mailVerifaction1.sendMail(customer);
            structure.setCode(HttpStatus.PROCESSING.value());
			structure.setMessgae("Varification Mail Sent ");
			structure.setData(custrepo.save(customer));
		

		return structure; 
	}
	public ResoponseStructure<mobile> verfiy(int otp) throws backend1.app.exception.myexception {
		ResoponseStructure<mobile> structure=new ResoponseStructure<>();
		
			if(customer.getOtp()!=otp) {
				structure.setCode(HttpStatus.CREATED.value());
				structure.setMessgae("otp verifyed successfully");
			}else {
				throw new backend1.app.exception.myexception("otp invalid");
			}
		
		return structure;
	}
	public ResoponseStructure<register> save(register rs)
	{
		ResoponseStructure<register>  structure=new ResoponseStructure<>();
            
            structure.setCode(HttpStatus.PROCESSING.value());
			structure.setMessgae("account register succsefulluy");
			structure.setData(regirepo.save(rs));
		return structure; 
	}
	
}