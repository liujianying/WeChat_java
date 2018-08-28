package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.database.Cursor;
import com.tencent.mm.plugin.j.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class CleanChattingUI$6 implements Runnable {
    final /* synthetic */ CleanChattingUI hSr;

    CleanChattingUI$6(CleanChattingUI cleanChattingUI) {
        this.hSr = cleanChattingUI;
    }

    public final void run() {
        if (!CleanChattingUI.c(this.hSr)) {
            x.i("MicroMsg.CleanChattingUI", "load contact cursor now");
            CleanChattingUI.d(this.hSr);
            ah.A(new 1(this));
            Cursor avC = b.avr().avs().avC();
            if (avC != null) {
                while (avC.moveToNext()) {
                    c cVar = new c();
                    cVar.username = avC.getString(0);
                    cVar.size = avC.getLong(1);
                    CleanChattingUI.f(this.hSr).add(cVar);
                }
            }
            ah.A(new 2(this));
        }
    }
}
