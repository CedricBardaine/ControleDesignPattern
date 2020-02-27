package com.tactfactory.designpattern.controle.views;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.tactfactory.designpattern.controle.entities.Meal;

public class ItemSelection extends JFrame {

  private Home home;
  private Meal meal;

  private JButton burger1 = new JButton("Burger1");
  private JButton burger2 = new JButton("Burger2");

  private JButton drink1Small = new JButton("Drink1Small");
  private JButton drink1Medium = new JButton("Drink1Medium");
  private JButton drink1Big = new JButton("Drink1Big");

  private JButton drink2Small = new JButton("Drink2Small");
  private JButton drink2Medium = new JButton("Drink2Medium");
  private JButton drink2Big = new JButton("Drink2Big");

  private JButton friesSmall = new JButton("FriesSmall");
  private JButton friesMedium = new JButton("FriesMedium");
  private JButton friesBig = new JButton("FriesBig");

  private JButton potatoesSmall = new JButton("PotatoesSmall");
  private JButton potatoesMedium = new JButton("PotatoesMedium");
  private JButton potatoesBig = new JButton("PotatoesBig");

  private JButton validate = new JButton("Valider");

  public ItemSelection() {
    this.setTitle("Items");
    this.setSize(800, 400);
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
