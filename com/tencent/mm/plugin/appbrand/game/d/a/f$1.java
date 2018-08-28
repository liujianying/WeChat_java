package com.tencent.mm.plugin.appbrand.game.d.a;

import com.tencent.mm.plugin.appbrand.game.widget.input.WAGamePanelInputEditText;
import com.tencent.mm.plugin.appbrand.game.widget.input.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class f$1 implements Runnable {
    final /* synthetic */ int doP;
    final /* synthetic */ String etb;
    final /* synthetic */ f fCB;
    final /* synthetic */ l fCl;

    f$1(f fVar, l lVar, String str, int i) {
        this.fCB = fVar;
        this.fCl = lVar;
        this.etb = str;
        this.doP = i;
    }

    public final void run() {
        if (this.fCl.Sx) {
            p d = f.d(this.fCl);
            if (d != null) {
                a bH = a.bH(d.getContentView());
                if (bH != null) {
                    WAGamePanelInputEditText attachedEditText = bH.getAttachedEditText();
                    int maxLength = attachedEditText.getMaxLength();
                    x.v("MicroMsg.WAGameJsApiUpdateKeyboard", "maxLength(%d).", new Object[]{Integer.valueOf(maxLength)});
                    if (bi.oW(this.etb)) {
                        attachedEditText.setText("");
                    } else {
                        if (maxLength > 0) {
                            attachedEditText.setText(this.etb.length() > maxLength ? this.etb.substring(0, maxLength) : this.etb);
                        } else {
                            attachedEditText.setText(this.etb);
                        }
                        attachedEditText.setSelection(attachedEditText.getText().length());
                    }
                    this.fCl.E(this.doP, this.fCB.f("ok", null));
                    return;
                }
                this.fCl.E(this.doP, this.fCB.f("fail", null));
            }
        }
    }
}
