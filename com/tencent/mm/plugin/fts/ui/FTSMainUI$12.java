package com.tencent.mm.plugin.fts.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.support.design.a$i;
import com.tencent.mm.ab.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.f;

class FTSMainUI$12 implements OnCancelListener {
    final /* synthetic */ f hkM;
    final /* synthetic */ e jwb;
    final /* synthetic */ FTSMainUI jxp;

    FTSMainUI$12(FTSMainUI fTSMainUI, f fVar, e eVar) {
        this.jxp = fTSMainUI;
        this.hkM = fVar;
        this.jwb = eVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.hkM);
        g.DF().b(a$i.AppCompatTheme_ratingBarStyle, this.jwb);
        FTSMainUI.j(this.jxp);
    }
}
