package com.tencent.mm.pluginsdk.ui.c;

import com.tencent.mm.a.e;
import com.tencent.mm.plugin.a.c;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.WebViewClient;

public final class a extends com.tencent.mm.ui.tools.a.a {
    public int fi = 104857600;
    private String nck;
    private a qOn;

    private a(String str) {
        this.nck = str;
    }

    public static a TQ(String str) {
        return new a(str);
    }

    public final int cfa() {
        return afr();
    }

    protected final int afr() {
        int shouldRemuxing;
        int i = 10485760;
        if (bi.oW(this.nck)) {
            x.w("MicroMsg.VideoBoundaryCheck", "dz[check video but path is null or nil]");
        }
        boolean is2G = ao.is2G(ad.getContext());
        if (c.oZ(this.nck)) {
            double d;
            String str = this.nck;
            if (!is2G) {
                i = this.fi;
            }
            if (is2G) {
                d = 60000.0d;
            } else {
                d = (double) this.fi;
            }
            shouldRemuxing = SightVideoJNI.shouldRemuxing(str, 660, 500, i, d, 1000000);
        } else {
            if (e.cm(this.nck) > (is2G ? 10485760 : 26214400)) {
                shouldRemuxing = -1;
            } else {
                shouldRemuxing = 1;
            }
        }
        x.i("MicroMsg.VideoBoundaryCheck", "check should remuxing, ret %d, isMp4 %b", new Object[]{Integer.valueOf(shouldRemuxing), Boolean.valueOf(r10)});
        switch (shouldRemuxing) {
            case WebViewClient.ERROR_CONNECT /*-6*/:
            case WebViewClient.ERROR_PROXY_AUTHENTICATION /*-5*/:
            case WebViewClient.ERROR_AUTHENTICATION /*-4*/:
            case WebViewClient.ERROR_UNSUPPORTED_AUTH_SCHEME /*-3*/:
            case -2:
                return 1;
            case -1:
                return 2;
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return 0;
            default:
                x.e("MicroMsg.VideoBoundaryCheck", "unknown check type %d", new Object[]{Integer.valueOf(shouldRemuxing)});
                return 1;
        }
    }

    protected final void cfb() {
        if (this.qOn == null) {
            x.w("MicroMsg.VideoBoundaryCheck", "dz[callback is null]");
        } else {
            afr();
        }
    }
}
