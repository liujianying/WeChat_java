package com.tencent.mm.plugin.exdevice.f.b.b;

import android.database.Cursor;
import com.tencent.mm.plugin.exdevice.f.b.a.c;
import com.tencent.mm.plugin.exdevice.f.b.b;
import com.tencent.mm.protocal.c.xj;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

public final class a extends i<c> {
    public static final String[] diD = new String[]{i.a(c.dhO, "HardDeviceRankFollowInfo")};
    private e diF;

    public a(e eVar) {
        super(eVar, c.dhO, "HardDeviceRankFollowInfo", null);
        this.diF = eVar;
        eVar.fV("HardDeviceRankFollowInfo", "CREATE INDEX IF NOT EXISTS ExdeviceRankFollowRankIdAppNameIndex ON HardDeviceRankFollowInfo ( rankID, appusername )");
    }

    public final c a(b bVar) {
        c cVar = null;
        String format = String.format("select *, rowid from %s where %s = ? and %s = ? and %s = ? limit 1", new Object[]{"HardDeviceRankFollowInfo", "rankID", "username", "appusername"});
        Cursor b = this.diF.b(format, new String[]{bi.aG(bVar.ixK, ""), bi.aG(bVar.username, ""), bi.aG(bVar.appName, "")}, 2);
        if (b == null) {
            x.e("MicroMsg.ExdeviceFollowInfoStg", "ap: Get no follow in DB");
        } else {
            if (b.moveToFirst()) {
                cVar = new c();
                cVar.d(b);
            } else {
                x.d("MicroMsg.ExdeviceFollowInfoStg", "ap: no record");
            }
            b.close();
        }
        return cVar;
    }

    public final boolean Af(String str) {
        String format = String.format("select * from %s where %s=? and %s=? and %s=? limit 1", new Object[]{"HardDeviceRankFollowInfo", "rankID", "appusername", "username"});
        Cursor b = this.diF.b(format, new String[]{bi.aG("hardcode_rank_id", ""), bi.aG("hardcode_app_name", ""), bi.aG(str, "")}, 2);
        if (b == null) {
            x.e("MicroMsg.ExdeviceFollowInfoStg", "ap: check follow not in DB");
            return false;
        }
        boolean moveToFirst = b.moveToFirst();
        b.close();
        x.d("MicroMsg.ExdeviceFollowInfoStg", "checkUserIsFollow %s", new Object[]{Boolean.valueOf(moveToFirst)});
        return moveToFirst;
    }

    public final ArrayList<c> aHs() {
        ArrayList<c> arrayList = null;
        String format = String.format("select *, rowid from %s where %s= ? and %s = ? order by rowid asc", new Object[]{"HardDeviceRankFollowInfo", "rankID", "appusername"});
        Cursor b = this.diF.b(format, new String[]{"hardcode_rank_id", "hardcode_app_name"}, 2);
        if (b == null) {
            x.e("MicroMsg.ExdeviceFollowInfoStg", "ap: Get follows not in DB");
        } else {
            if (b.moveToFirst()) {
                arrayList = new ArrayList();
                do {
                    c cVar = new c();
                    cVar.d(b);
                    x.d("MicroMsg.ExdeviceFollowInfoStg", "follow info: rowid: %s, info: %s", new Object[]{Integer.valueOf(b.getColumnIndex("rowid")), cVar.toString()});
                    arrayList.add(cVar);
                } while (b.moveToNext());
                x.d("MicroMsg.ExdeviceFollowInfoStg", "getAllFollowItem: %d, %s", new Object[]{Integer.valueOf(arrayList.size()), arrayList.toString()});
            } else {
                x.d("MicroMsg.ExdeviceFollowInfoStg", "ap: no record");
            }
            b.close();
        }
        return arrayList;
    }

    public final void a(ArrayList<xj> arrayList, String str, String str2) {
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                xj xjVar = (xj) it.next();
                c cVar = new c();
                cVar.field_rankID = str;
                cVar.field_step = xjVar.fHo;
                cVar.field_username = xjVar.username;
                cVar.field_appusername = str2;
                a(cVar);
            }
        }
    }

    public final void aS(List<c> list) {
        String str = "hardcode_app_name";
        if (bi.oW("hardcode_rank_id") || bi.oW(str)) {
            x.e("MicroMsg.ExdeviceFollowInfoStg", "ap: delete follows,params is null");
        } else {
            int delete = this.diF.delete("HardDeviceRankFollowInfo", "rankID=? and appusername=?", new String[]{r0, str});
            x.d("MicroMsg.ExdeviceFollowInfoStg", "ap: delete rankId: %s %s count %d", new Object[]{r0, str, Integer.valueOf(delete)});
        }
        if (list != null) {
            for (c cVar : list) {
                cVar.field_rankID = "hardcode_rank_id";
                cVar.field_appusername = "hardcode_app_name";
                a(cVar);
            }
        }
    }

    private boolean a(c cVar) {
        boolean z;
        boolean z2 = false;
        if (cVar != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        c a = a(new b(cVar.field_rankID, cVar.field_appusername, cVar.field_username));
        if (a != null) {
            a.field_step = cVar.field_step;
            c(a, new String[]{"rankID", "appusername", "username"});
            x.d("MicroMsg.ExdeviceFollowInfoStg", "ap: update success");
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            if (cVar != null) {
                z2 = true;
            }
            Assert.assertTrue(z2);
            b(cVar);
            x.d("MicroMsg.ExdeviceFollowInfoStg", "ap: insert success");
        }
        return true;
    }

    public final boolean Ag(String str) {
        c a = a(new b("hardcode_rank_id", "hardcode_app_name", str));
        if (a == null) {
            return false;
        }
        a(a, new String[]{"rankID", "appusername", "username"});
        x.d("MicroMsg.ExdeviceFollowInfoStg", "ap: update success");
        return true;
    }
}
