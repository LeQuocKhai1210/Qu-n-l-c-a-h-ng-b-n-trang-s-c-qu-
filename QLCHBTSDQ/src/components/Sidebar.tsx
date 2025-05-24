import { Link } from "react-router-dom";

export default function Sidebar() {
    return (
        <aside className="w-64 bg-gradient-to-b from-white via-purple-50 to-white h-screen p-6 shadow-lg fixed border-r border-gray-200">
            <h2 className="text-2xl font-bold text-purple-800 mb-8 tracking-wide">🌟 Admin Panel</h2>
            <nav className="flex flex-col gap-4">
                <Link to="/users" className="text-gray-700 hover:text-purple-600 font-medium">👤 Quản lý tài khoản</Link>
                <Link to="/staff" className="text-gray-700 hover:text-purple-600 font-medium">🧑‍💼 Quản lý nhân viên</Link>
                <Link to="/client" className="text-gray-700 hover:text-purple-600 font-medium">👥 Quản lý khách hàng</Link>
                <Link to="/product" className="text-gray-700 hover:text-purple-600 font-medium">💍 Quản lý sản phẩm</Link>
                <Link to="/orders" className="text-gray-700 hover:text-purple-600 font-medium">🧾 Quản lý đơn hàng</Link>
            </nav>
        </aside>
    );
}