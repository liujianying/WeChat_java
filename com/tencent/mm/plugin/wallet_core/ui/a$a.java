package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.mm.plugin.wallet.a.h;

public final class a$a {
    public String lNT;
    public String psA;
    public h psy;
    public double psz;

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        if (this.psy != null) {
            stringBuffer.append("|faovrComposeId: " + this.psy.pem);
        }
        stringBuffer.append("|bankName: " + this.lNT);
        stringBuffer.append("|bankFavorAmount: " + this.psz);
        stringBuffer.append("|bankType: " + this.psA);
        return stringBuffer.toString();
    }
}
