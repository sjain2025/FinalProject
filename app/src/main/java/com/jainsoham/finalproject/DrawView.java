package com.jainsoham.finalproject;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.DashPathEffect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DrawView extends View {
    private final Paint backboardColor1 = new Paint();
    private final Paint backboardColor2 = new Paint();
    private final Paint basketballPaint = new Paint();
    private final Paint borderPaint = new Paint();
    private final Paint dottedLinePaint = new Paint();
    private float hoopX = 250.0f;
    private float hoopY = 300.0f;
    private float basketballX = 550.0f;
    private float basketballY = 1500.0f;
    private float basketballSize = 90.0f;
    private float hoopDX = 8.0f;
    private final Path path = new Path();
    private boolean isSwiping = false;
    private float swipeStartX, swipeStartY;

    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initialize();
    }

    private void initialize() {
        borderPaint.setStyle(Paint.Style.STROKE);
        borderPaint.setStrokeWidth(3);
        borderPaint.setColor(Color.BLACK);

        backboardColor1.setColor(Color.rgb(255, 130, 0));
        backboardColor2.setColor(Color.WHITE);

        basketballPaint.setColor(Color.rgb(255, 130, 0));

        dottedLinePaint.setColor(Color.BLACK);
        dottedLinePaint.setStyle(Paint.Style.STROKE);
        dottedLinePaint.setStrokeWidth(10);
        dottedLinePaint.setPathEffect(new DashPathEffect(new float[]{10, 20}, 0));
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawRect(hoopX, hoopY, hoopX + 600.0f, hoopY + 400.0f, backboardColor1);
        canvas.drawRect(hoopX + 20.0f, hoopY + 20.0f, hoopX + 580.0f, hoopY + 380.0f, backboardColor2);

        canvas.drawRect(hoopX - 2, hoopY - 2, hoopX + 602.0f, hoopY + 402.0f, borderPaint);
        canvas.drawRect(hoopX + 18, hoopY + 18, hoopX + 582.0f, hoopY + 382.0f, borderPaint);

        canvas.drawRect(hoopX + 180.0f, hoopY + 120.0f, hoopX + 420.0f, hoopY + 288.0f, backboardColor1);
        canvas.drawRect(hoopX + 200.0f, hoopY + 140.0f, hoopX + 400.0f, hoopY + 268.0f, backboardColor2);

        canvas.drawRect(hoopX + 178.0f, hoopY + 118.0f, hoopX + 422.0f, hoopY + 290.0f, borderPaint);
        canvas.drawRect(hoopX + 198.0f, hoopY + 138.0f, hoopX + 402.0f, hoopY + 270.0f, borderPaint);

        float cornerRadius = 20.0f;
        canvas.drawRoundRect(hoopX + 170.0f, hoopY + 320.0f, hoopX + 430.0f, hoopY + 348.0f, cornerRadius, cornerRadius, backboardColor1);
        canvas.drawRoundRect(hoopX + 168.0f, hoopY + 318.0f, hoopX + 432.0f, hoopY + 350.0f, cornerRadius, cornerRadius, borderPaint);

        borderPaint.setStrokeWidth(8);
        canvas.drawLine(hoopX + 170.0f, hoopY + 340.0f, hoopX + 240.0f, hoopY + 530.0f, borderPaint);
        canvas.drawLine(hoopX + 200.0f, hoopY + 340.0f, hoopX + 270.0f, hoopY + 530.0f, borderPaint);
        canvas.drawLine(hoopX + 230.0f, hoopY + 340.0f, hoopX + 300.0f, hoopY + 530.0f, borderPaint);
        canvas.drawLine(hoopX + 260.0f, hoopY + 340.0f, hoopX + 330.0f, hoopY + 530.0f, borderPaint);
        canvas.drawLine(hoopX + 290.0f, hoopY + 340.0f, hoopX + 360.0f, hoopY + 530.0f, borderPaint);
        canvas.drawLine(hoopX + 320.0f, hoopY + 340.0f, hoopX + 375.0f, hoopY + 500.0f, borderPaint);
        canvas.drawLine(hoopX + 350.0f, hoopY + 340.0f, hoopX + 390.0f, hoopY + 465.0f, borderPaint);
        canvas.drawLine(hoopX + 380.0f, hoopY + 340.0f, hoopX + 405.0f, hoopY + 425.0f, borderPaint);

        canvas.drawLine(hoopX + 430.0f, hoopY + 340.0f, hoopX + 360.0f, hoopY + 530.0f, borderPaint);
        canvas.drawLine(hoopX + 400.0f, hoopY + 340.0f, hoopX + 330.0f, hoopY + 530.0f, borderPaint);
        canvas.drawLine(hoopX + 370.0f, hoopY + 340.0f, hoopX + 300.0f, hoopY + 530.0f, borderPaint);
        canvas.drawLine(hoopX + 340.0f, hoopY + 340.0f, hoopX + 270.0f, hoopY + 530.0f, borderPaint);
        canvas.drawLine(hoopX + 310.0f, hoopY + 340.0f, hoopX + 240.0f, hoopY + 530.0f, borderPaint);
        canvas.drawLine(hoopX + 280.0f, hoopY + 340.0f, hoopX + 225.0f, hoopY + 500.0f, borderPaint);
        canvas.drawLine(hoopX + 250.0f, hoopY + 340.0f, hoopX + 210.0f, hoopY + 465.0f, borderPaint);
        canvas.drawLine(hoopX + 220.0f, hoopY + 340.0f, hoopX + 195.0f, hoopY + 425.0f, borderPaint);

        canvas.drawCircle(basketballX, basketballY, basketballSize, basketballPaint);
        canvas.drawCircle(basketballX, basketballY, basketballSize + 2.0f, borderPaint);
        canvas.drawLine(basketballX, basketballY - basketballSize, basketballX, basketballY + basketballSize, borderPaint);
        canvas.drawLine(basketballX - basketballSize, basketballY, basketballX + basketballSize, basketballY, borderPaint);

        int x1 = (int)(basketballX - 0.6f * basketballSize);
        int y1 = (int)(basketballY - 0.8f * basketballSize);
        int x2 = (int)(basketballX - 0.6f * basketballSize);
        int y2 = (int)(basketballY + 0.8f * basketballSize);
        int midX = x1 + ((x2 - x1) / 2);
        int midY = y1 + ((y2 - y1) / 2);
        float xDiff = midX - x1;
        float yDiff = midY - y1;
        double angle = (Math.atan2(yDiff, xDiff) * (180 / Math.PI)) - 90;
        double angleRadians = Math.toRadians(angle);
        float pointX = (float) (midX + 30.0f * Math.cos(angleRadians));
        float pointY = (float) (midY + 30.0f * Math.sin(angleRadians));
        path.moveTo(x1, y1);
        path.cubicTo(x1, y1, pointX, pointY, x2, y2);
        canvas.drawPath(path, borderPaint);

        x1 = (int)(basketballX + 0.6f * basketballSize);
        y1 = (int)(basketballY - 0.8f * basketballSize);
        x2 = (int)(basketballX + 0.6f * basketballSize);
        y2 = (int)(basketballY + 0.8f * basketballSize);

        midX = x1 + ((x2 - x1) / 2);
        midY = y1 + ((y2 - y1) / 2);
        xDiff = midX - x1;
        yDiff = midY - y1;
        angle = (Math.atan2(yDiff, xDiff) * (180 / Math.PI)) - 90;
        angleRadians = Math.toRadians(angle);
        pointX = (float) (midX - 30.0f * Math.cos(angleRadians));
        pointY = (float) (midY - 30.0f * Math.sin(angleRadians));
        path.moveTo(x1, y1);
        path.cubicTo(x1, y1, pointX, pointY, x2, y2);
        canvas.drawPath(path, borderPaint);

        if (isSwiping) {
            drawDottedLine(canvas);
        }

        if (hoopX > getWidth() - 650 && hoopDX > 0) {
            hoopDX *= -1;
        } else if (hoopX < 50 && hoopDX < 0) {
            hoopDX *= -1;
        }

        hoopX += hoopDX;
        invalidate();
    }

    private void drawDottedLine(Canvas canvas) {
        Path dottedPath = new Path();
        dottedPath.moveTo(basketballX, basketballY);
        dottedPath.lineTo(swipeStartX, swipeStartY);
        canvas.drawPath(dottedPath, dottedLinePaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (isTouchingBasketball(event.getX(), event.getY())) {
                    isSwiping = true;
                    swipeStartX = event.getX();
                    swipeStartY = event.getY();
                    invalidate();
                    return true;
                }
                return false;
            case MotionEvent.ACTION_MOVE:
                if (isSwiping) {
                    swipeStartX = event.getX();
                    swipeStartY = event.getY();
                    invalidate();
                    return true;
                }
                return false;
            case MotionEvent.ACTION_UP:
                isSwiping = false;
                invalidate();
                return true;
            default:
                return super.onTouchEvent(event);
        }
    }

    private boolean isTouchingBasketball(float x, float y) {
        float dx = x - basketballX;
        float dy = y - basketballY;
        return dx * dx + dy * dy <= basketballSize * basketballSize;
    }
}
