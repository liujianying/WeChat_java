package com.tencent.mm.pluginsdk.ui;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.mm.aa.f.c;
import com.tencent.mm.sdk.platformtools.x;
import junit.framework.Assert;

public final class a extends i implements c {

    public interface a {
        void doInvalidate();

        Drawable getDrawable();

        void setImageDrawable(Drawable drawable);
    }

    public static class b {
        public static com.tencent.mm.pluginsdk.ui.i.a lZs;

        public static com.tencent.mm.pluginsdk.ui.i.a ccZ() {
            Assert.assertTrue(lZs != null);
            return lZs;
        }

        public static void a(ImageView imageView, String str) {
            if (imageView == null) {
                x.e("MicroMsg.AvatarDrawable", "imageView is null");
                return;
            }
            Drawable drawable = imageView.getDrawable();
            if (drawable == null || !(drawable instanceof a)) {
                drawable = new a(str, 0);
            } else {
                drawable = (a) drawable;
            }
            drawable.Tw(str);
            imageView.setImageDrawable(drawable);
            imageView.invalidate();
        }

        public static void n(ImageView imageView, String str) {
            a(imageView, str, 0.5f, false);
        }

        public static void o(ImageView imageView, String str) {
            a(imageView, str, 0.5f, true);
        }

        public static void a(ImageView imageView, String str, float f, boolean z) {
            Drawable drawable = imageView.getDrawable();
            if (drawable == null || !(drawable instanceof b)) {
                drawable = new b(str, f);
                drawable.kD(z);
            } else {
                drawable = (b) drawable;
            }
            drawable.Tw(str);
            imageView.setImageDrawable(drawable);
            imageView.invalidate();
        }

        public static void p(ImageView imageView, String str) {
            Drawable drawable = imageView.getDrawable();
            if (drawable == null || !(drawable instanceof a)) {
                drawable = new a(str, (short) 0);
            } else {
                drawable = (a) drawable;
            }
            drawable.Tw(str);
            imageView.setImageDrawable(drawable);
            imageView.invalidate();
        }

        public static void a(a aVar, String str) {
            Drawable drawable = aVar.getDrawable();
            if (drawable == null || !(drawable instanceof a)) {
                drawable = new a(str, 0);
            } else {
                drawable = (a) drawable;
            }
            drawable.Tw(str);
            aVar.setImageDrawable(drawable);
            aVar.doInvalidate();
        }

        public static void g(ImageView imageView, String str, int i) {
            if (imageView != null) {
                Drawable drawable = imageView.getDrawable();
                if (drawable == null || !(drawable instanceof c)) {
                    drawable = new c(str);
                } else {
                    drawable = (c) drawable;
                }
                if (drawable.qEL != i || drawable.qEK == null || drawable.qEK.hqv == null || drawable.qEK.hqv.isRecycled()) {
                    drawable.qEL = i;
                    Bitmap CV = com.tencent.mm.sdk.platformtools.c.CV(i);
                    if (drawable.qEK != null) {
                        drawable.qEK.hqv = CV;
                    }
                }
                drawable.Tw(str);
                imageView.setImageDrawable(drawable);
                imageView.invalidate();
            }
        }
    }

    private a(String str) {
        super(b.lZs, str);
    }

    private a(String str, byte b) {
        super(b.lZs, str, (byte) 0);
    }

    public final void jX(String str) {
        super.jX(str);
    }
}
