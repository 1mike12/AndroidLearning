package mike.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

/**
 * Created by mike on 9/23/15.
 */
public class LovelyView extends View {
    private int circleColor, labelColor;
    private String circleText;
    private Paint circlePainter;

    public LovelyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        circlePainter = new Paint();

        TypedArray a = context
                .getTheme()
                .obtainStyledAttributes(attrs, R.styleable.LovelyView, 0, 0);
        try {
            //get the text and colors specified using the names in attrs.xml
            circleText = a.getString(R.styleable.LovelyView_circleLabel);
            circleColor = a.getInteger(R.styleable.LovelyView_circleColor, 0);//0 is default
            labelColor = a.getInteger(R.styleable.LovelyView_labelColor, 0);
        } finally {
            a.recycle();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int viewWidthHalf = this.getMeasuredWidth() / 2;
        int viewHeightHalf = this.getMeasuredHeight() / 2;

        int radius = 0;
        if (viewWidthHalf > viewHeightHalf)
            radius = viewHeightHalf - 10;
        else
            radius = viewWidthHalf - 10;
        circlePainter.setStyle(Paint.Style.FILL);
        circlePainter.setAntiAlias(true);
        circlePainter.setColor(circleColor);

        canvas.drawCircle(viewWidthHalf, viewHeightHalf, radius, circlePainter);

        circlePainter.setColor(labelColor);
        circlePainter.setTextAlign(Paint.Align.CENTER);
        circlePainter.setTextSize(50);

        canvas.drawText(circleText, viewWidthHalf, viewHeightHalf, circlePainter);

    }

    //Getters
    public int getCircleColor() {
        return circleColor;
    }

    public int getLabelColor() {
        return labelColor;
    }

    public String getLabelText() {
        return circleText;
    }

    //setters
    public void setCircleColor(int newColor) {
        circleColor = newColor;
        invalidate();
        requestLayout();
    }

    public void setLabelColor(int newColor) {
        labelColor = newColor;
        invalidate();
        requestLayout();
    }

    public void setLabelText(String text) {
        circleText = text;
        invalidate();
        requestLayout();
    }

    public void setRandomCircleColor(){
        setCircleColor(randomColor());
    }

    public void setRandomTextColor(){
        setLabelColor(randomColor());
    }

    public void setRandomText(){
        setLabelText(randomString());
    }


    //Random Shit
    private int randomColor(){
        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        return color;
    }

    private String randomString(){
        SecureRandom random = new SecureRandom();
        return new BigInteger(130, random).toString(32);
    }
}

