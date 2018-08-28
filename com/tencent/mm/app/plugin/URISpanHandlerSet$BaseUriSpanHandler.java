package com.tencent.mm.app.plugin;

import android.os.Bundle;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;

abstract class URISpanHandlerSet$BaseUriSpanHandler {
    final /* synthetic */ URISpanHandlerSet bAt;

    abstract boolean a(m mVar, g gVar);

    abstract boolean a(String str, boolean z, s sVar, Bundle bundle);

    abstract m db(String str);

    abstract int[] vB();

    public URISpanHandlerSet$BaseUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
        this.bAt = uRISpanHandlerSet;
    }
}
