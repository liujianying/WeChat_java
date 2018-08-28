package com.tencent.mm.plugin.webview.modelcache.downloaderimpl;

import com.tencent.mm.pluginsdk.g.a.c.m;
import com.tencent.mm.pluginsdk.g.a.c.q.a;
import com.tencent.mm.pluginsdk.g.a.c.s;
import com.tencent.mm.sdk.platformtools.x;

final class b {
    static void c(String str, m mVar) {
        s Tn = a.ccH().Tn(str);
        if (Tn == null) {
            x.e("MicroMsg.ResDownloader.WebViewCache.DoResponseLogic", "networkRequest already completed, but get null record with urlKey = %s", str);
        } else if ("WebViewCache".equals(Tn.field_groupId1)) {
            Tn.field_contentType = mVar.aBC;
            a.ccH().g(Tn);
            f fVar = new f(Tn.field_url, Tn.field_filePath, Tn.field_fileVersion, Tn.field_appId, Tn.field_groupId2, Tn.field_packageId, Tn.field_wvCacheType, mVar.aBC, mVar.cfA, mVar.qDk);
            WebViewCacheDownloadHelper.bUM();
            WebViewCacheDownloadHelper.a(fVar);
        } else {
            x.e("MicroMsg.ResDownloader.WebViewCache.DoResponseLogic", "mismatch groupId, urlKey = %s, record.groupId = %s", str, Tn.field_groupId1);
        }
    }
}
