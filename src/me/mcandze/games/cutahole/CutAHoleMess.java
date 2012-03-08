package me.mcandze.games.cutahole;

import java.awt.Font;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class CutAHoleMess extends JFrame{
	protected JTextArea o;
	
	public CutAHoleMess(){
		super();
		o = new JTextArea();
		o.setFont(new Font("monospaced", Font.PLAIN, 14));
	}
	
	public void write(String s){
		o.append(s);
	}
	
	public void write(String[] s){
		for (String ss: s){
			write(ss);
		}
	}
	
	public void write(List<String> s){
		String[] toWrite = new String[s.size()];
		int i = 0;
		for (String ss: s){
			toWrite[i] = ss;
			i++;
		}
		write(toWrite);
	}

	public void write(int i){
		write(String.valueOf(i));
	}
	
	public void write(double d){
		write(String.valueOf(d));
	}
	
	public void write(float f){
		write(String.valueOf(f));
	}
	
	public void write(boolean b){
		write(String.valueOf(b));
	}
	
	public void write(short s){
		write(String.valueOf(s));
	}
	
	public void write(char c){
		write(String.valueOf(c));
	}

	public void writeln(String s){
		o.append(s + "\n");
	}
	
	public void writeln(String[] s){
		for (String ss: s){
			writeln(ss);
		}
	}
	
	public void writeln(List<String> s){
		String[] towriteln = new String[s.size()];
		int i = 0;
		for (String ss: s){
			towriteln[i] = ss;
			i++;
		}
		writeln(towriteln);
	}

	public void writeln(int i){
		writeln(String.valueOf(i));
	}
	
	public void writeln(double d){
		writeln(String.valueOf(d));
	}
	
	public void writeln(float f){
		writeln(String.valueOf(f));
	}
	
	public void writeln(boolean b){
		writeln(String.valueOf(b));
	}
	
	public void writeln(short s){
		writeln(String.valueOf(s));
	}
	
	public void writeln(char c){
		writeln(String.valueOf(c));
	}
	
	public void clear(){
		o.setText("");
	}
	
	public String getText(){
		return o.getText();
	}
}
