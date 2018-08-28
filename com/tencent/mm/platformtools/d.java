package com.tencent.mm.platformtools;

import android.app.Activity;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;

public final class d {
    private o evD;
    private p evE;
    private q evF;
    private m evG;
    private n evH;
    private l evI;

    public final boolean a(Activity activity, ah ahVar) {
        if (ahVar.type == 0 || ahVar.action == 0) {
            return false;
        }
        if (this.evI == null) {
            this.evI = new l(activity);
        }
        if (this.evI.a(ahVar)) {
            return true;
        }
        switch (ahVar.type) {
            case 1:
                if (this.evD == null) {
                    this.evD = new o(activity);
                }
                this.evD.a(ahVar);
                return false;
            case 2:
                if (this.evE == null) {
                    this.evE = new p(activity);
                }
                this.evE.a(ahVar);
                return false;
            case 3:
                if (this.evF == null) {
                    this.evF = new q(activity);
                }
                this.evF.a(ahVar);
                return false;
            case 4:
                if (this.evG == null) {
                    this.evG = new m(activity);
                }
                this.evG.a(ahVar);
                return false;
            case 5:
                if (this.evH == null) {
                    this.evH = new n(activity);
                }
                this.evH.a(ahVar);
                return false;
            case 6:
                if (this.evI == null) {
                    this.evI = new l(activity);
                }
                this.evI.a(ahVar);
                return false;
            default:
                x.e("MicroMsg.BaseErrorHelper", "Unkown error type");
                return false;
        }
    }

    private static void a(e eVar) {
        if (eVar != null) {
            for (Integer intValue : eVar.evJ) {
                g.DF().b(intValue.intValue(), eVar);
            }
            eVar.activity = null;
        }
    }

    public final void close() {
        a(this.evD);
        a(this.evE);
        a(this.evF);
        a(this.evG);
        a(this.evH);
        a(this.evI);
    }
}
