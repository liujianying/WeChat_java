package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet.balance.a.a.j;
import com.tencent.mm.plugin.wallet.balance.a.a.k;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.protocal.c.sj;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.Iterator;

public class WalletLqtDetailUI extends WalletLqtBasePresenterUI {
    private Dialog eBX;
    private ag handler = new ag(Looper.getMainLooper());
    private j paU = ((j) w(j.class));
    private k paV = ((k) t(k.class));
    private bdo paW;
    private ViewGroup paX;
    private TextView paY;
    private WalletTextView paZ;
    private ViewGroup pba;
    private TextView pbb;
    private TextView pbc;
    private ViewGroup pbd;
    private TextView pbe;
    private WalletTextView pbf;
    private Button pbg;
    private Button pbh;
    private LinearLayout pbi;
    private TextView pbj;
    private View pbk;
    private TextView pbl;
    private View pbm;
    private View pbn;
    private CdnImageView pbo;
    private TextView pbp;
    private TextView pbq;
    private boolean pbr = true;

    static /* synthetic */ void b(WalletLqtDetailUI walletLqtDetailUI) {
        if (walletLqtDetailUI.paW != null) {
            walletLqtDetailUI.paZ.setText(e.A(((double) walletLqtDetailUI.paW.balance) / 100.0d));
            walletLqtDetailUI.pba.setOnClickListener(new 8(walletLqtDetailUI));
            walletLqtDetailUI.pbb.setText(walletLqtDetailUI.paW.sfy);
            walletLqtDetailUI.pbc.setText(walletLqtDetailUI.paW.sfz);
            walletLqtDetailUI.pbe.setText(walletLqtDetailUI.paW.sfA);
            walletLqtDetailUI.pbf.setText(e.A(((double) walletLqtDetailUI.paW.sfB) / 100.0d));
            walletLqtDetailUI.pbd.setOnClickListener(new 9(walletLqtDetailUI));
            walletLqtDetailUI.pbi.removeAllViews();
            if (walletLqtDetailUI.paW.sfC != null && walletLqtDetailUI.paW.sfC.size() > 0) {
                Iterator it = walletLqtDetailUI.paW.sfC.iterator();
                while (it.hasNext()) {
                    sj sjVar = (sj) it.next();
                    LinearLayout linearLayout = (LinearLayout) walletLqtDetailUI.getLayoutInflater().inflate(g.lqt_detail_bottom_info_layout, walletLqtDetailUI.pbi, false);
                    TextView textView = (TextView) linearLayout.findViewById(f.lqt_detail_bottom_info_desc_tv);
                    ((TextView) linearLayout.findViewById(f.lqt_detail_bottom_info_title_tv)).setText(sjVar.title);
                    textView.setText(sjVar.desc);
                    if (!bi.oW(sjVar.rvK)) {
                        linearLayout.setTag(sjVar.rvK);
                        linearLayout.setOnClickListener(new 10(walletLqtDetailUI, linearLayout));
                    }
                    walletLqtDetailUI.pbi.addView(linearLayout, new LayoutParams(-1, -2, -1.0f));
                }
            }
            walletLqtDetailUI.paX.setVisibility(0);
            if (walletLqtDetailUI.paW.balance <= 0) {
                walletLqtDetailUI.pbh.setEnabled(false);
            } else {
                walletLqtDetailUI.pbh.setEnabled(true);
            }
            if (b.chp()) {
                walletLqtDetailUI.pbh.setEnabled(true);
            }
            if (walletLqtDetailUI.paW.sfF != null) {
                walletLqtDetailUI.pbj.setText(walletLqtDetailUI.paW.sfF.title);
                walletLqtDetailUI.pbj.setOnClickListener(new 11(walletLqtDetailUI));
            }
            walletLqtDetailUI.pbk.setVisibility(8);
            if (!(walletLqtDetailUI.paW.sfH == null || bi.oW(walletLqtDetailUI.paW.sfH.title))) {
                walletLqtDetailUI.pbk.setVisibility(0);
                walletLqtDetailUI.pbl.setText(walletLqtDetailUI.paW.sfH.title);
                if (!bi.oW(walletLqtDetailUI.paW.sfH.rvK)) {
                    walletLqtDetailUI.pbk.setOnClickListener(new 12(walletLqtDetailUI));
                }
            }
            walletLqtDetailUI.pbn.setVisibility(8);
            walletLqtDetailUI.pbm.setVisibility(8);
            if (!(walletLqtDetailUI.paW.sfI == null || bi.oW(walletLqtDetailUI.paW.sfI.username))) {
                walletLqtDetailUI.pbo.setUrl(walletLqtDetailUI.paW.sfI.huW);
                walletLqtDetailUI.pbp.setText(walletLqtDetailUI.paW.sfI.title);
                walletLqtDetailUI.pbq.setText(walletLqtDetailUI.paW.sfI.desc);
                walletLqtDetailUI.pbn.setOnClickListener(new 13(walletLqtDetailUI));
                walletLqtDetailUI.pbm.setVisibility(0);
                walletLqtDetailUI.pbn.setVisibility(0);
            }
            walletLqtDetailUI.pbj.setVisibility(4);
            walletLqtDetailUI.pbj.post(new 14(walletLqtDetailUI));
            walletLqtDetailUI.pbg.setOnClickListener(new 2(walletLqtDetailUI));
            walletLqtDetailUI.pbh.setOnClickListener(new 3(walletLqtDetailUI));
        }
        walletLqtDetailUI.mController.removeAllOptionMenu();
        if (walletLqtDetailUI.paW != null) {
            walletLqtDetailUI.addIconOptionMenu(0, a.e.mm_title_btn_menu, new 4(walletLqtDetailUI));
        }
    }

