import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

/**
 * Show - GUI for Linked list demonstration
 */
public class Show extends JFrame implements ActionListener {

    // frame size
    private final int frameWidth = 900;
    private final int frameHeight = 300;

    // message and list object
    private JLabel result = new JLabel("nothing picked yet");
    private JLabel message = new JLabel(" ");
    private SL theList = new SL(message);

    // menu items
    private JMenuItem add = new JMenuItem("add");
    private JMenuItem length = new JMenuItem("length");
    private JMenuItem clear	= new JMenuItem("clear");
    private JMenuItem valueAt = new JMenuItem("valueAt");
    private JMenuItem positionsOf = new JMenuItem("positionsOf");
    private JMenuItem omit = new JMenuItem("omit");
    private JMenuItem shuffle = new JMenuItem("shuffle");
    private JMenuItem move = new JMenuItem("move");

    // constants
    public static final int VAL = 1;
    public static final int POS = 2;
    public static final int BOTH = 3;

    // information for list operations
    private int value;
    private int position;
    private boolean cancel;

    /**
     * Subclass of SpecialList that displays the list.
     */
    private class SL extends SpecialList {

	// properties
	private JLabel message;
	private Vector<Node> nodes = new Vector<Node>();

	/**
	 * Set things up.
	 */
	public SL(JLabel m) {

	    message = m;
	    setBackground(Color.white);
	    } // end of constructor

	/**
	 * Add a value to the list.
	 *
	 * @param pos The position.
	 * @param value The value to be added.
	 */
	public void add(int pos, int value) {

	    super.add(pos, value);
	    repaint();
	    } // end of add method

	/**
	 * Get the current length of the list.
	 *
	 * @return  The current length.
	 */
	public int length() {

	    return super.length();
	    } // end of length method

	/**
	 * Remove all values from the list.
	 */
	public void clear() {

	    super.clear();
	    repaint();
	    } // end of clear method

	/**
	 * Get the value at the given position.
	 *
	 * @param pos The position to get the value from.
	 *
	 * @return The value at the given position.
	 */
	public int valueAt(int pos) {

	    return super.valueAt(pos);
	    } // end of valueAt method

	/**
	 * Get the positions of a given value.
	 *
	 * @param value The value to look for.
	 *
	 * @return The positions.
	 */
	public Vector<Integer> positionsOf(int value) {

	    return super.positionsOf(value);
	    } // end of positionsOf method

	/**
	 * Remove a value at the given position.
	 *
	 * @param pos The position.
	 */
	public void omit(int pos) {

	    super.omit(pos);
	    repaint();
	    } // end of omit method

	/**
	 * Shuffle the list.
	 */
	public void shuffle() {

	    super.shuffle();
	    repaint();
	    } // end of shuffle method

	/**
	 * Move the largest value to the end.
	 */
	public void move() {

	    super.move();
	    repaint();
	    } // end of shuffle method

	/**
	 * Convert the list into a string.
	 */
	public String toString() {

	    String result = "[";
	    Node here = first;
	    while (here != null) {
		if (here != first)
		    result += ",";
		result += here.getValue();
		here = here.getNext();
		}
	    result += "]";
	    return result;
	    } // end of toString method

	/**
	 * Draw the linked list.
	 *
	 * @param g The Graphics object to draw with.
	 */
	public final void paintComponent(Graphics g) {

	    super.paintComponent(g);

	    // draw the first reference
	    drawFirst(10,10,g);

	    // initialize for loop
	    int x = 10;
	    Node here = first;
	    nodes.clear();

	    // for each node...
	    while (here != null) {

		// add node to drawn list
		nodes.add(here);

		// draw the node
		drawNode(here,x,70,g);

		// advance to the next node (unless already drawn)
		here = here.getNext();
		if (here != null && nodes.contains(here)) {
		    message.setBackground(Color.pink);
		    message.setText("ERROR: cycle in node list");
		    here = null;
		    }

		// advance drawing position
		x += 90;
		}
	    } // end of paintComponent method

	/**
	 * Draw the first node and pointer.
	 *
	 * @param x The left edge of the box.
	 * @param y The top of the label over the box.
	 * @param g The Graphics object to draw with.
	 */
	private final void drawFirst(int x, int y, Graphics g) {

	    // draw the box
	    g.setColor(Color.black);
	    g.drawRect(x,y+10,50,20);

	    // label the box
	    g.drawString("first",x,y+10);

	    // draw an arrow or null
	    if (first == null) {
		g.drawLine(x,y+30,x+50,y+10);
		}
	    else {
		g.drawLine(x+25,y+20,x+25,y+50);
		g.drawLine(x+25,y+50,x+22,y+42);
		g.drawLine(x+25,y+50,x+28,y+42);
		}
	    } // end of drawFirst method

