package com.tencent.mm.plugin.account.bind.ui;

import com.tencent.mm.g.a.ju;
import com.tencent.mm.plugin.account.bind.ui.f.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

public final class e extends c<ju> implements a {
    private ju eIT;

    public e() {
        this.sFo = ju.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ju juVar = (ju) bVar;
        if (juVar instanceof ju) {
            this.eIT = juVar;
            new f(this.eIT.bTI.bOb, this).Xd();
        }
        return false;
    }

    public final boolean by(int i, int i2) {
        if (this.eIT == null) {
            return false;
        }
        if (this.eIT.bTI.bTK == null) {
            this.eIT = null;
            return false;
        } else if (i == 0 && i2 == 0) {
            this.eIT.bTJ.bJm = true;
            this.eIT.bTI.bTK.run();
            this.eIT = null;
            return true;
        } else {
            this.eIT.bTJ.bJm = false;
            this.eIT.bTI.bTK.run();
            this.eIT = null;
            return false;
        }
    }

    public final void Xc() {
        if (this.eIT != null && this.eIT.bTI.bTK != null) {
            this.eIT.bTJ.bJm = false;
            this.eIT.bTI.bTK.run();
            this.eIT = null;
        }
    }
}
