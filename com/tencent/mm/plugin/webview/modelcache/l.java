package com.tencent.mm.plugin.webview.modelcache;

import com.tencent.mm.sdk.platformtools.x;

public final class l {
    final String appId;
    final String bVd;
    final String cfx;
    final String cfy;
    final int cfz;
    final String pTa;
    final a pTb;

    public l(String str, String str2, int i, String str3, String str4) {
        this.appId = str;
        this.cfx = str2;
        this.pTa = str3;
        this.cfz = i;
        this.cfy = str4;
        x.i("MicroMsg.WebViewCacheResWriter", "init WebViewCacheResWriter, appId = %s, domain = %s, mainURL = %s, cacheType = %d", new Object[]{str, str2, str3, Integer.valueOf(i)});
        this.pTb = a.Qz(str);
        if (this.pTb != null) {
            a aVar = this.pTb;
            this.bVd = aVar.path + "/" + String.format("%d_%d_%d_%d", new Object[]{Integer.valueOf(str2.hashCode()), Integer.valueOf(i), Integer.valueOf(str3.hashCode()), Integer.valueOf(str4.hashCode())});
            return;
        }
        this.bVd = null;
        x.e("MicroMsg.WebViewCacheResWriter", "get null appIdResDir");
    }
}
