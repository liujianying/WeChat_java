package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.widget.Toast;
import com.tencent.mm.R;

class g$42 implements Runnable {
    final /* synthetic */ g qiK;

    g$42(g gVar) {
        this.qiK = gVar;
    }

    public final void run() {
        Toast.makeText(g.j(this.qiK), g.j(this.qiK).getString(R.l.game_download_network_unavailable), 0).show();
    }
}
