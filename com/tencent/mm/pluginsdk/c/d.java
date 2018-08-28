package com.tencent.mm.pluginsdk.c;

import com.tencent.mm.g.a.je;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;

public abstract class d implements a {
    public int qyw = 0;

    public abstract b CY(String str);

    public abstract j aSe();

    public final void adc() {
        if (this.qyw == 0) {
            j aSe = aSe();
            if (aSe != null) {
                aSe.c(this);
            }
        }
        this.qyw++;
    }

    public final void unregister() {
        if (this.qyw != 0) {
            this.qyw--;
            if (this.qyw == 0) {
                j aSe = aSe();
                if (aSe != null) {
                    aSe.d(this);
                }
            }
        }
    }

    public final void a(String str, l lVar) {
        je jeVar = new je();
        jeVar.bSL.bSM = CY(str);
        com.tencent.mm.sdk.b.a.sFg.m(jeVar);
    }
}
