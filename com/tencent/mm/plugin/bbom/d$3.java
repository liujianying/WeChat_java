package com.tencent.mm.plugin.bbom;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.storage.q;
import com.tencent.mm.ui.chatting.r;

class d$3 implements OnClickListener {
    final /* synthetic */ d heq;
    final /* synthetic */ q her;

    d$3(d dVar, q qVar) {
        this.heq = dVar;
        this.her = qVar;
    }

    public final void onClick(View view) {
        r.a(view, view.getContext(), this.her.field_talker);
    }
}
