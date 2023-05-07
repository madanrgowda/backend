package backend1.app.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;


import lombok.Data;

@Entity
@Data
@Component
public class mobile {
	@Id
	int id;
String email;
String device_id;
int otp;

@OneToOne
register r1;
}
