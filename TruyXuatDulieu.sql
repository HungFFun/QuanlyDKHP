
-- Hoc phàn đã đang kí


select dslhp.[MaLHP],[TenMonHoc], [TenGV], ([Thu]+N'  tiết'+[TietDay]) as tiethoc ,[MaPhongHoc],[NgayBatDau]
from [dbo].[DSLHP] as dslhp join [dbo].[LopHocPhan] as lhp on dslhp.MaLHP=lhp.MaLHP
						join [dbo].[MonHoc] as mh on lhp.MaMH=mh.MaMH
						join [dbo].[GiangVien_PDT] as gv on lhp.MaGV=gv.MaGV
						--join [dbo].[PhongHoc] as ph on lhp.MaPhongHoc=ph.MaPhongHoc
where [MaSV] like '13SV100003'

create function Hocphandadangky ( @maSV nvarchar )
returns table
as
	return (
				select dslhp.[MaLHP],[TenMonHoc], ([Thu]+N'  tiết'+[TietDay]) as tiethoc ,( [HoGV]+' '+[TenGV]) as Giangvien ,[MaSV]
				from [dbo].[DSLHP] as dslhp join [dbo].[LopHocPhan] as lhp on dslhp.MaLHP=lhp.MaLHP
						join [dbo].[MonHoc] as mh on lhp.MaMH=mh.MaMH
						join [dbo].[GiangVien_PDT] as gv on lhp.MaGV=gv.MaGV
				where [MaSV] like @maSV
			)
go

select *from Hocphandadangky('13SV100001')
insert into [dbo].[DSLHP] 
values (?,?)

delete from [dbo].[DSLHP] 
where [MaLHP] like '2019HP0014' and [MaSV] like '13SV100003'


-- Bảng điem

select [TenMonHoc],[MaLHP],[DiemTK],[DiemGK],[DiemTH],[DiemCK]
from [dbo].[BangDiem] as bd join [dbo].[LopHocPhan] as lhp on bd.MaMH= lhp.MaMH
								join [dbo].[MonHoc] as mh on lhp.MaMH = mh.MaMH
where [MaSV] like '13SV100001'


select lhp.[MaLHP],[DiemTK],[DiemGK],[DiemTH],[DiemCK]
from [dbo].[BangDiem] as bd join [dbo].[LopHocPhan] as lhp on bd.MaMH= lhp.MaMH
where [MaSV] like '13SV100001'

select *
from [dbo].[LopHocPhan]

select dslhp.[MaLHP],[TenMonHoc],[TenGV], ([Thu]+' tiet'+[TietDay]) as tiethoc ,[MaPhongHoc],[NgayBatDau],dslhp.MaSV,lhp.NamHoc,lhp.Hocki
from [dbo].[DSLHP] as dslhp join [dbo].[LopHocPhan] as lhp on dslhp.MaLHP=lhp.MaLHP 
join [dbo].[MonHoc] as mh on lhp.MaMH=mh.MaMH join [dbo].[GiangVien_PDT] as gv on lhp.MaGV=gv.MaGV 
where [MaSV] like '13SV100016'


select l.[MaLHP],[TenMonHoc],[TenGV],[SoTinChi],[SoluongSV],count([MaSV])as dadangki,[MaPhongHoc],[NgayBatDau],[NgayKetThuc],[TietDay],[Thu] 
from [dbo].[LopHocPhan] as l join [dbo].[MonHoc] as m on l.MaMH=m.MaMH join [dbo].[GiangVien_PDT] as gv on l.MaGV = gv.MaGV join [dbo].[DSLHP] as dslhp on l.MaLHP=dslhp.MaLHP 
where [Hocki] like 'HK1' and [NamHoc] like '2019-2020' group by l.[MaLHP],[TenMonHoc],[TenGV],[SoTinChi],[SoluongSV],[MaPhongHoc],[NgayBatDau],[NgayKetThuc],[TietDay],[Thu]


select sv.MaSV,TenSV,GioiTinh,NgaySinh,SDT,DiaChi,TrangThai
from [dbo].[Sinhvien] as sv join [dbo].[DSLHP] as dslhp on sv.[MaSV]=dslhp.[MaSV] join [dbo].[LopHocPhan] as lhp on dslhp.MaLHP=lhp.MaLHP
where dslhp.MaLHP like '2019HP0001'


