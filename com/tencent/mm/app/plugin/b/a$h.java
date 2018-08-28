package com.tencent.mm.app.plugin.b;

import com.tencent.mm.g.a.fk;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class a$h extends c<fk> {
    public a$h() {
        this.sFo = fk.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        fk fkVar = (fk) bVar;
        if (m.TI() == null) {
            x.e("MicroMsg.SubCoreExtAgent", "SubCoreVoice.getVoiceStg()" + bi.cjd());
            fkVar.bNN.fileName = "";
        }
        p iH = m.TI().iH((int) fkVar.bNM.bJC);
        if (iH == null) {
            fkVar.bNN.fileName = "";
        } else {
            fkVar.bNN.fileName = iH.fileName;
        }
        return true;
    }
}
