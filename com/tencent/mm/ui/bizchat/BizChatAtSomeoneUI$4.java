package com.tencent.mm.ui.bizchat;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.ak.o;

class BizChatAtSomeoneUI$4 implements OnScrollListener {
    final /* synthetic */ BizChatAtSomeoneUI tDX;

    BizChatAtSomeoneUI$4(BizChatAtSomeoneUI bizChatAtSomeoneUI) {
        this.tDX = bizChatAtSomeoneUI;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        o.Pj().br(i);
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
