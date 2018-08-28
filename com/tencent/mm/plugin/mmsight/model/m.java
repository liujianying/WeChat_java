package com.tencent.mm.plugin.mmsight.model;

import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.plugin.mmsight.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.aso;
import com.tencent.mm.sdk.platformtools.x;

public final class m implements v {
    public final void ob(String str) {
        final r nI = o.Ta().nI(str);
        if (nI != null) {
            o.Ta();
            final String nK = s.nK(str);
            aso aso = nI.enW;
            VideoTransPara NQ = d.NP().NQ();
            if (aso != null) {
                x.i("MicroMsg.MMSightVideoMsgSendCallback", "beforeVideoSend count %d filename %s filePath %s", new Object[]{Integer.valueOf(aso.rUQ), str, nK});
                if (aso.rUQ > 1) {
                    t.nP(str);
                    return;
                }
            }
            boolean a = l.a(nK, NQ, aso, new d() {
                public final boolean bcM() {
                    x.i("MicroMsg.MMSightVideoMsgSendCallback", "iUpdateVideoFile1 %s", new Object[]{nK});
                    nI.dHI = s.nM(nK);
                    nI.bWA = 32;
                    o.Ta().b(nI);
                    return true;
                }
            });
            if (aso != null) {
                x.i("MicroMsg.MMSightVideoMsgSendCallback", "filename: %s need ret: %s", new Object[]{str, Boolean.valueOf(a)});
                aso.rUT = !a;
                nI.enW = aso;
                nI.bWA = 536870912;
                o.Ta().b(nI);
            }
            if (a) {
                if (aso != null) {
                    aso.rUQ++;
                    nI.enW = aso;
                }
                nI.bWA = 536870912;
                o.Ta().b(nI);
                c.sI(nI.enN);
                if (l.b(nK, NQ, aso, new 2(this, nI, nK)) < 0) {
                    x.i("MicroMsg.MMSightRecorderIDKeyStat", "mark720CapturePostCompressFailed");
                    h.mEJ.a(440, 45, 1, false);
                    t.nP(str);
                } else if (aso != null) {
                    aso.rUT = true;
                    nI.enW = aso;
                    nI.bWA = 536870912;
                    o.Ta().b(nI);
                }
            }
        }
    }
}
