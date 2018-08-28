package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.ui.g;
import com.tencent.mm.ui.base.a;

@a(3)
public class WalletChangeLoanRepayBankcardUI extends WalletChangeBankcardUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setBackBtn(new 1(this));
    }

    protected final g bNB() {
        this.oZG = o.bOX().prv;
        bNA();
        return new g(this, this.oZG, this.pfw, this.mCZ);
    }

    protected final void zg(int i) {
        int size = this.oZG != null ? this.oZG.size() : 0;
        if (this.oZG != null && i < size) {
            Bankcard bankcard = (Bankcard) this.oZG.get(i);
            this.oZH = bankcard;
            this.pfx.puN = bankcard.field_bindSerial;
            this.mAE.setEnabled(true);
            this.pfx.notifyDataSetChanged();
            Intent intent = new Intent();
            intent.putExtra("bindSerial", bankcard.field_bindSerial);
            intent.putExtra("ret", 0);
            setResult(-1, intent);
        } else if (size == i) {
            Intent intent2 = new Intent();
            intent2.putExtra("ret", -1003);
            setResult(-1, intent2);
        }
        finish();
    }

    protected final int getForceOrientation() {
        return 1;
    }
}
