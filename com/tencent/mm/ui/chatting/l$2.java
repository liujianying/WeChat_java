package com.tencent.mm.ui.chatting;

import android.graphics.Bitmap;
import com.tencent.mm.modelappbrand.b.b.h;
import com.tencent.mm.plugin.appbrand.q.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.m;

class l$2 implements h {
    final /* synthetic */ m hrc;

    l$2(m mVar) {
        this.hrc = mVar;
    }

    public final void Kc() {
    }

    public final void n(Bitmap bitmap) {
        x.d("MicroMsg.ChattingEditModeSendToAppBrand", "onBitmapLoaded %s", new Object[]{this.hrc.dzI});
    }

    public final void Kd() {
    }

    public final String Ke() {
        return k.bq(this);
    }
}
