
public class Reproved extends StatusPedido {

	public Reproved(Pedido pedido) {
		super(pedido);
		this.nome = "REPROVED";
	}

	@Override
	public void negarPedido() {
		pedido.setStatusAtual(pedido.getStatusReproved());
	}
	

}
