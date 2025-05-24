import React, { useEffect, useState } from "react";
import axios from "axios";

interface SanPham {
    masanpham: number;
    tensanpham: string;
    maloai: number;
    mota: string;
    chatlieu: string;
    daquy: string;
    gia: number;
    soluongton: number;
    hinhanh: string;
}

const QuanLySanPham = () => {
    const [list, setList] = useState<SanPham[]>([]);
    const [form, setForm] = useState<Partial<SanPham>>({});
    const [isEdit, setIsEdit] = useState(false);

    const fetchData = async () => {
        try {
            const res = await axios.get("http://localhost:8080/sanpham/all");
            setList(res.data);
        } catch (error) {
            console.error("Lỗi tải danh sách sản phẩm:", error);
        }
    };

    useEffect(() => {
        fetchData();
    }, []);

    const handleChange = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>) => {
        let value: string | number = e.target.value;
        if (e.target.type === "number") {
            value = value === "" ? "" : Number(value);
        }
        setForm({ ...form, [e.target.name]: value });
    };

    const handleSubmit = async () => {
        if (!form.tensanpham || !form.maloai || form.gia === undefined || form.gia <= 0 || form.soluongton === undefined || form.soluongton < 0) {
            alert("Vui lòng nhập đầy đủ thông tin hợp lệ.");
            return;
        }

        try {
            if (isEdit && form.masanpham) {
                await axios.put(`http://localhost:8080/sanpham/update/${form.masanpham}`, form);
            } else {
                await axios.post("http://localhost:8080/sanpham/add", form);
            }
            fetchData();
            setForm({});
            setIsEdit(false);
        } catch (error) {
            console.error("Lỗi lưu sản phẩm:", error);
        }
    };

    const handleEdit = (sp: SanPham) => {
        setForm(sp);
        setIsEdit(true);
    };

    const handleDelete = async (id: number) => {
        const confirm = window.confirm("Bạn có chắc chắn muốn xóa sản phẩm này?");
        if (!confirm) return;

        try {
            await axios.delete(`http://localhost:8080/sanpham/delete/${id}`);
            fetchData();
        } catch (error) {
            console.error("Lỗi xóa:", error);
        }
    };

    return (
        <div className="p-6">
            <h2 className="text-xl font-bold mb-4">Quản lý sản phẩm</h2>


            <div className="grid grid-cols-2 gap-4 mb-4">
                <input name="tensanpham" placeholder="Tên sản phẩm" value={form.tensanpham || ''} onChange={handleChange} className="border p-2" />
                <input name="maloai" placeholder="Mã loại" type="number" value={form.maloai || ''} onChange={handleChange} className="border p-2" />
                <textarea name="mota" placeholder="Mô tả" value={form.mota || ''} onChange={handleChange} className="border p-2 col-span-2" />
                <input name="chatlieu" placeholder="Chất liệu" value={form.chatlieu || ''} onChange={handleChange} className="border p-2" />
                <input name="daquy" placeholder="Đá quý" value={form.daquy || ''} onChange={handleChange} className="border p-2" />
                <input name="gia" placeholder="Giá" type="number" value={form.gia || ''} onChange={handleChange} className="border p-2" />
                <input name="soluongton" placeholder="Số lượng tồn" type="number" value={form.soluongton || ''} onChange={handleChange} className="border p-2" />
                <input name="hinhanh" placeholder="Link hình ảnh" value={form.hinhanh || ''} onChange={handleChange} className="border p-2" />
                <button onClick={handleSubmit} className="col-span-2 bg-blue-600 text-white p-2 rounded">
                    {isEdit ? "Cập nhật" : "Thêm sản phẩm"}
                </button>
            </div>


            <table className="w-full border text-sm">
                <thead className="bg-gray-100">
                    <tr>
                        <th className="border p-2">STT</th>
                        <th className="border p-2">Tên SP</th>
                        <th className="border p-2">Mã loại</th>
                        <th className="border p-2">Mô tả</th>
                        <th className="border p-2">Chất liệu</th>
                        <th className="border p-2">Đá quý</th>
                        <th className="border p-2">Giá</th>
                        <th className="border p-2">Tồn kho</th>
                        <th className="border p-2">Hình ảnh</th>
                        <th className="border p-2">Hành động</th>
                    </tr>
                </thead>
                <tbody>
                    {list.map((sp, index) => (
                        <tr key={sp.masanpham} className="text-center">
                            <td className="border p-2">{index + 1}</td>
                            <td className="border p-2">{sp.tensanpham}</td>
                            <td className="border p-2">{sp.maloai}</td>
                            <td className="border p-2">{sp.mota}</td>
                            <td className="border p-2">{sp.chatlieu}</td>
                            <td className="border p-2">{sp.daquy}</td>
                            <td className="border p-2">{sp.gia}</td>
                            <td className="border p-2">{sp.soluongton}</td>
                            <td className="border p-2">
                                {sp.hinhanh && <img src={`http://localhost:8080/image/${sp.hinhanh}`} alt="sp" className="w-16 h-16 object-cover mx-auto" />
                                }
                            </td>
                            <td className="border p-2 space-x-2">
                                <button onClick={() => handleEdit(sp)} className="text-blue-600">Sửa</button>
                                <button onClick={() => handleDelete(sp.masanpham)} className="text-red-600">Xóa</button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default QuanLySanPham;
