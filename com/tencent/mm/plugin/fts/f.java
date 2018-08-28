package com.tencent.mm.plugin.fts;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.storage.ab;
import java.util.ArrayList;
import java.util.List;

public final class f implements j {
    public final Cursor h(String str, String[] strArr) {
        g.Ek();
        return g.Ei().dqr.b(str, strArr, 2);
    }

    public final Cursor rawQuery(String str, String[] strArr) {
        g.Ek();
        return g.Ei().dqr.b(str, strArr, 0);
    }

    public final ab Co(String str) {
        ab Yb = ((i) g.l(i.class)).FR().Yb(str);
        if (Yb == null) {
            Yb = new ab();
            Cursor h = h("SELECT ROWID, username, alias, conRemark, nickname, verifyFlag, type, lvbuff, contactLabelIds FROM rcontact WHERE username = ? AND deleteFlag=0;", new String[]{str});
            if (h.moveToNext()) {
                Yb.dhP = h.getLong(0);
                Yb.setUsername(h.getString(1));
                Yb.du(h.getString(2));
                Yb.dv(h.getString(3));
                Yb.dx(h.getString(4));
                Yb.eF(h.getInt(5));
                Yb.setType(h.getInt(6));
                Yb.B(h.getBlob(7));
                Yb.dE(h.getString(8));
                Yb.eH(0);
            }
            h.close();
        }
        return Yb;
    }

    public final boolean Cp(String str) {
        Cursor h = h(String.format("SELECT 1 FROM rconversation WHERE username = ?", new Object[0]), new String[]{str});
        try {
            boolean moveToNext = h.moveToNext();
            return moveToNext;
        } finally {
            if (h != null) {
                h.close();
            }
        }
    }

    public final long Cq(String str) {
        Cursor h = h("SELECT conversationTime FROM rconversation WHERE username=?;", new String[]{str});
        long j = 0;
        if (h != null && h.moveToFirst()) {
            j = h.getLong(0);
        }
        if (h != null) {
            h.close();
        }
        return j;
    }

    public final List<String> Cr(String str) {
        List arrayList = new ArrayList();
        if (str.endsWith("\u0000")) {
            str = str.substring(0, str.length() - 1);
        }
        if (str.length() != 0) {
            Cursor h = h(String.format("SELECT labelName FROM ContactLabel WHERE labelID IN (%s);", new Object[]{str}), null);
            while (h.moveToNext()) {
                arrayList.add(h.getString(0));
            }
            h.close();
        }
        return arrayList;
    }
}
