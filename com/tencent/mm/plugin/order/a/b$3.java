package com.tencent.mm.plugin.order.a;

import android.text.TextUtils;
import com.tencent.mm.ab.d;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.order.model.c;
import com.tencent.mm.plugin.order.model.j;
import com.tencent.mm.protocal.c.azz;
import com.tencent.mm.sdk.platformtools.x;

class b$3 implements a {
    final /* synthetic */ b lNo;

    b$3(b bVar) {
        this.lNo = bVar;
    }

    public final void a(final d.a aVar) {
        final String a = ab.a(aVar.dIN.rcl);
        x.i("MicroMsg.SubCoreWalletOrder", "MallPayMsg:" + a);
        b.a(this.lNo).post(new Runnable() {
            public final void run() {
                c bmq = b.bmq();
                String str = a;
                String str2 = aVar.dIN.rci;
                if (!TextUtils.isEmpty(str)) {
                    j Jq = c.Jq(str);
                    if (Jq == null) {
                        x.i("MicroMsg.MallPayMsgManager", "payMsg == null");
                    } else if (!TextUtils.isEmpty(Jq.lOO) || !TextUtils.isEmpty(Jq.lPf) || !TextUtils.isEmpty(Jq.lPe) || !TextUtils.isEmpty(Jq.bWW) || !TextUtils.isEmpty(Jq.lPa) || !TextUtils.isEmpty(Jq.lPb) || !TextUtils.isEmpty(Jq.lOZ) || !TextUtils.isEmpty(Jq.lPd) || !TextUtils.isEmpty(Jq.lPc) || !TextUtils.isEmpty(Jq.lOY)) {
                        if (Jq.lOY != null && com.tencent.mm.plugin.order.c.c.xW(Jq.lOY)) {
                            int intValue = Integer.valueOf(Jq.lOY).intValue();
                            if (!(intValue == 2 || intValue == 1)) {
                                return;
                            }
                        }
                        if (TextUtils.isEmpty(Jq.lPa)) {
                            Jq.bWQ = str2;
                        } else {
                            Jq.bWQ = str2 + Jq.lPa;
                        }
                        x.i("MicroMsg.MallPayMsgManager", "msgid: " + Jq.bWQ);
                        x.i("MicroMsg.MallPayMsgManager", "msgType: " + Jq.lOY);
                        if (bmq.Js(Jq.bWQ)) {
                            x.e("MicroMsg.MallPayMsgManager", "msg for id " + Jq.bWQ + " is exist!!");
                            com.tencent.mm.plugin.order.b.a Ju = bmq.Ju(Jq.bWQ);
                            bmq.Jr(Jq.bWQ);
                            bmq.huM.add(Jq);
                            bmq.a(Jq, str, Ju.field_isRead);
                        } else {
                            bmq.huM.add(Jq);
                            bmq.a(Jq, str, "0");
                        }
                        bmq.bmu();
                        b bmn = b.bmn();
                        if (Jq != null) {
                            azz azz = new azz();
                            if (TextUtils.isEmpty(Jq.lPa) || !com.tencent.mm.plugin.order.c.c.xW(Jq.lPa)) {
                                azz.lOH = (int) (System.currentTimeMillis() / 1000);
                                azz.lOJ = (int) (System.currentTimeMillis() / 1000);
                            } else {
                                azz.lOH = Integer.valueOf(Jq.lPa).intValue();
                                azz.lOJ = Integer.valueOf(Jq.lPa).intValue();
                            }
                            azz.lOM = 100000;
                            azz.lOO = Jq.lOO;
                            azz.lOE = Jq.bWQ;
                            azz.lOI = Jq.lPc;
                            azz.scI = -1;
                            azz.lOP = Jq.lOZ;
                            azz.lOQ = Jq.lPc;
                            azz.lOR = Jq.bWW;
                        }
                        bmn.bmo();
                    }
                }
            }
        });
    }
}
