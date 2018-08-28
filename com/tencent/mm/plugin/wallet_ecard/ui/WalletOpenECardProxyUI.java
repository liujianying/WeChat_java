package com.tencent.mm.plugin.wallet_ecard.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ab.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c;

@a(3)
public class WalletOpenECardProxyUI extends WalletECardBaseUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ux(4);
        c cDK = cDK();
        if (cDK != null) {
            int i = this.sy.getInt(com.tencent.mm.plugin.wallet_ecard.a.a.pBy, 0);
            x.i("MicroMsg.WalletOpenECardProxyUI", "onCreate, openScene: %s, isReuseExistCard: %s", new Object[]{Integer.valueOf(i), Boolean.valueOf(this.sy.getBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.pBQ, false))});
            if (this.sy.getBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.pBQ, false)) {
                cDL().m(new Object[]{Integer.valueOf(2), Integer.valueOf(i), Boolean.valueOf(true)});
                return;
            }
            String string = this.sy.getString(com.tencent.mm.plugin.wallet_ecard.a.a.pBz);
            boolean z = this.sy.getBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.pBB, false);
            x.i("MicroMsg.WalletOpenECardProxyUI", "onCreate, openScene: %s, token==null:%s, isTokenInvalid: %s", new Object[]{Integer.valueOf(i), Boolean.valueOf(bi.oW(string)), Boolean.valueOf(z)});
            if (bi.oW(string)) {
                cDK.a(this.mController.tml, 0, this.sy);
                return;
            }
            cDL().m(new Object[]{Integer.valueOf(1), Integer.valueOf(i), string});
        }
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        return false;
    }

    protected final int getLayoutId() {
        return -1;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.WalletOpenECardProxyUI", "activity result, request:%s, result: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i != 1) {
            super.onActivityResult(i, i2, intent);
        } else if (i2 == -1) {
            setResult(0);
            c cDK = cDK();
            if (cDK != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("key_process_result_code", 0);
                cDK.l(this, bundle);
                return;
            }
            finish();
        } else {
            finish();
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        x.i("MicroMsg.WalletOpenECardProxyUI", "new intent, resultCode: %d, isEnd: %s", new Object[]{Integer.valueOf(intent.getIntExtra("key_process_result_code", -1)), Boolean.valueOf(intent.getBooleanExtra("key_process_is_end", false))});
        if (intent.getIntExtra("key_process_result_code", -1) == -1) {
            setResult(-1);
        } else {
            setResult(0);
        }
        c cDK = cDK();
        if (r1) {
            finish();
        } else if (cDK != null) {
            cDK.ag(this.mController.tml);
        }
    }
}
