package com.tencent.mm.plugin.appbrand.game.d.a;

import com.tencent.mm.plugin.appbrand.game.widget.input.WAGamePanelInputEditText;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.widget.input.n.a;

class e$2 extends a {
    final /* synthetic */ l fCl;
    final /* synthetic */ e fCx;
    final /* synthetic */ WAGamePanelInputEditText fCy;

    e$2(e eVar, WAGamePanelInputEditText wAGamePanelInputEditText, l lVar) {
        this.fCx = eVar;
        this.fCy = wAGamePanelInputEditText;
        this.fCl = lVar;
    }

    public final void YY() {
        this.fCx.fCp.a(this.fCy.getEditableText().toString(), this.fCl);
    }
}
