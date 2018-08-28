package com.tencent.mm.ui.chatting.b;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mm.sdk.platformtools.x;

class ah$4 implements OnGlobalLayoutListener {
    final /* synthetic */ long cXh;
    final /* synthetic */ ah tSj;

    ah$4(ah ahVar, long j) {
        this.tSj = ahVar;
        this.cXh = j;
    }

    public final void onGlobalLayout() {
        x.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr needCheckHistoryTips onGlobalLayout run delay[%d], BADCR_SCROLL_DELAY[%d] needCheckHistoryTips[%b]", new Object[]{Long.valueOf(System.currentTimeMillis() - this.cXh), Integer.valueOf(ah.tSa), Boolean.valueOf(this.tSj.tSc)});
        this.tSj.bAG.getListView().getViewTreeObserver().removeGlobalOnLayoutListener(this);
        this.tSj.bAG.lT(false);
        this.tSj.bAG.getListView().postDelayed(new 1(this), (long) ah.tSa);
    }
}
