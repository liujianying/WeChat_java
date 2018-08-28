package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.view.View;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Arrays;

class a$1 implements Runnable {
    final /* synthetic */ View qfm;
    final /* synthetic */ a qfn;

    a$1(a aVar, View view) {
        this.qfn = aVar;
        this.qfm = view;
    }

    public final void run() {
        this.qfn.qff[0][0] = this.qfm.getY();
        this.qfn.qff[0][1] = 0.0f;
        this.qfn.qff[1][0] = this.qfm.getX();
        this.qfn.qff[1][1] = 0.0f;
        this.qfn.qff[2][0] = (float) this.qfm.getMeasuredWidth();
        this.qfn.qff[2][1] = (float) (this.qfm.getMeasuredWidth() + (this.qfn.qeT * 2));
        x.i("MicroMsg.FTS.SosAnimatorBaseController", "searchBarData %s", new Object[]{Arrays.toString(this.qfn.qff)});
    }
}
