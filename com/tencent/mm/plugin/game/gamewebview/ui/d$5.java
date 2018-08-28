package com.tencent.mm.plugin.game.gamewebview.ui;

import android.net.Uri;
import com.tencent.mm.pluginsdk.model.app.g;

class d$5 implements Runnable {
    final /* synthetic */ Uri hdW;
    final /* synthetic */ d jJO;

    d$5(d dVar, Uri uri) {
        this.jJO = dVar;
        this.hdW = uri;
    }

    public final void run() {
        g.f(d.t(this.jJO), this.hdW);
    }
}
