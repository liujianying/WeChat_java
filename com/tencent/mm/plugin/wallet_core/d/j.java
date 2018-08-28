package com.tencent.mm.plugin.wallet_core.d;

import android.database.Cursor;
import com.tencent.mm.plugin.wallet_core.model.af;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class j extends i<af> {
    public static final String[] diD = new String[]{i.a(af.dhO, "WalletUserInfo")};
    private List<Object> avD = new LinkedList();
    public e diF;

    public final /* synthetic */ boolean a(c cVar, String[] strArr) {
        if (!super.a((af) cVar, strArr)) {
            return false;
        }
        Iterator it = this.avD.iterator();
        while (it.hasNext()) {
            it.next();
        }
        return true;
    }

    public final /* synthetic */ boolean c(c cVar, String[] strArr) {
        if (!super.c((af) cVar, strArr)) {
            return false;
        }
        Iterator it = this.avD.iterator();
        while (it.hasNext()) {
            it.next();
        }
        return true;
    }

    public j(e eVar) {
        super(eVar, af.dhO, "WalletUserInfo", null);
        x.i("MicroMsg.WalletUserInfoStorage", "already call constructor.");
        this.diF = eVar;
    }

    public final af bPU() {
        af afVar = new af();
        Cursor b = this.diF.b("select * from WalletUserInfo", null, 2);
        afVar.field_is_reg = -1;
        if (b != null) {
            if (b.moveToNext()) {
                afVar.d(b);
            }
            b.close();
        }
        return afVar;
    }

    /* renamed from: a */
    public final boolean b(af afVar) {
        if (!super.b(afVar)) {
            return false;
        }
        Iterator it = this.avD.iterator();
        while (it.hasNext()) {
            it.next();
        }
        return true;
    }
}
