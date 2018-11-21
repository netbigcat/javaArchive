package test;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Test1 {
	public static void main(String[] args){
		JFrame jf = new JFrame("标题");
		Container container = jf.getContentPane();
		jf.setSize(400,200);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		JLabel jl = new JLabel("这是一个标题");
		container.add(jl);
		jl.setHorizontalAlignment(SwingConstants.CENTER);
		container.setBackground(Color.white);
		JButton jb = new JButton("按钮");
		
		container.add(jb);
		jb.setBounds(10,10,100,10);
		container.setLayout(null);
		final JDialog jd = new JDialog(jf,"this is jdialog");
		jb.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				jd.setVisible(true);
			}
		});
		Container container2 = jd.getContentPane();
		jd.setBounds(10, 10, 200, 100);
		
	}
}
