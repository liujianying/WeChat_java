package com.tencent.mm.plugin.appbrand.appcache.a.b;

import android.util.Base64;
import com.tencent.mm.plugin.appbrand.appcache.a.c.a;
import com.tencent.mm.plugin.appbrand.appcache.a.d.e;
import com.tencent.mm.protocal.c.aql;
import com.tencent.mm.protocal.c.chl;
import com.tencent.mm.protocal.c.chs;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public class g extends a<Boolean, chs> {
    final /* bridge */ /* synthetic */ chl bf(Object obj) {
        return ((chs) obj).sBu;
    }

    private static Boolean a(String str, String str2, chs chs) {
        String str3 = chs.sBJ;
        if (bi.oW(str3)) {
            x.e("MicroMsg.AppBrand.Predownload.CmdIssueLaunch", "call[%s | %s], empty base64", new Object[]{str, str2});
            return Boolean.FALSE;
        } else if (bi.cX(chs.sum)) {
            x.e("MicroMsg.AppBrand.Predownload.CmdIssueLaunch", "call[%s | %s], empty sceneList", new Object[]{str, str2});
            return Boolean.FALSE;
        } else {
            try {
                byte[] decode = Base64.decode(str3, 0);
                aql aql = new aql();
                aql.aG(decode);
                int i;
                if (aql.rSV.rsl.lR.length == 0) {
                    x.e("MicroMsg.AppBrand.Predownload.CmdIssueLaunch", "call[%s | %s], parse pb, invalid foreground control bytes", new Object[]{str, str2});
                    i = a.fiY;
                    a.n((long) chs.sBu.sBs, 105);
                    return Boolean.FALSE;
                }
                i = a.fiY;
                a.n((long) chs.sBu.sBs, 104);
                List<Object> list = chs.sum;
                long j = ((long) chs.sBK) & 4294967295L;
                long j2 = ((long) chs.sBL) & 4294967295L;
                String str4 = "MicroMsg.AppBrand.Predownload.CmdIssueLaunch";
                String str5 = "call[%s| %s] WriteToStorage, sceneList %s, time[%d, %d]";
                Object[] objArr = new Object[5];
                objArr[0] = str;
                objArr[1] = str2;
                if (list == null) {
                    str3 = "null";
                } else if (bi.cX(list)) {
                    str3 = "{}";
                } else {
                    StringBuilder stringBuilder = new StringBuilder("{");
                    for (Object obj : list) {
                        stringBuilder.append(obj.toString()).append(',');
                    }
                    stringBuilder.append("}");
                    str3 = stringBuilder.toString();
                }
                objArr[2] = str3;
                objArr[3] = Long.valueOf(j);
                objArr[4] = Long.valueOf(j2);
                x.i(str4, str5, objArr);
                boolean a = ((e) com.tencent.mm.plugin.appbrand.app.e.x(e.class)).a(decode, str2, list, j, j2);
                i = a.fiY;
                a.n((long) chs.sBu.sBs, a ? 107 : 108);
                return Boolean.valueOf(a);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.AppBrand.Predownload.CmdIssueLaunch", e, "call[%s | %s], decode base64", new Object[]{str, str2});
                return Boolean.FALSE;
            }
        }
    }

    final String acp() {
        return "CmdIssueLaunch";
    }
}
