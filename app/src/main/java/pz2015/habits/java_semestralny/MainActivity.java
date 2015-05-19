package pz2015.habits.java_semestralny;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import java.util.Timer;


public class MainActivity extends ActionBarActivity {

    private static final int NUM_ROWS = 10;
    private static final int NUM_COLS = 10;

    myButton myButtons[][] = new myButton[NUM_ROWS][NUM_COLS];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        populatemyButtons();
    }

    private void populatemyButtons() {
        TableLayout table = (TableLayout) findViewById(R.id.tableForButtons);
        for (int row = 0; row < NUM_ROWS; row++) {
            TableRow tableRow = new TableRow(this);
            //set row layout
            tableRow.setLayoutParams(new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.MATCH_PARENT,
                    1.0f
            ));
            table.addView(tableRow);

            for (int col = 0; col < NUM_COLS; col++) {
                final int FINAL_COL = col;
                final int FINAL_ROW = row;
                
                myButton myButton = new myButton(this);

                //myButton setText
                myButton.setText("" + row + "," + col);
                //padding text
                myButton.setPadding(0, 0, 0 ,0);
                //myButton setBackground
                myButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.greenbutton));
                //myButton onclick listener
                myButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        gridmyButtonClicked(FINAL_COL, FINAL_ROW);
                        //WIN
                        if (checkAllButtons()) {

                        }
                    }
                });
                tableRow.addView(myButton);
                myButtons[row][col] = myButton;
            }
        }
    }

    private void gridmyButtonClicked(int col, int row) {
        Toast.makeText(this, "myButton clicked: " + col + "," + row, Toast.LENGTH_SHORT).show();

        myButton button = myButtons[row][col];
        button.checkColor();

        if (col == 0 && row == 0) {
            myButton myButton0 = myButtons[row + 1][col];
            myButton myButton1 = myButtons[row][col + 1];

            myButton0.checkColor();
            myButton1.checkColor();
        }
        else if (col == NUM_COLS - 1 && row == 0) {
            myButton myButton0 = myButtons[row + 1][col];
            myButton myButton1 = myButtons[row][col - 1];

            myButton0.checkColor();
            myButton1.checkColor();
        }
        else if (col == 0 && row == NUM_ROWS - 1) {
            myButton myButton0 = myButtons[row - 1][col];
            myButton myButton1 = myButtons[row][col + 1];

            myButton0.checkColor();
            myButton1.checkColor();
        }
        else  if (col == NUM_COLS - 1 && row == NUM_ROWS - 1) {
            myButton myButton0 = myButtons[row - 1][col];
            myButton myButton1 = myButtons[row][col - 1];

            myButton0.checkColor();
            myButton1.checkColor();
        }
        else if (col == 0 && row > 0) {
            myButton myButton0 = myButtons[row - 1][col];
            myButton myButton1 = myButtons[row][col + 1];
            myButton myButton2 = myButtons[row + 1][col];

            myButton0.checkColor();
            myButton1.checkColor();
            myButton2.checkColor();
        }
        else if (col > 0 && row == 0) {
            myButton myButton0 = myButtons[row][col - 1];
            myButton myButton1 = myButtons[row + 1][col];
            myButton myButton2 = myButtons[row][col + 1];

            myButton0.checkColor();
            myButton1.checkColor();
            myButton2.checkColor();
        }
        else if (col == NUM_COLS - 1 && row > 0) {
            myButton myButton0 = myButtons[row - 1][col];
            myButton myButton1 = myButtons[row][col - 1];
            myButton myButton2 = myButtons[row + 1][col];

            myButton0.checkColor();
            myButton1.checkColor();
            myButton2.checkColor();
        }
        else if (col > 0 && row == NUM_ROWS - 1) {
            myButton myButton0 = myButtons[row][col - 1];
            myButton myButton1 = myButtons[row - 1][col];
            myButton myButton2 = myButtons[row][col + 1];

            myButton0.checkColor();
            myButton1.checkColor();
            myButton2.checkColor();
        }
        else {
            myButton myButton0 = myButtons[row - 1][col];
            myButton myButton1 = myButtons[row + 1][col];
            myButton myButton2 = myButtons[row][col - 1];
            myButton myButton3 = myButtons[row][col + 1];

            myButton0.checkColor();
            myButton1.checkColor();
            myButton2.checkColor();
            myButton3.checkColor();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up myButton, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean checkAllButtons() {
        for (int row = 0; row < NUM_ROWS; row++) {
            for (int col = 0; col < NUM_COLS; col++) {
                if (myButtons[row][col].getWhichColorIs() == false)
                    return false;
            }
        }
        return true;
    }

}