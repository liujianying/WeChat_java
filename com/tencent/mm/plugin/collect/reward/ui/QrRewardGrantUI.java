package com.tencent.mm.plugin.collect.reward.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.fp;
import com.tencent.mm.plugin.collect.reward.a.d;
import com.tencent.mm.plugin.collect.reward.a.e;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class QrRewardGrantUI extends QrRewardBaseUI {
    private RadioButton HP;
    private String bOd;
    private int bVU;
    private String fIb;
    private String hTI;
    private String hVA;
    private String hVB;
    private String hVC;
    private String hVD;
    private int hVE;
    private c<fp> hVF = new 8(this);
    private ImageView hVl;
    private TextView hVm;
    private TextView hVn;
    private WalletTextView hVo;
    private LinearLayout hVp;
    private WalletFormView hVq;
    private MMEditText hVr;
    private Button hVs;
    private int hVt;
    private int hVu;
    private String hVv;
    private String hVw;
    private String hVx;
    private String hVy;
    private String hVz;

    static /* synthetic */ void b(QrRewardGrantUI qrRewardGrantUI) {
        x.i("MicroMsg.QrRewardGrantUI", "do place order, amt: %s, amtType: %s, payer desc: %s showPayInfo %s", new Object[]{Integer.valueOf(qrRewardGrantUI.hVt), Integer.valueOf(qrRewardGrantUI.hVu), qrRewardGrantUI.hVr.getText().toString().replace("\n", ""), Integer.valueOf(qrRewardGrantUI.HP.isChecked() ? 1 : 0)});
        e eVar = new e(qrRewardGrantUI.hVt, qrRewardGrantUI.hVu, qrRewardGrantUI.hVz, qrRewardGrantUI.hVv, r5, qrRewardGrantUI.bVU, qrRewardGrantUI.hVB, qrRewardGrantUI.hVx, qrRewardGrantUI.fIb, qrRewardGrantUI.hVC, qrRewardGrantUI.hVD, r12);
        eVar.o(qrRewardGrantUI);
        qrRewardGrantUI.a(eVar, true, true);
    }

    static /* synthetic */ void d(QrRewardGrantUI qrRewardGrantUI) {
        x.i("MicroMsg.QrRewardGrantUI", "start pay");
        PayInfo payInfo = new PayInfo();
        payInfo.bOd = qrRewardGrantUI.bOd;
        payInfo.bVY = 48;
        Bundle bundle = new Bundle();
        bundle.putString("extinfo_key_1", qrRewardGrantUI.hVz);
        bundle.putString("extinfo_key_2", qrRewardGrantUI.hVA);
        bundle.putString("extinfo_key_3", qrRewardGrantUI.hVv);
        bundle.putString("extinfo_key_7", qrRewardGrantUI.hVr.getText().toString().replace("\n", ""));
        payInfo.qUL = bundle;
        h.a(qrRewardGrantUI, payInfo, 1);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        jr(1336);
        this.hVF.cht();
        setMMTitle(i.qr_reward_grant_title);
        this.hVt = getIntent().getIntExtra("key_money_amt", 20000);
        this.hVu = getIntent().getIntExtra("key_amt_type", 0);
        this.hVv = getIntent().getStringExtra("key_qrcode_desc");
        this.bVU = getIntent().getIntExtra("key_channel", 0);
        this.hVx = getIntent().getStringExtra("key_rcvr_open_id");
        this.hVz = getIntent().getStringExtra("key_rcvr_name");
        this.hVA = getIntent().getStringExtra("key_rcvr_true_name");
        this.hVB = getIntent().getStringExtra("key_scan_id");
        this.fIb = getIntent().getStringExtra("key_web_url");
        this.hVC = getIntent().getStringExtra("key_sxtend_1");
        this.hVD = getIntent().getStringExtra("key_sxtend_2");
        this.hVE = getIntent().getIntExtra("key_max_amt", 20000);
        x.i("MicroMsg.QrRewardGrantUI", "amtType: %s, channel: %s, maxAmt: %s", new Object[]{Integer.valueOf(this.hVu), Integer.valueOf(this.bVU), Integer.valueOf(this.hVE)});
        initView();
    }

    public final void initView() {
        this.hVl = (ImageView) findViewById(a$f.qrgu_avatar_iv);
        this.hVm = (TextView) findViewById(a$f.qrgu_desc_tv);
        this.hVo = (WalletTextView) findViewById(a$f.qrgu_fixed_money_tv);
        this.hVp = (LinearLayout) findViewById(a$f.qrgu_fixed_layout);
        this.hVq = (WalletFormView) findViewById(a$f.qrgu_edit_money_et);
        this.hVr = (MMEditText) findViewById(a$f.qrgu_edit_word_et);
        this.hVs = (Button) findViewById(a$f.qrgu_grant_btn);
        this.hVn = (TextView) findViewById(a$f.qrgu_alert_tv);
        this.HP = (RadioButton) findViewById(a$f.radio_check);
        this.HP.setChecked(true);
        this.hVn.setText(getString(i.qr_reward_set_money_exceed_text, new Object[]{Math.round(((float) this.hVE) / 100.0f)}));
        b.a(this.hVl, this.hVz, 0.03f, false);
        String dx = com.tencent.mm.wallet_core.ui.e.dx(com.tencent.mm.wallet_core.ui.e.gT(this.hVz), 10);
        this.hVm.setText(j.a(this, getString(i.qr_reward_grant_username_wrap_text, new Object[]{dx})));
        if (this.hVu == 2) {
            x.i("MicroMsg.QrRewardGrantUI", "edit layout");
            d(this.hVq, 2, false);
            this.hVq.a(new 1(this));
            this.hVq.setVisibility(0);
            this.hVp.setVisibility(8);
            this.hVq.cDV();
            this.hVs.setEnabled(false);
        } else {
            this.hVo.setText(com.tencent.mm.wallet_core.ui.e.A(((double) this.hVt) / 100.0d));
            this.hVq.setVisibility(8);
            this.hVp.setVisibility(0);
        }
        this.hVs.setOnClickListener(new 2(this));
        findViewById(a$f.radio_check_ll).setOnClickListener(new 3(this));
        this.HP.setOnCheckedChangeListener(new 4(this));
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (lVar instanceof e) {
            e eVar = (e) lVar;
            eVar.a(new 7(this, eVar)).b(new 6(this, eVar)).c(new 5(this));
        }
        return true;
    }

    public void onDestroy() {
        super.onDestroy();
        js(1336);
        this.hVF.dead();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i != 1) {
            super.onActivityResult(i, i2, intent);
        } else if (i2 == -1) {
            setResult(-1);
            if (intent != null) {
                cm(intent.getStringExtra("key_reqKey"), intent.getStringExtra("key_trans_id"));
            }
            finish();
        }
    }

    protected final int getLayoutId() {
        return a$g.qr_reward_grant_ui;
    }

    private void cm(String str, String str2) {
        x.i("MicroMsg.QrRewardGrantUI", "do pay check");
        if (bi.oW(this.bOd)) {
            this.bOd = str;
        }
        if (bi.oW(this.hTI)) {
            this.hTI = str2;
        }
        a(new d(this.bOd, this.hVw, this.hTI, this.hVt, this.hVx, this.hVy), false, false);
    }
}
