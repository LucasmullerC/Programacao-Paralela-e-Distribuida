import java.io.ObjectInputStream;
import java.net.Socket;
import java.sql.Date;
import javax.swing.JOptionPane;

public class TCPCliente {
    public static void main(String[] args) {
        try {
            Socket cliente = new Socket("localhost", 8089);
            ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
            Date data_atual = (Date) entrada.readObject();
            JOptionPane.showMessageDialog(null, "Dado recebido do servidor:" + data_atual.toString());
            entrada.close();
            System.out.println("Conexão encerrada");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}