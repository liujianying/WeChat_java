package com.tencent.mm.plugin.fts.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.ui.j.b;
import com.tencent.mm.plugin.websearch.api.e;
import com.tencent.mm.sdk.platformtools.bi;

class FTSMainUI$6 implements b {
    final /* synthetic */ FTSMainUI jxp;

    FTSMainUI$6(FTSMainUI fTSMainUI) {
        this.jxp = fTSMainUI;
    }

    public final void aQN() {
        String query = FTSMainUI.a(this.jxp).getQuery();
        if (FTSMainUI.a(this.jxp).getVisibility() == 0 && !bi.oW(query) && !FTSMainUI.b(this.jxp).containsKey(query)) {
            FTSMainUI.b(this.jxp).put(query, Integer.valueOf(1));
            ((e) g.l(e.class)).ah(query, FTSMainUI.a(this.jxp).getSearchId(), FTSMainUI.a(this.jxp).getWordList());
        }
    }
}
