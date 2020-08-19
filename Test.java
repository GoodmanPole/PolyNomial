import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
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

/**
 *
 * @author "Hovercraft Full of Eels", "Rodrigo Azevedo"
 *
 * This is an improved version of Hovercraft Full of Eels (https://stackoverflow.com/users/522444/hovercraft-full-of-eels)
 * answer on StackOverflow: https://stackoverflow.com/a/8693635/753012
 *
 * GitHub user @maritaria has made some performance improvements which can be found in the comment section of this Gist.
 */
public class Test extends JPanel {
    private int width = 800;
    private int height = 400;
    private int padding = 25;
    private int labelPadding = 25;
    private Color lineColor = new Color(44, 102, 230, 180);
    private Color pointColor = new Color(100, 100, 100, 180);
    private Color gridColor = new Color(200, 200, 200, 200);
    private static final Stroke GRAPH_STROKE = new BasicStroke(2f);
    private int pointWidth = 4;
    private int numberYDivisions = 10;
   // private List<Double> scores;
    private NodeMaker first;
    static int Picsl1 = 0,Picsl2 = 0,Picsl3 = 0,Picsl4 = 0 ;
    static int x1=0,x2=0,y1=0,y2=0,xs=0,ys=0,xf= 0,yf=0,i=0;
    static int loc1,loc2,loc3;

