package br.imd.ufrn.view;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JFrameExample extends JFrame {
	private Font f = new Font("Courier", Font.BOLD, 12);
	public JFrameExample() {
		Container ct = this.getContentPane();
		ct.setLayout(new FlowLayout());
		
		JButton btn1 = new JButton("Button 1");
		JButton btn2 = new JButton("Button 2");
		JButton btn3 = new JButton("Button 3");
		
		btn1.setFont(f);
		btn2.setFont(f);
		
		
		ct.add(btn1);
		ct.add(btn2);
		ct.add(btn3);
		
		
		setSize(400, 350);
		setTitle("Simple gui");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
