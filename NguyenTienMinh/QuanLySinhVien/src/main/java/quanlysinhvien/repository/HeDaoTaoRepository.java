package quanlysinhvien.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import quanlysinhvien.model.HeDaoTao;

@Repository
public interface HeDaoTaoRepository extends JpaRepository<HeDaoTao, Integer> {

}
