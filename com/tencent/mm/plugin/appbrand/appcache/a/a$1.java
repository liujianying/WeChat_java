package com.tencent.mm.plugin.appbrand.appcache.a;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appusage.d;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.protocal.c.bsc;
import com.tencent.mm.protocal.c.go;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class a$1 implements Runnable {
    public final void run() {
        int i = 0;
        if (g.Eg().dpD && e.aaV() != null) {
            long longValue = ((Long) g.Ei().DT().get(a.sTV, Long.valueOf(0))).longValue();
            long j = AppBrandGlobalSystemConfig.adZ().fpY.fqn;
            long VE = bi.VE();
            if (VE >= longValue + j) {
                boolean z;
                List emptyList;
                g.Ei().DT().a(a.sTV, Long.valueOf(VE));
                if (((Boolean) g.Ei().DT().get(a.sTW, Boolean.valueOf(true))).booleanValue()) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    d dVar = (d) e.x(d.class);
                    Cursor rawQuery = dVar.fgu.rawQuery("select distinct username,updateTime from AppBrandLocalUsageRecord where updateTime >= " + (bi.VE() - AppBrandGlobalSystemConfig.adZ().fpY.fqo) + " order by updateTime desc limit " + AppBrandGlobalSystemConfig.adZ().fpY.fqp + " offset 0 ", null);
                    if (!(rawQuery == null || rawQuery.isClosed())) {
                        if (rawQuery.moveToLast()) {
                            do {
                                dVar.u(rawQuery.getString(0), rawQuery.getLong(1));
                            } while (rawQuery.moveToPrevious());
                        }
                        rawQuery.close();
                    }
                    g.Ei().DT().a(a.sTW, Boolean.valueOf(true));
                }
                u.a aaV = e.aaV();
                int i2 = AppBrandGlobalSystemConfig.adZ().fpY.fqp;
                x.i("MicroMsg.AppBrand.CgiBatchSyncPkgVersion", "collectReqInfoList with minUpdateTime( %s )", new Object[]{bi.gb(bi.VE() - AppBrandGlobalSystemConfig.adZ().fpY.fqo)});
                Cursor b = aaV.b("select distinct WxaAttributesTable.username,WxaAttributesTable.appId,WxaAttributesTable.versionInfo from AppBrandAppLaunchUsernameDuplicateRecord left outer join WxaAttributesTable on AppBrandAppLaunchUsernameDuplicateRecord.username=WxaAttributesTable.username where AppBrandAppLaunchUsernameDuplicateRecord.updateTime >= " + j + " order by AppBrandAppLaunchUsernameDuplicateRecord.updateTime desc limit " + i2 + " offset 0", null, 2);
                if (b == null || b.isClosed()) {
                    emptyList = Collections.emptyList();
                } else {
                    List linkedList = new LinkedList();
                    if (b.moveToFirst()) {
                        WxaAttributes wxaAttributes = new WxaAttributes();
                        do {
                            String string = b.getString(0);
                            if (!bi.oW(string)) {
                                wxaAttributes.d(b);
                                bsc bsc = new bsc();
                                bsc.spJ = string;
                                if (wxaAttributes.ael() != null) {
                                    bsc.spK = wxaAttributes.ael().cbu;
                                }
                                if (!bi.oW(wxaAttributes.field_appId)) {
                                    WxaPkgWrappingInfo aG = com.tencent.mm.plugin.appbrand.launching.e.aG(wxaAttributes.field_appId, 0);
                                    bsc.spL = aG != null ? aG.fii : 0;
                                }
                                linkedList.add(bsc);
                            }
                        } while (b.moveToNext());
                    }
                    b.close();
                    i2 = aaV.delete("AppBrandAppLaunchUsernameDuplicateRecord", "updateTime < ?", new String[]{String.valueOf(j)});
                    x.i("MicroMsg.AppBrand.CgiBatchSyncPkgVersion", "collectReqInfoList, delete records updateTime < %s, count %d", new Object[]{bi.gb(j), Integer.valueOf(i2)});
                    emptyList = linkedList;
                }
                if (bi.cX(emptyList)) {
                    x.e("MicroMsg.AppBrand.CgiBatchSyncPkgVersion", "pullIfExceedLimit, empty list");
                    return;
                }
                int i3;
                int i4 = AppBrandGlobalSystemConfig.adZ().fpY.fqq;
                int i5 = 0;
                while (true) {
                    i3 = i;
                    if (i5 >= emptyList.size() / i4) {
                        break;
                    }
                    i = i5 * i4;
                    ai(emptyList.subList(i, i + i4));
                    i = i5 + 1;
                }
                if (i3 < emptyList.size()) {
                    ai(emptyList.subList(i3, emptyList.size()));
                }
            }
        }
    }

    private void ai(List<bsc> list) {
        int i = com.tencent.mm.plugin.appbrand.appcache.a.c.a.fiY;
        com.tencent.mm.plugin.appbrand.appcache.a.c.a.n(0, 0);
        new a(list, (byte) 0).KM().d(new com.tencent.mm.vending.c.a<Void, com.tencent.mm.ab.a.a<go>>() {
            public final /* synthetic */ Object call(Object obj) {
                com.tencent.mm.ab.a.a aVar = (com.tencent.mm.ab.a.a) obj;
                int i = aVar.errType;
                int i2 = aVar.errCode;
                String str = aVar.Yy;
                go goVar = (go) aVar.dIv;
                x.i("MicroMsg.AppBrand.CgiBatchSyncPkgVersion", "onCgiBack, errType %d, errCode %d, errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                int i3;
                if (i != 0 || i2 != 0 || goVar == null || goVar.rgX == null) {
                    i3 = com.tencent.mm.plugin.appbrand.appcache.a.c.a.fiY;
                    com.tencent.mm.plugin.appbrand.appcache.a.c.a.n(0, 2);
                } else {
                    b.aj(goVar.rgX);
                    i3 = com.tencent.mm.plugin.appbrand.appcache.a.c.a.fiY;
                    com.tencent.mm.plugin.appbrand.appcache.a.c.a.n(0, 1);
                }
                return uQG;
            }
        });
    }
}
