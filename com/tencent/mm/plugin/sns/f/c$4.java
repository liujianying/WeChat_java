package com.tencent.mm.plugin.sns.f;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.sns.f.d.b;
import com.tencent.mm.plugin.sns.ui.a.a.c;
import com.tencent.mm.protocal.c.boy;
import com.tencent.mm.sdk.platformtools.x;

class c$4 implements OnClickListener {
    final /* synthetic */ boy noy;
    final /* synthetic */ b nul;
    final /* synthetic */ c nun;
    final /* synthetic */ d nuo;
    final /* synthetic */ c nup;
    final /* synthetic */ d$a nur;
    final /* synthetic */ Context val$context;

    c$4(c cVar, Context context, boy boy, d$a d_a, b bVar, c cVar2, d dVar) {
        this.nup = cVar;
        this.val$context = context;
        this.noy = boy;
        this.nur = d_a;
        this.nul = bVar;
        this.nun = cVar2;
        this.nuo = dVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.SnSABTestMgr", "onClick alert2");
        c.a(this.nup, this.val$context, this.noy, this.nur, this.nul, this.nun, this.nuo);
    }
}
