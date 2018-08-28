package com.tencent.mm.plugin.wallet_core.c.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.DiscountInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.protocal.c.azi;
import com.tencent.mm.protocal.c.azm;
import com.tencent.mm.protocal.c.azt;
import com.tencent.mm.protocal.c.azu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.m;
import java.util.ArrayList;
import java.util.Iterator;

public final class c extends m {
    private b diG;
    private e diJ;
    public Orders pjG;
    public int pjR = 0;

    public c(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        a aVar = new a();
        aVar.dIG = new azt();
        aVar.dIH = new azu();
        aVar.uri = "/cgi-bin/mmpay-bin/payibgjsgettransaction";
        aVar.dIF = 1565;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        azt azt = (azt) this.diG.dID.dIL;
        azt.jQb = str;
        azt.rsx = str4;
        azt.rsw = str2;
        azt.rsy = str5;
        azt.rsz = str6;
        azt.rhq = str3;
        azt.rrC = str7;
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneIbgGetTransaction", "hy: get h5 transaction: errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        azu azu = (azu) ((b) qVar).dIE.dIL;
        if (i2 == 0 && i == 0) {
            i2 = azu.iwS;
            str = azu.iwT;
        }
        x.i("MicroMsg.NetSceneIbgGetTransaction", "resp.IsUseNewPage: %s", new Object[]{Integer.valueOf(azu.scv)});
        this.pjR = azu.scv;
        this.pjG = new Orders();
        this.pjG.pjA = 1;
        if (azu == null || azu.scs == null) {
            x.e("MicroMsg.NetSceneIbgGetTransaction", "hy: info not valid");
        } else {
            Iterator it;
            this.pjG.mBj = (double) azu.scs.scy;
            Commodity commodity = new Commodity();
            commodity.bOe = azu.scs.myq;
            commodity.desc = azu.scs.dWh;
            commodity.hUL = ((double) azu.scs.scy) / 100.0d;
            commodity.lNO = String.valueOf(azu.scs.scA);
            commodity.lNP = azu.scs.scB;
            commodity.lNT = azu.scs.scx;
            commodity.lNR = azu.scs.scw;
            commodity.lNV = azu.scs.lNV;
            commodity.lNK = azu.scs.scz;
            commodity.ppw = ((double) azu.scs.scC) / 100.0d;
            if (azu.sct != null) {
                commodity.lNW = azu.sct.rnD;
                Promotions promotions = new Promotions();
                promotions.name = azu.sct.scd;
                promotions.lNW = azu.sct.rnD;
                commodity.ppx = azu.sct.rnD;
                promotions.lRX = azu.sct.huW;
                commodity.poW = azu.sct.scb;
                promotions.type = Orders.ppu;
                if (!bi.oW(promotions.name)) {
                    commodity.ppF.add(promotions);
                    commodity.ppG = true;
                }
                this.pjG.poW = azu.sct.scb;
            } else {
                x.i("MicroMsg.NetSceneIbgGetTransaction", "hy: no biz info");
                this.pjG.poW = 0;
            }
            if (azu.scs.scD != null && azu.scs.scD.size() > 0) {
                commodity.ppz = new ArrayList();
                it = azu.scs.scD.iterator();
                while (it.hasNext()) {
                    azm azm = (azm) it.next();
                    DiscountInfo discountInfo = new DiscountInfo();
                    discountInfo.mwP = azm.sce;
                    commodity.ppz.add(discountInfo);
                }
            }
            if (azu.scu != null && azu.scu.size() > 0) {
                commodity.ppF = new ArrayList();
                it = azu.scu.iterator();
                while (it.hasNext()) {
                    azi azi = (azi) it.next();
                    Promotions promotions2 = new Promotions();
                    promotions2.type = Orders.ppv;
                    promotions2.url = azi.url;
                    promotions2.name = azi.bSc;
                    promotions2.lRX = azi.bWP;
                    promotions2.poG = azi.pwk;
                    promotions2.ppS = bi.getInt(azi.type, 0);
                    promotions2.title = azi.title;
                    promotions2.pji = azi.pqc;
                    promotions2.ppT = (int) azi.pqd;
                    promotions2.ppV = azi.poH;
                    promotions2.ppU = (int) azi.pqe;
                    promotions2.poD = azi.pqf;
                    promotions2.poE = azi.pqg;
                    promotions2.ppW = azi.sbY;
                    promotions2.ppX = azi.sbZ;
                    promotions2.poF = azi.pqh;
                    promotions2.ppY = azi.sca;
                    commodity.ppF.add(promotions2);
                }
            }
            this.pjG.ppf = new ArrayList();
            this.pjG.ppf.add(commodity);
            this.pjG.poY = azu.scs.scB;
            x.i("MicroMsg.NetSceneIbgGetTransaction", "formatOrders finish, mOrder.commoditys.size: %s, mOrder: %s", new Object[]{Integer.valueOf(this.pjG.ppf.size()), this.pjG});
        }
        if (bi.oW(str)) {
            str = ad.getContext().getString(a$i.wallet_data_err);
        }
        this.diJ.a(i, i2, str, this);
    }

    public final int getType() {
        return 1565;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
