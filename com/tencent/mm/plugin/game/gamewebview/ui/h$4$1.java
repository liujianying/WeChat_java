package com.tencent.mm.plugin.game.gamewebview.ui;

import com.tencent.mm.plugin.game.gamewebview.ui.h.4;
import com.tencent.mm.pluginsdk.ui.tools.s.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class h$4$1 implements b {
    final /* synthetic */ 4 jKo;

    h$4$1(4 4) {
        this.jKo = 4;
    }

    public final void uf(String str) {
        if (bi.oW(str)) {
            x.w("MicroMsg.GameWebViewMenuListHelper", "share image to friend fail, imgPath is null");
        } else {
            h.a(this.jKo.jKm, str);
        }
    }
}
