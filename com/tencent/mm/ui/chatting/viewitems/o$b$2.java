package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.i;
import com.tencent.mm.plugin.messenger.a.a;
import com.tencent.mm.ui.chatting.viewitems.o.b;
import com.tencent.mm.ui.chatting.viewitems.o.d;

class o$b$2 extends a {
    final /* synthetic */ d ubF;
    final /* synthetic */ String ubH;
    final /* synthetic */ String ubI;
    final /* synthetic */ b ubJ;

    o$b$2(b bVar, String str, d dVar, String str2) {
        this.ubJ = bVar;
        this.ubH = str;
        this.ubF = dVar;
        this.ubI = str2;
    }

    public final void onClickImp(View view) {
        ((i) g.l(i.class)).I(this.ubH, 2);
        this.ubF.ubL.setText(this.ubI);
    }
}
