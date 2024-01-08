package db;

import app.model.Kurir;
import dao.UserDao;
import app.model.User;
import dao.KurirDao;
import dao.OrderDao;

/**
 *
 * @author ridho
 */
public class Seeders {

    public int insertAdmin() {
        // Panggil DAO untuk melakukan pengecekan
        UserDao userDao = new UserDao();

        // Nomor telepon admin yang akan disisipkan
        String adminEmail = "admin@gmail.com";
        String adminTelp = "01234567890";

        // Lakukan pengecekan apakah admin dengan nomor telepon tersebut sudah ada
        User existingAdminEmail = userDao.select("email", adminEmail);
        User existingAdminTelp = userDao.select("Telp", adminTelp);
//        if (existingAdminEmail.getUserId() != null) {
        if (existingAdminEmail.getUserId() != null && existingAdminTelp.getUserId() != null) {
            System.err.println("User dengan email: " + adminEmail + " sudah ada");
            return -1; // Atau tindakan lain yang sesuai dengan kebutuhan Anda
        } else {
            // Jika belum ada, buat objek User dan sisipkan admin baru
            User newUser = new User();
            newUser.setUserName("admin");
            newUser.setUserEmail(adminEmail);
            newUser.setUserPassword("admin123");
            newUser.setUserTelp(adminTelp);
            newUser.setUserAlamat("Bandung");
            newUser.setIsKurir(false);
            newUser.setIsAdmin(true);

            // Panggil DAO untuk menyimpan data ke dalam database
            UserDao userDaoInsert = new UserDao();
            int result = userDaoInsert.insert(newUser);

            return result;

        }
    }

    public int insertUser() {
        // Panggil DAO untuk melakukan pengecekan
        UserDao userDao = new UserDao();

        String userEmail = "jack@gmail.com";
        String userTelp = "012345678910";

        // Lakukan pengecekan apakah admin dengan nomor telepon tersebut sudah ada
        User existingAdminEmail = userDao.select("email", userEmail);
        User existingAdminTelp = userDao.select("Telp", userTelp);
//        if (existingAdminEmail.getUserId() != null) {
        if (existingAdminEmail.getUserId() != null && existingAdminTelp.getUserId() != null) {
            System.err.println("User dengan email: " + userEmail + " sudah ada");
            return -1; // Atau tindakan lain yang sesuai dengan kebutuhan Anda
        } else {
            // Jika belum ada, buat objek User dan sisipkan admin baru
            User newUser = new User();
            newUser.setUserName("jack sparows");
            newUser.setUserEmail(userEmail);
            newUser.setUserPassword("jack123");
            newUser.setUserTelp(userTelp);
            newUser.setUserAlamat("Bandung");
            newUser.setIsKurir(false);
            newUser.setIsAdmin(false);

            // Panggil DAO untuk menyimpan data ke dalam database
            UserDao userDaoInsert = new UserDao();
            int result = userDaoInsert.insert(newUser);

            return result;

        }
    }

    public static void seedKurirData() {
        KurirDao kurirDao = new KurirDao();
        UserDao userDao = new UserDao();

        // Misalnya, kita ingin membuat user menjadi kurir dengan email tertentu
        String userEmail = "sarip@gmail.com";

        // Cek apakah user dengan email tersebut sudah ada
        User existingUser = userDao.select("email_user", userEmail);

        if (existingUser.getUserId() == null) {
            // Jika user belum ada, tambahkan user baru
            User newUser = new User();
            newUser.setUserName("saripudin");
            newUser.setUserEmail(userEmail);
            newUser.setUserPassword("sarip123");
            newUser.setUserTelp("98989898989");
            newUser.setUserAlamat("Bandung");
            newUser.setUserPoint(0);
            newUser.setIsKurir(true);
            newUser.setIsAdmin(false);

            // Tambahkan user baru
            userDao.insert(newUser);

            // Tambahkan kurir baru dengan poin awal
            Kurir newKurir = new Kurir();
            newKurir.setEmailKurir(userEmail);
            newKurir.setPointKurir(0); // Sesuaikan dengan poin awal

            // Tambahkan kurir baru ke dalam tabel kurir
            kurirDao.insert(newKurir);

            System.out.println("Seeder: Data kurir berhasil ditambahkan.");
        } else {
            System.out.println("Seeder: Kurir dengan email tersebut sudah ada.");
        }
    }

    public int insertOrder() {
        try {
            // Email user yang akan melakukan order
            String userEmail = "jack@gmail.com";

            // Daftar contoh data order
            String daerahOrder1 = "Daerah S";
            int totalSampahOrder1 = 5;
            String kategoriSampahOrder1 = "botol plastik";
            String emailKurirOrder1 = "sarip@gmail.com";

            String daerahOrder2 = "Daerah G";
            int totalSampahOrder2 = 8;
            String kategoriSampahOrder2 = "komputer";
            String emailKurirOrder2 = "sarip@gmail.com";

            // Panggil OrderDao untuk memasukkan data order ke dalam database
            OrderDao orderDao = new OrderDao();
            orderDao.placeOrder(userEmail, daerahOrder1, totalSampahOrder1, kategoriSampahOrder1, emailKurirOrder1, kategoriSampahOrder1);
            orderDao.placeOrder(userEmail, daerahOrder2, totalSampahOrder2, kategoriSampahOrder2, emailKurirOrder2, kategoriSampahOrder2);

            System.out.println("Seeder: Data order berhasil ditambahkan.");
//            logger.info("Seeder: Data order berhasil ditambahkan.");
            return 0;
        } catch (Exception e) {
            System.err.println("Seeder: Gagal menambahkan data order.");
//            logger.error("Seeder: Gagal menambahkan data order.", e);
            return -1;
        }
    }
}
