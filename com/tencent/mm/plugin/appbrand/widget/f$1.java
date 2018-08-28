package com.tencent.mm.plugin.appbrand.widget;

import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextUtils;

class f$1 extends Factory {
    final /* synthetic */ f gED;

    f$1(f fVar) {
        this.gED = fVar;
    }

    public final Spannable newSpannable(CharSequence charSequence) {
        Spannable newSpannable = super.newSpannable(charSequence);
        if (!(f.a(this.gED) == null || TextUtils.isEmpty(newSpannable))) {
            newSpannable.setSpan(f.a(this.gED), 0, newSpannable.length(), 18);
        }
        return newSpannable;
    }
}
