package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.ab.f;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.qqmail.b.v.g;
import com.tencent.mm.protocal.c.bvx;
import com.tencent.mm.sdk.platformtools.x;

class v$7 implements f {
    final /* synthetic */ v mdU;

    v$7(v vVar) {
        this.mdU = vVar;
    }

    public final void a(int i, int i2, l lVar) {
        x.i("MicroMsg.ShareModeMailAppService", "currentSendFile: %s, offset: %d, totalLen: %d, filesInfo.size: %d", new Object[]{this.mdU.mdN, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.mdU.mdM.size())});
        if (i >= i2) {
            this.mdU.mdP.put(this.mdU.mdO, ((o) lVar).boq().ruD);
            bvx boq = ((o) lVar).boq();
            if (this.mdU.mdR != null) {
                this.mdU.mdR.d(this.mdU.mdS - this.mdU.mdM.size(), this.mdU.mdS, this.mdU.mdO, boq.ruD);
            }
            if (this.mdU.mdM.isEmpty()) {
                x.i("MicroMsg.ShareModeMailAppService", "finished send all files");
                if (this.mdU.mdQ != null) {
                    this.mdU.mdQ.bot();
                    return;
                }
                return;
            }
            x.i("MicroMsg.ShareModeMailAppService", "finished send one file, continue to send another one");
            g gVar = (g) this.mdU.mdM.remove(0);
            this.mdU.mdN = gVar.fileId;
            this.mdU.mdO = gVar.fileName;
            au.DF().a(new o(this.mdU.mdO, this.mdU.mdN, this), 0);
        }
    }
}
