package com.tencent.mm.plugin.wallet_payu.order.ui;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.order.model.g;
import com.tencent.mm.plugin.order.model.i;
import com.tencent.mm.plugin.order.ui.MallOrderRecordListUI;
import com.tencent.mm.plugin.wallet_payu.order.a.a;
import com.tencent.mm.plugin.wallet_payu.order.a.b;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.protocal.c.bad;
import com.tencent.mm.protocal.c.ban;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class PayUMallOrderRecordListUI extends MallOrderRecordListUI {
    protected final void bmA() {
        jr(1519);
        jr(1544);
    }

    protected final void bmB() {
        js(1519);
        js(1544);
    }

    protected final void ed(String str, String str2) {
        a(new b(str), true, true);
    }

    protected final void bmC() {
        a(new a(this.tH), true, true);
    }

    protected final String uu(int i) {
        return e.a(i, new SimpleDateFormat("dd MMMM", Locale.ENGLISH), new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH));
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        Iterator it;
        if (lVar instanceof a) {
            if (this.jhd != null) {
                this.jhd.dismiss();
                this.jhd = null;
            }
            a aVar = (a) lVar;
            LinkedList linkedList = ((bad) aVar.diG.dIE.dIL).scP;
            List linkedList2 = new LinkedList();
            it = linkedList.iterator();
            while (it.hasNext()) {
                ban ban = (ban) it.next();
                i iVar = new i();
                iVar.jSv = ban.jSv;
                iVar.lOO = ban.lOO;
                iVar.lOP = ban.lOP;
                iVar.lOH = ban.lOH;
                iVar.lOK = ban.lOK;
                iVar.lOG = ban.lOG;
                iVar.lON = "0";
                iVar.lOJ = ban.lOJ;
                iVar.lOM = ban.lOM;
                iVar.lOS = 1;
                iVar.lOR = ban.lOR;
                iVar.lOQ = ban.lOQ;
                iVar.lOL = ban.lOL;
                iVar.lOF = (double) ban.scI;
                iVar.lOI = ban.lOI;
                iVar.lOE = ban.lOE;
                linkedList2.add(iVar);
            }
            bE(linkedList2);
            bF(null);
            this.mCount = this.lPM.size();
            this.kUl = aVar.bRl() > this.mCount;
            this.lPL.notifyDataSetChanged();
            x.d("MicroMsg.PayUMallOrderRecordListUI", "orders list count: " + this.mCount);
            x.d("MicroMsg.PayUMallOrderRecordListUI", "orders list total record: " + aVar.bRl());
            x.d("MicroMsg.PayUMallOrderRecordListUI", "orders list has more: " + this.kUl);
            this.mHandler.post(new 1(this));
            this.acT = false;
        } else if (lVar instanceof g) {
            if (this.jhd != null) {
                this.jhd.dismiss();
                this.jhd = null;
            }
            g gVar = (g) lVar;
            if (gVar.bmw() == 2) {
                if (this.lPM != null) {
                    this.lPM.clear();
                }
                this.mCount = 0;
                this.kUl = false;
                this.hPi.crD();
            } else {
                String bmx = gVar.bmx();
                x.d("MicroMsg.PayUMallOrderRecordListUI", "delete transId:" + bmx);
                if (!bi.oW(bmx)) {
                    for (i iVar2 : this.lPM) {
                        if (bmx.equals(iVar2.lOE)) {
                            this.lPM.remove(iVar2);
                            this.mCount = this.lPM.size();
                            break;
                        }
                    }
                }
            }
            this.mHandler.post(new 2(this));
        }
        if (this.mCount > 0 || this.lPM.size() != 0) {
            showOptionMenu(true);
            findViewById(f.empty_tip_layout).setVisibility(8);
        } else {
            showOptionMenu(false);
            findViewById(f.empty_tip_layout).setVisibility(0);
        }
        return true;
    }
}
