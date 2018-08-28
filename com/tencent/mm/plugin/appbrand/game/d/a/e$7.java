package com.tencent.mm.plugin.appbrand.game.d.a;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.plugin.appbrand.game.widget.input.WAGamePanelInputEditText;
import com.tencent.mm.plugin.appbrand.l;

class e$7 implements OnEditorActionListener {
    final /* synthetic */ l fCl;
    final /* synthetic */ boolean fCv;
    final /* synthetic */ e fCx;
    final /* synthetic */ WAGamePanelInputEditText fCy;

    e$7(e eVar, boolean z, WAGamePanelInputEditText wAGamePanelInputEditText, l lVar) {
        this.fCx = eVar;
        this.fCv = z;
        this.fCy = wAGamePanelInputEditText;
        this.fCl = lVar;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (!this.fCv) {
            return false;
        }
        this.fCx.fCr.a(this.fCy.getEditableText().toString(), this.fCl);
        return true;
    }
}
