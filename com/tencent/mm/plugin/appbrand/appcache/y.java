package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.a.g;
import com.tencent.mm.plugin.appbrand.p.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class y extends c<x> {
    public static final String[] dzV = new String[]{i.a(x.dzU, "PredownloadEncryptPkgInfo")};
    private final e fgu;

    public y(e eVar) {
        super(eVar, x.dzU, "PredownloadEncryptPkgInfo", x.ciG);
        this.fgu = eVar;
    }

    public final x p(String str, int i, int i2) {
        if (bi.oW(str)) {
            return null;
        }
        x xVar = new x();
        xVar.field_appId = str;
        xVar.field_type = i;
        xVar.field_version = i2;
        if (b(xVar, x.fgs)) {
            return xVar;
        }
        return null;
    }

    public final x q(String str, int i, int i2) {
        x p = p(str, i, i2);
        return (p == null || !a(p)) ? null : p;
    }

    static boolean a(x xVar) {
        if (bi.oW(xVar.field_pkgPath)) {
            x.i("MicroMsg.AppBrand.PredownloadEncryptPkgStorage", "checkPkgIntegrity, with %s path nil", new Object[]{xVar.toShortString()});
            return false;
        } else if (bi.oW(xVar.field_pkgMd5)) {
            x.i("MicroMsg.AppBrand.PredownloadEncryptPkgStorage", "checkPkgIntegrity, with %s record md5 nil", new Object[]{xVar.toShortString()});
            return false;
        } else {
            x.i("MicroMsg.AppBrand.PredownloadEncryptPkgStorage", "checkPkgIntegrity with %s, file_md5(%s), record_md5(%s)", new Object[]{xVar.toShortString(), g.cu(xVar.field_pkgPath), xVar.field_pkgMd5});
            return xVar.field_pkgMd5.equals(g.cu(xVar.field_pkgPath));
        }
    }
}
