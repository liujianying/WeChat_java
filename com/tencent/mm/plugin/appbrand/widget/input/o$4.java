package com.tencent.mm.plugin.appbrand.widget.input;

import android.text.InputFilter;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;

class o$4 implements InputFilter {
    final /* synthetic */ o gHL;

    o$4(o oVar) {
        this.gHL = oVar;
    }

    public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        if (TextUtils.isEmpty(charSequence) || o.a(this.gHL) == null) {
            return null;
        }
        if (charSequence instanceof Spannable) {
            charSequence = (Spannable) charSequence;
        } else {
            Object spannableStringBuilder = new SpannableStringBuilder(charSequence);
        }
        charSequence.setSpan(o.a(this.gHL), 0, charSequence.length(), 18);
        return charSequence;
    }
}
