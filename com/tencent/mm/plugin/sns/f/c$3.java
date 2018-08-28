package com.tencent.mm.plugin.sns.f;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.sns.f.d.a;
import com.tencent.mm.plugin.sns.f.d.b;
import com.tencent.mm.plugin.sns.ui.a.a.c;
import com.tencent.mm.protocal.c.boy;
import com.tencent.mm.sdk.platformtools.x;

class c$3 implements OnClickListener {
    final /* synthetic */ boy noy;
    final /* synthetic */ b nul;
    final /* synthetic */ c nun;
    final /* synthetic */ d nuo;
    final /* synthetic */ c nup;
    final /* synthetic */ a nuq;
    final /* synthetic */ Context val$context;

    c$3(c cVar, Context context, boy boy, a aVar, b bVar, c cVar2, d dVar) {
        this.nup = cVar;
        this.val$context = context;
        this.noy = boy;
        this.nuq = aVar;
        this.nul = bVar;
        this.nun = cVar2;
        this.nuo = dVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.SnSABTestMgr", "onClick alert1");
        c.a(this.nup, this.val$context, this.noy, this.nuq, this.nul, this.nun, this.nuo);
    }
}
