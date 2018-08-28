package com.tencent.mm.ui;

import android.content.Intent;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class ac$a implements Runnable {
    int bRZ;
    Intent bSa;
    int bjW;
    final /* synthetic */ ac tpr;
    int tpz;

    private ac$a(ac acVar) {
        this.tpr = acVar;
        this.tpz = 0;
    }

    /* synthetic */ ac$a(ac acVar, byte b) {
        this(acVar);
    }

    public final void run() {
        if (au.HX() && this.tpr.nfG != null) {
            x.i("MicroMsg.LauncherUI.NewChattingTabUI", "on post select image job, acc has ready, retry count %d", new Object[]{Integer.valueOf(this.tpz)});
            this.tpr.startChatting(this.tpr.tpk, null, false);
            ah.A(new 1(this));
        } else if (this.tpz >= 3) {
            x.w("MicroMsg.LauncherUI.NewChattingTabUI", "on post select image job, match max retry count");
        } else {
            boolean z;
            String str = "MicroMsg.LauncherUI.NewChattingTabUI";
            String str2 = "on post select image job, acc not ready or view init(%B), cur retry count %d";
            Object[] objArr = new Object[2];
            if (this.tpr.nfG != null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            objArr[1] = Integer.valueOf(this.tpz);
            x.w(str, str2, objArr);
            this.tpz++;
            ah.i(this, 300);
        }
    }

    public final String toString() {
        return super.toString() + "|PostSelectImageJob";
    }
}
