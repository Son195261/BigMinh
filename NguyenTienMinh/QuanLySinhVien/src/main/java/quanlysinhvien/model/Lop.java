package quanlysinhvien.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "lop")
public class Lop {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "malop")
	private int malop;
	
	@Column(name = "tenlop",nullable = false)
	private String tenlop;
	
	@ManyToOne
	@JoinColumn(name = "makhoa")
	private Khoa lop_khoa;
	
	@ManyToOne
	@JoinColumn(name = "mahedaotao")
	private HeDaoTao lop_hedaotao;
	
	@ManyToOne
	@JoinColumn(name = "makhoahoc")
	private KhoaHoc lop_khoahoc;

	@OneToMany(mappedBy = "sinhvien_malop",fetch = FetchType.EAGER)
	private Set<SinhVien> sinhViens;
	
	public Set<SinhVien> getSinhViens() {
		return sinhViens;
	}

	public void setSinhViens(Set<SinhVien> sinhViens) {
		this.sinhViens = sinhViens;
	}

	public String getTenlop() {
		return tenlop;
	}

	public void setTenlop(String tenlop) {
		this.tenlop = tenlop;
	}

	public Khoa getLop_khoa() {
		return lop_khoa;
	}

	public void setLop_khoa(Khoa lop_khoa) {
		this.lop_khoa = lop_khoa;
	}

	public HeDaoTao getLop_hedaotao() {
		return lop_hedaotao;
	}

	public void setLop_hedaotao(HeDaoTao lop_hedaotao) {
		this.lop_hedaotao = lop_hedaotao;
	}

	public KhoaHoc getLop_khoahoc() {
		return lop_khoahoc;
	}

	public void setLop_khoahoc(KhoaHoc lop_khoahoc) {
		this.lop_khoahoc = lop_khoahoc;
	}

	public int getMalop() {
		return malop;
	}
	
}
