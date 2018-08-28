package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

class l$3 implements Callback {
    final /* synthetic */ l Aj;

    l$3(l lVar) {
        this.Aj = lVar;
    }

    public final void invalidateDrawable(Drawable drawable) {
        this.Aj.invalidateSelf();
    }

    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        this.Aj.scheduleSelf(runnable, j);
    }

    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        this.Aj.unscheduleSelf(runnable);
    }
}
