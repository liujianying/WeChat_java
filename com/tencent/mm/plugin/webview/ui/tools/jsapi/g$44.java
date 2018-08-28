package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.widget.Toast;
import com.tencent.mm.R;

class g$44 implements Runnable {
    final /* synthetic */ g qiK;

    g$44(g gVar) {
        this.qiK = gVar;
    }

    public final void run() {
        Toast.makeText(g.j(this.qiK), g.j(this.qiK).getString(R.l.game_download_not_enough_space), 0).show();
    }
}
