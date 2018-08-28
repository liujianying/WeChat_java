package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;
import android.view.View;
import android.view.View.MeasureSpec;

public final class oo {
    public static on a(String str) {
        no noVar = new no(2);
        noVar.a(str);
        return new on(noVar);
    }

    public static on a(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        Bitmap a = kh.a(bitmap);
        no noVar = new no(7);
        noVar.a(a);
        return new on(noVar);
    }

    public static on a(View view) {
        if (view == null) {
            return null;
        }
        try {
            view.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            view.buildDrawingCache();
            Bitmap drawingCache = view.getDrawingCache();
            on a = a(drawingCache);
            if (drawingCache != null) {
                drawingCache.recycle();
            }
            view.destroyDrawingCache();
            return a;
        } catch (Exception e) {
            return null;
        }
    }
}
