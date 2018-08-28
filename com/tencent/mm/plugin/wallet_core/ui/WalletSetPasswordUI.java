package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.wallet_core.e.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;

@a(19)
public class WalletSetPasswordUI extends WalletBaseUI {
    private TextView gsY;
    private TextView hBv;
    public EditHintPasswdView kkY;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mController.hideTitleView();
        initView();
        c.b(this, this.sy, 5);
        findViewById(f.close_button).setOnClickListener(new 1(this));
        if (VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.white));
            if (VERSION.SDK_INT >= 23) {
                window.getDecorView().setSystemUiVisibility(8192);
            }
        }
        this.mController.contentView.setFitsSystemWindows(true);
    }

    protected final void initView() {
        this.gsY = (TextView) findViewById(f.wallet_pwd_title);
        this.hBv = (TextView) findViewById(f.wallet_pwd_content);
        if (cDK() != null && "ModifyPwdProcess".equals(cDK().aNK())) {
            this.gsY.setText(i.wallet_modify_password_title);
        }
        if (this.sy.getInt("key_err_code", 0) == -1002) {
            TextView textView = (TextView) findViewById(f.input_err);
            textView.setVisibility(0);
            textView.setText(q.GS() ? getString(i.wallet_set_password_no_same_payu) : getString(i.wallet_set_password_no_same));
            this.sy.putInt("key_err_code", 0);
        }
        this.kkY = (EditHintPasswdView) findViewById(f.input_et);
        com.tencent.mm.wallet_core.ui.formview.a.a(this.kkY);
        findViewById(f.bind_wallet_verify_hint).setVisibility(8);
        this.kkY.setOnInputValidListener(new 2(this));
        d(this.kkY, 0, false);
    }

    public void onResume() {
        this.kkY.requestFocus();
        super.onResume();
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        return false;
    }

    protected final int getLayoutId() {
        return g.wallet_set_pwd;
    }

    protected final boolean bND() {
        return true;
    }

    protected final int getForceOrientation() {
        return 1;
    }
}
