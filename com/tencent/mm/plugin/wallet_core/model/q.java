package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class q {
    public List<ElementQuery> pjy = null;
    public SparseArray<String> pqQ = null;

    public final String Q(Context context, int i) {
        if (this.pqQ != null) {
            String str = (String) this.pqQ.get(i);
            if (!bi.oW(str)) {
                return str;
            }
        }
        return context.getString(i.wallet_card_cre_type_default);
    }

    public final ElementQuery OW(String str) {
        if (this.pjy == null || this.pjy.size() == 0) {
            x.w("MicroMsg.WalletBankElementManager", "hy: no element from given banktype");
            return null;
        }
        for (ElementQuery elementQuery : this.pjy) {
            if (elementQuery.lMV != null && elementQuery.lMV.equals(str)) {
                return elementQuery;
            }
        }
        x.w("MicroMsg.WalletBankElementManager", "hy: not found given banktype: %s", new Object[]{str});
        return null;
    }

    public final ElementQuery OX(String str) {
        if (bi.oW(str)) {
            x.w("MicroMsg.WalletBankElementManager", "hy: bindSerail given is null");
            return null;
        } else if (this.pjy == null || this.pjy.size() == 0) {
            x.w("MicroMsg.WalletBankElementManager", "hy: element list is null. get element failed");
            return null;
        } else {
            for (ElementQuery elementQuery : this.pjy) {
                if (str.equals(elementQuery.lMW)) {
                    return elementQuery;
                }
            }
            x.w("MicroMsg.WalletBankElementManager", "hy: not found given element query");
            return null;
        }
    }
}
