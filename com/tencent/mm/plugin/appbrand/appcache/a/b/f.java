package com.tencent.mm.plugin.appbrand.appcache.a.b;

import com.tencent.mm.a.g;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appcache.a.c.a;
import com.tencent.mm.plugin.appbrand.appcache.aa;
import com.tencent.mm.plugin.appbrand.appcache.ai;
import com.tencent.mm.plugin.appbrand.appcache.ak;
import com.tencent.mm.plugin.appbrand.appcache.y;
import com.tencent.mm.plugin.appbrand.appcache.z;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.c.chl;
import com.tencent.mm.protocal.c.chr;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class f extends a<Boolean, chr> {

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.a.b.f$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] fiL = new int[a.acq().length];

        static {
            try {
                fiL[a.fiM - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    public final /* synthetic */ Object b(String str, String str2, Object obj) {
        boolean z = false;
        chr chr = (chr) obj;
        int i = chr.riv;
        String str3 = chr.sBI;
        int i2;
        if (bi.oW(str3)) {
            x.e("MicroMsg.AppBrand.Predownload.CmdIssueDecryptKey", "call appId(%s) version(%d) key nil", new Object[]{str2, Integer.valueOf(i)});
            i2 = a.fiY;
            a.n((long) chr.sBu.sBs, 124);
            return Boolean.valueOf(false);
        } else if (ak.t(str2, 0, i).first == ak.a.fhB) {
            x.i("MicroMsg.AppBrand.Predownload.CmdIssueDecryptKey", "call, normal pkg ok appId(%s), version(%d)", new Object[]{str2, Integer.valueOf(i)});
            i2 = a.fiY;
            a.n((long) chr.sBu.sBs, 125);
            return Boolean.valueOf(false);
        } else {
            com.tencent.mm.plugin.appbrand.appcache.x q = ((y) e.x(y.class)).q(str2, 1, i);
            if (q == null) {
                x.e("MicroMsg.AppBrand.Predownload.CmdIssueDecryptKey", "call, null encrypt pkg info with %s, %d", new Object[]{str2, Integer.valueOf(i)});
                i2 = a.fiY;
                a.n((long) chr.sBu.sBs, 126);
                i2 = 1;
            } else if (a(q, chr.sBI, chr.rwk, chr.sBu.sBs, a.fiN)) {
                boolean z2 = false;
            } else {
                i2 = 1;
            }
            if (i2 != 0) {
                aa aaVar = (aa) e.x(aa.class);
                String str4 = chr.rwk;
                int i3 = chr.sBu.sBs;
                if (bi.oW(str2) || bi.oW(str3)) {
                    x.e("MicroMsg.AppBrand.Predownload.PushWxaPkgDecryptKeyStorage", "setDecryptKey, invalid appId[%s], decryptKey[%s]", new Object[]{str2, str3});
                } else {
                    z zVar = new z();
                    zVar.field_appId = str2;
                    zVar.field_appVersion = i;
                    boolean b = aaVar.b(zVar, new String[0]);
                    zVar.field_decryptKey = str3;
                    zVar.field_reportId = i3;
                    zVar.field_pkgMd5 = str4;
                    z = b ? aaVar.c(zVar, new String[0]) : aaVar.b(zVar);
                }
                i2 = a.fiY;
                a.n((long) chr.sBu.sBs, z ? 135 : 136);
            }
            return Boolean.TRUE;
        }
    }

    final /* bridge */ /* synthetic */ chl bf(Object obj) {
        return ((chr) obj).sBu;
    }

    final String acp() {
        return "CmdIssueDecryptKey";
    }

    private static boolean a(com.tencent.mm.plugin.appbrand.appcache.x xVar, String str, String str2, int i, int i2) {
        int i3;
        int i4 = 0;
        switch (AnonymousClass1.fiL[i2 - 1]) {
            case 1:
                i3 = 131;
                break;
            default:
                i3 = 127;
                break;
        }
        int i5 = a.fiY;
        a.n((long) i, (long) i3);
        String ag = ai.ag(xVar.field_appId, xVar.field_version);
        x.i("MicroMsg.AppBrand.Predownload.CmdIssueDecryptKey", "decryptPkgAndSave, appId(%s), version(%d), ret %d", new Object[]{xVar.field_appId, Integer.valueOf(xVar.field_version), Integer.valueOf(MMProtocalJni.aesDecryptFile(xVar.field_pkgPath, ag, str.getBytes()))});
        int i6;
        if (MMProtocalJni.aesDecryptFile(xVar.field_pkgPath, ag, str.getBytes()) != 0) {
            switch (AnonymousClass1.fiL[i2 - 1]) {
                case 1:
                    i3 = 133;
                    break;
                default:
                    i3 = 129;
                    break;
            }
            i6 = a.fiY;
            a.n((long) i, (long) i3);
            return false;
        }
        if (g.cu(ag).equals(str2)) {
            e.abi().g(xVar.field_appId, xVar.field_version, str2);
            boolean d = e.abi().d(xVar.field_appId, 0, xVar.field_version, ag);
            switch (AnonymousClass1.fiL[i2 - 1]) {
                case 1:
                    if (!d) {
                        i3 = 148;
                        break;
                    }
                    i3 = 147;
                    break;
                default:
                    if (!d) {
                        i3 = 144;
                        break;
                    }
                    i3 = 143;
                    break;
            }
            i5 = a.fiY;
            a.n((long) i, (long) i3);
            com.tencent.mm.a.e.deleteFile(xVar.field_pkgPath);
            i3 = ((y) e.x(y.class)).a(xVar, new String[0]) ? 139 : 140;
            i5 = a.fiY;
            a.n((long) i, (long) i3);
            if (i2 != a.fiN) {
                aa aaVar = (aa) e.x(aa.class);
                String str3 = xVar.field_appId;
                int i7 = xVar.field_version;
                if (!bi.oW(str3)) {
                    z zVar = new z();
                    zVar.field_appId = str3;
                    zVar.field_appVersion = i7;
                    i4 = aaVar.a(zVar, new String[0]);
                }
                i3 = i4 != 0 ? 141 : 142;
                i4 = a.fiY;
                a.n((long) i, (long) i3);
            }
            switch (AnonymousClass1.fiL[i2 - 1]) {
                case 1:
                    i3 = 132;
                    break;
                default:
                    i3 = 128;
                    break;
            }
            i4 = a.fiY;
            a.n((long) i, (long) i3);
            return true;
        }
        x.e("MicroMsg.AppBrand.Predownload.CmdIssueDecryptKey", "decryptPkgAndSave, file_md5(%s) expect_md5(%s) mismatch", new Object[]{g.cu(ag), str2});
        switch (AnonymousClass1.fiL[i2 - 1]) {
            case 1:
                i3 = c.CTRL_INDEX;
                break;
            default:
                i3 = 130;
                break;
        }
        i6 = a.fiY;
        a.n((long) i, (long) i3);
        return false;
    }

    public static boolean a(com.tencent.mm.plugin.appbrand.appcache.x xVar, int i) {
        return a(xVar, i, null);
    }

    public static boolean a(com.tencent.mm.plugin.appbrand.appcache.x xVar, int i, PLong pLong) {
        aa aaVar = (aa) e.x(aa.class);
        String str = xVar.field_appId;
        int i2 = xVar.field_version;
        z zVar = new z();
        zVar.field_appId = str;
        zVar.field_appVersion = i2;
        z zVar2 = aaVar.b(zVar, new String[0]) ? zVar : null;
        if (zVar2 == null) {
            x.i("MicroMsg.AppBrand.Predownload.CmdIssueDecryptKey", "decryptPkgAndSave get null key with %s", new Object[]{xVar.toShortString()});
            return false;
        }
        if (pLong != null) {
            pLong.value = (long) zVar2.field_reportId;
        }
        return a(xVar, zVar2.field_decryptKey, zVar2.field_pkgMd5, zVar2.field_reportId, i);
    }
}
