package quanlysinhvien.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import quanlysinhvien.model.Khoa;

@Repository
public interface KhoaRepository extends JpaRepository<Khoa, Integer> {

}
