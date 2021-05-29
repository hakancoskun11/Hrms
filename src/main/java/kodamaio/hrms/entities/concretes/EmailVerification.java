package kodamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="verification_codes")
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name="user_id", referencedColumnName = "id")
public class EmailVerification {
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="code")
	private String code;
	
	@Column(name="is_verified")
	private boolean isVerified;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="verification_date")
	private Date verificationDate = new Date();
	
	
}
