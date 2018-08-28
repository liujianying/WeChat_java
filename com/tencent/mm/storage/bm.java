package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.bt.g;
import com.tencent.mm.bt.g.a;
import com.tencent.mm.bt.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class bm extends j implements a, i {
    public static final String[] diD = new String[]{"CREATE TABLE IF NOT EXISTS role_info ( id TEXT PRIMARY KEY, name TEXT, status INT, text_reserved1 TEXT, text_reserved2 TEXT, text_reserved3 TEXT, text_reserved4 TEXT, int_reserved1 INT, int_reserved2 INT, int_reserved3 INT, int_reserved4 INT )"};
    private e diF = null;

    public bm(h hVar) {
        this.diF = hVar;
    }

    public final int a(g gVar) {
        if (gVar != null) {
            this.diF = gVar;
        }
        return 0;
    }

    public final String getTableName() {
        return "role_info";
    }

    public final bl Hg(String str) {
        bl blVar = null;
        if (str != null && str.length() > 0) {
            bl blVar2 = new bl();
            Cursor a = this.diF.a("role_info", null, "name LIKE ?", new String[]{"%" + str}, null, null, null, 2);
            if (a.moveToFirst()) {
                blVar2.d(a);
                blVar = blVar2;
            }
            a.close();
        }
        return blVar;
    }

    private bl Zl(String str) {
        bl blVar = null;
        boolean z = str != null && str.length() > 0;
        Assert.assertTrue(z);
        bl blVar2 = new bl();
        Cursor a = this.diF.a("role_info", null, "name= ?", new String[]{str}, null, null, null, 2);
        if (a.moveToFirst()) {
            blVar2.d(a);
            blVar = blVar2;
        }
        a.close();
        return blVar;
    }

    public final List<bl> bdo() {
        List<bl> linkedList = new LinkedList();
        Cursor a = this.diF.a("role_info", null, "int_reserved1=1", null, null, null, null, 2);
        while (a.moveToNext()) {
            bl blVar = new bl();
            blVar.d(a);
            linkedList.add(blVar);
        }
        a.close();
        return linkedList;
    }

    private void a(bl blVar) {
        blVar.bWA = 135;
        ContentValues wH = blVar.wH();
        if (wH.size() > 0 && this.diF.insert("role_info", "id", wH) != 0) {
            doNotify();
        }
    }

    public final boolean has(String str) {
        bl Hg = Hg(new bl.a(str).Zk(""));
        return Hg != null && str.equals(Hg.name);
    }

    public final void bJ(String str, int i) {
        if (bi.oW(str)) {
            x.e("MicroMsg.RoleStorage", "insert role info failed: empty user");
        } else if (Zl(str) == null) {
            a(new bl(str, true, i));
            x.d("MicroMsg.RoleStorage", "insert new role, user=" + str);
        }
    }

    public final void aF(String str, boolean z) {
        if (bi.oW(str)) {
            x.e("MicroMsg.RoleStorage", "insert role info failed: empty user");
            return;
        }
        bl Zl = Zl(str);
        if (Zl == null) {
            a(new bl(str, z, 2));
            x.d("MicroMsg.RoleStorage", "insert new role, user=" + str);
            return;
        }
        Zl.setEnable(z);
        Zl.bWA = 4;
        b(Zl);
    }

    public final void e(String str, boolean z, boolean z2) {
        int i = 2;
        if (bi.oW(str)) {
            x.e("MicroMsg.RoleStorage", "insert role info failed: empty user");
            return;
        }
        bl Zl = Zl(str);
        if (Zl == null) {
            a(new bl(str, z, 2));
            x.d("MicroMsg.RoleStorage", "insert new role, user=" + str);
            return;
        }
        Zl.setEnable(z);
        if (z2) {
            int i2 = Zl.status;
            if (!z2) {
                i = 0;
            }
            Zl.status = i | i2;
        } else {
            Zl.status &= -3;
        }
        Zl.bWA = 4;
        b(Zl);
    }

    private void b(bl blVar) {
        ContentValues wH = blVar.wH();
        if (wH.size() > 0) {
            int update = this.diF.update("role_info", wH, "name like ?", new String[]{blVar.name});
            x.d("MicroMsg.RoleStorage", "update role info, name=" + blVar.name + ", res:" + update);
            if (update > 0) {
                doNotify();
            }
        }
    }

    public final void delete(String str) {
        Assert.assertTrue(str.length() > 0);
        int delete = this.diF.delete("role_info", "name=?", new String[]{str});
        x.d("MicroMsg.RoleStorage", "delete name name :" + str + ", res:" + delete);
        if (delete > 0) {
            doNotify();
        }
    }
}