    static /* synthetic */ ArrayList e(WalletLqtDetailUI walletLqtDetailUI) {
        ArrayList arrayList = new ArrayList();
        if (walletLqtDetailUI.paW.sfE != null && walletLqtDetailUI.paW.sfE.size() > 0) {
            Iterator it = walletLqtDetailUI.paW.sfE.iterator();
            while (it.hasNext()) {
                sj sjVar = (sj) it.next();
                if (!(bi.oW(sjVar.title) || bi.oW(sjVar.rvK))) {
                    arrayList.add(String.format("%s||%s", new Object[]{sjVar.title, sjVar.rvK}));
                }
            }
        }
        return arrayList;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        lF(getResources().getColor(c.wallet_lqt_detail_bg));
        cqh();
        setMMTitle(getString(i.wallet_lqt_title));
        int intExtra = getIntent().getIntExtra("key_account_type", 1);
        x.i("MicroMsg.WalletLqtDetailUI", "inputAccountType: %s", new Object[]{Integer.valueOf(intExtra)});
        this.paX = (ViewGroup) findViewById(f.detail_container_ll);
        this.paY = (TextView) findViewById(f.lqt_detail_title_tv);
        this.paZ = (WalletTextView) findViewById(f.lqt_detail_balance_amount_tv);
        this.pba = (ViewGroup) findViewById(f.detail_balance_layout);
        this.pbb = (TextView) findViewById(f.lqt_detail_balance_rate_hint_tv);
        this.pbc = (TextView) findViewById(f.lqt_detail_balance_rate_tv);
        this.pbd = (ViewGroup) findViewById(f.detail_gain_balance_layout);
        this.pbe = (TextView) findViewById(f.lqt_detail_gain_balance_hint_tv);
        this.pbf = (WalletTextView) findViewById(f.lqt_detail_gain_balance_tv);
        this.pbg = (Button) findViewById(f.lqt_detail_save_btn);
        this.pbh = (Button) findViewById(f.lqt_detail_fetch_btn);
        this.pbi = (LinearLayout) findViewById(f.lqt_detail_bottom_info_layout);
        this.pbj = (TextView) findViewById(f.lqt_detail_faq_link_tv);
        this.pbk = findViewById(f.lqt_detail_banner_ll);
        this.pbl = (TextView) findViewById(f.lqt_detail_banner_text);
        this.pbn = findViewById(f.lqt_detail_tiny_app_ll);
        this.pbo = (CdnImageView) findViewById(f.tiny_app_logo);
        this.pbp = (TextView) findViewById(f.tiny_app_name);
        this.pbq = (TextView) findViewById(f.tiny_app_desc);
        this.pbm = findViewById(f.lqt_detail_tiny_app_gap);
        this.pbj.setVisibility(4);
    }

    public void onResume() {
        super.onResume();
        if (this.pbr) {
            this.paX.setVisibility(8);
            this.eBX = com.tencent.mm.wallet_core.ui.g.b(this, false, null);
            com.tencent.mm.vending.g.g.cBK().c(this.paV.oYU).f(new 7(this)).a(new 1(this));
        }
        this.pbr = true;
    }

    protected final int getLayoutId() {
        return g.wallet_lqt_detail_ui;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 123 && i2 == -1) {
            this.pbr = false;
            String stringExtra = intent.getStringExtra("lqt_enc_pwd");
            if (this.eBX == null) {
                this.eBX = com.tencent.mm.wallet_core.ui.g.b(this, false, null);
            } else {
                this.eBX.show();
            }
            com.tencent.mm.vending.g.g.v(stringExtra, Integer.valueOf(this.paW.rtK)).c(this.paV.oYV).f(new 6(this)).a(new 5(this));
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.paU = null;
        this.paV = null;
    }
}
