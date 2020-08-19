import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.sun.corba.se.impl.orbutil.graph.*;
import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;



class Input extends JFrame{
    JPanel jp = new JPanel(new GridLayout(8, 8, 4, 4));
    JTextField  T1,T2,T3,T4,T5,T6,T7,T8;
   public StringBuilder strequ1,strequ2;
    public NodeMaker rz1,rz2,addResult,multiplyResult;
    JButton button = new JButton("Draw Graph");
    JButton button1 = new JButton("Go on...");
    
    Input(){
        setLocationRelativeTo(null);
        setSize(1000, 500);
        setLocation(0, 0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(jp);
        getContentPane().setBackground(Color.black);
        T1 = new JTextField("First PolyNomial");
        T2 = new JTextField("Second PolyNomial");
        T3 = new JTextField("Sum Result");
        T4 = new JTextField("Multiply Result");
        T5 = new JTextField();
        T6 = new JTextField();
        T7 = new JTextField();
        T8 = new JTextField();
        T1.setEditable(false);
        T2.setEditable(false);
        T3.setEditable(false);
        T4.setEditable(false);
        T1.setBounds(50, 105, 100, 40);
        T2.setBounds(50, 155, 100, 40);
        T3.setBounds(50, 305, 100, 40);
        T4.setBounds(50, 355, 100, 40);
        T5.setBounds(250, 105, 550, 40);
        T6.setBounds(250, 155, 550, 40);
        T7.setBounds(250, 305, 550, 40);
        T8.setBounds(160, 355, 2000, 40);
        T5.setCaretColor(Color.RED);
        T5.setForeground(Color.red);
        T6.setCaretColor(Color.red);
        T6.setForeground(Color.red);
        T7.setCaretColor(Color.red);
        T8.setCaretColor(Color.red);
        button.setBounds(325, 235, 180, 30);
        button1.setBounds(520, 235, 180, 30);
       
        add(T1);
        add(T2);
        add(T3);
        add(T4);
        add(T5);
        add(T6);
        add(T7);
        add(T8);
        add(button);
        add(button1);
        //call(T5,T6);
      /*  T5.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 strequ1 = new StringBuilder(T5.getText());
				 rz1=Worker.zCreator(strequ1,0,0);
				 
				 //System.out.println(strequ1.charAt(0));
			}
        	
        });
        T6.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			    
			    rz2=Worker.zCreator(strequ2,0,0);
			    
			}
        	
        });*/
		
		//System.out.println(strequ1.charAt(0));
		//
		
		
		

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        try {
            button1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	strequ1 = new StringBuilder(T5.getText());
                	strequ2 = new StringBuilder(T6.getText());
                	
                	rz1=Worker.zCreator(strequ1,0,0);
                	rz2=Worker.zCreator(strequ2,0,0);
                	NodeMaker r1=rz1.getNext();
                	NodeMaker r2=rz2.getNext();
            		 addResult=Calculate.add(r1, r2);
            		 multiplyResult=Calculate.multiPly(r1, r2);
            		 Calculate.print(addResult,T7);
            		 Calculate.print(multiplyResult,T8);
                	//System.out.println(rz1.getNext().getExp());
                    
                }
            });
            button.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Graph(addResult);
				}
            	
            });
            
        } catch (Exception e) {

            JOptionPane.showMessageDialog(rootPane ,"No mathematical equations were obtained");
            T7.setText("");
            T8.setText("");
        }
    }
    void Graph(NodeMaker result){
        //display1 ds = new display1(result);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	new display1(result);
            }
         });
    }
    void call(JTextField T1,JTextField T2){

		
    }
    
}




/////////////////////////////////////////////////////////////////////////
class display1 extends JFrame{
    private static final Stroke GRAPH_STROKE = new BasicStroke(2f);
    
    //JPanel jp = new JPanel(new GridLayout(64, 3, 1, 1));
 //   private int x;
   /* static int Picsl1 = 0,Picsl2 = 0,Picsl3 = 0,Picsl4 = 0 ;
    static int x1=0,x2=0,y1=0,y2=0,xs=0,ys=0,xf= 0,yf=0,i=0;
    static int loc1,loc2,loc3;*/
    NodeMaker foR;
    
