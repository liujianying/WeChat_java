package com.tencent.mm.plugin.wallet_payu.bind.ui;

import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;

public class WalletPayUBankcardDetailUI extends WalletBankcardDetailUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (1 == this.paI.field_bankcardState) {
            bNg();
            findViewById(f.wallet_bankcard_detail_expired_bankphone_title).setVisibility(8);
            findViewById(f.wallet_bankcard_detail_expired_bankphone).setVisibility(8);
        } else {
            ji(false);
        }
        findViewById(f.wallet_bankcard_detail_international_default).setVisibility(8);
        ((TextView) findViewById(f.wallet_bankcard_detail_international_wording)).setText(i.wallet_bankcard_detail_international_tips_payu);
    }
}
