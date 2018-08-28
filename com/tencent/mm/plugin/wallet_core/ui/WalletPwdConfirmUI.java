package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.tg;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;

@a(19)
public class WalletPwdConfirmUI extends WalletBaseUI {
    private c cXu = new 6(this);
    private TextView gsY;
    private TextView hBv;
    public EditHintPasswdView kkY;
    private PayInfo mCn;
    private TextView pxc;
    private boolean pxd = false;
    private al pxe = new al(new al.a() {
        public final boolean vD() {
            if (WalletPwdConfirmUI.this.pxd) {
                WalletPwdConfirmUI.this.pxd = false;
                WalletPwdConfirmUI.this.bQs();
            }
            return false;
        }
    }, false);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mController.hideTitleView();
        this.mCn = (PayInfo) this.sy.getParcelable("key_pay_info");
        initView();
        com.tencent.mm.plugin.wallet_core.e.c.b(this, this.sy, 6);
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
        this.hBv.setText(i.wallet_set_password_hint_2);
        this.pxc = (TextView) findViewById(f.input_finish);
        if (bi.K(cDM())) {
            this.pxc.setText(i.app_finish);
        } else {
            this.pxc.setText(i.wallet_set_password_pay_tips);
        }
        this.pxc.setVisibility(0);
        this.pxc.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                String string = WalletPwdConfirmUI.this.sy.getString("key_new_pwd1");
                String md5Value = WalletPwdConfirmUI.this.kkY.getMd5Value();
                String string2 = WalletPwdConfirmUI.this.sy.getString("kreq_token");
                String string3 = WalletPwdConfirmUI.this.sy.getString("key_verify_code");
                x.d("Micromsg.WalletPwdConfirmUI", "mPayInfo " + WalletPwdConfirmUI.this.mCn + " vertifyCode: " + string3);
                if (string == null || !string.equals(md5Value)) {
                    com.tencent.mm.wallet_core.a.m(WalletPwdConfirmUI.this, -1002);
                    return;
                }
                p pVar = new p();
                pVar.eJn = WalletPwdConfirmUI.this.kkY.getText();
                pVar.mpb = WalletPwdConfirmUI.this.mCn;
                pVar.token = string2;
                pVar.pqM = string3;
                pVar.pqN = WalletPwdConfirmUI.this.sy.getBoolean("key_is_bind_bankcard", true);
                if (com.tencent.mm.wallet_core.a.af(WalletPwdConfirmUI.this).bQH()) {
                    pVar.flag = "4";
                } else {
                    pVar.flag = "1";
                }
                FavorPayInfo favorPayInfo = (FavorPayInfo) WalletPwdConfirmUI.this.sy.getParcelable("key_favor_pay_info");
                if (favorPayInfo != null) {
                    pVar.plt = favorPayInfo.pnS;
                    pVar.plu = favorPayInfo.pnP;
                }
                WalletPwdConfirmUI.this.cDL().m(new Object[]{pVar});
            }
        });
        this.pxc.setEnabled(false);
        this.pxc.setClickable(false);
        this.kkY = (EditHintPasswdView) findViewById(f.input_et);
        com.tencent.mm.wallet_core.ui.formview.a.a(this.kkY);
        this.kkY.setEditTextMaxLength(6);
        this.kkY.setOnInputValidListener(new 3(this));
        findViewById(f.bind_wallet_verify_hint).setVisibility(8);
        d(this.kkY, 0, false);
        this.kTx = new 4(this, (ScrollView) findViewById(f.root_view));
    }

    public void onResume() {
        this.kkY.requestFocus();
        super.onResume();
        com.tencent.mm.sdk.b.a.sFg.b(this.cXu);
    }

    public void onPause() {
        super.onPause();
        com.tencent.mm.sdk.b.a.sFg.c(this.cXu);
    }

    private void bQs() {
        Bundle bundle = this.sy;
        bundle.putBoolean("intent_bind_end", true);
        com.tencent.mm.wallet_core.a.j(this, bundle);
    }

    protected final boolean aWj() {
        return true;
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (i != 0 || i2 != 0) {
            return false;
        }
        this.sy.putString("key_pwd1", this.kkY.getText());
        if (lVar instanceof y) {
            if (!this.pxd) {
                bQs();
            }
        } else if (com.tencent.mm.wallet_core.a.af(this) == null || !com.tencent.mm.wallet_core.a.af(this).c(this, null)) {
            com.tencent.mm.wallet_core.a.j(this, this.sy);
        } else {
            a(new y(this.mCn != null ? this.mCn.bOd : "", 22), true, false);
            tg tgVar = new tg();
            if (com.tencent.mm.sdk.b.a.sFg.G(tgVar.getClass())) {
                this.pxd = true;
                com.tencent.mm.sdk.b.a.sFg.m(tgVar);
            }
            this.pxe.J(10000, 10000);
        }
        return true;
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
