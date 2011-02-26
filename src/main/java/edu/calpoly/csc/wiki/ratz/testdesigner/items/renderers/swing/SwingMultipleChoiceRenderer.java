package edu.calpoly.csc.wiki.ratz.testdesigner.items.renderers.swing;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.List;

import edu.calpoly.csc.wiki.ratz.testdesigner.gui.document.PageSettings;
import edu.calpoly.csc.wiki.ratz.testdesigner.items.MultipleChoiceItem;
import edu.calpoly.csc.wiki.ratz.testdesigner.items.MultipleChoiceItem.Answer;
import edu.calpoly.csc.wiki.ratz.testdesigner.items.renderers.Renderer;
import edu.calpoly.csc.wiki.ratz.testdesigner.items.renderers.swing.util.Block;
import edu.calpoly.csc.wiki.ratz.testdesigner.items.renderers.swing.util.TextBlock;
import edu.calpoly.csc.wiki.ratz.testdesigner.items.renderers.swing.util.Vec2d;

/**
 * Class that renders multiple choice questions for the Swing preview component.
 * 
 * @author jdisanti
 */
public class SwingMultipleChoiceRenderer implements Renderer {
   private Graphics2D gr;

   private Block mainBlock;

   public SwingMultipleChoiceRenderer(MultipleChoiceItem item, int number,
         PageSettings pageSettings, Graphics2D gr, boolean showAnswers) {
      this.gr = gr;

      mainBlock = new Block();

      final double padding = 10 / (double) pageSettings.getDpi();
      final double numberWidth = 0.3;

      TextBlock numberBlock = new TextBlock(pageSettings, gr, String.format(
            "%d.", number), numberWidth);
      numberBlock.setPosition(0, 0);
      mainBlock.addChild(numberBlock);

      TextBlock question = new TextBlock(pageSettings, gr, String.format(
            "(%d) %s", item.getWeight(), item.getQuestion()),
            pageSettings.getQuestionWidth() - numberWidth);
      question.setPosition(numberBlock.calculateSize().x + padding, 0);
      mainBlock.addChild(question);

      Block answerBlock = new Block();
      answerBlock.setPosition(new Vec2d(2 * numberWidth, question
            .calculateSize().y + padding / 4));
      mainBlock.addChild(answerBlock);

      buildAnswerSection(answerBlock, pageSettings, item.getAnswers(),
            pageSettings.getQuestionWidth() - numberWidth);
   }

   private void buildAnswerSection(Block answerBlock,
         PageSettings pageSettings, List<Answer> answers, double width) {
      final double letterWidth = 0.3;

      int idx = 0;
      double y = 0;
      for (Answer answer : answers) {
         TextBlock letterBlock = new TextBlock(pageSettings, gr, String.format(
               "%c.", 'A' + idx), letterWidth);
         letterBlock.setPosition(new Vec2d(0, y));
         answerBlock.addChild(letterBlock);

         TextBlock block = new TextBlock(pageSettings, gr, answer.getAnswer(),
               width - letterWidth);
         block.setPosition(new Vec2d(letterWidth, y));
         answerBlock.addChild(block);

         y += block.calculateSize().y;
         idx++;
      }
   }

   /**
    * {@inheritDoc}
    */
   public void render() {
      gr.setColor(Color.BLACK);
      mainBlock.render(gr);
   }

   /**
    * {@inheritDoc}
    */
   public double calculateHeight() {
      return mainBlock.calculateSize().y;
   }
}
