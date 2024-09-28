import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View extends JFrame {
    // Deklarasi komponen UI
    public JTextField display; // Komponen untuk menampilkan hasil atau input
    public JButton[] tombolAngka = new JButton[10]; // Array tombol angka 0-9
    public JButton tombolTambah, tombolKurang, tombolKali, tombolBagi, tombolMod, tombolSamaDengan, tombolKoma, tombolReset, tombolHapus;
    public JLabel labelJudul; // Label judul untuk tampilan kalkulator

    // Konstruktor untuk View
    public View() {
        // Mengatur title window, ukuran, dan operasi default ketika ditutup
        setTitle("Kalkulator Jadul");
        setSize(350, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); // Menggunakan layout null untuk posisi bebas

        // Menambahkan label judul
        labelJudul = new JLabel("CASIO");
        labelJudul.setBounds(135, 10, 200, 30);
        labelJudul.setFont(labelJudul.getFont().deriveFont(18f)); // Mengatur ukuran font
        add(labelJudul);

        // Menambahkan dan mengatur tampilan display
        display = new JTextField();
        display.setBounds(30, 40, 270, 50);
        display.setEditable(false); // Non-aktifkan edit langsung oleh pengguna
        display.setFont(display.getFont().deriveFont(30f)); // Mengatur ukuran font
        display.setBorder(BorderFactory.createLineBorder(new Color(50, 50, 50))); // Mengatur border
        display.setMargin(new Insets(0, 10, 0, 0)); // Mengatur margin dalam teks
        add(display);

        // Mengatur posisi tombol angka (1-9) dalam grid 3x3
        int x = 30, y = 100;
        for (int i = 1; i <= 9; i++) {
            tombolAngka[i] = new JButton(String.valueOf(i));
            tombolAngka[i].setBounds(x, y, 60, 60);
            tombolAngka[i].setBackground(new Color(220, 220, 220)); // Mengatur warna tombol
            add(tombolAngka[i]);
            x += 70; // Geser ke kanan
            if (i % 3 == 0) { // Ganti baris setiap 3 tombol
                x = 30;
                y += 70; // Geser ke bawah
            }
        }

        // Menambahkan tombol angka 0
        tombolAngka[0] = new JButton("0");
        tombolAngka[0].setBounds(30, 310, 60, 60);
        tombolAngka[0].setBackground(new Color(220, 220, 220)); // Mengatur warna tombol
        add(tombolAngka[0]);

        // Menambahkan tombol koma
        tombolKoma = new JButton(",");
        tombolKoma.setBounds(100, 310, 60, 60);
        tombolKoma.setBackground(new Color(220, 220, 220)); // Mengatur warna tombol
        add(tombolKoma);

        // Menambahkan tombol sama dengan (=)
        tombolSamaDengan = new JButton("=");
        tombolSamaDengan.setBounds(240, 380, 60, 60);
        tombolSamaDengan.setBackground(new Color(255, 180, 50)); // Mengatur warna tombol
        add(tombolSamaDengan);

        // Menambahkan tombol reset
        tombolReset = new JButton("RESET");
        tombolReset.setBounds(100, y + 70, 130, 60);
        tombolReset.setBackground(new Color(255, 255, 255)); // Mengatur warna tombol
        tombolReset.setForeground(Color.BLACK); // Mengatur warna teks
        add(tombolReset);

        // Menambahkan tombol tambah (+)
        tombolTambah = new JButton("+");
        tombolTambah.setBounds(240, 100, 60, 60);
        tombolTambah.setBackground(new Color(255, 180, 50)); // Mengatur warna tombol
        add(tombolTambah);

        // Menambahkan tombol kurang (-)
        tombolKurang = new JButton("-");
        tombolKurang.setBounds(240, 170, 60, 60);
        tombolKurang.setBackground(new Color(255, 180, 50)); // Mengatur warna tombol
        add(tombolKurang);

        // Menambahkan tombol kali (*)
        tombolKali = new JButton("*");
        tombolKali.setBounds(240, 240, 60, 60);
        tombolKali.setBackground(new Color(255, 180, 50)); // Mengatur warna tombol
        add(tombolKali);

        // Menambahkan tombol bagi (/)
        tombolBagi = new JButton("/");
        tombolBagi.setBounds(240, 310, 60, 60);
        tombolBagi.setBackground(new Color(255, 180, 50)); // Mengatur warna tombol
        add(tombolBagi);

        // Menambahkan tombol modulus (%)
        tombolMod = new JButton("%");
        tombolMod.setBounds(170, 310, 60, 60);
        tombolMod.setBackground(new Color(255, 180, 50)); // Mengatur warna tombol
        add(tombolMod);

        // Menambahkan tombol hapus (DEL)
        tombolHapus = new JButton("DEL");
        tombolHapus.setBounds(30, y + 70, 60, 60);
        tombolHapus.setBackground(new Color(255, 255, 255)); // Mengatur warna tombol
        add(tombolHapus);
    }

    // Mengatur teks pada display
    public void setDisplay(String text) {
        display.setText(text);
    }

    // Mendapatkan teks dari display
    public String getDisplayText() {
        return display.getText();
    }

    // Menambahkan ActionListener ke tombol angka
    public void addtombolAngka(int index, ActionListener listener) {
        tombolAngka[index].addActionListener(listener);
    }

    // Menambahkan ActionListener ke tombol operator
    public void addtombolOperator(JButton button, ActionListener listener) {
        button.addActionListener(listener);
    }

    // Menambahkan ActionListener ke tombol sama dengan (=)
    public void addtombolSamaDengan(ActionListener listener) {
        tombolSamaDengan.addActionListener(listener);
    }

    // Menambahkan ActionListener ke tombol reset
    public void addtombolResetListener(ActionListener listener) {
        tombolReset.addActionListener(listener);
    }

    // Menambahkan ActionListener ke tombol hapus (DEL)
    public void addtombolHapusListener(ActionListener listener) {
        tombolHapus.addActionListener(listener);
    }
}