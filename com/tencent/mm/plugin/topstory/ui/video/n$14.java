package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.mm.plugin.topstory.ui.b.g;
import com.tencent.mm.sdk.platformtools.al.a;

class n$14 implements a {
    final /* synthetic */ n oBM;

    n$14(n nVar) {
        this.oBM = nVar;
    }

    public final boolean vD() {
        n.k(this.oBM);
        n.m(this.oBM).setText(this.oBM.getContext().getString(g.recommend_video_play_next_hint, new Object[]{Integer.valueOf(n.l(this.oBM))}));
        if (n.l(this.oBM) > 0) {
            return true;
        }
        this.oBM.iC(true);
        return false;
    }
}
