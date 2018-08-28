package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMPullDownView.e;

class bb$13 implements e {
    final /* synthetic */ bb ogl;

    bb$13(bb bbVar) {
        this.ogl = bbVar;
    }

    public final boolean aCg() {
        x.e("MicroMsg.SnsActivity", "bottomLoad  isAll:" + this.ogl.ofU);
        if (!this.ogl.ofU) {
            bb.g(this.ogl);
        }
        return true;
    }
}
