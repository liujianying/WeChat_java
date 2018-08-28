package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.tq;
import com.tencent.mm.g.a.tq.a;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.exdevice.b.k.f;
import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.plugin.exdevice.service.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class af implements e {
    c cXu = new c<tq>() {
        {
            this.sFo = tq.class.getName().hashCode();
        }

        private boolean a(tq tqVar) {
            boolean z = true;
            if (tqVar instanceof tq) {
                switch (tqVar.cfq.bIH) {
                    case 1:
                        x.i("MicroMsg.WearHardDeviceLogic", "receive register deviceId=%s", new Object[]{tqVar.cfq.byN});
                        i.ivn.a(ad.getContext(), new 1(this, tqVar));
                        break;
                    case 3:
                        b Al = ad.aHe().Al(tqVar.cfq.byN);
                        a aVar = tqVar.cfq;
                        if (Al == null) {
                            z = false;
                        }
                        aVar.bLW = z;
                        break;
                    case 4:
                        x.i("MicroMsg.WearHardDeviceLogic", "receive send deviceId=%s", new Object[]{tqVar.cfq.byN});
                        au.DF().a(538, af.this);
                        au.DF().a(new w(0, tqVar.cfq.bKv, tqVar.cfq.byN, f.aGI(), bi.VF(), tqVar.cfq.data, 1), 0);
                        break;
                    case 7:
                        au.DF().a(541, af.this);
                        au.DF().a(new r("AndroidWear", tqVar.cfq.bKv, tqVar.cfq.byN, 1, new byte[0]), 0);
                        break;
                    case 11:
                        if (!bi.bs(ad.getContext(), ad.getPackageName() + ":exdevice")) {
                            d.de(ad.getContext());
                            break;
                        }
                        break;
                }
            }
            return false;
        }
    };

    static /* synthetic */ void am(String str, boolean z) {
        x.i("MicroMsg.WearHardDeviceLogic", "publish register response deviceId=%s | isSuccess=%b", new Object[]{str, Boolean.valueOf(z)});
        tq tqVar = new tq();
        tqVar.cfq.bIH = 2;
        tqVar.cfq.bLW = z;
        tqVar.cfq.byN = str;
        com.tencent.mm.sdk.b.a.sFg.m(tqVar);
    }

    public af() {
        com.tencent.mm.sdk.b.a.sFg.b(this.cXu);
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar instanceof r) {
            au.DF().b(541, this);
            r rVar = (r) lVar;
            if (i == 0 && i2 == 0) {
                ak(rVar.ivE, true);
            } else {
                ak(rVar.ivE, false);
            }
        } else if (lVar instanceof w) {
            au.DF().b(538, this);
            w wVar = (w) lVar;
            if (i == 0 && i2 == 0) {
                al(wVar.ivG, true);
            } else {
                al(wVar.ivG, false);
            }
        }
    }

    private static void ak(String str, boolean z) {
        x.i("MicroMsg.WearHardDeviceLogic", "publish auth response deviceId=%s | isSuccess=%b", new Object[]{str, Boolean.valueOf(z)});
        tq tqVar = new tq();
        tqVar.cfq.bIH = 8;
        tqVar.cfq.bLW = z;
        tqVar.cfq.byN = str;
        com.tencent.mm.sdk.b.a.sFg.m(tqVar);
    }

    private static void al(String str, boolean z) {
        x.i("MicroMsg.WearHardDeviceLogic", "publish send response deviceId=%s | isSuccess=%b", new Object[]{str, Boolean.valueOf(z)});
        tq tqVar = new tq();
        tqVar.cfq.bIH = 5;
        tqVar.cfq.bLW = z;
        tqVar.cfq.byN = str;
        com.tencent.mm.sdk.b.a.sFg.m(tqVar);
    }
}
