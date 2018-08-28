package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.sdk.platformtools.x;

class v$3 implements v$c {
    final /* synthetic */ v mdU;

    v$3(v vVar) {
        this.mdU = vVar;
    }

    public final void bot() {
        x.d("MicroMsg.ShareModeMailAppService", "uploadMsgImg, finshed upload all msg img");
        this.mdU.uW(90);
        v vVar = this.mdU;
        if (vVar.mdM != null && vVar.mdM.size() > 0) {
            vVar.mdM.clear();
        }
        this.mdU.bos();
    }
}
