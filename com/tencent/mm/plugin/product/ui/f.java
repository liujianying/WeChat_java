package com.tencent.mm.plugin.product.ui;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.o;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.g.a.te;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.b.d;
import com.tencent.mm.plugin.product.b.h;
import com.tencent.mm.plugin.product.b.i;
import com.tencent.mm.plugin.product.b.j;
import com.tencent.mm.plugin.product.b.k;
import com.tencent.mm.plugin.product.b.m;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.protocal.c.bfm;
import com.tencent.mm.protocal.c.wk;
import com.tencent.mm.protocal.c.wl;
import com.tencent.mm.protocal.c.wr;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.TXLiveConstants;
import java.util.HashMap;
import java.util.LinkedList;

public final class f implements e {
    static int fdx = 0;
    Activity ftd;
    boolean lSE = false;
    private boolean lSF = false;
    c lSG;
    private a lSH;
    private com.tencent.mm.sdk.b.c lSI = new 3(this);

    /* renamed from: com.tencent.mm.plugin.product.ui.f$1 */
    class AnonymousClass1 implements a {
        final /* synthetic */ m lSJ;
        private volatile int result;
        final /* synthetic */ Intent val$intent;

        AnonymousClass1(Intent intent, m mVar) {
            this.val$intent = intent;
            this.lSJ = mVar;
        }

        public final boolean Kr() {
            this.result = f.a(f.this, this.val$intent, this.lSJ);
            return true;
        }

        public final boolean Ks() {
            switch (this.result) {
                case -1:
                    if (f.this.lSH != null) {
                        f.this.lSH.m(0, -1, f.this.ftd.getString(a$i.mall_product_data_err));
                        break;
                    }
                    break;
                case 0:
                    if (f.this.lSH != null) {
                        f.this.lSH.m(0, 0, "");
                        break;
                    }
                    break;
            }
            return true;
        }

        public final String toString() {
            return super.toString() + "|initData";
        }
    }

    static /* synthetic */ int a(f fVar, Intent intent, m mVar) {
        fdx = intent.getIntExtra("key_product_scene", 3);
        String stringExtra = intent.getStringExtra("key_product_info");
        String stringExtra2 = intent.getStringExtra("key_product_id");
        String stringExtra3 = intent.getStringExtra("key_source_url");
        c cVar = fVar.lSG;
        if (!bi.oW(stringExtra3)) {
            cVar.lQO = stringExtra3;
        }
        int i = -2;
        x.i("MicroMsg.MallProductUI", "Scene : " + fdx);
        switch (fdx) {
            case 1:
            case 2:
            case 4:
                if (!bi.oW(stringExtra)) {
                    mVar = m.b(mVar, stringExtra);
                    if (mVar == null) {
                        i = -1;
                        break;
                    }
                    fVar.lSG.a(mVar, null);
                    stringExtra2 = mVar.lRl;
                    i = 0;
                    break;
                }
                break;
            case 3:
                if (!bi.oW(stringExtra)) {
                    mVar = m.a(mVar, stringExtra);
                    if (mVar == null) {
                        i = -1;
                        break;
                    }
                    fVar.lSG.a(mVar, null);
                    stringExtra2 = mVar.lRl;
                    i = 0;
                    break;
                }
                break;
        }
        if (bi.oW(stringExtra2)) {
            return -1;
        }
        g.Ek();
        g.Eh().dpP.a(new h(mVar, stringExtra2), 0);
        return i;
    }

    public f(Activity activity, a aVar) {
        this.ftd = activity;
        com.tencent.mm.plugin.product.a.a.bmF();
        this.lSG = com.tencent.mm.plugin.product.a.a.bmG();
        this.lSH = aVar;
    }

    public final void onStart() {
        g.Ek();
        g.Eh().dpP.a(553, this);
        g.Ek();
        g.Eh().dpP.a(554, this);
        g.Ek();
        g.Eh().dpP.a(555, this);
        g.Ek();
        g.Eh().dpP.a(556, this);
        g.Ek();
        g.Eh().dpP.a(557, this);
        g.Ek();
        g.Eh().dpP.a(578, this);
        g.Ek();
        g.Eh().dpP.a(579, this);
    }

