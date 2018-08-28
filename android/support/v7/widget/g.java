package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.b.a.a;
import android.support.v4.widget.c;
import android.support.v7.a.a.k;
import android.util.AttributeSet;
import android.widget.CompoundButton;

final class g {
    private final h Mb;
    private final CompoundButton Mi;
    ColorStateList Mj = null;
    Mode Mk = null;
    private boolean Ml = false;
    private boolean Mm = false;
    private boolean Mn;

    g(CompoundButton compoundButton, h hVar) {
        this.Mi = compoundButton;
        this.Mb = hVar;
    }

    final void b(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.Mi.getContext().obtainStyledAttributes(attributeSet, k.CompoundButton, i, 0);
        try {
            if (obtainStyledAttributes.hasValue(k.CompoundButton_android_button)) {
                int resourceId = obtainStyledAttributes.getResourceId(k.CompoundButton_android_button, 0);
                if (resourceId != 0) {
                    this.Mi.setButtonDrawable(this.Mb.a(this.Mi.getContext(), resourceId, false));
                }
            }
            if (obtainStyledAttributes.hasValue(k.CompoundButton_buttonTint)) {
                c.a(this.Mi, obtainStyledAttributes.getColorStateList(k.CompoundButton_buttonTint));
            }
            if (obtainStyledAttributes.hasValue(k.CompoundButton_buttonTintMode)) {
                c.a(this.Mi, w.aZ(obtainStyledAttributes.getInt(k.CompoundButton_buttonTintMode, -1)));
            }
            obtainStyledAttributes.recycle();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
        }
    }

    final void setSupportButtonTintList(ColorStateList colorStateList) {
        this.Mj = colorStateList;
        this.Ml = true;
        eI();
    }

    final void setSupportButtonTintMode(Mode mode) {
        this.Mk = mode;
        this.Mm = true;
        eI();
    }

    final void eH() {
        if (this.Mn) {
            this.Mn = false;
            return;
        }
        this.Mn = true;
        eI();
    }

    private void eI() {
        Drawable a = c.a(this.Mi);
        if (a == null) {
            return;
        }
        if (this.Ml || this.Mm) {
            a = a.g(a).mutate();
            if (this.Ml) {
                a.a(a, this.Mj);
            }
            if (this.Mm) {
                a.a(a, this.Mk);
            }
            if (a.isStateful()) {
                a.setState(this.Mi.getDrawableState());
            }
            this.Mi.setButtonDrawable(a);
        }
    }

    final int aU(int i) {
        if (VERSION.SDK_INT >= 17) {
            return i;
        }
        Drawable a = c.a(this.Mi);
        if (a != null) {
            return i + a.getIntrinsicWidth();
        }
        return i;
    }
}
