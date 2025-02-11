package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	
	// face, mouth, lEye/rEye, nose, lEar/rEar/cEar
	private static String generateOutputCss(String input) {
		String ans = "";
		
		String allNamesString = input.replace("/", ", ");
		List<String> allNames = Arrays.asList(allNamesString.split(", "));
		
		List<String> groupedNames = Arrays.asList(input.split(", "));
		
		List<String> finalTokens = new ArrayList<String>();
		for(int i=0;i<groupedNames.size();++i) {
			List<String> tmp = Arrays.asList(groupedNames.get(i).split("/"));
			System.out.println(tmp);
			if(tmp.size() == 1) {
				finalTokens.add("[" + tmp.get(0) + "]");
			} else {
				for(int j=0;j<tmp.size();++j) {
					String currentToken = "";
					for(int k=j;k<tmp.size();++k) {
						currentToken += "[" + tmp.get(k) + "], ";
					}
					finalTokens.add(currentToken.substring(0, currentToken.length()-2));
				}
			}
		}
		System.out.println(finalTokens);
				
		// HTML elements
		for(int i=0;i<allNames.size();++i) {
			ans += "<p " + allNames.get(i) + "></p>";
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
		for(int i=0;i<finalTokens.size();++i) {
			ans += "    " + finalTokens.get(i) + " {\n";
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