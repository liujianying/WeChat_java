package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.i;
import com.tencent.mm.plugin.messenger.a.a;

class o$a$2 extends a {
    final /* synthetic */ d ubF;
    final /* synthetic */ o.a ubG;
    final /* synthetic */ String ubH;
    final /* synthetic */ String ubI;

    o$a$2(o.a aVar, String str, d dVar, String str2) {
        this.ubG = aVar;
        this.ubH = str;
        this.ubF = dVar;
        this.ubI = str2;
    }

    public final void onClickImp(View view) {
        ((i) g.l(i.class)).I(this.ubH, 2);
        this.ubF.ubL.setText(this.ubI);
    }
}
