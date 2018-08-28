package com.tencent.mm.plugin.appbrand.jsapi.k;

import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.jsapi.k.d.2;
import com.tencent.mm.plugin.appbrand.widget.g.a;

class d$2$3 extends Factory {
    final /* synthetic */ 2 fXX;
    final /* synthetic */ int fXY;

    d$2$3(2 2, int i) {
        this.fXX = 2;
        this.fXY = i;
    }

    public final Spannable newSpannable(CharSequence charSequence) {
        Spannable newSpannable = super.newSpannable(charSequence);
        if (!TextUtils.isEmpty(newSpannable)) {
            newSpannable.setSpan(new a((float) this.fXY), 0, newSpannable.length(), 18);
        }
        return newSpannable;
    }
}
