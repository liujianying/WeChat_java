package com.tencent.mm.plugin.game.model;

import com.tencent.mm.bk.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;

public final class ab extends i<aa> {
    public static final String[] diD = new String[]{i.a(aa.dhO, "GamePBCache")};

    public ab(e eVar) {
        super(eVar, aa.dhO, "GamePBCache", null);
    }

    public final byte[] Dw(String str) {
        if (bi.oW(str) || !w.chP().equals(f.aTF())) {
            return null;
        }
        aa aaVar = new aa();
        aaVar.field_key = str;
        if (super.b(aaVar, new String[0])) {
            return aaVar.field_value;
        }
        return null;
    }

    public final boolean a(String str, a aVar) {
        boolean z = false;
        if (bi.oW(str) || aVar == null) {
            return z;
        }
        try {
            return p(str, aVar.toByteArray());
        } catch (IOException e) {
            x.e("MicroMsg.GamePBCacheStorage", "Saving Failed: %s", new Object[]{e.getMessage()});
            return z;
        }
    }

    public final boolean p(String str, byte[] bArr) {
        boolean z = false;
        if (!(bArr == null || bArr.length == 0)) {
            aa aaVar = new aa();
            aaVar.field_key = str;
            if (super.b(aaVar, new String[0])) {
                aaVar.field_value = bArr;
                z = super.c(aaVar, new String[0]);
            } else {
                aaVar.field_value = bArr;
                z = super.b(aaVar);
            }
            if (!z) {
                x.e("MicroMsg.GamePBCacheStorage", "Saving cache failed (update or insert)");
            }
        }
        return z;
    }
}
