package com.tencent.mm.br;

import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.SpannableString;

class b$1 extends Factory {
    final /* synthetic */ b sLI;

    b$1(b bVar) {
        this.sLI = bVar;
    }

    public final Spannable newSpannable(CharSequence charSequence) {
        return new SpannableString(charSequence);
    }
}
