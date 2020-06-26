package quanlysinhvien.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import quanlysinhvien.model.MonHoc;
import quanlysinhvien.model.SinhVien;
import quanlysinhvien.repository.DiemRepository;
import quanlysinhvien.repository.MocHocRepository;
import quanlysinhvien.repository.SinhVienRepository;

@Controller
public class ControllerClass {
	
	String dn = "";
	SinhVien sinhVien = null;
	List<Integer> mamondachon = new ArrayList<Integer>();
	List<MonHoc> danhsachmondachon = new ArrayList<MonHoc>();
	
	@Autowired
	SinhVienRepository sinhVienRepository;
	
	@Autowired
	MocHocRepository monHocRepository;
	
	@Autowired
	DiemRepository diemRepository;
	
	@RequestMapping("/formchinh")
	public String formchinh(Model model)
	{
		model.addAttribute("dn", dn);
		return "FormChinh";
	}
	
	@RequestMapping("/formchinh/xulydangnhap")
	public String XuLyDangNhap(@RequestParam String masv, @RequestParam String matkhau)
	{
		sinhVien = sinhVienRepository.TimSinhVien(Integer.parseInt(masv), matkhau);
		if(sinhVien!=null)
		{
			dn = "oke";
			return "redirect:/formchinh";
		}
		return "FormLoi";
	}

	@RequestMapping("/formchinh/formsualylich")
	public String formsualylich(Model model)
	{
		model.addAttribute("sinhvien", sinhVien);
		return "FormSuaLyLich";
	}
	
	@RequestMapping("/formchinh/formsualylich/xulysualylich")
	public String xulysualylich(@RequestParam String sodienthoai,@RequestParam String email,@RequestParam String mkcu,@RequestParam String mkmoi)
	{
		if(mkmoi.isEmpty())
		{
			return "FormLoi";
		}
		sinhVien.setMatkhau(mkmoi);
		sinhVienRepository.CapNhatThongTin(sodienthoai, email, mkmoi,sinhVien.getMasv());
		return "redirect:/formchinh/formsualylich";
	}
	
	@RequestMapping("/formchinh/formxemdiem")
	public String formxemdiem(Model modelSinhvien,Model modelMondangky)
	{
		modelSinhvien.addAttribute("sinhvien", sinhVien);
		modelMondangky.addAttribute("mondangky", diemRepository.TimKiemTheoMasv(sinhVien.getMasv()));
		return "FormXemDiem";
	}
	
	@RequestMapping("/formchinh/formdangkymonhoc")
	public String formdangkymonhoc(Model model,Model modelMonDaChon)
	{
		model.addAttribute("monhoc", monHocRepository.TimMonHoc(1));
		modelMonDaChon.addAttribute("mondachon", danhsachmondachon);
		return "FormDangKyMonHoc";
	}
	
	@RequestMapping("/formchinh/formdangkymonhoc/xulythemmonhoc/{mamonhoc}")
	public String xulythemmonhoc(@PathVariable int mamonhoc)
	{
		if(!mamondachon.contains(monHocRepository.TimMonHocTheoMa(mamonhoc).getMamonhoc()))
		{
			mamondachon.add(monHocRepository.TimMonHocTheoMa(mamonhoc).getMamonhoc());
			danhsachmondachon.add(monHocRepository.TimMonHocTheoMa(mamonhoc));	
		}
		return "redirect:/formchinh/formdangkymonhoc";
	}
	
	@RequestMapping("/formchinh/formdangkymonhoc/xoamondachon/{mamonhoc}")
	public String xoamonhoc(@PathVariable int mamonhoc)
	{
		if(mamondachon.contains(mamonhoc))
		{
			for (int i = 0; i < danhsachmondachon.size(); i++) {
				if(danhsachmondachon.get(i).getMamonhoc() == mamonhoc)
				{
					danhsachmondachon.remove(i);
				}
			}
		}
		return "redirect:/formchinh/formdangkymonhoc";
	}
	
	@RequestMapping("/formchinh/formdangkymonhoc/luumonhocdachon")
	public String luumonhocdachon()
	{
		for(int i = 0;i < danhsachmondachon.size();i++)
		{
			diemRepository.ThemMonDangKy(sinhVien.getMasv(), danhsachmondachon.get(i).getMamonhoc(), 1, 0, 0);
		}
		return "redirect:/formchinh/formdangkymonhoc";
	}
	
}
