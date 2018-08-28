package com.tencent.mm.ui;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.x;

class aa$2 implements b {
    final /* synthetic */ aa toC;

    aa$2(aa aaVar) {
        this.toC = aaVar;
    }

    public final void a(int i, m mVar, Object obj) {
        int bc = ai.bc(obj);
        x.d("MicroMsg.LauncherUI.MainTabUnreadMgr", "onNotifyChange event:%d obj:%d stg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(bc), mVar});
        au.HU();
        if (mVar != c.DT() || bc <= 0) {
            x.e("MicroMsg.LauncherUI.MainTabUnreadMgr", "onNotifyChange error obj:%d stg:%s", new Object[]{Integer.valueOf(bc), mVar});
            return;
        }
        this.toC.cqD();
        if (bc == 143618) {
            aa.a(this.toC);
        } else if (bc == 204817 || bc == 204820) {
            aa.b(this.toC);
        }
    }
}
