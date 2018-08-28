package com.tencent.mm.plugin.wallet_ecard.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.lf;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c;

@a(19)
public class WalletECardFinishUI extends WalletECardBaseUI {
    private Button klJ;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(i.ecard_finish_title);
        enableBackMenu(false);
        setBackBtn(new 1(this));
        showHomeBtn(false);
        initView();
    }

    protected final void initView() {
        this.klJ = (Button) findViewById(f.finish_btn);
        this.klJ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                x.i("MicroMsg.WalletECardFinishUI", "click finish");
                com.tencent.mm.sdk.b.a.sFg.m(new lf());
                c cDK = WalletECardFinishUI.this.cDK();
                if (cDK != null) {
                    cDK.b(WalletECardFinishUI.this.mController.tml, new Bundle());
                    return;
                }
                x.w("MicroMsg.WalletECardFinishUI", "process is null");
                WalletECardFinishUI.this.finish();
            }
        });
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        return false;
    }

    protected final int getLayoutId() {
        return g.ecard_finish_ui;
    }
}
