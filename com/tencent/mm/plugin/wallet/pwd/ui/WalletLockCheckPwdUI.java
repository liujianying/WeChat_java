package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.qz;
import com.tencent.mm.plugin.wallet_core.c.r;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;

public class WalletLockCheckPwdUI extends WalletBaseUI {
    private TextView gsY;
    private TextView hBv;
    private r pco;
    private EditHintPasswdView phS;
    private int phT = -1;
    private String sS;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mController.hideTitleView();
        this.phT = getIntent().getIntExtra("key_wallet_lock_type", -1);
        this.sS = getIntent().getStringExtra("action");
        x.v("MicroMsg.WalletLockCheckPwdUI", "alvinluo wallet lock type: %d, action: %s", new Object[]{Integer.valueOf(this.phT), this.sS});
        this.phS = (EditHintPasswdView) findViewById(a$f.input_et);
        this.gsY = (TextView) findViewById(a$f.wallet_pwd_title);
        this.hBv = (TextView) findViewById(a$f.wallet_pwd_content);
        CharSequence stringExtra = getIntent().getStringExtra("key_wallet_lock_input_new_fp_tips");
        if (this.phT == 2) {
            this.gsY.setText(i.wallet_wx_offline_start_fingerprint_lock);
            if (this.sS.equals("action.touchlock_need_verify_paypwd") && !bi.oW(stringExtra)) {
                this.hBv.setText(stringExtra);
            }
        } else if (this.phT == 1) {
            this.gsY.setText(i.wallet_wx_offline_start_gesture);
        }
        this.phS.setOnInputValidListener(new 3(this));
        d(this.phS, 0, false);
        setBackBtn(new 1(this));
        findViewById(a$f.close_button).setOnClickListener(new 2(this));
        if (VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(getResources().getColor(c.white));
            if (VERSION.SDK_INT >= 23) {
                window.getDecorView().setSystemUiVisibility(8192);
            }
        }
        this.mController.contentView.setFitsSystemWindows(true);
    }

    public void onResume() {
        super.onResume();
        if (this.phS != null) {
            this.phS.bqn();
        }
    }

    public void onBackPressed() {
        x.i("MicroMsg.WalletLockCheckPwdUI", "alvinluo onBackPressed");
        zh(4);
    }

    protected final boolean aWj() {
        return true;
    }

    protected final int getLayoutId() {
        return a$g.wallet_check_pwd;
    }

    public final void rj(int i) {
        super.rj(i);
        this.phS.bqn();
    }

    private void zh(int i) {
        Intent intent = new Intent();
        intent.putExtra("key_err_code", i);
        setResult(-1, intent);
        finish();
    }

    private void u(int i, String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra("key_err_code", i);
        intent.putExtra("key_token", str);
        intent.putExtra("key_type", str2);
        setResult(-1, intent);
        finish();
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.WalletLockCheckPwdUI", "alvinluo WalletLockCheckPwdUI errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (lVar instanceof r) {
            r rVar = (r) lVar;
            if (i == 0 && i2 == 0) {
                if ("next_action.switch_on_pattern".equals(getIntent().getStringExtra("next_action"))) {
                    x.i("MicroMsg.WalletLockCheckPwdUI", "alvinluo start to open wallet lock after check pwd");
                    Intent intent = new Intent();
                    intent.putExtra("action", "action.switch_on_pattern");
                    intent.putExtra("next_action", "next_action.switch_on_pattern");
                    intent.putExtra("token", rVar.token);
                    intent.putExtra("type", rVar.pjt);
                    intent.putExtra("key_wallet_lock_type", this.phT);
                    intent.setPackage(ad.getPackageName());
                    if (this.phT == 2) {
                        intent.putExtra("key_pay_passwd", this.phS.getText());
                    }
                    qz qzVar = new qz();
                    qzVar.cbL.cbN = intent;
                    qzVar.cbL.bOb = this;
                    qzVar.cbL.bRZ = 1;
                    a.sFg.m(qzVar);
                    return true;
                }
                u(0, rVar.token, rVar.pjt);
                return true;
            } else if (i == 1000 && i2 == 3) {
                u(-1, null, null);
                return true;
            }
        } else if (lVar instanceof com.tencent.mm.plugin.wallet.pwd.a.i) {
            if (i == 0 && i2 == 0) {
                zh(0);
                return true;
            }
            zh(-1);
            return true;
        } else if (lVar instanceof com.tencent.mm.plugin.wallet.pwd.a.a) {
            if (i == 0 && i2 == 0) {
                zh(0);
            } else {
                zh(-1);
            }
        }
        return false;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        boolean z = true;
        String str = "MicroMsg.WalletLockCheckPwdUI";
        String str2 = "alvinluo WalletLockCheckPwdUI onActivityResult requestCode: %d, resultCode: %d, data == null: %b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        if (intent != null) {
            z = false;
        }
        objArr[2] = Boolean.valueOf(z);
        x.v(str, str2, objArr);
        setResult(i2, intent);
        finish();
    }
}
