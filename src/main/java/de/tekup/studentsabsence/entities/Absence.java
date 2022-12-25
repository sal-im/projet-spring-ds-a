package de.tekup.studentsabsence.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Absence implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull(message = "Start date is required")
	@Past(message = "Should be a date in the past")
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
	private LocalDateTime startDate;
	@NotNull(message = "Hours is required")
	@Positive(message = "Should be positive")
	private float hours;
	// TODO Complete Relations with other entities

	@ManyToOne
	private Student student;

	@OneToOne
	private Subject subject;

}
