package com.tencent.mm.plugin.wallet_core.d;

import android.database.Cursor;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c extends i<Bankcard> {
    public static final String[] diD = new String[]{i.a(Bankcard.dhO, "WalletBankcard")};
    private List<Object> avD = new LinkedList();
    public e diF;

    public final /* synthetic */ boolean a(com.tencent.mm.sdk.e.c cVar, String[] strArr) {
        if (!super.a((Bankcard) cVar, strArr)) {
            return false;
        }
        Iterator it = this.avD.iterator();
        while (it.hasNext()) {
            it.next();
        }
        return true;
    }

    public final /* synthetic */ boolean c(com.tencent.mm.sdk.e.c cVar, String[] strArr) {
        if (!super.c((Bankcard) cVar, strArr)) {
            return false;
        }
        Iterator it = this.avD.iterator();
        while (it.hasNext()) {
            it.next();
        }
        return true;
    }

    public c(e eVar) {
        super(eVar, Bankcard.dhO, "WalletBankcard", null);
        this.diF = eVar;
    }

    public final ArrayList<Bankcard> bPD() {
        ArrayList<Bankcard> arrayList = null;
        Cursor b = this.diF.b("select * from WalletBankcard where cardType <= 7", null, 2);
        if (b != null) {
            if (b.moveToFirst()) {
                arrayList = new ArrayList();
                do {
                    Bankcard bankcard = new Bankcard();
                    bankcard.d(b);
                    arrayList.add(bankcard);
                } while (b.moveToNext());
            }
            b.close();
        }
        return arrayList;
    }

    public final ArrayList<Bankcard> bPS() {
        ArrayList<Bankcard> arrayList = null;
        Cursor b = this.diF.b("select * from WalletBankcard where cardType & " + Bankcard.plK + " != 0 ", null, 2);
        if (b != null) {
            if (b.moveToFirst()) {
                arrayList = new ArrayList();
                do {
                    Bankcard bankcard = new Bankcard();
                    bankcard.d(b);
                    arrayList.add(bankcard);
                } while (b.moveToNext());
            }
            b.close();
        }
        return arrayList;
    }

    public final boolean cG(List<Bankcard> list) {
        for (Bankcard b : list) {
            super.b(b);
        }
        Iterator it = this.avD.iterator();
        while (it.hasNext()) {
            it.next();
        }
        return true;
    }

    /* renamed from: e */
    public final boolean b(Bankcard bankcard) {
        if (!super.b(bankcard)) {
            return false;
        }
        Iterator it = this.avD.iterator();
        while (it.hasNext()) {
            it.next();
        }
        return true;
    }
}
