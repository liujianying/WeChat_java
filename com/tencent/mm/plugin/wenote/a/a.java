package com.tencent.mm.plugin.wenote.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.g.a.kp;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.fav.a.an;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wenote.model.f;
import com.tencent.mm.plugin.wenote.model.g;
import com.tencent.mm.plugin.wenote.model.g.1;
import com.tencent.mm.protocal.c.wl;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends c<kp> {
    public a() {
        this.sFo = kp.class.getName().hashCode();
    }

    private static boolean a(kp kpVar) {
        switch (kpVar.bUP.type) {
            case 0:
                com.tencent.mm.plugin.wenote.model.c.bZb().qnC.b(kpVar);
                break;
            case 2:
                if (kpVar.bUP.bUW == 4) {
                    long j;
                    h.mEJ.h(14789, new Object[]{Integer.valueOf(4)});
                    x.i("MicroMsg.NotifyWNNoteOperationListener", "do OPEN_NOTE_FROM_SNS");
                    g gVar = new g();
                    com.tencent.mm.plugin.wenote.model.c.bZb().qnC = gVar;
                    Context context = kpVar.bUP.context;
                    wl wlVar = kpVar.bUP.field_favProto;
                    Bundle bundle = kpVar.bUP.bUU;
                    boolean z = kpVar.bUP.bUY;
                    String str = "";
                    String str2 = "";
                    if (bundle != null) {
                        str = bundle.getString("noteauthor", "");
                        str2 = bundle.getString("noteeditor", "");
                        j = bundle.getLong("edittime", 0);
                        gVar.qnV = bundle.getString("snslocalid");
                        gVar.qnW = bundle.getString("notexml", "");
                        gVar.qod = bundle.getString("snsthumbpath", "");
                        gVar.qoe = bundle.getString("snsnotelinkxml", "");
                    } else {
                        j = 0;
                    }
                    gVar.bVe = System.currentTimeMillis();
                    gVar.bUY = z;
                    gVar.qnN = false;
                    gVar.qoa = str + ";" + str2 + ";" + j;
                    gVar.R(context, 4);
                    au.Em().H(new 1(gVar, wlVar));
                    break;
                }
                h.mEJ.h(14789, new Object[]{Integer.valueOf(1)});
                x.i("MicroMsg.NotifyWNNoteOperationListener", "do OPEN_NOTE_FROM_FAV");
                g gVar2 = new g();
                com.tencent.mm.plugin.wenote.model.c.bZb().qnC = gVar2;
                if (!(kpVar.bUP.field_favProto == null || kpVar.bUP.field_favProto.rBG == null)) {
                    gVar2.qob = kpVar.bUP.field_favProto.rBG.bJt;
                }
                if (kpVar.bUP.bUU != null) {
                    gVar2.qoc = kpVar.bUP.bUU.getLong("edittime", 0);
                }
                gVar2.a(kpVar.bUP.field_localId, kpVar.bUP.context, Boolean.valueOf(kpVar.bUP.bUY), 0, 0, kpVar.bUP.bUZ);
                break;
            case 3:
                kpVar.bUQ.path = an.aLR();
                break;
            case 7:
                switch (kpVar.bUP.bUV) {
                    case 2:
                        com.tencent.mm.plugin.wenote.model.h.X(kpVar.bUP.bUX);
                        break;
                    case 3:
                        try {
                            com.tencent.mm.plugin.wenote.model.h.Si(kpVar.bUP.bUS);
                            break;
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.NotifyWNNoteOperationListener", e, "", new Object[0]);
                            break;
                        }
                    case 4:
                        com.tencent.mm.plugin.wenote.model.h.l(kpVar.bUP.context, kpVar.bUP.path, kpVar.bUP.bUW);
                        break;
                    case 5:
                        com.tencent.mm.plugin.wenote.model.h.Sh(kpVar.bUP.path);
                        break;
                }
                break;
            case 8:
                com.tencent.mm.plugin.wenote.model.h.ba(kpVar.bUP.context, kpVar.bUP.path);
                break;
            case 9:
                x.i("MicroMsg.NotifyWNNoteOperationListener", "do OPEN_NOTE_FROM_ADD");
                g gVar3 = new g();
                gVar3.bVe = kpVar.bUP.field_localId;
                com.tencent.mm.plugin.wenote.model.c.bZb().qnC = gVar3;
                Context context2 = kpVar.bUP.context;
                gVar3.qnN = true;
                gVar3.R(context2, 2);
                break;
            case 10:
                f.t(kpVar.bUP.field_localId, kpVar.bUP.path);
                break;
            case 11:
                f.W(kpVar.bUP.bUX);
                break;
            case 12:
                au.Em().h(new c$1(com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD()), 700);
                break;
        }
        return false;
    }
}
