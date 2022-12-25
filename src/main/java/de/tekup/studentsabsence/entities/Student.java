package de.tekup.studentsabsence.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = { "image", "group", "absences" })
public class Student implements Serializable {
	// TODO Complete Validations of fields
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sid;

	@NotBlank(message = "FirstName is required")
	private String firstName;

	@NotBlank(message = "LastName is required")
	private String lastName;

	@NotBlank(message = "Email is required")
	@Email(message = "Email be a valid")
	private String email;

	@NotBlank(message = "Phone is required")
	private String phone;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate dob;

	// TODO Complete Relations with other entities

	@ManyToOne
	private Group group;

	@OneToOne
	private Image image;

	@OneToMany(mappedBy = "student")
	private List<Absence> absences;

}
