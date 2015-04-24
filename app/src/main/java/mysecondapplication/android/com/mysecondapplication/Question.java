
package mysecondapplication.android.com.mysecondapplication;

/**
 * Created by ilya on 23/04/2015.
 */
public class Question {


    private int id;
    private String QUESTION;
    private String option_yes;
    private String option_no;
    private String answer;


    public Question () {

        id = 0;    // override in constuctor?
        QUESTION = "";
        option_no = "";
        option_yes = "";
        answer = "";

    }

    public Question(String Question, String Option_yes, String Option_no, String Answer) {

        QUESTION = Question;
        option_yes = Option_yes;
        option_no = Option_no;
        answer = Answer;


    }

    public int getId() {

        return id;

    }

    public void setId(int id) {

        this.id = id;

    }


    public String getQuestion() {

        return QUESTION;
    }

    public String getOption_yes(){

        return option_yes;

    }

    public String getOption_no() {

        return option_no;

    }

    public String getAnswer() {

        return answer;

    }

    public void setQuestion (String question) {

        QUESTION = question;

    }

    public void setOption_yes (String Option_yes) {

        option_yes = Option_yes;

    }


    public void setOption_no (String Option_no) {

        option_no = Option_no;

    }

    public void setAnswer (String Answer) {

        answer = Answer;

    }




    public String toString () {
        return QUESTION;
    }


}
