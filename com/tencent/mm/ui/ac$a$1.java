package com.tencent.mm.ui;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.ac.a;

class ac$a$1 implements Runnable {
    final /* synthetic */ a tpA;

    ac$a$1(a aVar) {
        this.tpA = aVar;
    }

    public final void run() {
        boolean z = true;
        String str = "MicroMsg.LauncherUI.NewChattingTabUI";
        String str2 = "on select image ActivityResult. after creat chattingUI, chatting fragment is null? %B";
        Object[] objArr = new Object[1];
        if (this.tpA.tpr.tpn != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        x.d(str, str2, objArr);
        if (this.tpA.tpr.tpn != null) {
            x.d("MicroMsg.LauncherUI.NewChattingTabUI", "on select image ActivityResult. do post activity result");
            this.tpA.tpr.tpn.onActivityResult(this.tpA.bRZ & 65535, this.tpA.bjW, this.tpA.bSa);
        }
    }

    public final String toString() {
        return super.toString() + "|PostSelectImageJob_onActivityResult";
    }
}
