package com.tencent.mm.plugin.appbrand.f;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.appusage.k;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.a.f;

public final class d extends a {
    public l fyJ;
    public k fyK;
    public CharSequence fyL;
    private b fyM = new b(this);
    a fyN = new a(this);

    public d(int i) {
        super(16, i);
    }

    public final void a(Context context, a.a aVar, Object... objArr) {
        boolean z = true;
        boolean z2 = false;
        this.fyK = i.sK(this.fyJ.jrv);
        if (this.fyK != null) {
            boolean z3;
            switch (this.fyJ.jru) {
                case 2:
                    break;
                case 3:
                    z2 = true;
                    break;
                default:
                    z = false;
                    z3 = false;
                    break;
            }
            z3 = z2;
            this.fyL = f.a(com.tencent.mm.plugin.fts.a.a.d.a(this.fyK.appName, this.jrx, z, z3)).jrO;
            this.info = this.fyK.bGy;
        }
    }

    public final b BV() {
        return this.fyM;
    }

    protected final a.a afD() {
        return this.fyN;
    }

    public final String afE() {
        return this.fyK.appName;
    }

    public final int afF() {
        return this.fyJ.jsJ;
    }
}
