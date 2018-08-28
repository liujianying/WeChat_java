package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.plugin.remittance.bankcard.a.l;
import com.tencent.mm.plugin.wxpay.a$e;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;

@a(19)
public class BankRemitDetailUI extends BankRemitBaseUI {
    private int eEZ;
    private Button klJ;
    private LinearLayout klz;
    private int mState;
    private View mvA;
    private ViewGroup mvB;
    private String mvC;
    private ImageView mvq;
    private ImageView mvr;
    private ImageView mvs;
    private TextView mvt;
    private TextView mvu;
    private TextView mvv;
    private TextView mvw;
    private TextView mvx;
    private TextView mvy;
    private View mvz;

    static /* synthetic */ void a(BankRemitDetailUI bankRemitDetailUI, int i, String str) {
        int i2 = 1;
        switch (i) {
            case 1:
                bankRemitDetailUI.mvr.setScaleType(ScaleType.CENTER_CROP);
                bankRemitDetailUI.mvr.setImageResource(h.bank_remit_waiting);
                bankRemitDetailUI.mvx.setTextColor(bankRemitDetailUI.getResources().getColor(c.normal_text_color));
                bankRemitDetailUI.mvu.setText(i.bank_remit_detail_state_bank_handling);
                if (!bi.oW(str)) {
                    bankRemitDetailUI.mvx.setText(str);
                    bankRemitDetailUI.mvx.setVisibility(0);
                    break;
                }
                break;
            case 2:
                bankRemitDetailUI.mvA.setBackground(bankRemitDetailUI.getResources().getDrawable(a$e.bank_remit_detail_state_line_succ));
                bankRemitDetailUI.mvs.setScaleType(ScaleType.CENTER_CROP);
                bankRemitDetailUI.mvs.setImageResource(h.bank_remit_success);
                bankRemitDetailUI.mvv.setTextColor(bankRemitDetailUI.getResources().getColor(c.normal_text_color));
                if (!bi.oW(str)) {
                    bankRemitDetailUI.mvy.setText(str);
                    bankRemitDetailUI.mvy.setVisibility(0);
                    break;
                }
                break;
            case 3:
                bankRemitDetailUI.mvr.setScaleType(ScaleType.CENTER_CROP);
                bankRemitDetailUI.mvr.setImageResource(h.bank_remit_delay);
                bankRemitDetailUI.mvu.setTextColor(bankRemitDetailUI.getResources().getColor(c.normal_text_color));
                bankRemitDetailUI.mvu.setText(i.bank_remit_detail_state_delay);
                if (!bi.oW(str)) {
                    bankRemitDetailUI.mvx.setText(str);
                    bankRemitDetailUI.mvx.setVisibility(0);
                    break;
                }
                break;
            case 4:
                bankRemitDetailUI.mvr.setScaleType(ScaleType.CENTER_CROP);
                bankRemitDetailUI.mvr.setImageResource(h.bank_remit_fail);
                bankRemitDetailUI.mvu.setTextColor(bankRemitDetailUI.getResources().getColor(c.normal_text_color));
                bankRemitDetailUI.mvu.setText(i.bank_remit_detail_state_refunding);
                if (!bi.oW(str)) {
                    bankRemitDetailUI.mvx.setText(str);
                    bankRemitDetailUI.mvx.setVisibility(0);
                    break;
                }
                break;
            case 5:
                bankRemitDetailUI.mvs.setScaleType(ScaleType.CENTER_CROP);
                bankRemitDetailUI.mvs.setImageResource(h.bank_remit_fail);
                bankRemitDetailUI.mvv.setTextColor(bankRemitDetailUI.getResources().getColor(c.normal_text_color));
                bankRemitDetailUI.mvv.setText(i.bank_remit_detail_state_fail);
                if (!bi.oW(str)) {
                    bankRemitDetailUI.mvy.setText(str);
                    bankRemitDetailUI.mvy.setVisibility(0);
                    break;
                }
                break;
            default:
                x.w("MicroMsg.BankRemitDetailUI", "unknown state: %s", new Object[]{Integer.valueOf(bankRemitDetailUI.mState)});
                i2 = 0;
                break;
        }
        if (i2 != 0) {
            bankRemitDetailUI.findViewById(f.brdu_timeline_mask).setVisibility(8);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        jr(1579);
        this.mvC = getIntent().getStringExtra("key_transfer_bill_id");
        this.eEZ = getIntent().getIntExtra("key_enter_scene", 0);
        x.i("MicroMsg.BankRemitDetailUI", "billId: %s, enterScene: %s", new Object[]{this.mvC, Integer.valueOf(this.eEZ)});
        initView();
        x.i("MicroMsg.BankRemitDetailUI", "do query detail");
        a(new l(this.mvC), true, true);
        if (this.eEZ == 0) {
            showHomeBtn(false);
            enableBackMenu(false);
            setMMTitle(i.bank_remit_detail_title_2);
        } else {
            showHomeBtn(true);
            enableBackMenu(true);
            setMMTitle(i.bank_remit_detail_title_1);
        }
        setBackBtn(new 1(this));
    }

    public final void initView() {
        this.mvq = (ImageView) findViewById(f.brdu_state_iv_1);
        this.mvr = (ImageView) findViewById(f.brdu_state_iv_2);
        this.mvs = (ImageView) findViewById(f.brdu_state_iv_3);
        this.mvt = (TextView) findViewById(f.brdu_state_title_tv_1);
        this.mvu = (TextView) findViewById(f.brdu_state_title_tv_2);
        this.mvv = (TextView) findViewById(f.brdu_state_title_tv_3);
        this.mvw = (TextView) findViewById(f.brdu_state_desc_tv_1);
        this.mvx = (TextView) findViewById(f.brdu_state_desc_tv_2);
        this.mvy = (TextView) findViewById(f.brdu_state_desc_tv_3);
        this.mvz = findViewById(f.brdu_state_line_1);
        this.mvA = findViewById(f.brdu_state_line_2);
        this.klz = (LinearLayout) findViewById(f.brdu_content_layout);
        this.mvB = (ViewGroup) findViewById(f.brdu_root_layout);
        if (this.eEZ == 1) {
            findViewById(f.brdu_finish_layout).setVisibility(8);
            return;
        }
        this.klJ = (Button) findViewById(f.brdu_finish_btn);
        this.klJ.setOnClickListener(new 2(this));
    }

    protected final void aWd() {
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
        }
        BankRemitBaseUI.E(this);
        this.mController.contentView.setFitsSystemWindows(true);
    }

    public final boolean d(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        if (lVar instanceof l) {
            final l lVar2 = (l) lVar;
            lVar2.a(new 5(this, lVar2)).b(new com.tencent.mm.wallet_core.c.h.a() {
                public final void g(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
                    x.e("MicroMsg.BankRemitDetailUI", "detail reponse error: %s, %s", new Object[]{Integer.valueOf(lVar2.mud.hUm), lVar2.mud.hUn});
                    if (bi.oW(lVar2.mud.hUn)) {
                        Toast.makeText(BankRemitDetailUI.this, i.bank_remit_detail_fetch_fail_text, 1).show();
                    } else {
                        Toast.makeText(BankRemitDetailUI.this, lVar2.mud.hUn, 1).show();
                    }
                }
            }).c(new 3(this));
        }
        return true;
    }

    protected final int getLayoutId() {
        return g.bank_remit_detail_ui;
    }

    public void onDestroy() {
        super.onDestroy();
        js(1579);
    }
}