	/**
	 * Draw a node and pointer.
	 *
	 * @param n The node to draw.
	 * @param x The left edge of the node.
	 * @param y The top edge of the node.
	 * @param g The Graphics object to draw with.
	 */
	private final void drawNode(Node n, int x, int y, Graphics g) {

	    // draw the front face
	    g.setColor(new Color(0xe0,0xe0,0xff));
	    g.fillRect(x,y,60,100);

	    // draw the receding faces
	    Polygon border = new Polygon();
	    border.addPoint(x,y);
	    border.addPoint(x+10,y-10);
	    border.addPoint(x+70,y-10);
	    border.addPoint(x+70,y+90);
	    border.addPoint(x+60,y+100);
	    border.addPoint(x+60,y);
	    g.setColor(new Color(0xd0,0xd0,0xff));
	    g.fillPolygon(border);

	    // draw borders
	    g.setColor(Color.black);
	    g.drawPolygon(border);
	    g.drawRect(x,y,60,100);
	    g.drawLine(x+60,y,x+70,y-10);

	    // label the node
	    g.drawString("Node",x+20,y);

	    // draw the two instance variable boxes with borders
	    g.setColor(Color.white);
	    g.fillRect(x+5,y+25,50,20);
	    g.fillRect(x+5,y+70,50,20);
	    g.setColor(Color.black);
	    g.drawRect(x+5,y+25,50,20);
	    g.drawRect(x+5,y+70,50,20);

	    // label the instance variables
	    g.drawString("data",x+5,y+23);
	    g.drawString("next",x+5,y+67);

	    // put the value in the data variable
	    g.drawString(""+n.getValue(),x+10,y+40);

	    // draw an arrow to the next Node (or null)
	    Node next = n.getNext();
	    if (next == null) {
		g.drawLine(x+5,y+90,x+55,y+70);
		}
	    else if (nodes.contains(next)) {
		int where = nodes.indexOf(next);
		g.setColor(Color.red);
		g.drawLine(x+30,y+80,x+30,y+110);
		g.drawLine(x+30,y+110,where*90+50,y+110);
		g.drawLine(where*90+50,y+110,where*90+50,y+100);
		g.drawLine(where*90+50,y+100,where*90+47,y+107);
		g.drawLine(where*90+50,y+100,where*90+53,y+107);
		}
	    else {
		g.drawLine(x+30,y+80,x+90,y+80);
		g.drawLine(x+90,y+80,x+83,y+77);
		g.drawLine(x+90,y+80,x+83,y+83);
		}
	    } // end of drawNode method

	} // end of SL class

    /**
     * Dialog for getting value and position.
     */
    private class ListDialog extends JDialog implements ActionListener {

	// GUI stuff
	private JTextField valText = new JTextField(10);
	private JTextField posText = new JTextField(10);

	// properties
	Show frame;
	int type;

	/**
	 * Create GUI.
	 */
	public ListDialog(Show f, String operation,int type) {

	    // set title, etc.
	    super(f,operation,true);

	    // save stuff
	    frame = f;
	    this.type = type;

	    // set up GUI
	    Container window = getContentPane();
	    if (type == Show.VAL) {
		window.setLayout(new GridLayout(1,2));
		window.add(new JLabel("value: ",SwingConstants.RIGHT));
		window.add(valText);
		}
	    else if (type == Show.POS) {
		window.setLayout(new GridLayout(1,2));
		window.add(new JLabel("position: ",SwingConstants.RIGHT));
		window.add(posText);
		}
	    else { // BOTH
		window.setLayout(new GridLayout(2,2));
		window.add(new JLabel("position: ",SwingConstants.RIGHT));
		window.add(posText);
		window.add(new JLabel("value: ",SwingConstants.RIGHT));
		window.add(valText);
		}

	    // add listeners
	    valText.addActionListener(this);
	    posText.addActionListener(this);

	    // set cancel as default
	    frame.setInfo(0,0,true);

	    // finish up
	    pack();
	    setLocation(200,200);
	    setVisible(true);
	    } // end of constructor

