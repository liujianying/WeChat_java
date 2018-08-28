package com.tencent.mm.plugin.wallet_ecard.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_ecard.a.g;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c.h;
import org.xwalk.core.Log;

public class WalletECardLogoutUI extends WalletECardBaseUI {
    private TextView eBT;
    private TextView gsY;
    private CdnImageView kmk;
    private TextView pCv;
    private LinearLayout pCw;
    private View pCx;
    private Button pCy;
    private String pct;
    private String psA;

    static /* synthetic */ void a(WalletECardLogoutUI walletECardLogoutUI) {
        Log.i("MicroMsg.WalletECardLogoutUI", "do logout");
        Bundle bundle = new Bundle();
        bundle.putBoolean("key_is_show_detail", false);
        Bankcard bankcard = new Bankcard();
        bankcard.field_bindSerial = walletECardLogoutUI.pct;
        bankcard.field_bankcardType = walletECardLogoutUI.psA;
        bundle.putParcelable("key_bankcard", bankcard);
        bundle.putInt("scene", 2);
        a.a(walletECardLogoutUI, com.tencent.mm.plugin.wallet.bind.a.class, bundle);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        jr(2931);
        initView();
        setMMTitle(i.ecard_logout_title);
        Log.i("MicroMsg.WalletECardLogoutUI", "do qry logout desc");
        g gVar = new g();
        gVar.m(this);
        a(gVar, true, false);
    }

    protected final void initView() {
        this.gsY = (TextView) findViewById(f.elu_title);
        this.pCv = (TextView) findViewById(f.elu_tips_title);
        this.pCw = (LinearLayout) findViewById(f.elu_tips_layout);
        this.eBT = (TextView) findViewById(f.elu_bottom_link_tv);
        this.kmk = (CdnImageView) findViewById(f.elu_icon_iv);
        this.pCx = findViewById(f.elu_mask_view);
        this.pCy = (Button) findViewById(f.elu_logout_btn);
        this.pCy.setOnClickListener(new 1(this));
    }

    public void onDestroy() {
        super.onDestroy();
        js(2931);
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (!(lVar instanceof g)) {
            return false;
        }
        g gVar = (g) lVar;
        gVar.a(new 4(this, gVar)).b(new 3(this)).c(new h.a() {
            public final void g(int i, int i2, String str, l lVar) {
            }
        });
        return true;
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.ecard_logout_ui;
    }
}
