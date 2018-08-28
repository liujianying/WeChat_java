package com.tencent.mm.app.plugin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.app.plugin.URISpanHandlerSet.AAUriSpanHandler;
import com.tencent.mm.g.a.bo;
import com.tencent.mm.sdk.b.a;

class URISpanHandlerSet$AAUriSpanHandler$1 implements OnClickListener {
    final /* synthetic */ String bAu;
    final /* synthetic */ String bAv;
    final /* synthetic */ long bAw;
    final /* synthetic */ AAUriSpanHandler bAx;

    URISpanHandlerSet$AAUriSpanHandler$1(AAUriSpanHandler aAUriSpanHandler, String str, String str2, long j) {
        this.bAx = aAUriSpanHandler;
        this.bAu = str;
        this.bAv = str2;
        this.bAw = j;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        bo boVar = new bo();
        boVar.bIW.bIX = this.bAu;
        boVar.bIW.bIY = this.bAv;
        boVar.bIW.bIZ = this.bAw;
        a.sFg.m(boVar);
    }
}
