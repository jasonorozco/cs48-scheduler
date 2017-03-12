package client.view;
import client.app.obj.*;
import client.commander.BGCommander;
import client.view.*;

import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class UserInterface extends JFrame{
	private DisplayMyEvents displayMyEvents;
	private DisplayScheduleDisplay displayScheduleDisplay;
	private DisplayHostedEvents displayHostedEvents;
	private DisplayMyOrganizations displayMyOrganizations;
	private static UserInterface ui;


  /**
	 * Launch method.
	 */
	public void launch(){
		try {
			UserInterface uiWindow = new UserInterface();
			this.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static UserInterface getUserInterface(){
		if(ui==null){
			ui = new UserInterface();
		}
		return ui;
	}
	private UserInterface() {
		super("Del Planner");
		initialize();
	}

	/**
	 * Initialize the contents of the panel.
	 */
	private void initialize() {
		//commander=BGCommander.getBGCommander();
		this.setBounds(100, 100, 1200, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new GridLayout(1, 3));


		//LEFT PANE OF MAIN UI
		JTabbedPane paneLeft = new JTabbedPane(JTabbedPane.TOP);

		displayMyEvents = new DisplayMyEvents();
		paneLeft.addTab("My Events", displayMyEvents);
		displayScheduleDisplay = new DisplayScheduleDisplay();
		paneLeft.addTab("My Schedules", displayScheduleDisplay);
		displayHostedEvents = new DisplayHostedEvents();
		paneLeft.addTab("My Hosted Events", displayHostedEvents);
		displayMyOrganizations = new DisplayMyOrganizations();
		paneLeft.addTab("My Organizations", displayMyOrganizations);

		//RIGHT PANE OF MAIN UI
		JTabbedPane paneRight = new JTabbedPane(JTabbedPane.TOP);

		paneRight.addTab("Login",new login(this));
		JSplitPane splitPaneLR = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, paneLeft, paneRight);

		paneRight.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		paneLeft.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		splitPaneLR.setOneTouchExpandable(true);
		splitPaneLR.setResizeWeight(0.6);

		this.getContentPane().add(splitPaneLR);
	}

	public void refreshDisplay(){
		displayMyEvents.refresh();
		displayScheduleDisplay.refresh();
		displayHostedEvents.refresh();
		displayMyOrganizations.refresh();
		this.repaint();
	}

}
