package com.tencent.mm.pluginsdk.ui.chat;

import com.tencent.mm.g.a.so;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class n$8 extends c<so> {
    final /* synthetic */ n qNT;

    n$8(n nVar) {
        this.qNT = nVar;
        this.sFo = so.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        so soVar = (so) bVar;
        if (!(soVar instanceof so)) {
            x.d("MicroMsg.VoiceInputPanel", "VoiceInputResultEvent mismatched event");
            return false;
        } else if (soVar == null || soVar.cdq == null) {
            x.e("MicroMsg.VoiceInputPanel", "VoiceInputResultEvent event data is null");
            return false;
        } else if (n.d(this.qNT)) {
            x.i("MicroMsg.VoiceInputPanel", "VoiceInputResultEvent fromFullScreen true");
            return false;
        } else if (soVar.cdq.cds.equalsIgnoreCase(n.e(this.qNT))) {
            x.i("MicroMsg.VoiceInputPanel", "VoiceInputResultEvent action = %s, textChange: %b", new Object[]{Integer.valueOf(soVar.cdq.action), Integer.valueOf(soVar.cdq.cdr)});
            if (soVar.cdq.action == 2) {
                if (soVar.cdq.cdr == 1) {
                    n.a(this.qNT, true);
                } else {
                    n.a(this.qNT, false);
                }
                n.g(this.qNT).a(n.f(this.qNT), soVar.cdq.result, false);
                n.g(this.qNT).a(n.f(this.qNT));
                n.g(this.qNT).b(n.f(this.qNT));
                n.h(this.qNT);
                n.i(this.qNT).fullScroll(130);
            } else if (soVar.cdq.action == 3) {
                if (n.j(this.qNT) != null) {
                    n.j(this.qNT).bXG();
                }
            } else if (soVar.cdq.action == 1 || soVar.cdq.action == 4) {
                if (soVar.cdq.cdr == 1) {
                    n.a(this.qNT, true);
                } else {
                    n.a(this.qNT, false);
                }
                n.g(this.qNT).a(n.f(this.qNT), soVar.cdq.result, false);
                n.g(this.qNT).a(n.f(this.qNT));
                n.g(this.qNT).b(n.f(this.qNT));
                n.h(this.qNT);
                n.i(this.qNT).fullScroll(130);
                n.a(this.qNT, soVar.cdq.action);
            } else {
                this.qNT.reset();
            }
            return true;
        } else {
            x.e("MicroMsg.VoiceInputPanel", "VoiceInputResultEvent userCode not equals!");
            this.qNT.destroy();
            return false;
        }
    }
}
