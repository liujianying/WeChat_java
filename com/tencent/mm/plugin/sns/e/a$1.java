package com.tencent.mm.plugin.sns.e;

import com.tencent.mm.g.a.qb;
import com.tencent.mm.plugin.sns.data.e;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.av;

class a$1 extends c<qb> {
    final /* synthetic */ a nlm;

    a$1(a aVar) {
        this.nlm = aVar;
        this.sFo = qb.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        qb qbVar = (qb) bVar;
        if (qbVar instanceof qb) {
            if (qbVar.caJ.bIH == 1) {
                x.i("MicroMsg.FTS.FTSSnsImageDownloadLogic", "start do download id %s", new Object[]{qbVar.caJ.caK.ksA});
                e eVar = new e(qbVar.caJ.caK);
                eVar.nkQ = 1;
                eVar.kJG = qbVar.caJ.caK.ksA;
                if (qbVar.caJ.caK.hcE == 6) {
                    af.byj().a(qbVar.caJ.caK, 5, eVar, av.tbw);
                } else {
                    af.byj().a(qbVar.caJ.caK, 1, eVar, av.tbw);
                }
            } else if (qbVar.caJ.bIH == 3) {
                String s = an.s(af.getAccSnsPath(), qbVar.caJ.mediaId);
                String LA = i.LA(qbVar.caJ.mediaId);
                qbVar.caJ.path = s + LA;
            }
        }
        return false;
    }
}
