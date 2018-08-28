package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet.pwd.c;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(7)
public class WalletResetPwdAdapterUI extends WalletBaseUI {
    protected String cYO = null;
    protected boolean myK = false;
    protected com.tencent.mm.plugin.wallet.a myL = null;
    protected String pij = "";

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ux(8);
        this.pij = getIntent().getStringExtra("reset_pwd_token");
        x.i("MicroMsg.WalletResetPwdAdapterUI", "token_by_resetPwd %s", new Object[]{this.pij});
        jr(580);
        if (getIntent() == null) {
            x.d("MicroMsg.WalletResetPwdAdapterUI", "func[doCheckPayNetscene] intent null");
            setResult(0);
            finish();
            return;
        }
        com.tencent.mm.plugin.wallet_core.c.a aVar = new com.tencent.mm.plugin.wallet_core.c.a(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("url"), 13, "setWCPayPassword", getIntent().getIntExtra("pay_channel", 0));
        aVar.dox = "RemittanceProcess";
        a(aVar, true, false);
    }

    protected void onNewIntent(Intent intent) {
        x.v("MicroMsg.WalletResetPwdAdapterUI", "onNewIntent");
        int intExtra = intent.getIntExtra("RESET_PWD_USER_ACTION", 0);
        if (intExtra == 1) {
            setResult(-1);
            finish();
        } else if (intExtra == 2) {
            setResult(-1000);
            finish();
        } else {
            setResult(0);
            finish();
        }
    }

    public void onDestroy() {
        js(580);
        super.onDestroy();
    }

    public void onBackPressed() {
        if (this.myK) {
            x.d("MicroMsg.WalletResetPwdAdapterUI", "back press but lock");
            return;
        }
        x.d("MicroMsg.WalletResetPwdAdapterUI", "back press not lock");
        finish();
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (i != 0 || i2 != 0) {
            setResult(-1000);
            h.bA(this, str);
            finish();
            return true;
        } else if (!(lVar instanceof com.tencent.mm.plugin.wallet_core.c.a)) {
            return false;
        } else {
            f.Ul(((com.tencent.mm.plugin.wallet_core.c.a) lVar).bOj());
            Bundle bundle = new Bundle();
            bundle.putString("kreq_token", this.pij);
            com.tencent.mm.wallet_core.a.a(this, c.class, bundle, null);
            return true;
        }
    }

    protected final int getLayoutId() {
        return -1;
    }
}
