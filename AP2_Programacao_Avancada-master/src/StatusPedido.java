
public abstract class StatusPedido {

	protected Pedido pedido;
	protected String nome;
	
	public StatusPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public void pay() throws StatusInvalidoException{
		throw new StatusInvalidoException("Erro" + pedido.getStatusAtual().getNome());
	}
	
	public void retorne() throws StatusInvalidoException {
		throw new StatusInvalidoException("Erro" + pedido.getStatusAtual().getNome());
	}

	public String getNome() {
		return nome;
	}

	public void entregarPedido() {
		// TODO Auto-generated method stub
		
	}

	public void negarPedido() {
		// TODO Auto-generated method stub
		
	}
	 
	
}
