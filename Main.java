import javax.swing.*;
import java.util.ArrayList;

public class Main {

    private static class Question {
        String question;
        Boolean isTrue;

        public Question(String question, Boolean isTrue) {
            this.question = question;
            this.isTrue = isTrue;
        }
    }

    private static class QuestionHandler {
        ArrayList<Question> questions = new ArrayList();

        public void addQuestion(String question, Boolean isTrue) {
            this.questions.add(new Question(question, isTrue));
        }

        public Question getRandomQuestion() {
            int random = (int) Math.round(Math.random()*(this.questions.size()-1));
            return this.questions.get(random);
        }
    }

    public static void main(String[] args) {
        QuestionHandler handler = new QuestionHandler();
        handler.addQuestion("McDonald’s once made bubblegum-flavored broccoli", true);
        handler.addQuestion("The first oranges weren’t orange", true);
        handler.addQuestion("In the days of Christopher Columbus, everyone thought the world was flat.", false);

        Question q = handler.getRandomQuestion();

        String reply = JOptionPane.showInputDialog(null, q.question + " | True or false?");
        boolean parsed_reply = Boolean.parseBoolean(reply.toLowerCase());

        if(parsed_reply == q.isTrue) {
            JOptionPane.showMessageDialog(null, "You are correct!");
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect :(");
        }
    }

}
