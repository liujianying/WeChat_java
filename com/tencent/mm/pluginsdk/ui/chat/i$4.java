package com.tencent.mm.pluginsdk.ui.chat;

import com.tencent.mm.sdk.platformtools.al.a;

class i$4 implements a {
    final /* synthetic */ i qMU;

    i$4(i iVar) {
        this.qMU = iVar;
    }

    public final boolean vD() {
        i iVar = this.qMU;
        if (iVar.qMQ != null) {
            iVar.qMQ.dismiss();
        }
        return false;
    }
}
