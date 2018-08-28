package com.tencent.mm.ui.chatting;

import android.view.animation.Animation;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.ChattingAnimFrame.a;
import com.tencent.mm.ui.chatting.ChattingAnimFrame.c;
import com.tencent.mm.ui.chatting.ChattingAnimFrame.c.2;

class ChattingAnimFrame$c$1 extends a {
    final /* synthetic */ c tIA;
    final /* synthetic */ ChattingAnimFrame tIz;

    ChattingAnimFrame$c$1(c cVar, ChattingAnimFrame chattingAnimFrame) {
        this.tIA = cVar;
        this.tIz = chattingAnimFrame;
        super(cVar.tIp);
    }

    public final void onAnimationEnd(Animation animation) {
        c cVar = this.tIA;
        if (cVar.tIy != null) {
            cVar.tIy.post(new 2(cVar));
        } else {
            x.w("MicroMsg.ChattingAnimFrame", "mTargetView is NULL.");
        }
    }
}
