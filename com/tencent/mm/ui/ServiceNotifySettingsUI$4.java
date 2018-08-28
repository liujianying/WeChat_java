package com.tencent.mm.ui;

import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.na;
import com.tencent.mm.g.a.sl;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.protocal.c.bsa;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.ui.base.s;
import java.util.Iterator;
import java.util.LinkedList;

class ServiceNotifySettingsUI$4 implements e {
    final /* synthetic */ ServiceNotifySettingsUI tqb;
    final /* synthetic */ boolean tqc;
    final /* synthetic */ boolean tqd;
    final /* synthetic */ LinkedList tqe;
    final /* synthetic */ int tqf;

    ServiceNotifySettingsUI$4(ServiceNotifySettingsUI serviceNotifySettingsUI, boolean z, boolean z2, LinkedList linkedList, int i) {
        this.tqb = serviceNotifySettingsUI;
        this.tqc = z;
        this.tqd = z2;
        this.tqe = linkedList;
        this.tqf = i;
    }

    public final void a(int i, int i2, String str, l lVar) {
        au.DF().b(1176, this);
        x.i("MicroMsg.ServiceNotifySettingsUI", "onSceneEnd(BatchSwitchServiceNotifyOption), errType : %s, errCode : %s, errMsg : %s.", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i != 0 || i2 != 0) {
            s.makeText(this.tqb, R.l.notify_message_settings_revert_ban_failed_tips, 0).show();
            if (this.tqc) {
                au.HU();
                c.DT().a(a.sUk, Boolean.valueOf(this.tqd));
                com.tencent.mm.sdk.b.a.sFg.m(new na());
            }
            Iterator it = this.tqe.iterator();
            while (it.hasNext()) {
                bsa bsa = (bsa) it.next();
                sl slVar = new sl();
                slVar.cdl.bGy = bsa.spI;
                slVar.cdl.action = 1;
                slVar.cdl.cdn = this.tqf;
                com.tencent.mm.sdk.b.a.sFg.m(slVar);
            }
        }
    }
}
