package com.tencent.mm.ui.base;

import android.text.InputFilter;
import android.text.Spanned;
import com.tencent.map.lib.gl.model.GLIcon;
import com.tencent.mm.ui.tools.g;

public class MMTagPanel$c implements InputFilter {
    final /* synthetic */ MMTagPanel txS;
    int txZ = 36;
    private int tya = GLIcon.TOP;
    private int tyb;

    public MMTagPanel$c(MMTagPanel mMTagPanel) {
        this.txS = mMTagPanel;
    }

    public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        int abd = g.abd(spanned.toString()) + g.abd(charSequence.toString());
        if (i4 > i3) {
            if (abd - (i4 - i3) > this.txZ) {
                MMTagPanel.a(this.txS, true);
                this.tyb = (abd - (i4 - i3)) - this.txZ;
            } else {
                MMTagPanel.a(this.txS, false);
            }
        } else if (abd > this.txZ) {
            MMTagPanel.a(this.txS, true);
            this.tyb = abd - this.txZ;
        } else {
            MMTagPanel.a(this.txS, false);
        }
        if (MMTagPanel.h(this.txS) && 1 == this.tyb && charSequence.equals("\n")) {
            this.tyb = 0;
        }
        if (MMTagPanel.e(this.txS) != null) {
            this.txS.post(new 1(this));
        }
        if (abd > this.tya) {
            return "";
        }
        return charSequence;
    }
}
