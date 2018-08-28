package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

final class m extends l {
    private static final int[] Nl = new int[]{16843666, 16843667};
    private an Nm;
    private an Nn;

    m(TextView textView) {
        super(textView);
    }

    final void b(AttributeSet attributeSet, int i) {
        super.b(attributeSet, i);
        Context context = this.Ng.getContext();
        h eJ = h.eJ();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Nl, i, 0);
        if (obtainStyledAttributes.hasValue(0)) {
            this.Nm = l.a(context, eJ, obtainStyledAttributes.getResourceId(0, 0));
        }
        if (obtainStyledAttributes.hasValue(1)) {
            this.Nn = l.a(context, eJ, obtainStyledAttributes.getResourceId(1, 0));
        }
        obtainStyledAttributes.recycle();
    }

    final void eL() {
        super.eL();
        if (this.Nm != null || this.Nn != null) {
            Drawable[] compoundDrawablesRelative = this.Ng.getCompoundDrawablesRelative();
            a(compoundDrawablesRelative[0], this.Nm);
            a(compoundDrawablesRelative[2], this.Nn);
        }
    }
}
