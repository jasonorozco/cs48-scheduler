package client.view.listeners;

import client.view.UserInterface;
import client.commander.BGCommander;
import client.app.exceptions.ElementNotFoundException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.util.ArrayList;
public class CreateHostedListener implements ActionListener{
	private JTextField id,description, sunday,monday,tuesday,wednesday,thursday,friday,saturday;
	public CreateHostedListener(JTextField i,
				JTextField desc,
				JTextField sun,
				JTextField mon,
				JTextField tues,
				JTextField wed,
				JTextField thurs,
				JTextField fri,
				JTextField sat){
		id=i;
		description=desc;
		sunday=sun;
		monday=mon;
		tuesday=tues;
		wednesday=wed;
		thursday=thurs;
		friday=fri;
		saturday=sat;
	}

	public void actionPerformed(ActionEvent e){
		try{
		ArrayList<ArrayList<Integer>> duration = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<7; i++){
			ArrayList<Integer> day=new ArrayList<Integer>();
			switch(i){
				case 0: for(String s: sunday.getText().split(",")){
					if(!s.equals(""))day.add(Integer.parseInt(s));
				}break;
				case 1:for(String s: monday.getText().split(",")){
					if(!s.equals(""))day.add(Integer.parseInt(s));
				}break;
				case 2:for(String s: tuesday.getText().split(",")){
					if(!s.equals(""))day.add(Integer.parseInt(s));
				}break;
				case 3:for(String s: wednesday.getText().split(",")){
					if(!s.equals(""))day.add(Integer.parseInt(s));
				}break;
				case 4:for(String s: thursday.getText().split(",")){
					if(!s.equals(""))day.add(Integer.parseInt(s));
				}break;
				case 5:for(String s: friday.getText().split(",")){
					if(!s.equals(""))day.add(Integer.parseInt(s));
				}break;
				case 6:for(String s: saturday.getText().split(",")){
					if(!s.equals(""))day.add(Integer.parseInt(s));
				}break;
			}
			duration.add(day);
		}
		BGCommander.getBGCommander().createHostedEvent(duration,id.getText(),description.getText());
		UserInterface.getUserInterface().refreshDisplay();
	}catch(NumberFormatException ex){System.out.println("nfe");}
		catch(NullPointerException n){System.out.println("npe");}
		catch(ElementNotFoundException ex){System.out.println("enfe");}

	}
}
