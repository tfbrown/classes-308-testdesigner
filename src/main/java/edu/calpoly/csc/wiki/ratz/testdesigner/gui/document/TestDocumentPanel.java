package edu.calpoly.csc.wiki.ratz.testdesigner.gui.document;

import java.awt.Dimension;
import java.awt.print.PrinterException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import edu.calpoly.csc.wiki.ratz.testdesigner.document.DocumentController;
import edu.calpoly.csc.wiki.ratz.testdesigner.items.MultipleChoiceItem;
import edu.calpoly.csc.wiki.ratz.testdesigner.items.MultipleChoiceItem.Answer;

public class TestDocumentPanel extends JFrame {
   private static final long serialVersionUID = -7356203018616219698L;

   private DocumentController controller;

   private DocumentPanel panel;

   public TestDocumentPanel() {
      super("Test Document Panel");

      controller = new DocumentController();

      MultipleChoiceItem mcItem = new MultipleChoiceItem();
      mcItem.setWeight(1);
      mcItem.setLevel("Easy");
      mcItem.setCategory("Science");
      mcItem.setQuestion("What is the first element on the periodic table of elements?");
      List<Answer> answers = new ArrayList<Answer>();
      answers.add(new Answer("Hydrogen", true));
      answers.add(new Answer("Helium", false));
      answers.add(new Answer("Iron", false));
      answers.add(new Answer("Mercury", false));
      mcItem.setAnswers(answers);
      controller.addItem(mcItem);

      mcItem = new MultipleChoiceItem();
      mcItem.setWeight(1);
      mcItem.setLevel("Easy");
      mcItem.setCategory("Science");
      mcItem.setQuestion("Who wrote Special Relativity?");
      answers = new ArrayList<Answer>();
      answers.add(new Answer("Isaac Newton", false));
      answers.add(new Answer("Albert Einstein", true));
      answers.add(new Answer("Millenium Falcon", false));
      answers.add(new Answer("Dr. Dalbey", false));
      mcItem.setAnswers(answers);
      controller.addItem(mcItem);

      mcItem = new MultipleChoiceItem();
      mcItem.setWeight(1);
      mcItem.setLevel("Easy");
      mcItem.setCategory("Science");
      mcItem.setQuestion("Quisque sed lectus neque, nec vulputate ipsum. Pellentesque at lorem id magna congue aliquam. Etiam quis luctus diam. Ut malesuada feugiat nisi, eget tristique ligula euismod sit amet. Phasellus non nisi elit, fringilla pulvinar mi. Nam bibendum fringilla nunc ultrices blandit. Morbi eget mi non augue tempus tempor. Etiam lobortis rutrum rhoncus. Proin posuere magna pretium nisi cursus pellentesque. Donec est tellus, tincidunt quis fringilla a, hendrerit id tellus.");
      answers = new ArrayList<Answer>();
      answers
            .add(new Answer(
                  "Phasellus accumsan, turpis at imperdiet lobortis, turpis libero congue felis,",
                  false));
      answers.add(new Answer(
            "Aliquam sed magna at lectus aliquet tincidunt in ac ante.", true));
      answers.add(new Answer("est enim euismod ipsum, nec dignissim ", false));
      answers.add(new Answer("pretium, elementum quis mi. Cras fermentum",
            false));
      mcItem.setAnswers(answers);
      controller.addItem(mcItem);

      for (int idx = 0; idx < 5; idx++) {
         mcItem = new MultipleChoiceItem();
         mcItem.setWeight(1);
         mcItem.setLevel("Easy");
         mcItem.setCategory("Science");
         mcItem.setQuestion("Who wrote Special Relativity?");
         answers = new ArrayList<Answer>();
         answers.add(new Answer("Isaac Newton", false));
         answers.add(new Answer("Albert Einstein", true));
         answers.add(new Answer("Millenium Falcon", false));
         answers.add(new Answer("Dr. Dalbey", false));
         mcItem.setAnswers(answers);
         controller.addItem(mcItem);

         mcItem = new MultipleChoiceItem();
         mcItem.setWeight(1);
         mcItem.setLevel("Easy");
         mcItem.setCategory("Science");
         mcItem.setQuestion("What is the first element on the periodic table of elements?");
         answers = new ArrayList<Answer>();
         answers.add(new Answer("Hydrogen", true));
         answers.add(new Answer("Helium", false));
         answers.add(new Answer("Iron", false));
         answers.add(new Answer("Mercury", false));
         mcItem.setAnswers(answers);
         controller.addItem(mcItem);
      }

      initComponents();

      try {
         controller.print();
      }
      catch (PrinterException ex) {
         ex.printStackTrace();
      }
   }

   public void initComponents() {
      setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      setName("Test Document Panel");
      setPreferredSize(new Dimension(1024, 768));

      panel = new DocumentPanel();
      panel.refresh(controller.getItems());
      add(panel);
      pack();
   }
}
