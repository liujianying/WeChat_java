package com.tencent.mm.ui.chatting;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mm.sdk.platformtools.x;

class y$11 implements OnGlobalLayoutListener {
    final /* synthetic */ y tMm;

    y$11(y yVar) {
        this.tMm = yVar;
    }

    public final void onGlobalLayout() {
        y.a(this.tMm).getViewTreeObserver().removeGlobalOnLayoutListener(this);
        if (y.b(this.tMm) || y.c(this.tMm) != 0) {
            x.w("MicroMsg.ChattingUIFragment", "error state user has touch listview, not need to scroll to last. userTouched: %s state: %s", new Object[]{Boolean.valueOf(y.b(this.tMm)), Integer.valueOf(y.c(this.tMm))});
            return;
        }
        x.i("MicroMsg.ChattingUIFragment", "first time in, scroll to last");
        this.tMm.EV(y.a(this.tMm).getCount() - 1);
    }
}
