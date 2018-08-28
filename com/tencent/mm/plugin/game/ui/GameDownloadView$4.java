package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.plugin.game.model.m.b;
import com.tencent.mm.sdk.platformtools.bi;

class GameDownloadView$4 implements b {
    final /* synthetic */ GameDownloadView jXJ;

    GameDownloadView$4(GameDownloadView gameDownloadView) {
        this.jXJ = gameDownloadView;
    }

    public final void f(int i, String str, boolean z) {
        if (z && !bi.oW(str) && GameDownloadView.b(this.jXJ) != null && GameDownloadView.b(this.jXJ).jMa != null && GameDownloadView.b(this.jXJ).jMa.field_appId.equals(str)) {
            this.jXJ.refresh();
        }
    }
}