    public Test(NodeMaker first) {
        this.first=first;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


       // create x and y axes 
     //   g2.drawLine(padding + labelPadding, getHeight() - padding - labelPadding, padding + labelPadding, padding);
    //    g2.drawLine(padding + labelPadding, getHeight() - padding - labelPadding, getWidth() - padding, getHeight() - padding - labelPadding);
        NodeMaker r=first;
        Stroke oldStroke = g2.getStroke();
        g2.setColor(lineColor);
        g2.setStroke(GRAPH_STROKE);

        while(r!=null){
        	System.out.print("baby");
            if(r.getElement()!='0'){
        // drawrect
                loc1 = setLocation(r.getElement());
                char a = r.getElement();
                String b = Character.toString(a);
                g2.setStroke(oldStroke);
                g2.setColor(Color.red);
                xs = loc1;
                ys = loc1;
                int H = 35, W = 35;
                g2.setColor(Color.red);
                g2.fillRect(xs, ys, H, W);
                g2.setColor(Color.black);
                g2.drawString(b, xs+10, ys + 20);
                System.out.print("ghjkjkjk");
                
        }
            
        if(r.getCoef()!=-9999.0){
            if(r.getExp()!=-1){
            //drawrectwith line
                loc1=setLocation(r.getElement());
                String s = Integer.toString(r.getExp());
                g2.setStroke(oldStroke);
                g2.setColor(Color.red);
                xf =loc1;
                yf =loc1;
                int H = 35, W = 35;
                g2.setColor(Color.red);
                g2.fillRect(xf, yf,H ,W );
                g2.setColor(Color.black);
                g2.drawString(s, xf+10, yf+20);
                System.out.print("dryiuf");
            }
        }
            if(r.getNext()!=null){
        //drwaline
                
                g2.setColor(Color.BLACK);
                g2.setStroke(GRAPH_STROKE);
                x1 = xs;
                y1 = ys;
                x2 = xf;
                y2 = yf;
                g2.drawLine(x1, y1, x2, y2);
            }
            
            if(r.getDown()!=null){
        //drawline
                
                g2.setColor(Color.BLACK);
                g2.setStroke(GRAPH_STROKE);
                x1 = xs;
                y1 = ys;
                x2 = xs+20;
                y2 = ys-20;
             //   g2.drawLine(x1, y1, x2, y2);
            
            
            NodeMaker ry,ry1;
            ry=r.getDown();
            ry1=ry.getNext();
            while(ry1!=null){
            	System.out.print("baby");
                if(ry.getElement()!='0'){
        // drawrect 
                    loc1 = setLocation(ry.getElement());
                    char a = ry.getElement();
                    String b = Character.toString(a);
                    g2.setStroke(oldStroke);
                    g2.setColor(Color.red);
                    xs =loc1;
                    ys =loc1;
                    int H = 20, W = 20;
                    g2.setColor(Color.red);
                    g2.fillRect(xs, ys, W, H);
                    g2.setColor(Color.black);
                    g2.drawString(b, xs+10, ys+20);
                    System.out.print("sadwwsx");
            }
            if(ry1.getCoef()!=-9999.0){
            if(ry1.getExp()!=-1){
            //drawrectwith line
            	String s = Integer.toString(ry1.getExp());
                g2.setStroke(oldStroke);
                g2.setColor(Color.red);
                xf = 19;
                yf = 29;
                int H = 35, W = 35;
                g2.setColor(Color.red);
                g2.fillRect(xf, yf, W, H);
                g2.setColor(Color.black);
                g2.drawString(s, xf, yf+20);
            }
            }
            if(ry1.getNext()!=null){
        //drwaline
                
                g2.setColor(Color.BLACK);
                g2.setStroke(GRAPH_STROKE);
                x1 = xs;
                y1 = ys;
                x2 = 10;
                y2 = 10;
           //     g2.drawLine(x1, y1, x2, y2);
                
            }
            if(ry1.getDown()!=null){
            NodeMaker rx,rx1;
            rx=ry1.getDown();
            rx1=rx.getNext();
            while(rx1!=null){
            if(rx1.getElement()!='0'){
        // drawrect
                loc1 = setLocation(rx.getElement());
                char a = rx.getElement();
                String b = Character.toString(a);
                g2.setStroke(oldStroke);
                g2.setColor(Color.red);
                xs = loc1;
                ys = loc1;
                int H = 40, W = 40;
                g2.setColor(Color.red);
                g2.fillRect(xs, ys, W, H);
                g2.setColor(Color.black);
                g2.drawString(b, xs, ys+20);
            }
            if(rx1.getCoef()!=-9999.0){
            if(rx1.getExp()!=-1){
            //drawrectwith line
            	String s = Integer.toString(rx1.getExp());
            	String s1 = Double.toString(rx1.getCoef());
                g2.setStroke(oldStroke);
                g2.setColor(Color.red);
                xf = loc1;
                yf = loc1;
                int H = 35, W = 35;
                g2.setColor(Color.red);
                g2.fillRect(xf, yf, W, H);
                g2.setColor(Color.black);
                g2.drawString(s+ " " +s1, xf, yf+20);
            }
            }
            if(rx1.getNext()!=null){
        //drwaline
                
                g2.setColor(Color.BLACK);
                g2.setStroke(GRAPH_STROKE);
                x1 = xs;
                y1 = ys;
                x2 = 10;
                y2 = 10;
           //     g2.drawLine(x1, y1, x2, y2);
            }
            rx1= rx1.getNext();
            }
        }
        ry1=ry1.getNext();
        }
            }
    
    r=r.getNext();
}

    }

//    @Override
//    public Dimension getPreferredSize() {
//        return new Dimension(width, height);
//    }
     static int setLocation(char c) {
        int A =0 ;
        i += 30;
        System.out.print(i);
        if(c == 'z'){
            Picsl1 = 500;
            A = Picsl1+i;
        }
        if(c == 'y'){
            Picsl2 = 600;
            A = Picsl2+i;
        }
        if(c == 'x'){
            Picsl3 = 700 ; 
            A = Picsl3+i;
        }
        if(c == '0'){
            Picsl4  = 1100;
            A = Picsl4+i;
        }
        
        return A;
        
    }
}
    
   /* private static void createAndShowGui(NodeMaker first) {
        Test mainPanel = new Test(first);
        mainPanel.setPreferredSize(new Dimension(800, 600));
        JFrame frame = new JFrame("DrawGraph");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
    	 NodeMaker f;
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui(f);
         }
      });
   }
}*/

