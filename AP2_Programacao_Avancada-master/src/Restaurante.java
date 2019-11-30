import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Restaurante extends JFrame implements SubjectPedido, ObserverEntrega {
	
	private List<ObserverPedido> observersPedidos = new ArrayList<>();
	private JLabel lbNome;
	private JLabel lbPedido;
	private JLabel lbUltimoPedidoEntregue;
	private JButton btPedidoPronto;
	private JLabel lbPedidostatus;
	private JLabel lbStatus;
	private JLabel lbUltimoNumeroEntregue;
	private JLabel lbPedidoColetado;
	private JLabel lbNumeroPedidoColetado;
	private int pedidoAtual = 100;
	private int pedidoColetado;
	//Variável de instancia que controla o singleton
    private volatile static Restaurante uniqueInstance;
    //Privar o construtor para não ser utilizado por outras classes
    private Restaurante () {  
    	//Definicoes da tela
    		this.setVisible(true);
    		this.setTitle("PÉ DE FAVA");
    		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    		this.setResizable(true);
    		this.setSize(650, 400);
    		this.setLocationRelativeTo(null);
    		this.setLayout(null);
    	//Definicoes dos Labels
    		//Label do nome do restaurante
    		this.lbNome = new JLabel("PÉ DE FAVA - RESTAURANTE");
    		this.lbNome.setFont(new Font("Serif", Font.BOLD, 32));
    		this.lbNome.setBounds(0, 0, 600, 100);
    		this.add(lbNome);
    		//Label de estado
    		this.lbStatus = new JLabel("PEDIDO PRONTO");
    		this.lbStatus.setFont(new Font("Serif", Font.BOLD, 30));
    		this.lbStatus.setBounds(20, 150, 400, 40);
    		this.setVisible(true);  		
    		this.add(lbStatus);
    		//Label do pedido
    		this.lbPedidostatus = new JLabel("" + pedidoAtual);
    		this.lbPedidostatus.setFont(new Font("Serif", Font.BOLD, 40));
    		this.lbPedidostatus.setBounds(400, 150, 400, 40);
    		this.setVisible(true);  		
    		this.add(lbPedidostatus);    		
    		//Label da Entrega
    		this.lbPedidoColetado = new JLabel("PEDIDO COLETADO N:");
    		this.lbPedidoColetado.setFont(new Font("Serif", Font.BOLD, 30));
    		this.lbPedidoColetado.setBounds(20, 250, 400, 40);
    		this.setVisible(true);  		
    		this.add(lbPedidoColetado);
    		//Label do nmero da ultima entrega
    		this.lbNumeroPedidoColetado = new JLabel("" + pedidoColetado);
    		this.lbNumeroPedidoColetado.setFont(new Font("Serif", Font.BOLD, 40));
    		this.lbNumeroPedidoColetado.setBounds(400, 250, 400, 40);
    		this.setVisible(true);  		
    		this.add(lbNumeroPedidoColetado);  
    		
    	//Definicoes  de Buttons	
    		this.btPedidoPronto = new JButton("Chamar número");
    		this.btPedidoPronto.setBounds(20, 100, 200, 40);    		
    		this.add(btPedidoPronto);
    		this.btPedidoPronto.setVisible(true);
    		btPedidoPronto.addActionListener(new ActionListener() {				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					atualizarPedidoPronto();
					
				}
			});

    	}
    
    //Método responsável pelo singleton com a verificação da variável quanto a quantidade de instâncias,
    //sendo a variável vazia ele cria um novo objeto, se não retorna o existente
    public static synchronized Restaurante getInstance() {
    	if(uniqueInstance == null) {
    		synchronized (Restaurante.class) {
				if (uniqueInstance == null) {
					uniqueInstance = new Restaurante();
				}
			}    		
    	}
    	return uniqueInstance;
    } 
    public int getPedidoAtual() {
    	return pedidoAtual;
    }
    public void atualizarPedidoPronto() {
		pedidoAtual++;
		lbPedidostatus.setText(""+pedidoAtual);
		notificarPedido();
	}

	@Override
	public void addObserverPedido(ObserverPedido observerPedido) {
		observersPedidos.add(observerPedido);
		
	}

	@Override
	public void removeObserverPedido(ObserverPedido observerPedido) {
		observersPedidos.remove(observerPedido);
		
	}

	@Override
	public void atualizarEntrega(SubjectEntrega subjectEntrega) {
		if (subjectEntrega instanceof Motoboy) {
			Motoboy motoboy = (Motoboy) subjectEntrega;
			this.pedidoColetado = motoboy.getPedidoColetado();
			this.lbNumeroPedidoColetado.setText(""+this.pedidoColetado);
		}
		
	}
	

	@Override
	public void notificarPedido() {
		for (ObserverPedido observerPedido : observersPedidos) {
			observerPedido.atualizarPedido(this);
		}
		
	}

    
}

	
