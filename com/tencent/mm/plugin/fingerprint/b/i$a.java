package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.a;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.pluginsdk.wallet.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public class i$a implements c {
    final /* synthetic */ i jgO;

    public i$a(i iVar) {
        this.jgO = iVar;
    }

    public final void aK(int i, int i2) {
        if (this.jgO.jgq) {
            x.e("MicroMsg.OpenFingerPrintAuthEventListener", "hy: event already end. ignore");
            return;
        }
        String string;
        switch (i) {
            case 0:
                x.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: identify FingerPrintConst.RESULT_SUCCESS");
                i iVar = this.jgO;
                x.i("MicroMsg.OpenFingerPrintAuthEventListener", "onSuccess()");
                iVar.jgq = true;
                a.aMW();
                a.aMX();
                ((k) g.l(k.class)).a(iVar.jgL, i2);
                if (iVar.jgq) {
                    iVar.jgL = null;
                }
                x.i("MicroMsg.OpenFingerPrintAuthEventListener", "callback OpenFingerPrintAuthEvent onSuccess()");
                i.aND();
                return;
            case 2000:
                x.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: identify timeout");
                return;
            case 2001:
                this.jgO.fd(false);
                x.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: identify FingerPrintConst.RESULT_TIMEOUT");
                return;
            case 2002:
                x.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: identify FingerPrintConst.RESULT_NO_MATCH");
                this.jgO.jgq = false;
                i.aND();
                this.jgO.fd(true);
                this.jgO.U(1, "");
                return;
            case 2004:
            case 2005:
            case 2007:
            case 10308:
                x.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: on error: %d", new Object[]{Integer.valueOf(i)});
                this.jgO.jgq = true;
                string = ad.getContext().getString(i.soter_on_error_common);
                if (i == 10308) {
                    string = ad.getContext().getString(i.soter_on_error_max_trial);
                } else if (i == 2007) {
                    s.pqR.jgY = true;
                }
                i.aND();
                this.jgO.U(2, string);
                return;
            case 2009:
                x.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: on error: %d", new Object[]{Integer.valueOf(i)});
                if (this.jgO.jgL != null) {
                    com.tencent.mm.plugin.soter.c.a.xQ(this.jgO.jgL.bVz.bVC);
                }
                this.jgO.jgq = true;
                string = ad.getContext().getString(i.soter_on_error_common);
                i.aND();
                this.jgO.U(i, string);
                return;
            default:
                return;
        }
    }
}
