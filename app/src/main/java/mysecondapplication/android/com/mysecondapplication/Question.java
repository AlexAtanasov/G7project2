
package mysecondapplication.android.com.mysecondapplication;

/**
 * Created by ilya on 23/04/2015.
 */
public class Question {                         // a constructor to store the info for the questions in db

    private int id;
    private String QUESTION;
    private String fact;
    private String option_yes;
    private String option_no;
    private String answer;

    public Question() {                          //constructor which empties question at the start

        id = 0;
        fact = "";
        QUESTION = "";
        option_no = "";
        option_yes = "";
        answer = "";

    }

    public Question(String Fact, String Question, String Answer, String Option_yes, String Option_no) {

        fact = Fact;
        QUESTION = Question;
        answer = Answer;
        option_yes = Option_yes;
        option_no = Option_no;

    }

//getters and setters below


    public String getFact() {              
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toFact() {
        return fact;
    }

    public String getQuestion() {
        return QUESTION;
    }

    public String getOption_yes() {
        return option_yes;
    }

    public String getOption_no() {
        return option_no;
    }

    public String getAnswer() {
        return answer;
    }

    public void setQuestion(String question) {
        QUESTION = question;
    }

    public void setOption_yes(String Option_yes) {
        option_yes = Option_yes;
    }

    public void setOption_no(String Option_no) {
        option_no = Option_no;
    }

    public void setAnswer(String Answer) {
        answer = Answer;
    }
}
