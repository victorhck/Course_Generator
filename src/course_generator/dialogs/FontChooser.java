/*
 * Course Generator
 * Copyright (C) 2018 Pierre Delore
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package course_generator.dialogs;

import java.awt.Font;
import java.awt.GraphicsEnvironment;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListModel;

/**
 *
 * @author pierre.delore
 */
public class FontChooser extends javax.swing.JDialog {

	private static final long serialVersionUID = 6219342493247691267L;
	String[] styleList; // = new String[]{"Plain", "Bold", "Italic", "Bold Italic"};
	String[] sizeList = new String[] { "2", "4", "6", "8", "10", "12", "14", "16", "18", "20", "22", "24", "30", "36",
			"48", "72" }; // NOI18N

	String currentFont = null;
	int currentStyle = -1;
	int currentSize = -1;

	public boolean ok = false;
	java.util.ResourceBundle bundle;


	/**
	 * Creates new form FontChooser
	 */
	public FontChooser() {
		initComponents();
		setModal(true);
		bundle = java.util.ResourceBundle.getBundle("course_generator/Bundle"); // NOI18N
		styleList = new String[4];
		styleList[0] = bundle.getString("FontChooser.Plain");
		styleList[1] = bundle.getString("FontChooser.Bold");
		styleList[2] = bundle.getString("FontChooser.Italic");
		styleList[3] = bundle.getString("FontChooser.Bold_Italic");
	}


	/**
	 * Set the value of a JList
	 * 
	 * @param list
	 *            JList component
	 * @param values
	 *            Array of string values
	 */
	private void setListValues(JList<String> list, String[] values) {
		list.removeAll();

		DefaultListModel<String> listModel = new DefaultListModel<String>();
		for (String value : values) {
			listModel.addElement(value);
		}
		list.setModel(listModel);
	}


	/**
	 * Set the font of the preview component
	 */
	private void setSampleFont() {
		if (currentFont != null && currentStyle >= 0 && currentSize > 0) {
			taPreview.setFont(new Font(currentFont, currentStyle, currentSize));
		}
	}


	/**
	 * Select the font name in the font name component
	 * 
	 * @param font
	 *            Font where to get the font name to search to search
	 */
	private void SelectInFontList(Font font) {
		String str;
		ListModel<String> lm = jFontList.getModel();
		for (int i = 0; i < lm.getSize(); i++) {
			str = (String) lm.getElementAt(i);
			if (str.equalsIgnoreCase(font.getFamily())) {
				jFontList.setSelectedIndex(i);
				jFontList.ensureIndexIsVisible(i);
				return;
			}
		}
	}


	/**
	 * Select the style in the style component
	 * 
	 * @param font
	 *            Font where to get the style to search
	 */
	private void SelectInStyleList(Font font) {
		int index = 0;
		if (font.isPlain())
			index = 0;
		else if (font.isBold() && !font.isItalic())
			index = 1;
		else if (!font.isBold() && font.isItalic())
			index = 2;
		else if (font.isBold() && font.isItalic())
			index = 3;
		jStyleList.setSelectedIndex(index);
		jStyleList.ensureIndexIsVisible(index);
	}


	/**
	 * Search the size in the size list and select the corresponding size in the
	 * SizeList component
	 * 
	 * @param font
	 *            Font where to get the size to search
	 */
	private void SelectInSizeList(Font font) {
		for (int i = 0; i < sizeList.length; i++) {
			if (Integer.parseInt(sizeList[i]) == font.getSize()) {
				jSizeList.setSelectedIndex(i);
				jSizeList.ensureIndexIsVisible(i);
				return;
			}
		}
	}


	/**
	 * Get the font from the preview component
	 * 
	 * @return
	 */
	public Font getCurrentFont() {
		return taPreview.getFont();
	}


	/**
	 * Set the font in the preview component
	 * 
	 * @param font
	 */
	public void setCurrentFont(Font font) {
		if (font == null) {
			taPreview.setFont(font);
		}
	}


	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		lbFamily = new javax.swing.JLabel();
		lbStyle = new javax.swing.JLabel();
		lbSize = new javax.swing.JLabel();
		btOk = new javax.swing.JButton();
		btCancel = new javax.swing.JButton();
		jScrollPane2 = new javax.swing.JScrollPane();
		jStyleList = new javax.swing.JList<String>();
		jScrollPane3 = new javax.swing.JScrollPane();
		jFontList = new javax.swing.JList<String>();
		jScrollPane4 = new javax.swing.JScrollPane();
		jSizeList = new javax.swing.JList<String>();
		jScrollPane1 = new javax.swing.JScrollPane();
		taPreview = new javax.swing.JTextArea();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setAlwaysOnTop(true);
		setBackground(new java.awt.Color(204, 204, 204));
		setModalityType(java.awt.Dialog.ModalityType.DOCUMENT_MODAL);
		setType(java.awt.Window.Type.UTILITY);
		addComponentListener(new java.awt.event.ComponentAdapter() {
			public void componentShown(java.awt.event.ComponentEvent evt) {
				formComponentShown(evt);
			}
		});

		java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("course_generator/Bundle"); // NOI18N
		lbFamily.setText(bundle.getString("FontChooser.lbFamily.text")); // NOI18N

		lbStyle.setText(bundle.getString("FontChooser.lbStyle.text")); // NOI18N

		lbSize.setText(bundle.getString("FontChooser.lbSize.text")); // NOI18N

