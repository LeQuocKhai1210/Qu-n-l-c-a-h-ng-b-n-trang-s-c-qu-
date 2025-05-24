
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Header from "./components/Header";
import Sidebar from "./components/Sidebar";
import Footer from "./components/Footer";
import Dashboard from "./pages/Admin/Dashboard";
import QuanLyTaiKhoan from './pages/Admin/QuanLyTaiKhoan';
import QuanLyNhanVien from './pages/Admin/QuanLyNhanVien';
import QuanLyKhachHang from "./pages/Admin/QuanLyKhachHang";
import QuanLySanPham from "./pages/Admin/QuanLySanPham";
import QuanLyDonHang from "./pages/Admin/QuanLyDonHang";



export default function App() {
  return (
    <BrowserRouter>
      <div className="flex">
        <Sidebar />
        <div className="flex flex-col flex-1 ml-64 min-h-screen">
          <Header />
          <main className="flex-1 p-4 bg-gray-50">
            <Routes>
              <Route path="/" element={<Dashboard />} />
              <Route path="/users" element={<QuanLyTaiKhoan />} />
              <Route path="/staff" element={<QuanLyNhanVien />} />
              <Route path="/client" element={<QuanLyKhachHang />} />
              <Route path="product" element={<QuanLySanPham />} />
              <Route path="/orders" element={<QuanLyDonHang />} />


            </Routes>
          </main>
          <Footer />
        </div>
      </div>
    </BrowserRouter>
  );
}
