package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.gamewebview.ui.d;

class a$1 implements Runnable {
    final /* synthetic */ d jGF;
    final /* synthetic */ a jGG;

    a$1(a aVar, d dVar) {
        this.jGG = aVar;
        this.jGF = dVar;
    }

    public final void run() {
        Toast.makeText(this.jGF.getContext(), this.jGF.getContext().getString(R.l.game_download_network_unavailable), 0).show();
    }
}
