package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.mm.bt.h;
import com.tencent.mm.g.c.dv;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class k extends i<j> implements d {
    public static final String[] diD = new String[]{i.a(j.dhO, "SnsComment")};
    public h dCZ;

    public k(h hVar) {
        super(hVar, j.dhO, "SnsComment", dv.ciG);
        this.dCZ = hVar;
    }

    public static String bAO() {
        return "select *, rowid from SnsComment";
    }

    public final int axd() {
        int i = 0;
        Cursor b = this.dCZ.b(" select count(*) from SnsComment where isRead = ? and isSilence != ? ", new String[]{"0", "1"}, 2);
        if (b != null) {
            if (b.moveToFirst()) {
                i = b.getInt(0);
            }
            b.close();
        }
        return i;
    }

    public final Cursor bAP() {
        return this.dCZ.b("select *, rowid from SnsComment where isRead = ?  and isSilence != ?  order by createTime desc", new String[]{"0", "1"}, 0);
    }

    public final boolean a(long j, String str, int i, String str2) {
        String str3;
        if (bi.oW(str2)) {
            str3 = "select count(*) from SnsComment where snsID = " + j + " and createTime = " + i + " and talker = '" + str + "'";
        } else {
            str3 = "select count(*) from SnsComment where snsID = " + j + " and clientId = '" + str2 + "'";
        }
        Cursor rawQuery = rawQuery(str3, new String[0]);
        if (rawQuery == null) {
            return false;
        }
        rawQuery.moveToFirst();
        int i2 = rawQuery.getInt(0);
        rawQuery.close();
        if (i2 > 0) {
            return true;
        }
        return false;
    }

    public final int bAQ() {
        Cursor rawQuery = rawQuery("select count(*) from SnsComment where isSend = 0", new String[0]);
        if (rawQuery == null) {
            return 0;
        }
        rawQuery.moveToFirst();
        int i = rawQuery.getInt(0);
        rawQuery.close();
        return i;
    }

    public final j c(long j, long j2, int i) {
        int i2;
        if (i == 9) {
            i2 = 2;
        } else {
            i2 = i;
        }
        if (i2 == 10) {
            i2 = 8;
        }
        Cursor rawQuery = rawQuery("select *, rowid from SnsComment where snsID = " + j + " and commentSvrID = " + j2 + " and type = " + i2, new String[0]);
        if (rawQuery == null) {
            return null;
        }
        j jVar;
        if (rawQuery.moveToFirst()) {
            jVar = new j();
            jVar.d(rawQuery);
        } else {
            jVar = null;
        }
        rawQuery.close();
        return jVar;
    }

    public final boolean fd(long j) {
        return this.dCZ.fV("SnsComment", "delete from SnsComment where snsID = " + j);
    }

    public final boolean d(long j, long j2, int i) {
        int i2;
        if (i == 9) {
            i2 = 2;
        } else {
            i2 = i;
        }
        if (i2 == 10) {
            i2 = 8;
        }
        return this.dCZ.fV("SnsComment", "delete from SnsComment where snsID = " + j + " and commentSvrID = " + j2 + " and type = " + i2);
    }

    public final boolean axe() {
        return this.dCZ.fV("SnsComment", " update SnsComment set isRead = 1 where isRead = 0");
    }

    public final boolean s(long j, boolean z) {
        int i = z ? 1 : 0;
        String str = " update SnsComment set isSilence = " + i + " where isSilence != " + i + " and  snsID = " + j;
        x.i("MicroMsg.SnsCommentStorage", "updateIsSilence " + str);
        return this.dCZ.fV("SnsComment", str);
    }

    public final void bAR() {
        this.dCZ.ZM("SnsComment");
    }
}
