package pz2015.habits.java_semestralny;

import android.content.Context;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

/**
 * Created by ASUS on 2015-05-19.
 */
public class myButton extends Button {

    private boolean whichColorIs = false;

    public myButton(Context context) {
        super(context);

        //set myButton layout
        this.setLayoutParams(new TableRow.LayoutParams(
                TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.MATCH_PARENT,
                1.0f
        ));
    }

    public boolean getWhichColorIs() { return this.whichColorIs; }

    public void checkColor() {
        if (whichColorIs == true) {
            this.setBackgroundDrawable(getResources().getDrawable(R.drawable.greenbutton));
            whichColorIs = false;
        }
        else {
            this.setBackgroundDrawable(getResources().getDrawable(R.drawable.redbutton));
            whichColorIs = true;
        }
    }

}
