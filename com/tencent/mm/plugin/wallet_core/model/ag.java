package com.tencent.mm.plugin.wallet_core.model;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.wallet_core.d.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ag {
    public int mRetryCount = 0;
    public Bankcard paw = null;
    public ArrayList<Bankcard> pcZ = new ArrayList();
    ArrayList<Bankcard> pda = new ArrayList();
    public af prA = null;
    public Bankcard prB = null;
    ae prC = null;
    public k prD = null;
    public b prE = null;
    private List<c> prF = new LinkedList();
    public Bankcard prG = null;
    public long prH = bi.VE();
    long prI = 0;
    public long prJ = -1;
    private String prK = "";
    public int prL = 10000;
    public String prM = "";
    public String prN = "";
    private ArrayList<Bankcard> pry = new ArrayList();
    private ArrayList<Bankcard> prz = new ArrayList();

    public ag() {
        bPB();
    }

    public final boolean bPr() {
        return this.prA == null || (this.prA != null && this.prA.bPq());
    }

    public final boolean bPs() {
        if (this.prA != null) {
            if (this.prA.field_is_reg == 1) {
                return true;
            }
        }
        return false;
    }

    public final boolean bPp() {
        return this.prA != null && this.prA.bPp();
    }

    public final boolean bPt() {
        if (this.prA != null) {
            if (this.prA.field_is_reg == 2) {
                return true;
            }
        }
        return false;
    }

    public final boolean bPu() {
        if (this.prA != null) {
            if (this.prA.field_is_open_touch == 1) {
                return true;
            }
        }
        return false;
    }

    public final String bPv() {
        if (this.prA != null) {
            return this.prA.field_ftf_pay_url;
        }
        return null;
    }

    public final ae bPw() {
        if (this.prC == null) {
            return new ae();
        }
        return this.prC;
    }

    public final boolean bPx() {
        return this.prA != null && this.prA.field_isDomesticUser;
    }

    public final String aCl() {
        if (this.prA != null) {
            return this.prA.field_true_name;
        }
        return null;
    }

    public final int bPy() {
        if (this.prA != null) {
            return this.prA.field_cre_type;
        }
        return 1;
    }

    public final String bPz() {
        g.Ek();
        String str = (String) g.Ei().DT().get(a.sYx, null);
        if (bi.oW(str)) {
            return this.prA != null ? this.prA.field_lct_wording : null;
        } else {
            return str;
        }
    }

    public final String bPA() {
        if (this.prA != null) {
            return this.prA.field_lct_url;
        }
        return null;
    }

    public final void bPB() {
        k kVar = null;
        if (g.Eg().Dx()) {
            Bankcard bankcard;
            this.prA = o.bOS().bPU();
            if (this.prA != null) {
                this.prC = new ae(this.prA.field_switchConfig);
            } else {
                this.prC = new ae();
            }
            c bOU = o.bOU();
            Cursor b = bOU.diF.b("select * from WalletBankcard where cardType & " + Bankcard.plL + " != 0 ", null, 2);
            if (b == null) {
                bankcard = null;
            } else {
                if (b.moveToFirst()) {
                    bankcard = new Bankcard();
                    bankcard.d(b);
                } else {
                    bankcard = null;
                }
                b.close();
            }
            this.paw = bankcard;
            bOU = o.bOU();
            b = bOU.diF.b("select * from WalletBankcard where cardType & " + Bankcard.plO + " != 0 ", null, 2);
            if (b == null) {
                bankcard = null;
            } else {
                if (b.moveToFirst()) {
                    bankcard = new Bankcard();
                    bankcard.d(b);
                } else {
                    bankcard = null;
                }
                b.close();
            }
            this.prG = bankcard;
            e.a("wallet_balance", new 1(this));
            this.pcZ = o.bOU().bPD();
            this.pda = o.bOU().bPS();
            bOU = o.bOU();
            b = bOU.diF.b("select * from WalletBankcard where cardType & " + Bankcard.plM + " != 0 ", null, 2);
            if (b == null) {
                bankcard = null;
            } else {
                if (b.moveToNext()) {
                    bankcard = new Bankcard();
                    bankcard.d(b);
                } else {
                    bankcard = null;
                }
                b.close();
            }
            this.prB = bankcard;
            Cursor b2 = o.bOY().diF.b("select * from LoanEntryInfo", null, 2);
            if (b2 != null) {
                if (b2.moveToFirst()) {
                    kVar = new k();
                    kVar.d(b2);
                }
                b2.close();
            }
            this.prD = kVar;
            x.i("MicroMsg.WalletUserInfoManger", "loadDbData!");
            bPI();
            return;
        }
        x.w("MicroMsg.WalletUserInfoManger", "Account Not Ready!");
    }

    public final boolean bPC() {
        if (af.eyi) {
            return true;
        }
        g.Ek();
        int intValue = ((Integer) g.Ei().DT().get(a.sYw, Integer.valueOf(-1))).intValue();
        if (intValue != -1) {
            return intValue == 1;
        } else {
            if (this.prA != null) {
                return this.prA.field_lqt_state == 1;
            } else {
                return false;
            }
        }
    }

    public final void aMk() {
        if (this.prA != null) {
            this.prA.field_is_reg = -1;
            this.prA = null;
        }
        if (this.prC != null) {
            this.prC = null;
        }
        if (this.paw != null) {
            this.paw = null;
        }
        if (this.pcZ != null) {
            this.pcZ.clear();
            this.pcZ = null;
        }
        if (this.pda != null) {
            this.pda.clear();
            this.pda = null;
        }
        this.prI = 0;
        e.a(new e.c[]{new e.c("wallet_balance_version", Integer.valueOf(-1)), new e.c("wallet_balance_last_update_time", Integer.valueOf(-1)), new e.c("wallet_balance", Integer.valueOf(-1))});
        this.prH = bi.VE();
    }

    public final ArrayList<Bankcard> bPD() {
        if (this.pcZ == null || this.pcZ.size() <= 0) {
            this.pcZ = o.bOU().bPD();
        }
        if (this.pcZ == null || this.pcZ.size() <= 0) {
            return null;
        }
        ArrayList<Bankcard> arrayList = new ArrayList();
        Iterator it = this.pcZ.iterator();
        while (it.hasNext()) {
            arrayList.add((Bankcard) it.next());
        }
        return arrayList;
    }

    public final List<c> bPE() {
        if (this.prF != null) {
            this.prF.size();
        }
        if (this.prF == null || this.prF.size() <= 0) {
            return null;
        }
        return this.prF;
    }

    public final ArrayList<Bankcard> bPF() {
        if (this.pcZ == null || this.pcZ.size() <= 0) {
            return null;
        }
        ArrayList<Bankcard> arrayList = new ArrayList();
        Iterator it = this.pcZ.iterator();
        while (it.hasNext()) {
            Bankcard bankcard = (Bankcard) it.next();
            if (!(bankcard.bOu() || bankcard.bOw())) {
                arrayList.add(bankcard);
            }
        }
        return arrayList;
    }

    public final ArrayList<Bankcard> jl(boolean z) {
        ArrayList<Bankcard> arrayList = new ArrayList();
        if (z) {
            if (!(this.paw == null || bPp())) {
                arrayList.add(this.paw);
            }
            if (!(this.prG == null || bPp())) {
                arrayList.add(this.prG);
            }
        }
        if (this.pcZ != null && this.pcZ.size() > 0) {
            Iterator it = this.pcZ.iterator();
            while (it.hasNext()) {
                arrayList.add((Bankcard) it.next());
            }
        }
        return arrayList;
    }

    public final ArrayList<Bankcard> jt(boolean z) {
        ArrayList<Bankcard> arrayList = new ArrayList();
        if (z) {
            if (!(this.paw == null || bPp())) {
                arrayList.add(this.paw);
            }
            if (!(this.prG == null || bPp())) {
                arrayList.add(this.prG);
            }
        }
        Iterator it;
        if (this.pry != null && this.pcZ != null && this.pry.size() == this.pcZ.size() && this.pry.size() > 0) {
            it = this.pry.iterator();
            while (it.hasNext()) {
                arrayList.add((Bankcard) it.next());
            }
        } else if (this.pcZ != null && this.pcZ.size() > 0) {
            it = this.pcZ.iterator();
            while (it.hasNext()) {
                arrayList.add((Bankcard) it.next());
            }
        }
        return arrayList;
    }

    public final ArrayList<Bankcard> bPG() {
        ArrayList<Bankcard> arrayList = new ArrayList();
        if (!(this.paw == null || bPp())) {
            arrayList.add(this.paw);
        }
        if (!(this.prz == null || this.pcZ == null || this.prz.size() <= 0)) {
            Iterator it = this.prz.iterator();
            while (it.hasNext()) {
                Bankcard bankcard = (Bankcard) it.next();
                if (!bankcard.bOw()) {
                    arrayList.add(bankcard);
                }
            }
        }
        return arrayList;
    }

    public final void f(ArrayList<Bankcard> arrayList, ArrayList<Bankcard> arrayList2) {
        if (this.pcZ == null || arrayList == null || arrayList2 == null) {
            x.e("MicroMsg.WalletUserInfoManger", "error list, bankcards == null || bankcardsClone == null || virtualBankcardsClone == null");
            return;
        }
        Iterator it;
        arrayList.clear();
        arrayList2.clear();
        if (this.pcZ != null) {
            it = this.pcZ.iterator();
            while (it.hasNext()) {
                arrayList.add((Bankcard) it.next());
            }
        }
        if (this.pda != null) {
            it = this.pda.iterator();
            while (it.hasNext()) {
                Bankcard bankcard = (Bankcard) it.next();
                if (bankcard.field_wxcreditState == 0) {
                    arrayList2.add(bankcard);
                } else {
                    arrayList.add(bankcard);
                }
            }
        }
    }

    public static boolean cD(List<Bankcard> list) {
        if (list.size() == 0) {
            return false;
        }
        g.Ek();
        String str = (String) g.Ei().DT().get(196659, null);
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        String[] split = str.split("&");
        if (split == null || split.length == 0) {
            return true;
        }
        int i = 0;
        for (Object obj : split) {
            if (!TextUtils.isEmpty(obj)) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    Bankcard bankcard = (Bankcard) list.get(i2);
                    if (bankcard != null && obj.equals(bankcard.field_bankcardType)) {
                        i++;
                        break;
                    }
                }
            }
        }
        if (i < list.size()) {
            return true;
        }
        return false;
    }

    public final boolean Pb(String str) {
        if (bi.oW(str)) {
            return false;
        }
        Iterator it;
        Bankcard bankcard;
        if (this.pcZ != null) {
            it = this.pcZ.iterator();
            while (it.hasNext()) {
                bankcard = (Bankcard) it.next();
                if (str.equals(bankcard.field_bankcardType) && bankcard.bOr()) {
                    return false;
                }
            }
        }
        if (this.pda != null) {
            it = this.pda.iterator();
            while (it.hasNext()) {
                bankcard = (Bankcard) it.next();
                if (str.equals(bankcard.field_bankcardType) && bankcard.field_bankcardState == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public final void a(af afVar, ArrayList<Bankcard> arrayList, ArrayList<Bankcard> arrayList2, Bankcard bankcard, Bankcard bankcard2, k kVar, b bVar, Bankcard bankcard3, int i, int i2, List<c> list) {
        x.i("MicroMsg.WalletUserInfoManger", "setBankcards scene %d", new Object[]{Integer.valueOf(i2)});
        if (i2 == 8) {
            this.pry = arrayList;
        }
        if (i2 == 24 || i2 == 25) {
            this.prz = arrayList;
        }
        this.prF = list;
        this.prA = afVar;
        this.pcZ = arrayList;
        this.pda = arrayList2;
        this.paw = bankcard;
        this.prC = new ae(afVar.field_switchConfig);
        this.prB = bankcard2;
        this.prD = kVar;
        this.prE = bVar;
        this.prG = bankcard3;
        x.i("MicroMsg.WalletUserInfoManger", "setBankcards()! " + afVar.field_switchConfig);
        bPI();
        if (i < 0) {
            i = Downloads.DOWNLOAD_ERR_INTERRUPTED;
        }
        this.prH = bi.VE() + ((long) i);
        this.prI = bi.VE() + 600;
        x.i("MicroMsg.WalletUserInfoManger", "hy: cache time: %d, dead time: %d, cacheDeadTime: %s", new Object[]{Integer.valueOf(i), Long.valueOf(this.prH), Long.valueOf(this.prI)});
        o.bOU().diF.fV("WalletBankcard", "delete from WalletBankcard");
        if (!(i2 == 24 || i2 == 25 || arrayList == null)) {
            o.bOU().cG(arrayList);
        }
        if (arrayList2 != null) {
            o.bOU().cG(arrayList2);
        }
        if (bankcard != null) {
            o.bOU().e(bankcard);
        }
        if (bankcard2 != null) {
            o.bOU().e(bankcard2);
        }
        if (bankcard3 != null) {
            o.bOU().e(bankcard3);
        }
        o.bOS().diF.fV("WalletUserInfo", "delete from WalletUserInfo");
        o.bOS().b(afVar);
        o.bOY().diF.fV("LoanEntryInfo", "delete from LoanEntryInfo");
        if (kVar != null) {
            o.bOY().b(kVar);
        }
    }

    public static void Pc(String str) {
        if (!bi.oW(str)) {
            g.Ek();
            g.Ei().DT().set(196612, str);
        }
    }

    public final Bankcard a(ArrayList<Bankcard> arrayList, String str, boolean z, boolean z2) {
        return a(arrayList, str, z, z2, false);
    }

    public final Bankcard a(ArrayList<Bankcard> arrayList, String str, boolean z, boolean z2, boolean z3) {
        ArrayList arrayList2;
        if (arrayList2 == null) {
            arrayList2 = this.pcZ;
        }
        if (bi.oW(str)) {
            g.Ek();
            str = (String) g.Ei().DT().get(196612, null);
        }
        if (z && this.paw != null) {
            if (bPt()) {
                return this.paw;
            }
            if (str != null && str.equals(this.paw.field_bindSerial)) {
                return this.paw;
            }
            if (this.prG != null && this.prA != null && this.prA.field_lqt_state == 1 && str != null && str.equals(this.prG.field_bindSerial)) {
                return this.prG;
            }
            if (!bPp() && (arrayList2 == null || arrayList2.size() == 0)) {
                return this.paw;
            }
        }
        if (arrayList2 == null || arrayList2.size() <= 0) {
            x.e("MicroMsg.WalletUserInfoManger", "not found bankcard!");
            return null;
        } else if (arrayList2.size() == 1 && z2) {
            x.e("MicroMsg.WalletUserInfoManger", "only one bankcard!");
            return (Bankcard) arrayList2.get(0);
        } else {
            x.i("MicroMsg.WalletUserInfoManger", "have multiple bankcards!");
            if (!bi.oW(str)) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    Bankcard bankcard = (Bankcard) it.next();
                    if (bankcard != null && str.equals(bankcard.field_bindSerial)) {
                        if (!z3 || !bankcard.bOw()) {
                            return bankcard;
                        }
                        x.i("MicroMsg.WalletUserInfoManger", "default card is honeypay");
                        if (z && this.paw != null) {
                            return this.paw;
                        }
                        Iterator it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            bankcard = (Bankcard) it2.next();
                            if (!bankcard.bOw()) {
                                return bankcard;
                            }
                        }
                        continue;
                    }
                }
            }
            return z2 ? (Bankcard) arrayList2.get(0) : null;
        }
    }

    public final String bPH() {
        if (this.pcZ == null || this.pcZ.size() <= 0) {
            x.e("MicroMsg.WalletUserInfoManger", "not found bankcard!");
            return null;
        }
        Iterator it = this.pcZ.iterator();
        if (it.hasNext()) {
            return ((Bankcard) it.next()).field_bindSerial;
        }
        return null;
    }

    private void bPI() {
        x.i("MicroMsg.WalletUserInfoManger", "recordDataState()");
        if (this.prA == null) {
            x.i("MicroMsg.WalletUserInfoManger", "userInfo == null");
        }
        if (this.pcZ == null) {
            x.i("MicroMsg.WalletUserInfoManger", "bankcards == null");
        } else if (this.pcZ.size() == 0) {
            x.i("MicroMsg.WalletUserInfoManger", "bankcards.size() == 0");
        } else {
            x.i("MicroMsg.WalletUserInfoManger", "bankcards.size() == " + this.pcZ.size());
        }
        if (this.pda == null) {
            x.i("MicroMsg.WalletUserInfoManger", "virtualBankcards == null");
        } else if (this.pda.size() == 0) {
            x.i("MicroMsg.WalletUserInfoManger", "virtualBankcards.size() == 0");
        } else {
            x.i("MicroMsg.WalletUserInfoManger", "virtualBankcards.size() == " + this.pda.size());
        }
        if (this.paw == null) {
            x.i("MicroMsg.WalletUserInfoManger", "balance == null");
        } else {
            x.i("MicroMsg.WalletUserInfoManger", "balance != null");
        }
        if (this.prB == null) {
            x.i("MicroMsg.WalletUserInfoManger", "historyBankcard == null");
        } else {
            x.i("MicroMsg.WalletUserInfoManger", "historyBankcard != null");
        }
        if (this.prD == null) {
            x.i("MicroMsg.WalletUserInfoManger", "mLoanEntryInfo == null");
        } else {
            x.i("MicroMsg.WalletUserInfoManger", "mLoanEntryInfo != null");
        }
    }
}
