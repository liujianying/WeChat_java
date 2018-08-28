package com.tencent.mm.ui.chatting;

import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.ui.chatting.ChattingAnimFrame.c;

class ChattingAnimFrame$c$2 implements Runnable {
    final /* synthetic */ c tIA;

    ChattingAnimFrame$c$2(c cVar) {
        this.tIA = cVar;
    }

    public final void run() {
        if (this.tIA.tIy != null) {
            this.tIA.tIy.clearAnimation();
            ChattingAnimFrame chattingAnimFrame = this.tIA.tIp;
            MMAnimateView mMAnimateView = this.tIA.tIy;
            if (mMAnimateView != null && chattingAnimFrame.tIj != null) {
                chattingAnimFrame.tIj.remove(mMAnimateView);
                mMAnimateView.recycle();
                if (chattingAnimFrame.tIj.isEmpty()) {
                    mMAnimateView.setLayerType(0, null);
                    chattingAnimFrame.removeAllViews();
                    return;
                }
                mMAnimateView.setVisibility(4);
                mMAnimateView.setLayerType(0, null);
            }
        }
    }
}
