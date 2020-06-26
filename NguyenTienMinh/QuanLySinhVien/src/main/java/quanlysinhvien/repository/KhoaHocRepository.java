package quanlysinhvien.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import quanlysinhvien.model.KhoaHoc;

@Repository
public interface KhoaHocRepository extends JpaRepository<KhoaHoc, Integer> {

}
