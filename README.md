# 🚀 SpringStore - Spring Boot E-Commerce API

Proyek ini adalah aplikasi backend berbasis **Spring Boot** yang menggunakan **Spring Data JPA**, **MySQL**, dan **Docker** untuk mengelola inventaris produk. Anda dapat menambahkan produk, memperbarui stok, memeriksa ketersediaan, dan memproses pesanan.

---

## ✨ Teknologi Inti

| Lapisan           | Teknologi             |
| :---------------- | :-------------------- |
| Bahasa            | Java 17               |
| Framework         | Spring Boot 3.5.3     |
| ORM               | Spring Data JPA       |
| Database          | MySQL                 |
| Build Tool        | Maven                 |
| Boilerplate       | Lombok                |
| Kontainerisasi    | Docker & Docker Compose |
| Dokumentasi API   | Swagger-UI            |
| Pengujian         | JUnit 5, Mockito      |

---

## 📂 Struktur Proyek

```
com.juniorsu.springbootjuniorsu
├── controller        # 🌐 REST API Controllers
├── service           # 🧠 Business Logic
├── repository        # 🗄️ JPA Repositories
├── model             # 📦 Entity Models
└── SpringbootJuniorsuApplication.java # 🚀 Aplikasi Utama
```

---

## ⚙️ Konfigurasi Database & Aplikasi

Pastikan Anda menyesuaikan file `src/main/resources/application.properties` dengan detail database MySQL Anda:

```properties
# Konfigurasi Database MySQL
spring.datasource.url=jdbc:mysql://localhost:3306/juniorsu_db
spring.datasource.username=root
spring.datasource.password=your_password # Ganti dengan password MySQL Anda
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

# Aktifkan Swagger UI untuk Dokumentasi API
springdoc.api-docs.enabled=true
springdoc.swagger-ui.enabled=true

# Port Server Aplikasi
server.port=8080
```
**PENTING**: Pastikan untuk mengganti `your_password` dengan password root MySQL Anda.

---

## 🚀 Persiapan & Jalankan Aplikasi

### 1. Prasyarat

* **Java 17+**
* **Maven 3.8+**
* **MySQL Server**
* **Docker** (opsional, untuk menjalankan dengan Docker Compose)

### 2. Jalankan Secara Lokal (Tanpa Docker)

Pastikan MySQL server Anda berjalan dan database `juniorsu_db` telah dibuat.

```bash
# Klon repositori (jika belum)
# git clone [https://github.com/your-username/springboot-juniorsu.git](https://github.com/your-username/springboot-juniorsu.git)
# cd springboot-juniorsu

# Compile dan jalankan aplikasi
mvn spring-boot:run
```
Aplikasi akan berjalan di `http://localhost:8080`.

### 3. Jalankan Menggunakan Docker Compose (Lokal)

Ini akan secara otomatis membuat dan menjalankan kontainer MySQL serta aplikasi Spring Boot Anda.

```bash
# Build gambar Docker dan jalankan kontainer
docker-compose up --build
```
Aplikasi akan berjalan di `http://localhost:8080`.

---

## ☁️ Deployment ke Railway

Proyek ini dirancang untuk deployment mudah ke platform seperti Railway, karena sudah menggunakan Docker.

1.  **Buat Akun Railway:**
    Jika Anda belum punya, daftar di [Railway.app](https://railway.app/).

2.  **Buat Proyek Baru:**
    Di dashboard Railway, buat proyek baru.

3.  **Hubungkan Repositori GitHub:**
    * Pilih opsi untuk "Deploy from GitHub Repo".
    * Pilih repositori `springboot-juniorsu` Anda.
    * Railway akan secara otomatis mendeteksi `Dockerfile` Anda dan mencoba membangun aplikasi.

4.  **Tambahkan Database MySQL:**
    * Di dalam proyek Railway Anda, tambahkan layanan database baru. Pilih "MySQL".
    * Railway akan menyediakan kredensial database (URL, username, password).

5.  **Konfigurasi Variabel Lingkungan:**
    * Di pengaturan layanan aplikasi Spring Boot Anda di Railway, navigasikan ke tab "Variables".
    * Tambahkan variabel lingkungan berikut, gunakan kredensial dari database MySQL yang disediakan Railway:

    ```
    SPRING_DATASOURCE_URL=jdbc:mysql://<host-database-railway>:<port-database-railway>/<nama-database-railway>
    SPRING_DATASOURCE_USERNAME=<username-database-railway>
    SPRING_DATASOURCE_PASSWORD=<password-database-railway>
    SERVER_PORT=8080 # Railway akan mengekspos port ini secara otomatis
    ```

6.  **Deployment:**
    * Setelah variabel lingkungan diatur, Railway akan secara otomatis memulai proses build dan deployment.
    * Anda dapat memantau log deployment di dashboard Railway.
    * Setelah deployment berhasil, Railway akan memberikan URL publik untuk aplikasi Anda.

---

## 🛠️ Dokumentasi API (Swagger UI)

Setelah aplikasi berjalan (baik lokal maupun di Railway), Anda dapat mengakses dokumentasi API interaktif menggunakan Swagger UI di:

* **Lokal:** `http://localhost:8080/swagger-ui.html`
* **Railway:** `https://<your-railway-app-url>/swagger-ui.html`

Anda dapat menguji semua endpoint API langsung dari antarmuka ini.

---

## 🔗 Endpoint API

| Metode | Endpoint                     | Deskripsi                      |
| :----- | :--------------------------- | :----------------------------- |
| `POST` | `/api/products`              | Tambah produk baru             |
| `PUT`  | `/api/products/{id}`         | Update kuantitas produk        |
| `GET`  | `/api/products/{id}`         | Cek ketersediaan produk        |
| `POST` | `/api/products/order`        | Pesan produk (kurangi stok)    |

---

## 🐳 Docker Compose

Berikut adalah konfigurasi `docker-compose.yml` Anda untuk menjalankan aplikasi dan database MySQL secara lokal:

```yaml
version: '3.8'
services:
  mysql:
    image: mysql:8
    restart: always
    environment:
      MYSQL_ROOT_PASSWORD: yourpassword # Ganti ini!
      MYSQL_DATABASE: juniorsu_db
    ports:
      - "3306:3306"
    volumes:
      - mysql_data:/var/lib/mysql # Volume persisten untuk data database MySQL

  app:
    build: .
    ports:
      - "8080:8080"
    depends_on:
      - mysql
    environment:
      SPRING_DATASOURCE_URL: jdbc:mysql://mysql:3306/juniorsu_db
      SPRING_DATASOURCE_USERNAME: root
      SPRING_DATASOURCE_PASSWORD: yourpassword # Ganti ini!

volumes:
  mysql_data:
```
**PENTING**: Pastikan untuk mengganti `yourpassword` dengan password root MySQL yang sama di kedua bagian `mysql` dan `app` dalam `docker-compose.yml`.

---

## 🧑‍💻 Developer

Dibuat oleh Juniorsu Team
GitHub: [@jaya2berjaya](https://github.com/jaya2berjaya)

---
