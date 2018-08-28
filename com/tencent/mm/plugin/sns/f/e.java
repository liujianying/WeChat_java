package com.tencent.mm.plugin.sns.f;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;

public final class e {
    public static void MN(String str) {
        x.i("MicroMsg.SnsABTestStrategy", "dump id " + str);
        c fJ = com.tencent.mm.model.c.c.Jx().fJ(str);
        if (!fJ.isValid()) {
            x.i("MicroMsg.SnsABTestStrategy", "abtest is invalid");
        }
        if (fJ.ckq() != null) {
            x.i("MicroMsg.SnsABTestStrategy", "dump feed abtest " + fJ.field_rawXML);
        }
    }
}
