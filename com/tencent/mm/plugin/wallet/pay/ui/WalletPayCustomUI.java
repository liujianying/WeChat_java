package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet_core.c.w;
import com.tencent.mm.plugin.wallet_core.ui.n;
import com.tencent.mm.protocal.c.btd;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(7)
public class WalletPayCustomUI extends WalletBaseUI {
    private String cZH = "";
    private int fdx = 0;
    private btd kkd;
    protected n pfQ;
    private String pfR = "";
    private boolean pfS = false;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ux(8);
        this.pfR = getIntent().getStringExtra("INTENT_PAYFEE");
        this.cZH = getIntent().getStringExtra("INTENT_TITLE");
        this.pfS = getIntent().getIntExtra("INTENT_CAN_TOUCH", 0) == 1;
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("INTENT_TOKENMESS");
        this.kkd = new btd();
        try {
            this.kkd.aG(byteArrayExtra);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WalletPayCustomUI", e, "", new Object[0]);
        }
        x.i("MicroMsg.WalletPayCustomUI", "mTokeMess packageex:%s busi_id:%s sign:%s can_use_touch %s mPayFee %s mTitle %s", new Object[]{this.kkd.sqy, this.kkd.rFf, this.kkd.sign, Boolean.valueOf(this.pfS), this.pfR, this.cZH});
        this.pfQ = n.a(this, this.cZH, this.pfR, "", this.pfS, new 1(this), new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                WalletPayCustomUI.this.finish();
            }
        }, new 3(this));
    }

    protected final int getLayoutId() {
        return -1;
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.WalletPayCustomUI", "errorType %s errCode %s, errmsg %s, scene %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, lVar});
        if (lVar instanceof w) {
            if (i == 0 && i2 == 0) {
                w wVar = (w) lVar;
                Intent intent = new Intent();
                intent.putExtra("INTENT_RESULT_TOKEN", wVar.pjE);
                setResult(-1, intent);
            }
            finish();
        }
        return false;
    }
}
