package com.tencent.mm.plugin.appbrand.game.d.a;

import com.tencent.mm.plugin.appbrand.game.widget.input.WAGamePanelInputEditText;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.widget.input.a.b;

class e$4 implements b {
    final /* synthetic */ l fCl;
    final /* synthetic */ e fCx;
    final /* synthetic */ WAGamePanelInputEditText fCy;

    e$4(e eVar, WAGamePanelInputEditText wAGamePanelInputEditText, l lVar) {
        this.fCx = eVar;
        this.fCy = wAGamePanelInputEditText;
        this.fCl = lVar;
    }

    public final void agA() {
        this.fCx.fCp.a(this.fCy.getEditableText().toString(), this.fCl);
    }
}
