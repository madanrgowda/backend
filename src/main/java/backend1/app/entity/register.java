package backend1.app.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import lombok.Data;

@Entity
@Data
@Component
public class register {
	@Id
int id;
long phone_no;
String pass;
String user_id;
long referalcode;
}
