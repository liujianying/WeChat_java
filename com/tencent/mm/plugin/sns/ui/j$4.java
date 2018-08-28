package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import com.tencent.mm.ui.widget.MMEditText.a;

class j$4 implements a {
    final /* synthetic */ j nMb;

    j$4(j jVar) {
        this.nMb = jVar;
    }

    public final void bbt() {
        if (this.nMb.nLN.getVisibility() == 0) {
            this.nMb.nLN.setVisibility(8);
        } else {
            ((Activity) j.c(this.nMb)).finish();
        }
    }
}
