package com.sm.shahriaz.smartmenu;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;

public class PointerDrawable extends Drawable{
    private final Paint paint = new Paint();
    private boolean enabled;

    public Paint getPaint() {
        return paint;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        float cx = canvas.getWidth()/2;
        float cy = canvas.getHeight()/2;
        if(enabled){
            paint.setColor(Color.GREEN);
            canvas.drawCircle(cx,cy,1,paint);
        } else {
            paint.setColor(Color.RED);
            canvas.drawText("X",cx,cy,paint);
        }

    }

    @Override
    public void setAlpha(int alpha) {

    }

    @Override
    public void setColorFilter(@NonNull ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return PixelFormat.OPAQUE;
    }
}