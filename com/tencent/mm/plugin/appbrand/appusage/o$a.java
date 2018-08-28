package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.ab.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Map;

public final class o$a implements a {
    private static final o$a fmq = new o$a();

    static /* synthetic */ void rm(String str) {
        int i = 0;
        x.i("MicroMsg.AppBrandUsagePushingUpdateLogic", "parseThenProcess, accReady %b, received xml %s", new Object[]{Boolean.valueOf(g.Eg().Dx()), str});
        if (g.Eg().Dx()) {
            Map z = bl.z(str, "sysmsg");
            if (z != null && z.size() > 0) {
                ArrayList arrayList;
                ArrayList arrayList2;
                ArrayList arrayList3;
                int i2;
                int i3 = bi.getInt((String) z.get(".sysmsg.UpdateWxaUsageListNotify.Type"), 0);
                int i4 = bi.getInt((String) z.get(".sysmsg.UpdateWxaUsageListNotify.DeleteCount"), 0);
                if (i4 > 0) {
                    arrayList = new ArrayList();
                    arrayList2 = new ArrayList();
                    arrayList3 = new ArrayList();
                    int i5 = 0;
                    while (i5 < i4) {
                        String str2 = ".sysmsg.UpdateWxaUsageListNotify.DeleteList.DeleteAppInfo" + (i5 == 0 ? "" : Integer.valueOf(i5));
                        String str3 = (String) z.get(str2 + ".UserName");
                        String str4 = (String) z.get(str2 + ".AppID");
                        i2 = bi.getInt((String) z.get(str2 + ".AppType"), 0);
                        if (!(bi.oW(str3) || bi.oW(str4))) {
                            arrayList.add(str3);
                            arrayList2.add(str4);
                            arrayList3.add(Integer.valueOf(i2));
                        }
                        i5++;
                    }
                } else {
                    arrayList3 = null;
                    arrayList2 = null;
                    arrayList = null;
                }
                switch (i3) {
                    case 1:
                        new r(4, 1, Integer.MAX_VALUE, 30).KM();
                        return;
                    case 2:
                        new r(4, 2, 0, 0).KM();
                        return;
                    case 3:
                        if (!bi.cX(arrayList)) {
                            while (i < arrayList.size()) {
                                v.l((String) arrayList.get(i), (String) arrayList2.get(i), ((Integer) arrayList3.get(i)).intValue());
                                i++;
                            }
                            return;
                        }
                        return;
                    case 4:
                        if (!bi.cX(arrayList)) {
                            for (i2 = 0; i2 < arrayList.size(); i2++) {
                                e.abh().g((String) arrayList.get(i2), ((Integer) arrayList3.get(i2)).intValue(), false);
                            }
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public static void adc() {
        ((o) g.n(o.class)).getSysCmdMsgExtension().a("UpdateWxaUsageListNotify", fmq, true);
    }

    public static void unregister() {
        ((o) g.n(o.class)).getSysCmdMsgExtension().b("UpdateWxaUsageListNotify", fmq, true);
    }

    public final void a(d.a aVar) {
        String a = ab.a(aVar.dIN.rcl);
        if (!bi.oW(a)) {
            c.Em().H(new 1(this, a));
        }
    }
}
