package com.tencent.mm.plugin.appbrand.game.d.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.appbrand.game.widget.input.WAGamePanelInputEditText;
import com.tencent.mm.plugin.appbrand.game.widget.input.a;
import com.tencent.mm.plugin.appbrand.l;

class e$5 implements OnClickListener {
    final /* synthetic */ l fCl;
    final /* synthetic */ boolean fCv;
    final /* synthetic */ e fCx;
    final /* synthetic */ WAGamePanelInputEditText fCy;
    final /* synthetic */ a fCz;

    e$5(e eVar, WAGamePanelInputEditText wAGamePanelInputEditText, l lVar, boolean z, a aVar) {
        this.fCx = eVar;
        this.fCy = wAGamePanelInputEditText;
        this.fCl = lVar;
        this.fCv = z;
        this.fCz = aVar;
    }

    public final void onClick(View view) {
        this.fCx.fCr.a(this.fCy.getEditableText().toString(), this.fCl);
        this.fCx.fCp.a(this.fCy.getEditableText().toString(), this.fCl);
        if (!this.fCv) {
            this.fCz.hide();
        }
    }
}
