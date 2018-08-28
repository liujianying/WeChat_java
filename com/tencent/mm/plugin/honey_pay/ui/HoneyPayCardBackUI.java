package com.tencent.mm.plugin.honey_pay.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.honey_pay.a.k;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.c.btd;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.v;
import com.tencent.mm.wallet_core.ui.WalletTextView;

public class HoneyPayCardBackUI extends HoneyPayBaseUI {
    private CdnImageView kjX;
    private WalletTextView kjY;
    private TextView kjZ;
    private TextView kka;
    private TextView kkb;
    private String kkc;
    private btd kkd;

    public void onCreate(Bundle bundle) {
        this.kjV = c.honey_pay_orange;
        super.onCreate(bundle);
        setMMTitle("");
        setBackBtn(new 1(this));
        jr(2851);
        this.kkc = getIntent().getStringExtra("key_card_no");
        initView();
        x.i(this.TAG, "do qry card detail: %s", new Object[]{this.kkc});
        l kVar = new k(this.kkc);
        kVar.m(this);
        a(kVar, true, false);
    }

    protected final void initView() {
        this.kjX = (CdnImageView) findViewById(f.hpcb_avatar_iv);
        this.kjY = (WalletTextView) findViewById(f.hpcb_quota_remained_tv);
        this.kjZ = (TextView) findViewById(f.hpcb_quota_tv);
        this.kka = (TextView) findViewById(f.hpcb_card_type_name_tv);
        this.kkb = (TextView) findViewById(f.hpcb_desc_tv);
        this.kjY.setPrefix(v.cDm());
    }

    public void onDestroy() {
        super.onDestroy();
        js(2851);
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (lVar instanceof k) {
            k kVar = (k) lVar;
            kVar.a(new 4(this, kVar)).b(new 3(this)).c(new 2(this));
        }
        return true;
    }

    protected final int getLayoutId() {
        return g.honey_pay_card_back_ui;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1 && i2 == -1) {
            x.i(this.TAG, "unbind success");
            finish();
        }
        super.onActivityResult(i, i2, intent);
    }
}
