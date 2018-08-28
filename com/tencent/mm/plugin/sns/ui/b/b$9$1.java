package com.tencent.mm.plugin.sns.ui.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.mm.g.a.ni;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.lucky.a.g;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.r;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.sns.ui.b.b.9;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class b$9$1 implements OnClickListener {
    final /* synthetic */ View gvo;
    final /* synthetic */ 9 olg;

    b$9$1(9 9, View view) {
        this.olg = 9;
        this.gvo = view;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.gvo.getTag() instanceof String) {
            String str = (String) this.gvo.getTag();
            x.d("MicroMsg.TimelineClickListener", "onItemDelClick:" + str);
            n Nl = af.byo().Nl(str);
            b io;
            b ir;
            String str2;
            if (Nl == null) {
                x.d("MicroMsg.TimelineClickListener", "can not get snsinfo by localid %s then return it", new Object[]{str});
            } else if (Nl.bBg()) {
                x.i("MicroMsg.TimelineClickListener", "dead item");
                af.byo().xe(Nl.nJc);
                if (this.olg.olf.olc != null) {
                    this.olg.olf.olc.bDV();
                }
                if (this.olg.olf.scene == 0) {
                    io = b.io(739);
                } else {
                    io = b.ip(739);
                }
                ir = io.nb(i.g(Nl)).ir(Nl.field_type);
                str2 = Nl.bBg() ? "2" : Nl.field_snsId == 0 ? "1" : "0";
                ir.nb(str2);
                io.RD();
                if (Nl.field_type == 21) {
                    g.bxc().bxe();
                }
            } else if (Nl.bxX()) {
                x.i("MicroMsg.TimelineClickListener", "cancel item " + Nl.bBe());
                af.byk().r(Nl);
                this.olg.olf.bBS();
            } else {
                x.i("MicroMsg.TimelineClickListener", "delete by server");
                str = Nl.bAK();
                af.byn().eS(v.NE(str));
                com.tencent.mm.kernel.g.Ek();
                com.tencent.mm.kernel.g.Eh().dpP.a(new r(v.NE(str), 1), 0);
                af.byo().delete(v.NE(str));
                af.byt().fd(v.NE(str));
                com.tencent.mm.plugin.sns.storage.i.fc(v.NE(str));
                this.olg.olf.bBS();
                bsu bAJ = Nl.bAJ();
                if (bAJ != null) {
                    if (bAJ.sqb == null) {
                        str = null;
                    } else {
                        str = bAJ.sqb.ksA;
                    }
                    if (!bi.oW(str) && a.ezo.cU(str)) {
                        String cS = a.ezo.cS(str);
                        ni niVar = new ni();
                        niVar.bYn.appId = str;
                        niVar.bYn.bYo = bAJ.hbL;
                        niVar.bYn.byT = cS;
                        niVar.bYn.mediaTagName = bAJ.sqg;
                        com.tencent.mm.sdk.b.a.sFg.m(niVar);
                    }
                }
                if (this.olg.olf.scene == 0) {
                    io = b.io(739);
                } else {
                    io = b.ip(739);
                }
                ir = io.nb(i.g(Nl)).ir(Nl.field_type);
                str2 = Nl.bBg() ? "2" : Nl.field_snsId == 0 ? "1" : "0";
                ir.nb(str2);
                io.RD();
            }
        }
    }
}
