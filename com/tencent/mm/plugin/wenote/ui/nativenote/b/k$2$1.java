package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import com.tencent.mm.plugin.wenote.model.nativenote.spans.u;
import com.tencent.mm.plugin.wenote.ui.nativenote.b.k.2;

class k$2$1 implements Runnable {
    final /* synthetic */ 2 qvO;

    k$2$1(2 2) {
        this.qvO = 2;
    }

    public final void run() {
        if (this.qvO.qvN.qoQ != 0) {
            int i = k.a(this.qvO.qvL).getSelection().Tw;
            if (i == this.qvO.qvN.content.length()) {
                k.a(this.qvO.qvL).cab();
                k.a(this.qvO.qvL).getText().append("\n");
                k.a(this.qvO.qvL).cac();
                k.a(this.qvO.qvL).setSelection(i);
            }
            this.qvO.qvN.qoQ = 0;
            if (this.qvO.qvN.qoR == 1) {
                k.a(this.qvO.qvL).a(u.qtx, Boolean.valueOf(true));
            } else if (this.qvO.qvN.qoR == 3) {
                k.a(this.qvO.qvL).a(u.qtw, Boolean.valueOf(true));
            } else if (this.qvO.qvN.qoR == 2) {
                k.a(this.qvO.qvL).a(u.qty, Boolean.valueOf(true));
            }
        }
    }
}
