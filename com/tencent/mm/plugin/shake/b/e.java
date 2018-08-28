package com.tencent.mm.plugin.shake.b;

import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends i<d> {
    public static final String[] diD = new String[]{i.a(d.dhO, "shakeitem1")};
    public com.tencent.mm.sdk.e.e diF;

    public final /* synthetic */ boolean b(c cVar) {
        return a((d) cVar, false);
    }

    public e(com.tencent.mm.sdk.e.e eVar) {
        super(eVar, d.dhO, "shakeitem1", null);
        this.diF = eVar;
        x.d("MicroMsg.NewShakeItemStorage", "ShakeItemStorage");
        eVar.fV("shakeitem1", "DROP INDEX IF EXISTS shakeItemUsernameIndex ");
        eVar.fV("shakeitem1", "CREATE INDEX IF NOT EXISTS shakeItemNewUsernameIndex ON shakeitem1 ( username )");
    }

    public final Cursor bur() {
        return rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? order by shakeItemID desc ", new String[]{"4"});
    }

    public final d bus() {
        d dVar = new d();
        Cursor rawQuery = rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   order by shakeItemID desc limit 1", new String[0]);
        if (rawQuery.getCount() != 0) {
            rawQuery.moveToFirst();
            dVar.d(rawQuery);
        }
        rawQuery.close();
        return dVar;
    }

    public final boolean a(d dVar, boolean z) {
        if (dVar == null) {
            return false;
        }
        if (!(z || bi.oW(dVar.field_username))) {
            Lb(dVar.field_username);
        }
        dVar.bWA = -1;
        return super.b(dVar);
    }

    public final int vT(int i) {
        int delete = this.diF.delete("shakeitem1", "shakeItemID=?", new String[]{String.valueOf(i)});
        doNotify();
        x.i("MicroMsg.NewShakeItemStorage", "delById id:" + i + " result:" + delete);
        return delete;
    }

    public final int Lb(String str) {
        int delete = this.diF.delete("shakeitem1", "(username=?)", new String[]{str});
        if (delete > 0) {
            doNotify();
        }
        x.i("MicroMsg.NewShakeItemStorage", "delByusername:" + str + " result:" + delete);
        return delete;
    }

    public final boolean vU(int i) {
        boolean fV;
        if (i == 0) {
            fV = this.diF.fV("shakeitem1", "delete from shakeitem1 where type = " + i + " or type is null");
        } else {
            fV = this.diF.fV("shakeitem1", "delete from shakeitem1 where type = " + i);
        }
        doNotify();
        return fV;
    }

    public final boolean but() {
        boolean fV = this.diF.fV("shakeitem1", "delete from shakeitem1");
        doNotify();
        return fV;
    }

    public final void buu() {
        x.i("MicroMsg.NewShakeItemStorage", "setAllOld");
        d dVar = new d();
        dVar.field_insertBatch = 0;
        dVar.bWA = 1024;
        if (-1 != this.diF.update("shakeitem1", dVar.wH(), "insertBatch!=?", new String[]{"0"})) {
            doNotify();
        }
    }
}
