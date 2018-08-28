package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.a.a.a;
import android.support.v7.a.a.k;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;

class l {
    private static final int[] Ne = new int[]{16842804, 16843119, 16843117, 16843120, 16843118};
    private static final int[] Nf = new int[]{a.textAllCaps};
    final TextView Ng;
    private an Nh;
    private an Ni;
    private an Nj;
    private an Nk;

    static l c(TextView textView) {
        if (VERSION.SDK_INT >= 17) {
            return new m(textView);
        }
        return new l(textView);
    }

    l(TextView textView) {
        this.Ng = textView;
    }

    void b(AttributeSet attributeSet, int i) {
        int i2 = 1;
        Context context = this.Ng.getContext();
        h eJ = h.eJ();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Ne, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        if (obtainStyledAttributes.hasValue(1)) {
            this.Nh = a(context, eJ, obtainStyledAttributes.getResourceId(1, 0));
        }
        if (obtainStyledAttributes.hasValue(2)) {
            this.Ni = a(context, eJ, obtainStyledAttributes.getResourceId(2, 0));
        }
        if (obtainStyledAttributes.hasValue(3)) {
            this.Nj = a(context, eJ, obtainStyledAttributes.getResourceId(3, 0));
        }
        if (obtainStyledAttributes.hasValue(4)) {
            this.Nk = a(context, eJ, obtainStyledAttributes.getResourceId(4, 0));
        }
        obtainStyledAttributes.recycle();
        if (!(this.Ng.getTransformationMethod() instanceof PasswordTransformationMethod)) {
            boolean z;
            int i3;
            boolean i32;
            if (resourceId != -1) {
                TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, k.TextAppearance);
                if (obtainStyledAttributes2.hasValue(k.TextAppearance_textAllCaps)) {
                    z = obtainStyledAttributes2.getBoolean(k.TextAppearance_textAllCaps, false);
                    i32 = 1;
                } else {
                    i32 = false;
                    z = false;
                }
                obtainStyledAttributes2.recycle();
            } else {
                i32 = false;
                z = false;
            }
            TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, Nf, i, 0);
            if (obtainStyledAttributes3.hasValue(0)) {
                z = obtainStyledAttributes3.getBoolean(0, false);
            } else {
                i2 = i32;
            }
            obtainStyledAttributes3.recycle();
            if (i2 != 0) {
                setAllCaps(z);
            }
        }
    }

    final void l(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, Nf);
        if (obtainStyledAttributes.hasValue(0)) {
            setAllCaps(obtainStyledAttributes.getBoolean(0, false));
        }
        obtainStyledAttributes.recycle();
    }

    final void setAllCaps(boolean z) {
        this.Ng.setTransformationMethod(z ? new android.support.v7.e.a(this.Ng.getContext()) : null);
    }

    void eL() {
        if (this.Nh != null || this.Ni != null || this.Nj != null || this.Nk != null) {
            Drawable[] compoundDrawables = this.Ng.getCompoundDrawables();
            a(compoundDrawables[0], this.Nh);
            a(compoundDrawables[1], this.Ni);
            a(compoundDrawables[2], this.Nj);
            a(compoundDrawables[3], this.Nk);
        }
    }

    final void a(Drawable drawable, an anVar) {
        if (drawable != null && anVar != null) {
            h.a(drawable, anVar, this.Ng.getDrawableState());
        }
    }

    protected static an a(Context context, h hVar, int i) {
        ColorStateList j = hVar.j(context, i);
        if (j == null) {
            return null;
        }
        an anVar = new an();
        anVar.Wu = true;
        anVar.Ws = j;
        return anVar;
    }
}
