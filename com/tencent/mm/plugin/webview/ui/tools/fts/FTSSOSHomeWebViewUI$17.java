package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.websearch.api.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.fts.widget.FTSMainUIHotWordLayout$a;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.HashMap;
import java.util.Map;

class FTSSOSHomeWebViewUI$17 implements OnClickListener {
    final /* synthetic */ FTSSOSHomeWebViewUI qeq;

    FTSSOSHomeWebViewUI$17(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI) {
        this.qeq = fTSSOSHomeWebViewUI;
    }

    public final void onClick(View view) {
        Bundle bundle;
        Map hashMap;
        FTSMainUIHotWordLayout$a fTSMainUIHotWordLayout$a = (FTSMainUIHotWordLayout$a) view.getTag();
        switch (fTSMainUIHotWordLayout$a.bYt) {
            case 1:
                if (this.qeq.qdo) {
                    FTSSOSHomeWebViewUI.o(this.qeq);
                    FTSSOSHomeWebViewUI.e(this.qeq, 0);
                    this.qeq.bXk().clearText();
                    this.qeq.bXk().j(fTSMainUIHotWordLayout$a.utK, null);
                    this.qeq.bXk().aQY();
                    FTSSOSHomeWebViewUI.a(this.qeq).Dd(13);
                    try {
                        bundle = new Bundle();
                        bundle.putInt(DownloadSettingTable$Columns.TYPE, 0);
                        bundle.putBoolean("isHomePage", true);
                        bundle.putInt("scene", 20);
                        bundle = FTSSOSHomeWebViewUI.p(this.qeq).p(4, bundle);
                        hashMap = new HashMap();
                        hashMap.put("sceneActionType", "2");
                        hashMap.put("recommendId", FTSSOSHomeWebViewUI.q(this.qeq).getSearchId());
                        FTSSOSHomeWebViewUI.t(this.qeq).post(new 1(this, bundle, hashMap));
                        break;
                    } catch (Exception e) {
                        break;
                    }
                }
                return;
            case 4:
                Intent intent = new Intent();
                intent.putExtra("rawUrl", fTSMainUIHotWordLayout$a.jumpUrl);
                intent.putExtra("convertActivityFromTranslucent", false);
                d.b(ad.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                break;
        }
        try {
            hashMap = new HashMap();
            hashMap.put("isclick", Integer.valueOf(1));
            hashMap.put("scene", Integer.valueOf(20));
            hashMap.put("recommendid", FTSSOSHomeWebViewUI.q(this.qeq).getSearchId());
            hashMap.put("businesstype", Integer.valueOf(0));
            hashMap.put("docid", fTSMainUIHotWordLayout$a.utK != null ? Uri.encode(fTSMainUIHotWordLayout$a.utK) : "");
            hashMap.put("docpos", Integer.valueOf(fTSMainUIHotWordLayout$a.utL + 1));
            hashMap.put("ishomepage", Integer.valueOf(1));
            hashMap.put("typepos", Integer.valueOf(1));
            hashMap.put("jumpurl", Uri.encode(fTSMainUIHotWordLayout$a.jumpUrl));
            String U = p.U(hashMap);
            bundle = new Bundle();
            bundle.putString("logString", U);
            FTSSOSHomeWebViewUI.u(this.qeq).g(131, bundle);
        } catch (Exception e2) {
            x.w("MicroMsg.FTS.FTSSOSHomeWebViewUI", "onHotwordCellClickListener cgi report fail for %s", new Object[]{e2.toString()});
        }
    }
}
