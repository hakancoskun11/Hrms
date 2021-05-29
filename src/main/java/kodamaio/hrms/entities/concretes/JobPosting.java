package kodamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="job_potings")
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
public class JobPosting {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="posting_id")
	private int postingId;
	
	@Column(name="job_definition")
	private String jobDefinition;
	
	@Column(name="min_salary")
	private double minSalary;
	
	@Column(name="max_salary")
	private double maxSalary;
	
	@Column(name="open_position_number")
	private int openPositionNumber;
	
	@Column(name="application_deadline")
	private LocalDate applicationDeadline;
	
	@Column(name="posting_date")
	private LocalDate postingDate;
	
	@Column(name="activiy_status")
	private boolean activityStatus;
	
	@ManyToOne()
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	@ManyToOne
	@JoinColumn(name="position_id")
	private JobTitle jobTitle;
	
	@ManyToOne
	@JoinColumn(name="city_id")
	private City city;
}
