package com.tencent.mm.plugin.card.ui;

import android.os.Message;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.ui.e.b;
import com.tencent.mm.plugin.card.ui.e.c;
import com.tencent.mm.sdk.platformtools.ag;

class e$3 extends ag {
    final /* synthetic */ e hCy;

    e$3(e eVar) {
        this.hCy = eVar;
    }

    public final void handleMessage(Message message) {
        if (message.obj != null && (message.obj instanceof c)) {
            c cVar = (c) message.obj;
            if (cVar.hCH == b.hCF) {
                if (this.hCy.hCa != null) {
                    d.a(this.hCy.hBT, cVar.Yy, false);
                    this.hCy.hCa.azL();
                }
            } else if (cVar.hCH == b.hCD) {
                if (this.hCy.hCa != null) {
                    this.hCy.hCa.d(com.tencent.mm.plugin.card.d.c.hIx);
                }
            } else if (this.hCy.hCa != null) {
                this.hCy.hCa.d(cVar.hCI);
            }
        }
    }
}
