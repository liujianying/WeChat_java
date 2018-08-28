package com.tencent.mm.plugin.chatroom;

import com.tencent.mm.g.a.jv;
import com.tencent.mm.g.a.jw;
import com.tencent.mm.g.a.jx;
import com.tencent.mm.g.a.jy;
import com.tencent.mm.g.a.kc;
import com.tencent.mm.g.a.rg;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class d$6 extends c<rg> {
    final /* synthetic */ d hKI;

    d$6(d dVar) {
        this.hKI = dVar;
        this.sFo = rg.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        rg rgVar = (rg) bVar;
        if (rgVar.cbZ.cca.equals(jv.class.getName())) {
            if (rgVar.cbZ.bNI == 1) {
                d.a(this.hKI).cbp();
            } else {
                d.a(this.hKI).aYG();
            }
        } else if (rgVar.cbZ.cca.equals(jy.class.getName())) {
            if (rgVar.cbZ.bNI == 1) {
                d.b(this.hKI).cbp();
            } else {
                d.b(this.hKI).aYG();
            }
        } else if (rgVar.cbZ.cca.equals(jw.class.getName())) {
            if (rgVar.cbZ.bNI == 1) {
                d.c(this.hKI).cbp();
            } else {
                d.c(this.hKI).aYG();
            }
        } else if (rgVar.cbZ.cca.equals(jx.class.getName())) {
            if (rgVar.cbZ.bNI == 1) {
                d.d(this.hKI).cbp();
            } else {
                d.d(this.hKI).aYG();
            }
        } else if (rgVar.cbZ.cca.equals(kc.class.getName())) {
            if (rgVar.cbZ.bNI == 1) {
                d.e(this.hKI).cbp();
            } else {
                d.e(this.hKI).aYG();
            }
        }
        return false;
    }
}
