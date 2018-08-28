package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchResultItemView;
import com.tencent.mm.plugin.wxpay.a$e;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.bft;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

public class WalletLqtSaveFetchFinishProgressUI extends WalletBaseUI {
    private LinearLayout klz;
    private ImageView mvq;
    private ImageView mvr;
    private ImageView mvs;
    private TextView mvt;
    private TextView mvu;
    private TextView mvv;
    private TextView mvw;
    private TextView mvx;
    private TextView mvy;
    private bft pbx;

    public void onCreate(Bundle bundle) {
        String format;
        super.onCreate(bundle);
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("key_redeem_res");
        this.pbx = new bft();
        try {
            this.pbx.aG(byteArrayExtra);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WalletLqtSaveFetchFinishProgressUI", e, "parse redeemFundRes error!", new Object[0]);
            finish();
        }
        String str = "MicroMsg.WalletLqtSaveFetchFinishProgressUI";
        String str2 = "onCreate, redeemRes: %s";
        Object[] objArr = new Object[1];
        if (this.pbx != null) {
            format = String.format("status:%s, wording_for_status2:%s, pre_arrive_time_wording:%s, redeem_fee:%s, bank_name:%s, card_tail:%s, failure_wording:%s", new Object[]{Integer.valueOf(this.pbx.status), this.pbx.sgT, this.pbx.sgU, Integer.valueOf(this.pbx.sdC), this.pbx.knE, this.pbx.lNU, this.pbx.sgV});
        } else {
            format = "";
        }
        objArr[0] = format;
        x.i(str, str2, objArr);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(c.white)));
        View customView = getSupportActionBar().getCustomView();
        if (customView != null) {
            View findViewById = customView.findViewById(f.divider);
            if (findViewById != null) {
                findViewById.setBackgroundColor(getResources().getColor(c.half_alpha_white));
            }
            customView = customView.findViewById(16908308);
            if (customView != null && (customView instanceof TextView)) {
                ((TextView) customView).setTextColor(getResources().getColor(c.black));
            }
        }
        if (VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(getResources().getColor(c.white));
            if (VERSION.SDK_INT >= 23) {
                getWindow().getDecorView().setSystemUiVisibility(8192);
            }
        }
        this.mController.contentView.setFitsSystemWindows(true);
        initView();
        showHomeBtn(false);
        enableBackMenu(false);
        lD(false);
        setMMTitle(i.wallet_lqt_fetch_progress_title);
        setBackBtn(new 1(this));
    }

    protected final void initView() {
        this.mvq = (ImageView) findViewById(f.brdu_state_iv_1);
        this.mvr = (ImageView) findViewById(f.brdu_state_iv_2);
        this.mvs = (ImageView) findViewById(f.brdu_state_iv_3);
        this.mvq.setImageResource(a$e.bank_remit_detail_state_circle_succ);
        this.mvr.setScaleType(ScaleType.CENTER_CROP);
        this.mvr.setImageResource(h.remittance_wait);
        this.mvs.setImageResource(a$e.bank_remit_detail_state_circle_unknown);
        this.mvt = (TextView) findViewById(f.brdu_state_title_tv_1);
        this.mvu = (TextView) findViewById(f.brdu_state_title_tv_2);
        this.mvv = (TextView) findViewById(f.brdu_state_title_tv_3);
        this.mvt.setText(i.wallet_lqt_launch_fetch_title);
        this.mvu.setText(this.pbx.sgT);
        this.mvu.setTextColor(getResources().getColor(c.normal_text_color));
        this.mvv.setText(i.wallet_balance_fetch_success_title);
        this.mvw = (TextView) findViewById(f.brdu_state_desc_tv_1);
        this.mvx = (TextView) findViewById(f.brdu_state_desc_tv_2);
        this.mvy = (TextView) findViewById(f.brdu_state_desc_tv_3);
        this.mvw.setVisibility(8);
        this.mvx.setText(this.pbx.sgU);
        this.mvx.setVisibility(0);
        this.mvy.setVisibility(8);
        this.klz = (LinearLayout) findViewById(f.brdu_content_layout);
        this.klz.setBackgroundResource(a$e.bank_remit_detail_desc_singleline_layout_bg);
        WalletBalanceFetchResultItemView walletBalanceFetchResultItemView = new WalletBalanceFetchResultItemView(this, true);
        walletBalanceFetchResultItemView.b(i.wallet_lqt_result_total_fee_fetch, e.B((double) (((float) this.pbx.sdC) / 100.0f)));
        this.klz.addView(walletBalanceFetchResultItemView);
        if (!bi.oW(this.pbx.knE)) {
            CharSequence charSequence = this.pbx.knE;
            if (!bi.oW(this.pbx.lNU)) {
                charSequence = charSequence + " " + getString(i.wallet_pay_bankcard_tail) + this.pbx.lNU;
            }
            WalletBalanceFetchResultItemView walletBalanceFetchResultItemView2 = new WalletBalanceFetchResultItemView(this);
            walletBalanceFetchResultItemView2.b(i.wallet_lqt_fetch_progress_account, charSequence);
            this.klz.addView(walletBalanceFetchResultItemView2);
        }
        if (!bi.oW(this.pbx.sgV)) {
            walletBalanceFetchResultItemView = new WalletBalanceFetchResultItemView(this);
            walletBalanceFetchResultItemView.b(i.wallet_lqt_fetch_failed_wording_mark, this.pbx.sgV);
            this.klz.addView(walletBalanceFetchResultItemView);
        }
        ((Button) findViewById(f.brdu_finish_btn)).setOnClickListener(new 2(this));
        findViewById(f.brdu_timeline_mask).setVisibility(8);
        findViewById(f.brdu_content_mask).setVisibility(8);
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        return false;
    }

    protected final int getLayoutId() {
        return g.bank_remit_detail_ui;
    }
}
