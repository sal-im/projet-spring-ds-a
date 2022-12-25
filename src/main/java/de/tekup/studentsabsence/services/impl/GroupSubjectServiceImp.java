package de.tekup.studentsabsence.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import de.tekup.studentsabsence.entities.Group;
import de.tekup.studentsabsence.entities.GroupSubject;
import de.tekup.studentsabsence.entities.GroupSubjectKey;
import de.tekup.studentsabsence.entities.Subject;
import de.tekup.studentsabsence.repositories.GroupSubjectRepository;
import de.tekup.studentsabsence.services.GroupService;
import de.tekup.studentsabsence.services.GroupSubjectService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GroupSubjectServiceImp implements GroupSubjectService {
	private final GroupSubjectRepository groupSubjectRepository;
	private final GroupService groupService;

	@Override
	public void addSubjectToGroup(Group group, Subject subject, float hours) {
		groupSubjectRepository
				.save(new GroupSubject(new GroupSubjectKey(group.getId(), subject.getId()), group, subject, hours));
	}

	@Override
	public List<GroupSubject> getSubjectsByGroupId(Long id) {
		Group group = groupService.getGroupById(id);
		return new ArrayList<>(groupSubjectRepository.findAllByGroup(group));
	}

	@Override
	public void deleteSubjectFromGroup(Long gid, Long sid) {
		// TODO find a groupSubject by Group Id and Subject Id
		GroupSubject groupSubject = groupSubjectRepository.findByGroupIdAndSubjectId(gid, sid);

		groupSubjectRepository.delete(groupSubject);
	}

}
