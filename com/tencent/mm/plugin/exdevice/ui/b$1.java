package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.plugin.exdevice.f.b.a.d;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceLikeView.a;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements a {
    final /* synthetic */ d iER;
    final /* synthetic */ b iES;

    b$1(b bVar, d dVar) {
        this.iES = bVar;
        this.iER = dVar;
    }

    public final void ju(int i) {
        x.i("MicroMsg.ExdeviceRankAdapter", "hy: like view clicked.after statae: %d", new Object[]{Integer.valueOf(i)});
        if (b.a(this.iES) != null) {
            b.a(this.iES).bk(this.iER.field_username, i);
        }
    }

    public final boolean aHU() {
        if (b.a(this.iES) != null) {
            return b.a(this.iES).Ay(this.iER.field_username);
        }
        return true;
    }
}
