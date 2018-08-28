package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bi;

class bb$5 implements OnClickListener {
    final /* synthetic */ int bpX;
    final /* synthetic */ bb ogl;

    bb$5(bb bbVar, int i) {
        this.ogl = bbVar;
        this.bpX = i;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        g.Ek();
        int a = bi.a((Integer) g.Ei().DT().get(68386, null), 0) + 1;
        g.Ek();
        g.Ei().DT().set(68386, Integer.valueOf(a));
        this.ogl.xE(this.bpX);
    }
}
