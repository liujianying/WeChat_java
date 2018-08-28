package com.tencent.mm.plugin.sport.ui.a;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ac.f;
import com.tencent.mm.pluginsdk.g;

class a$2 implements OnClickListener {
    final /* synthetic */ a opS;

    a$2(a aVar) {
        this.opS = aVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        ((g) com.tencent.mm.kernel.g.l(g.class)).a(f.kH(this.opS.guS.field_username), (Activity) this.opS.context, this.opS.guS);
        this.opS.auv();
    }
}
