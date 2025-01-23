package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

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
		mainFrame = new JFrame("CTPR Score Tracker"); {
			
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
			
			// Textfields
			JPanel textFieldPanel = new JPanel();
			textFieldPanel.setLayout(new BoxLayout(textFieldPanel, BoxLayout.Y_AXIS)); {
				
				// Input field
				JPanel namePanel = new JPanel();
				namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.X_AXIS)); {
					inputArea = new JTextArea(20, 30);
					namePanel.add(inputArea);
				}
				textFieldPanel.add(namePanel);

				// Convert button
				convertButton = new JButton("Calculate Scores");
				convertButton.setPreferredSize(new Dimension(80, 40));
				convertButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {

					}
				});
				textFieldPanel.add(convertButton);				

				// Output field
				JPanel urlPanel = new JPanel();
				urlPanel.setLayout(new BoxLayout(urlPanel, BoxLayout.X_AXIS)); {
					outputArea = new JTextArea(20, 30);
					urlPanel.add(outputArea);
				}
				textFieldPanel.add(urlPanel);
			}
			ans.add(textFieldPanel);			
		}
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