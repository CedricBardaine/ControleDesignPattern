package com.tactfactory.designpattern.controle.views;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.tactfactory.designpattern.controle.entities.Item;
import com.tactfactory.designpattern.controle.entities.Meal;

public class DetailsSelection extends JFrame {

  private Home home;
  private Meal meal;

  private JButton validate = new JButton("Retour");
  private JButton clean = new JButton("Tout annuler");
  private JTextArea commandDetails = new JTextArea();
  private JTextField price = new JTextField();

  public DetailsSelection() {
    this.setTitle("Details");
    this.setSize(400, 800);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    bindActions();
    addButtons();

    this.setVisible(true);    
  }

  private void addButtons() {
    JPanel container = new JPanel();
    container.setLayout(new GridLayout(3, 1));
    JPanel containerBtnsAction = new JPanel();
    containerBtnsAction.setLayout(new GridLayout(1,2));

    containerBtnsAction.add(clean);
    containerBtnsAction.add(validate);
    
    container.add(new JScrollPane(commandDetails) );
    container.add(price);
    container.add(containerBtnsAction);
    
    this.setContentPane(container);
  }

  private void bindActions() {

    // Actions code here
//    JButton.addActionListener(new ActionListener() {
//
//      @Override
//      public void actionPerformed(ActionEvent e) {
//        // Do something
//      }
//    });

    validate.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        home.setMeal(meal);
        home.setVisible(true);
        DetailsSelection.this.dispose();
      }
    });
    
    clean.addActionListener(new ActionListener() {
    	@Override
    	public void actionPerformed(ActionEvent e) {
    		meal = new Meal() ; 
    		home.setMeal(meal);
    		home.setVisible(true);
    		DetailsSelection.this.dispose();
    	}
    });
    
    
  }
  
  public void setDetails() {
	  this.commandDetails.setText(meal.getShowItemsWithTVA() ) ; 
//	  this.price.setText(String.valueOf( meal.getTotalPrice() )); 
	  DecimalFormat df = new DecimalFormat() ; 
	  df.setMaximumFractionDigits(2) ; 
	  this.price.setText( df.format(meal.getTotalPrice()) +" (TVA: "+ df.format(meal.getTotalPrice()*0.2 ) +")"+ " = "+ df.format(meal.getTotalPriceWithTVA() ) ); 
  }

  public void setHome(Home home) {
    this.home = home;
    meal = home.getMeal();
    home.setVisible(false);
    
    setDetails() ; 
    for (Item unItem : meal.getItems()) {
		System.out.println(unItem.toString());
	}
    
  }
}
