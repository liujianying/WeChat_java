package com.tencent.mm.plugin.wallet.balance.ui;

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
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wxpay.a$e;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WalletBalanceFetchResultUI extends WalletBaseUI {
    private LinearLayout klz;
    private Orders mCZ;
    private ImageView mvq;
    private ImageView mvr;
    private ImageView mvs;
    private TextView mvt;
    private TextView mvu;
    private TextView mvv;
    private TextView mvw;
    private TextView mvx;
    private TextView mvy;

    static /* synthetic */ void a(WalletBalanceFetchResultUI walletBalanceFetchResultUI) {
        if (walletBalanceFetchResultUI.sy.containsKey("key_realname_guide_helper")) {
            RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) walletBalanceFetchResultUI.sy.getParcelable("key_realname_guide_helper");
            if (realnameGuideHelper != null) {
                Bundle bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".balance.ui.WalletBalanceResultUI");
                bundle.putString("realname_verify_process_jump_plugin", "wallet");
                realnameGuideHelper.b(walletBalanceFetchResultUI, bundle, new 3(walletBalanceFetchResultUI));
                walletBalanceFetchResultUI.sy.remove("key_realname_guide_helper");
                return;
            }
            return;
        }
        walletBalanceFetchResultUI.cDK().a(walletBalanceFetchResultUI, 0, walletBalanceFetchResultUI.sy);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
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
        this.mCZ = (Orders) this.sy.getParcelable("key_orders");
        initView();
        showHomeBtn(false);
        enableBackMenu(false);
        setMMTitle((String) cDL().ui(0));
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
        this.mvt.setText(i.wallet_balance_launch_fetch_title);
        this.mvu.setText(i.wallet_balance_fetch_waiting_title);
        this.mvu.setTextColor(getResources().getColor(c.normal_text_color));
        this.mvv.setText(i.wallet_balance_fetch_success_title);
        this.mvw = (TextView) findViewById(f.brdu_state_desc_tv_1);
        this.mvx = (TextView) findViewById(f.brdu_state_desc_tv_2);
        this.mvy = (TextView) findViewById(f.brdu_state_desc_tv_3);
        this.mvw.setVisibility(8);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        this.mvx.setText(getString(i.wallet_balance_fetch_expect_arrive_time, new Object[]{simpleDateFormat.format(new Date(this.mCZ.poZ))}));
        this.mvx.setVisibility(0);
        this.mvy.setVisibility(8);
        this.klz = (LinearLayout) findViewById(f.brdu_content_layout);
        this.klz.setBackgroundResource(a$e.bank_remit_detail_desc_singleline_layout_bg);
        WalletBalanceFetchResultItemView walletBalanceFetchResultItemView = new WalletBalanceFetchResultItemView(this, true);
        walletBalanceFetchResultItemView.b(i.wallet_balance_result_total_fee_fetch, e.e(this.mCZ.mBj, this.mCZ.lNV));
        this.klz.addView(walletBalanceFetchResultItemView);
        if (this.mCZ.mxE > 0.0d) {
            walletBalanceFetchResultItemView = new WalletBalanceFetchResultItemView(this, true);
            walletBalanceFetchResultItemView.b(i.wallet_balance_result_charge_fee, e.e(this.mCZ.mxE, this.mCZ.lNV));
            this.klz.addView(walletBalanceFetchResultItemView);
        }
        if (this.mCZ.ppf != null && this.mCZ.ppf.size() > 0) {
            CharSequence charSequence;
            Commodity commodity = (Commodity) this.mCZ.ppf.get(0);
            String str = commodity.lNT;
            if (bi.oW(commodity.ppy)) {
                Object charSequence2 = str;
            } else {
                charSequence2 = str + " " + getString(i.wallet_pay_bankcard_tail) + commodity.ppy;
            }
            WalletBalanceFetchResultItemView walletBalanceFetchResultItemView2 = new WalletBalanceFetchResultItemView(this);
            walletBalanceFetchResultItemView2.b(i.wallet_balance_fetch_bankcard_title, charSequence2);
            this.klz.addView(walletBalanceFetchResultItemView2);
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
