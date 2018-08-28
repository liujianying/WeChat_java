package com.tencent.mm.ui.conversation.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.g.a.rx;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;

class o$2 implements OnClickListener {
    final /* synthetic */ o usZ;

    o$2(o oVar) {
        this.usZ = oVar;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.TryNewInitBanner", "summerinit onClick trynewinit layout start try");
        this.usZ.setVisibility(8);
        a.sFg.m(new rx());
        x.i("MicroMsg.TryNewInitBanner", "summerinit onClick tryNeeInitAgain done callBack (now by event to notice initbanner)");
    }
}
