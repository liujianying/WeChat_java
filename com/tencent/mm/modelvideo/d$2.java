package com.tencent.mm.modelvideo;

import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.t.a.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bc;
import java.util.Map;

class d$2 implements Runnable {
    final /* synthetic */ d emc;
    final /* synthetic */ boolean emd;
    final /* synthetic */ int eme;

    d$2(d dVar, boolean z, int i) {
        this.emc = dVar;
        this.emd = z;
        this.eme = i;
    }

    public final void run() {
        Map z = bl.z(this.emc.elW.Tm(), "msg");
        if (z != null) {
            s Ta = o.Ta();
            o.Ta();
            Ta.r(s.nK(this.emc.fileName), (String) z.get(".msg.videomsg.$cdnvideourl"), (String) z.get(".msg.videomsg.$aeskey"));
        }
        boolean z2 = false;
        if (this.emd) {
            z2 = t.U(this.emc.fileName, this.eme);
            if (this.emc.elV) {
                r nW = t.nW(this.emc.fileName);
                if (nW != null) {
                    nW.videoFormat = 1;
                    nW.bWA = 2;
                    o.Ta().b(nW);
                }
            }
        } else if (this.emc.elV) {
            t.nP(this.emc.fileName);
            h.mEJ.a(354, 138, 1, false);
        } else {
            z2 = t.U(this.emc.fileName, this.eme);
        }
        x.i("MicroMsg.NetSceneDownloadVideo", "%s ashutest::cdntra !FIN! file:%s svrid:%d human:%s user:%s updatedbsucc:%b  MediaCheckDuplicationStorage MD5:%s SIZE:%d renameFlag %b needRename %b", new Object[]{this.emc.SR(), this.emc.fileName, Long.valueOf(this.emc.elW.bYu), this.emc.elW.Tk(), this.emc.elW.Tj(), Boolean.valueOf(z2), this.emc.dVr, Integer.valueOf(this.emc.dVs), Boolean.valueOf(this.emd), Boolean.valueOf(this.emc.ema)});
        if (!bi.oW(this.emc.dVr) && this.emc.dVs > 0) {
            bc FY = ((a) g.l(a.class)).FY();
            String str = this.emc.dVr;
            int i = this.emc.dVs;
            o.Ta();
            FY.y(str, i, s.nK(this.emc.fileName));
        }
        if (this.emc.elW.enT == 3) {
            h.mEJ.a(198, 38, (long) this.emc.elW.dHI, false);
            h.mEJ.a(198, 40, (long) this.emc.elW.enM, false);
            h.mEJ.a(198, 41, 1, false);
            h.mEJ.a(198, s.fq(this.emc.elW.Tj()) ? 43 : 42, 1, false);
        } else {
            h.mEJ.a(198, 31, (long) this.emc.elW.dHI, false);
            h.mEJ.a(198, 33, (long) this.emc.elW.enM, false);
            h.mEJ.a(198, 34, 1, false);
            h.mEJ.a(198, s.fq(this.emc.elW.Tj()) ? 36 : 35, 1, false);
        }
        this.emc.diJ.a(0, 0, "", this.emc);
    }
}
