package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b.h;
import com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView.a;
import com.tencent.mm.plugin.profile.a.c;

class EnterpriseBizContactListView$a$3 implements OnClickListener {
    final /* synthetic */ String dhh;
    final /* synthetic */ a hpx;
    final /* synthetic */ Context val$context;

    EnterpriseBizContactListView$a$3(a aVar, String str, Context context) {
        this.hpx = aVar;
        this.dhh = str;
        this.val$context = context;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        c cVar = new c(this.dhh, true);
        g.DF().a(1394, this.hpx);
        g.DF().a(cVar, 0);
        a aVar = this.hpx;
        Context context = this.val$context;
        this.val$context.getString(h.app_tip);
        aVar.tipDialog = com.tencent.mm.ui.base.h.a(context, this.val$context.getString(h.app_waiting), true, new 1(this, cVar));
    }
}
