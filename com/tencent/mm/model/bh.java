package com.tencent.mm.model;

import com.tencent.mm.network.k;

public final class bh {
    public static a dCN = null;

    public interface a {
        k It();
    }

    public static k a(k kVar) {
        return dCN == null ? kVar : dCN.It();
    }
}
