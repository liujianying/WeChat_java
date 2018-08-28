package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI$a.2;
import com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.c;
import com.tencent.mm.sdk.platformtools.ah;

class FTSSOSHomeWebViewUI$5 implements OnClickListener {
    final /* synthetic */ FTSSOSHomeWebViewUI qeq;

    FTSSOSHomeWebViewUI$5(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI) {
        this.qeq = fTSSOSHomeWebViewUI;
    }

    public final void onClick(View view) {
        c cVar = (c) view.getTag();
        if (cVar.type == 1) {
            Bundle bundle = new Bundle();
            bundle.putString("history", cVar.content);
            try {
                FTSSOSHomeWebViewUI.y(this.qeq).j(5, bundle);
            } catch (RemoteException e) {
            }
            ah.A(new 2(FTSSOSHomeWebViewUI.z(this.qeq), cVar));
        } else if (cVar.type == 2) {
            FTSSOSHomeWebViewUI.z(this.qeq).clear();
            this.qeq.bXk().j(cVar.content, null);
            FTSSOSHomeWebViewUI.a(this.qeq, cVar, 2);
            FTSSOSHomeWebViewUI.e(this.qeq, 2);
            FTSSOSHomeWebViewUI.A(this.qeq);
        }
    }
}
