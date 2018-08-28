package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;

class i$3 implements OnCancelListener {
    final /* synthetic */ int doP;
    final /* synthetic */ d jGF;
    final /* synthetic */ i jGV;

    i$3(i iVar, d dVar, int i) {
        this.jGV = iVar;
        this.jGF = dVar;
        this.doP = i;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.jGF.E(this.doP, a.f("doChooseMedia:cancel", null));
    }
}
