package com.tencent.mm.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mm.ab.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.f;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

@a(3)
public abstract class WalletPreferenceUI extends MMPreference implements f {
    public c uYN = null;
    public i uYO = null;
    public g uYP = null;

    public abstract boolean h(int i, int i2, String str, l lVar);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.uYO = new i(this, this);
        this.uYO.jr(385);
        this.uYO.jr(1518);
        if (getLayoutId() > 0) {
            e.cDN();
        }
    }

    public final i cDP() {
        if (this.uYO == null) {
            this.uYO = new i(this, this);
        }
        return this.uYO;
    }

    public final void b(int i, int i2, String str, l lVar, boolean z) {
        if (!h(i, i2, str, lVar) && i2 != 0) {
            if (bi.oW(str)) {
                str = getString(com.tencent.mm.plugin.wxpay.a.i.wallet_data_err);
            }
            h.a(this, str, null, false, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    WalletPreferenceUI.this.finish();
                }
            });
        }
    }

    public void onDestroy() {
        this.uYO.js(385);
        this.uYO.js(1518);
        this.uYO = null;
        super.onDestroy();
    }
}
