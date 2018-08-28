package com.tencent.mm.app.plugin;

import com.tencent.mm.R;
import com.tencent.mm.ab.l;
import com.tencent.mm.app.plugin.URISpanHandlerSet.DeeplinkUriSpanHandler;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.pluginsdk.d.a;
import com.tencent.mm.protocal.c.bua;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.s;

class URISpanHandlerSet$DeeplinkUriSpanHandler$4 implements a {
    final /* synthetic */ DeeplinkUriSpanHandler bAB;
    final /* synthetic */ p bAD;

    URISpanHandlerSet$DeeplinkUriSpanHandler$4(DeeplinkUriSpanHandler deeplinkUriSpanHandler, p pVar) {
        this.bAB = deeplinkUriSpanHandler;
        this.bAD = pVar;
    }

    public final void a(int i, int i2, String str, l lVar, boolean z) {
        if (this.bAD != null && this.bAD.isShowing()) {
            this.bAD.dismiss();
        }
        if (lVar != null && i != 0 && i2 != 0 && (lVar instanceof aa)) {
            bua Rw = ((aa) lVar).Rw();
            if (Rw != null && URISpanHandlerSet.a(this.bAB.bAt) != null) {
                s.makeText(URISpanHandlerSet.a(this.bAB.bAt), URISpanHandlerSet.a(this.bAB.bAt).getString(R.l.app_tip) + " : " + bi.oV(Rw.srt), 0).show();
            }
        }
    }
}
