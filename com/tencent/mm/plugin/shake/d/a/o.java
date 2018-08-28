package com.tencent.mm.plugin.shake.d.a;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;

public final class o extends i<n> {
    public static final String[] ciG = new String[0];
    public static final String[] diD = new String[]{i.a(n.dhO, "shaketvhistory")};
    public e diF;

    public o(e eVar) {
        super(eVar, n.dhO, "shaketvhistory", diD);
        this.diF = eVar;
    }

    public final Cursor bvi() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT * FROM shaketvhistory ORDER BY createtime DESC");
        return this.diF.rawQuery(stringBuilder.toString(), null);
    }
}
