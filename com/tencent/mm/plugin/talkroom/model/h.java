package com.tencent.mm.plugin.talkroom.model;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.ab;

public final class h {
    private static final int ovJ = a.ovJ;

    public static String aJ(Context context, String str) {
        if (bi.oW(str)) {
            return null;
        }
        au.HU();
        ab Yg = c.FR().Yg(str);
        if (Yg == null) {
            return null;
        }
        if (!s.fq(str)) {
            return r.gT(str);
        }
        if (bi.oW(Yg.field_nickname)) {
            return context.getString(R.l.talk_room_tilte);
        }
        return Yg.BK();
    }
}
