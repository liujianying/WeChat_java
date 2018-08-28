package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

final class ao extends ad {
    private final WeakReference<Context> Wv;

    public ao(Context context, Resources resources) {
        super(resources);
        this.Wv = new WeakReference(context);
    }

    public final Drawable getDrawable(int i) {
        Drawable drawable = super.getDrawable(i);
        Context context = (Context) this.Wv.get();
        if (!(drawable == null || context == null)) {
            h.eJ();
            h.a(context, i, drawable);
        }
        return drawable;
    }
}
