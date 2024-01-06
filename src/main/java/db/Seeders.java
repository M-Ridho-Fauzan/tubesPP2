package db;

import app.model.Kurir;
import dao.UserDao;
import java.util.UUID;
import app.model.User;
import dao.KurirDao;

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

        // Lakukan pengecekan apakah admin dengan nomor telepon tersebut sudah ada
        User existingAdmin = userDao.select("email", adminEmail);
        if (existingAdmin.getUserId() != null) {
            System.out.println("Admin with the same email already exists. Skipping insertion.");
            return -1; // Atau tindakan lain yang sesuai dengan kebutuhan Anda
        } else {
            // Jika belum ada, buat objek User dan sisipkan admin baru
            User newUser = new User();
            newUser.setUserId(UUID.randomUUID().toString());
            newUser.setUserName("admin");
            newUser.setUserEmail(adminEmail);
            newUser.setUserPassword("admin123");
            newUser.setUserTelp("081234567890");
            newUser.setUserAlamat("Bandung");
            newUser.setIsKurir(false);
            newUser.setIsAdmin(true);

            // Panggil DAO untuk menyimpan data ke dalam database
            UserDao userDaoInsert = new UserDao();
            int result = userDaoInsert.insert(newUser);

            return result;
        }
    }

//    =============
    public int insertKurir() {
        // Panggil DAO untuk melakukan pengecekan
        KurirDao kurirDao = new KurirDao();

        // Email kurir yang akan disisipkan
        String kurirEmail = "ini@gmail.com";

        // Lakukan pengecekan apakah kurir dengan email tersebut sudah ada
        Kurir existingKurir = kurirDao.select("email_kurir", kurirEmail);
        if (existingKurir.getEmailKurir() != null) {
            System.out.println("Kurir with the same email already exists. Skipping insertion.");
            return -1; // Atau tindakan lain yang sesuai dengan kebutuhan Anda
        } else {
            // Jika belum ada, buat objek Kurir dan sisipkan kurir baru
            Kurir newKurir = new Kurir();
            newKurir.setEmailKurir(kurirEmail);
            newKurir.setPointKurir(+5); // Misalnya, set poin awal kurir ke 0

            // Panggil DAO untuk menyimpan data ke dalam database
            KurirDao kurirDaoInsert = new KurirDao();
            int result = kurirDaoInsert.insert(newKurir);

            return result;
        }
    }

}
