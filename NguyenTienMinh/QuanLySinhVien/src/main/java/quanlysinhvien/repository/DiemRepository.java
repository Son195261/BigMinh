package quanlysinhvien.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import quanlysinhvien.model.Diem;

@Repository
public interface DiemRepository extends JpaRepository<Diem, Integer> {
	@Transactional
	@Modifying
	@Query(value = "insert into diem(masv,mamonhoc,hocky,diemquatrinh,diemthi) values(?1,?2,?3,?4,?5)",nativeQuery = true)
	void ThemMonDangKy(int masv,int mamonhoc,int hocky,float diemquatrinh,float diemthi);
	
	@Query(value = "select * from diem where masv = ?1",nativeQuery = true)
	List<Diem> TimKiemTheoMasv(int masv);
	
}