select sv.[MaSV],[TenSV],sv.[MaLop],[NgaySinh],[GioiTinh],[TrangThai],[TenLop],[TenKhoa],[NamHoc],Hocki,mh.[MaMH],lhp.[MaLHP],[DiemTK],
[DiemGK],[DiemTH],[DiemCK],[TenMonHoc],[SoTinChi]
from [dbo].[Khoa] as k join [dbo].[Lop] as l on k.MaKhoa=l.MaKhoa
	join [dbo].[Sinhvien] as sv on l.MaLop=sv.MaLop
	join [dbo].[BangDiem] as bd on sv.MaSV=bd.MaSV join [dbo].[LopHocPhan] as lhp on bd.MaLHP=lhp.MaLHP
	join [dbo].[MonHoc] as mh on lhp.MaMH=mh.MaMH
where lhp.[MaLHP] like '2019HP0001'



select lhp.[MaLHP],[Hocki],[NamHoc],[NgayBatDau],[NgayKetThuc],[TietDay],[Thu],gv.[TenGV],sv.[MaSV],[TenSV],sv.[GioiTinh],sv.[NgaySinh],[TenLop],[TenMonHoc],[SoTinChi]
from [dbo].[GiangVien_PDT] as gv join [dbo].[LopHocPhan] as lhp on gv.[MaGV]=lhp.[MaGV]
join [dbo].[MonHoc] as mh on lhp.MaMH=mh.MaMH
join [dbo].[DSLHP] as dslhp on dslhp.MaLHP=lhp.MaLHP
join [dbo].[Sinhvien] as sv on sv.MaSV=dslhp.MaSV
join [dbo].[Lop] as l on l.[MaLop]=sv.[MaLop]
where lhp.MaLHP = '2019HP0001'

[MaMH]
select * from [dbo].[MonHoc] where [TenMonHoc] like N'%tin%'

select dslhp.[MaLHP],[TenMonHoc],[TenGV], ([Thu]+N'  tiết'+[TietDay]) as tiethoc ,[MaPhongHoc],[NgayBatDau] 
from [dbo].[DSLHP] as dslhp join [dbo].[LopHocPhan] as lhp on dslhp.MaLHP=lhp.MaLHP join [dbo].[MonHoc] as mh on lhp.MaMH=mh.MaMH 
join [dbo].[GiangVien_PDT] as gv on lhp.MaGV=gv.MaGV where [MaSV] like

select [MaMH],[TenMonHoc],[SoTinChi]
from [dbo].[MonHoc]
ORDER BY [MaMH]

select DISTINCT sv.[MaSV],[TenSV],[GioiTinh],[NgaySinh],[SDT],[DiaChi],sv.[MaLop],
	[TrangThai],[TenLop],[NienKhoa],[TenKhoa],lhp.[MaLHP],mh.[MaMH],[TenMonHoc],[SoTinChi]
from [dbo].[SinhVien] as sv join [dbo].[Lop] as l on sv.[MaLop]=l.[MaLop]
join [dbo].[Khoa] as k on l.[MaKhoa]=k.[MaKhoa]
join [dbo].[DSLHP] as dsl on dsl.[MaSV]=sv.[MaSV]
join [dbo].[LopHocPhan] as lhp on dsl.MaLHP=lhp.MaLHP
join [dbo].[MonHoc] as mh on lhp.MaMH=mh.MaMH
where sv.MaSV = '13SV100001'

select dslhp.[MaLHP],[TenMonHoc], [TenGV], [Thu],[TietDay],[MaPhongHoc]
from [dbo].[DSLHP] as dslhp join [dbo].[LopHocPhan] as lhp on dslhp.MaLHP=lhp.MaLHP
						join [dbo].[MonHoc] as mh on lhp.MaMH=mh.MaMH
						join [dbo].[GiangVien_PDT] as gv on lhp.MaGV=gv.MaGV
where [MaSV] like '13SV100001'


select DISTINCT TenMonHoc
from [dbo].[MonHoc]


