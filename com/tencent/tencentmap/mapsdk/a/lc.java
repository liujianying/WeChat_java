package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class lc implements ld {
    private Context a;
    private ImageView b = new ImageView(this.a);

    public lc(Context context) {
        this.a = context;
    }

    public void a(int i, int i2) {
    }

    public void a() {
    }

    public boolean a(ViewGroup viewGroup) {
        if (viewGroup == null || this.b == null) {
            return false;
        }
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.b.setLayoutParams(layoutParams);
        this.b.setImageBitmap(b(viewGroup));
        viewGroup.addView(this.b);
        return true;
    }

    private Bitmap b(ViewGroup viewGroup) {
        int height;
        String str = "鉴权失败,请到腾讯";
        String str2 = "地图官网申请开发密钥";
        Paint paint = new Paint();
        int width = ((int) (((double) viewGroup.getWidth()) * 0.6d)) / 10;
        if (width <= 0) {
            width = 1;
        }
        paint.setTextSize((float) width);
        paint.setColor(-65536);
        Rect rect = new Rect();
        paint.getTextBounds(str, 0, str.length(), rect);
        Rect rect2 = new Rect();
        paint.getTextBounds(str2, 0, str2.length(), rect2);
        if (rect.width() > rect2.width()) {
            width = rect.width();
        } else {
            width = rect2.width();
        }
        if (rect.height() > rect2.height()) {
            height = rect.height();
        } else {
            height = rect2.height();
        }
        Bitmap createBitmap = Bitmap.createBitmap(width + 2, (height * 2) + 2, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawText(str, (float) ((width - rect.width()) / 2), (float) rect.height(), paint);
        canvas.drawText(str2, (float) ((width - rect2.width()) / 2), (float) ((rect2.height() * 2) + 2), paint);
        return createBitmap;
    }
}
