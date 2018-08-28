package com.tencent.mm.plugin.fav.b.e;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.e;
import com.tencent.mm.plugin.fav.a.s;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends i<e> implements s {
    private com.tencent.mm.sdk.e.e diF;

    public b(com.tencent.mm.sdk.e.e eVar) {
        super(eVar, e.dhO, "FavConfigInfo", null);
        this.diF = eVar;
    }

    public final void aw(byte[] bArr) {
        e aMb = aMb();
        boolean c;
        if (8216 == aMb.field_configId) {
            aMb.field_value = bi.bE(bArr);
            c = c(aMb, new String[0]);
            x.i("MicroMsg.FavConfigStorage", "update sync key: %s, result %B", new Object[]{aMb.field_value, Boolean.valueOf(c)});
            return;
        }
        aMb.field_configId = 8216;
        aMb.field_value = bi.bE(bArr);
        c = b(aMb);
        x.i("MicroMsg.FavConfigStorage", "insert sync key: %s, result %B", new Object[]{aMb.field_value, Boolean.valueOf(c)});
    }

    private e aMb() {
        e eVar = new e();
        x.d("MicroMsg.FavConfigStorage", "get fav config sql %s", new Object[]{"select * from FavConfigInfo where configId = 8216"});
        Cursor b = this.diF.b("select * from FavConfigInfo where configId = 8216", null, 2);
        if (b != null) {
            if (b.moveToFirst()) {
                eVar.d(b);
            }
            b.close();
        }
        return eVar;
    }

    public final byte[] aLx() {
        e aMb = aMb();
        if (8216 != aMb.field_configId) {
            x.w("MicroMsg.FavConfigStorage", "get sync key from fav db fail, try to load from mmdb");
            g.Ek();
            if (((Boolean) g.Ei().DT().get(8224, Boolean.valueOf(false))).booleanValue()) {
                x.w("MicroMsg.FavConfigStorage", "get sync from mmdb fail, has trans");
            } else {
                g.Ek();
                x.i("MicroMsg.FavConfigStorage", "get sync key(%s) from mmdb, do update fav sync key", new Object[]{bi.oV((String) g.Ei().DT().get(8216, ""))});
                byte[] WP = bi.WP(r0);
                aw(WP);
                x.w("MicroMsg.FavConfigStorage", "set fav sync key has trans");
                g.Ek();
                g.Ei().DT().set(8224, Boolean.valueOf(true));
                return WP;
            }
        }
        x.i("MicroMsg.FavConfigStorage", "get sync key, id %d, value %s", new Object[]{Integer.valueOf(aMb.field_configId), aMb.field_value});
        return bi.WP(aMb.field_value);
    }
}
