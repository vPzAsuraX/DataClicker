package main.dataclicker.gui;

import main.dataclicker.player.Player;
import main.dataclicker.upgrades.Upgrades_Template;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

import main.dataclicker.buyers.Buyers_Template;
import main.dataclicker.dataSources.*;
import main.dataclicker.gui.GUI;
import main.dataclicker.upgrades.*;

import javax.swing.JLabel;

public class GUI {

	private JFrame frame;
	private String title = "DataClicker";

	//Buyers
	private static Buyers_Template nsa;
	private static Buyers_Template krake;

	//Datasources
	private static DataSource_Template dataFarm;
	private static DataSource_Template dataBook;
	private static DataSource_Template dataPirate;
	private static DataSource_Template dataHub;
	private static DataSource_Template dataGewinnspiele;
	private static DataSource_Template dataScout24;
	private static DataSource_Template whatsData;
	private static DataSource_Template dataSearch;
	
	//upgrades
	private static Upgrades_Template zuchtBot;
	
	//Beschriftung der Buttons die immer dem gelichen Formular folgt
	 public String playerRessources() {
		 return ("Data: " + main.dataclicker.player.Player.getDataAmount() + " Daten pro Sekunde: " + main.dataclicker.player.Player.getCurrentDataPerSecond() + " Money: " + main.dataclicker.player.Player.getMoneyAmount());
	 }
	 public String dataSourcesText(DataSource_Template datasource) {
		 return (datasource.getSourceName() + " kostet: " + datasource.getCurrentCost() + " DPS: " + datasource.getInitialDataPerSecond() + " A: " + datasource.getSourceAmountOwned());
	 }
	 public String buyersText(Buyers_Template buyer) {
		 return ("LvL: " + buyer.getLevel() + " " +  buyer.getName() + " kauft " + buyer.getPrice() + " Daten f�r " + buyer.getValue() + "�");
	 }
	 public String upgradesText(Upgrades_Template upgrade, DataSource_Template datasource) {
		 return (upgrade.getUpgradeName()+ " kostet: "+ upgrade.getUpgradeCost()+" verbessert "+ datasource.getSourceName() +" um: "+ upgrade.getUpgradeMultiplier());
	 }

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		 //Buyer
		 nsa = new  Buyers_Template("NSA", 10, 50);
		 krake = new Buyers_Template("Daten-Krake", 50, 200);

		 //Datasources
		 dataFarm = new DataSource_Template("Daten-Farm", "Bringt 2 Daten Pro Sekunde", 2, 10, 1.15, 0);
		 dataBook = new DataSource_Template("Daten-Buch", "", 10, 50, 1.20, 2000);
		 dataPirate = new DataSource_Template("Daten-Pirat", "", 15, 100, 1.40, 3000);
		 dataHub = new DataSource_Template("Daten-Hub", "", 30, 150, 1.80, 6000);
		 dataGewinnspiele = new DataSource_Template("Daten-Gewinnspiele", "", 40, 200, 2.0, 8000);
		 dataScout24 = new DataSource_Template("Daten-Scout24", "", 50, 250, 2.25, 12000);
		 dataSearch = new DataSource_Template("Daten-Suche", "", 55, 300, 2.50, 20000);
		 whatsData = new DataSource_Template("Whats-Data", "", 60, 500, 3.0, 25000);
		 
		 //upgrades
		 zuchtBot = new Upgrades_Template("Zucht-Bot", "Zieht die Daten vom klein auf an und macht diese Loyal wie keine anderen", 20, 2, dataFarm);

	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frame = new JFrame(title);
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JPanel playerRessourcesPanel = new JPanel();  //Anzeige von Daten & Geld welches der Spieler zur Zeit hat
		FlowLayout fl_playerRessourcesPanel = (FlowLayout) playerRessourcesPanel.getLayout();
		fl_playerRessourcesPanel.setVgap(50);
		frame.getContentPane().add(playerRessourcesPanel, BorderLayout.NORTH);
		
		JLabel playerRessources = new JLabel(playerRessources());
		playerRessourcesPanel.add(playerRessources);
		
		JPanel dataSources = new JPanel();
		dataSources.setLayout(new GridLayout(10,1));
		frame.getContentPane().add(dataSources, BorderLayout.EAST);
		
