package com.tactfactory.designpattern.controle.views;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.tactfactory.designpattern.controle.builders.MealBuilder;
import com.tactfactory.designpattern.controle.entities.Meal;
import com.tactfactory.designpattern.controle.entities.food.Sandwich_BigMac;
import com.tactfactory.designpattern.controle.entities.food.Sandwich_RoyalDeluxe;

public class MenuSelection extends JFrame {

  private Home home;
  private Meal meal;
  
  private MealBuilder theMealBuilder ; 

  private JButton bestOf = new JButton("BestOf");
  private JButton maxiBestOf = new JButton("MaxiBestOf");

  private JButton burger1 = new JButton("Big Mac");
  private JButton burger2 = new JButton("Royal Deluxe");

  private JButton drink1 = new JButton("Drink1");
  private JButton drink2 = new JButton("Drink2");

  private JButton fries = new JButton("Fries");
  private JButton potatoes = new JButton("Potatoes");

  private JButton validate = new JButton("Valider");

  public MenuSelection() {
    this.setTitle("Menu");
    this.setSize(800, 400);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    bindActions();
    addButtons();

    this.setVisible(true);
  }

  private void addButtons() {
    JPanel container = new JPanel();
    container.setLayout(new GridLayout(3, 1));

    JPanel containerType = new JPanel();
    containerType.setLayout(new GridLayout(1, 2));
    containerType.add(bestOf);
    containerType.add(maxiBestOf);
    container.add(containerType);

    JPanel containerBurger = new JPanel();
    containerBurger.setLayout(new GridLayout(2, 4));
    containerBurger.add(burger1);
    containerBurger.add(burger2);
    container.add(containerBurger);

    JPanel containerDrink = new JPanel();
    containerDrink.setLayout(new GridLayout(2, 4));
    containerDrink.add(drink1);
    containerDrink.add(drink2);
    container.add(containerDrink);

    JPanel containerAccompaniment = new JPanel();
    containerAccompaniment.setLayout(new GridLayout(2, 4));
    containerAccompaniment.add(fries);
    containerAccompaniment.add(potatoes);
    container.add(containerAccompaniment);

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
	  
	  bestOf.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("- vous preparez maintenant un nouveau menu best of.");
			theMealBuilder = new MealBuilder();
			theMealBuilder.prepareBestOf() ;
			}
	});
	  
	  burger1.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if ( theMealBuilder == null )
				System.out.println("- sélectionnez d'abord un menu");
			else {
			Sandwich_BigMac newBurger = new Sandwich_BigMac() ; 
			theMealBuilder.addItem(newBurger) ; 
//			System.out.println("- votre menu best-of contient un "+ newBurger.name() );
			}
		}
	});
	  burger2.addActionListener(new ActionListener() {
		  @Override
		  public void actionPerformed(ActionEvent e) {
			  if ( theMealBuilder == null )
				  System.out.println("- ! sélectionnez d'abord un menu");
			  else {
				  Sandwich_RoyalDeluxe newBurger = new Sandwich_RoyalDeluxe() ; 
				  theMealBuilder.addItem(newBurger) ; 
//				  System.out.println("- votre menu best-of contient un "+ newBurger.name() );
			  }
		  }
	  });
	  

    validate.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        home.setMeal(meal);
        home.setVisible(true);
        MenuSelection.this.dispose();
      }
    });
  }

  public void setHome(Home home) {
    this.home = home;
    meal = home.getMeal();
    home.setVisible(false);
  }
}
