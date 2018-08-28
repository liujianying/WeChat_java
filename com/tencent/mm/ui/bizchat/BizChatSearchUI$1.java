package com.tencent.mm.ui.bizchat;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.ac.a.l;
import com.tencent.mm.model.au;

class BizChatSearchUI$1 implements OnScrollListener {
    boolean hoR = false;
    final /* synthetic */ BizChatSearchUI tEO;

    BizChatSearchUI$1(BizChatSearchUI bizChatSearchUI) {
        this.tEO = bizChatSearchUI;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0 && this.hoR && BizChatSearchUI.a(this.tEO).tFc) {
            BizChatSearchUI$a a = BizChatSearchUI.a(this.tEO);
            if (a.a() && !a.tFe) {
                a.tFe = true;
                au.DF().a(new l(a.hpJ, a.dBm, a.tFi), 0);
                a.csw();
            }
        }
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (i + i2 == i3) {
            this.hoR = true;
        } else {
            this.hoR = false;
        }
    }
}
