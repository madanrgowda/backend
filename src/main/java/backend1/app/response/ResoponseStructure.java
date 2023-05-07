package backend1.app.response;

import lombok.Data;

@Data
public class ResoponseStructure<T> {
	int code;
	String messgae;
	T data;

}