	/**
	 * React to numbers being entered.
	 *
	 * @param event The event object for the action.
	 */
	public void actionPerformed(ActionEvent event) {

	    // if just value expected
	    if (type == Show.VAL) {
		if (!ok(valText.getText(),"value")) {
		    frame.setInfo(0,0,true);
		    return;
		    }
		frame.setInfo(Integer.parseInt(valText.getText()),0,false);
		}

	    // if just position expected
	    else if (type == Show.POS) {
		if (!ok(posText.getText(),"position")) {
		    frame.setInfo(0,0,true);
		    return;
		    }
		frame.setInfo(0,Integer.parseInt(posText.getText()),false);
		}

	    // if both value and position expected
	    else { // BOTH
		if (!ok(posText.getText(),"position")) {
		    frame.setInfo(0,0,true);
		    return;
		    }
		if (!ok(valText.getText(),"value")) {
		    frame.setInfo(0,0,true);
		    return;
		    }
		frame.setInfo(Integer.parseInt(valText.getText()),
			Integer.parseInt(posText.getText()),false);
		}

	    // clear fields and quit dialog
	    valText.setText("");
	    posText.setText("");
	    dispose();
	    } // end of actionPerformed method

	/**
	 * Check string for a valid number.
	 * Display an error message if not.
	 *
	 * @param num The string to check.
	 * @param field The field being checked.
	 */
	private boolean ok(String num, String field) {

	    try {
		if (num.equals(""))
		    return false;
		Integer.parseInt(num);
		}
	    catch (NumberFormatException ex) {
		JOptionPane.showMessageDialog(this,field +
			": invalid number, try again");
		return false;
		}
	    return true;
	    } // end of ok method

	} // end of ListDialog class

    /**
     * Create Show object.
     *
     * @param args Unused.
     */

    public static void main(String [] args) {

	new Show();
	} // end of main method

    /**
     * Set up GUI.
     */
    public Show() {

	// set frame title
	super("CS1122 Linked-list Tester");

	// set up the menus
	JMenuBar bar = new JMenuBar();
	setJMenuBar(bar);
	JMenu mOptions = new JMenu("Methods");
	bar.add(mOptions);
	mOptions.add(add);
	mOptions.add(length);
	mOptions.add(clear);
	mOptions.add(valueAt);
	mOptions.add(positionsOf);
	mOptions.add(omit);
	mOptions.add(shuffle);
	mOptions.add(move);

	// add actionListeners
	add.addActionListener(this);
	length.addActionListener(this);
	clear.addActionListener(this);
	valueAt.addActionListener(this);
	positionsOf.addActionListener(this);
	omit.addActionListener(this);
	shuffle.addActionListener(this);
	move.addActionListener(this);

	// set up center panel 
	Container window = getContentPane();
	theList.setBackground(Color.white);
	window.add(theList,BorderLayout.CENTER);

	// set up message for result
	JPanel bottom = new JPanel();
	bottom.setLayout(new GridLayout(1,2));
	result.setBackground(Color.cyan);
	result.setOpaque(true);
	message.setBackground(Color.green);
	message.setOpaque(true);
	bottom.add(result);
	bottom.add(message);
	window.add(bottom,BorderLayout.SOUTH);

	// finish up
	setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	setSize(frameWidth,frameHeight);
	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	setLocation(d.width/2-frameWidth/2,d.height/2-frameHeight/2);
	setVisible(true);
	} // end of constructor

    /**
     * React to menu selections.
     *
     * @param event The event object for the action.
     */
    public void actionPerformed(ActionEvent event) {

	// clear stuff
	result.setText(" ");
	message.setBackground(Color.green);
	message.setText(" ");

	// display dialog (if necessary), call method, and then display result
	if(event.getSource() == add){
	    new ListDialog(this,"add",BOTH);
	    if (cancel)
		return;
	    theList.add(position,value);
	    }
	else if(event.getSource() == length){
	    result.setText("Length of the list is "+theList.length());
	    }
	else if(event.getSource() == clear){
	    theList.clear();
	    }
	else if(event.getSource() == valueAt){
	    new ListDialog(this,"valueAt",POS);
	    if (cancel)
		return;
	    result.setText("The value at position " + position + " is " + 
		    theList.valueAt(position));
	    }
	else if(event.getSource() == positionsOf){
	    new ListDialog(this,"positionsOf",VAL);
	    if (cancel)
		return;
	    result.setText(value + " is at the following positions: " +
		    theList.positionsOf(value));
	    }
	else if(event.getSource() == omit){
	    new ListDialog(this,"omit",POS);
	    if (cancel)
		return;
	    theList.omit(position);
	    }
	else if(event.getSource() == shuffle){
	    theList.shuffle();
	    }
	else if(event.getSource() == move){
	    theList.move();
	    }
	else {        
	    System.exit(0);
	    }
	} // end of actionPerformed method

    /**
     * Used by the Dialog to set value and position.
     *
     * @param value The new value.
     * @param position The new position.
     * @param cancel True if dialog cancelled, false otherwise.
     */
    public void setInfo(int value, int position, boolean cancel) {

	this.value = value;
	this.position = position;
	this.cancel = cancel;
	} // end of setInfo method

    } // end of Show class