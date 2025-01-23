package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import util.GuiComponentFactory;

/**
 * @author sahil
 * This class describes the primary GUI used for the project.
 * The GUI contains various textfields for data entry of scores
 * and then calculates the averages over each category.
 */
public class MainGui
{
	public JFrame mainFrame;
	
	private JTextArea inputArea;
	private JTextArea outputArea;
	
	private JButton convertButton;
	
	/******************************  ******************************/
	
	/**
	 * constructor
	 */
	public MainGui() {
		mainFrame = new JFrame("CSSB Basic Template Generator"); {
			
			JPanel wrapper = new JPanel();
			wrapper.setBorder(GuiComponentFactory.insideLineBorder);
			wrapper.setLayout(new BoxLayout(wrapper, BoxLayout.X_AXIS)); {
				
				JPanel rightSidePanel = new JPanel();
				rightSidePanel.setBorder(GuiComponentFactory.emptyBorder);
				rightSidePanel.setLayout(new BoxLayout(rightSidePanel, BoxLayout.Y_AXIS)); {

					// Button Panel
					JPanel mainPanel = buildMainPanel();
					rightSidePanel.add(mainPanel);					
				}
				wrapper.add(rightSidePanel);
			}
			mainFrame.add(wrapper);
		}
		mainFrame.setResizable(false);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.pack();
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);		
	}
	
	/******************************  ******************************/
	
	/**
	 * @description build the layout for the button panel.
	 * this function creates, initialises and add all the requisite
	 * elements to the button panels and returns it.
	 */
	private JPanel buildMainPanel() {
		JPanel ans = new JPanel();
		ans.setLayout(new BoxLayout(ans, BoxLayout.Y_AXIS)); {

			inputArea = new JTextArea(20, 30);
			inputArea.setLineWrap(true);
			inputArea.setWrapStyleWord(true);
			ans.add(inputArea);
	
			convertButton = new JButton("Generate CSS Template");
			convertButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					outputArea.setText(generateOutputCss(inputArea.getText()));
				}
			});
			ans.add(convertButton);				
	
			outputArea = new JTextArea(20, 30);
			outputArea.setLineWrap(true);
			outputArea.setWrapStyleWord(true);
			JScrollPane outputScrollPane = new JScrollPane(outputArea);
			outputScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			outputScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			ans.add(outputScrollPane);		
		}
		return ans;
	}
	
	private String generateOutputCss(String input) {
		String ans = "";
		
		String[] elements = input.split(", ");
		
		// HTML elements
		for(int i=0;i<elements.length;++i) {
			ans += "<p " + elements[i] + "></p>";
		}
		ans += "\n";
		
		// Initial text
		ans += "<style>\n";
		ans += "  * {\n";
		ans += "    margin: 0;\n";
		ans += "    position: fixed;\n";
		ans += "    background: ;\n";
		ans += "  }\n";

		// Elements descriptors
		for(int i=0;i<elements.length;++i) {
			ans += "  [" + elements[i] + "] {\n";
			ans += "    margin: ;\n";
			ans += "    height: ;\n";
			ans += "    width: ;\n";
			ans += "    background: ;\n";
			ans += "    /* outline: ; */\n";
			ans += "    /* border-radius: ; */\n";
			ans += "    /* box-shadow: ; */\n";
			ans += "  }\n";
		}		
		ans += "</style>";
		
		return ans;
	}
	
	/******************************  ******************************/
	
	/**
	 * @description main function for local testing.
	 */
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		MainGui gui = new MainGui();
	}
}