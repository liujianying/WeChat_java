package com.tencent.mm.ui.conversation;

import android.graphics.Rect;
import android.view.ViewGroup;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.ui.HomeUI.FitSystemWindowLayoutView;

class BaseConversationUI$7 implements Runnable {
    final /* synthetic */ int[] tpt;
    final /* synthetic */ FitSystemWindowLayoutView tpu;
    final /* synthetic */ ViewGroup tpv;
    final /* synthetic */ BaseConversationUI unn;

    BaseConversationUI$7(BaseConversationUI baseConversationUI, int[] iArr, FitSystemWindowLayoutView fitSystemWindowLayoutView, ViewGroup viewGroup) {
        this.unn = baseConversationUI;
        this.tpt = iArr;
        this.tpu = fitSystemWindowLayoutView;
        this.tpv = viewGroup;
    }

    public final void run() {
        this.unn.getSupportActionBar().getCustomView().getLocationInWindow(this.tpt);
        int i = this.tpt[1];
        if (i > 0) {
            BaseConversationUI.access$1300(this.unn, this.tpu, i, new Rect(0, i, 0, 0), this.tpv);
        } else if (d.fR(20)) {
            this.tpu.setOnApplyWindowInsetsListener(new 1(this));
        }
    }
}
