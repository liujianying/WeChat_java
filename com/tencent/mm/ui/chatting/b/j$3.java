package com.tencent.mm.ui.chatting.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.b.b.g;
import com.tencent.mm.ui.chatting.m;

class j$3 implements OnClickListener {
    final /* synthetic */ j tOS;

    j$3(j jVar) {
        this.tOS = jVar;
    }

    public final void onClick(View view) {
        if (((g) this.tOS.bAG.O(g.class)).boX() == 0) {
            x.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
        } else {
            m.a(this.tOS.bAG, j.c(this.tOS), j.d(this.tOS), this.tOS, j.e(this.tOS));
        }
    }
}
