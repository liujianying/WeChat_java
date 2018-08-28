package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.app.e;
import java.lang.ref.WeakReference;

public final class ar extends Resources {
    private final WeakReference<Context> Wv;

    public static boolean hi() {
        return e.dg() && VERSION.SDK_INT <= 20;
    }

    public ar(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.Wv = new WeakReference(context);
    }

    public final Drawable getDrawable(int i) {
        Context context = (Context) this.Wv.get();
        if (context == null) {
            return super.getDrawable(i);
        }
        h eJ = h.eJ();
        Drawable i2 = eJ.i(context, i);
        if (i2 == null) {
            i2 = super.getDrawable(i);
        }
        return i2 != null ? eJ.a(context, i, false, i2) : null;
    }
}
