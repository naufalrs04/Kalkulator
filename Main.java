public class Main {
    public static void main(String[] args) {
        // Membuat objek Model
        Model model = new Model();
        
        // Membuat objek View
        View view = new View();
        
        // Membuat objek Controller dengan menghubungkan Model dan View
        Controller controller = new Controller(model, view);
        
        // Menampilkan UI kalkulator
        view.setVisible(true);
    }
}
