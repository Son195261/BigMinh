package quanlysinhvien.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import quanlysinhvien.model.MonHoc;

@Repository
public interface MocHocRepository extends JpaRepository<MonHoc, Integer> {

	@Query(value = "select * from monhoc where hocky = ?1",nativeQuery = true)
	List<MonHoc> TimMonHoc(int hocky);
	
	@Query(value = "select * from monhoc where mamonhoc = ?1",nativeQuery = true)
	MonHoc TimMonHocTheoMa(int mamonhoc);
	
}
