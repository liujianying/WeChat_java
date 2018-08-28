package com.tencent.mm.plugin.appbrand.dynamic.j;

import android.os.Bundle;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.ab.w;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ak;
import com.tencent.mm.plugin.appbrand.appcache.al;
import com.tencent.mm.plugin.appbrand.dynamic.launching.b;
import com.tencent.mm.plugin.appbrand.dynamic.launching.c;
import com.tencent.mm.plugin.appbrand.dynamic.launching.c.a;
import com.tencent.mm.protocal.c.akj;
import com.tencent.mm.protocal.c.akk;
import com.tencent.mm.protocal.c.cfy;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

class a$a implements i<Bundle, WxaPkgWrappingInfo> {
    private a$a() {
    }

    private static WxaPkgWrappingInfo o(Bundle bundle) {
        String string = bundle.getString(SlookAirButtonFrequentContactAdapter.ID);
        String string2 = bundle.getString("appId");
        int i = bundle.getInt("pkgType");
        int i2 = bundle.getInt("pkgVersion");
        bundle.getInt("scene");
        String string3 = bundle.getString("searchId");
        al a;
        String str;
        switch (i) {
            case 10000:
                return (WxaPkgWrappingInfo) ak.t(string2, i, i2).second;
            case 10001:
                if (new c(string2, "", "", (byte) 0).afr() == a.fxe - 1) {
                    al a2 = ((com.tencent.mm.plugin.appbrand.a.c) g.l(com.tencent.mm.plugin.appbrand.a.c.class)).aaN().a(string2, i, new String[]{"downloadURL"});
                    if (a2 == null) {
                        x.e("MicroMsg.DynamicPkgUpdater", "WxaPkgManifestRecord(%s, %d) is null.", new Object[]{string2, Integer.valueOf(i)});
                        return null;
                    }
                    try {
                        return new b(string, string2, string3, i, i2, b.fwX, a2.field_downloadURL).afp();
                    } catch (Exception e) {
                        x.e("MicroMsg.DynamicPkgUpdater", "getWxaPkgInfo(%s, %d) error : %s", new Object[]{string2, Integer.valueOf(i), e});
                        return null;
                    }
                }
                break;
            case 10100:
            case 10101:
                a = ((com.tencent.mm.plugin.appbrand.a.c) g.l(com.tencent.mm.plugin.appbrand.a.c.class)).aaN().a(string2, i, new String[]{"downloadURL"});
                g.Eg();
                int Df = com.tencent.mm.kernel.a.Df();
                com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
                akj akj = new akj();
                akj.bPS = string2;
                akj.rMX = Df;
                cfy cfy = new cfy();
                switch (i) {
                    case 10100:
                        cfy.rka = 1;
                        cfy.sAw = 1;
                        break;
                    case 10101:
                        cfy.rka = 2;
                        cfy.sAw = 1;
                        break;
                    default:
                        cfy.rka = 0;
                        cfy.sAw = 0;
                        break;
                }
                if (a != null) {
                    cfy.bKg = a.field_versionMd5;
                } else {
                    cfy.bKg = "";
                }
                akj.rMY = new LinkedList();
                akj.rMY.add(cfy);
                aVar.dIG = akj;
                aVar.dIH = new akk();
                aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/getwidgetinfo";
                aVar.dIF = 1186;
                com.tencent.mm.ab.a.a b = w.b(aVar.KT());
                if (b.errType == 0 && b.errCode == 0) {
                    akk akk = (akk) b.dIv;
                    if (!(akk == null || akk.rMY == null || akk.rMY.size() <= 0)) {
                        cfy cfy2 = (cfy) akk.rMY.getFirst();
                        x.i("MicroMsg.DynamicPkgUpdater", "getWidgetInfo debugType %d, md5 %s, url %s", new Object[]{Integer.valueOf(i), cfy2.bKg, cfy2.url});
                        if (cfy2.url != null && cfy2.url.length() > 0) {
                            switch (i) {
                                case 10000:
                                    ((com.tencent.mm.plugin.appbrand.a.c) g.l(com.tencent.mm.plugin.appbrand.a.c.class)).aaN().a(string2, 10000, cfy2.url, cfy2.bKg, 0, 0);
                                    break;
                                case 10001:
                                    ((com.tencent.mm.plugin.appbrand.a.c) g.l(com.tencent.mm.plugin.appbrand.a.c.class)).aaN().a(string2, 10001, cfy2.url, cfy2.bKg, 0, 0);
                                    break;
                                case 10100:
                                    ((com.tencent.mm.plugin.appbrand.a.c) g.l(com.tencent.mm.plugin.appbrand.a.c.class)).aaN().a(string2, 10100, cfy2.url, cfy2.bKg, 0, 0);
                                    break;
                                case 10101:
                                    ((com.tencent.mm.plugin.appbrand.a.c) g.l(com.tencent.mm.plugin.appbrand.a.c.class)).aaN().a(string2, 10101, cfy2.url, cfy2.bKg, 0, 0);
                                    break;
                            }
                        }
                    }
                }
                x.i("MicroMsg.DynamicPkgUpdater", "cgi fail errType %d, errCode %d,errMsg %s, appid %s , pkgType %d", new Object[]{Integer.valueOf(b.errType), Integer.valueOf(b.errCode), b.Yy, string2, Integer.valueOf(i)});
                return (WxaPkgWrappingInfo) ak.t(string2, i, i2).second;
            case 10102:
                try {
                    str = "";
                    a = ((com.tencent.mm.plugin.appbrand.a.c) g.l(com.tencent.mm.plugin.appbrand.a.c.class)).aaN().a(string2, i, new String[]{"downloadURL", "version"});
                    if (a != null) {
                        str = a.field_downloadURL;
                        i2 = a.field_version;
                    }
                    return new b(string, string2, string3, i, i2, b.fwY, str).afp();
                } catch (Exception e2) {
                    x.e("MicroMsg.DynamicPkgUpdater", "CheckWidgetPkg error : %s", new Object[]{e2});
                    break;
                }
            default:
                try {
                    str = "";
                    a = ((com.tencent.mm.plugin.appbrand.a.c) g.l(com.tencent.mm.plugin.appbrand.a.c.class)).aaN().a(string2, i, new String[]{"downloadURL", "version"});
                    if (a != null) {
                        str = a.field_downloadURL;
                        i2 = a.field_version;
                    }
                    return new b(string, string2, string3, i, i2, b.fwX, str).afp();
                } catch (Exception e22) {
                    x.e("MicroMsg.DynamicPkgUpdater", "CheckWidgetPkg error : %s", new Object[]{e22});
                    break;
                }
        }
        return null;
    }
}
