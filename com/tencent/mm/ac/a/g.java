package com.tencent.mm.ac.a;

import android.database.Cursor;
import com.tencent.mm.g.c.x;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.bi;

public final class g extends i<x> {
    public static final String[] diD = new String[]{i.a(f.dhO, "BizChatMyUserInfo")};
    private final k<a, b> dKC = new 1(this);
    private e diF;

    public g(e eVar) {
        super(eVar, f.dhO, "BizChatMyUserInfo", null);
        this.diF = eVar;
        eVar.fV("BizChatMyUserInfo", "CREATE INDEX IF NOT EXISTS bizChatbrandUserNameIndex ON BizChatMyUserInfo ( brandUserName )");
    }

    public final f lk(String str) {
        if (bi.oW(str)) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.BizChatMyUserInfoStorage", "get： wrong argument");
            return null;
        }
        f fVar = new f();
        fVar.field_brandUserName = str;
        super.b(fVar, new String[0]);
        return fVar;
    }

    public final boolean ll(String str) {
        boolean z = false;
        if (bi.oW(str)) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.BizChatMyUserInfoStorage", "delete wrong argument");
        } else {
            f fVar = new f();
            fVar.field_brandUserName = str;
            z = super.a(fVar, new String[]{"brandUserName"});
            if (z) {
                b bVar = new b();
                bVar.bKC = fVar.field_brandUserName;
                bVar.dNC = a.dNz;
                bVar.dND = fVar;
                this.dKC.ci(bVar);
                this.dKC.doNotify();
            }
        }
        return z;
    }

    public final boolean a(f fVar) {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.BizChatMyUserInfoStorage", "BizChatMyUserInfoStorage insert");
        boolean b = super.b(fVar);
        if (b) {
            b bVar = new b();
            bVar.bKC = fVar.field_brandUserName;
            bVar.dNC = a.dNy;
            bVar.dND = fVar;
            this.dKC.ci(bVar);
            this.dKC.doNotify();
        } else {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.BizChatMyUserInfoStorage", "BizChatMyUserInfoStorage insert fail");
        }
        return b;
    }

    public final boolean b(f fVar) {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.BizChatMyUserInfoStorage", "BizChatMyUserInfoStorage update");
        if (fVar == null) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.BizChatMyUserInfoStorage", "update wrong argument");
            return false;
        }
        boolean a = super.a(fVar);
        if (a) {
            b bVar = new b();
            bVar.bKC = fVar.field_brandUserName;
            bVar.dNC = a.dNA;
            bVar.dND = fVar;
            this.dKC.ci(bVar);
            this.dKC.doNotify();
            return a;
        }
        com.tencent.mm.sdk.platformtools.x.w("MicroMsg.BizChatMyUserInfoStorage", "BizChatMyUserInfoStorage update fail");
        return a;
    }

    public final int getCount() {
        int i = 0;
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.BizChatMyUserInfoStorage", "BizChatMyUserInfoStorage getCount");
        Cursor b = this.diF.b("SELECT COUNT(*) FROM BizChatMyUserInfo", null, 2);
        if (b.moveToFirst()) {
            i = b.getInt(0);
        }
        b.close();
        return i;
    }
}
