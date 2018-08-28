package com.tencent.mm.plugin.wallet_index.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.te;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c.q;

@a(7)
public class WalletBrandUI extends MMActivity implements e {
    private String appId;
    private String bVX;
    private Dialog eXG = null;
    private int lNG;
    private c pDA = new c<te>() {
        {
            this.sFo = te.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            te teVar = (te) bVar;
            x.i("MicroMsg.WalletBrandUI", "onPayEnd payResult : " + teVar.ceH.result);
            WalletBrandUI.this.setResult(teVar.ceH.result, teVar.ceH.intent);
            WalletBrandUI.this.finish();
            return true;
        }
    };
    private c pDB = new 3(this);
    private boolean pDy = false;
    private b pDz;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (VERSION.SDK_INT >= 21 && getWindow() != null) {
            getWindow().addFlags(Integer.MIN_VALUE);
            getWindow().setStatusBarColor(0);
        }
        this.lNG = getIntent().getIntExtra("pay_scene", 3);
        q.cDf();
        x.i("MicroMsg.WalletBrandUI", "onCreate");
        int intExtra = getIntent().getIntExtra("pay_for_wallet_type", 1);
        x.i("MicroMsg.WalletBrandUI", "onCreate payForWalletType is " + intExtra);
        if (com.tencent.mm.model.q.GS()) {
            x.i("MicroMsg.WalletBrandUI", "hy: do pay with payu");
            this.pDz = new c(this);
        } else if (intExtra == 2) {
            x.i("MicroMsg.WalletBrandUI", "hy: do pay with h5");
            this.pDz = new a(this);
        } else if (intExtra == 3) {
            x.i("MicroMsg.WalletBrandUI", "do pay with mall");
            this.pDz = new e(this);
        } else {
            x.i("MicroMsg.WalletBrandUI", "hy: do pay with tenpay");
            this.pDz = new d(this);
        }
        com.tencent.mm.sdk.b.a.sFg.b(this.pDA);
        com.tencent.mm.sdk.b.a.sFg.b(this.pDB);
        g.Ek();
        g.Eh().dpP.a(this.pDz.bRf(), this);
    }

    public void onDestroy() {
        super.onDestroy();
        g.Ek();
        g.Eh().dpP.b(this.pDz.bRf(), this);
        com.tencent.mm.sdk.b.a.sFg.c(this.pDA);
        com.tencent.mm.sdk.b.a.sFg.c(this.pDB);
    }

    public void onResume() {
        x.d("MicroMsg.WalletBrandUI", "onResume");
        super.onResume();
        x.i("MicroMsg.WalletBrandUI", "Handler jump");
        if (!this.pDy) {
            this.pDy = true;
            l bRg = this.pDz.bRg();
            if (this.eXG != null) {
                this.eXG.dismiss();
                this.eXG = null;
            }
            this.eXG = com.tencent.mm.wallet_core.ui.g.e(this, new 1(this, bRg));
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        finish();
        return true;
    }

    public void onStart() {
        super.onStart();
    }

    protected void onStop() {
        super.onStop();
        if (this.eXG != null) {
            this.eXG.dismiss();
            this.eXG = null;
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.WalletBrandUI", "hy: brandui on scene end. errType: %d, errCode: %d, errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (lVar.getType() == this.pDz.bRf()) {
            this.pDz.a(i, i2, str, lVar);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x.i("MicroMsg.WalletBrandUI", "onActivityResultresultCode : " + i2 + " requestCode: " + i);
        if (i2 == -1) {
            switch (i) {
                case 1:
                    x.i("MicroMsg.WalletBrandUI", "get result to callback? " + intent.getStringExtra("test"));
                    break;
            }
        }
        finish();
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected final int getLayoutId() {
        return -1;
    }
}
