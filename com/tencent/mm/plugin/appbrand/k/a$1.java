package com.tencent.mm.plugin.appbrand.k;

import com.tencent.mm.plugin.appbrand.k.a.a;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

class a$1 implements a {
    final /* synthetic */ String fEg;
    final /* synthetic */ a$a gkH;
    final /* synthetic */ a gkI;

    public a$1(a aVar, String str, a$a a_a) {
        this.gkI = aVar;
        this.fEg = str;
        this.gkH = a_a;
    }

    public final void b(String str, String str2, String str3, int i) {
        a.a(this.gkI, this.fEg);
        this.gkH.c(a.SUCCESS, str2, str, i);
        x.i("MicroMsg.AppBrandNetworkDownload", "download success! filename %s, url %s", new Object[]{str, str3});
    }

    public final void t(JSONObject jSONObject) {
        this.gkH.t(jSONObject);
    }

    public final void f(int i, long j, long j2) {
        this.gkH.e(i, j, j2);
    }

    public final void G(String str, String str2, String str3) {
        x.e("MicroMsg.AppBrandNetworkDownload", "download error! filename %s, url %s", new Object[]{str, str2});
        this.gkH.tQ(str3);
        a.a(this.gkI, this.fEg);
    }

    public final void bG(String str, String str2) {
        x.i("MicroMsg.AppBrandNetworkDownload", "download start! filename %s, url %s", new Object[]{str, str2});
    }

    public final void uH(String str) {
        this.gkI.gkF.remove(str);
    }
}