    display1(NodeMaker result){
        super("Diplay Panel");
        getContentPane().setBackground(Color.black);
       foR=result;
	/*setSize(1000, 800);
	setLocation(200, 50);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	getContentPane().add(jp);
	jp.setBackground(Color.white);
        
        setVisible(true);
        new Test(foR);*/
       Test mainPanel = new Test(foR);
       mainPanel.setPreferredSize(new Dimension(800, 600));
       JFrame frame = new JFrame("DrawGraph");
       
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.getContentPane().add(mainPanel);
     
       frame.pack();
       frame.setLocationRelativeTo(null);
       frame.setVisible(true);

    }

}
class NodeMaker{
	private char element;
	private int exp;
	private double coef;
	private NodeMaker down;
	private NodeMaker next;
	NodeMaker(NodeMaker d,char e,double co,int ex,NodeMaker n){
		this.setDown(d);
		this.setElement(e);
		this.setCoef(co);
		this.setExp(ex);
		this.setNext(n);
	}
	 void setElement(char e){
		 element=e;
	 }
	 void setExp(int exp){
		 this.exp=exp;
	 }
	 void setNext(NodeMaker next){
		 this.next=next;
	 }
	 void setDown(NodeMaker down){
		 this.down=down;
	 }
	 void setCoef(double coef){
		 this.coef=coef;
	 }
	 char getElement(){
		 return element;
	 }
	 int getExp(){
		 return exp;
	 }
	 NodeMaker getNext(){
		 return next;
	 }
	 NodeMaker getDown(){
		 return down;
	 }
	 double getCoef(){
		 return coef;
	 }
	  static void insertAfter(NodeMaker first,NodeMaker newOne){
		 first.setNext(newOne);
	 }
}
class Worker{
	 static NodeMaker zCreator(StringBuilder strequ,int countopen,int countclose){
		int flag=0;
		//System.out.println(strequ.length());
		NodeMaker foz=new NodeMaker(null,'z',0,-1,null);
		for(int i=0;i<strequ.length();i++){
			//System.out.println(o);
			if(strequ.charAt(i)=='(')
				countopen++;
			else if(strequ.charAt(i)==')')
				countclose++;
			if(countopen==countclose){
				//System.out.println(i);
				i++;
				//System.out.println(i);
				if(i>=strequ.length()){
					if(strequ.charAt(i-1)==')'){
						//System.out.println(strequ.charAt(i-1));
					strequ.setCharAt(i-1, '/');
					//System.out.println(strequ.charAt(i-1));
					NodeMaker foy=new NodeMaker(null,'y',0,-1,null);
					NodeMaker temp=new NodeMaker(foy,'0',-9999.0,0,foz.getNext());
					foz.setNext(temp);
					foy=yCreator(foy,strequ, flag, 0, 0);
					break;
					}
				}
				else if(i+1>=strequ.length()){
					if(strequ.charAt(i-1)==')'){
						//System.out.println(strequ.charAt(i-1));
					strequ.setCharAt(i-1, '/');
					//System.out.println(strequ.charAt(i-1));
					NodeMaker foy=new NodeMaker(null,'y',0,-1,null);
					NodeMaker temp=new NodeMaker(foy,'0',-9999.0,1,foz.getNext());
					foz.setNext(temp);
					foy=yCreator(foy,strequ, flag, 0, 0);
					break;
					}
					else{
						NodeMaker foy=new NodeMaker(null,'y',0,-1,null);
						NodeMaker temp=new NodeMaker(foy,'0',-9999.0,1,foz.getNext());
						foz.setNext(temp);
						foy=yCreator(foy,strequ, flag, 0, 0);
						break;
					}
				}
				else{
				if(strequ.charAt(i)=='z'){
					strequ.setCharAt(i-1, '/');
					if(strequ.charAt(i+1)=='^'){
						NodeMaker foy=new NodeMaker(null,'y',0,-1,null);
	
						NodeMaker temp=new NodeMaker(foy,'0',-9999.0,isDigit(strequ, i+2),foz.getNext());
						foz.setNext(temp);
						foy=yCreator(foy,strequ, flag, 0, 0);
						i+=2;
						flag=i+2;
					}
					else if(strequ.charAt(i+1)=='+'){
						NodeMaker foy=new NodeMaker(null,'y',0,-1,null);
						
						NodeMaker temp=new NodeMaker(foy,'0',-9999.0,1,foz.getNext());
						foz.setNext(temp);
						foy=yCreator(foy,strequ, flag, 0, 0);
						i++;
						flag=i+1;
					}	
				}
				else if(strequ.charAt(i)=='+'){
					//System.out.println(strequ.charAt(i-1));
					strequ.setCharAt(i-1, '/');
					//System.out.println(strequ.charAt(i-1));
					NodeMaker foy=new NodeMaker(null,'y',0,-1,null);
					
					NodeMaker temp=new NodeMaker(foy,'0',-9999.0,0,foz.getNext());
					foz.setNext(temp);
					foy=yCreator(foy,strequ, flag, 0, 0);
					flag=i+1;
					//System.out.println('u');
				}
			}
			}
		}
		return foz;
	}
	 static NodeMaker yCreator( NodeMaker foy,StringBuilder strequ,int flag,int countopen,int countclose){
		
		//System.out.println(flag);
		for(int i=flag+1;strequ.charAt(i)!= '/';i++){
			//System.out.println(i);
			if(strequ.charAt(i)=='(')
				countopen++;
			else if(strequ.charAt(i)==')')
				countclose++;
		    if(countopen==countclose){
				i++;
				if(strequ.charAt(i)=='y'){
					strequ.setCharAt(i-1, '/');
					//System.out.println(strequ.charAt(i-1));
					if(strequ.charAt(i+1)=='^'){
						//flag++;
						NodeMaker fox=new NodeMaker(null,'x',0,-1,null);
						
						NodeMaker temp=new NodeMaker(fox,'0',-9999.0,isDigit(strequ, i+2),foy.getNext());
						foy.setNext(temp);
						fox=xCreator( fox,strequ, flag, 0, 0);
						i+=2;
						flag=i;
					}
					else if(strequ.charAt(i+1)=='+'){
						flag++;
						//System.out.println('?');
						NodeMaker fox=new NodeMaker(null,'x',0,-1,null);
						NodeMaker temp=new NodeMaker(fox,'0',-9999.0,1,foy.getNext());
						foy.setNext(temp);
						fox=xCreator( fox,strequ, flag, 0, 0);
						i++;
						flag=i+1;
						//System.out.println(flag);
					}	
				}
				else if(strequ.charAt(i)=='+'){
					int t=i;
					boolean s=false;
					while(strequ.charAt(t)!='/'){
						if(strequ.charAt(t)=='y')
							 s=true;
						t++;
					}
					if(s){
						flag=i+1;
						NodeMaker fox=new NodeMaker(null,'x',0,-1,null);
						
						NodeMaker temp=new NodeMaker(fox,'0',-9999.0,0,foy.getNext());
						foy.setNext(temp);
						fox=yspecial( fox,strequ, flag, 0, 0,i);
					}
					else{
					//System.out.println('?');
					//strequ.setCharAt(i-1, '/');
					NodeMaker fox=new NodeMaker(null,'x',0,-1,null);

					NodeMaker temp=new NodeMaker(fox,'0',-9999.0,0,foy.getNext());
					foy.setNext(temp);
					fox=xCreator( fox,strequ, flag, 0, 0);
					break;
					}
				}
				/*else{
					 if(strequ.charAt(i)=='x'){
						if(strequ.charAt(i+1)=='^')
							NodeMaker.insertAfter(foy,'0',0,-9999.0,yspecial(fox,strequ,flag,0,0,i+3),foy.getNext());
						else
							NodeMaker.insertAfter(foy,'0',0,-9999.0,yspecial(fox,strequ,flag,0,0,i+1),foy.getNext());
					}
				}*/
			}
		}
		//System.out.println('l');
		return foy;
	}
	static NodeMaker xCreator(NodeMaker fox,StringBuilder strequ,int flag,int countopen,int countclose){
		//System.out.println('?');
		
		for(int i=flag+1;strequ.charAt(i)!= '/';i++){
			/*if(strequ.charAt(i)=='/')
				break;*/
			if(strequ.charAt(i)=='(')
				countopen++;
			else if(strequ.charAt(i)==')')
				countclose++;
			if(countopen==countclose){
				i++;
				if(strequ.charAt(i)=='x'){
					if(strequ.charAt(i+1)=='^'){
						//System.out.println('p');
						NodeMaker temp=new NodeMaker(null,'0',isDigitco(strequ, i-2),isDigit(strequ, i+2),fox.getNext());
						fox.setNext(temp);
						//System.out.println('o');
						i+=2;
						//System.out.println(i);
						
					}
					else if(strequ.charAt(i+1)=='+'){
						//System.out.println('o');
						NodeMaker temp=new NodeMaker(null,'0',isDigitco(strequ, i-2),1,fox.getNext());
						fox.setNext(temp);
						//System.out.println('p');
						i+=1;
					}
					else{
						NodeMaker temp=new NodeMaker(null,'0',isDigitco(strequ, i-2),1,fox.getNext());
						 fox.setNext(temp);
					}
				}
				else if(strequ.charAt(i)=='+'){
					NodeMaker temp=new NodeMaker(null,'0',isDigitco(strequ, i-2),0,fox.getNext());
					fox.setNext(temp);
					//System.out.println('?');
				}
			}
		}

		return fox;
	}
	static NodeMaker yspecial( NodeMaker fox,StringBuilder strequ,int flag,int countopen,int countclose,int end){
		for(int i=flag+1;i<end;i++){
			/*if(strequ.charAt(i)=='/')
				break;*/
			if(strequ.charAt(i)=='(')
				countopen++;
			else if(strequ.charAt(i)==')')
				countclose++;
			if(countopen==countclose){
				i++;
				if(strequ.charAt(i)=='x'){
					if(strequ.charAt(i+1)=='^'){
						//System.out.println('p');
						NodeMaker temp=new NodeMaker(fox,'0',isDigitco(strequ, i-2),isDigit(strequ, i+2),fox.getNext());
						NodeMaker.insertAfter(fox,temp);
						//System.out.println('o');
						i+=2;
						//System.out.println(i);
						
					}
					else if(strequ.charAt(i+1)=='+'){
						NodeMaker temp=new NodeMaker(fox,'0',isDigitco(strequ, i-2),1,fox.getNext());
						NodeMaker.insertAfter(fox,temp);
					}	
				}
				else if(strequ.charAt(i)=='+'){
					NodeMaker temp=new NodeMaker(fox,'0',isDigitco(strequ, i-2),0,fox.getNext());
					NodeMaker.insertAfter(fox,temp);
					//System.out.println('?');
				}
			}
		}

		return fox;
	}
	 static int isDigit(StringBuilder strequ,int bindex){
		int i =bindex;
		if(i+1>=strequ.length()){
			return Character.getNumericValue(strequ.charAt(bindex));
		}
		while(true){
			if(i+1>=strequ.length())
				break;
			if(strequ.charAt(i+1)=='+'||strequ.charAt(i+1)==')'||strequ.charAt(i+1)=='/')
				break;
			else
				i++;
		}
		if(bindex==i){
			//System.out.println(Character.getNumericValue(strequ.charAt(bindex)));
			return Character.getNumericValue(strequ.charAt(bindex));
		}
		else{
			int x=0;
			int p=i-bindex;
			while(p>=0){
				x+=Character.getNumericValue(strequ.charAt(bindex))* Math.pow(10,p);
				bindex++;
				p--;
			}
			System.out.println(x);
			return x;
		}
	}
	 static double isDigitco(StringBuilder strequ,int bindex){
		int i=bindex,dindex=0;
		boolean s=false;
		while(true){
			if(strequ.charAt(i-1)=='(')
				break;
			if(strequ.charAt(i-1)=='-'){
				s=true;
				break;
			}
			else if(strequ.charAt(i)=='.')
				dindex=i;
			i--;
		}
		if(bindex==i){
			//System.out.println(Double.parseDouble(Character.toString(strequ.charAt(bindex))));
			if(s)
			return -1*(Double.parseDouble(Character.toString(strequ.charAt(bindex))));
			else
				return (Double.parseDouble(Character.toString(strequ.charAt(bindex))));
		}
		else{
			if(dindex!=0){
				int p=dindex-i;
				int pd=bindex-dindex;
				double x=0;
				while(p>=0){
					x+=Character.getNumericValue(strequ.charAt(i))*Math.pow(10, p);
					p--;
					i++;
				}
				while(pd>=0){
					x+=Double.parseDouble(Character.toString(strequ.charAt(dindex)))*Math.pow(10, -pd);
					dindex++;
					pd--;
				}
				if(s)
				return -1*x;
				else
					return x;
			}
			else{
				double x=0;
				int p=bindex-i;
				while(p>=0){
					x+=Character.getNumericValue(strequ.charAt(i))*Math.pow(10, p);
					p--;
					i++;
				}
				if(s)
				return -1*x;
				else
					return x;
			}
		}
	}
}
class Calculate{
	static NodeMaker add(NodeMaker r1,NodeMaker r2){
		//System.out.println("Hi");
		NodeMaker foR=new NodeMaker(null,'z',0,-1,null);
		NodeMaker first=foR;
		while(r1!=null&& r2!=null){
			if(r1!=null && r2!=null){
			if(r1.getExp()==r2.getExp()){
				//System.out.println("Hio");
				NodeMaker foyr=new NodeMaker(null,'y',0,-1,null);
				NodeMaker temp= new NodeMaker(foyr,'0',-9999.0,r1.getExp(),foR.getNext());
				foR.setNext(temp);
				foR=foR.getNext();
				NodeMaker rny1,rny2;
				//System.out.println(r1.getElement());
				rny1=r1.getDown(); rny2=r2.getDown();
				rny1=rny1.getNext(); rny2=rny2.getNext();
				while(rny1!= null && rny2!= null){
					//System.out.println("Hip");
					if(rny1.getExp()==rny2.getExp()){
						NodeMaker foxr=new NodeMaker(null,'x',0,-1,null);
						NodeMaker temp1= new NodeMaker(foxr,'0',-9999.0,rny1.getExp(),foyr.getNext());
						foyr.setNext(temp1);
						foyr=foyr.getNext();
						NodeMaker rx1,rx2;
						rx1=rny1.getDown(); rx2=rny2.getDown();
						rx1=rx1.getNext(); rx2=rx2.getNext();
						while(rx1!=null && rx2!=null){
							//System.out.println("pop");
							if(rx1.getExp()==rx2.getExp()){
								NodeMaker temp2= new NodeMaker(null,'0',rx1.getCoef()+rx2.getCoef(),rx1.getExp(),foxr.getNext());
								foxr.setNext(temp2);
								foxr=foxr.getNext();
								rx1=rx1.getNext(); rx2=rx2.getNext();
							}
							else if(rx1.getExp()>rx2.getExp()){
								NodeMaker temp2= new NodeMaker(null,'0',rx1.getCoef(),rx1.getExp(),foxr.getNext());
								foxr.setNext(temp2);
								foxr=foxr.getNext();
								
								rx1=rx1.getNext();
							}
							else{
								NodeMaker temp2= new NodeMaker(null,'0',rx2.getCoef(),rx2.getExp(),foxr.getNext());
								foxr.setNext(temp2);
								foxr=foxr.getNext();
								
								rx2=rx2.getNext();
							}
						}
						rny1=rny1.getNext(); rny2=rny2.getNext();
					}
					else if(rny1.getExp()>rny2.getExp()){
						NodeMaker temp1= new NodeMaker(rny1.getDown(),'0',-9999.0,rny1.getExp(),foyr.getNext());
						foyr.setNext(temp1);
						foyr=foyr.getNext();
						
						rny1=rny1.getNext();
					}
					else{
						NodeMaker temp1= new NodeMaker(rny2.getDown(),'0',-9999.0,rny2.getExp(),foyr.getNext());
						foyr.setNext(temp1);
						foyr=foyr.getNext();
						
						rny2=rny2.getNext();
					}
				}
				r1=r1.getNext(); r2=r2.getNext();
			}
			else if(r1.getExp()>r2.getExp()){
				NodeMaker temp= new NodeMaker(r1.getDown(),'0',-9999.0,r1.getExp(),foR.getNext());
				foR.setNext(temp);
				foR=foR.getNext();
			
				r1=r1.getNext();
			}
			else{
				NodeMaker temp= new NodeMaker(r2.getDown(),'0',-9999.0,r2.getExp(),foR.getNext());
				foR.setNext(temp);
				foR=foR.getNext();
				
				r2=r2.getNext();
			}
		}
		else if(r2==null){
				NodeMaker temp= new NodeMaker(r1.getDown(),'0',-9999.0,r1.getExp(),foR.getNext());
				foR.setNext(temp);
				foR=foR.getNext();
				r1=r1.getNext();
			}

		}
		if(r2!=null){
			while(r2!=null){
				NodeMaker temp= new NodeMaker(r2.getDown(),'0',-9999.0,r2.getExp(),foR.getNext());
				foR.setNext(temp);
				foR=foR.getNext();
			
				r2=r2.getNext();
			}
		}
		return first;
	}
	static NodeMaker multiPly(NodeMaker r1, NodeMaker r2){
		//System.out.println("Hi");
		NodeMaker rn2=r2;
		NodeMaker foR=new NodeMaker(null,'z',0,-1,null);
		NodeMaker first=foR;
		while(r1!=null){
			System.out.println("Hi");
			while(rn2!=null){
				NodeMaker foyr=new NodeMaker(null,'y',0,-1,null);
				NodeMaker temp=new NodeMaker(foyr,'0',-9999.0,r1.getExp()+rn2.getExp(),foR.getNext());
				foR.setNext(temp);
				foR=foR.getNext();
				NodeMaker ry1,ry2,rny2;
				ry1=r1.getDown(); ry2=rn2.getDown();
				ry1=ry1.getNext(); rny2=ry2.getNext();
				while(ry1!=null){
					while(rny2!=null){
						NodeMaker foxr=new NodeMaker(null,'x',0,-1,null);
						NodeMaker temp1=new NodeMaker(foxr,'0',-9999.0,ry1.getExp()+rny2.getExp(),foyr.getNext());
						foyr.setNext(temp1);
						foyr=foyr.getNext();
						NodeMaker rx1,rx2,rnx2;
						rx1=ry1.getDown(); rx2=rny2.getDown();
						rx1=rx1.getNext(); rnx2=rx2.getNext();
						while(rx1!=null){
							while(rnx2!=null){
								NodeMaker temp2=new NodeMaker(null,'0',rx1.getCoef()*rnx2.getCoef(),rx1.getExp()+rnx2.getExp(),foxr.getNext());
								foxr.setNext(temp2);
								foxr=foxr.getNext();
								rnx2=rnx2.getNext();
							}
							rx1=rx1.getNext();
							rnx2=rx2.getNext();
						}
						rny2=rny2.getNext();
					}
					ry1=ry1.getNext();
					rny2=ry2.getNext();
				}
				rn2=rn2.getNext();	
			}
			r1=r1.getNext();
			rn2=r2;
		}
		//System.out.println(first.getNext().getExp());
		return sort(first);
	}
	static NodeMaker sort(NodeMaker first){
		//System.out.println("Hish");
		NodeMaker p=first,q=first.getNext();
		q=q.getNext(); p=p.getNext();
		while(p!=null){
			System.out.println("Hi");
			if(q!=null){
				NodeMaker qy,py;
				py=p.getDown(); qy=py.getNext();
				py=py.getNext(); qy=qy.getNext();
				while(py!=null){
					//System.out.println("p");
					if(qy!=null){
						NodeMaker px,qx;
						px=py.getDown(); qx=px.getNext();
						px=px.getNext(); qx=qx.getNext();
						while(qx!= null){
								if(qx.getExp()>px.getExp()){
									int tempexp=qx.getExp();
									qx.setExp(px.getExp());
									px.setExp(tempexp);
									double tempcoef=qx.getCoef();
									qx.setCoef(px.getCoef());
									px.setCoef(tempcoef);
								}
								else if(qx.getExp()==px.getExp()){
									px.setNext(qx.getNext());
									px.setCoef(qx.getCoef()+px.getCoef());
									qx.setNext(null);
									qx=px.getNext();
									continue;
								}
								qx=qx.getNext(); px=px.getNext();
							
						}
						if(qy.getExp()>py.getExp()){
							int tempexp=qy.getExp();
							qy.setExp(py.getExp());
							py.setExp(tempexp);
						}
						qy=qy.getNext(); py=py.getNext();
					}
					else if(qy==null){
						NodeMaker px,qx;
						px=py.getDown(); qx=px.getNext();
						px=px.getNext(); qx=qx.getNext();
						while(px!= null){
							System.out.println("o");
							if(qx==null)
								break;
								if(qx.getExp()>px.getExp()){
									System.out.println("i");
									int tempexp=qx.getExp();
									qx.setExp(px.getExp());
									px.setExp(tempexp);
									double tempcoef=qx.getCoef();
									qx.setCoef(px.getCoef());
									px.setCoef(tempcoef);
								}
								else if(qx.getExp()==px.getExp()){
									
									px.setNext(qx.getNext());
									px.setCoef(qx.getCoef()+px.getCoef());
									qx.setNext(null);
									qx=px.getNext();
									//continue;
								}
								System.out.println("oo");
								qx=qx.getNext(); px=px.getNext();
							
						}
						py=py.getNext();
					}
					 
				}
				if(q.getExp()>p.getExp()){
					int tempexp=q.getExp();
					q.setExp(p.getExp());
					p.setExp(tempexp);
				}
				q=q.getNext(); p=p.getNext();
			}
			else if(q==null){
				NodeMaker qy,py;
				py=p.getDown(); qy=py.getNext();
				py=py.getNext(); qy=qy.getNext();
				while(py!=null){
					if(qy!=null){
						NodeMaker px,qx;
						px=py.getDown(); qx=px.getNext();
						px=px.getNext(); qx=qx.getNext();
						while(qx!= null){
								if(qx.getExp()>px.getExp()){
									int tempexp=qx.getExp();
									qx.setExp(px.getExp());
									px.setExp(tempexp);
									double tempcoef=qx.getCoef();
									qx.setCoef(px.getCoef());
									px.setCoef(tempcoef);
								}
								else if(qx.getExp()==px.getExp()){
									px.setNext(qx.getNext());
									px.setCoef(qx.getCoef()+px.getCoef());
									qx.setNext(null);
									qx=px.getNext();
									continue;
								}
								qx=qx.getNext(); px=px.getNext();
							
						}
						if(qy.getExp()>py.getExp()){
							int tempexp=qy.getExp();
							qy.setExp(py.getExp());
							py.setExp(tempexp);
						}
						qy=qy.getNext(); py=py.getNext();
					}
					else if(qy==null){
						NodeMaker px,qx;
						px=py.getDown(); qx=px.getNext();
						px=px.getNext(); qx=qx.getNext();
						while(qx!= null){
								if(qx.getExp()>px.getExp()){
									int tempexp=qx.getExp();
									qx.setExp(px.getExp());
									px.setExp(tempexp);
									double tempcoef=qx.getCoef();
									qx.setCoef(px.getCoef());
									px.setCoef(tempcoef);
								}
								else if(qx.getExp()==px.getExp()){
									px.setNext(qx.getNext());
									px.setCoef(qx.getCoef()+px.getCoef());
									qx.setNext(null);
									qx=px.getNext();
									continue;
								}
								qx=qx.getNext(); px=px.getNext();
							
						}
						py=py.getNext();
					}
					 
				}
				p=p.getNext();
			}
			 
		}
		//System.out.println("Hosh");
		return first;

	}
	static void print(NodeMaker first,JTextField T1){
		int countclose=0;
		String result="->  ";
		NodeMaker r2=first.getNext();
		while(r2!=null){
			if(r2.getExp()==0){
				result=result+'(';
				countclose++;
			}
			else if(r2.getExp()==1){
				result=result+first.getElement();
				result=result+'(';
				countclose++;
			}
			else{
				result=result+first.getElement();
				result=result+'^';
				result=result+((char)(r2.getExp()+'0'));
				result=result+'(';
				/*T1.setText(Character.toString(first.getElement()));
				T1.setText(Character.toString('^'));
				T1.setText(Character.toString((char)(r2.getExp()+'0')));
				T1.setText(Character.toString('('));*/
				countclose++;
			}
			NodeMaker ry,rny1;
			ry=r2.getDown(); rny1=ry.getNext();
			while(rny1!=null){
				if(rny1.getExp()==1){
					result=result+ry.getElement();
					result=result+'(';
					/*T1.setText(Character.toString(ry.getElement()));
					T1.setText(Character.toString('('));*/
					countclose++;
				}
				else if(rny1.getExp()>1){
					result=result+ry.getElement();
					result=result+'^';
					result=result+((char)(rny1.getExp()+'0'));
					result=result+'(';
					/*T1.setText(Character.toString(ry.getElement()));
					T1.setText(Character.toString('^'));
					T1.setText(Character.toString((char)(rny1.getExp()+'0')));
					T1.setText(Character.toString('('));*/
					countclose++;
				}
				NodeMaker rx,rnx;
				rx=rny1.getDown(); rnx=rx.getNext();
				while(rnx!=null){
					if(rnx.getExp()==0){
						result=result+'(';
						result=result+String.valueOf(rnx.getCoef());
						result=result+')';
						/*T1.setText(Character.toString('('));
						T1.setText(String.valueOf(rnx.getCoef()));
						T1.setText(Character.toString(')'));*/
					}
					else if(rnx.getExp()==1){
						result=result+rx.getElement();
						result=result+'(';
						result=result+String.valueOf(rnx.getCoef());
						result=result+')';
						/*T1.setText(Character.toString(rx.getElement()));
						T1.setText(Character.toString('('));
						T1.setText(String.valueOf(rnx.getCoef()));
						T1.setText(Character.toString(')'));*/
					}
					else{
						result=result+rx.getElement();
						result=result+'^';
						result=result+((char)(rnx.getExp()+'0'));
						result=result+'(';
						result=result+String.valueOf(rnx.getCoef());
						result=result+')';
						/*T1.setText(Character.toString(rx.getElement()));
						T1.setText(Character.toString('^'));
						T1.setText(Character.toString((char)(rnx.getExp()+'0')));
						T1.setText(Character.toString('('));
						T1.setText(String.valueOf(rnx.getCoef()));
						T1.setText(Character.toString(')'));*/
					}
					rnx=rnx.getNext();
					if(rnx!=null)
						result=result+'+';
						//T1.setText(Character.toString('+'));
				}
				
				rny1=rny1.getNext();
				if(rny1!=null)
					result=result+'+';
					//T1.setText(Character.toString('+'));
			}
			r2=r2.getNext();
			while(countclose!=0){
				result=result+')';
				//T1.setText(Character.toString(')'));
				countclose--;
			}
			if(r2!=null)
				result=result+'+';
				//T1.setText(Character.toString('+'));
			
		}
		T1.setText(result);
	}
}
public class EquationStructure{
	public static void main(String[] args){
		//Scanner input=new Scanner(System.in);
		//String parEqu1,parEqu2;
		//parEqu1=input.nextLine();
		 new Input();
		 
		/*StringBuilder strequ1 = new StringBuilder(parEqu1);
		NodeMaker rz1=Worker.zCreator(strequ1,0,0);
		parEqu2=input.nextLine();
		StringBuilder strequ2 = new StringBuilder(parEqu2);
		NodeMaker rz2=Worker.zCreator(strequ2,0,0);
		//System.out.println(rz1.getNext().getExp());
		NodeMaker r1=rz1.getNext();
		NodeMaker r2=rz2.getNext();
		NodeMaker addResult=Calculate.add(r1, r2);
		NodeMaker multiplyResult=Calculate.multiPly(r1, r2);*/
		//System.out.println(multiplyResult.getNext().getExp());
		 // new Input();
		//System.out.println(addResult.getNext().getDown().getNext().getDown().getNext().getCoef());
		//System.out.println("Hi");
		
		
	}
		
	}
