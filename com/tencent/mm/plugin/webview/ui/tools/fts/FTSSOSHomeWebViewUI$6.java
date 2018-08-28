package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.c;

class FTSSOSHomeWebViewUI$6 implements OnItemClickListener {
    final /* synthetic */ FTSSOSHomeWebViewUI qeq;

    FTSSOSHomeWebViewUI$6(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI) {
        this.qeq = fTSSOSHomeWebViewUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        c AW = FTSSOSHomeWebViewUI.z(this.qeq).getItem(i);
        this.qeq.bXk().j(AW.content, null);
        if (AW.type == 2) {
            FTSSOSHomeWebViewUI.a(this.qeq, AW, 1);
            FTSSOSHomeWebViewUI.e(this.qeq, 1);
        }
        this.qeq.anx();
    }
}
