package com.tencent.mm.plugin.shake.b;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.x;

public final class g extends i<f> {
    public static final String[] ciG = new String[]{"CREATE INDEX IF NOT EXISTS  shakemessage_status_index ON shakemessage ( status )", "CREATE INDEX IF NOT EXISTS shakemessage_type_index ON shakemessage ( type )"};
    public static final String[] diD = new String[]{i.a(f.dhO, "shakemessage")};
    public e diF;

    public g(e eVar) {
        super(eVar, f.dhO, "shakemessage", ciG);
        this.diF = eVar;
    }

    /* renamed from: a */
    public final boolean b(f fVar) {
        if (fVar == null) {
            x.e("MicroMsg.ShakeMessageStorage", "insert fail, shakeMsg is null");
            return false;
        } else if (!super.b(fVar)) {
            return false;
        } else {
            Xp(fVar.sKx);
            return true;
        }
    }

    public final int axd() {
        int i;
        Cursor b = this.diF.b("select count(*) from " + getTableName() + " where status != 1", null, 2);
        if (b.moveToFirst()) {
            i = b.getInt(0);
        } else {
            i = 0;
        }
        b.close();
        return i > 0 ? i : 0;
    }
}
