//Interface para uso do Observer Pattern, sendo essa interface criada para o Observable(Observado) com relacao ao pedido realizado no restaurante
public interface SubjectPedido {
	
	void addObserverPedido(ObserverPedido observerPedido);
	public void removeObserverPedido(ObserverPedido observerPedido);
	public void notificarPedido();

}