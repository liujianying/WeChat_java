package com.tencent.xweb.xwalk;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class a$16 implements OnClickListener {
    final /* synthetic */ a vEm;
    final /* synthetic */ String vEp;
    final /* synthetic */ String vEq;
    final /* synthetic */ boolean vEr;

    a$16(a aVar, String str, String str2, boolean z) {
        this.vEm = aVar;
        this.vEp = str;
        this.vEq = str2;
        this.vEr = z;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.vEm.x(this.vEp, this.vEq, this.vEr);
    }
}
