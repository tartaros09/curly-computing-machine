package gui;
import java.awt.Dialog;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import util.GuiComponentFactory;

public class AboutGui extends JDialog
{
	private static final long serialVersionUID = 1L;
	private JButton okButton;
	
	/******************************  ******************************/
	
	/**
	 * constructor
	 */
	public AboutGui(JFrame parent) {
		super(parent, "About", Dialog.ModalityType.APPLICATION_MODAL); {
			JPanel wrapper = new JPanel();
			wrapper.setBorder(GuiComponentFactory.emptyBorder);
			wrapper.setLayout(new BoxLayout(wrapper, BoxLayout.Y_AXIS)); {

				// Label Panel
				JPanel labelPanel = new JPanel();
				labelPanel.setLayout(new GridLayout(0, 1)); {
					labelPanel.add(new JLabel("CTPR Score Tracker Application."));
					labelPanel.add(new JLabel(""));
					labelPanel.add(new JLabel("Created by S"));
				}
				wrapper.add(labelPanel);
				
				// Button Panel
				JPanel buttonPanel = new JPanel();
				buttonPanel.setBorder(GuiComponentFactory.largeTopSpacerBorder);
				buttonPanel.setLayout(new GridLayout(1, 1)); {
					okButton = new JButton("OK");
					okButton.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							setVisible(false);
							dispose();
						}
					});
					buttonPanel.add(okButton);
				}
				wrapper.add(buttonPanel);
			}
			this.add(wrapper);
		}
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	/******************************  ******************************/
	
	/**
	 * @description main function for local testing
	 */
	public static void main(String[] args) {
		
	}
}