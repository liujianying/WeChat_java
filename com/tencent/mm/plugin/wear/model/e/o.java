package com.tencent.mm.plugin.wear.model.e;

import com.tencent.mm.g.a.tr;
import com.tencent.mm.sdk.b.a;
import java.util.ArrayList;
import java.util.List;

public final class o extends a {
    public final List<Integer> bSy() {
        List<Integer> arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(11028));
        arrayList.add(Integer.valueOf(11027));
        return arrayList;
    }

    protected final byte[] p(int i, byte[] bArr) {
        switch (i) {
            case 11027:
                yE(1);
                break;
            case 11028:
                yE(2);
                break;
        }
        return null;
    }

    private static void yE(int i) {
        tr trVar = new tr();
        trVar.cfr.bIH = i;
        a.sFg.m(trVar);
    }
}
