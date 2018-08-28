package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;

class BakToPcUI$5 implements Runnable {
    final /* synthetic */ int bFq;
    final /* synthetic */ BakToPcUI haT;

    BakToPcUI$5(BakToPcUI bakToPcUI, int i) {
        this.haT = bakToPcUI;
        this.bFq = i;
    }

    public final void run() {
        x.d("MicroMsg.BakToPcUI", "BakToPcUI onCloseSocket errType: %d", new Object[]{Integer.valueOf(this.bFq)});
        if (this.bFq == -1) {
            x.d("MicroMsg.BakToPcUI", "BakToPcUI jump tips");
            Intent intent = new Intent();
            intent.putExtra("title", this.haT.getString(R.l.backup_pc_not_support_title));
            intent.putExtra("rawUrl", this.haT.getString(R.l.backup_not_support_doc, new Object[]{w.chP()}));
            intent.putExtra("showShare", false);
            intent.putExtra("neverGetA8Key", true);
            d.b(this.haT, "webview", ".ui.tools.WebViewUI", intent);
            return;
        }
        BakToPcUI.e(this.haT);
    }
}
