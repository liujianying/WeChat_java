package com.tencent.mm.plugin.bottle.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.messenger.a.f;

class BottleBeachUI$5 implements OnCancelListener {
    final /* synthetic */ BottleBeachUI hkL;
    final /* synthetic */ f hkM;

    BottleBeachUI$5(BottleBeachUI bottleBeachUI, f fVar) {
        this.hkL = bottleBeachUI;
        this.hkM = fVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        au.DF().c(this.hkM);
    }
}
