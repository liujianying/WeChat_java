package com.tencent.mm.plugin.topstory.ui.video;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.topstory.ui.a.c;
import com.tencent.mm.plugin.websearch.api.a.a;

class n$6 implements OnClickListener {
    final /* synthetic */ n oBM;

    n$6(n nVar) {
        this.oBM = nVar;
    }

    public final void onClick(View view) {
        if (n.b(this.oBM).bHQ().jMc) {
            a.kB(10);
            c.a(n.b(this.oBM), this.oBM.getContext(), this.oBM, n.d(this.oBM));
        }
    }
}
