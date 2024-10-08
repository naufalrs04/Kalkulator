import java.util.*;

public class Model {
    private StringBuilder nilaiSekarang = new StringBuilder();

    public void appendNilai(String value) {
        nilaiSekarang.append(value);
    }

    public String getNilai() {
        System.out.println(nilaiSekarang); // Debug: menampilkan nilai saat ini di konsol
        return nilaiSekarang.toString();
    }

    public void setOperator(String operator) {
        nilaiSekarang.append(" ").append(operator).append(" ");
    }

    public void hitung() {
        String ekspresi = nilaiSekarang.toString(); // Konversi nilai saat ini ke string
        String[] token = ekspresi.split(" "); // Memisahkan string berdasarkan spasi

        List<String> ekspresiPostfix = konversiInfixKePostfix(token); // Konversi ke notasi postfix

        double result = evaluatePostfix(ekspresiPostfix); // Evaluasi ekspresi postfix

        nilaiSekarang.setLength(0); // Reset nilai saat ini
        nilaiSekarang.append(result); // Tambahkan hasil perhitungan ke nilai saat ini
    }

    public void reset() {
        nilaiSekarang.setLength(0);
    }

    public void del() {
        if (nilaiSekarang.length() > 0) {
            nilaiSekarang.setLength(nilaiSekarang.length() - 1);
        }
    }

    private List<String> konversiInfixKePostfix(String[] token) {
        // Mendefinisikan presedensi operator
        Map<String, Integer> precedence = new HashMap<>();
        precedence.put("+", 1);
        precedence.put("-", 1);
        precedence.put("*", 2);
        precedence.put("/", 2);

        List<String> outputQueue = new ArrayList<>(); // Hasil konversi dalam bentuk postfix
        Stack<String> operatorStack = new Stack<>(); // inisialisasi stack untuk menyimpan operator

        for (String x : token) {
            if (isNumeric(x)) {
                outputQueue.add(x); // Tambahkan angka ke output
            } 
            else if (precedence.containsKey(x)) {
                while (!operatorStack.isEmpty() &&
                        precedence.containsKey(operatorStack.peek()) &&
                        precedence.get(operatorStack.peek()) >= precedence.get(x)) {
                    outputQueue.add(operatorStack.pop()); // Pindahkan operator ke output
                }
                operatorStack.push(x); // Tambahkan operator ke stack
            }
        }

        while (!operatorStack.isEmpty()) {
            outputQueue.add(operatorStack.pop());
        }

        return outputQueue; // Kembalikan ekspresi dalam bentuk postfix
    }

    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } 
        catch (NumberFormatException e) {
            return false;
        }
    }

    private double evaluatePostfix(List<String> token) {
        Stack<Double> stack = new Stack<>(); // Tumpukan untuk evaluasi
        for (String x : token) {
            if (isNumeric(x)) {
                stack.push(Double.parseDouble(x)); // Tambahkan angka ke tumpukan
            } 
            else {
                double b = stack.pop(); // Ambil angka terakhir
                double a = stack.pop(); // Ambil angka kedua terakhir
                switch (x) {
                    case "+":
                        stack.push(a + b); // Lakukan operasi tambah
                        break;
                    case "-":
                        stack.push(a - b); // Lakukan operasi kurang
                        break;
                    case "*":
                        stack.push(a * b); // Lakukan operasi kali
                        break;
                    case "/":
                        stack.push(a / b); // Lakukan operasi bagi
                        break;
                }
            }
        }
        return stack.pop(); // Kembalikan hasil evaluasi
    }
}
