package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.widget.Toast;
import com.tencent.mm.R;

class g$43 implements Runnable {
    final /* synthetic */ g qiK;

    g$43(g gVar) {
        this.qiK = gVar;
    }

    public final void run() {
        Toast.makeText(g.j(this.qiK), g.j(this.qiK).getString(R.l.game_download_sdcard_unavailable), 0).show();
    }
}
