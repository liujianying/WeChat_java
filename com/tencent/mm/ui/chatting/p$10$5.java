package com.tencent.mm.ui.chatting;

import android.content.Intent;
import com.tencent.mm.bg.d.a;
import com.tencent.mm.ui.chatting.p.10;

class p$10$5 implements a {
    final /* synthetic */ 10 tJn;

    p$10$5(10 10) {
        this.tJn = 10;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        if (i == 227) {
            p.a(this.tJn.tJl, p.e(this.tJn.tJl), i2, intent);
        }
    }
}
