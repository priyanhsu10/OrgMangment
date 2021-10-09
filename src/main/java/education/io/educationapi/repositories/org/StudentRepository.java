package education.io.educationapi.repositories.org;

import education.io.educationapi.entities.org.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
  @Query("Select s from Student s where s.organization.id=:orgId")
    List<Student> getByOrganizationId(int orgId);
  @Query("Select s from Student s where s.standardsClass.id=:classId")
  List<Student> getByClassId(int classId);
  @Query("Select s from Student s where s.standard.id=:standardId")
  List<Student> getByStandardId(int standardId);
  @Query(value = "Select count(id) from tblstudents s where organizationid=:orgId",nativeQuery = true)
  Integer getCountByOrganizationId(int orgId);
  @Query(value = "Select count(s.id) from tblstudents s where organizationid=:classId",nativeQuery = true)
  Integer getCountByClassId(int classId);
  @Query(value = "Select count(s.id) from tblstudents s where currentstandardid=:standardId",nativeQuery = true)
  Integer getCountByStandardId(int standardId);
}
