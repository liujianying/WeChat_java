package com.tencent.mm.plugin.honey_pay.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet_core.ui.m.a;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.ui.d.m;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.v;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.math.RoundingMode;

public class HoneyPayGiveCardUI extends HoneyPayBaseUI {
    private String gtX;
    private ImageView hVP;
    private String hYh;
    private String iAb;
    private long kkP = 100000;
    private long kkQ = 0;
    private String kla;
    private int klc;
    private ScrollView klj;
    private WalletFormView klk;
    private TextView kll;
    private TextView klm;
    private TextView kln;
    private TextView klo;
    private TextView klp;
    private TextView klq;
    private CdnImageView klr;

    static /* synthetic */ boolean a(HoneyPayGiveCardUI honeyPayGiveCardUI) {
        if (bi.oW(honeyPayGiveCardUI.klk.getText())) {
            x.d(honeyPayGiveCardUI.TAG, "no input, hide alert");
            honeyPayGiveCardUI.fG(false);
            honeyPayGiveCardUI.fF(false);
            honeyPayGiveCardUI.fH(false);
            return false;
        }
        int gp = e.gp(honeyPayGiveCardUI.klk.getText(), "100");
        x.d(honeyPayGiveCardUI.TAG, "current fen: %s", new Object[]{Integer.valueOf(gp)});
        if (((long) gp) < honeyPayGiveCardUI.kkQ) {
            honeyPayGiveCardUI.fF(true);
            honeyPayGiveCardUI.fH(false);
            return false;
        } else if (((long) gp) > honeyPayGiveCardUI.kkP) {
            honeyPayGiveCardUI.fG(true);
            honeyPayGiveCardUI.fH(false);
            return false;
        } else if (gp == 0) {
            honeyPayGiveCardUI.fH(false);
            return false;
        } else {
            honeyPayGiveCardUI.fG(false);
            honeyPayGiveCardUI.fF(false);
            honeyPayGiveCardUI.fH(true);
            return true;
        }
    }

    static /* synthetic */ void d(HoneyPayGiveCardUI honeyPayGiveCardUI) {
        x.i(honeyPayGiveCardUI.TAG, "go to pwd ui");
        long gq = e.gq(honeyPayGiveCardUI.klk.getText(), "100");
        String stringExtra = honeyPayGiveCardUI.getIntent().getStringExtra("key_take_message");
        Intent intent = new Intent(honeyPayGiveCardUI.mController.tml, HoneyPayCheckPwdUI.class);
        intent.putExtra("key_scene", 1);
        intent.putExtra("key_credit_line", gq);
        intent.putExtra("key_take_message", stringExtra);
        intent.putExtra("key_username", honeyPayGiveCardUI.gtX);
        intent.putExtra("key_wishing", honeyPayGiveCardUI.kla);
        intent.putExtra("key_cardtype", honeyPayGiveCardUI.klc);
        honeyPayGiveCardUI.startActivity(intent);
    }

    public void onCreate(Bundle bundle) {
        this.kjV = c.honey_pay_grey_bg_1;
        super.onCreate(bundle);
        this.kkP = getIntent().getLongExtra("key_max_credit_line", 0);
        this.kkQ = getIntent().getLongExtra("key_min_credit_line", 0);
        this.hYh = getIntent().getStringExtra("key_true_name");
        this.gtX = getIntent().getStringExtra("key_username");
        this.kla = getIntent().getStringExtra("key_wishing");
        this.iAb = getIntent().getStringExtra("key_icon_url");
        this.klc = getIntent().getIntExtra("key_cardtype", 0);
        if (this.klc == 0) {
            x.w(this.TAG, "error card type!!");
            finish();
        }
        initView();
        setMMTitle(a$i.honey_pay_give_card_title);
    }

