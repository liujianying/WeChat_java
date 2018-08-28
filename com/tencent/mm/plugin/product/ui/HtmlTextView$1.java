package com.tencent.mm.plugin.product.ui;

import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.widget.TextView.BufferType;
import com.tencent.mm.sdk.platformtools.ah.a;

class HtmlTextView$1 implements a {
    private volatile Spanned lSa;
    final /* synthetic */ String lSb;
    final /* synthetic */ HtmlTextView lSc;

    HtmlTextView$1(HtmlTextView htmlTextView, String str) {
        this.lSc = htmlTextView;
        this.lSb = str;
    }

    public final boolean Kr() {
        this.lSa = HtmlTextView.a(this.lSc, this.lSb);
        return true;
    }

    public final boolean Ks() {
        HtmlTextView.a(this.lSc, this.lSa, BufferType.SPANNABLE);
        this.lSc.setMovementMethod(LinkMovementMethod.getInstance());
        return true;
    }

    public final String toString() {
        return super.toString() + "|setText";
    }
}
