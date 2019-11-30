
public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Restaurante pedefava = Restaurante.getInstance();
		pedefava.setVisible(true);
		
		
		Motoboy mt1 = new Motoboy();
		mt1.setVisible(true);
		mt1.addObserverEntrega(pedefava);
		pedefava.addObserverPedido(mt1);
		
		TelaPedido telaPedido = new TelaPedido();
		telaPedido.setVisible(true);
		
	}

}
