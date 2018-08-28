package com.tencent.mm.plugin.wallet_core.id_verify;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;

@a(7)
public class WalletRealNameProcessProxyUI extends WalletBaseUI {
    public void onCreate(Bundle bundle) {
        int i;
        super.onCreate(bundle);
        jr(580);
        Bundle bundle2 = this.sy;
        if (bundle2 != null) {
            i = bundle2.getInt("realname_scene", 0);
        } else {
            i = 0;
        }
        if (i == 0) {
            i = getIntent().getIntExtra("realname_scene", 0);
        }
        if (i == 1) {
            x.i("MicroMsg.WalletRealNameProcessProxyUI", "from jsapi, do NetSceneCheckPayJsapi");
            if (getIntent() == null) {
                String str = "";
                if (bi.oW(str)) {
                    str = getString(i.wallet_unknown_err);
                }
                h.a(this, str, null, false, new 1(this));
                return;
            }
            String stringExtra = getIntent().getStringExtra("appId");
            String stringExtra2 = getIntent().getStringExtra("timeStamp");
            String stringExtra3 = getIntent().getStringExtra("nonceStr");
            String stringExtra4 = getIntent().getStringExtra("packageExt");
            String stringExtra5 = getIntent().getStringExtra("signtype");
            String stringExtra6 = getIntent().getStringExtra("paySignature");
            String stringExtra7 = getIntent().getStringExtra("url");
            int i2 = 8;
            if (this.sy.getInt("realname_scene") == 2) {
                i2 = 12;
            }
            a(new com.tencent.mm.plugin.wallet_core.c.a(stringExtra, stringExtra2, stringExtra3, stringExtra4, stringExtra5, stringExtra6, stringExtra7, i2, "idCardRealnameVerify", getIntent().getIntExtra("pay_channel", 0)), true, false);
            return;
        }
        K(bundle2);
    }

    public void onResume() {
        super.onResume();
    }

    private void K(Bundle bundle) {
        x.i("MicroMsg.WalletRealNameProcessProxyUI", "goRealNameUI");
        if (bundle == null) {
            x.i("MicroMsg.WalletRealNameProcessProxyUI", "goRealNameUI, param is null");
            bundle = new Bundle();
        }
        bundle.putString("realname_verify_process_jump_plugin", "wallet_core");
        bundle.putString("realname_verify_process_jump_activity", ".id_verify.WalletRealNameProcessProxyUI");
        bundle.putBoolean("process_finish_stay_orgpage", false);
        com.tencent.mm.wallet_core.a.a(this, a.class, bundle);
    }

    protected final int getLayoutId() {
        return -1;
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (lVar instanceof com.tencent.mm.plugin.wallet_core.c.a) {
            x.e("MicroMsg.WalletRealNameProcessProxyUI", "NetSceneCheckPayJsapi resp,errType = " + i + ",errCode=" + i2);
            if (i == 0 && i2 == 0) {
                f.Ul(((com.tencent.mm.plugin.wallet_core.c.a) lVar).bOj());
                K(this.sy);
                return true;
            }
        }
        return false;
    }

    protected void onNewIntent(Intent intent) {
        x.i("MicroMsg.WalletRealNameProcessProxyUI", "onNewIntent");
        Bundle extras = getIntent().getExtras();
        if (extras == null || !extras.getBoolean("key_is_realname_verify_process")) {
            setResult(0);
        } else {
            switch (extras.getInt("realname_verify_process_ret", 0)) {
                case IX5WebViewClient.ERROR_UNKNOWN /*-1*/:
                    setResult(-1);
                    break;
            }
            setResult(0);
        }
        finish();
    }

    public final boolean bbR() {
        return true;
    }

    public void onDestroy() {
        super.onDestroy();
        js(580);
    }
}
