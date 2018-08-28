package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.x;

public final class bi extends i<bh> {
    public static final String[] diD = new String[]{i.a(bh.dhO, "NewTipsInfo")};
    public e diF;

    public bi(e eVar) {
        super(eVar, bh.dhO, "NewTipsInfo", null);
        this.diF = eVar;
    }

    /* renamed from: f */
    public final boolean b(bh bhVar) {
        boolean z = false;
        if (bhVar == null) {
            x.e("MicroMsg.NewTipsInfoStorage", "NewTipsInfo is null!");
        } else if (bhVar.field_tipId <= 0) {
            x.e("MicroMsg.NewTipsInfoStorage", "newTipsId is error, tipsId = %s", Integer.valueOf(bhVar.field_tipId));
        } else {
            z = a((c) bhVar, false);
            if (z) {
                b(bhVar.field_tipId, 2, Integer.valueOf(bhVar.field_tipId));
            }
        }
        return z;
    }

    /* renamed from: a */
    public final boolean c(bh bhVar, String... strArr) {
        if (bhVar == null) {
            x.e("MicroMsg.NewTipsInfoStorage", "NewTipsInfo is null!");
            return false;
        }
        boolean b = super.b(bhVar, false, strArr);
        if (b) {
            b(bhVar.field_tipId, 3, Integer.valueOf(bhVar.field_tipId));
        }
        x.d("MicroMsg.NewTipsInfoStorage", "update result[%B]", Boolean.valueOf(b));
        return b;
    }

    public final bh Do(int i) {
        if (this.diF == null) {
            x.e("MicroMsg.NewTipsInfoStorage", "getByTipsId, but db is null, return");
            return null;
        }
        Cursor a = this.diF.a("NewTipsInfo", null, "tipId=?", new String[]{String.valueOf(i)}, null, null, null, 2);
        if (a.moveToFirst()) {
            bh bhVar = new bh();
            try {
                bhVar.d(a);
                a.close();
                return bhVar;
            } catch (Exception e) {
                x.e("MicroMsg.NewTipsInfoStorage", "getByTipsId convertFrom(cu) cause IlleagalStateException, return null");
                a.close();
                return null;
            }
        }
        x.w("MicroMsg.NewTipsInfoStorage", "getByTipsId:%d, no data", Integer.valueOf(i));
        a.close();
        return null;
    }
}
