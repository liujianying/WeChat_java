package com.tencent.mm.plugin.appbrand.appcache;

import android.util.Pair;
import com.tencent.mm.plugin.appbrand.a.a;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public enum m implements a {
    ;
    
    private int fgd;
    private String fge;

    private m(String str) {
        this.fgd = -1;
        this.fge = null;
    }

    final void A(int i, String str) {
        this.fgd = i;
        this.fge = str;
    }

    public final void cs(boolean z) {
        Pair p = ak.p(z, true);
        if (p.second == null && p.first == ak$a.APP_BROKEN) {
            al a = e.abi().a("@LibraryAppId", z ? 0 : 999, new String[]{"downloadURL", "version"});
            if (a != null && !bi.oW(a.field_downloadURL)) {
                int i;
                if (z) {
                    i = a.field_version;
                } else {
                    i = 0;
                }
                1 1 = new 1(this, i);
                if (z) {
                    if (this.fgd > 0 && !bi.oW(this.fge)) {
                        x.i("MicroMsg.AppBrand.PkgDownloadService", "[incremental] lib can be patch, abtest open %b", new Object[]{Boolean.valueOf(k.abF())});
                        if (k.abF()) {
                            if (ak.t("@LibraryAppId", 0, this.fgd).first == ak$a.APP_READY) {
                                x.i("MicroMsg.AppBrand.PkgDownloadService", "[incremental] start incremental lib download");
                                i.a("@LibraryAppId", this.fgd, a.field_version, this.fge, 1);
                                return;
                            }
                            x.e("MicroMsg.AppBrand.PkgDownloadService", "[incremental] OldLibPkg[%d] or PatchUrl[%s] Invalid", new Object[]{Integer.valueOf(this.fgd), this.fge});
                        }
                    }
                    aq.a(a.field_downloadURL, a.field_version, 1);
                    return;
                }
                aq.a(a.field_downloadURL, 1);
            }
        }
    }
}