    protected final void initView() {
        this.klj = (ScrollView) findViewById(f.hpgc_scroll_view);
        this.klk = (WalletFormView) findViewById(f.hpgc_max_limit_et);
        this.kll = (TextView) findViewById(f.hpgc_display_name_tv);
        this.klm = (TextView) findViewById(f.hpgc_top_alert_tv);
        this.hVP = (ImageView) findViewById(f.hpgc_avatar_iv);
        this.kln = (TextView) findViewById(f.hpgc_give_btn);
        this.klo = (TextView) findViewById(f.hpgc_limit_hint_tv);
        this.klp = (TextView) findViewById(f.hpgc_wishing_tv);
        this.klq = (TextView) findViewById(f.hpgc_modify_wishing_tv);
        this.klq.setVisibility(8);
        b.a(this.hVP, this.gtX, 0.06f, false);
        CharSequence dy = e.dy(this.gtX, 10);
        if (!bi.oW(this.hYh)) {
            dy = String.format("%s(%s)", new Object[]{dy, this.hYh});
        }
        this.kll.setText(j.a(this.mController.tml, dy, this.kll.getTextSize()));
        this.klk.cDS();
        this.klk.getTitleTv().setText(v.cDm());
        this.klk.a(new 1(this));
        this.klk.setOnClickListener(new 2(this));
        this.klo.setOnClickListener(new 3(this));
        this.kln.setClickable(true);
        this.kln.setOnClickListener(new 4(this));
        this.klp.setClickable(true);
        this.klp.setOnTouchListener(new m(this));
        aWi();
        this.kTx = new 5(this);
        d(this.klk, 2, false);
        this.klk.postDelayed(new Runnable() {
            public final void run() {
                HoneyPayGiveCardUI.this.klk.d(HoneyPayGiveCardUI.this);
            }
        }, 100);
        this.klr = (CdnImageView) findViewById(f.hpgc_quota_logo_2_iv);
        if (bi.oW(this.iAb)) {
            this.klr.setImageResource(com.tencent.mm.plugin.honey_pay.model.c.aWc());
        } else {
            this.klr.cS(this.iAb, com.tencent.mm.plugin.honey_pay.model.c.aWc());
        }
    }

    private void aWi() {
        CharSequence spannableStringBuilder = new SpannableStringBuilder();
        CharSequence string = getString(a$i.honey_pay_modify_word_text);
        CharSequence a = j.a(this.mController.tml, this.kla, this.klp.getTextSize());
        spannableStringBuilder.append(a);
        spannableStringBuilder.append(" ");
        spannableStringBuilder.append(string);
        spannableStringBuilder.setSpan(new com.tencent.mm.plugin.wallet_core.ui.m(new a() {
            public final void aCb() {
                HoneyPayGiveCardUI.this.Wq();
                com.tencent.mm.plugin.wallet_core.ui.view.a.a(HoneyPayGiveCardUI.this, HoneyPayGiveCardUI.this.getString(a$i.honey_pay_modify_wishing_title), HoneyPayGiveCardUI.this.kla, "", 20, new 1(this), new 2(this));
            }
        }), a.length() + 1, spannableStringBuilder.length(), 34);
        this.klp.setText(spannableStringBuilder);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        return false;
    }

    protected final int getLayoutId() {
        return g.honey_pay_give_card_ui;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    private void fF(boolean z) {
        if (z && !this.klm.isShown()) {
            String str = v.cDm() + e.a(this.kkQ, "100", RoundingMode.HALF_UP);
            this.klm.setText(getString(a$i.honey_pay_min_quota_alert_text, new Object[]{str}));
            this.klm.startAnimation(AnimationUtils.loadAnimation(this, com.tencent.mm.plugin.wxpay.a.a.in_from_up));
            this.klm.setVisibility(0);
        } else if (!z && this.klm.isShown()) {
            this.klm.startAnimation(AnimationUtils.loadAnimation(this, com.tencent.mm.plugin.wxpay.a.a.out_to_up));
            this.klm.setVisibility(8);
        }
    }

    private void fG(boolean z) {
        if (z && !this.klm.isShown()) {
            String str = v.cDm() + e.b(this.kkP, "100", RoundingMode.HALF_UP).toString();
            this.klm.setText(getString(a$i.honey_pay_max_quota_alert_text, new Object[]{str}));
            this.klm.startAnimation(AnimationUtils.loadAnimation(this, com.tencent.mm.plugin.wxpay.a.a.in_from_up));
            this.klm.setVisibility(0);
        } else if (!z && this.klm.isShown()) {
            this.klm.startAnimation(AnimationUtils.loadAnimation(this, com.tencent.mm.plugin.wxpay.a.a.out_to_up));
            this.klm.setVisibility(8);
        }
    }

    private void fH(boolean z) {
        this.kln.setEnabled(z);
    }
}
