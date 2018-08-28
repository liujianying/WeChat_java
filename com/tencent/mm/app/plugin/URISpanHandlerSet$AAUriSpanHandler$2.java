package com.tencent.mm.app.plugin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.app.plugin.URISpanHandlerSet.AAUriSpanHandler;
import com.tencent.mm.g.a.bp;
import com.tencent.mm.sdk.b.a;

class URISpanHandlerSet$AAUriSpanHandler$2 implements OnClickListener {
    final /* synthetic */ String bAu;
    final /* synthetic */ String bAv;
    final /* synthetic */ long bAw;
    final /* synthetic */ AAUriSpanHandler bAx;

    URISpanHandlerSet$AAUriSpanHandler$2(AAUriSpanHandler aAUriSpanHandler, String str, String str2, long j) {
        this.bAx = aAUriSpanHandler;
        this.bAu = str;
        this.bAv = str2;
        this.bAw = j;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        bp bpVar = new bp();
        bpVar.bJa.bIX = this.bAu;
        bpVar.bJa.bIY = this.bAv;
        bpVar.bJa.bIZ = this.bAw;
        a.sFg.m(bpVar);
    }
}
