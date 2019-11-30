
public class Waiting extends StatusPedido {

	public Waiting(Pedido pedido) {
		super(pedido);
		this.nome = "AGUARDANDO";
	}
	
	@Override
	public void pay() {
		pedido.setStatusAtual(pedido.getStatusAproved());
	}
	

}
