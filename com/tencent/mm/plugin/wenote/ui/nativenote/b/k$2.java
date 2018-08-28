package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import com.tencent.mm.plugin.wenote.model.a.h;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ah;

class k$2 implements Runnable {
    final /* synthetic */ k qvL;
    final /* synthetic */ h qvN;

    k$2(k kVar, h hVar) {
        this.qvL = kVar;
        this.qvN = hVar;
    }

    public final void run() {
        k.a(this.qvL).setRichTextEditing(this.qvN.content);
        k.a(this.qvL).cab();
        k.a(this.qvL).cad();
        j.g(k.a(this.qvL));
        k.a(this.qvL).cae();
        k.a(this.qvL).cac();
        if (this.qvN.qoH) {
            if (this.qvN.qoJ == -1 || this.qvN.qoJ >= k.a(this.qvL).getText().toString().length()) {
                k.a(this.qvL).setSelection(k.a(this.qvL).getText().toString().length());
            } else {
                k.a(this.qvL).setSelection(this.qvN.qoJ);
            }
            k.a(this.qvL).requestFocus();
            ah.i(new 1(this), 500);
        } else if (k.a(this.qvL).hasFocus()) {
            k.a(this.qvL).clearFocus();
        }
        if (this.qvN.qoP) {
            this.qvN.qoP = false;
            k.a(this.qvL).qoP = true;
            k.a(this.qvL).onTextContextMenuItem(16908322);
        }
    }
}
