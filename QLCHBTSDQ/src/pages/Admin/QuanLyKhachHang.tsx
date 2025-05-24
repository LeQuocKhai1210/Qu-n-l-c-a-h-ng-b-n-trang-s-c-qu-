import React, { useEffect, useState } from "react";
import axios from "axios";

interface KhachHang {
    makhachhang: number;
    hoten: string;
    sodienthoai: string;
    diachi: string;
    mataikhoan: number;
}

const QuanLyKhachHang = () => {
    const [danhSach, setDanhSach] = useState<KhachHang[]>([]);
    const [form, setForm] = useState<Partial<KhachHang>>({});
    const [isEdit, setIsEdit] = useState(false);

    // Lấy danh sách khách hàng
    const fetchKhachHang = async () => {
        try {
            const res = await axios.get("http://localhost:8080/khachhang/all");
            setDanhSach(res.data);
        } catch (error) {
            console.error("Lỗi khi tải danh sách:", error);
        }
    };

    useEffect(() => {
        fetchKhachHang();
    }, []);

    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        setForm({ ...form, [e.target.name]: e.target.value });
    };

    const handleSubmit = async () => {
        if (!form.hoten || !form.sodienthoai || !form.diachi || !form.mataikhoan) {
            alert("Vui lòng điền đầy đủ thông tin.");
            return;
        }


        const phoneRegex = /^0\d{9}$/;
        if (!phoneRegex.test(form.sodienthoai)) {
            alert("Số điện thoại không hợp lệ!");
            return;
        }

        try {
            if (isEdit && form.makhachhang !== undefined) {
                await axios.put(`http://localhost:8080/khachhang/update/${form.makhachhang}`, form);
            } else {
                await axios.post("http://localhost:8080/khachhang/add", form);
            }
            setForm({});
            setIsEdit(false);
            fetchKhachHang();
        } catch (error) {
            console.error("Lỗi khi lưu:", error);
        }
    };

    const handleEdit = (kh: KhachHang) => {
        setForm(kh);
        setIsEdit(true);
    };

    const handleDelete = async (id: number) => {
        const confirmDelete = window.confirm("Bạn có chắc chắn muốn xóa khách hàng này?");
        if (!confirmDelete) return;

        try {
            await axios.delete(`http://localhost:8080/khachhang/delete/${id}`);
            fetchKhachHang();
        } catch (error) {
            console.error("Lỗi khi xóa:", error);
        }
    };

    return (
        <div className="p-6">
            <h2 className="text-xl font-bold mb-4">Quản lý khách hàng</h2>


            <div className="grid grid-cols-2 gap-4 mb-4">
                <input name="hoten" placeholder="Tên khách hàng" value={form.hoten || ""} onChange={handleChange} className="border p-2 rounded" />
                <input name="sodienthoai" placeholder="Số điện thoại" value={form.sodienthoai || ""} onChange={handleChange} className="border p-2 rounded" />
                <input name="diachi" placeholder="Địa chỉ" value={form.diachi || ""} onChange={handleChange} className="border p-2 rounded" />
                <input name="mataikhoan" type="number" placeholder="Mã tài khoản" value={form.mataikhoan || ""} onChange={handleChange} className="border p-2 rounded" />
                <button onClick={handleSubmit} className="col-span-2 bg-blue-600 text-white py-2 rounded hover:bg-blue-700">
                    {isEdit ? "Cập nhật" : "Thêm mới"}
                </button>
            </div>

            <table className="w-full border">
                <thead>
                    <tr className="bg-gray-100">
                        <th className="p-2 border">STT</th>
                        <th className="p-2 border">Tên khách hàng</th>
                        <th className="p-2 border">SĐT</th>
                        <th className="p-2 border">Địa chỉ</th>
                        <th className="p-2 border">Mã TK</th>
                        <th className="p-2 border">Hành động</th>
                    </tr>
                </thead>
                <tbody>
                    {danhSach.map((kh, index) => (
                        <tr key={kh.makhachhang} className="hover:bg-gray-50 text-center">
                            <td className="p-2 border">{index + 1}</td>
                            <td className="p-2 border">{kh.hoten}</td>
                            <td className="p-2 border">{kh.sodienthoai}</td>
                            <td className="p-2 border">{kh.diachi}</td>
                            <td className="p-2 border">{kh.mataikhoan}</td>
                            <td className="p-2 border space-x-2">
                                <button onClick={() => handleEdit(kh)} className="text-blue-500">Sửa</button>
                                <button onClick={() => handleDelete(kh.makhachhang)} className="text-red-500">Xóa</button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default QuanLyKhachHang;