package com.tencent.mm.plugin.backup.c;

import android.content.Intent;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.backup.a.d;
import com.tencent.mm.plugin.backup.a.g;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.ach;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class c$1 implements e {
    final /* synthetic */ c gUr;

    c$1(c cVar) {
        this.gUr = cVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        au.DF().b(595, c.a(this.gUr));
        if (i == 0 && i2 == 0) {
            ach asA = ((com.tencent.mm.plugin.backup.f.e) lVar).asA();
            au.HU();
            if (bi.oV((String) c.DT().get(2, null)).equals(asA.rfk)) {
                String str2;
                b.arv().gRu = asA.ID;
                b.arv().gRv = asA.rfr;
                b.arv().gRw = asA.rfs;
                b.a(this.gUr.gUo);
                b.arv().aqQ();
                b.a(b.arv().ary());
                b.a(b.arv().arw());
                b.mx(2);
                b.a(c.b(this.gUr));
                b.a(c.c(this.gUr));
                int i3 = 0;
                if (asA.rfh > 0) {
                    pw pwVar = (pw) asA.rfi.getFirst();
                    String str3 = pwVar.rud;
                    i3 = ((Integer) pwVar.rue.getFirst()).intValue();
                    str2 = str3;
                } else {
                    x.e("MicroMsg.BackupMoveRecoverServer", "summerbak address convMsgCount is empty");
                    str2 = null;
                }
                c cVar = this.gUr;
                cVar.gUe = asA.rfl;
                cVar.gUf = str2;
                cVar.gUg = i3;
                x.i("MicroMsg.BackupMoveRecoverServer", "summerbak getconnetinfo, type:%d, scene:%d, wifiName:%s, ip:%s, port:%d", new Object[]{Integer.valueOf(asA.hcE), Integer.valueOf(asA.otY), asA.rfl, str2, Integer.valueOf(i3)});
                d.mx(22);
                b.arv().aqP().gRC = 1;
                Intent className = new Intent().setClassName(ad.getContext(), "com.tencent.mm.ui.LauncherUI");
                className.addFlags(335544320);
                className.putExtra("nofification_type", "backup_move_notification");
                ad.getContext().startActivity(className);
                h.mEJ.a(485, 41, 1, false);
                c.dv(false);
                x.i("MicroMsg.BackupMoveRecoverServer", "summerbak try connct old phone, oldphone ip:%s, oldphone wifi:%s, newphone wifi:%s", new Object[]{str2, asA.rfl, g.cQ(ad.getContext())});
                c.arF();
                c.a(this.gUr, str2, i3);
                return;
            }
            x.e("MicroMsg.BackupMoveRecoverServer", "summerbak getConnectinfo not the same account");
            b.arv().aqP().gRC = -5;
            this.gUr.mw(-5);
            return;
        }
        x.i("MicroMsg.BackupMoveRecoverServer", "summerbak getConnect info other error [%d,%d,%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 4 && i2 == -2011) {
            x.e("MicroMsg.BackupMoveRecoverServer", "summerbak getConnect info: INVALID URL");
        }
        b.arv().aqP().gRC = -5;
        this.gUr.mw(-5);
    }
}
