package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.pluginsdk.permission.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class FTSSOSHomeWebViewUI$15 implements OnClickListener {
    final /* synthetic */ FTSSOSHomeWebViewUI qeq;

    FTSSOSHomeWebViewUI$15(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI) {
        this.qeq = fTSSOSHomeWebViewUI;
    }

    public final void onClick(View view) {
        int i = 2;
        x.i("MicroMsg.FTS.FTSSOSHomeWebViewUI", "summerper checkPermission checkmicrophone[%s], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(a.a(this.qeq, "android.permission.RECORD_AUDIO", 80, "", "")), bi.cjd(), this.qeq});
        if (a.a(this.qeq, "android.permission.RECORD_AUDIO", 80, "", "")) {
            Intent intent = new Intent();
            intent.putExtra("sessionId", this.qeq.bJK);
            intent.putExtra("subSessionId", this.qeq.bWr);
            intent.putExtra("key_scene", this.qeq.scene);
            String str = "key_is_nav_voice";
            if (this.qeq.qdW.bXy()) {
                i = 1;
            }
            intent.putExtra(str, i);
            intent.setClass(this.qeq, WebSearchVoiceUI.class);
            this.qeq.startActivityForResult(intent, 1);
            this.qeq.overridePendingTransition(0, 0);
        }
    }
}
