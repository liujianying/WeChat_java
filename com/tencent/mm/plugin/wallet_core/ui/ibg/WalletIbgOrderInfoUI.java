package com.tencent.mm.plugin.wallet_core.ui.ibg;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet_core.c.a.c;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(3)
public class WalletIbgOrderInfoUI extends WalletBaseUI {
    public static Orders pfb;
    private String mAppId = null;
    private String mTimeStamp = null;
    private String pdI = null;
    private String pze = null;
    private String pzf = null;
    private String pzg = null;
    private String pzh = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        jr(1565);
        this.mAppId = getIntent().getStringExtra("appId");
        this.pze = getIntent().getStringExtra("nonceStr");
        this.mTimeStamp = getIntent().getStringExtra("timeStamp");
        this.pdI = getIntent().getStringExtra("packageExt");
        this.pzf = getIntent().getStringExtra("paySignature");
        this.pzg = getIntent().getStringExtra("signtype");
        this.pzh = getIntent().getStringExtra("url");
        a(new c(this.mAppId, this.pze, this.mTimeStamp, this.pdI, this.pzf, this.pzg, this.pzh), true, false);
    }

    protected final int getLayoutId() {
        return a$g.transparent_layout;
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.WalletIbgOrderInfoUI", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s, scene: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, lVar});
        if (lVar instanceof c) {
            js(1565);
            if (i == 0 && i2 == 0) {
                c cVar = (c) lVar;
                pfb = cVar.pjG;
                Orders orders = pfb;
                x.i("MicroMsg.WalletIbgOrderInfoUI", "gotoIbgOrderInfoUI, useNewPage: %s, orders: %s", new Object[]{Integer.valueOf(cVar.pjR), orders});
                Intent intent;
                if (cVar.pjR == 1) {
                    intent = new Intent(this, WalletIbgOrderInfoNewUI.class);
                    intent.putExtra("key_orders", orders);
                    startActivity(intent);
                } else {
                    intent = new Intent(this, WalletIbgOrderInfoOldUI.class);
                    intent.putExtra("key_orders", orders);
                    startActivity(intent);
                }
                setResult(-1);
                finish();
                return true;
            }
            setResult(0);
            finish();
        }
        setResult(0);
        finish();
        return false;
    }

    public void onDestroy() {
        super.onDestroy();
        js(1565);
    }
}
