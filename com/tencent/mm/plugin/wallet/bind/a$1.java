package com.tencent.mm.plugin.wallet.bind;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet.bind.a.d;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

class a$1 extends g {
    private String bOd = null;
    final /* synthetic */ a pcq;

    a$1(a aVar, MMActivity mMActivity, i iVar) {
        this.pcq = aVar;
        super(mMActivity, iVar);
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (lVar instanceof d) {
            if (i == 0 && i2 == 0) {
                this.pcq.jfZ.putInt("key_process_result_code", -1);
                if (this.pcq.c(this.fEY, null)) {
                    this.uXK.a(new y(this.bOd, 14), true, 1);
                } else {
                    this.pcq.a(this.fEY, 0, null);
                    if (this.fEY instanceof WalletBaseUI) {
                        ((WalletBaseUI) this.fEY).rj(0);
                    }
                    this.fEY.finish();
                }
                return true;
            }
            this.pcq.jfZ.putInt("key_process_result_code", 1);
        }
        return false;
    }

    public final boolean r(Object... objArr) {
        Bankcard bankcard = (Bankcard) a.a(this.pcq).getParcelable("key_bankcard");
        if (bankcard == null || bankcard.field_bankcardState != 1) {
            this.pcq.jfZ.putInt("key_process_result_code", 1);
            return super.r(objArr);
        }
        this.uXK.a(new d(bankcard.field_bankcardType, bankcard.field_bindSerial, a.b(this.pcq).getInt("scene", -1) == 2), true, 1);
        a.c(this.pcq).putBoolean("key_is_expired_bankcard", true);
        return true;
    }

    public final boolean m(Object... objArr) {
        Bankcard bankcard = (Bankcard) a.d(this.pcq).getParcelable("key_bankcard");
        String str = (String) objArr[0];
        this.bOd = (String) objArr[1];
        if (bankcard != null) {
            this.uXK.a(new d(bankcard.field_bankcardType, bankcard.field_bindSerial, str, a.e(this.pcq).getInt("scene", -1) == 2), true, 1);
            return true;
        }
        this.pcq.jfZ.putInt("key_process_result_code", 1);
        return false;
    }

    public final CharSequence ui(int i) {
        switch (i) {
            case 1:
                return this.fEY.getString(a.i.wallet_index_ui_unbind_bankcard_title);
            default:
                return super.ui(i);
        }
    }
}
