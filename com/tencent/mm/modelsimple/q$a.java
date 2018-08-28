package com.tencent.mm.modelsimple;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.bi;

public class q$a {
    public String bLe;
    public String bSc;
    public String efV;
    public Bundle efW;
    public int type;
    public String username;

    public final String toString() {
        return String.format("AuthBioInfo hash[%d], type[%d]. username[%s], ticket[%s], helpUrlp[%s], wording[%s], extra[%s]", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(this.type), this.username, bi.Xf(this.bLe), this.efV, this.bSc, this.efW});
    }
}
