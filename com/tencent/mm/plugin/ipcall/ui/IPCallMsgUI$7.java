package com.tencent.mm.plugin.ipcall.ui;

import android.os.Looper;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ag;

class IPCallMsgUI$7 implements a {
    final /* synthetic */ IPCallMsgUI kwA;

    IPCallMsgUI$7(IPCallMsgUI iPCallMsgUI) {
        this.kwA = iPCallMsgUI;
    }

    public final void a(String str, l lVar) {
        new ag(Looper.getMainLooper()).post(new 1(this));
    }
}
