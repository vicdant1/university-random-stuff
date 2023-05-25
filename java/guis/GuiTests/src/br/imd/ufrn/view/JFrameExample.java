package br.imd.ufrn.view;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JFrameExample extends JFrame {
	private Font f = new Font("Courier", Font.BOLD, 12);
	
	private JLabel lname = new JLabel("Nome.: ");
	private JLabel lage  = new JLabel("Idade: ");
	private JLabel lcpf  = new JLabel("CPF..: ");
	private JLabel lrg   = new JLabel("RG...: ");
	
	private JTextField tname = new JTextField();
	private JTextField tage  = new JTextField();
	private JTextField tcpf  = new JTextField();
	private JTextField trg   = new JTextField();
	
	private JButton bSubmit = new JButton("Submeter");
	private JButton bClear = new JButton("Limpar");
	
	public JFrameExample() {
		Container ct = this.getContentPane();
		ct.setLayout(null);
		
		lname.setFont(f);
		lage.setFont(f);
		lcpf.setFont(f);
		lrg.setFont(f);
		
		lname.setBounds(10, 10, 100, 30);
		tname.setBounds(55, 10, 200, 25);
		
		lage.setBounds(10, 40, 100, 30);
		tage.setBounds(55, 40, 22, 25);
		
		
		
		ct.add(lname);
		ct.add(tname);
		
		ct.add(lage);
		ct.add(tage);
		
		setSize(280, 200);
		setTitle("Formulário Geral");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}

}
