import React, { useEffect, useState } from 'react';
import axios from 'axios';

interface TaiKhoan {
    mataikhoan: number;
    tendangnhap: string;
    matkhau: string;
    vaitro: string;
}

const QuanLyTaiKhoan = () => {
    const [danhSach, setDanhSach] = useState<TaiKhoan[]>([]);
    const [form, setForm] = useState<Partial<TaiKhoan>>({});
    const [isEditing, setIsEditing] = useState(false);

    const fetchTaiKhoan = async () => {
        const res = await axios.get('http://localhost:8080/taikhoan/all');
        setDanhSach(res.data);
    };

    const handleChange = (e: React.ChangeEvent<HTMLInputElement | HTMLSelectElement>) => {
        setForm({ ...form, [e.target.name]: e.target.value });
    };

    const handleSubmit = async () => {
        if (!form.tendangnhap || !form.matkhau || !form.vaitro) return;

        if (isEditing && form.mataikhoan !== undefined) {
            await axios.put(`http://localhost:8080/taikhoan/update/${form.mataikhoan}`, form);
        } else {
            await axios.post('http://localhost:8080/taikhoan/add', form);
        }
        setForm({});
        setIsEditing(false);
        fetchTaiKhoan();
    };

    const handleEdit = (tk: TaiKhoan) => {
        setForm(tk);
        setIsEditing(true);
    };

    const handleDelete = async (id: number) => {
        const confirmDelete = window.confirm("Bạn có chắc chắn muốn xóa không?");
        if (!confirmDelete) return;

        try {
            await axios.delete(`http://localhost:8080/taikhoan/delete/${id}`);
            fetchTaiKhoan();
        } catch (err) {
            console.error("Lỗi xóa:", err);
        }
    };

    useEffect(() => {
        fetchTaiKhoan();
    }, []);

    return (
        <div className="p-6">
            <h2 className="text-xl font-bold mb-4">Quản lý tài khoản</h2>

            <div className="grid grid-cols-3 gap-4 mb-6">
                <input name="tendangnhap" value={form.tendangnhap || ''} onChange={handleChange}
                    placeholder="Tên đăng nhập" className="border p-2 rounded" />
                <input name="matkhau" value={form.matkhau || ''} onChange={handleChange}
                    placeholder="Mật khẩu" className="border p-2 rounded" />
                <select name="vaitro" value={form.vaitro || ''} onChange={handleChange} className="border p-2 rounded">
                    <option value="">Chọn vai trò</option>
                    <option value="admin">Admin</option>
                    <option value="nhanvien">Nhân viên</option>
                    <option value="khachhang">Khách hàng</option>
                </select>
            </div>

            <button onClick={handleSubmit} className="bg-blue-500 text-white px-4 py-2 rounded mb-6">
                {isEditing ? 'Cập nhật' : 'Thêm mới'}
            </button>

            <table className="w-full border text-left">
                <thead>
                    <tr className="bg-gray-100">
                        <th className="p-2 border">STT</th>
                        <th className="p-2 border">Tên đăng nhập</th>
                        <th className="p-2 border">Mật khẩu</th>
                        <th className="p-2 border">Vai trò</th>
                        <th className="p-2 border">Hành động</th>
                    </tr>
                </thead>
                <tbody>
                    {danhSach.map((tk, index) => (
                        <tr key={tk.mataikhoan} className="hover:bg-gray-50">
                            <td className="p-2 border">{index + 1}</td>
                            <td className="p-2 border">{tk.tendangnhap}</td>
                            <td className="p-2 border">{tk.matkhau}</td>
                            <td className="p-2 border">{tk.vaitro}</td>
                            <td className="p-2 border space-x-2">
                                <button onClick={() => handleEdit(tk)} className="text-blue-500">Sửa</button>
                                <button onClick={() => handleDelete(tk.mataikhoan)} className="text-red-500">Xóa</button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>

        </div>
    );
};

export default QuanLyTaiKhoan;