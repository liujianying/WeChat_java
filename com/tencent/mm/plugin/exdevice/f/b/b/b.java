package com.tencent.mm.plugin.exdevice.f.b.b;

import android.database.Cursor;
import com.tencent.mm.plugin.exdevice.f.b.a.a;
import com.tencent.mm.plugin.exdevice.f.b.d;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import junit.framework.Assert;

public final class b extends i<a> {
    public static final String[] diD = new String[]{i.a(a.dhO, "HardDeviceChampionInfo")};
    private e diF;

    public b(e eVar) {
        super(eVar, a.dhO, "HardDeviceChampionInfo", null);
        this.diF = eVar;
        eVar.fV("HardDeviceChampionInfo", "CREATE INDEX IF NOT EXISTS ExdeviceRankChampionInfoRankIdAppNameIndex ON HardDeviceChampionInfo ( username )");
    }

    public final a Ah(String str) {
        a aVar = null;
        String format = String.format("select *, rowid from %s where %s = ? limit 1", new Object[]{"HardDeviceChampionInfo", "username"});
        Cursor b = this.diF.b(format, new String[]{bi.aG(str, "")}, 2);
        if (b == null) {
            x.e("MicroMsg.ExdeviceRankChampionStg", "Get no rank in DB");
        } else {
            if (b.moveToFirst()) {
                aVar = new a();
                aVar.d(b);
            } else {
                x.d("MicroMsg.ExdeviceRankChampionStg", "hy: no record");
            }
            b.close();
        }
        return aVar;
    }

    public final boolean a(a aVar) {
        Assert.assertTrue(aVar != null);
        if (c(aVar, new String[]{"username"})) {
            x.d("MicroMsg.ExdeviceRankChampionStg", "hy: update success");
            ad.aHn().a("HardDeviceChampionInfo", new d(null, null, aVar.field_username));
            return true;
        } else if (b(aVar)) {
            x.d("MicroMsg.ExdeviceRankChampionStg", "hy: insert success");
            ad.aHn().a("HardDeviceChampionInfo", new d(null, null, aVar.field_username));
            return true;
        } else {
            x.w("MicroMsg.ExdeviceRankChampionStg", "hy: insert or update failed");
            return false;
        }
    }
}