		btOk.setText(bundle.getString("Global.btOk.text")); // NOI18N
		btOk.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btOkActionPerformed(evt);
			}
		});

		btCancel.setText(bundle.getString("Global.btCancel.text")); // NOI18N
		btCancel.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btCancelActionPerformed(evt);
			}
		});

		jStyleList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		jStyleList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
			public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
				jStyleListValueChanged(evt);
			}
		});
		jScrollPane2.setViewportView(jStyleList);

		jFontList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		jFontList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
			public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
				jFontListValueChanged(evt);
			}
		});
		jScrollPane3.setViewportView(jFontList);

		jSizeList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		jSizeList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
			public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
				jSizeListValueChanged(evt);
			}
		});
		jScrollPane4.setViewportView(jSizeList);

		taPreview.setColumns(20);
		taPreview.setRows(5);
		taPreview.setText(bundle.getString("FontChooser.taPreview.text")); // NOI18N
		jScrollPane1.setViewportView(taPreview);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(layout
						.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(lbFamily))
								.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jScrollPane3,
										javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 141,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lbStyle))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lbSize).addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE,
										73, javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGroup(layout.createSequentialGroup().addContainerGap()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addGroup(layout.createSequentialGroup().addGap(299, 299, 299)
												.addComponent(btOk, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(btCancel, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addComponent(jScrollPane1))))
				.addContainerGap()));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addContainerGap()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(lbSize).addComponent(lbStyle).addComponent(lbFamily))
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jScrollPane2)
										.addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 153,
												Short.MAX_VALUE)
										.addComponent(jScrollPane3))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(btOk, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(btCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addContainerGap()));

		pack();
		setLocationRelativeTo(null);
	}// </editor-fold>//GEN-END:initComponents


	private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btCancelActionPerformed
		setVisible(false);
	}// GEN-LAST:event_btCancelActionPerformed


	private void btOkActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btOkActionPerformed
		ok = true;
		setVisible(false);
	}// GEN-LAST:event_btOkActionPerformed


	private void jStyleListValueChanged(javax.swing.event.ListSelectionEvent evt) {// GEN-FIRST:event_jStyleListValueChanged
		String str = (String) jStyleList.getSelectedValue();
		if (str != null) {
			if (str.equalsIgnoreCase(bundle.getString("FontChooser.Plain"))) // "Plain"))
				currentStyle = Font.PLAIN;
			else if (str.equalsIgnoreCase(bundle.getString("FontChooser.Bold"))) // "Bold"))
				currentStyle = Font.BOLD;
			else if (str.equalsIgnoreCase(bundle.getString("FontChooser.Italic")))// "Italic"))
				currentStyle = Font.ITALIC;
			else if (str.equalsIgnoreCase(bundle.getString("FontChooser.Bold_Italic"))) // "Bold Italic"))
				currentStyle = Font.BOLD | Font.ITALIC;
			;
			setSampleFont();
		}
	}// GEN-LAST:event_jStyleListValueChanged


	private void jSizeListValueChanged(javax.swing.event.ListSelectionEvent evt) {// GEN-FIRST:event_jSizeListValueChanged
		String str = (String) jSizeList.getSelectedValue();
		if (str != null) {
			currentSize = Integer.parseInt(str);
		}
		setSampleFont();
	}// GEN-LAST:event_jSizeListValueChanged


	private void jFontListValueChanged(javax.swing.event.ListSelectionEvent evt) {// GEN-FIRST:event_jFontListValueChanged
		String str = (String) jFontList.getSelectedValue();
		if (str != null)
			currentFont = str;

		setSampleFont();
	}// GEN-LAST:event_jFontListValueChanged


	private void formComponentShown(java.awt.event.ComponentEvent evt) {// GEN-FIRST:event_formComponentShown
		repaint();
	}// GEN-LAST:event_formComponentShown


	/**
	 * Init the fontchooser dialog
	 * 
	 * @param font
	 *            Initial font
	 */
	private void InitDialog(Font font) {
		setListValues(jFontList, GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames());
		setListValues(jStyleList, styleList);
		setListValues(jSizeList, sizeList);
		setCurrentFont(font);
		taPreview.setFont(font);
		SelectInFontList(font);
		SelectInStyleList(font);
		SelectInSizeList(font);
	}


	// Create font chooser dialog.
	// If user selected a font (i.e. clicked OK button) - return the font that user
	// has selected.
	// If user didn't click OK button - return "null".
	/**
	 * Create font chooser dialog.
	 * 
	 * @param title
	 *            Dialog title
	 * @param font
	 *            Font to display
	 * @return If user selected a font (i.e. clicked OK button) - return the font
	 *         that user has selected. If user didn't click OK button - return
	 *         "null".
	 */
	public static Font showDialog(String title, Font font) {
		FontChooser dlg = new FontChooser();
		if (title != null) {
			dlg.setTitle(title);
		}

		dlg.InitDialog(font);

		// End set field
		dlg.ok = false;

		dlg.setVisible(true);
		Font newfont = null;
		if (dlg.ok) {
			newfont = dlg.getCurrentFont();
		} else
			newfont = font;

		dlg.dispose();

		return newfont;
	}

	private javax.swing.JButton btCancel;
	private javax.swing.JButton btOk;
	private javax.swing.JList<String> jFontList;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JScrollPane jScrollPane4;
	private javax.swing.JList<String> jSizeList;
	private javax.swing.JList<String> jStyleList;
	private javax.swing.JLabel lbFamily;
	private javax.swing.JLabel lbSize;
	private javax.swing.JLabel lbStyle;
	private javax.swing.JTextArea taPreview;
}
