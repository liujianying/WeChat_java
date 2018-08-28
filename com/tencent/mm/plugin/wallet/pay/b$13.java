package com.tencent.mm.plugin.wallet.pay;

import android.os.Parcelable;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.pay.a.d.b;
import com.tencent.mm.plugin.wallet.pay.b.a;
import com.tencent.mm.plugin.wallet_core.e.c;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

class b$13 extends a {
    final /* synthetic */ b peU;

    b$13(b bVar, WalletBaseUI walletBaseUI, i iVar) {
        this.peU = bVar;
        super(bVar, walletBaseUI, iVar);
    }

    public final /* synthetic */ CharSequence ui(int i) {
        boolean z = this.peU.jfZ.getBoolean("key_is_changing_balance_phone_num");
        boolean z2 = this.peU.jfZ.getBoolean("key_is_return_from_switch_phone", false);
        Authen authen = (Authen) this.peU.jfZ.getParcelable("key_authen");
        String str = (authen == null || authen.plv == null) ? "" : authen.plv;
        int i2 = this.peU.jfZ.getInt("key_pay_flag", 3);
        Bankcard bankcard;
        String oV;
        MMActivity mMActivity;
        int i3;
        Object[] objArr;
        if (!z2 || str.isEmpty()) {
            if (!z || i2 == 2) {
                str = bi.aG(b.k(this.peU).getString("key_mobile"), "");
                return String.format(this.fEY.getString(com.tencent.mm.plugin.wxpay.a.i.wallet_verify_code_pay_hint), new Object[]{str});
            }
            bankcard = (Bankcard) this.peU.jfZ.getParcelable("key_bankcard");
            oV = bi.oV(this.peU.jfZ.getString("key_mobile"));
            mMActivity = this.fEY;
            i3 = com.tencent.mm.plugin.wxpay.a.i.wallet_verify_code_balance_change_phone_num;
            objArr = new Object[2];
            objArr[0] = bankcard.field_desc;
            objArr[1] = e.aca(bi.oW(oV) ? bankcard.field_mobile : oV);
            return mMActivity.getString(i3, objArr);
        } else if (str.equals("cft")) {
            bankcard = (Bankcard) this.peU.jfZ.getParcelable("key_bankcard");
            oV = bi.oV(this.peU.jfZ.getString("key_mobile"));
            mMActivity = this.fEY;
            i3 = com.tencent.mm.plugin.wxpay.a.i.wallet_verify_code_balance_change_phone_num;
            objArr = new Object[2];
            objArr[0] = bankcard.field_desc;
            objArr[1] = e.aca(bi.oW(oV) ? bankcard.field_mobile : oV);
            return mMActivity.getString(i3, objArr);
        } else {
            str = bi.aG(b.j(this.peU).getString("key_mobile"), "");
            return String.format(this.fEY.getString(com.tencent.mm.plugin.wxpay.a.i.wallet_verify_code_pay_hint), new Object[]{str});
        }
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (super.d(i, i2, str, lVar)) {
            return true;
        }
        if (i == 0 && i2 == 0) {
            if ((lVar instanceof com.tencent.mm.plugin.wallet.pay.a.d.e) || (lVar instanceof b)) {
                com.tencent.mm.plugin.wallet.pay.a.d.e eVar = (com.tencent.mm.plugin.wallet.pay.a.d.e) lVar;
                if (eVar.pgm) {
                    b.l(this.peU).putParcelable("key_orders", eVar.pfb);
                }
                Parcelable parcelable = eVar.lJN;
                if (parcelable != null) {
                    b.m(this.peU).putParcelable("key_realname_guide_helper", parcelable);
                }
                h.mEJ.h(10707, new Object[]{Integer.valueOf(1), Integer.valueOf(c.bQX())});
                return false;
            } else if (lVar instanceof com.tencent.mm.plugin.wallet.pay.a.a.b) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean m(java.lang.Object... r9) {
        /*
        r8 = this;
        r3 = 0;
        r2 = 1;
        r0 = r9[r2];
        r0 = (com.tencent.mm.plugin.wallet_core.model.p) r0;
        r1 = r8.peU;
        r1 = com.tencent.mm.plugin.wallet.pay.b.n(r1);
        r4 = "key_orders";
        r1 = r1.getParcelable(r4);
        r1 = (com.tencent.mm.plugin.wallet_core.model.Orders) r1;
        r4 = "MicroMsg.PayProcess";
        r5 = new java.lang.StringBuilder;
        r6 = "WalletVerifyCodeUI onNext pay_flag : ";
        r5.<init>(r6);
        r6 = r8.peU;
        r6 = r6.jfZ;
        r7 = "key_pay_flag";
        r6 = r6.getInt(r7, r3);
        r5 = r5.append(r6);
        r5 = r5.toString();
        com.tencent.mm.sdk.platformtools.x.i(r4, r5);
        r4 = r8.peU;
        r4 = r4.jfZ;
        r5 = "key_is_changing_balance_phone_num";
        r4 = r4.getBoolean(r5);
        r5 = r8.peU;
        r5 = r5.jfZ;
        r6 = "key_pay_flag";
        r5 = r5.getInt(r6, r3);
        switch(r5) {
            case 1: goto L_0x0051;
            case 2: goto L_0x0096;
            case 3: goto L_0x00ea;
            default: goto L_0x004f;
        };
    L_0x004f:
        r0 = r3;
    L_0x0050:
        return r0;
    L_0x0051:
        r3 = "1";
        r0.flag = r3;
        if (r4 != 0) goto L_0x007e;
    L_0x0058:
        r3 = r0.lMV;
        r3 = com.tencent.mm.sdk.platformtools.bi.oW(r3);
        if (r3 != 0) goto L_0x008a;
    L_0x0060:
        com.tencent.mm.plugin.wallet.a.p.bNp();
        r3 = com.tencent.mm.plugin.wallet.a.p.bNq();
        r3 = r3.prG;
        if (r3 == 0) goto L_0x008a;
    L_0x006b:
        r3 = r0.lMV;
        com.tencent.mm.plugin.wallet.a.p.bNp();
        r4 = com.tencent.mm.plugin.wallet.a.p.bNq();
        r4 = r4.prG;
        r4 = r4.field_bankcardType;
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x008a;
    L_0x007e:
        r3 = r8.uXK;
        r4 = new com.tencent.mm.plugin.wallet.pay.a.d.b;
        r4.<init>(r0, r1);
        r3.a(r4, r2, r2);
    L_0x0088:
        r0 = r2;
        goto L_0x0050;
    L_0x008a:
        r0 = com.tencent.mm.plugin.wallet.pay.a.a.a(r0, r1);
        if (r0 == 0) goto L_0x0088;
    L_0x0090:
        r1 = r8.uXK;
        r1.a(r0, r2, r2);
        goto L_0x0088;
    L_0x0096:
        r3 = r8.peU;
        r3 = r3.bQH();
        if (r3 != 0) goto L_0x00d8;
    L_0x009e:
        r3 = "2";
        r0.flag = r3;
    L_0x00a3:
        if (r4 != 0) goto L_0x00cb;
    L_0x00a5:
        r3 = r0.lMV;
        r3 = com.tencent.mm.sdk.platformtools.bi.oW(r3);
        if (r3 != 0) goto L_0x00de;
    L_0x00ad:
        com.tencent.mm.plugin.wallet.a.p.bNp();
        r3 = com.tencent.mm.plugin.wallet.a.p.bNq();
        r3 = r3.prG;
        if (r3 == 0) goto L_0x00de;
    L_0x00b8:
        r3 = r0.lMV;
        com.tencent.mm.plugin.wallet.a.p.bNp();
        r4 = com.tencent.mm.plugin.wallet.a.p.bNq();
        r4 = r4.prG;
        r4 = r4.field_bankcardType;
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x00de;
    L_0x00cb:
        r3 = r8.uXK;
        r4 = new com.tencent.mm.plugin.wallet.pay.a.d.b;
        r4.<init>(r0, r1);
        r3.a(r4, r2, r2);
    L_0x00d5:
        r0 = r2;
        goto L_0x0050;
    L_0x00d8:
        r3 = "5";
        r0.flag = r3;
        goto L_0x00a3;
    L_0x00de:
        r0 = com.tencent.mm.plugin.wallet.pay.a.a.a(r0, r1);
        if (r0 == 0) goto L_0x00d5;
    L_0x00e4:
        r1 = r8.uXK;
        r1.a(r0, r2, r2);
        goto L_0x00d5;
    L_0x00ea:
        r3 = r8.peU;
        r3 = r3.bQH();
        if (r3 != 0) goto L_0x012c;
    L_0x00f2:
        r3 = "3";
        r0.flag = r3;
    L_0x00f7:
        if (r4 != 0) goto L_0x011f;
    L_0x00f9:
        r3 = r0.lMV;
        r3 = com.tencent.mm.sdk.platformtools.bi.oW(r3);
        if (r3 != 0) goto L_0x0132;
    L_0x0101:
        com.tencent.mm.plugin.wallet.a.p.bNp();
        r3 = com.tencent.mm.plugin.wallet.a.p.bNq();
        r3 = r3.prG;
        if (r3 == 0) goto L_0x0132;
    L_0x010c:
        r3 = r0.lMV;
        com.tencent.mm.plugin.wallet.a.p.bNp();
        r4 = com.tencent.mm.plugin.wallet.a.p.bNq();
        r4 = r4.prG;
        r4 = r4.field_bankcardType;
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x0132;
    L_0x011f:
        r3 = r8.uXK;
        r4 = new com.tencent.mm.plugin.wallet.pay.a.d.b;
        r4.<init>(r0, r1);
        r3.a(r4, r2, r2);
    L_0x0129:
        r0 = r2;
        goto L_0x0050;
    L_0x012c:
        r3 = "6";
        r0.flag = r3;
        goto L_0x00f7;
    L_0x0132:
        r0 = com.tencent.mm.plugin.wallet.pay.a.a.a(r0, r1);
        if (r0 == 0) goto L_0x0129;
    L_0x0138:
        r1 = r8.uXK;
        r1.a(r0, r2, r2);
        goto L_0x0129;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wallet.pay.b$13.m(java.lang.Object[]):boolean");
    }
}
