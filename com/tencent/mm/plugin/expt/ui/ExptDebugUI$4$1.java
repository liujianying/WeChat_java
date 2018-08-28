package com.tencent.mm.plugin.expt.ui;

import com.tencent.mm.plugin.expt.ui.ExptDebugUI.4;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.widget.picker.b;
import com.tencent.mm.ui.widget.picker.b.a;

class ExptDebugUI$4$1 implements a {
    final /* synthetic */ b gQT;
    final /* synthetic */ String[] iIV;
    final /* synthetic */ 4 iIW;

    ExptDebugUI$4$1(4 4, b bVar, String[] strArr) {
        this.iIW = 4;
        this.gQT = bVar;
        this.iIV = strArr;
    }

    public final void h(boolean z, Object obj) {
        this.gQT.hide();
        ExptDebugUI.a(this.iIW.iIU, bi.getInt(this.iIV[this.gQT.cAP()], 0));
    }
}
