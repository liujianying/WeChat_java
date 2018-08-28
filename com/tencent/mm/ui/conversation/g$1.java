package com.tencent.mm.ui.conversation;

import android.content.res.ColorStateList;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.TextAppearanceSpan;
import com.tencent.mm.bp.a;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.base.NoMeasuredTextView$c;

class g$1 implements NoMeasuredTextView$c {
    final /* synthetic */ g uqa;

    g$1(g gVar) {
        this.uqa = gVar;
    }

    public final CharSequence a(NoMeasuredTextView noMeasuredTextView, CharSequence charSequence, String str, int i, int i2) {
        CharSequence ellipsize = TextUtils.ellipsize(charSequence, noMeasuredTextView.getPaint(), ((float) ((noMeasuredTextView.getMeasuredWidth() - noMeasuredTextView.getCompoundPaddingRight()) - noMeasuredTextView.getCompoundPaddingLeft())) - noMeasuredTextView.getPaint().measureText(" " + str), TruncateAt.END);
        int fromDPToPix = a.fromDPToPix(g.a(this.uqa), i2);
        CharSequence a = j.a(g.b(this.uqa), ellipsize + " " + str);
        ColorStateList ac = a.ac(g.c(this.uqa), i);
        a.setSpan(new TextAppearanceSpan(null, 0, fromDPToPix, ac, ac), ellipsize.length() + 1, (ellipsize.length() + 1) + str.length(), 33);
        return a;
    }
}
