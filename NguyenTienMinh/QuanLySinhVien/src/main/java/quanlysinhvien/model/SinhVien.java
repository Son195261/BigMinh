package quanlysinhvien.model;

import java.util.Date;
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
@Table(name = "sinhvien")
public class SinhVien {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "masv")
	private int masv;
	
	@Column(name = "matkhau")
	private String matkhau;
	
	public String getMatkhau() {
		return matkhau;
	}

	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}

	@Column(name = "sodienthoai",nullable = false)
	private String sodienthoai;
	
	@Column(name = "email",nullable = false)
	private String email;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setMasv(int masv) {
		this.masv = masv;
	}

	@Column(name = "tensv",nullable = false)
	private String tensv;
	
	@Column(name = "ngaysinh",nullable = false)
	private Date ngaysinh;
	
	@Column(name = "quequan",nullable = false)
	private String quequan;
	
	@ManyToOne
	@JoinColumn(name = "malop")
	private Lop sinhvien_malop;

	@OneToMany(mappedBy = "diem_sinhvien",fetch = FetchType.EAGER)
	private Set<Diem> diems;
	
	public Set<Diem> getDiems() {
		return diems;
	}

	public void setDiems(Set<Diem> diems) {
		this.diems = diems;
	}

	public int getMasv() {
		return masv;
	}

	public String getTensv() {
		return tensv;
	}

	public void setTensv(String tensv) {
		this.tensv = tensv;
	}

	public Date getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public String getQuequan() {
		return quequan;
	}

	public void setQuequan(String quequan) {
		this.quequan = quequan;
	}

	public Lop getSinhvien_malop() {
		return sinhvien_malop;
	}

	public String getSodienthoai() {
		return sodienthoai;
	}

	public void setSodienthoai(String sodienthoai) {
		this.sodienthoai = sodienthoai;
	}

	public void setSinhvien_malop(Lop sinhvien_malop) {
		this.sinhvien_malop = sinhvien_malop;
	}
	
}
