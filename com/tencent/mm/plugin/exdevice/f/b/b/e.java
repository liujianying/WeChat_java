package com.tencent.mm.plugin.exdevice.f.b.b;

import android.database.Cursor;
import com.tencent.mm.plugin.exdevice.f.b.d;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import junit.framework.Assert;

public final class e extends i<com.tencent.mm.plugin.exdevice.f.b.a.e> {
    public static final String[] diD = new String[]{i.a(com.tencent.mm.plugin.exdevice.f.b.a.e.dhO, "HardDeviceLikeUser")};
    private com.tencent.mm.sdk.e.e diF;

    public e(com.tencent.mm.sdk.e.e eVar) {
        super(eVar, com.tencent.mm.plugin.exdevice.f.b.a.e.dhO, "HardDeviceLikeUser", null);
        this.diF = eVar;
        eVar.fV("HardDeviceLikeUser", "CREATE INDEX IF NOT EXISTS ExdeviceRankLikeInfoRankIdAppNameIndex ON HardDeviceLikeUser ( rankID, appusername )");
    }

    public final ArrayList<com.tencent.mm.plugin.exdevice.f.b.a.e> Ai(String str) {
        ArrayList<com.tencent.mm.plugin.exdevice.f.b.a.e> arrayList = null;
        if (bi.oW(str)) {
            x.e("MicroMsg.ExdeviceRankLikeUserStg", "hy: param error");
        } else {
            String format = String.format("select *, rowid from %s where %s = ? order by %s desc", new Object[]{"HardDeviceLikeUser", "rankID", "timestamp"});
            Cursor b = this.diF.b(format, new String[]{bi.aG(str, "")}, 2);
            if (b == null) {
                x.e("MicroMsg.ExdeviceRankLikeUserStg", "Get no rank in DB");
            } else {
                if (b.moveToFirst()) {
                    arrayList = new ArrayList();
                    do {
                        com.tencent.mm.plugin.exdevice.f.b.a.e eVar = new com.tencent.mm.plugin.exdevice.f.b.a.e();
                        eVar.d(b);
                        arrayList.add(eVar);
                    } while (b.moveToNext());
                }
                b.close();
            }
        }
        return arrayList;
    }

    public final void a(String str, String str2, ArrayList<com.tencent.mm.plugin.exdevice.f.b.a.e> arrayList) {
        Assert.assertTrue(!bi.oW(str));
        if (arrayList == null) {
            x.i("MicroMsg.ExdeviceRankLikeUserStg", "batchInsertOrUpdate failed, data is null.");
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.exdevice.f.b.a.e eVar = (com.tencent.mm.plugin.exdevice.f.b.a.e) it.next();
            Assert.assertTrue(eVar != null);
            if (c(eVar, new String[]{"rankID", "username"})) {
                x.d("MicroMsg.ExdeviceRankLikeUserStg", "hy: update success");
            } else if (b(eVar)) {
                x.d("MicroMsg.ExdeviceRankLikeUserStg", "hy: insert success");
            } else {
                x.w("MicroMsg.ExdeviceRankLikeUserStg", "hy: insert or update failed");
            }
        }
        ad.aHn().a("HardDeviceLikeUser", new d(str, str2, null));
    }
}
