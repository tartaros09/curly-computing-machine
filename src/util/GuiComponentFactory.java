package util;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class GuiComponentFactory
{
	public static Border emptyBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
	public static Border largeTopSpacerBorder = BorderFactory.createEmptyBorder(15, 2, 2, 2);
	public static Border insideLineBorder = BorderFactory.createCompoundBorder(
			emptyBorder,
			BorderFactory.createLineBorder(Color.BLACK, 2));
	
	// Create custom colored borders
	public static Border borderForStyle = BorderFactory.createCompoundBorder(
			emptyBorder,
			BorderFactory.createLineBorder(new Color(255, 51, 153), 2));
	
	public static Border borderForContent = BorderFactory.createCompoundBorder(
			emptyBorder,
			BorderFactory.createLineBorder(new Color(227, 108, 9), 2));

	public static Border borderForOriginality = BorderFactory.createCompoundBorder(
			emptyBorder,
			BorderFactory.createLineBorder(new Color(0, 176, 80), 2));

	public static Border borderForReach = BorderFactory.createCompoundBorder(
			emptyBorder,
			BorderFactory.createLineBorder(new Color(0, 176, 240), 2));

	public static Border borderForEngagement = BorderFactory.createCompoundBorder(
			emptyBorder,
			BorderFactory.createLineBorder(new Color(112, 48, 160), 2));
	
	public static Border borderForComments = BorderFactory.createCompoundBorder(
			emptyBorder,
			BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2),
					"Comments"));
}