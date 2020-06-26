package quanlysinhvien.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "diem")
public class Diem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "madiem")
	private int madiem;
	
	@Column(name = "hocky")
	private int hocky;
	
	@Column(name = "diemquatrinh")
	private float diemquatrinh;
	
	@Column(name = "diemthi")
	private float diemthi;
	
	@ManyToOne
	@JoinColumn(name = "masv")
	private SinhVien diem_sinhvien;
	
	@ManyToOne
	@JoinColumn(name = "mamonhoc")
	private MonHoc diem_monhoc;

	public int getHocky() {
		return hocky;
	}

	public void setHocky(int hocky) {
		this.hocky = hocky;
	}

	public float getDiemquatrinh() {
		return diemquatrinh;
	}

	public void setDiemquatrinh(float diemquatrinh) {
		this.diemquatrinh = diemquatrinh;
	}

	public float getDiemthi() {
		return diemthi;
	}

	public void setDiemthi(float diemthi) {
		this.diemthi = diemthi;
	}

	public SinhVien getDiem_sinhvien() {
		return diem_sinhvien;
	}

	public void setDiem_sinhvien(SinhVien diem_sinhvien) {
		this.diem_sinhvien = diem_sinhvien;
	}

	public MonHoc getDiem_monhoc() {
		return diem_monhoc;
	}

	public void setDiem_monhoc(MonHoc diem_monhoc) {
		this.diem_monhoc = diem_monhoc;
	}

	public int getMadiem() {
		return madiem;
	}
	
}
