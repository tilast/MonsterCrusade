package com.da.MonsterCrusade.entities;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import com.da.MonsterCrusade.entities.components.Speed;

/**
 * Created by sancho on 04.04.15.
 */
public class Hero {
    private Bitmap bitmap;
    private int x;
    private int y;
    private boolean touched;
    private double speed;

    public Hero(Bitmap bitmap, int x, int y) {
        this.bitmap = bitmap;
        this.x = x;
        this.y = y;
        speed = 1 / 10.0;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isTouched() {
        return touched;
    }

    public void setTouched(boolean touched) {
        this.touched = touched;
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(bitmap, x - (bitmap.getWidth() / 2), y - (bitmap.getHeight() / 2), null);
    }

    public void handleActionDown(int eventX, int eventY) {
        setTouched(eventX >= (x - bitmap.getWidth() / 2) && (eventX <= (x + bitmap.getWidth() / 2)) &&
                eventY >= (y - bitmap.getHeight() / 2) && (eventY <= (y + bitmap.getHeight() / 2)));
    }

    public void goWithCost(double costX, double costY) {
        x += costX * speed;
        y += costY * speed;
    }


}
