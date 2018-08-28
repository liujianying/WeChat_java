package com.google.android.gms.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.google.android.gms.c.k;
import com.google.android.gms.c.l;
import com.google.android.gms.c.l$a;

public abstract class a {
    final a aMR;
    protected int aMS;
    protected int aMT;

    final void a(Context context, Bitmap bitmap) {
        if (bitmap == null) {
            throw new IllegalArgumentException("null reference");
        }
        if ((this.aMT & 1) != 0) {
            bitmap = k.g(bitmap);
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), bitmap);
        pb();
    }

    final void a(Context context, l lVar) {
        if (this.aMS != 0) {
            int i = this.aMS;
            Resources resources = context.getResources();
            if (this.aMT > 0) {
                l$a l_a = new l$a(i, this.aMT);
                if (((Drawable) lVar.get(l_a)) == null) {
                    Object drawable = resources.getDrawable(i);
                    if ((this.aMT & 1) != 0) {
                        Bitmap bitmap;
                        if (drawable == null) {
                            bitmap = null;
                        } else if (drawable instanceof BitmapDrawable) {
                            bitmap = ((BitmapDrawable) drawable).getBitmap();
                        } else {
                            Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Config.ARGB_8888);
                            Canvas canvas = new Canvas(createBitmap);
                            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                            drawable.draw(canvas);
                            bitmap = createBitmap;
                        }
                        drawable = new BitmapDrawable(resources, k.g(bitmap));
                    }
                    lVar.put(l_a, drawable);
                }
            } else {
                resources.getDrawable(i);
            }
        }
        pb();
    }

    protected abstract void pb();
}
