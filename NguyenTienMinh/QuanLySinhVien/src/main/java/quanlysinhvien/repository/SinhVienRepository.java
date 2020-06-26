package quanlysinhvien.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import quanlysinhvien.model.SinhVien;

@Repository
public interface SinhVienRepository extends JpaRepository<SinhVien, Integer> {

	@Query(value = "select * from sinhvien where masv = ?1 and matkhau = ?2",nativeQuery = true)
	SinhVien TimSinhVien(int masv,String matkhau);
	
	@Transactional
	@Modifying
	@Query(value = "update sinhvien set sodienthoai = ?1,email = ?2,matkhau = ?3 where masv = ?4",nativeQuery = true)
	void CapNhatThongTin(String sodienthoai,String email,String matkhau,int masv);
	
}
