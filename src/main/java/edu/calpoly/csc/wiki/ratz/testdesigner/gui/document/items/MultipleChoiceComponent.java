package edu.calpoly.csc.wiki.ratz.testdesigner.gui.document.items;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import edu.calpoly.csc.wiki.ratz.testdesigner.gui.document.PageSettings;
import edu.calpoly.csc.wiki.ratz.testdesigner.items.MultipleChoiceItem;
import edu.calpoly.csc.wiki.ratz.testdesigner.items.renderers.swing.SwingMultipleChoiceRenderer;

public class MultipleChoiceComponent extends ItemComponent<MultipleChoiceItem> {
   private static final long serialVersionUID = 7172145259989034168L;

   private static final int MAX_HEIGHT = 400;

   SwingMultipleChoiceRenderer renderer;
   BufferedImage bufferedImage;

   public MultipleChoiceComponent(PageSettings pageSettings,
         MultipleChoiceItem item, int number) {
      super(pageSettings, item, number);

      bufferedImage = new BufferedImage(pageSettings.getItemAreaWidthPixels(),
            pageSettings.getItemAreaHeightPixels(), BufferedImage.TYPE_INT_RGB);
      Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();
      graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
      graphics.setColor(Color.WHITE);
      graphics.fillRect(0, 0, bufferedImage.getWidth(),
            bufferedImage.getHeight());
      renderer = new SwingMultipleChoiceRenderer(item, number, pageSettings,
            (Graphics2D) graphics, false);
      renderer.render();

      Dimension size = new Dimension(pageSettings.getItemAreaWidthPixels(),
            (int) (pageSettings.getDpi() * renderer.calculateHeight()));
      setPreferredSize(size);
      setMinimumSize(size);
      setMaximumSize(size);
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);

      ((Graphics2D) g).drawImage(bufferedImage, new AffineTransformOp(
            new AffineTransform(), AffineTransformOp.TYPE_NEAREST_NEIGHBOR), 0,
            0);
   }

   protected void initComponents() {
      /*
       * setLayout(new MigLayout());
       * 
       * JPanel left = new JPanel(); left.setBackground(Color.WHITE);
       * left.add(new JLabel(getNumber()));
       * 
       * JPanel right = new JPanel(); right.setBackground(Color.WHITE);
       * right.add(makeTextArea( String.format("__ (%d) %s", item.getWeight(),
       * item.getQuestion()), pageSettings.getQuestionWidthPixels() -
       * left.getWidth()));
       * 
       * add(left); add(right, "wrap");
       * 
       * int curAnswer = 0; for (Answer answer : item.getAnswers()) { JLabel
       * label = new JLabel(String.format("%c.", 'A' + curAnswer));
       * label.setHorizontalAlignment(JLabel.RIGHT); label.setPreferredSize(new
       * Dimension(50, label.getHeight())); add(label);
       * 
       * add(makeTextArea(answer.getAnswer(),
       * pageSettings.getQuestionWidthPixels() - label.getWidth()), "wrap");
       * curAnswer++; }
       */
   }

   /*
    * private JTextArea makeTextArea(String text, int width) { JTextArea
    * textArea = new JTextArea(); textArea.setText(text);
    * textArea.setLineWrap(true); textArea.setWrapStyleWord(true);
    * textArea.setEditable(false);
    * 
    * FontMetrics metrics = textArea.getFontMetrics(textArea.getFont());
    * Rectangle2D size = metrics.getStringBounds(text, new BufferedImage(width,
    * MAX_HEIGHT, BufferedImage.TYPE_BYTE_BINARY).getGraphics());
    * 
    * textArea.setPreferredSize(new Dimension((int) size.getWidth(), (int) size
    * .getHeight() + 4)); return textArea; }
    */
}
