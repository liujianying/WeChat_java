package com.tencent.mm.plugin.collect.reward.ui;

import android.os.Bundle;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.collect.reward.a.g;
import com.tencent.mm.plugin.collect.reward.b.b;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.ui.base.MMGridView;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class QrRewardSetMoneyUI extends QrRewardBaseUI {
    private String desc;
    private String fkq;
    private TextView gsY;
    private int hVE;
    private ImageView hVP;
    private MMGridView hWA;
    private Button hWB;
    private MMEditText hWC;
    private TextView hWD;
    private TextView hWE;
    private SparseArray<WalletFormView> hWF;
    private List<Integer> hWG;
    private List<Integer> hWH;
    private boolean hWI = false;
    private Runnable hWJ = new 5(this);
    private TextWatcher hWK = new 6(this);

    static /* synthetic */ boolean a(QrRewardSetMoneyUI qrRewardSetMoneyUI) {
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < qrRewardSetMoneyUI.hWF.size(); i++) {
            WalletFormView walletFormView = (WalletFormView) qrRewardSetMoneyUI.hWF.get(i);
            int round = (int) Math.round(bi.getDouble(walletFormView.getText(), 0.0d) * 100.0d);
            qrRewardSetMoneyUI.hWH.set(i, Integer.valueOf(round));
            if (round > qrRewardSetMoneyUI.hVE) {
                walletFormView.setContentTextColorRes(c.QrRewardAlertColor);
                z2 = true;
            } else {
                if (round <= 0) {
                    z = true;
                }
                walletFormView.setContentTextColorRes(c.black);
            }
        }
        if (z2) {
            if (!qrRewardSetMoneyUI.hWD.isShown()) {
                qrRewardSetMoneyUI.hWD.startAnimation(AnimationUtils.loadAnimation(qrRewardSetMoneyUI, a.in_from_up));
                qrRewardSetMoneyUI.hWD.setVisibility(0);
            }
            qrRewardSetMoneyUI.hWB.setEnabled(false);
        } else if (z) {
            qrRewardSetMoneyUI.hWB.setEnabled(false);
        } else {
            if (qrRewardSetMoneyUI.hWD.isShown()) {
                qrRewardSetMoneyUI.hWD.startAnimation(AnimationUtils.loadAnimation(qrRewardSetMoneyUI, a.out_to_up));
                qrRewardSetMoneyUI.hWD.setVisibility(8);
            }
            qrRewardSetMoneyUI.hWB.setEnabled(true);
        }
        return z2;
    }

    static /* synthetic */ void b(QrRewardSetMoneyUI qrRewardSetMoneyUI) {
        x.i("MicroMsg.QrRewardSetMoneyUI", "do set code");
        g gVar = new g(new LinkedList(qrRewardSetMoneyUI.hWH), qrRewardSetMoneyUI.hWC.getText().toString().replace("\n", ""), qrRewardSetMoneyUI.hWI, qrRewardSetMoneyUI.aCc());
        gVar.o(qrRewardSetMoneyUI);
        qrRewardSetMoneyUI.a(gVar, true, false);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(i.qr_reward_set_money_title);
        jr(1562);
        List<String> fQ = bi.fQ((String) com.tencent.mm.kernel.g.Ei().DT().get(aa.a.sYT, ""), ",");
        this.hWG = new ArrayList();
        if (fQ.isEmpty()) {
            x.i("MicroMsg.QrRewardSetMoneyUI", "use client hardcode amt list");
            this.hWG = Arrays.asList(b.hVj);
        } else {
            for (String str : fQ) {
                this.hWG.add(Integer.valueOf(bi.getInt(str, 0)));
            }
        }
        this.hWH = new ArrayList(this.hWG);
        this.hVE = ((Integer) com.tencent.mm.kernel.g.Ei().DT().get(aa.a.sYS, Integer.valueOf(20000))).intValue();
        this.hWI = getIntent().getBooleanExtra("key_first_flag", false);
        this.desc = getIntent().getStringExtra("key_desc_word");
        this.hWF = new SparseArray();
        aCd();
        initView();
    }

    protected final void initView() {
        this.hWA = (MMGridView) findViewById(f.qrsu_money_layout_new);
        this.hWB = (Button) findViewById(f.qrsu_gen_btn);
        this.hWD = (TextView) findViewById(f.qrsu_alert_tv);
        this.hVP = (ImageView) findViewById(f.qrsu_avatar_iv);
        this.hWC = (MMEditText) findViewById(f.qrsu_reward_et);
        this.gsY = (TextView) findViewById(f.qrsu_title_tv);
        this.hWE = (TextView) findViewById(f.qrsu_bottom_tips_tv);
        CharSequence GH = q.GH();
        if (bi.oW(GH)) {
            GH = q.GI();
        }
        this.gsY.setText(j.a(this.mController.tml, GH));
        com.tencent.mm.pluginsdk.ui.a.b.a(this.hVP, q.GF(), 0.06f, false);
        this.hWA.setAdapter(new a(this, (byte) 0));
        if (!bi.oW(this.desc)) {
            this.hWC.setText(j.a(this, this.desc, this.hWC.getTextSize()));
        }
        this.hWD.setText(getString(i.qr_reward_set_money_exceed_text, new Object[]{Math.round(((float) this.hVE) / 100.0f)}));
        if (this.hWI) {
            this.hWB.setText(i.qr_reward_first_set_money_btn_text);
            this.hWE.setVisibility(8);
        }
        this.hWB.setOnClickListener(new 1(this));
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.qr_reward_setting_ui;
    }

    public void onDestroy() {
        super.onDestroy();
        js(1562);
        ah.M(this.hWJ);
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (lVar instanceof g) {
            final g gVar = (g) lVar;
            gVar.a(new 4(this, gVar)).b(new com.tencent.mm.plugin.collect.reward.a.a.a() {
                public final void i(l lVar) {
                    x.e("MicroMsg.QrRewardSetMoneyUI", "set code error: %s, %s", new Object[]{Integer.valueOf(gVar.hVd.hUm), gVar.hVd.hUn});
                    if (bi.oW(gVar.hVd.hUn)) {
                        Toast.makeText(QrRewardSetMoneyUI.this, i.qr_reward_set_code_failure_text, 1).show();
                    } else {
                        Toast.makeText(QrRewardSetMoneyUI.this, gVar.hVd.hUn, 1).show();
                    }
                }
            }).c(new 2(this));
        }
        return false;
    }

    private boolean aCc() {
        int i = 0;
        while (i < this.hWG.size()) {
            if (((Integer) this.hWG.get(i)).equals(this.hWH.get(i))) {
                i++;
            } else {
                x.i("MicroMsg.QrRewardSetMoneyUI", "modify money: %s, %s", new Object[]{this.hWG.get(i), this.hWH.get(i)});
                return true;
            }
        }
        return false;
    }

    private void aCd() {
        for (int i = 0; i < this.hWH.size(); i++) {
            WalletFormView walletFormView = (WalletFormView) LayoutInflater.from(this.mController.tml).inflate(com.tencent.mm.plugin.wxpay.a.g.qr_reward_setting_item, null);
            walletFormView.a(this.hWK);
            int intValue = ((Integer) this.hWH.get(i)).intValue();
            if (((double) intValue) / 100.0d > ((double) (intValue / 100))) {
                walletFormView.setText(String.format("%.2f", new Object[]{Double.valueOf(((double) intValue) / 100.0d)}));
            } else {
                walletFormView.setText(String.format("%d", new Object[]{Integer.valueOf(intValue / 100)}));
            }
            d(walletFormView, 2, false);
            this.hWF.put(i, walletFormView);
        }
    }
}
