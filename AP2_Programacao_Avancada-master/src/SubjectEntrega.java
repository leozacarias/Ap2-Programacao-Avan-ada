
public interface SubjectEntrega {
	
	void addObserverEntrega(ObserverEntrega observerEntrega);
	public void removeObserverEntrega(ObserverEntrega observerEntrega);
	public void notificarEntrega();
}
