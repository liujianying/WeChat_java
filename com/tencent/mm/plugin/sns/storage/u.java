package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.mm.plugin.sns.b.k;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class u extends i<t> implements k {
    public static final String[] diD = new String[]{i.a(t.dhO, "snsTagInfo2")};
    private e diF;

    public u(e eVar) {
        super(eVar, t.dhO, "snsTagInfo2", null);
        this.diF = eVar;
    }

    public final t fk(long j) {
        Cursor b = this.diF.b("select *, rowid from snsTagInfo2 where tagId = ? ", new String[]{String.valueOf(j)}, 2);
        t tVar = new t();
        if (b.moveToFirst()) {
            tVar.d(b);
        }
        b.close();
        return tVar;
    }

    public final List<String> eD(long j) {
        t fk = fk(j);
        if (fk.field_memberList == null || fk.field_memberList.equals("")) {
            return new ArrayList();
        }
        return bi.F(fk.field_memberList.split(","));
    }

    public final String eE(long j) {
        return fk(j).field_tagName;
    }

    public final List<Long> bBG() {
        Cursor a = this.diF.a("snsTagInfo2", new String[]{"tagId"}, null, null, null, null, null, 2);
        List<Long> arrayList = new ArrayList();
        while (a.moveToNext()) {
            arrayList.add(Long.valueOf(a.getLong(0)));
        }
        a.close();
        return arrayList;
    }

    public final boolean a(t tVar) {
        if (tVar.field_tagId == 0) {
            return false;
        }
        long j = tVar.field_tagId;
        Cursor b = this.diF.b("select *, rowid from snsTagInfo2 where tagId = ? ", new String[]{String.valueOf(j)}, 2);
        boolean moveToFirst = b.moveToFirst();
        b.close();
        if (moveToFirst) {
            super.a(tVar);
        } else {
            super.b(tVar);
        }
        return true;
    }

    public final int fl(long j) {
        return this.diF.delete("snsTagInfo2", " tagId = ? ", new String[]{String.valueOf(j)});
    }

    public final boolean q(long j, String str) {
        String str2 = "select tagId, tagName, count, rowid from snsTagInfo2 where tagId > 5 AND  tagName  =\"" + bi.oU(str) + "\" AND  tagId != " + j;
        x.d("MicroMsg.SnsTagInfoStorage", "isTagNameExist " + str2);
        Cursor b = this.diF.b(str2, null, 2);
        boolean moveToFirst = b.moveToFirst();
        b.close();
        return moveToFirst;
    }

    public final Cursor getCursor() {
        return this.diF.rawQuery("select *, rowid from snsTagInfo2 where tagId > 5", null);
    }

    public final boolean Lz(String str) {
        t fk = fk(5);
        if (bi.oW(fk.field_memberList)) {
            return false;
        }
        return bi.F(fk.field_memberList.split(",")).contains(str);
    }

    public final boolean bwW() {
        if (bBG().size() == 0) {
            return false;
        }
        return true;
    }
}
