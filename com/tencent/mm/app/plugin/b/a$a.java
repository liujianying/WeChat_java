package com.tencent.mm.app.plugin.b;

import com.tencent.mm.app.plugin.b.a.d;
import com.tencent.mm.app.plugin.b.a.f;
import com.tencent.mm.app.plugin.b.a.g;
import com.tencent.mm.app.plugin.b.a.h;
import com.tencent.mm.app.plugin.b.a.i;
import com.tencent.mm.g.a.et;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public class a$a extends c<et> {
    i bAO;
    a$e bAP;
    f bAQ;
    d bAR;
    h bAS;
    g bAT;
    a.c bAU;
    a$b bAV;

    public a$a() {
        this.sFo = et.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        et etVar = (et) bVar;
        if (etVar.bMw.op == 1) {
            x.i("MicroMsg.SubCoreExtAgent", "ExtAgentLifeEventListener init");
            this.bAO = new i();
            this.bAP = new a$e();
            this.bAQ = new f();
            this.bAR = new d();
            this.bAS = new h();
            this.bAT = new g();
            this.bAU = new a.c();
            this.bAV = new a$b();
            a.sFg.b(this.bAO);
            a.sFg.b(this.bAP);
            a.sFg.b(this.bAQ);
            a.sFg.b(this.bAR);
            a.sFg.b(this.bAS);
            a.sFg.b(this.bAT);
            a.sFg.b(this.bAU);
            a.sFg.b(this.bAV);
        } else if (etVar.bMw.op == 2) {
            if (this.bAO != null) {
                a.sFg.c(this.bAO);
            }
            if (this.bAP != null) {
                a.sFg.c(this.bAP);
            }
            if (this.bAQ != null) {
                a.sFg.c(this.bAQ);
            }
            if (this.bAR != null) {
                a.sFg.c(this.bAR);
            }
            if (this.bAS != null) {
                a.sFg.c(this.bAS);
            }
            if (this.bAT != null) {
                a.sFg.c(this.bAT);
            }
            if (this.bAU != null) {
                a.sFg.c(this.bAU);
            }
            if (this.bAV != null) {
                a.sFg.c(this.bAV);
            }
        }
        return true;
    }
}
