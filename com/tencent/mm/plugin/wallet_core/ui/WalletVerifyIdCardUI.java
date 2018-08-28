package com.tencent.mm.plugin.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.h;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.wallet_core.c.g;
import com.tencent.mm.wallet_core.c.g.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;

public class WalletVerifyIdCardUI extends WalletBaseUI {
    private TextView gsY;
    private boolean pyP = false;
    private h pyR = new h();
    private a pyS = new 4(this);
    private EditHintPasswdView pyX;

    static /* synthetic */ boolean a(WalletVerifyIdCardUI walletVerifyIdCardUI, a aVar) {
        if (walletVerifyIdCardUI.pyP) {
            x.i("MicroMsg.WalletVerifyIdCardUI", "isCertInstalled passed");
            return false;
        }
        String string = walletVerifyIdCardUI.sy.getString("key_cre_type");
        String text = walletVerifyIdCardUI.pyX.getText();
        if (walletVerifyIdCardUI.pyR.bOD()) {
            x.i("MicroMsg.WalletVerifyIdCardUI", "tryToinstallCert isBlockInstall %s", new Object[]{aVar});
            if (bi.oW(text)) {
                x.i("MicroMsg.WalletVerifyIdCardUI", "tryToinstallCert isBlockInstall sms error %s", new Object[]{aVar});
                return false;
            }
            com.tencent.mm.plugin.report.service.h.mEJ.h(13731, new Object[]{Integer.valueOf(6)});
            walletVerifyIdCardUI.a(new g(string, text, walletVerifyIdCardUI.bNs(), aVar, true), true, true);
            return true;
        } else if (walletVerifyIdCardUI.pyR.bOC()) {
            x.i("MicroMsg.WalletVerifyIdCardUI", "tryToinstallCert isNeedInstall %s", new Object[]{aVar});
            com.tencent.mm.plugin.report.service.h.mEJ.h(13731, new Object[]{Integer.valueOf(6)});
            walletVerifyIdCardUI.a(new g(string, text, walletVerifyIdCardUI.bNs(), aVar, false), true, true);
            return true;
        } else {
            x.i("MicroMsg.WalletVerifyIdCardUI", "no need installcert");
            return false;
        }
    }

    static /* synthetic */ void b(WalletVerifyIdCardUI walletVerifyIdCardUI) {
        if (walletVerifyIdCardUI.cDL() != null) {
            x.d("MicroMsg.WalletVerifyIdCardUI", "3des text: %s", new Object[]{walletVerifyIdCardUI.pyX.getText()});
            p pVar = new p();
            pVar.eJn = walletVerifyIdCardUI.sy.getString("key_pwd1");
            pVar.mpb = (PayInfo) walletVerifyIdCardUI.sy.getParcelable("key_pay_info");
            pVar.bVC = 1;
            pVar.pqP = walletVerifyIdCardUI.sy.getString("key_cre_type");
            pVar.pqO = walletVerifyIdCardUI.pyX.getText();
            pVar.token = bi.aG(walletVerifyIdCardUI.sy.getString("kreq_token"), "");
            switch (walletVerifyIdCardUI.sy.getInt("key_pay_flag", 0)) {
                case 1:
                    pVar.flag = "1";
                    break;
                case 2:
                    if (!walletVerifyIdCardUI.bQH()) {
                        pVar.flag = "2";
                        break;
                    } else {
                        pVar.flag = "5";
                        break;
                    }
                case 3:
                    if (!walletVerifyIdCardUI.bQH()) {
                        pVar.flag = "3";
                        break;
                    } else {
                        pVar.flag = "6";
                        break;
                    }
            }
            Bankcard bankcard = (Bankcard) walletVerifyIdCardUI.sy.getParcelable("key_bankcard");
            if (bankcard != null) {
                pVar.lMV = bankcard.field_bankcardType;
                pVar.lMW = bankcard.field_bindSerial;
                pVar.plq = bi.aG(bankcard.field_arrive_type, "");
            } else {
                pVar.lMV = walletVerifyIdCardUI.sy.getString("key_bank_type");
                if (bi.oW(pVar.lMV)) {
                    pVar.lMV = walletVerifyIdCardUI.sy.getString("key_bind_card_type", "");
                }
            }
            walletVerifyIdCardUI.cDL().m(pVar);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.pyR = new h(this.sy);
        initView();
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(c.white)));
        View customView = getSupportActionBar().getCustomView();
        if (customView != null) {
            customView = customView.findViewById(f.divider);
            if (customView != null) {
                customView.setBackgroundColor(getResources().getColor(c.transparent));
            }
        }
        if (d.fR(21)) {
            if (d.fR(23)) {
                getWindow().setStatusBarColor(-1);
                getWindow().getDecorView().setSystemUiVisibility(8192);
            } else {
                getWindow().setStatusBarColor(Color.parseColor("#E5E5E5"));
            }
        }
        setMMTitle("");
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                WalletVerifyIdCardUI.this.finish();
                return false;
            }
        }, com.tencent.mm.plugin.wxpay.a.h.actionbar_icon_dark_back);
    }

    protected final void initView() {
        this.gsY = (TextView) findViewById(f.wviu_title_tv);
        this.pyX = (EditHintPasswdView) findViewById(f.wviu_tail_et);
        String string = this.sy.getString("key_true_name");
        String string2 = this.sy.getString("key_cre_name");
        String string3 = this.sy.getString("key_cre_type");
        this.gsY.setText(getString(i.wallet_idcard_tail_title, new Object[]{string, string2}));
        this.pyX.setEditTextMaxLength(4);
        this.pyX.setEditTextSize(34.0f);
        this.pyX.setOnInputValidListener(new EditHintPasswdView.a() {
            public final void fE(boolean z) {
                WalletVerifyIdCardUI.this.pyX.postDelayed(new 1(this, z), 50);
            }
        });
        if ("1".equals(string3)) {
            d(this.pyX, 1, false);
        } else {
            d(this.pyX, 1, true);
        }
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (!(lVar instanceof g)) {
            return false;
        }
        if (i2 == 0 || !((g) lVar).caB) {
            this.pyX.bqn();
        } else {
            com.tencent.mm.ui.base.h.a(this.mController.tml, str, null, false, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        }
        return true;
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.wallet_verify_idcard_ui;
    }

    private boolean bQH() {
        return this.sy.getBoolean("key_is_oversea", false);
    }

    public final boolean k(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.WalletVerifyIdCardUI", "onPreSceneEnd %s %s", new Object[]{Integer.valueOf(i2), lVar});
        if ((lVar instanceof g) && i2 == 0) {
            this.pyP = true;
            s.makeText(this, i.wallet_password_setting_digitalcert_install_verify_install_toast, 0).show();
            x.i("MicroMsg.WalletVerifyIdCardUI", "tag it isCertInstalled ok");
        }
        return true;
    }
}
