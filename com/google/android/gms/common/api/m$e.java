package com.google.android.gms.common.api;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.api.m.d;
import com.google.android.gms.common.api.m.i;
import java.util.Map;

class m$e extends i {
    final /* synthetic */ m aLa;
    private final Map<b, d> aLj;

    public m$e(m mVar, Map<b, d> map) {
        this.aLa = mVar;
        super(mVar, (byte) 0);
        this.aLj = map;
    }

    public final void oI() {
        int i;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        for (b bVar : this.aLj.keySet()) {
            if (!bVar.ov()) {
                i = 0;
            } else if (((d) this.aLj.get(bVar)).aLi == 0) {
                i4 = 1;
                i = 1;
                break;
            } else {
                i = i3;
                i4 = 1;
            }
            i3 = i;
        }
        i = 0;
        if (i4 != 0) {
            i2 = com.google.android.gms.common.b.ae(this.aLa.mContext);
        }
        if (i2 == 0 || (r0 == 0 && i3 == 0)) {
            if (this.aLa.aKS) {
                this.aLa.aKQ.connect();
            }
            for (b bVar2 : this.aLj.keySet()) {
                c$e c_e = (c$e) this.aLj.get(bVar2);
                if (!bVar2.ov() || i2 == 0) {
                    bVar2.a(c_e);
                } else {
                    this.aLa.aKG.a(new 2(this, this.aLa, c_e));
                }
            }
            return;
        }
        this.aLa.aKG.a(new 1(this, this.aLa, new ConnectionResult(i2, null)));
    }
}
