import React, { useEffect, useState } from "react";
import axios from "axios";

interface DonHang {
    madh: number;
    makhachhang: number;
    ngaydat: string;
    trangthai: string;
    tongtien: number;
}

const QuanLyDonHang = () => {
    const [list, setList] = useState<DonHang[]>([]);
    const [editingId, setEditingId] = useState<number | null>(null);
    const [form, setForm] = useState<Partial<DonHang>>({});

    const fetchData = async () => {
        try {
            const res = await axios.get("http://localhost:8080/donhang/all");
            setList(res.data);
        } catch (error) {
            console.error("Lỗi tải danh sách đơn hàng:", error);
        }
    };

    useEffect(() => {
        fetchData();
    }, []);

    const startEdit = (dh: DonHang) => {
        setEditingId(dh.madh);
        setForm({ ...dh });
    };

    const cancelEdit = () => {
        setEditingId(null);
        setForm({});
    };

    const handleChange = (e: React.ChangeEvent<HTMLInputElement | HTMLSelectElement>) => {
        const { name, value } = e.target;
        setForm(prev => ({ ...prev, [name]: name === "tongtien" || name === "makhachhang" ? Number(value) : value }));
    };

    const saveEdit = async () => {
        if (!editingId || !form.makhachhang || !form.ngaydat || !form.trangthai || form.tongtien === undefined) {
            alert("Vui lòng nhập đầy đủ thông tin");
            return;
        }

        try {
            await axios.put(`http://localhost:8080/donhang/update/${editingId}`, form);
            fetchData();
            cancelEdit();
        } catch (error) {
            console.error("Lỗi cập nhật đơn hàng:", error);
        }
    };

    const handleDelete = async (id: number) => {
        const confirm = window.confirm("Bạn có chắc chắn muốn xóa đơn hàng này?");
        if (!confirm) return;

        try {
            await axios.delete(`http://localhost:8080/donhang/delete/${id}`);
            fetchData();
        } catch (error) {
            console.error("Lỗi xóa đơn hàng:", error);
        }
    };

    return (
        <div className="p-6">
            <h2 className="text-xl font-bold mb-4">Quản lý đơn hàng</h2>

            <table className="w-full border text-left text-sm">
                <thead className="bg-gray-100">
                    <tr>
                        <th className="border p-2">STT</th>
                        <th className="border p-2">Mã khách hàng</th>
                        <th className="border p-2">Ngày đặt</th>
                        <th className="border p-2">Trạng thái</th>
                        <th className="border p-2">Tổng tiền</th>
                        <th className="border p-2">Hành động</th>
                    </tr>
                </thead>
                <tbody>
                    {list.map((dh, index) => (
                        <tr key={dh.madh} className="hover:bg-gray-50">
                            <td className="border p-2">{index + 1}</td>

                            <td className="border p-2">
                                {editingId === dh.madh ? (
                                    <input
                                        type="number"
                                        name="makhachhang"
                                        value={form.makhachhang || ''}
                                        onChange={handleChange}
                                        className="border p-1 rounded w-full"
                                    />
                                ) : (
                                    dh.makhachhang
                                )}
                            </td>

                            <td className="border p-2">
                                {editingId === dh.madh ? (
                                    <input
                                        type="date"
                                        name="ngaydat"
                                        value={form.ngaydat ? form.ngaydat.slice(0, 10) : ''}
                                        onChange={handleChange}
                                        className="border p-1 rounded"
                                    />
                                ) : (
                                    dh.ngaydat.slice(0, 10)
                                )}
                            </td>

                            <td className="border p-2">
                                {editingId === dh.madh ? (
                                    <select
                                        name="trangthai"
                                        value={form.trangthai || ''}
                                        onChange={handleChange}
                                        className="border p-1 rounded"
                                    >
                                        <option value="Chờ xác nhận">Chờ xác nhận</option>
                                        <option value="Đang giao">Đang giao</option>
                                        <option value="Hoàn thành">Hoàn thành</option>
                                        <option value="Đã hủy">Đã hủy</option>
                                    </select>
                                ) : (
                                    dh.trangthai
                                )}
                            </td>

                            <td className="border p-2">
                                {editingId === dh.madh ? (
                                    <input
                                        type="number"
                                        name="tongtien"
                                        value={form.tongtien !== undefined ? form.tongtien : ''}
                                        onChange={handleChange}
                                        className="border p-1 rounded w-full"
                                        min={0}
                                    />
                                ) : (
                                    dh.tongtien.toLocaleString()
                                )}
                            </td>

                            <td className="border p-2 space-x-2">
                                {editingId === dh.madh ? (
                                    <>
                                        <button onClick={saveEdit} className="text-green-600">Lưu</button>
                                        <button onClick={cancelEdit} className="text-gray-600">Hủy</button>
                                    </>
                                ) : (
                                    <>
                                        <button onClick={() => startEdit(dh)} className="text-blue-600">Sửa</button>
                                        <button onClick={() => handleDelete(dh.madh)} className="text-red-600">Xóa</button>
                                    </>
                                )}
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default QuanLyDonHang;