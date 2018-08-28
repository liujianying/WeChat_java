package com.tencent.mm.plugin.wallet.a;

import com.tencent.mm.g.a.hf;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;

public final class i extends c<hf> {
    public i() {
        this.sFo = hf.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        int i = 0;
        hf hfVar = (hf) bVar;
        if (!(hfVar instanceof hf)) {
            return false;
        }
        hfVar.bQu.bQw = o.bOW().bPv();
        String aCl = o.bOW().aCl();
        if (bi.oW(aCl)) {
            hfVar.bQu.bQv = "";
        } else {
            String str = "";
            while (i < aCl.length() - 1) {
                str = str + "*";
                i++;
            }
            hfVar.bQu.bQv = str + aCl.substring(aCl.length() - 1, aCl.length());
        }
        return true;
    }
}
