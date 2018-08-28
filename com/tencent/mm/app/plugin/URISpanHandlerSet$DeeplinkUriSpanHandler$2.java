package com.tencent.mm.app.plugin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ac.d;
import com.tencent.mm.ac.f;
import com.tencent.mm.app.plugin.URISpanHandlerSet.DeeplinkUriSpanHandler;
import com.tencent.mm.sdk.platformtools.x;

class URISpanHandlerSet$DeeplinkUriSpanHandler$2 implements OnClickListener {
    final /* synthetic */ String bAA;
    final /* synthetic */ DeeplinkUriSpanHandler bAB;
    final /* synthetic */ d bAy;
    final /* synthetic */ String bAz;

    URISpanHandlerSet$DeeplinkUriSpanHandler$2(DeeplinkUriSpanHandler deeplinkUriSpanHandler, d dVar, String str, String str2) {
        this.bAB = deeplinkUriSpanHandler;
        this.bAy = dVar;
        this.bAz = str;
        this.bAA = str2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        int i2 = this.bAy.field_brandFlag;
        this.bAy.field_brandFlag &= -2;
        x.i("MicroMsg.URISpanHandlerSet", "receive biz msg %s, %s, old = %d, new = %d", new Object[]{this.bAz, this.bAA, Integer.valueOf(i2), Integer.valueOf(this.bAy.field_brandFlag)});
        f.f(this.bAy);
    }
}
