package com.tencent.mm.ui.conversation;

import com.tencent.mm.plugin.appbrand.widget.recentview.a;
import com.tencent.mm.ui.conversation.ConversationWithAppBrandListView.3;

class ConversationWithAppBrandListView$3$1 implements Runnable {
    final /* synthetic */ a gPy;
    final /* synthetic */ 3 upC;

    ConversationWithAppBrandListView$3$1(3 3, a aVar) {
        this.upC = 3;
        this.gPy = aVar;
    }

    public final void run() {
        if (ConversationWithAppBrandListView.e(this.upC.upB) != null && this.gPy != null) {
            if (this.gPy.type != 1 || this.gPy.gOT == null) {
                this.upC.upB.B(0, 2);
                return;
            }
            ConversationWithAppBrandListView.e(this.upC.upB).gPd.append(this.gPy.gOT.appId + ":");
        }
    }
}
