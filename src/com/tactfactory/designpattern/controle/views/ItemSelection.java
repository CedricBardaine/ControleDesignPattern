package com.tactfactory.designpattern.controle.views;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.tactfactory.designpattern.controle.entities.Meal;
import com.tactfactory.designpattern.controle.entities.food.Accompaniment_fries;
import com.tactfactory.designpattern.controle.entities.food.Accompaniment_potatoes;
import com.tactfactory.designpattern.controle.entities.food.Drink_CocaCola;
import com.tactfactory.designpattern.controle.entities.food.Drink_DrPepper;
import com.tactfactory.designpattern.controle.entities.food.Sandwich_BigMac;
import com.tactfactory.designpattern.controle.entities.food.Sandwich_RoyalDeluxe;

public class ItemSelection extends JFrame {

  private Home home;
  private Meal meal;

  private JButton burger1 = new JButton("Big Mac");
  private JButton burger2 = new JButton("Royal Deluxe");

  private JButton drink1Small = new JButton("Coca Cola - petit");
  private JButton drink1Medium = new JButton("Coca Cola - moyen");
  private JButton drink1Big = new JButton("Coca Cola - grand");

  private JButton drink2Small = new JButton("Dr Pepper - petit");
  private JButton drink2Medium = new JButton("Dr Pepper - moyen");
  private JButton drink2Big = new JButton("Dr Pepper - grand");

  private JButton friesSmall = new JButton("Frittes - petit");
  private JButton friesMedium = new JButton("Frittes - moyen");
  private JButton friesBig = new JButton("Frittes - grand");

  private JButton potatoesSmall = new JButton("Potatoes - petit");
  private JButton potatoesMedium = new JButton("Potatoes - moyen");
  private JButton potatoesBig = new JButton("Potatoes - grand");

  private JButton validate = new JButton("Valider");

  public ItemSelection() {
    this.setTitle("Items");
    this.setSize(1000, 400);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    bindActions();
    addButtons();

    this.setVisible(true);
  }

  private void addButtons() {
    JPanel container = new JPanel();
    container.setLayout(new GridLayout(3, 1));

    JPanel containerBurger = new JPanel();
    containerBurger.setLayout(new GridLayout(2, 4));
    containerBurger.add(burger1);
    containerBurger.add(burger2);
    container.add(containerBurger);

    JPanel containerDrink = new JPanel();
    containerDrink.setLayout(new GridLayout(2, 3));
    containerDrink.add(drink1Small);
    containerDrink.add(drink1Medium);
    containerDrink.add(drink1Big);
    containerDrink.add(drink2Small);
    containerDrink.add(drink2Medium);
    containerDrink.add(drink2Big);
    container.add(containerDrink);

    JPanel containerAccompaniment = new JPanel();
    containerAccompaniment.setLayout(new GridLayout(2, 3));
    containerAccompaniment.add(friesSmall);
    containerAccompaniment.add(friesMedium);
    containerAccompaniment.add(friesBig);
    containerAccompaniment.add(potatoesSmall);
    containerAccompaniment.add(potatoesMedium);
    containerAccompaniment.add(potatoesBig);
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
	  
	  burger1.addActionListener(new ActionListener() {
		  @Override
		  public void actionPerformed(ActionEvent e) { meal.addItem(new Sandwich_BigMac()) ; }
	  });
	  burger2.addActionListener(new ActionListener() {
		  @Override
		  public void actionPerformed(ActionEvent e) { meal.addItem(new Sandwich_RoyalDeluxe()) ; }
	  });
	  
	  drink1Small.addActionListener(new ActionListener() {
		  @Override
		  public void actionPerformed(ActionEvent e) { meal.addItem(new Drink_CocaCola("petit") ) ; }
	  });
	  drink1Medium.addActionListener(new ActionListener() {
		  @Override
		  public void actionPerformed(ActionEvent e) { meal.addItem(new Drink_CocaCola("moyen") ) ; }
	  });
	  drink1Big.addActionListener(new ActionListener() {
		  @Override
		  public void actionPerformed(ActionEvent e) { meal.addItem(new Drink_CocaCola("grand") ) ; }
	  });
	  
	  drink2Small.addActionListener(new ActionListener() {
		  @Override
		  public void actionPerformed(ActionEvent e) { meal.addItem(new Drink_DrPepper("petit") ) ; }
	  });
	  drink2Medium.addActionListener(new ActionListener() {
		  @Override
		  public void actionPerformed(ActionEvent e) { meal.addItem(new Drink_DrPepper("moyen") ) ; }
	  });
	  drink2Big.addActionListener(new ActionListener() {
		  @Override
		  public void actionPerformed(ActionEvent e) { meal.addItem(new Drink_DrPepper("grand") ) ; }
	  });
	  
	  friesSmall.addActionListener(new ActionListener() {
		  @Override
		  public void actionPerformed(ActionEvent e) { meal.addItem(new Accompaniment_fries("petit") ) ; }
	  });
	  friesMedium.addActionListener(new ActionListener() {
		  @Override
		  public void actionPerformed(ActionEvent e) { meal.addItem(new Accompaniment_fries("moyen") ) ; }
	  });
	  friesBig.addActionListener(new ActionListener() {
		  @Override
		  public void actionPerformed(ActionEvent e) { meal.addItem(new Accompaniment_fries("grand") ) ; }
	  });
	  
	  potatoesSmall.addActionListener(new ActionListener() {
		  @Override
		  public void actionPerformed(ActionEvent e) { meal.addItem(new Accompaniment_potatoes("petit") ) ; }
	  });
	  potatoesMedium.addActionListener(new ActionListener() {
		  @Override
		  public void actionPerformed(ActionEvent e) { meal.addItem(new Accompaniment_potatoes("moyen") ) ; }
	  });
	  potatoesBig.addActionListener(new ActionListener() {
		  @Override
		  public void actionPerformed(ActionEvent e) { meal.addItem(new Accompaniment_potatoes("grand") ) ; }
	  });
	  

    validate.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        home.setMeal(meal);
        home.setVisible(true);
        ItemSelection.this.dispose();
      }
    });
  }

  public void setHome(Home home) {
    this.home = home;
    meal = home.getMeal();
    home.setVisible(false);
  }
}
