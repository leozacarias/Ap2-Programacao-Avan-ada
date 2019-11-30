
public class Aproved extends StatusPedido {

	public Aproved(Pedido pedido) {
		super(pedido);
		this.nome = "APROVED";
	}

	@Override
	public void entregarPedido() {
		pedido.setStatusAtual(pedido.getStatusAproved());
	}
}
