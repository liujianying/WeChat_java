package com.tencent.mm.plugin.voip.model;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;

public final class p {
    public static p oMV;
    v2protocal oMN = new v2protocal(new ag(Looper.getMainLooper()));
    boolean oMO = false;
    public a oMP;
    int oMQ = -1;
    boolean oMR = false;
    int oMS = 0;
    public int oMT;
    public int oMU;
    al oMW = new al(Looper.getMainLooper(), new 1(this), true);

    public static p bKK() {
        if (oMV == null) {
            oMV = new p();
        }
        return oMV;
    }

    private p() {
    }

    public final void bKL() {
        x.d("MicroMsg.VoipNetStatusChecker", "startNetStatusCheck");
        this.oMQ = -1;
        this.oMR = true;
        this.oMU = 0;
        this.oMT = 0;
        ah.i(new 2(this), 3000);
    }

    public final void bKM() {
        x.d("MicroMsg.VoipNetStatusChecker", "stopNetStatusCheck");
        this.oMQ = -1;
        this.oMO = false;
        this.oMR = false;
        this.oMU = 0;
        this.oMT = 0;
        ah.A(new 3(this));
    }
}
