package com.tencent.mm.plugin.game.gamewebview.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.game.gamewebview.ui.d.34;
import com.tencent.xweb.f;

class d$34$10 implements OnClickListener {
    final /* synthetic */ 34 jKa;
    final /* synthetic */ f jKb;

    d$34$10(34 34, f fVar) {
        this.jKa = 34;
        this.jKb = fVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.jKb.confirm();
    }
}
