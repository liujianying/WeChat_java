package com.tencent.mm.plugin.appbrand.appcache.a.b;

import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appcache.a.d.a;
import com.tencent.mm.protocal.c.chl;
import com.tencent.mm.protocal.c.chm;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;

public class b extends a<Boolean, chm> {
    final /* synthetic */ Object b(String str, String str2, Object obj) {
        boolean z;
        int i = -1;
        chm chm = (chm) obj;
        com.tencent.mm.plugin.appbrand.appcache.a.d.b bVar = (com.tencent.mm.plugin.appbrand.appcache.a.d.b) e.x(com.tencent.mm.plugin.appbrand.appcache.a.d.b.class);
        if (bi.cX(chm.sum) || bi.cX(chm.sBv)) {
            String str3 = "MicroMsg.AppBrand.Predownload.CmdBlockCgiPersistentStorage";
            String str4 = "saveBlockList with username(%s) appId(%s) sceneList.size(%d), blockCgi.size(%d), skip";
            Object[] objArr = new Object[4];
            objArr[0] = str;
            objArr[1] = str2;
            objArr[2] = Integer.valueOf(chm.sum == null ? -1 : chm.sum.size());
            if (chm.sBv != null) {
                i = chm.sBv.size();
            }
            objArr[3] = Integer.valueOf(i);
            x.e(str3, str4, objArr);
            z = false;
        } else {
            a aVar = new a();
            aVar.field_username = str;
            boolean b = bVar.b(aVar, new String[0]);
            aVar.field_appId = str2;
            aVar.field_startTime = (long) chm.sBw;
            aVar.field_endTime = (long) chm.sBx;
            StringBuilder stringBuilder = new StringBuilder(";");
            Iterator it = chm.sum.iterator();
            while (it.hasNext()) {
                stringBuilder.append(((Integer) it.next()).intValue()).append(";");
            }
            aVar.field_sceneList = stringBuilder.toString();
            stringBuilder = new StringBuilder(";");
            it = chm.sBv.iterator();
            while (it.hasNext()) {
                stringBuilder.append(((Integer) it.next()).intValue()).append(";");
            }
            aVar.field_cgiList = stringBuilder.toString();
            aVar.field_reportId = chm.sBu.sBs;
            x.i("MicroMsg.AppBrand.Predownload.CmdBlockCgiPersistentStorage", "saveBlockList, record( %s ), doUpdate %b", new Object[]{aVar, Boolean.valueOf(b)});
            z = b ? bVar.c(aVar, new String[0]) : bVar.b(aVar);
        }
        x.i("MicroMsg.AppBrand.Predownload.CmdBlockCgiRequest", "saveBlockList with username(%s) appId(%s), ret %b", new Object[]{str, str2, Boolean.valueOf(z)});
        return Boolean.valueOf(z);
    }

    final /* bridge */ /* synthetic */ chl bf(Object obj) {
        return ((chm) obj).sBu;
    }

    final String acp() {
        return "CmdBlockCgiRequest";
    }
}
