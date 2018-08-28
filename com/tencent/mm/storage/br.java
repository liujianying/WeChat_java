package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.x;

public final class br extends i<bq> implements k {
    public static final String[] diD = new String[]{i.a(bq.dhO, "Stranger")};
    private e diF;
    private final com.tencent.mm.sdk.e.k<a, bq> sNT = new com.tencent.mm.sdk.e.k<a, bq>() {
    };

    private void b(bq bqVar) {
        if (this.sNT.ci(bqVar)) {
            this.sNT.doNotify();
        }
    }

    public final void a(a aVar) {
        this.sNT.a(aVar, null);
    }

    public final void b(a aVar) {
        this.sNT.remove(aVar);
    }

    public br(e eVar) {
        super(eVar, bq.dhO, "Stranger", null);
        this.diF = eVar;
    }

    public final bq Hh(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        bq bqVar = new bq();
        Cursor a = this.diF.a("Stranger", null, "encryptUsername = ?", new String[]{str}, null, null, null, 2);
        if (a.moveToFirst()) {
            bqVar.d(a);
        }
        a.close();
        return bqVar;
    }

    public final int Hi(String str) {
        int delete = this.diF.delete("Stranger", "(encryptUsername=?)", new String[]{str});
        if (delete > 0) {
            doNotify();
        }
        x.i("MicroMsg.StrangerStorage", "delByEncryptUsername:" + str + " result:" + delete);
        return delete;
    }
}
