package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;

class aq$2 implements OnClickListener {
    final /* synthetic */ int doP;
    final /* synthetic */ d jGF;
    final /* synthetic */ aq jHr;

    aq$2(aq aqVar, d dVar, int i) {
        this.jHr = aqVar;
        this.jGF = dVar;
        this.doP = i;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.jGF.E(this.doP, a.f("add_download_task:fail_network_not_wifi", null));
    }
}