select top 1 [MaLHP]
from [dbo].[LopHocPhan]
ORDER BY [MaLHP] desc

 select l.[MaLHP],[TenMonHoc],[TenGV],[SoTinChi],[SoluongSV],count([MaSV])as dadangki,[MaPhongHoc],[NgayBatDau],[NgayKetThuc],[TietDay],[Thu]
 from [dbo].[LopHocPhan] as l join [dbo].[MonHoc] as m on l.MaMH=m.MaMH 
  join [dbo].[GiangVien_PDT] as gv on l.MaGV = gv.MaGV join [dbo].[DSLHP] as dslhp on l.MaLHP=dslhp.MaLHP 
  where [Hocki] like 'HK1' and [NamHoc] like '2019-2020'
	and l.[MaLHP] not in (  select dslhp.[MaLHP]
   from [dbo].[DSLHP] as dslhp join [dbo].[LopHocPhan] as lhp on dslhp.MaLHP=lhp.MaLHP 
   join [dbo].[MonHoc] as mh on lhp.MaMH=mh.MaMH join [dbo].[GiangVien_PDT] as gv on lhp.MaGV=gv.MaGV 
   where [MaSV] like 'admin     'and [NamHoc] like '2019-2020' and [Hocki] like 'HK1')
  group by l.[MaLHP],[TenMonHoc],[TenGV],[SoTinChi],[SoluongSV],[MaPhongHoc],[NgayBatDau],[NgayKetThuc],[TietDay],[Thu]

  select dslhp.[MaLHP],[TenMonHoc],[TenGV], ([Thu]+N'  tiết'+[TietDay]) as tiethoc ,[MaPhongHoc],[NgayBatDau]
   from [dbo].[DSLHP] as dslhp join [dbo].[LopHocPhan] as lhp on dslhp.MaLHP=lhp.MaLHP 
   join [dbo].[MonHoc] as mh on lhp.MaMH=mh.MaMH join [dbo].[GiangVien_PDT] as gv on lhp.MaGV=gv.MaGV 
   where [MaSV] like 'admin     'and [NamHoc] like '2019-2020' and [Hocki] like 'HK1'

   select l.[MaLHP],[TenMonHoc],[TenGV],[SoTinChi],[SoluongSV],count([MaSV])as dadangki,[MaPhongHoc],[NgayBatDau],[NgayKetThuc],[TietDay],[Thu] 
   from [dbo].[LopHocPhan] as l join [dbo].[MonHoc] as m on l.MaMH=m.MaMH 
   join [dbo].[GiangVien_PDT] as gv on l.MaGV = gv.MaGV join [dbo].[DSLHP] as dslhp on l.MaLHP=dslhp.MaLHP 
   where [Hocki] like 'HK1' and [NamHoc] like '2019-2020' 
   group by l.[MaLHP],[TenMonHoc],[TenGV],[SoTinChi],[SoluongSV],[MaPhongHoc],[NgayBatDau],[NgayKetThuc],[TietDay],[Thu]

    select l.[MaLHP],[TenMonHoc],[TenGV],[SoTinChi],[SoluongSV],count([MaSV])as dadangki,[MaPhongHoc],[NgayBatDau],[NgayKetThuc],[TietDay],[Thu] 
	 from [dbo].[LopHocPhan] as l join [dbo].[MonHoc] as m on l.MaMH=m.MaMH   
	 join [dbo].[GiangVien_PDT] as gv on l.MaGV = gv.MaGV join [dbo].[DSLHP] as dslhp on l.MaLHP=dslhp.MaLHP  
	 where [Hocki] like 'HK1' and [NamHoc] like '2019-2020'	and l.[MaLHP] not in (  
		select dslhp.[MaLHP]   from [dbo].[DSLHP] as dslhp join [dbo].[LopHocPhan] as lhp on dslhp.MaLHP=lhp.MaLHP  
		 join [dbo].[MonHoc] as mh on lhp.MaMH=mh.MaMH join [dbo].[GiangVien_PDT] as gv on lhp.MaGV=gv.MaGV   
		  where [MaSV] like 'admin     'and [NamHoc] like '2019-2020'and [Hocki] like 'HK1' ) 
group by l.[MaLHP],[TenMonHoc],[TenGV],[SoTinChi],[SoluongSV],[MaPhongHoc],[NgayBatDau],[NgayKetThuc],[TietDay],[Thu]


select l.[MaLHP],[TenMonHoc],count([MaSV])as dadangki,[MaGV]
from  [dbo].[LopHocPhan] as l join [dbo].[MonHoc] as m on l.MaMH=m.MaMH   
join [dbo].[DSLHP] as dslhp on l.MaLHP=dslhp.MaLHP 