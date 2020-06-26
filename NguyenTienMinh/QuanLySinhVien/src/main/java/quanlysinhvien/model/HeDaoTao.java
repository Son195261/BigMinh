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
@Table(name = "hedaotao")
public class HeDaoTao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mahedaotao",nullable = false)
	private int mahedaotao;
	
	@Column(name = "tenhedaotao",nullable = false)
	private String tenhedaotao;

	@OneToMany(mappedBy = "lop_hedaotao",fetch = FetchType.EAGER)
	private Set<Lop> lops;
	
	public Set<Lop> getLops() {
		return lops;
	}

	public void setLops(Set<Lop> lops) {
		this.lops = lops;
	}

	public int getMahedaotao() {
		return mahedaotao;
	}

	public String getTenhedaotao() {
		return tenhedaotao;
	}

	public void setTenhedaotao(String tenhedaotao) {
		this.tenhedaotao = tenhedaotao;
	}
	
}
