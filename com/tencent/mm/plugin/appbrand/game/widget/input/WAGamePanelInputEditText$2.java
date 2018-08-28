package com.tencent.mm.plugin.appbrand.game.widget.input;

import android.text.InputFilter;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;

class WAGamePanelInputEditText$2 implements InputFilter {
    final /* synthetic */ WAGamePanelInputEditText fDB;

    WAGamePanelInputEditText$2(WAGamePanelInputEditText wAGamePanelInputEditText) {
        this.fDB = wAGamePanelInputEditText;
    }

    public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        Spannable spannable;
        CharSequence subSequence = charSequence.subSequence(i, i2);
        if (subSequence instanceof Spannable) {
            spannable = (Spannable) subSequence;
        } else {
            Object spannable2 = new SpannableStringBuilder(subSequence);
        }
        return WAGamePanelInputEditText.a(this.fDB, spannable2);
    }
}
