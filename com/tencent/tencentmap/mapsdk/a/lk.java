package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.widget.ImageView;

public class lk extends ImageView {
    public lk(Context context) {
        super(context);
        setClickable(true);
    }

    public void a(Context context, Bitmap bitmap, Bitmap bitmap2) {
        Drawable stateListDrawable = new StateListDrawable();
        Drawable bitmapDrawable = new BitmapDrawable(context.getResources(), bitmap);
        stateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, new BitmapDrawable(context.getResources(), bitmap2));
        stateListDrawable.addState(View.ENABLED_STATE_SET, bitmapDrawable);
        setBackgroundDrawable(stateListDrawable);
    }

    public void a() {
        setClickable(false);
        Drawable background = getBackground();
        if (background != null) {
            background.setCallback(null);
        }
        setBackgroundDrawable(null);
    }
}