    public final void onStop() {
        g.Ek();
        g.Eh().dpP.b(553, this);
        g.Ek();
        g.Eh().dpP.b(554, this);
        g.Ek();
        g.Eh().dpP.b(555, this);
        g.Ek();
        g.Eh().dpP.b(556, this);
        g.Ek();
        g.Eh().dpP.b(557, this);
        g.Ek();
        g.Eh().dpP.b(578, this);
        g.Ek();
        g.Eh().dpP.b(579, this);
    }

    public final void bnf() {
        m mVar = this.lSG.lQL;
        ch chVar = new ch();
        wl wlVar = new wl();
        wr wrVar = new wr();
        wk wkVar = new wk();
        wrVar.Vw(q.GF());
        wrVar.Vx(q.GF());
        wrVar.CO(11);
        wrVar.fU(bi.VF());
        wkVar.Vp(mVar.lRp.name);
        wkVar.Vq(this.lSG.bmZ());
        wkVar.CL(mVar.lRm);
        wkVar.Vs(this.lSG.a(mVar));
        wkVar.Vr(mVar.bnb());
        chVar.bJF.title = mVar.lRp.name;
        chVar.bJF.desc = this.lSG.bmZ();
        chVar.bJF.bJH = wlVar;
        chVar.bJF.type = 11;
        wlVar.a(wrVar);
        wlVar.b(wkVar);
        chVar.bJF.activity = this.ftd;
        chVar.bJF.bJM = 5;
        com.tencent.mm.sdk.b.a.sFg.m(chVar);
    }

