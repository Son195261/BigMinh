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
@Table(name = "monhoc")
public class MonHoc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mamonhoc")
	private int mamonhoc;
	
	@Column(name = "tenmonhoc",nullable = false)
	private String tenmonhoc;
	
	@Column(name = "sotinchi")
	private int sotinchi;

	@Column(name = "hocky")
	private int hocky;
	
	public int getHocky() {
		return hocky;
	}

	public void setHocky(int hocky) {
		this.hocky = hocky;
	}

	@OneToMany(mappedBy = "diem_monhoc",fetch = FetchType.EAGER)
	private Set<Diem> diems;
	
	public Set<Diem> getDiems() {
		return diems;
	}

	public void setDiems(Set<Diem> diems) {
		this.diems = diems;
	}

	public String getTenmonhoc() {
		return tenmonhoc;
	}

	public void setTenmonhoc(String tenmonhoc) {
		this.tenmonhoc = tenmonhoc;
	}

	public int getSotinchi() {
		return sotinchi;
	}

	public void setSotinchi(int sotinchi) {
		this.sotinchi = sotinchi;
	}

	public int getMamonhoc() {
		return mamonhoc;
	}
	
}
