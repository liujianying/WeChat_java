package com.tencent.mm.plugin.appbrand.widget.input;

import android.text.Spanned;
import android.widget.EditText;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.tools.a.c.a;
import com.tencent.mm.ui.tools.g;

final class n$b extends g {
    final /* synthetic */ n gHA;
    private final int gHy;
    private final int gHz;

    n$b(n nVar, int i, int i2) {
        this.gHA = nVar;
        super(i, i2);
        this.gHy = i;
        this.gHz = i2;
    }

    public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        int i5 = 0;
        if (du(spanned.subSequence(0, i3).toString() + spanned.subSequence(i4, spanned.length()).toString(), this.gHz) + du(charSequence.subSequence(i, i2).toString(), this.gHz) > this.gHy) {
            i5 = 1;
        }
        if (i5 != 0) {
            charSequence = charSequence.subSequence(i, Math.max(i, Math.min(this.gHy - (spanned.length() - (i4 - i3)), i2)));
        }
        if (i5 != 0 && bi.K(charSequence)) {
            EditText editText = this.gHA.uCS == null ? null : (EditText) this.gHA.uCS.get();
            a aVar = this.gHA.uCW;
            if (!(editText == null || aVar == null)) {
                editText.post(new 1(this, aVar));
            }
        }
        return charSequence;
    }
}
