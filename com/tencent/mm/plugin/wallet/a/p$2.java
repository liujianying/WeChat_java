package com.tencent.mm.plugin.wallet.a;

import com.tencent.mm.ab.d.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.s.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.util.Map;

class p$2 implements n {
    final /* synthetic */ p peH;

    p$2(p pVar) {
        this.peH = pVar;
    }

    public final void onNewXmlReceived(String str, Map<String, String> map, a aVar) {
        if ("paymsg".equals(str) && "30".equals(map.get(".sysmsg.paymsg.PayMsgType"))) {
            Object obj = (String) map.get(".sysmsg.paymsg.NewTagBankSerial");
            String str2 = (String) map.get(".sysmsg.paymsg.WalletRedDotWording");
            x.i("MicroMsg.SubCoreMMWallet", "moreTabWallet: %s, walletBankCard: %s, bankSerial: %s", new Object[]{Integer.valueOf(bi.getInt((String) map.get(".sysmsg.paymsg.WalletRedDot"), 0)), Integer.valueOf(bi.getInt((String) map.get(".sysmsg.paymsg.BankCardRedDot"), 0)), obj});
            if (bi.getInt((String) map.get(".sysmsg.paymsg.WalletRedDot"), 0) == 1) {
                c.Cp().b(aa.a.sYc, true);
            } else {
                c.Cp().b(aa.a.sYc, false);
            }
            if (r3 == 1) {
                c.Cp().b(aa.a.sYd, true);
            } else {
                c.Cp().b(aa.a.sYd, false);
            }
            if (!bi.oW(str2)) {
                g.Ek();
                g.Ei().DT().a(aa.a.sYf, str2);
            }
            if (!bi.oW(obj)) {
                g.Ek();
                str2 = (String) g.Ei().DT().get(aa.a.sYg, "");
                if (!bi.oW(str2)) {
                    obj = str2 + "," + obj;
                }
                g.Ek();
                g.Ei().DT().a(aa.a.sYg, obj);
            }
        }
    }
}
