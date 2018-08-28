package com.tencent.mm.ui.bizchat;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.ak.o;

class BizChatFavUI$8 implements OnScrollListener {
    final /* synthetic */ BizChatFavUI tEG;

    BizChatFavUI$8(BizChatFavUI bizChatFavUI) {
        this.tEG = bizChatFavUI;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        o.Pj().br(i);
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
