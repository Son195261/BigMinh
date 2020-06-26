create database quanlysinhvien

create table khoa
(
	makhoa int primary key identity(1,1),
	tenkhoa nvarchar(50) not null,
	diachi nvarchar(50) not null,
	dienthoai varchar(11) not null
)

create table khoahoc
(
	makhoahoc int primary key identity(1,1),
	tenkhoahoc nvarchar(20) not null
)

create table monhoc
(
	mamonhoc int primary key identity(1,1),
	tenmonhoc nvarchar(20) not null,
	sotinchi int,
	hocky int 
)

create table hedaotao
(
	mahedaotao int primary key identity(1,1),
	tenhedaotao nvarchar(20) not null
)

create table lop
(
	malop int primary key identity(1,1),
	tenlop varchar(6) not null,
	makhoa int,
	constraint fk_makhoa foreign key(makhoa) references khoa(makhoa),
	mahedaotao int,
	constraint fk_mahedaotao foreign key(mahedaotao) references hedaotao(mahedaotao),
	makhoahoc int,
	constraint fk_makhoahoc foreign key(makhoahoc) references khoahoc(makhoahoc)
)

create table sinhvien
(
	masv int primary key identity(1,1),
	matkhau varchar(10) not null,
	tensv nvarchar(25) not null,
	sodienthoai varchar(10) not null,
	email varchar(25) not null,
	ngaysinh date not null,
	quequan nvarchar(30) not null,
	malop int,
	constraint fk_malop foreign key(malop) references lop(malop)
)

create table diem
(
	madiem int primary key identity(1,1),
	masv int,
	constraint fk_masv foreign key(masv) references sinhvien(masv),
	mamonhoc int,
	constraint fk_mamonhoc foreign key(mamonhoc) references monhoc(mamonhoc),
	hocky int,
	diemquatrinh float,
	diemthi float
)

--khoa
insert into khoa(tenkhoa,diachi,dienthoai) values(N'công nghệ thông tin',N'Tòa nhà A3,55 trần duy hưng','036666222')

--khoa hoc
insert into khoahoc(tenkhoahoc) values('2016-2020')

--mon hoc
insert into monhoc(tenmonhoc,sotinchi,hocky) values(N'Lập trình java',3,1)
insert into monhoc(tenmonhoc,sotinchi,hocky) values(N'Chủ nghĩa Marx-Lenin',3,1)
insert into monhoc(tenmonhoc,sotinchi,hocky) values(N'Giáo dục thể chất 1',2,1)
insert into monhoc(tenmonhoc,sotinchi,hocky) values(N'Lập trình C++',2,2)

--he dao tao
insert into hedaotao(tenhedaotao) values(N'Chính quy')
insert into hedaotao(tenhedaotao) values(N'Cao đẳng')

--lop
insert into lop(tenlop,makhoa,mahedaotao,makhoahoc) values('50PM1',1,1,1)

--sinh vien
insert into sinhvien(tensv,matkhau,sodienthoai,email,ngaysinh,quequan,malop) values(N'Nguyễn Văn A','123456','0123656333','nguyenvana@gmail.com',CAST(N'2000-01-3' AS Date),N'Hải Dương',1)




