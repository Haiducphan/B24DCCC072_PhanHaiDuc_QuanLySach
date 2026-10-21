
# ỨNG DỤNG QUẢN LÝ THƯ VIỆN SÁCH

## Thông tin sinh viên

- Họ và tên: Phan Hải Đức
- Mã sinh viên: B24DCCC072
- Học phần: Lập trình cho thiết bị di động
- Trường: Học viện Công nghệ Bưu chính Viễn thông (PTIT)

## Giới thiệu

Ứng dụng quản lý thư viện sách cá nhân được phát triển
bằng Java và XML trên Android Studio.

Ứng dụng cho phép người dùng quản lý danh sách sách,
theo dõi trạng thái đọc, đánh giá và ghi chú về sách.

## Công nghệ sử dụng

- Ngôn ngữ: Java
- Giao diện: XML
- IDE: Android Studio
- Android SDK tối thiểu: API 24
- Lưu trữ dữ liệu: ArrayList<Book>
- Thiết bị kiểm thử: Pixel 7 (Android API 35)

## Chức năng chính

### 1. Đăng nhập
- Đăng nhập bằng tài khoản cố định.
- Kiểm tra trường thông tin bắt buộc.
- Thông báo khi đăng nhập sai.

Tài khoản kiểm thử:
- Username: admin
- Password: 123456

### 2. Danh sách sách
- Hiển thị các cuốn sách trong thư viện.
- Hiển thị tên sách, tác giả, thể loại.
- Hiển thị trạng thái đọc và đánh giá bằng sao.
- Thống kê tổng số sách, số sách đã đọc
  và số sách chưa đọc xong.

### 3. Thêm sách
- Nhập tên sách và tác giả.
- Chọn thể loại bằng Spinner.
- Chọn trạng thái đọc bằng RadioGroup.
- Đánh giá sách bằng RatingBar (0-5 sao).
- Nhập ghi chú.
- Kiểm tra thông tin bắt buộc trước khi lưu.

### 4. Chi tiết sách
- Xem thông tin chi tiết từng cuốn sách.
- Cập nhật số sao đánh giá.
- Đánh dấu sách là đã đọc.
- Xóa sách với hộp thoại xác nhận.
- Quay lại danh sách và cập nhật thống kê.

## Cách chạy ứng dụng

1. Clone repository từ GitHub.
2. Mở project bằng Android Studio.
3. Chờ Gradle Sync hoàn tất.
4. Chọn máy ảo Android hoặc điện thoại Android.
5. Nhấn Run để khởi chạy ứng dụng.
6. Đăng nhập bằng tài khoản kiểm thử.

## Lưu ý

Dữ liệu được lưu trong ArrayList trên bộ nhớ RAM.
Dữ liệu có thể được khởi tạo lại khi tiến trình
ứng dụng bị kết thúc.

## Cấu trúc dự án

- Book.java: Lớp mô hình sách.
- BookData.java: Danh sách sách dùng chung.
- BookAdapter.java: Hiển thị dữ liệu lên ListView.
- LoginActivity.java: Xử lý đăng nhập.
- MainActivity.java: Hiển thị danh sách và thống kê.
- AddBookActivity.java: Xử lý thêm sách.
- BookDetailActivity.java: Xử lý chi tiết và xóa sách.

## GitHub

Repository:
https://github.com/Haiducphan/B24DCCC072_PhanHaiDuc_QuanLySach
