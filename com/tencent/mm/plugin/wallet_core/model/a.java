package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.sdk.platformtools.bi;

public final class a {
    public String bSc;
    public String hUt;
    public String kRu;
    public String kRv;

    public final boolean bOq() {
        return (bi.oW(this.bSc) || bi.oW(this.kRu) || bi.oW(this.kRv) || bi.oW(this.hUt)) ? false : true;
    }
}
