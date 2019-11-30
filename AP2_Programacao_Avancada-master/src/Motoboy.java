//classe que informa os métodos que um motoboy pode realizar após receber a informação da Interface Pedido

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Motoboy extends JFrame implements SubjectEntrega, ObserverPedido, Entregador{

    private final ArrayList<Pedido> pilotos = new ArrayList<Pedido>();
	private JLabel lbMotoboyName;
	private JLabel lbEntregaStatus;
	private JLabel lbPedidoStatus;
	private JButton btPedidoColetado;
	private List<ObserverEntrega> observersEntregas = new ArrayList<>();
	private JLabel lbNome;
	private JLabel lbnumeroPedidoColetado;
	private int pedidoAtual;
	private JLabel lbPedidoPronto;
	private JLabel lbNumPedidoPronto;
	private JButton btPedidoEntregue;
	int pedidoEntregue;
	private int pedidoColetado;	
	private JLabel lbUltimoPedidoEntregue;
	private JLabel lbUltimoNumeroEntregue;
    
    public Motoboy(){
    	//Definicoes da tela
		this.setVisible(true);
		this.setTitle("Entregador");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setSize(650, 400);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
	//Definicoes dos Labels
		//Label do nome do restaurante
		this.lbNome = new JLabel("P� DE FAVA - ENTREGADOR");
		this.lbNome.setFont(new Font("Serif", Font.BOLD, 32));
		this.lbNome.setBounds(10, 0, 600, 100);
		this.add(lbNome);
		//Label de ultimo pedido pronto
		this.lbPedidoPronto = new JLabel("PEDIDO PRONTO");
		this.lbPedidoPronto.setFont(new Font("Serif", Font.BOLD, 30));
		this.lbPedidoPronto.setBounds(20, 200, 400, 40);
		this.setVisible(true);  		
		this.add(lbPedidoPronto);
		//Label do numero do ultimo pedido pronto que ser� atualizado com o pedido atual
		this.lbNumPedidoPronto = new JLabel("" + pedidoAtual);
		this.lbNumPedidoPronto.setFont(new Font("Serif", Font.BOLD, 40));
		this.lbNumPedidoPronto.setBounds(400, 200, 400, 40);
		this.setVisible(true);  		
		this.add(lbNumPedidoPronto);
		//Label de estado
		this.lbEntregaStatus = new JLabel("PEDIDO COLETADO");
		this.lbEntregaStatus.setFont(new Font("Serif", Font.BOLD, 30));
		this.lbEntregaStatus.setBounds(20, 150, 500, 40);
		this.setVisible(true);  		
		this.add(lbEntregaStatus);
		//Label do pedido
		this.lbnumeroPedidoColetado = new JLabel("0");
		this.lbnumeroPedidoColetado.setFont(new Font("Serif", Font.BOLD, 40));
		this.lbnumeroPedidoColetado.setBounds(400, 150, 400, 40);
		this.setVisible(true);  		
		this.add(lbnumeroPedidoColetado);		
	//Definicoes  de Buttons	
		this.btPedidoColetado = new JButton("COLETAR PEDIDO");
		this.btPedidoColetado.setBounds(20, 100, 200, 40);    		
		this.add(btPedidoColetado);
		this.btPedidoColetado.setVisible(true);
		btPedidoColetado.addActionListener(new ActionListener() {				
			@Override
			public void actionPerformed(ActionEvent arg0) {
				coletarPedido();				
			}
		});
		
	}
	
    public void setPedidoColetado(int pedidoColetado) {
    	this.pedidoColetado = pedidoColetado;
    }
    public int getPedidoColetado() {
    	return pedidoColetado;
    }
	@Override
	public void coletarPedido() {
		pedidoColetado++;
		lbnumeroPedidoColetado.setText(""+pedidoColetado);
		notificarEntrega();
	}
	
	@Override
	public void atualizarPedido(SubjectPedido subjectPedido) {
		if(subjectPedido instanceof Restaurante) {
			Restaurante restaurante = (Restaurante) subjectPedido;
			this.pedidoAtual = restaurante.getPedidoAtual();
			this.lbNumPedidoPronto.setText(""+this.pedidoAtual);
		}				
	}
	
	
	
	@Override
	public void addObserverEntrega(ObserverEntrega observerEntrega) {
		observersEntregas.add(observerEntrega);		
	}
	@Override
	public void removeObserverEntrega(ObserverEntrega observerEntrega) {
		observersEntregas.remove(observerEntrega);		
	}	
	@Override
	public void notificarEntrega() {
		for (ObserverEntrega observerEntrega : observersEntregas) {
			observerEntrega.atualizarEntrega(this);
		}
		
	}
}
