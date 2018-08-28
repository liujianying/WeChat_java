package com.tencent.mm.plugin.notification.d;

import com.tencent.mm.bt.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.notification.a.a;
import com.tencent.mm.plugin.notification.c.c;
import com.tencent.mm.plugin.notification.ui.FailSendMsgNotification;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class f implements ar {
    private static f lHY = null;
    c lHZ = null;
    c lIa = null;
    private a lIb = null;
    private boolean lIc = false;
    private com.tencent.mm.sdk.b.c lId = new 1(this);
    private com.tencent.mm.sdk.b.c lIe = new 2(this);
    private com.tencent.mm.sdk.b.c lIf = new 3(this);
    private com.tencent.mm.sdk.b.c lIg = new 4(this);
    private com.tencent.mm.sdk.b.c lIh = new 5(this);
    private com.tencent.mm.sdk.b.c lIi = new 6(this);

    private f() {
        b.init();
        if (this.lIa == null) {
            this.lIa = new e();
        }
        if (this.lHZ == null) {
            this.lHZ = new d();
        }
    }

    public static FailSendMsgNotification uh(int i) {
        if (i == 2 && bky().lIa != null) {
            x.d("MicroMsg.SubCoreNotification", "get sns notificaiton");
            return bky().lIa.bkk();
        } else if (i != 1 || bky().lHZ == null) {
            return null;
        } else {
            x.d("MicroMsg.SubCoreNotification", "get msg notificaiton");
            return bky().lHZ.bkk();
        }
    }

    public static f bky() {
        if (lHY == null) {
            lHY = new f();
            au.HN().a("plugin.notification", lHY);
        }
        return lHY;
    }

    public final HashMap<Integer, d> Ci() {
        return null;
    }

    public final void gi(int i) {
    }

    public final void bn(boolean z) {
        this.lHZ.bkt();
        this.lHZ.bku();
        this.lIa.bkt();
        this.lIa.bku();
        if (this.lIb == null) {
            this.lIb = new a();
        }
        a aVar = this.lIb;
        if (au.HX()) {
            x.d("MicroMsg.NotificationObserver", "added");
            try {
                au.HU();
                com.tencent.mm.model.c.FW().a(aVar);
                aVar.lHj = true;
            } catch (Throwable e) {
                x.e("MicroMsg.NotificationObserver", "exception:%s", new Object[]{bi.i(e)});
            }
        } else {
            x.e("MicroMsg.NotificationObserver", "account not ready!");
        }
        com.tencent.mm.sdk.b.a.sFg.b(this.lId);
        com.tencent.mm.sdk.b.a.sFg.b(this.lIe);
        com.tencent.mm.sdk.b.a.sFg.b(this.lIf);
        com.tencent.mm.sdk.b.a.sFg.b(this.lIg);
        com.tencent.mm.sdk.b.a.sFg.b(this.lIh);
        com.tencent.mm.sdk.b.a.sFg.b(this.lIi);
        com.tencent.mm.k.f.AN();
        au.getNotification().fq(com.tencent.mm.k.f.AQ());
        au.getNotification().aS(false);
        x.d("MicroMsg.SubCoreNotification", "onAccountPostReset");
    }

    public final void bo(boolean z) {
    }

    public final void onAccountRelease() {
        this.lHZ.bkv();
        this.lHZ.bkw();
        this.lIa.bkv();
        this.lIa.bkw();
        if (this.lIb != null) {
            a aVar = this.lIb;
            if (au.HX()) {
                try {
                    au.HU();
                    com.tencent.mm.model.c.FW().b(aVar);
                } catch (Throwable e) {
                    x.e("MicroMsg.NotificationObserver", "exception:%s", new Object[]{bi.i(e)});
                }
            }
        }
        com.tencent.mm.sdk.b.a.sFg.c(this.lId);
        com.tencent.mm.sdk.b.a.sFg.c(this.lIe);
        com.tencent.mm.sdk.b.a.sFg.c(this.lIf);
        com.tencent.mm.sdk.b.a.sFg.c(this.lIg);
        com.tencent.mm.sdk.b.a.sFg.c(this.lIh);
        com.tencent.mm.sdk.b.a.sFg.c(this.lIi);
        au.getNotification().fq(0);
        au.getNotification().aS(true);
        x.d("MicroMsg.SubCoreNotification", "onAccountRelease");
    }

    public static boolean bkz() {
        return bky().lIc;
    }

    public static ArrayList<Long> X(bd bdVar) {
        if (bdVar == null) {
            return null;
        }
        au.HU();
        com.tencent.mm.model.c.FT().a(bdVar.field_msgId, bdVar);
        ArrayList bdg = ((i) g.l(i.class)).bcY().bdg();
        ArrayList<Long> arrayList = new ArrayList();
        Iterator it = bdg.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((bd) it.next()).field_msgId));
        }
        return arrayList;
    }
}
