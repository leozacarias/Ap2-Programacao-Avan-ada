import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TelaPedido extends JFrame {

	private static final long serialVersionUID = 1L;
	private Pedido pedido;
	private JLabel lbCompra;
	private JButton btPay;
	private JButton btRetirar;
	private JLabel lbStatusPedido;
	
	public TelaPedido() {
		this.setTitle("TELA PEDIDO");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setSize(650, 400);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		
		this.lbCompra = new JLabel("PAGUE E RECEBA SEU PEDIDO");
		this.lbCompra.setFont(new Font("Serif", Font.BOLD, 30));
		this.lbCompra.setBounds(20, 20, 550, 40);
		this.add(lbCompra);
		
		this.btPay = new JButton("PAGUE");
		this.btPay.setBounds(20, 85, 150, 25);
		btPay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					pedido.pay();
				} catch (StatusInvalidoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				exibirStatusPedido();
			}
		});
		this.add(btPay);
		
		this.btRetirar = new JButton("RETIRE O PEDIDO");
		this.btRetirar.setBounds(200, 85, 150, 25);
		btRetirar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		this.add(btRetirar);
		
		this.lbStatusPedido = new JLabel("Status do pedido");
		this.lbStatusPedido.setFont(new Font("Serif", Font.BOLD, 25));
		this.lbStatusPedido.setBounds(20, 150, 500, 100);
		this.add(lbStatusPedido);
		
		this.setVisible(true);
	}
	
	
	
	private void exibirStatusPedido() {
		lbStatusPedido.setText(""+this.pedido.getStatusAtual().getNome());
	}
}
