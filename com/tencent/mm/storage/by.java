package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.bt.g;
import com.tencent.mm.bt.g.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;

public final class by extends i<bx> implements a {
    public static final String[] diD = new String[]{i.a(bx.dhO, "VoiceTransText")};
    public e diF;

    public by(e eVar) {
        this(eVar, bx.dhO, "VoiceTransText");
    }

    private by(e eVar, c.a aVar, String str) {
        super(eVar, aVar, str, null);
        this.diF = eVar;
    }

    public final int a(g gVar) {
        if (gVar != null) {
            this.diF = gVar;
        }
        return 0;
    }

    /* renamed from: a */
    public final boolean b(bx bxVar) {
        if (bxVar == null) {
            return false;
        }
        if (this.diF.replace("VoiceTransText", "msgId", bxVar.wH()) >= 0) {
            return true;
        }
        return false;
    }

    public final bx Zs(String str) {
        if (bi.oW(str)) {
            return null;
        }
        bx bxVar = new bx();
        Cursor a = this.diF.a("VoiceTransText", null, "cmsgId=?", new String[]{str}, null, null, null, 2);
        if (a.moveToFirst()) {
            bxVar.d(a);
        }
        a.close();
        return bxVar;
    }
}
