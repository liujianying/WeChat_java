package com.tencent.mm.plugin.offline.ui;

import com.tencent.mm.plugin.offline.a.s.g;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.ui.o.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

class c$13 implements c {
    final /* synthetic */ c lLe;
    final /* synthetic */ g lLf;

    c$13(c cVar, g gVar) {
        this.lLe = cVar;
        this.lLf = gVar;
    }

    public final void a(String str, FavorPayInfo favorPayInfo, boolean z) {
        if (this.lLe.mActivity instanceof MMActivity) {
            ((MMActivity) this.lLe.mActivity).YC();
        }
        if (this.lLe.lKZ != null) {
            this.lLe.lKZ.o(1, this.lLf.id, str);
        }
        x.i("MicroMsg.OfflineLogicMgr", "launchPwdDialog do pay");
    }
}
