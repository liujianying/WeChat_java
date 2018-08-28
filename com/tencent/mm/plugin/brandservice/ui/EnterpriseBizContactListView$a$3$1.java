package com.tencent.mm.plugin.brandservice.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView.a.3;
import com.tencent.mm.plugin.profile.a.c;

class EnterpriseBizContactListView$a$3$1 implements OnCancelListener {
    final /* synthetic */ c hpy;
    final /* synthetic */ 3 hpz;

    EnterpriseBizContactListView$a$3$1(3 3, c cVar) {
        this.hpz = 3;
        this.hpy = cVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.hpy);
        g.DF().b(1394, this.hpz.hpx);
    }
}
