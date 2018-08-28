package com.tencent.mm.plugin.honey_pay.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.v;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.math.RoundingMode;

public class HoneyPayModifyQuotaUI extends HoneyPayBaseUI {
    private long kkP;
    private long kkQ;
    private String kkc;
    private WalletFormView klI;
    private Button klJ;
    private TextView klm;

    static /* synthetic */ boolean a(HoneyPayModifyQuotaUI honeyPayModifyQuotaUI) {
        if (bi.oW(honeyPayModifyQuotaUI.klI.getText())) {
            honeyPayModifyQuotaUI.fG(false);
            honeyPayModifyQuotaUI.fF(false);
            honeyPayModifyQuotaUI.fH(false);
            return false;
        }
        int gp = e.gp(honeyPayModifyQuotaUI.klI.getText(), "100");
        x.d(honeyPayModifyQuotaUI.TAG, "current fen: %s", new Object[]{Integer.valueOf(gp)});
        if (((long) gp) < honeyPayModifyQuotaUI.kkQ) {
            honeyPayModifyQuotaUI.fF(true);
            honeyPayModifyQuotaUI.fH(false);
            return false;
        } else if (((long) gp) > honeyPayModifyQuotaUI.kkP) {
            honeyPayModifyQuotaUI.fG(true);
            honeyPayModifyQuotaUI.fH(false);
            return false;
        } else if (gp == 0) {
            honeyPayModifyQuotaUI.fH(false);
            return false;
        } else {
            honeyPayModifyQuotaUI.fG(false);
            honeyPayModifyQuotaUI.fF(false);
            honeyPayModifyQuotaUI.fH(true);
            return true;
        }
    }

    static /* synthetic */ void b(HoneyPayModifyQuotaUI honeyPayModifyQuotaUI) {
        x.i(honeyPayModifyQuotaUI.TAG, "go to check pwd ui");
        long gq = e.gq(honeyPayModifyQuotaUI.klI.getText(), "100");
        Intent intent = new Intent(honeyPayModifyQuotaUI, HoneyPayCheckPwdUI.class);
        intent.putExtra("key_scene", 2);
        intent.putExtra("key_credit_line", gq);
        intent.putExtra("key_card_no", honeyPayModifyQuotaUI.kkc);
        honeyPayModifyQuotaUI.startActivityForResult(intent, 1);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kkP = getIntent().getLongExtra("key_max_credit_line", 0);
        this.kkQ = getIntent().getLongExtra("key_min_credit_line", 0);
        this.kkc = getIntent().getStringExtra("key_card_no");
        initView();
        setMMTitle(a$i.honey_pay_modify_quota_title);
    }

    protected final void initView() {
        this.klI = (WalletFormView) findViewById(f.hpmq_quota_et);
        this.klJ = (Button) findViewById(f.hpmq_finish_btn);
        this.klm = (TextView) findViewById(f.hpmq_top_alert_tv);
        this.klI.cDS();
        this.klI.getTitleTv().setText(v.cDm());
        d(this.klI, 2, false);
        this.klI.a(new 1(this));
        this.klJ.setOnClickListener(new 2(this));
        this.klI.postDelayed(new 3(this), 100);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        return false;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1 && i2 == -1 && intent.getBooleanExtra("key_modify_create_line_succ", false)) {
            setResult(-1, intent);
            finish();
        }
        super.onActivityResult(i, i2, intent);
    }

    protected final int getLayoutId() {
        return g.honey_pay_modify_quota_ui;
    }

    private void fF(boolean z) {
        if (z && !this.klm.isShown()) {
            String str = v.cDm() + e.b(this.kkQ, "100", RoundingMode.HALF_UP).toString();
            this.klm.setText(getString(a$i.honey_pay_min_quota_alert_text, new Object[]{str}));
            this.klm.startAnimation(AnimationUtils.loadAnimation(this, a.in_from_up));
            this.klm.setVisibility(0);
        } else if (!z && this.klm.isShown()) {
            this.klm.startAnimation(AnimationUtils.loadAnimation(this, a.out_to_up));
            this.klm.setVisibility(8);
        }
    }

    private void fG(boolean z) {
        if (z && !this.klm.isShown()) {
            String str = v.cDm() + e.b(this.kkP, "100", RoundingMode.HALF_UP);
            this.klm.setText(getString(a$i.honey_pay_max_quota_alert_text, new Object[]{str}));
            this.klm.startAnimation(AnimationUtils.loadAnimation(this, a.in_from_up));
            this.klm.setVisibility(0);
        } else if (!z && this.klm.isShown()) {
            this.klm.startAnimation(AnimationUtils.loadAnimation(this, a.out_to_up));
            this.klm.setVisibility(8);
        }
    }

    private void fH(boolean z) {
        this.klJ.setEnabled(z);
    }
}