    private void bng() {
        d bmH = com.tencent.mm.plugin.product.a.a.bmF().bmH();
        bfm bmN = this.lSG.bmN();
        if (!(bmN == null || bi.oW(bmN.jQf) || bmN.jQf.contains(";"))) {
            bmH.lRd.remove(bmN.jQf);
            bmH.lRd.add(bmN.jQf);
            bmH.bna();
        }
        Intent intent = new Intent(this.ftd, MallProductUI.class);
        intent.putExtra("key_go_finish", true);
        intent.addFlags(67108864);
        this.ftd.startActivity(intent);
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.d("MicroMsg.MallProductUI", "errCode: " + i2 + ", errMsg: " + str);
        h hVar;
        c cVar;
        String str2;
        LinkedList linkedList;
        if (i != 0 || i2 != 0) {
            switch (i2) {
                case -10010003:
                    x.i("MicroMsg.MallProductUI", "deal with MMBIZPAY_FUNC_ERR_NO_EXISTED_PRODUCT");
                    if (lVar instanceof h) {
                        hVar = (h) lVar;
                        this.lSG.a(hVar.lRh, hVar.lRi);
                        if (this.lSH != null) {
                            this.lSH.m(i, i2, str);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    x.i("MicroMsg.MallProductUI", "unkown errCode " + i2);
                    if (bi.oW(str)) {
                        str = i2 + " : " + this.ftd.getString(a$i.mall_product_data_err);
                    }
                    if (this.lSH != null) {
                        this.lSH.m(i, i2, str);
                        return;
                    }
                    return;
            }
        } else if (lVar instanceof h) {
            hVar = (h) lVar;
            this.lSG.a(hVar.lRh, hVar.lRi);
            if (this.lSH != null) {
                this.lSH.m(i, i2, str);
            }
            if (bi.oW(hVar.lRh.lRl)) {
                com.tencent.mm.plugin.report.service.h.mEJ.h(11007, new Object[]{this.lSG.bmO(), hVar.lRg, Integer.valueOf(fdx), Integer.valueOf(1)});
                return;
            }
            com.tencent.mm.plugin.report.service.h.mEJ.h(11007, new Object[]{this.lSG.bmO(), hVar.lRh.lRl, Integer.valueOf(fdx), Integer.valueOf(1)});
        } else if (lVar instanceof j) {
            j jVar = (j) lVar;
            cVar = this.lSG;
            str2 = jVar.lQN;
            linkedList = jVar.lQY;
            LinkedList linkedList2 = jVar.lQZ;
            cVar.lQN = str2;
            cVar.lQZ = linkedList2;
            cVar.lQY = linkedList;
            cVar.uw(0);
            this.ftd.startActivity(new Intent(this.ftd, MallProductSubmitUI.class));
            com.tencent.mm.plugin.report.service.h.mEJ.h(11009, new Object[]{this.lSG.bmO(), this.lSG.lQL.lRl, Integer.valueOf(fdx), Integer.valueOf(1)});
        } else if (!(lVar instanceof com.tencent.mm.plugin.product.b.f)) {
            if (lVar instanceof com.tencent.mm.plugin.product.b.l) {
                str2 = ((com.tencent.mm.plugin.product.b.l) lVar).lRk;
                int i3 = 6;
                if (fdx == 7) {
                    i3 = TXLiveConstants.PUSH_EVT_CONNECT_SUCC;
                }
                x.d("MicroMsg.MallProductUI", "payScene:" + i3);
                com.tencent.mm.pluginsdk.wallet.h.a(this.ftd, str2, this.lSG.getAppId(), i3, 3);
                com.tencent.mm.sdk.b.a.sFg.b(this.lSI);
            } else if (lVar instanceof k) {
                com.tencent.mm.ui.base.h.bA(this.ftd, this.ftd.getString(a$i.mall_product_submit_buy_free));
                bng();
            } else if (lVar instanceof com.tencent.mm.plugin.product.b.g) {
                try {
                    this.ftd.dismissDialog(-10002);
                } catch (Exception e) {
                    x.e("MicroMsg.MallProductUI", e.toString());
                }
                cVar = this.lSG;
                cVar.lQY = ((com.tencent.mm.plugin.product.b.g) lVar).lQY;
                cVar.uw(0);
            } else if (lVar instanceof i) {
                try {
                    this.ftd.dismissDialog(-10002);
                } catch (Exception e2) {
                    x.e("MicroMsg.MallProductUI", e2.toString());
                }
                i iVar = (i) lVar;
                cVar = this.lSG;
                str2 = iVar.mUrl;
                linkedList = iVar.lRj;
                if (!(bi.oW(str2) || linkedList == null || linkedList.size() <= 0)) {
                    if (cVar.lRc == null) {
                        cVar.lRc = new HashMap();
                    }
                    cVar.lRc.put(str2, linkedList);
                }
                if (this.lSH != null) {
                    this.lSH.m(i, i2, str);
                }
            }
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                if (i2 == -1 && intent != null) {
                    this.lSG.W(intent);
                    if (this.lSH != null) {
                        this.lSH.m(0, 0, "");
                    }
                    g.Ek();
                    o oVar = g.Eh().dpP;
                    c cVar = this.lSG;
                    oVar.a(new com.tencent.mm.plugin.product.b.g(cVar.lQL != null ? cVar.lQL.lRl : "", this.lSG.lQN, this.lSG.lQR), 0);
                    return;
                }
                return;
            case 2:
                if (i2 == -1 && intent != null) {
                    this.lSG.W(intent);
                    g.Ek();
                    g.Eh().dpP.a(new j(this.lSG.bmV(), fdx), 0);
                    return;
                }
                return;
            case 3:
                te teVar = new te();
                teVar.ceH.result = i;
                teVar.ceH.intent = intent;
                this.lSI.a(teVar);
                return;
            case 4:
                if (this.lSH != null) {
                    this.lSH.m(0, 0, "");
                    return;
                }
                return;
            case 10000:
                this.ftd.showDialog(-10002);
                g.Ek();
                g.Eh().dpP.a(new i(this.lSG.lQN, this.lSG.lQU), 0);
                return;
            default:
                return;
        }
    }
}
