package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.text.TextUtils;
import com.tencent.mm.plugin.websearch.api.o;
import com.tencent.mm.plugin.webview.fts.b.a.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;

class BaseSOSWebViewUI$17 implements Runnable {
    final /* synthetic */ BaseSOSWebViewUI qdp;

    BaseSOSWebViewUI$17(BaseSOSWebViewUI baseSOSWebViewUI) {
        this.qdp = baseSOSWebViewUI;
    }

    public final void run() {
        if (BaseSOSWebViewUI.k(this.qdp) != null) {
            Map hashMap = new HashMap();
            if (this.qdp.bXj() != 0) {
                hashMap.put("sugClickType", Integer.valueOf(this.qdp.bXj()));
                hashMap.put("sugId", this.qdp.bXi());
            }
            d l = BaseSOSWebViewUI.l(this.qdp);
            String totalQuery = this.qdp.getTotalQuery();
            String inEditTextQuery = this.qdp.getInEditTextQuery();
            JSONArray bXp = this.qdp.bXp();
            Map hashMap2 = new HashMap();
            hashMap2.putAll(hashMap);
            hashMap2.put("query", totalQuery);
            hashMap2.put("custom", inEditTextQuery);
            hashMap2.put("tagList", bXp);
            l.a("onSearchInputConfirm", hashMap2, null);
            if (!TextUtils.isEmpty(this.qdp.getInEditTextQuery())) {
                o.a(this.qdp.qdC, this.qdp.bJK, this.qdp.bWr, this.qdp.getInEditTextQuery(), this.qdp.qdD);
            }
        }
        a.bTN();
        a.Qg(this.qdp.getTotalQuery());
    }
}
