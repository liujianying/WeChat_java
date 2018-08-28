package com.tencent.mm.pluginsdk.ui.applet;

import com.tencent.mm.pluginsdk.ui.applet.k.b;
import com.tencent.mm.sdk.platformtools.x;

class i$2 implements b {
    final /* synthetic */ i qIU;

    i$2(i iVar) {
        this.qIU = iVar;
    }

    public final boolean oe(int i) {
        if (this.qIU.qIM.qJi && this.qIU.qIM.Cb(i) && !this.qIU.qIM.Ca(i)) {
            x.d("MicroMsg.ContactListArchor", "onItemLongClick " + i);
        }
        return true;
    }
}
