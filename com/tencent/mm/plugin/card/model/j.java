package com.tencent.mm.plugin.card.model;

import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;

public final class j extends i<i> {
    public static final String[] diD = new String[]{i.a(i.dhO, "CardQrCodeConfi")};
    private e diF;

    public j(e eVar) {
        super(eVar, i.dhO, "CardQrCodeConfi", null);
        this.diF = eVar;
    }

    public final i xn(String str) {
        i iVar = new i();
        iVar.field_card_id = str;
        return b(iVar, new String[0]) ? iVar : null;
    }
}
