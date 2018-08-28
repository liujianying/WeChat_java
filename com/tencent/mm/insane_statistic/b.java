package com.tencent.mm.insane_statistic;

import com.tencent.mm.ak.e;
import com.tencent.mm.ak.o;
import com.tencent.mm.ak.r.a;
import com.tencent.mm.g.a.ms;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.protocal.c.bwi;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.c;

public final class b implements a {
    public final void a(long j, bd bdVar, com.tencent.mm.ab.b bVar, int i, boolean z, keep_SceneResult keep_sceneresult) {
        a aVar = new a(j, bdVar, bVar, z, i);
        c fJ = com.tencent.mm.model.c.c.Jx().fJ("100131");
        if (fJ.isValid()) {
            aVar.dlT = ai.getInt((String) fJ.ckq().get("needUploadData"), 1);
        }
        if (!aVar.dlR) {
            if (aVar.dlV || aVar.dlT != 0) {
                aVar.dlU = keep_sceneresult;
                aVar.dlR = true;
                String str = ((bwi) aVar.diG.dID.dIL).rck.siM;
                Object obj = (bi.oW(str) || !str.endsWith("@chatroom")) ? null : 1;
                aVar.dlQ = "2," + (obj != null ? 2 : 1) + ",,";
                if (aVar.dlP == null) {
                    aVar.dlP = o.Pf().b(Long.valueOf(aVar.dlN));
                }
                e eVar = aVar.dlP;
                if (eVar != null) {
                    ms msVar = new ms();
                    com.tencent.mm.sdk.b.a.sFg.b(aVar.dlW);
                    com.tencent.mm.sdk.b.a.sFg.b(aVar.dlX);
                    aVar.dlS = o.Pf().o(eVar.dTL, "", "");
                    msVar.bXH.filePath = aVar.dlS;
                    com.tencent.mm.sdk.b.a.sFg.m(msVar);
                }
            }
        }
    }
}
