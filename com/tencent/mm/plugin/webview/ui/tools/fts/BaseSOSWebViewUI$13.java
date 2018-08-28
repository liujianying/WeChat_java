package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.mm.plugin.websearch.api.o;
import com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.c;
import java.util.HashMap;
import java.util.Map;

class BaseSOSWebViewUI$13 implements Runnable {
    final /* synthetic */ BaseSOSWebViewUI qdp;
    final /* synthetic */ c qdt;

    BaseSOSWebViewUI$13(BaseSOSWebViewUI baseSOSWebViewUI, c cVar) {
        this.qdp = baseSOSWebViewUI;
        this.qdt = cVar;
    }

    public final void run() {
        if (BaseSOSWebViewUI.a(this.qdp) != null) {
            this.qdp.bXe();
            int i = this.qdp.qdD;
            this.qdp.qdD = this.qdt.type;
            this.qdp.bXf();
            Bundle bundle = new Bundle();
            bundle.putInt("type", this.qdp.qdD);
            bundle.putBoolean("isHomePage", true);
            bundle.putInt("scene", this.qdp.aUM());
            try {
                Bundle p = BaseSOSWebViewUI.b(this.qdp).p(4, bundle);
                Map hashMap = new HashMap();
                hashMap.put("isBackButtonClick", "1");
                hashMap.put("custom", this.qdp.getInEditTextQuery());
                if (this.qdp.qdD != i) {
                    BaseSOSWebViewUI.c(this.qdp).a(p.getString("scene", "0"), p.getString("type", "0"), p.getString("isSug", "0"), p.getString("isLocalSug", "0"), this.qdp.getSessionId(), hashMap, this.qdt.qdy);
                } else {
                    BaseSOSWebViewUI.d(this.qdp).a(this.qdp.getTotalQuery(), this.qdp.getInEditTextQuery(), this.qdp.bXp(), 1, this.qdt.qdy);
                }
                if (!TextUtils.isEmpty(this.qdp.getInEditTextQuery())) {
                    o.a(this.qdp.scene, this.qdp.bJK, this.qdp.bWr, this.qdp.getInEditTextQuery(), this.qdp.type);
                }
            } catch (RemoteException e) {
            }
        }
    }
}
