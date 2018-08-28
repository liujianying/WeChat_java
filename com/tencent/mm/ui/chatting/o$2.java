package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.chatting.b.b.g;

class o$2 implements OnClickListener {
    final /* synthetic */ o tIY;
    final /* synthetic */ g tIZ;

    o$2(o oVar, g gVar) {
        this.tIY = oVar;
        this.tIZ = gVar;
    }

    public final void onClick(View view) {
        this.tIZ.gt(((Long) view.getTag()).longValue());
    }
}
