package com.tencent.mm.plugin.appbrand.appcache.a.d;

import android.util.Pair;
import com.tencent.mm.plugin.appbrand.p.c;
import com.tencent.mm.protocal.c.aql;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public class e extends c<f> {
    public static final String[] dzV = new String[]{i.a(f.dzU, "PredownloadIssueLaunchWxaAppResponse")};

    public e(com.tencent.mm.sdk.e.e eVar) {
        super(eVar, f.dzU, "PredownloadIssueLaunchWxaAppResponse", f.ciG);
    }

    public final boolean a(byte[] bArr, String str, List<Integer> list, long j, long j2) {
        if (bi.bC(bArr) || bi.oW(str)) {
            x.i("MicroMsg.AppBrand.Predownload.DuplicateLaunchWxaAppCacheStorage", "setLaunchData, invalid input %s", new Object[]{str});
            return false;
        } else if (bi.cX(list)) {
            x.e("MicroMsg.AppBrand.Predownload.DuplicateLaunchWxaAppCacheStorage", "setLaunchData, appId %s, empty sceneList", new Object[]{str});
            return false;
        } else {
            boolean z = true;
            for (Integer intValue : list) {
                int intValue2 = intValue.intValue();
                f fVar = new f();
                fVar.field_appId = str;
                fVar.field_scene = intValue2;
                boolean b = b(fVar, new String[0]);
                fVar.field_launchProtoBlob = bArr;
                fVar.field_startTime = j;
                fVar.field_endTime = j2;
                z = (b ? c(fVar, new String[0]) : b(fVar)) & z;
            }
            x.i("MicroMsg.AppBrand.Predownload.DuplicateLaunchWxaAppCacheStorage", "setLaunchData, appId %s, sceneList %d, setOk %b", new Object[]{str, Integer.valueOf(list.size()), Boolean.valueOf(z)});
            return z;
        }
    }

    public final Pair<aql, Long> am(String str, int i) {
        try {
            long VE = bi.VE();
            f fVar = new f();
            fVar.field_appId = str;
            fVar.field_scene = i;
            if (b(fVar, new String[0])) {
                x.i("MicroMsg.AppBrand.Predownload.DuplicateLaunchWxaAppCacheStorage", "found info with appId(%s) scene(%d), [%d, %d]", new Object[]{str, Integer.valueOf(i), Long.valueOf(fVar.field_startTime), Long.valueOf(fVar.field_endTime)});
                if (fVar.field_startTime <= VE && VE <= fVar.field_endTime) {
                    aql aql = new aql();
                    aql.aG(fVar.field_launchProtoBlob);
                    if (aql.rSV.rsl.lR.length > 0) {
                        return Pair.create(aql, Long.valueOf(fVar.field_reportId));
                    }
                    x.e("MicroMsg.AppBrand.Predownload.DuplicateLaunchWxaAppCacheStorage", "found into with appId(%s) scene(%d), but jsapi_control_bytes invalid", new Object[]{str, Integer.valueOf(i)});
                }
            }
            return Pair.create(null, Long.valueOf(-1));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AppBrand.Predownload.DuplicateLaunchWxaAppCacheStorage", e, "get with appId(%s) scene(%d)", new Object[]{str, Integer.valueOf(i)});
            return Pair.create(null, Long.valueOf(-1));
        }
    }

    public static void act() {
    }
}
