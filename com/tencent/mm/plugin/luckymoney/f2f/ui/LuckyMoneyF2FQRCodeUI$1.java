package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.util.Pair;
import android.view.View;
import com.tencent.mm.aa.j;
import com.tencent.mm.aa.q;
import com.tencent.mm.ab.d;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.model.s;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView.5;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import java.util.Map;

class LuckyMoneyF2FQRCodeUI$1 implements a {
    final /* synthetic */ LuckyMoneyF2FQRCodeUI kOv;

    LuckyMoneyF2FQRCodeUI$1(LuckyMoneyF2FQRCodeUI luckyMoneyF2FQRCodeUI) {
        this.kOv = luckyMoneyF2FQRCodeUI;
    }

    public final void a(d.a aVar) {
        Map z = bl.z(ab.a(aVar.dIN.rcl), "sysmsg");
        if (z != null) {
            String str = (String) z.get(".sysmsg.sendId");
            final String str2 = (String) z.get(".sysmsg.username");
            final String str3 = (String) z.get(".sysmsg.amount");
            final String str4 = (String) z.get(".sysmsg.receiveId");
            if (bi.getInt((String) z.get(".sysmsg.islucky"), 0) > 0) {
                LuckyMoneyF2FQRCodeUI.a(this.kOv, str2);
            }
            if (!bi.G(new String[]{str, str2, str3})) {
                this.kOv.runOnUiThread(new Runnable() {
                    public final void run() {
                        if (!LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI$1.this.kOv).contains(str4)) {
                            LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI$1.this.kOv).add(0, str4);
                            if (!s.he(str2)) {
                                j jVar = new j();
                                jVar.username = str2;
                                q.KH().a(jVar);
                            }
                            LuckyMoneyF2FQRCodeUI.b(LuckyMoneyF2FQRCodeUI$1.this.kOv).put(str4, str2);
                            ShuffleView c = LuckyMoneyF2FQRCodeUI.c(LuckyMoneyF2FQRCodeUI$1.this.kOv);
                            if (c.kOO.size() > 0) {
                                if (c.kOT.isStarted()) {
                                    c.kOT.end();
                                }
                                if (c.kOS.isStarted()) {
                                    c.kOS.end();
                                }
                                if (c.eRT != null) {
                                    c.kOX = c.eRT;
                                    c.kOO.remove(c.kOX);
                                    if (c.kOQ != null) {
                                        c.kOQ.start();
                                    }
                                    c.sf(c.kOZ);
                                    if (c.kPc > 0) {
                                        c.kOZ = c.baP();
                                        c.eRT = (View) c.kOO.get(c.kOZ);
                                    } else {
                                        c.eRT = null;
                                        c.kOZ = 0;
                                    }
                                } else {
                                    c.sd(c.baP());
                                    c.kOX = c.eRT;
                                    c.kOT.addListener(new 5(c));
                                }
                            }
                            LuckyMoneyF2FQRCodeUI.d(LuckyMoneyF2FQRCodeUI$1.this.kOv).remove(LuckyMoneyF2FQRCodeUI.c(LuckyMoneyF2FQRCodeUI$1.this.kOv).getExitView());
                            LuckyMoneyF2FQRCodeUI.e(LuckyMoneyF2FQRCodeUI$1.this.kOv).J(0, 60000);
                            LuckyMoneyF2FQRCodeUI.f(LuckyMoneyF2FQRCodeUI$1.this.kOv).add(new Pair(str2, Integer.valueOf(bi.getInt(str3, 0))));
                        }
                    }
                });
            }
        }
    }
}
