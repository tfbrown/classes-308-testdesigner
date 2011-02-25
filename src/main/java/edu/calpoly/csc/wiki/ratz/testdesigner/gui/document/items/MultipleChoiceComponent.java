package edu.calpoly.csc.wiki.ratz.testdesigner.gui.document.items;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import net.miginfocom.swing.MigLayout;
import edu.calpoly.csc.wiki.ratz.testdesigner.gui.document.PageSettings;
import edu.calpoly.csc.wiki.ratz.testdesigner.items.MultipleChoiceItem;
import edu.calpoly.csc.wiki.ratz.testdesigner.items.MultipleChoiceItem.Answer;

public class MultipleChoiceComponent extends ItemComponent<MultipleChoiceItem> {
   private static final long serialVersionUID = 7172145259989034168L;

   private static final int MAX_HEIGHT = 400;

   public MultipleChoiceComponent(PageSettings pageSettings,
         MultipleChoiceItem item, int number) {
      super(pageSettings, item, number);
   }

   protected void initComponents() {
      setLayout(new MigLayout());

      JPanel left = new JPanel();
      left.setBackground(Color.WHITE);
      left.add(new JLabel(getNumber()));

      JPanel right = new JPanel();
      right.setBackground(Color.WHITE);
      right.add(makeTextArea(
            String.format("__ (%d) %s", item.getWeight(), item.getQuestion()),
            pageSettings.getQuestionWidthPixels() - left.getWidth()));

      add(left);
      add(right, "wrap");

      int curAnswer = 0;
      for (Answer answer : item.getAnswers()) {
         JLabel label = new JLabel(String.format("%c.", 'A' + curAnswer));
         label.setHorizontalAlignment(JLabel.RIGHT);
         label.setPreferredSize(new Dimension(50, label.getHeight()));
         add(label);

         add(makeTextArea(answer.getAnswer(), pageSettings.getQuestionWidthPixels()
               - label.getWidth()), "wrap");
         curAnswer++;
      }
   }

   private JTextArea makeTextArea(String text, int width) {
      JTextArea textArea = new JTextArea();
      textArea.setText(text);
      textArea.setLineWrap(true);
      textArea.setWrapStyleWord(true);
      textArea.setEditable(false);

      FontMetrics metrics = textArea.getFontMetrics(textArea.getFont());
      Rectangle2D size = metrics.getStringBounds(text, new BufferedImage(width,
            MAX_HEIGHT, BufferedImage.TYPE_BYTE_BINARY).getGraphics());

      textArea.setPreferredSize(new Dimension((int) size.getWidth(), (int) size
            .getHeight() + 4));
      return textArea;
   }
}
