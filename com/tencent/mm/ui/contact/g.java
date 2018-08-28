package com.tencent.mm.ui.contact;

import android.database.Cursor;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.storage.ai;
import java.util.ArrayList;
import java.util.List;

public final class g {
    static final List<String> dR(List<String> list) {
        List<String> arrayList = new ArrayList();
        Cursor a = ((i) com.tencent.mm.kernel.g.l(i.class)).FW().a(s.dAN, list, true, null);
        if (a.moveToFirst()) {
            int i = 0;
            do {
                ai aiVar = new ai();
                aiVar.d(a);
                if (NY(aiVar.field_username)) {
                    arrayList.add(aiVar.field_username);
                    i++;
                    if (i >= 4) {
                        break;
                    }
                }
            } while (a.moveToNext());
        }
        a.close();
        return arrayList;
    }

    private static final boolean NY(String str) {
        for (Object equals : s.dAV) {
            if (str.equals(equals)) {
                return false;
            }
        }
        if (s.fq(str) || s.hf(str)) {
            return false;
        }
        return true;
    }
}
