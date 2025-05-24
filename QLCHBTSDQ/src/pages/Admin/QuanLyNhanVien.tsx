import React, { useEffect, useState } from "react";
import axios from "axios";

interface Nhanvien {
    manhanvien: number;
    hoten: string;
    sodienthoai: string;
    diachi: string;
    mataikhoan: number;
}

const QuanLyNhanVien = () => {
    const [list, setList] = useState<Nhanvien[]>([]);
    const [form, setForm] = useState<Partial<Nhanvien>>({
        hoten: "",
        sodienthoai: "",
        diachi: "",
        mataikhoan: undefined
    });
    const [isEdit, setIsEdit] = useState(false);

    const fetchData = () => {
        axios.get("http://localhost:8080/nhanvien/all").then((res) => setList(res.data));
    };

    useEffect(() => {
        fetchData();
    }, []);

    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        setForm({ ...form, [e.target.name]: e.target.value });
    };

    const handleSubmit = () => {
        if (!form.hoten || !form.sodienthoai || !form.diachi || !form.mataikhoan) {
            alert("Vui lòng nhập đầy đủ thông tin.");
            return;
        }


        const phoneRegex = /^0\d{9}$/;
        if (!phoneRegex.test(form.sodienthoai)) {
            alert("Số điện thoại không hợp lệ!");
            return;
        }

        if (isEdit && form.manhanvien) {
            axios.put(`http://localhost:8080/nhanvien/update/${form.manhanvien}`, form).then(() => {
                fetchData();
                setForm({});
                setIsEdit(false);
            });
        } else {
            axios.post("http://localhost:8080/nhanvien/add", form).then(() => {
                fetchData();
                setForm({});
            });
        }
    };
    const handleEdit = (nv: Nhanvien) => {
        setForm(nv);
        setIsEdit(true);
    };

    const handleDelete = (id: number) => {
        const confirm = window.confirm("Bạn có chắc chắn muốn xóa nhân viên này không?");
        if (!confirm) return;

        axios.delete(`http://localhost:8080/nhanvien/delete/${id}`)
            .then(() => fetchData())
            .catch((err) => console.error("Lỗi khi xóa:", err));
    };
    return (
        <div className="p-4">
            <h2 className="text-xl font-bold mb-4">Quản lý nhân viên</h2>


            <div className="mb-6 grid grid-cols-2 gap-4">
                <input name="hoten" placeholder="Họ tên" value={form.hoten || ""} onChange={handleChange} className="border p-2" />
                <input name="sodienthoai" placeholder="SĐT" value={form.sodienthoai || ""} onChange={handleChange} className="border p-2" />
                <input name="diachi" placeholder="Địa chỉ" value={form.diachi || ""} onChange={handleChange} className="border p-2" />
                <input name="mataikhoan" type="number" placeholder="Mã tài khoản" value={form.mataikhoan || ""} onChange={handleChange} className="border p-2" />
                <button onClick={handleSubmit} className="col-span-2 bg-blue-500 text-white p-2 rounded">
                    {isEdit ? "Cập nhật" : "Thêm"}
                </button>
            </div>


            <table className="w-full border">
                <thead>
                    <tr className="bg-gray-200">
                        <th className="border p-2">STT</th>
                        <th className="border p-2">Họ tên</th>
                        <th className="border p-2">SĐT</th>
                        <th className="border p-2">Địa chỉ</th>
                        <th className="border p-2">Mã TK</th>
                        <th className="border p-2">Hành động</th>
                    </tr>
                </thead>
                <tbody>
                    {list.map((nv, index) => (
                        <tr key={nv.manhanvien} className="text-center hover:bg-gray-50">
                            <td className="border p-2">{index + 1}</td>
                            <td className="border p-2">{nv.hoten}</td>
                            <td className="border p-2">{nv.sodienthoai}</td>
                            <td className="border p-2">{nv.diachi}</td>
                            <td className="border p-2">{nv.mataikhoan}</td>
                            <td className="border p-2 space-x-2">
                                <button onClick={() => handleEdit(nv)} className="text-blue-500">Sửa</button>
                                <button onClick={() => handleDelete(nv.manhanvien)} className="text-red-500">Xóa</button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default QuanLyNhanVien;