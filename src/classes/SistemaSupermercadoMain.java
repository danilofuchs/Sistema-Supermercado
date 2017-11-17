package classes;
import interfaceGrafica.VendaGUI;
import exceptions.NegativeStockException;

public class SistemaSupermercadoMain {

    public static void main(String[] args) {
	VendaGUI vendaWindow = new VendaGUI();
        vendaWindow.setVisible(true);
    }

}
