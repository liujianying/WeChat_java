package com.tencent.mm.plugin.card.model;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;

public final class h extends i<g> {
    public static final String[] diD = new String[]{i.a(g.dhO, "CardMsgInfo")};
    public e diF;

    public h(e eVar) {
        super(eVar, g.dhO, "CardMsgInfo", null);
        this.diF = eVar;
    }

    public final Cursor axc() {
        return this.diF.rawQuery("select * from CardMsgInfo order by time desc", null);
    }

    public final int axd() {
        int i = 0;
        Cursor b = this.diF.b(" select count(*) from CardMsgInfo where read_state = ? ", new String[]{"1"}, 2);
        if (b != null) {
            if (b.moveToFirst()) {
                i = b.getInt(0);
            }
            b.close();
        }
        return i;
    }

    public final boolean axe() {
        return this.diF.fV("CardMsgInfo", " update CardMsgInfo set read_state = 0  where read_state = 1");
    }
}
