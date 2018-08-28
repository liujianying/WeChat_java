package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.sdk.platformtools.bi;
import org.json.JSONObject;

public final class g {
    private static g pmP;
    public String lMX;
    public int pmQ = 0;
    JSONObject pmR;

    public static g bOA() {
        if (pmP == null) {
            pmP = new g();
        }
        return pmP;
    }

    public final boolean aKp() {
        if (this.pmQ != 1 || bi.oW(this.lMX)) {
            return false;
        }
        return true;
    }
}
