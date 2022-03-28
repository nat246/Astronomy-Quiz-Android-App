package com.example.android.astronomyquizapp;

import android.content.Context;
import android.media.Image;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     *This method is called when the Finish button is clicked
     * @param view
     */
    public void finishQuiz (View view) {
        int points = 0;
        int score = total(points);

        /** Compliment */
        String compliment = "";
        if (score == 10) {
            compliment = "Perfect Score!";
        } else if (score < 10 && score > 5){
            compliment = "Great Job!";
        } else if (score <= 5 && score >2){
            compliment = "Not bad!";
        } else if (score <= 2 && score >= 0){
            compliment = "You can do better than that!";
        }

        /** Creates a message after the Finish button is clicked */
        String resultsMessage = createResultsMessage(compliment, score);
        displayResults(resultsMessage);
    }

    /** This is the message that is created when the Finish button is clicked */
    private String createResultsMessage(String compliment, int score){
        String message = compliment;
        message += "\nYou got " + score + "/10 questions correct!";
        return message;
    }

    /**
     * Calculates the total amount of questions that is correct
     */
    private int total(int points){
        /** Question 1 */
        CheckBox q1Choice1 = (CheckBox) findViewById(R.id.q1_moon);
        CheckBox q1Choice2 = (CheckBox) findViewById(R.id.q1_saturn);
        CheckBox q1Choice3 = (CheckBox) findViewById(R.id.q1_pluto);
        CheckBox q1Choice4 = (CheckBox) findViewById(R.id.q1_venus);

        boolean q1Correct1 = q1Choice2.isChecked();
        boolean q1Correct2 = q1Choice4.isChecked();
        boolean q1Wrong1 = q1Choice1.isChecked();
        boolean q1Wrong2 = q1Choice3.isChecked();

        if (q1Correct1 && q1Correct2 && !q1Wrong1 && !q1Wrong2)
            points = points +1;


        if (q1Correct1)
            setCBDrawable(q1Choice2, R.drawable.correct_img);

        if (q1Correct2)
            setCBDrawable(q1Choice4, R.drawable.correct_img);

        if (q1Wrong1)
            setCBDrawable(q1Choice1, R.drawable.incorrect_img);

        if (q1Wrong2)
            setCBDrawable(q1Choice3, R.drawable.incorrect_img);

        /** Question 2 */
        EditText q2Mercury = (EditText) findViewById(R.id.q2_mercury);
        EditText q2Venus = (EditText) findViewById(R.id.q2_venus);
        EditText q2Earth = (EditText) findViewById(R.id.q2_earth);
        EditText q2Mars =  (EditText) findViewById(R.id.q2_mars);
        EditText q2Jupiter = (EditText) findViewById(R.id.q2_jupiter);
        EditText q2Saturn = (EditText) findViewById(R.id.q2_saturn);
        EditText q2Uranus = (EditText) findViewById(R.id.q2_uranus);
        EditText q2Neptune = (EditText) findViewById(R.id.q2_neptune);

        String mercury = q2Mercury.getText().toString();
        String venus = q2Venus.getText().toString();
        String earth = q2Earth.getText().toString();
        String mars = q2Mars.getText().toString();
        String jupiter = q2Jupiter.getText().toString();
        String saturn = q2Saturn.getText().toString();
        String uranus = q2Uranus.getText().toString();
        String neptune = q2Neptune.getText().toString();


        if (mercury.equals("Mercury") && venus.equals("Venus") && earth.equals("Earth") &&
                mars.equals("Mars") && jupiter.equals("Jupiter") && saturn.equals("Saturn") &&
                uranus.equals("Uranus") && neptune.equals("Neptune")) {
            points = points + 1;
        }

        if (mercury.equals("Mercury")){
            setETDrawable(q2Mercury, R.drawable.correct_img);
        } else {
            setETDrawable(q2Mercury, R.drawable.incorrect_img);
        }
        if (venus.equals("Venus")){
            setETDrawable(q2Venus, R.drawable.correct_img);
        } else {
            setETDrawable(q2Venus, R.drawable.incorrect_img);
        }
        if (earth.equals("Earth")){
            setETDrawable(q2Earth, R.drawable.correct_img);
        } else {
            setETDrawable(q2Earth, R.drawable.incorrect_img);
        }
        if (mars.equals("Mars")){
            setETDrawable(q2Mars, R.drawable.correct_img);
        } else {
            setETDrawable(q2Mars, R.drawable.incorrect_img);
        }
        if (jupiter.equals("Jupiter")) {
            setETDrawable(q2Jupiter, R.drawable.correct_img);
        } else {
            setETDrawable(q2Jupiter, R.drawable.incorrect_img);
        }
        if (saturn.equals("Saturn")){
            setETDrawable(q2Saturn, R.drawable.correct_img);
        } else {
            setETDrawable(q2Saturn, R.drawable.incorrect_img);
        }
        if (uranus.equals("Uranus")) {
            setETDrawable(q2Uranus,R.drawable.correct_img);
        } else {
            setETDrawable(q2Uranus, R.drawable.incorrect_img);
        }
        if (neptune.equals("Neptune")){
            setETDrawable(q2Neptune, R.drawable.correct_img);
        } else {
            setETDrawable(q2Neptune, R.drawable.incorrect_img);
        }


        /** Question 3 */
        RadioButton q3rbCorrect = (RadioButton) findViewById(R.id.q3_correct);
        RadioButton q3rbWrong1 = (RadioButton) findViewById(R.id.q3_wrong1);
        RadioButton q3rbWrong2 = (RadioButton) findViewById(R.id.q3_wrong2);
        RadioButton q3rbWrong3 = (RadioButton) findViewById(R.id.q3_wrong3);

        boolean q3Correct = q3rbCorrect.isChecked();
        boolean q3Wrong1 = q3rbWrong1.isChecked();
        boolean q3Wrong2 = q3rbWrong2.isChecked();
        boolean q3Wrong3 = q3rbWrong3.isChecked();

        if (q3Correct) {
            points = points + 1;
            setRBDrawable(q3rbCorrect, R.drawable.correct_img);
        } else if (q3Wrong1) {
            setRBDrawable(q3rbWrong1, R.drawable.incorrect_img);
        } else if (q3Wrong2) {
            setRBDrawable(q3rbWrong2, R.drawable.incorrect_img);
        } else if (q3Wrong3) {
            setRBDrawable(q3rbWrong3, R.drawable.incorrect_img);
        }
        /** Question 4 */
        RadioButton q4rbCorrect = (RadioButton) findViewById(R.id.q4_correct);
        RadioButton q4rbWrong1 = (RadioButton) findViewById(R.id.q4_wrong1);
        RadioButton q4rbWrong2 = (RadioButton) findViewById(R.id.q4_wrong2);
        RadioButton q4rbWrong3 = (RadioButton) findViewById(R.id.q4_wrong3);

        boolean q4Correct = q4rbCorrect.isChecked();
        boolean q4Wrong1 = q4rbWrong1.isChecked();
        boolean q4Wrong2 = q4rbWrong2.isChecked();
        boolean q4Wrong3 = q4rbWrong3.isChecked();

        if (q4Correct){
            points = points +1;
            setRBDrawable(q4rbCorrect, R.drawable.correct_img);
        } else if (q4Wrong1) {
            setRBDrawable(q4rbWrong1, R.drawable.incorrect_img);
        } else if (q4Wrong2) {
            setRBDrawable(q4rbWrong2, R.drawable.incorrect_img);
        } else if (q4Wrong3) {
            setRBDrawable(q4rbWrong3, R.drawable.incorrect_img);
        }

        /** Question 5 */
        RadioButton q5rbCorrect = (RadioButton) findViewById(R.id.q5_correct);
        RadioButton q5rbWrong1 = (RadioButton) findViewById(R.id.q5_wrong1);
        RadioButton q5rbWrong2 = (RadioButton) findViewById(R.id.q5_wrong2);
        RadioButton q5rbWrong3 = (RadioButton) findViewById(R.id.q5_wrong3);

        boolean q5Correct = q5rbCorrect.isChecked();
        boolean q5Wrong1 = q5rbWrong1.isChecked();
        boolean q5Wrong2 = q5rbWrong2.isChecked();
        boolean q5Wrong3 = q5rbWrong3.isChecked();

        if (q5Correct){
            points = points + 1;
            setRBDrawable(q5rbCorrect, R.drawable.correct_img);
        } else if (q5Wrong1) {
            setRBDrawable(q5rbWrong1, R.drawable.incorrect_img);
        } else if (q5Wrong2) {
            setRBDrawable(q5rbWrong2, R.drawable.incorrect_img);
        } else if (q5Wrong3) {
            setRBDrawable(q5rbWrong3, R.drawable.incorrect_img);
        }

        /** Question 6 */
        EditText q6Answer = (EditText) findViewById(R.id.q6_galaxy);
        String q6MilkyWay = q6Answer.getText().toString();

        if (q6MilkyWay.equals("Milky Way Galaxy") || q6MilkyWay.equals("Milky Way")){
            points = points + 1;
            setETDrawable(q6Answer, R.drawable.correct_img);
        } else {
            setETDrawable(q6Answer, R.drawable.incorrect_img);
        }

        /** Question 7 **/
        RadioButton q7rbCorrect = (RadioButton) findViewById(R.id.q7_correct);
        RadioButton q7rbWrong1 = (RadioButton) findViewById(R.id.q7_wrong1);
        RadioButton q7rbWrong2 = (RadioButton) findViewById(R.id.q7_wrong2);
        RadioButton q7rbWrong3 = (RadioButton) findViewById(R.id.q7_wrong3);

        boolean q7Correct = q7rbCorrect.isChecked();
        boolean q7Wrong1 = q7rbWrong1.isChecked();
        boolean q7Wrong2 = q7rbWrong2.isChecked();
        boolean q7Wrong3 = q7rbWrong3.isChecked();

        if (q7Correct){
            points = points +1;
            setRBDrawable(q7rbCorrect, R.drawable.correct_img);
        } else if (q7Wrong1) {
            setRBDrawable(q7rbWrong1, R.drawable.incorrect_img);
        } else if (q7Wrong2) {
            setRBDrawable(q7rbWrong2, R.drawable.incorrect_img);
        } else if (q7Wrong3) {
            setRBDrawable(q7rbWrong3, R.drawable.incorrect_img);
        }

        /** Question 8 **/
        RadioButton q8rbCorrect = (RadioButton) findViewById(R.id.q8_correct);
        RadioButton q8rbWrong = (RadioButton) findViewById(R.id.q8_wrong);

        boolean q8Correct = q8rbCorrect.isChecked();
        boolean q8Wrong = q8rbWrong.isChecked();

        if (q8Correct){
            points = points +1;
            setRBDrawable(q8rbCorrect, R.drawable.correct_img);
        } else if (q8Wrong) {
            setRBDrawable(q8rbWrong, R.drawable.incorrect_img);
        }

        /** Question 9 **/
        CheckBox q9Choice1 = (CheckBox) findViewById(R.id.q9_Saturn);
        CheckBox q9Choice2 = (CheckBox) findViewById(R.id.q9_Jupiter);
        CheckBox q9Choice3 = (CheckBox) findViewById(R.id.q9_Venus);
        CheckBox q9Choice4 = (CheckBox) findViewById(R.id.q9_Uranus);

        boolean q9Correct1 = q9Choice1.isChecked();
        boolean q9Correct2 = q9Choice2.isChecked();
        boolean q9Correct3 = q9Choice4.isChecked();
        boolean q9Incorrect = q9Choice3.isChecked();

        if (q9Correct1 && q9Correct2 && q9Correct3 && !q9Incorrect){
            points = points +1;
        }

        if (q9Correct1)
            setCBDrawable(q9Choice1,R.drawable.correct_img);

        if (q9Correct2)
            setCBDrawable(q9Choice2,R.drawable.correct_img);

        if (q9Correct3)
            setCBDrawable(q9Choice4,R.drawable.correct_img);

        if (q9Incorrect)
            setCBDrawable(q9Choice3, R.drawable.incorrect_img);


        /** Question 10 */
        RadioButton q10rbCorrect = (RadioButton) findViewById(R.id.q10_correct);
        RadioButton q10rbWrong = (RadioButton) findViewById(R.id.q10_wrong);

        boolean q10Correct = q10rbCorrect.isChecked();
        boolean q10Wrong = q10rbWrong.isChecked();

//        if (q10Correct){
//            points = points +1;
//            q10rbCorrect.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.correct_img,0);
//        } else if (q10Wrong) {
//            q10rbWrong.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.incorrect_img,0);
//        }

        if (q10Correct) {
            points = points + 1;
            setRBDrawable(q10rbCorrect, R.drawable.correct_img);
        } else if (q10Wrong) {
            setRBDrawable(q10rbWrong, R.drawable.incorrect_img);
        }

        return points;
    }

    /**
     * This marks whether the questions that uses the RADIO BUTTONS are right or wrong
     * @param radioButton
     * @param drawable
     */
    private void setRBDrawable(RadioButton radioButton, int drawable){
        radioButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, drawable, 0);
    }
    /**
     * This marks whether the questions that uses CHECK BOXES are right or wrong
     * @param checkBox
     * @param drawable
     */
    private void  setCBDrawable (CheckBox checkBox, int drawable){
        checkBox.setCompoundDrawablesWithIntrinsicBounds(0,0, drawable,0);
    }

    /**
     * This marks whether the questions that uses EDIT TEXT are right or wrong
     * @param editText
     * @param drawable
     */
    private void setETDrawable (EditText editText, int drawable){
        editText.setCompoundDrawablesWithIntrinsicBounds(0,0,drawable,0);
    }

    /**
     * This methods displays the results
     * @param resultsText is linked to String Result Message
     */
    private void displayResults(String resultsText){
        Context context = this;
        CharSequence text = resultsText;
        int duration = Toast.LENGTH_LONG;

        Toast resultsToast = Toast.makeText(context, text, duration);
        resultsToast.setGravity(Gravity.CENTER,0,0);
        TextView x = (TextView) resultsToast.getView().findViewById(android.R.id.message);
        if( x != null) x.setGravity(Gravity.CENTER);
        resultsToast.show();
    }
}
