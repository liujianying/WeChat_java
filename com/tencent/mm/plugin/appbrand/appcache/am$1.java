package com.tencent.mm.plugin.appbrand.appcache;

import android.database.Cursor;
import com.tencent.mm.g.b.a.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import org.xwalk.core.XWalkEnvironment;

class am$1 implements h {
    am$1() {
    }

    private void ack() {
        File file = new File(ah.abY());
        if (file.exists() && file.isDirectory()) {
            for (File file2 : file.listFiles(new 1(this))) {
                if (!e.abi().qT(file2.getAbsolutePath())) {
                    h$a.qD(file2.getAbsolutePath());
                }
            }
        }
    }

    public final void run() {
        try {
            List<al> acm = e.abi().acm();
            if (!bi.cX(acm)) {
                long VE = bi.VE();
                for (al alVar : acm) {
                    if (alVar.field_endTime > 0 && alVar.field_endTime <= VE && alVar.field_debugType == XWalkEnvironment.LOCAL_TEST_VERSION) {
                        h$a.qD(alVar.field_pkgPath);
                        e.abi().a(alVar);
                        com.tencent.mm.plugin.appbrand.task.e.aN(alVar.field_appId, alVar.field_debugType);
                    }
                }
            }
            if (g.Eg().Dx()) {
                ap abi = e.abi();
                Cursor b = abi.fhY.b(String.format("select distinct %s from %s ", new Object[]{"appId", "AppBrandWxaPkgManifestRecord"}), null, 2);
                List<String> arrayList = new ArrayList();
                while (b.moveToNext()) {
                    arrayList.add(b.getString(0));
                }
                b.close();
                List list;
                if (bi.cX(arrayList)) {
                    list = null;
                } else {
                    List linkedList = new LinkedList();
                    for (String qU : arrayList) {
                        Collection qU2 = abi.qU(qU);
                        if (!bi.cX(qU2)) {
                            linkedList.addAll(qU2);
                        }
                    }
                    list = linkedList;
                }
                if (!bi.cX(acm)) {
                    for (al alVar2 : acm) {
                        if (alVar2.field_appId.indexOf(36) <= 0 && !com.tencent.mm.plugin.appbrand.task.e.vD(alVar2.field_appId)) {
                            h$a.qD(alVar2.field_pkgPath);
                            e.abi().a(alVar2);
                            e.abn().af(alVar2.field_appId, alVar2.field_version);
                            l lVar = new l();
                            lVar.ciw = 2;
                            lVar.cix = alVar2.field_appId;
                            lVar.ciy = 0;
                            lVar.ciz = 1;
                            lVar.ciu = 0;
                            lVar.RD();
                        }
                    }
                }
            }
            ack();
        } catch (Throwable e) {
            x.e("MicroMsg.AppBrand.WxaPkgPruner", "prune running, exp = %s", new Object[]{bi.i(e)});
        }
    }
}
