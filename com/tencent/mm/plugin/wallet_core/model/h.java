package com.tencent.mm.plugin.wallet_core.model;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.wallet_core.c.b;

public final class h {
    public int pmS = 0;
    public String pmT = "";
    public int pmU = 0;
    public String pmV = "";
    public int pmW = 0;
    public b pmX = new b();

    public h(Bundle bundle) {
        this.pmS = bundle.getInt("key_is_gen_cert", 0);
        this.pmU = bundle.getInt("key_is_hint_crt", 0);
        this.pmW = bundle.getInt("key_is_ignore_cert", 0);
        this.pmT = bundle.getString("key_crt_token", "");
        this.pmV = bundle.getString("key_crt_wording", "");
        this.pmX = new b(this.pmV);
    }

    public final boolean bOB() {
        if (this.pmU == 0 || bi.oW(this.pmV)) {
            return false;
        }
        return true;
    }

    public final boolean bOC() {
        if (this.pmS == 1) {
            return true;
        }
        return false;
    }

    public final boolean bOD() {
        if (bOC() && this.pmW == 0) {
            return true;
        }
        return false;
    }
}
