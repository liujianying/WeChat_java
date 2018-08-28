package android.support.v7.widget;

import android.graphics.drawable.Drawable;
import android.support.v4.content.a;
import android.support.v7.a.a.k;
import android.util.AttributeSet;
import android.widget.ImageView;

public final class i {
    private final ImageView MD;
    private final h Mb;

    public i(ImageView imageView, h hVar) {
        this.MD = imageView;
        this.Mb = hVar;
    }

    public final void b(AttributeSet attributeSet, int i) {
        ap a = ap.a(this.MD.getContext(), attributeSet, k.AppCompatImageView, i);
        try {
            Drawable bP = a.bP(k.AppCompatImageView_android_src);
            if (bP != null) {
                this.MD.setImageDrawable(bP);
            }
            int resourceId = a.getResourceId(k.AppCompatImageView_srcCompat, -1);
            if (resourceId != -1) {
                bP = this.Mb.a(this.MD.getContext(), resourceId, false);
                if (bP != null) {
                    this.MD.setImageDrawable(bP);
                }
            }
            bP = this.MD.getDrawable();
            if (bP != null) {
                w.m(bP);
            }
            a.Ww.recycle();
        } catch (Throwable th) {
            a.Ww.recycle();
        }
    }

    public final void setImageResource(int i) {
        if (i != 0) {
            Drawable a = this.Mb != null ? this.Mb.a(this.MD.getContext(), i, false) : a.f(this.MD.getContext(), i);
            if (a != null) {
                w.m(a);
            }
            this.MD.setImageDrawable(a);
            return;
        }
        this.MD.setImageDrawable(null);
    }
}
