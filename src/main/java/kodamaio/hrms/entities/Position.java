package kodamaio.hrms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "job_position_names")
public class Position {
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="job_name")
	private String job_name;
	
	public Position() {
		
	}
	
	

	
	
}
