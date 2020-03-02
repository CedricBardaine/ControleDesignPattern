package com.tactfactory.designpattern.controle.views;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.tactfactory.designpattern.controle.entities.Item;
import com.tactfactory.designpattern.controle.entities.Meal;

public class DetailsSelection extends JFrame {

  private Home home;
  private Meal meal;

  private JButton validate = new JButton("Retour");
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
    container.add(commandDetails);
    container.add(price);
    container.add(validate);
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
  }
  
  public void setDetails() {
	  this.commandDetails.setText(meal.getShowItems() ) ; 
//	  this.price.setText(String.valueOf( meal.getTotalPrice() )); 
	  DecimalFormat df = new DecimalFormat() ; 
	  df.setMaximumFractionDigits(2) ; 
	  this.price.setText( df.format(meal.getTotalPrice()) ); 
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
