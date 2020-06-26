package quanlysinhvien.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "khoahoc")
public class KhoaHoc {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "makhoahoc")
	private int makhoahoc;
	
	@Column(name = "tenkhoahoc",nullable = false)
	private String tenkhoahoc;

	@OneToMany(mappedBy = "lop_khoahoc",fetch = FetchType.EAGER)
	private Set<Lop> lops;
	
	public Set<Lop> getLops() {
		return lops;
	}

	public void setLops(Set<Lop> lops) {
		this.lops = lops;
	}

	public String getTenkhoahoc() {
		return tenkhoahoc;
	}

	public void setTenkhoahoc(String tenkhoahoc) {
		this.tenkhoahoc = tenkhoahoc;
	}

	public int getMakhoahoc() {
		return makhoahoc;
	}
	
}
