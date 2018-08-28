package com.tencent.mm.plugin.account.friend.a;

import android.database.Cursor;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bi;
import junit.framework.Assert;

public final class h extends j {
    public static final String[] diD = new String[]{"CREATE TABLE IF NOT EXISTS facebookfriend ( fbid long  PRIMARY KEY , fbname text  , fbimgkey int  , status int  , username text  , nickname text  , nicknamepyinitial text  , nicknamequanpin text  , sex int  , personalcard int  , province text  , city text  , signature text  , alias text  , type int  , email text  ) "};
    public com.tencent.mm.bt.h dCZ;

    public h(com.tencent.mm.bt.h hVar) {
        this.dCZ = hVar;
    }

    public final boolean a(g gVar) {
        Assert.assertTrue("Func Set always conv_flag == flag_all", gVar.bWA == -1);
        Cursor b = this.dCZ.b("select facebookfriend.fbid,facebookfriend.fbname,facebookfriend.fbimgkey,facebookfriend.status,facebookfriend.username,facebookfriend.nickname,facebookfriend.nicknamepyinitial,facebookfriend.nicknamequanpin,facebookfriend.sex,facebookfriend.personalcard,facebookfriend.province,facebookfriend.city,facebookfriend.signature,facebookfriend.alias,facebookfriend.type,facebookfriend.email from facebookfriend   where facebookfriend.fbid = \"" + bi.oU(String.valueOf(gVar.csC)) + "\"", null, 2);
        boolean moveToFirst = b.moveToFirst();
        b.close();
        if (moveToFirst) {
            int update = this.dCZ.update("facebookfriend", gVar.wH(), "fbid=?", new String[]{gVar.csC});
            if (update > 0) {
                doNotify();
            }
            if (update <= 0) {
                return false;
            }
            return true;
        }
        gVar.bWA = -1;
        return ((int) this.dCZ.insert("facebookfriend", "fbid", gVar.wH())) != -1;
    }

    public final boolean Xw() {
        return this.dCZ.fV("facebookfriend", "delete from facebookfriend");
    }
}
