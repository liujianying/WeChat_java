package com.tencent.mm.plugin.wallet_core.d;

import android.database.Cursor;
import com.tencent.mm.plugin.wallet_core.model.ac;
import com.tencent.mm.protocal.c.azs;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.x;

public final class i extends com.tencent.mm.sdk.e.i<ac> {
    public static final String[] diD = new String[]{com.tencent.mm.sdk.e.i.a(ac.dhO, "WalletRegionGreyAreaList")};
    private e diF;

    public i(e eVar) {
        super(eVar, ac.dhO, "WalletRegionGreyAreaList", null);
        this.diF = eVar;
    }

    public final void a(int i, azs azs) {
        ac acVar = new ac();
        acVar.field_wallet_region = i;
        try {
            acVar.field_wallet_grey_item_buf = azs.toByteArray();
        } catch (Exception e) {
            x.e("MicroMsg.WalletRegionGreyItemStg", "setWalletRegionGreyItem error " + e.getMessage());
        }
        super.a(acVar);
    }

    public final ac zo(int i) {
        String str = "select * from WalletRegionGreyAreaList where wallet_region = " + i;
        Cursor b = this.diF.b(str, null, 2);
        x.i("MicroMsg.WalletRegionGreyItemStg", "getWalletRegionGreyItem " + str);
        if (b == null) {
            return new ac();
        }
        ac acVar = new ac();
        if (b.moveToNext()) {
            acVar = new ac();
            acVar.d(b);
        }
        x.i("MicroMsg.WalletRegionGreyItemStg", "get grey item ");
        b.close();
        return acVar;
    }
}
