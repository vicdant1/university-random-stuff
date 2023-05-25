package br.ufrn.imd.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import br.ufrn.imd.dao.ZooDao;
import br.ufrn.imd.model.Elefante;
import br.ufrn.imd.model.Girafa;
import br.ufrn.imd.model.Tigre;

public class TelaComando extends JFrame implements ActionListener  {

	JPanel mainPanel = new JPanel();
	
	JButton bListAnimals = new JButton("Listar animais");
	JButton bListAnimalsConsult = new JButton("Listar animais - Consulta");
	JButton bHerbFood = new JButton("Mostrar Comida Herbivoros");
	JButton bCarnFood = new JButton("Mostrar Comida Carnívoros");
	
	ZooDao aDao = new ZooDao();
	
	
	public TelaComando() throws ParseException{
		
		
		Date dt = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
		
		Tigre an1 = new Tigre();
		Tigre an2 = new Tigre();
		Girafa an3 = new Girafa();
		Girafa an4 = new Girafa();
		Elefante an5 = new Elefante();
		Elefante an6 = new Elefante();
		Elefante an7 = new Elefante();
		
		an1.setNome("Tigre 01");
		an1.setTipoAlimentacao("Carne");
		an1.setPeso(350);
		an1.setTipoTigre("Branco");
		dt = formato.parse("16-06-1995");
		an1.setDataNascimento(dt);
		aDao.adicionarAnimal(an1);
		
		an2.setNome("Tigre 02");
		an2.setTipoAlimentacao("Carne");
		an2.setPeso(300);
		an2.setTipoTigre("Amarela");
		dt = formato.parse("16-10-1999");
		an2.setDataNascimento(dt);
		aDao.adicionarAnimal(an2);
		
		an3.setNome("Girafa 01");
		an3.setTipoAlimentacao("Verduras e Frutas");
		an3.setPeso(500);
		an3.setTamanhoLingua(50);
		dt = formato.parse("10-01-2020");
		an3.setDataNascimento(dt);
		aDao.adicionarAnimal(an3);
		
		an4.setNome("Girafa 01");
		an4.setTipoAlimentacao("Verduras e Frutas");
		an4.setPeso(450);
		an4.setTamanhoLingua(60);
		dt = formato.parse("10-02-2015");
		an4.setDataNascimento(dt);
		aDao.adicionarAnimal(an4);
		
		an5.setNome("Elefante 01");
		an5.setTipoAlimentacao("Verduras e Frutas");
		an5.setPeso(750);
		an5.setTamanhoTromba(100);
		dt = formato.parse("10-04-2015");
		an5.setDataNascimento(dt);
		aDao.adicionarAnimal(an5);
		
		an6.setNome("Elefante 02");
		an6.setTipoAlimentacao("Verduras e Frutas");
		an6.setPeso(1000);
		an6.setTamanhoTromba(150);
		dt = formato.parse("20-06-2000");
		an6.setDataNascimento(dt);
		aDao.adicionarAnimal(an6);
		
		an7.setNome("Elefante 03");
		an7.setTipoAlimentacao("Verduras e Frutas");
		an7.setPeso(900);
		an7.setTamanhoTromba(150);
		dt = formato.parse("20-06-1999");
		an7.setDataNascimento(dt);
		aDao.adicionarAnimal(an7);
		
		System.out.println("");
		
		
		
		
		
		Container ct = this.getContentPane();
		ct.setLayout(new BorderLayout());
		
		
		mainPanel.setLayout(new GridLayout(4, 1));
		mainPanel.add(bListAnimals);
		mainPanel.add(bListAnimalsConsult);
		mainPanel.add(bHerbFood);
		mainPanel.add(bCarnFood);
		
		bListAnimals.addActionListener(this);
		bListAnimalsConsult.addActionListener(this);
		bHerbFood.addActionListener(this);
		bCarnFood.addActionListener(this);
		
		
		ct.add(BorderLayout.CENTER, mainPanel);
		
		setSize(400, 350);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Zoo Natal");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == bListAnimals) {
			aDao.getInfoAnimais();
			aDao.getListaAnimaisPorIdade();
		}
		if(e.getSource() == bListAnimalsConsult) {
			aDao.getAnimaisConsulta();
		}
		if(e.getSource() == bHerbFood) {
			aDao.getTotalComidaHerbivoros();
		}
		if(e.getSource() == bCarnFood) {
			aDao.getTotalComidaCarnivoros();
		}
	}

}
