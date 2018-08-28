package com.tencent.mm.plugin.nearby.a;

import com.tencent.mm.bt.h;
import com.tencent.mm.g.a.iv;
import com.tencent.mm.g.a.jz;
import com.tencent.mm.g.a.ka;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.pluginsdk.c.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ay.a;
import java.util.HashMap;

public final class f implements ar {
    private c hKG = new 5(this);
    private c lBo = new 1(this);
    private c lBp = new c<iv>() {
        {
            this.sFo = iv.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            iv ivVar = (iv) bVar;
            switch (ivVar.bSp.bNI) {
                case 1:
                    b.bP(ivVar.bSp.bSr, ivVar.bSp.bSs);
                    break;
                case 2:
                    b.tP(ivVar.bSp.bSs);
                    break;
                case 3:
                    ivVar.bSq.bJm = b.biN();
                    break;
                case 4:
                    b.biO();
                    break;
                case 5:
                    b.biP();
                    break;
                case 6:
                    b.IH(ivVar.bSp.bSr);
                    break;
                case 7:
                    iv.b bVar2 = ivVar.bSq;
                    au.HU();
                    Long l = (Long) com.tencent.mm.model.c.DT().get(8210, null);
                    boolean z = l == null ? true : System.currentTimeMillis() > l.longValue();
                    bVar2.bJm = z;
                    break;
                default:
                    x.e("MicroMsg.SubCoreNearby", "LbsroomLogicEvent unkown opcode!");
                    break;
            }
            return false;
        }
    };
    com.tencent.mm.pluginsdk.c.c<jz> lBq = new 3(this);
    com.tencent.mm.pluginsdk.c.c<ka> lBr = new 4(this);
    d lBs = new 6(this);
    private a lBt = new 7(this);

    public final void onAccountRelease() {
        au.HU();
        com.tencent.mm.model.c.FR().b(this.lBt);
        com.tencent.mm.sdk.b.a.sFg.c(this.lBp);
        com.tencent.mm.sdk.b.a.sFg.c(this.hKG);
        com.tencent.mm.sdk.b.a.sFg.c(this.lBq);
        com.tencent.mm.sdk.b.a.sFg.c(this.lBr);
        this.lBo.dead();
    }

    public final HashMap<Integer, h.d> Ci() {
        return null;
    }

    public final void gi(int i) {
    }

    public final void bn(boolean z) {
        au.HU();
        com.tencent.mm.model.c.FR().a(this.lBt);
        com.tencent.mm.sdk.b.a.sFg.b(this.hKG);
        com.tencent.mm.sdk.b.a.sFg.b(this.lBp);
        com.tencent.mm.sdk.b.a.sFg.b(this.lBq);
        com.tencent.mm.sdk.b.a.sFg.b(this.lBr);
        this.lBo.cht();
    }

    public final void bo(boolean z) {
    }
}