		JButton dataSource1 = new JButton(dataSourcesText(dataFarm));
		dataSources.add(dataSource1);
		dataSource1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent click) {
				dataFarm.purchaseDataSource();
				playerRessources.setText(playerRessources());
				dataSource1.setText(dataSourcesText(dataFarm));
			}
		});
		Timer everySecond = new Timer();		//erstellt einen Timer der jede Sekunde eine Aufgabe vollf�hrt
		everySecond.schedule(new TimerTask() {
			public void run() {
				dataFarm.collectDataPerSecond();
				dataBook.collectDataPerSecond();
				dataGewinnspiele.collectDataPerSecond();
				dataHub.collectDataPerSecond();
				dataPirate.collectDataPerSecond();
				dataScout24.collectDataPerSecond();
				dataSearch.collectDataPerSecond();
				dataGewinnspiele.collectDataPerSecond();
				whatsData.collectDataPerSecond();
				playerRessources.setText(playerRessources());
			}
		}, 0, 1000);
		
		JButton dataSource2 = new JButton(dataSourcesText(dataBook));
		dataSources.add(dataSource2);
		dataSource2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent click) {
				dataBook.purchaseDataSource();
				playerRessources.setText(playerRessources());
				dataSource2.setText(dataSourcesText(dataBook));
			}
		});

		JButton dataSource3 = new JButton(dataSourcesText(dataPirate));
		dataSources.add(dataSource3);
		dataSource3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent click) {
				dataPirate.purchaseDataSource();
				playerRessources.setText(playerRessources());
				dataSource3.setText(dataSourcesText(dataPirate));
			}
		});

		JButton dataSource4 = new JButton(dataSourcesText(dataHub)); 
		dataSources.add(dataSource4);
		dataSource4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent click) {
				dataHub.purchaseDataSource();
				playerRessources.setText(playerRessources());
				dataSource4.setText(dataSourcesText(dataHub));
			}
		});

		JButton dataSource5 = new JButton(dataSourcesText(dataGewinnspiele));
		dataSources.add(dataSource5);
		dataSource5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent click) {
				dataGewinnspiele.purchaseDataSource();
				playerRessources.setText(playerRessources());
				dataSource5.setText(dataSourcesText(dataGewinnspiele));
			}
		});

		JButton dataSource6 = new JButton(dataSourcesText(dataScout24));
		dataSources.add(dataSource6);
		dataSource6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent click) {
				dataScout24.purchaseDataSource();
				playerRessources.setText(playerRessources());
				dataSource6.setText(dataSourcesText(dataScout24));
			}
		});

		JButton dataSource7 = new JButton(dataSourcesText(dataSearch));
		dataSources.add(dataSource7);
		dataSource7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent click) {
				dataSearch.purchaseDataSource();
				playerRessources.setText(playerRessources());
				dataSource7.setText(dataSourcesText(dataSearch));
			}
		});

		JButton dataSource8 = new JButton(dataSourcesText(whatsData));
		dataSources.add(dataSource8);
		dataSource8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent click) {
				whatsData.purchaseDataSource();
				playerRessources.setText(playerRessources());
				dataSource8.setText(dataSourcesText(whatsData));
			}
		});

		JPanel dataBankPanel = new JPanel();
		frame.getContentPane().add(dataBankPanel, BorderLayout.CENTER);
		
		JButton dataBank = new JButton("Datenbank");
		dataBank.addActionListener(new ActionListener() { //überprüft wann geclickt wird und was in dem Falle passiert
			public void actionPerformed(ActionEvent click) {
				main.dataclicker.player.Player.dataClick();		//added die durch klicken dazugewonnene Anzahl von Daten
				playerRessources.setText(playerRessources()); //updatet das Label welches die aktuelle Anzahl an Daten anzeigt
				
			}
		});
		dataBankPanel.add(dataBank);
		
		JPanel buyersPanel = new JPanel();
		buyersPanel.setLayout(new GridLayout(10,1));
		frame.getContentPane().add(buyersPanel, BorderLayout.WEST);
		
		JButton buyer1 = new JButton(buyersText(nsa));
		buyersPanel.add(buyer1);
		buyer1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				nsa.buy();
				playerRessources.setText(playerRessources());
				buyer1.setText(buyersText(nsa));
			}
		});

		JButton buyer2 = new JButton(buyersText(krake));
		buyersPanel.add(buyer2);
		buyer2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				krake.buy();
				playerRessources.setText(playerRessources());
				buyer2.setText(buyersText(krake));
			}
		});

		JButton btnNewButton_1 = new JButton("New button");
		buyersPanel.add(btnNewButton_1);

		JPanel upgradesPanel = new JPanel();
		frame.getContentPane().add(upgradesPanel, BorderLayout.SOUTH);
		
		JButton upgrade1 = new JButton(upgradesText(zuchtBot, dataFarm));
		upgradesPanel.add(upgrade1);
		upgrade1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {				
				zuchtBot.purchaseUpgrade(dataFarm);
				playerRessources.setText(playerRessources());
				dataSource1.setText(dataSourcesText(dataFarm));
				upgradesPanel.remove(upgrade1);   //der button wird removed, da man Upgrades nur 1 mal erwerben kann
			}
		});
		
		
	}
	
	

}