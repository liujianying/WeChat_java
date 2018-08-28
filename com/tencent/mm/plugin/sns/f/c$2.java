package com.tencent.mm.plugin.sns.f;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.f.d.b;
import com.tencent.mm.plugin.sns.ui.a.a.c;

class c$2 implements OnClickListener {
    final /* synthetic */ d$a nuk;
    final /* synthetic */ b nul;
    final /* synthetic */ c nun;
    final /* synthetic */ d nuo;
    final /* synthetic */ c nup;
    final /* synthetic */ Context val$context;

    c$2(c cVar, Context context, d$a d_a, b bVar, c cVar2, d dVar) {
        this.nup = cVar;
        this.val$context = context;
        this.nuk = d_a;
        this.nul = bVar;
        this.nun = cVar2;
        this.nuo = dVar;
    }

    public final void onClick(View view) {
        c.a(this.nup, this.val$context, view, this.nuk, this.nul, this.nun, this.nuo);
    }
}
