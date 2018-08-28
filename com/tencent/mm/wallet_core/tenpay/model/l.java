package com.tencent.mm.wallet_core.tenpay.model;

import com.tencent.mm.wallet_core.c.c;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave.RetryPayInfo;
import org.json.JSONObject;

public abstract class l extends i implements a {
    private String Yy = "";
    private int errCode = 0;
    public boolean mxp = false;
    private RetryPayInfo oYE;
    public boolean pgm = false;
    private boolean uYl = false;
    public boolean uYm = false;
    public boolean uYn;

    public final void J(boolean z, boolean z2) {
        super.J(z, z2);
    }

    public void a(int i, String str, JSONObject jSONObject) {
        this.errCode = i;
        this.Yy = str;
    }

    public boolean cDq() {
        return false;
    }

    public final boolean brf() {
        return !this.mxp;
    }

    public void a(c cVar, JSONObject jSONObject) {
        boolean z = true;
        super.a(cVar, jSONObject);
        if (jSONObject == null || jSONObject.optInt("can_pay_retry") != 1) {
            z = false;
        }
        this.uYn = z;
        this.oYE = new RetryPayInfo();
        this.oYE.ag(jSONObject);
    }

    public final void cDC() {
        reset();
        this.uYm = true;
        this.uXZ = false;
    }
}
