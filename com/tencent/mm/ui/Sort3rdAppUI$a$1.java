package com.tencent.mm.ui;

import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

class Sort3rdAppUI$a$1 implements a {
    final /* synthetic */ f tqt;
    final /* synthetic */ Sort3rdAppUI.a tqu;

    Sort3rdAppUI$a$1(Sort3rdAppUI.a aVar, f fVar) {
        this.tqu = aVar;
        this.tqt = fVar;
    }

    public final void cf(boolean z) {
        f fVar;
        if (z) {
            fVar = this.tqt;
            fVar.field_appInfoFlag &= -16385;
        } else {
            fVar = this.tqt;
            fVar.field_appInfoFlag |= 16384;
        }
        ao.bmf().a(this.tqt, new String[0]);
    }
}
