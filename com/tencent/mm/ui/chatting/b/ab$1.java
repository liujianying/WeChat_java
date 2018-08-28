package com.tencent.mm.ui.chatting.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.mm.ap.a;

class ab$1 implements OnClickListener {
    final /* synthetic */ a tRf;
    final /* synthetic */ ab tRg;
    final /* synthetic */ View val$view;

    ab$1(ab abVar, View view, a aVar) {
        this.tRg = abVar;
        this.val$view = view;
        this.tRf = aVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        ab.a(this.tRg, this.val$view, (com.tencent.mm.ui.chatting.f.a) this.tRf);
    }
}
