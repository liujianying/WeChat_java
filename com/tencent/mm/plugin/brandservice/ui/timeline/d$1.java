package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bd;

class d$1 implements Runnable {
    final /* synthetic */ Runnable dmS;
    final /* synthetic */ d hrR;

    d$1(d dVar, Runnable runnable) {
        this.hrR = dVar;
        this.dmS = runnable;
    }

    public final void run() {
        Runnable runnable = this.dmS;
        if (!d.avi()) {
            Cursor b = ((i) g.l(i.class)).FW().b(s.dAN, null, "officialaccounts");
            int i = 0;
            int i2 = 0;
            while (i < 50 && b.moveToNext()) {
                ai aiVar = new ai();
                aiVar.d(b);
                Cursor g = ((i) g.l(i.class)).bcY().g(aiVar.field_username, 3, 0);
                int i3 = i2;
                while (g.moveToNext()) {
                    bd bdVar = new bd();
                    bdVar.d(g);
                    com.tencent.mm.storage.s.ah(bdVar);
                    i3++;
                }
                g.close();
                i++;
                i2 = i3;
            }
            x.i("MicroMsg.BizTimeLineMigrateImp", "doMigrate %d/%d", new Object[]{Integer.valueOf(b.getCount()), Integer.valueOf(i2)});
            b.close();
            g.Ei().DT().a(a.sZY, Integer.valueOf(((Integer) g.Ei().DT().get(a.sZY, Integer.valueOf(0))).intValue() | 2));
            if (runnable != null) {
                ah.A(runnable);
            }
        } else if (runnable != null) {
            ah.A(runnable);
        }
    }
}
