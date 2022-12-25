package de.tekup.studentsabsence.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupSubject implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private GroupSubjectKey id;

	@ManyToOne
	@MapsId("group_id")
	@JoinColumn(name = "group_id")
	private Group group;

	@ManyToOne
	@MapsId("subject_id")
	@JoinColumn(name = "subject_id")
	private Subject subject;

	private float hours;
}
