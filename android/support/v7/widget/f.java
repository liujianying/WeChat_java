package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.z;
import android.support.v7.a.a.k;
import android.util.AttributeSet;
import android.view.View;

final class f {
    private final h Mb;
    private an Me;
    private an Mf;
    private an Mg;
    private final View mView;

    f(View view, h hVar) {
        this.mView = view;
        this.Mb = hVar;
    }

    final void b(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.mView.getContext().obtainStyledAttributes(attributeSet, k.ViewBackgroundHelper, i, 0);
        try {
            if (obtainStyledAttributes.hasValue(k.ViewBackgroundHelper_android_background)) {
                ColorStateList j = this.Mb.j(this.mView.getContext(), obtainStyledAttributes.getResourceId(k.ViewBackgroundHelper_android_background, -1));
                if (j != null) {
                    b(j);
                }
            }
            if (obtainStyledAttributes.hasValue(k.ViewBackgroundHelper_backgroundTint)) {
                z.a(this.mView, obtainStyledAttributes.getColorStateList(k.ViewBackgroundHelper_backgroundTint));
            }
            if (obtainStyledAttributes.hasValue(k.ViewBackgroundHelper_backgroundTintMode)) {
                z.a(this.mView, w.aZ(obtainStyledAttributes.getInt(k.ViewBackgroundHelper_backgroundTintMode, -1)));
            }
            obtainStyledAttributes.recycle();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
        }
    }

    final void aT(int i) {
        b(this.Mb != null ? this.Mb.j(this.mView.getContext(), i) : null);
    }

    final void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.Mf == null) {
            this.Mf = new an();
        }
        this.Mf.Ws = colorStateList;
        this.Mf.Wu = true;
        eG();
    }

    final ColorStateList getSupportBackgroundTintList() {
        return this.Mf != null ? this.Mf.Ws : null;
    }

    final void setSupportBackgroundTintMode(Mode mode) {
        if (this.Mf == null) {
            this.Mf = new an();
        }
        this.Mf.kJ = mode;
        this.Mf.Wt = true;
        eG();
    }

    final Mode getSupportBackgroundTintMode() {
        return this.Mf != null ? this.Mf.kJ : null;
    }

    final void eG() {
        boolean z = false;
        Drawable background = this.mView.getBackground();
        if (background != null) {
            if (VERSION.SDK_INT == 21) {
                if (this.Mg == null) {
                    this.Mg = new an();
                }
                an anVar = this.Mg;
                anVar.Ws = null;
                anVar.Wu = false;
                anVar.kJ = null;
                anVar.Wt = false;
                ColorStateList ae = z.ae(this.mView);
                if (ae != null) {
                    anVar.Wu = true;
                    anVar.Ws = ae;
                }
                Mode af = z.af(this.mView);
                if (af != null) {
                    anVar.Wt = true;
                    anVar.kJ = af;
                }
                if (anVar.Wu || anVar.Wt) {
                    h.a(background, anVar, this.mView.getDrawableState());
                    z = true;
                }
                if (z) {
                    return;
                }
            }
            if (this.Mf != null) {
                h.a(background, this.Mf, this.mView.getDrawableState());
            } else if (this.Me != null) {
                h.a(background, this.Me, this.mView.getDrawableState());
            }
        }
    }

    final void b(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.Me == null) {
                this.Me = new an();
            }
            this.Me.Ws = colorStateList;
            this.Me.Wu = true;
        } else {
            this.Me = null;
        }
        eG();
    }
}
