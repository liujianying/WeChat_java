package com.tencent.mm.view.e;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class a$1 extends ag {
    final /* synthetic */ a uWa;

    a$1(a aVar) {
        this.uWa = aVar;
    }

    public final void handleMessage(Message message) {
        boolean z = true;
        switch (message.what) {
            case 1102:
                this.uWa.cCp();
                a.a(this.uWa);
                if (a.b(this.uWa) != null && a.c(this.uWa) != null) {
                    int i = a.d(this.uWa).uWt;
                    if (i < 0 || i > a.d(this.uWa).abS(a.b(this.uWa)).cCn()) {
                        i = a.d(this.uWa).abS(a.b(this.uWa)).cCn() - 1;
                    }
                    a.a(this.uWa, i + a.d(this.uWa).abS(a.b(this.uWa)).gKG);
                    a.c(this.uWa).setCurrentItem(a.e(this.uWa));
                    a.f(this.uWa);
                    return;
                }
                return;
            case 1103:
                x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "update selection");
                a aVar = this.uWa;
                int i2 = message.arg1;
                if (message.arg2 != 1) {
                    z = false;
                }
                a.a(aVar, i2, z, false);
                return;
            default:
                return;
        }
    }
}
