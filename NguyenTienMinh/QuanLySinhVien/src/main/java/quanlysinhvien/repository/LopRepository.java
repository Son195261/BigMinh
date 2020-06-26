package quanlysinhvien.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import quanlysinhvien.model.Lop;

@Repository
public interface LopRepository extends JpaRepository<Lop, Integer> {

}
