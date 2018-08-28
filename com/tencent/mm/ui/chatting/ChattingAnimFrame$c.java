package com.tencent.mm.ui.chatting;

import android.view.animation.AnimationSet;
import com.tencent.mm.plugin.gif.MMAnimateView;

class ChattingAnimFrame$c extends AnimationSet {
    int fi;
    final /* synthetic */ ChattingAnimFrame tIp;
    private long tIx;
    MMAnimateView tIy;

    static /* synthetic */ void a(ChattingAnimFrame$c chattingAnimFrame$c) {
        chattingAnimFrame$c.setStartOffset(chattingAnimFrame$c.tIx);
        chattingAnimFrame$c.start();
    }

    public ChattingAnimFrame$c(ChattingAnimFrame chattingAnimFrame, int i, int i2, long j, boolean z) {
        this.tIp = chattingAnimFrame;
        super(false);
        this.fi = i2;
        switch (i) {
            case 0:
            case 1:
                addAnimation(new ChattingAnimFrame$b(chattingAnimFrame, i, this.fi));
                break;
            case 2:
                addAnimation(new ChattingAnimFrame$b(chattingAnimFrame, 999, this.fi));
                addAnimation(new ChattingAnimFrame$b(chattingAnimFrame, i, this.fi));
                break;
            case 3:
                addAnimation(new ChattingAnimFrame$b(chattingAnimFrame, i, this.fi, z));
                addAnimation(new ChattingAnimFrame$b(chattingAnimFrame, 999, this.fi));
                break;
            default:
                addAnimation(new ChattingAnimFrame$b(chattingAnimFrame, 0, this.fi));
                break;
        }
        setAnimationListener(new 1(this, chattingAnimFrame));
        this.tIx = 500 + j;
        reset();
        setDuration(ChattingAnimFrame.EL(i));
    }
}
