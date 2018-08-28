package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.bt.h;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.x;
import junit.framework.Assert;

public final class an extends j {
    public static final String[] diD = new String[]{"CREATE TABLE IF NOT EXISTS qqgroup ( grouopid int PRIMARY KEY,membernum int,weixinnum int,insert_time int,lastupdate_time int,needupdate int,updatekey text,groupname text,reserved1 text ,reserved2 text ,reserved3 int ,reserved4 int )"};
    public final h dCZ;

    public an(h hVar) {
        this.dCZ = hVar;
    }

    public final am jf(int i) {
        am amVar = null;
        Cursor b = this.dCZ.b("select qqgroup.grouopid,qqgroup.membernum,qqgroup.weixinnum,qqgroup.insert_time,qqgroup.lastupdate_time,qqgroup.needupdate,qqgroup.updatekey,qqgroup.groupname from qqgroup  where grouopid = " + i, null, 2);
        if (b != null) {
            if (b.moveToFirst()) {
                amVar = new am();
                amVar.d(b);
            }
            b.close();
        }
        return amVar;
    }

    public final boolean a(am amVar) {
        Assert.assertTrue(amVar != null);
        ContentValues XS = amVar.XS();
        if (XS.size() <= 0) {
            x.e("MicroMsg.QQGroupStorage", "update failed, no values set");
            return false;
        }
        if (this.dCZ.update("qqgroup", XS, "grouopid= ?", new String[]{amVar.eLo}) <= 0) {
            return false;
        }
        doNotify();
        return true;
    }
}
