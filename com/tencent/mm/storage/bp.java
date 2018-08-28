package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class bp extends i<bo> implements j {
    public static final String[] ciG = new String[]{"CREATE INDEX IF NOT EXISTS  shakeverifymessage_unread_index ON shakeverifymessage ( status )", "CREATE INDEX IF NOT EXISTS shakeverifymessage_statusIndex ON shakeverifymessage ( status )", "CREATE INDEX IF NOT EXISTS shakeverifymessage_createtimeIndex ON shakeverifymessage ( createtime )"};
    public static final String[] diD = new String[]{i.a(bo.dhO, "shakeverifymessage")};
    public e diF;

    public bp(e eVar) {
        super(eVar, bo.dhO, "shakeverifymessage", ciG);
        this.diF = eVar;
    }

    public final int axd() {
        Cursor b = this.diF.b("select count(*) from " + getTableName() + " where status != 4", null, 2);
        if (b.moveToFirst()) {
            int i = b.getInt(0);
            b.close();
            if (i > 0) {
                return i;
            }
            return 0;
        }
        b.close();
        return 0;
    }

    public final int getCount() {
        Cursor b = this.diF.b("select count(*) from " + getTableName(), null, 2);
        if (b.moveToFirst()) {
            int i = b.getInt(0);
            b.close();
            if (i > 0) {
                return i;
            }
            return 0;
        }
        b.close();
        return 0;
    }

    public final bo cna() {
        Cursor b = this.diF.b("SELECT * FROM " + getTableName() + " ORDER BY createtime DESC LIMIT 1", null, 2);
        if (b == null) {
            return null;
        }
        if (b.moveToFirst()) {
            bo boVar = new bo();
            boVar.d(b);
            b.close();
            return boVar;
        }
        b.close();
        return null;
    }

    public final void YP(String str) {
        int delete = this.diF.delete(getTableName(), "svrid = '" + str + "'", null);
        if (delete > 0) {
            doNotify();
        }
        x.i("MicroMsg.ShakeVerifyMessageStorage", "delBySvrId = " + delete);
    }

    public final void aPm() {
        this.diF.delete(getTableName(), null, null);
    }

    /* renamed from: a */
    public final boolean b(bo boVar) {
        if (boVar == null) {
            x.e("MicroMsg.ShakeVerifyMessageStorage", "insert fail, shakeMsg is null");
            return false;
        } else if (!super.b(boVar)) {
            return false;
        } else {
            Xp(boVar.sKx);
            return true;
        }
    }

    public final bo[] df(String str, int i) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.ShakeVerifyMessageStorage", "getLastRecvShakeMsg fail, talker is null");
            return null;
        }
        Cursor b = this.diF.b("select * from ShakeVerifyMessage where isSend = 0 and sayhiuser = '" + bi.oU(str) + "' order by createTime DESC limit " + i, null, 2);
        ArrayList arrayList = new ArrayList();
        while (b.moveToNext()) {
            bo boVar = new bo();
            boVar.d(b);
            arrayList.add(boVar);
        }
        b.close();
        if (arrayList.size() != 0) {
            return (bo[]) arrayList.toArray(new bo[arrayList.size()]);
        }
        return null;
    }

    public final bo[] Zp(String str) {
        x.d("MicroMsg.ShakeVerifyMessageStorage", "getLastShakeVerifyMessage");
        Cursor b = this.diF.b("select *, rowid from ShakeVerifyMessage  where sayhiuser = '" + bi.oU(str) + "' order by createtime DESC limit 3", null, 2);
        ArrayList arrayList = new ArrayList();
        while (b.moveToNext()) {
            bo boVar = new bo();
            boVar.d(b);
            arrayList.add(boVar);
        }
        b.close();
        if (arrayList.size() == 0) {
            return null;
        }
        return (bo[]) arrayList.toArray(new bo[arrayList.size()]);
    }

    public static long YT(String str) {
        long j;
        long VE;
        if (str != null) {
            bo cna = ((bp) ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).bcU()).cna();
            if (cna != null) {
                j = cna.field_createtime + 1;
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
