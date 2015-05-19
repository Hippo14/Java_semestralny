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


public class MainActivity extends ActionBarActivity {

    private static final int NUM_ROWS = 10;
    private static final int NUM_COLS = 10;

    Button buttons[][] = new Button[NUM_ROWS][NUM_COLS];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        populateButtons();
    }

    private void populateButtons() {
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
                
                Button button = new Button(this);
                //set button layout
                button.setLayoutParams(new TableRow.LayoutParams(
                        TableLayout.LayoutParams.MATCH_PARENT,
                        TableLayout.LayoutParams.MATCH_PARENT,
                        1.0f
                ));
                //button setText
                button.setText("" + row + "," + col);
                //padding text
                button.setPadding(0, 0, 0 ,0);
                //button setBackground
                button.setBackgroundDrawable(getResources().getDrawable(R.drawable.greenbutton));
                //button onclick listener
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        gridButtonClicked(FINAL_COL, FINAL_ROW);
                    }
                });
                tableRow.addView(button);
                buttons[row][col] = button;
            }
        }
    }

    private void gridButtonClicked(int col, int row) {
        Toast.makeText(this, "Button clicked: " + col + "," + row, Toast.LENGTH_SHORT).show();

        if (row > 0 && col > 0) {
            Button button0 = buttons[row - 1][col];
            Button button1 = buttons[row + 1][col];
            Button button2 = buttons[row][col - 1];
            Button button3 = buttons[row][col + 1];
            //button setBackground
            button0.setBackgroundDrawable(getResources().getDrawable(R.drawable.redbutton));
            button1.setBackgroundDrawable(getResources().getDrawable(R.drawable.redbutton));
            button2.setBackgroundDrawable(getResources().getDrawable(R.drawable.redbutton));
            button3.setBackgroundDrawable(getResources().getDrawable(R.drawable.redbutton));
        }



        //v.setBackgroundDrawable(getResources().getDrawable(R.drawable.redbutton));

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
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
