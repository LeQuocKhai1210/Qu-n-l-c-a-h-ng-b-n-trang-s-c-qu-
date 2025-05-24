export default function Header() {
    return (
        <header className="relative px-6 py-4 bg-white border-b shadow w-full">

            <h1 className="absolute left-1/2 transform -translate-x-1/2 text-2xl font-bold text-purple-700">
                Quản Lý Cửa Hàng Trang Sức Đá Quý
            </h1>


            <div className="text-gray-600 text-right">
                Xin chào, <span className="font-semibold">Admin</span>
            </div>
        </header>
    );
}
