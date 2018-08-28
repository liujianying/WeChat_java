package com.tencent.mm.plugin.offline;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.g.a.to;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

class m$1 extends c<to> {
    final /* synthetic */ m lJD;

    m$1(m mVar) {
        this.lJD = mVar;
        this.sFo = to.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        to toVar = (to) bVar;
        if (toVar instanceof to) {
            switch (toVar.cfd.action) {
                case 3:
                    if (!((com.tencent.mm.plugin.walletlock.a.b) g.l(com.tencent.mm.plugin.walletlock.a.b.class)).bRp()) {
                        if (!o.bOW().bPr()) {
                            if (!o.bOW().bPp()) {
                                if (!o.bOW().bPs() || !a.bly()) {
                                    if (!o.bOW().bPs() || a.bly()) {
                                        if (o.bOW().bPt()) {
                                            toVar.cfe.cff = 3;
                                            break;
                                        }
                                    }
                                    toVar.cfe.cff = 4;
                                    break;
                                }
                                k.bkO();
                                e bkQ = k.bkQ();
                                x.i("MicroMsg.OfflineCodesMgr", "generatetKey scene %s isSnapshot %s stack: %s", new Object[]{Integer.valueOf(9), Integer.valueOf(0), bi.cjd().toString()});
                                String k = bkQ.k(9, 0, "");
                                Bitmap b = com.tencent.mm.bm.a.a.b(ad.getContext(), k, 5, 0);
                                Bitmap b2 = com.tencent.mm.bm.a.a.b(ad.getContext(), k, 0, 3);
                                toVar.cfe.cff = 1;
                                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                b.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                                toVar.cfe.cfk = byteArrayOutputStream.toByteArray();
                                byteArrayOutputStream.reset();
                                b2.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                                toVar.cfe.cfl = byteArrayOutputStream.toByteArray();
                                toVar.cfe.cfm = e.acd(k);
                                String blI = a.blI();
                                Bankcard bankcard = null;
                                for (Bankcard bankcard2 : a.gY(true)) {
                                    Bankcard bankcard22;
                                    if (bankcard22.field_bindSerial == null || !bankcard22.field_bindSerial.equals(blI)) {
                                        bankcard22 = bankcard;
                                    }
                                    bankcard = bankcard22;
                                }
                                if (bankcard == null) {
                                    x.i("MicroMsg.Wear.WearOfflineLogic", "get payway fail");
                                    break;
                                }
                                toVar.cfe.cfn = ad.getContext().getString(a$i.wallet_wx_offline_change_bankcard_tips_without_comma, new Object[]{bankcard.field_desc});
                                x.i("MicroMsg.Wear.WearOfflineLogic", "payway %s", new Object[]{toVar.cfe.cfn});
                                break;
                            }
                            toVar.cfe.cff = 3;
                            break;
                        }
                        toVar.cfe.cff = 2;
                        break;
                    }
                    toVar.cfe.cff = 5;
                    break;
                    break;
            }
        }
        return false;
    }
}
