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
@Table(name = "khoa")
public class Khoa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "makhoa")
	private int makhoa;
	
	@Column(name = "tenkhoa",nullable = false)
	private String tenkhoa;
	
	@Column(name = "diachi",nullable = false)
	private String diachi;
	
	@Column(name = "dienthoai",nullable = false)
	private String dienthoai;
	
	@OneToMany(mappedBy = "lop_khoa",fetch = FetchType.EAGER)
	private Set<Lop> lops;
	
	public Set<Lop> getLops() {
		return lops;
	}

	public void setLops(Set<Lop> lops) {
		this.lops = lops;
	}

	public void setTenkhoa(String tenkhoa) {
		this.tenkhoa = tenkhoa;
	}

	public int getMakhoa() {
		return makhoa;
	}

	public void setMakhoa(int makhoa) {
		this.makhoa = makhoa;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getDienthoai() {
		return dienthoai;
	}

	public void setDienthoai(String dienthoai) {
		this.dienthoai = dienthoai;
	}

	public String getTenkhoa() {
		return tenkhoa;
	}
	
}
