package com.tencent.mm.ui.chatting.g;

import android.support.v7.widget.GridLayoutManager.b;
import com.tencent.mm.ui.chatting.a.a.c;

class e$1 extends b {
    final /* synthetic */ e tYu;

    e$1(e eVar) {
        this.tYu = eVar;
    }

    public final int bc(int i) {
        if (((c) e.a(this.tYu).get(i)).type == Integer.MAX_VALUE) {
            return 4;
        }
        return 1;
    }
}
