package com.tencent.mm.plugin.sns.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends i<e> {
    public static final String[] ciG = new String[]{"CREATE INDEX IF NOT EXISTS serverAdSnsNameIndex ON AdSnsInfo ( snsId )", "CREATE INDEX IF NOT EXISTS serverAdSnsTimeHeadIndex ON AdSnsInfo ( head )", "DROP INDEX IF EXISTS serverAdSnsTimeIndex", "DROP INDEX IF EXISTS serverAdSnsTimeSourceTypeIndex", "CREATE INDEX IF NOT EXISTS adsnsMultiIndex1 ON AdSnsInfo ( createTime,snsId,sourceType,type)", "CREATE INDEX IF NOT EXISTS adsnsMultiIndex2 ON AdSnsInfo ( sourceType,type,userName)"};
    public static final String[] diD = new String[]{i.a(e.dhO, "adsnsinfo")};
    private static final String nJf = String.format("select  %s %s,rowid from AdSnsInfo ", new Object[]{"snsId", "createTime"});
    public e diF;

    public f(e eVar) {
        super(eVar, e.dhO, "adsnsinfo", ciG);
        this.diF = eVar;
    }

    public final e eZ(long j) {
        e eVar = new e();
        Cursor b = this.diF.b("select *,rowid from AdSnsInfo  where AdSnsInfo.snsId=" + j, null, 2);
        if (b.moveToFirst()) {
            eVar.d(b);
            b.close();
            return eVar;
        }
        b.close();
        return null;
    }

    public final e xa(int i) {
        e eVar = new e();
        Cursor b = this.diF.b("select *,rowid from AdSnsInfo  where AdSnsInfo.rowid=" + i, null, 2);
        if (b.moveToFirst()) {
            eVar.d(b);
            b.close();
            return eVar;
        }
        b.close();
        return null;
    }

    public final boolean a(long j, e eVar) {
        if (fa(j)) {
            return a(j, eVar);
        }
        int i;
        x.d("MicroMsg.AdSnsInfoStorage", "added PcId " + j);
        x.d("MicroMsg.AdSnsInfoStorage", "SnsInfo Insert");
        if (eVar == null) {
            i = -1;
        } else {
            i = (int) this.diF.insert("AdSnsInfo", "", eVar.wH());
            x.d("MicroMsg.AdSnsInfoStorage", "SnsInfo Insert result" + i);
        }
        return i != -1;
    }

    /* renamed from: b */
    public final boolean a(long j, e eVar) {
        ContentValues wH = eVar.wH();
        wH.remove("rowid");
        if (this.diF.update("AdSnsInfo", wH, "snsId=?", new String[]{String.valueOf(j)}) > 0) {
            return true;
        }
        return false;
    }

    public final boolean fa(long j) {
        Cursor b = this.diF.b("select *,rowid from AdSnsInfo  where AdSnsInfo.snsId=" + j, null, 2);
        boolean moveToFirst = b.moveToFirst();
        b.close();
        return moveToFirst;
    }

    public final boolean delete(long j) {
        int delete = this.diF.delete("AdSnsInfo", "snsId=?", new String[]{String.valueOf(j)});
        x.i("MicroMsg.AdSnsInfoStorage", "del msg " + j + " res " + delete);
        if (delete > 0) {
            return true;
        }
        return false;
    }
}
