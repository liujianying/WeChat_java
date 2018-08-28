package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.mm.plugin.wallet_core.ui.view.BankCardSelectSortView.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.sortview.d;
import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

class WalletBankCardSelectUI$a implements Comparator<d> {
    private Collator psN;

    private WalletBankCardSelectUI$a() {
        this.psN = Collator.getInstance(Locale.getDefault());
    }

    /* synthetic */ WalletBankCardSelectUI$a(byte b) {
        this();
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        d dVar = (d) obj;
        d dVar2 = (d) obj2;
        if (!(dVar == null && dVar2 == null)) {
            if (dVar == null) {
                return -1;
            }
            if (dVar2 == null) {
                return 1;
            }
            String ag;
            a aVar = (a) dVar.data;
            a aVar2 = (a) dVar2.data;
            if (bi.oW(aVar.mcD)) {
                x.e("WalletBankCardSelectUI", "should not go here");
                ag = WalletBankCardSelectUI.ag(aVar.lNT, "#", "_");
            } else {
                ag = aVar.mcD.toUpperCase();
            }
            String toUpperCase = !bi.oW(aVar2.mcD) ? aVar2.mcD.toUpperCase() : WalletBankCardSelectUI.ag(aVar2.lNT, "#", "_");
            if (ag.equals("#")) {
                return 1;
            }
            if (toUpperCase.equals("#")) {
                return -1;
            }
            int min = Math.min(ag.length(), toUpperCase.length());
            int i = 0;
            while (i < min) {
                char charAt = ag.charAt(i);
                char charAt2 = toUpperCase.charAt(i);
                if (charAt == '_' && charAt2 == '_') {
                    return this.psN.compare(aVar.lNT, aVar2.lNT);
                }
                if (charAt == charAt2) {
                    i++;
                } else if (charAt == '_') {
                    return -1;
                } else {
                    if (charAt2 == '_') {
                        return 1;
                    }
                    return charAt < charAt2 ? -1 : 1;
                }
            }
            if (ag.length() > min) {
                return 1;
            }
            if (toUpperCase.length() > min) {
                return -1;
            }
        }
        return 0;
    }
}
