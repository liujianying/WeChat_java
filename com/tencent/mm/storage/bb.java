package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class bb extends i<ba> implements e {
    public static final String[] diD = new String[]{i.a(ba.dhO, "LBSVerifyMessage")};
    public com.tencent.mm.sdk.e.e diF;

    public bb(com.tencent.mm.sdk.e.e eVar) {
        super(eVar, ba.dhO, "LBSVerifyMessage", ch.ciG);
        this.diF = eVar;
    }

    public final int axd() {
        Cursor b = this.diF.b("select count(*) from " + getTableName() + " where status != 4", null, 2);
        if (b.moveToFirst()) {
            int i = b.getInt(0);
            b.close();
            return i;
        }
        b.close();
        return 0;
    }

    public final int getCount() {
        int i = 0;
        Cursor b = this.diF.b("select count(*) from " + getTableName(), null, 2);
        if (b.moveToFirst()) {
            i = b.getInt(0);
        }
        b.close();
        return i;
    }

    public final ba clZ() {
        Cursor b = this.diF.b("SELECT * FROM " + getTableName() + " where status != 4 ORDER BY createtime DESC LIMIT 1", null, 2);
        if (b == null) {
            return null;
        }
        if (b.moveToFirst()) {
            ba baVar = new ba();
            baVar.d(b);
            b.close();
            return baVar;
        }
        b.close();
        return null;
    }

    public final void cma() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", Integer.valueOf(4));
        if (this.diF.update(getTableName(), contentValues, "status!=? ", new String[]{"4"}) != 0) {
            doNotify();
        }
    }

    public final void YP(String str) {
        int delete = this.diF.delete(getTableName(), "svrid = '" + str + "'", null);
        if (delete > 0) {
            doNotify();
        }
        x.i("MicroMsg.LBSVerifyMessageStorage", "delBySvrId = " + delete);
    }

    public final void YQ(String str) {
        int delete = this.diF.delete(getTableName(), "sayhiuser = '" + str + "' or sayhiencryptuser='" + str + "'", null);
        if (delete > 0) {
            doNotify();
        }
        x.i("MicroMsg.LBSVerifyMessageStorage", "delByUserName = " + delete);
    }

    public final void aPm() {
        this.diF.delete(getTableName(), null, null);
    }

    /* renamed from: a */
    public final boolean b(ba baVar) {
        if (baVar == null) {
            x.e("MicroMsg.LBSVerifyMessageStorage", "insert fail, lbsMsg is null");
            return false;
        } else if (!super.b(baVar)) {
            return false;
        } else {
            Xp(baVar.sKx);
            return true;
        }
    }

    public final ba[] YR(String str) {
        x.d("MicroMsg.LBSVerifyMessageStorage", "getLastLBSVerifyMessage");
        Cursor b = this.diF.b("select *, rowid from LBSVerifyMessage  where sayhiuser = '" + bi.oU(str) + "' or sayhiencryptuser = '" + bi.oU(str) + "' order by createtime DESC limit 3", null, 2);
        ArrayList arrayList = new ArrayList();
        while (b.moveToNext()) {
            ba baVar = new ba();
            baVar.d(b);
            arrayList.add(baVar);
        }
        b.close();
        return (ba[]) arrayList.toArray(new ba[arrayList.size()]);
    }

    public final ba YS(String str) {
        ba baVar = null;
        x.d("MicroMsg.LBSVerifyMessageStorage", "getLBSVerifyMessage");
        Cursor b = this.diF.b("select *, rowid from LBSVerifyMessage  where (sayhiuser = '" + bi.oU(str) + "' or sayhiencryptuser = '" + bi.oU(str) + "') and flag=1 order by createtime DESC limit 1", null, 2);
        if (b.moveToFirst()) {
            baVar = new ba();
            baVar.d(b);
        } else {
            x.i("MicroMsg.LBSVerifyMessageStorage", "getLBSVerifyMessage, cursor count = 0");
        }
        b.close();
        return baVar;
    }

    public final ba[] dd(String str, int i) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.LBSVerifyMessageStorage", "getLastRecvLbsMsg fail, talker is null");
            return null;
        }
        Cursor b = this.diF.b("select * from LBSVerifyMessage where isSend = 0 and (sayhiuser = '" + bi.oU(str) + "' or sayhiencryptuser = '" + bi.oU(str) + "') order by createTime DESC limit " + i, null, 2);
        ArrayList arrayList = new ArrayList();
        while (b.moveToNext()) {
            ba baVar = new ba();
            baVar.d(b);
            arrayList.add(baVar);
        }
        b.close();
        return (ba[]) arrayList.toArray(new ba[arrayList.size()]);
    }

    public static long YT(String str) {
        long j;
        long VE;
        if (str != null) {
            ba baVar;
            bb bbVar = (bb) ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).bcV();
            Cursor b = bbVar.diF.b("SELECT * FROM " + bbVar.getTableName() + " ORDER BY createtime DESC LIMIT 1", null, 2);
            if (b == null) {
                baVar = null;
            } else if (b.moveToFirst()) {
                baVar = new ba();
                baVar.d(b);
                b.close();
            } else {
                b.close();
                baVar = null;
            }
            if (baVar != null) {
                j = baVar.field_createtime + 1;
                VE = bi.VE();
                return j <= VE ? j : VE;
            }
        }
        j = 0;
        VE = bi.VE();
        if (j <= VE) {
        }
    }
}
