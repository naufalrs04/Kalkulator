import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Controller {
    // Deklarasi Kamus
    private Model model;
    private View view;
    private JButton tombolOperatorTerakhir;

    // Konstruktor Controller, menerima model dan view sebagai parameter
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        // Loop untuk menambahkan listener ke tombol angka (0-9)
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            view.addtombolAngka(i, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    model.appendNilai(String.valueOf(finalI)); // Menambahkan angka yang diklik ke model
                    view.setDisplay(model.getNilai()); // Mengupdate tampilan dengan nilai baru
                }
            });
        }

        // Menambahkan listener ke tombol tambah
        view.addtombolOperator(view.tombolTambah, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tombolOperatorDiClick(view.tombolTambah, "+"); // Mengatur operator sebagai "+"
            }
        });

        // Menambahkan listener ke tombol kurang
        view.addtombolOperator(view.tombolKurang, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tombolOperatorDiClick(view.tombolKurang, "-"); // Mengatur operator sebagai "-"
            }
        });

        // Menambahkan listener ke tombol kali
        view.addtombolOperator(view.tombolKali, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tombolOperatorDiClick(view.tombolKali, "*"); // Mengatur operator sebagai "*"
            }
        });

        // Menambahkan listener ke tombol bagi
        view.addtombolOperator(view.tombolBagi, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tombolOperatorDiClick(view.tombolBagi, "/"); // Mengatur operator sebagai "/"
            }
        });

        view.addtombolOperator(view.tombolMod, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tombolOperatorDiClick(view.tombolMod, "%"); // Mengatur operator sebagai "%"
            }
        });

        view.addtombolSamaDengan(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.hitung(); // Melakukan perhitungan berdasarkan operator yang dipilih
                view.setDisplay(model.getNilai()); // Mengupdate tampilan dengan hasil perhitungan
                tombolResetDiClick(); // Mereset tampilan tombol operator
            }
        });

        view.addtombolResetListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.reset(); // Mereset model (menghapus semua nilai dan operator)
                view.setDisplay(model.getNilai()); // Mengupdate tampilan dengan nilai baru (kosong)
                tombolResetDiClick(); // Mereset tampilan tombol operator
            }
        });

        view.addtombolHapusListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.del(); // Menghapus digit terakhir dari nilai
                view.setDisplay(model.getNilai()); // Mengupdate tampilan dengan nilai baru
            }
        });

        view.addtombolOperator(view.tombolKoma, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.appendNilai("."); // Menambahkan koma (.) ke nilai
                view.setDisplay(model.getNilai()); // Mengupdate tampilan dengan nilai baru
            }
        });
    }

    private void tombolOperatorDiClick(JButton button, String operator) {
        model.setOperator(operator); // Mengatur operator di model
        tombolResetDiClick(); // Mereset tampilan tombol operator sebelumnya
        button.setBackground(new Color(255, 180, 50)); // Mengubah warna tombol operator yang diklik
        tombolOperatorTerakhir = button; // Menyimpan referensi tombol operator yang terakhir diklik
    }

    private void tombolResetDiClick() {
        if (tombolOperatorTerakhir != null) {
            // Mengembalikan warna tombol operator ke warna default
            if (tombolOperatorTerakhir == view.tombolTambah || tombolOperatorTerakhir == view.tombolKurang ||
                tombolOperatorTerakhir == view.tombolKali || tombolOperatorTerakhir == view.tombolBagi ||
                tombolOperatorTerakhir == view.tombolMod) {
                tombolOperatorTerakhir.setBackground(new Color(255, 180, 50)); 
            } 
            else {
                tombolOperatorTerakhir.setBackground(new Color(220, 220, 220)); 
            }
        }
    }
}
