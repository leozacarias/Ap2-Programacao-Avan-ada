
public class Pedido {

	private float valorPedido;
	private StatusPedido statusAtual;
	private StatusPedido statusWaiting;
	private StatusPedido statusAproved;
	private StatusPedido statusReproved;
	
	public Pedido(float valorPedido) {
		this.statusWaiting = new Waiting(this);
		this.statusAproved = new Aproved(this);
		this.statusReproved = new Reproved(this);
		this.statusAtual = this.statusWaiting;
	}

	public StatusPedido getStatusWaiting() {
		return statusWaiting;
	}
	public StatusPedido getStatusAproved() {
		return statusAproved;
	}
	public StatusPedido getStatusReproved() {
		return statusReproved;
	}
	public float getValorPedido() {
		return valorPedido;
	}

	public void setValorPedido(float valorPedido) {
		this.valorPedido = valorPedido;
	}

	public StatusPedido getStatusAtual() {
		return statusAtual;
	}

	public void setStatusAtual(StatusPedido statusAtual) {
		this.statusAtual = statusAtual;
	}
	
	public void pay() throws StatusInvalidoException{
		statusAtual.pay();
	}
	
	public void devolver() throws StatusInvalidoException{
		statusAtual.negarPedido();
	}
	
	

}
