package com.tencent.mm.plugin.game.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.model.an;

class t$1 implements OnClickListener {
    final /* synthetic */ t kcJ;
    final /* synthetic */ String val$url;

    t$1(t tVar, String str) {
        this.kcJ = tVar;
        this.val$url = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        c.an(t.a(this.kcJ), this.val$url);
        an.a(t.a(this.kcJ), t.b(this.kcJ).scene, t.b(this.kcJ).bYq, t.b(this.kcJ).position, 17, t.b(this.kcJ).field_appId, t.c(this.kcJ), t.b(this.kcJ).bHF, t.b(this.kcJ).jLt);
    }
}
