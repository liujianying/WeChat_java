package com.tencent.mm.plugin.wallet_payu.security_question.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mm.plugin.wallet_payu.security_question.model.PayUSecurityQuestion;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.util.ArrayList;

@a(3)
public class WalletPayUSecurityQuestionSettingUI extends WalletBaseUI {
    private Button eWk;
    private WalletPayUSecurityQuestionView pGl;
    private WalletFormView pGm;
    private l pGq;
    private String pGr = "";
    private a pGs;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.pGq = new l(this);
        this.pGq.mw(true);
        this.pGq.ofp = new c() {
            public final void a(com.tencent.mm.ui.base.l lVar) {
                lVar.clear();
                ArrayList a = WalletPayUSecurityQuestionSettingUI.this.sy.getParcelableArrayList("key_security_question_list");
                if (a != null) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < a.size()) {
                            lVar.add(((PayUSecurityQuestion) a.get(i2)).desc);
                            i = i2 + 1;
                        } else {
                            return;
                        }
                    }
                }
            }
        };
        this.pGq.ofq = new d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                WalletPayUSecurityQuestionSettingUI.this.pGl.setQuestionText(((PayUSecurityQuestion) WalletPayUSecurityQuestionSettingUI.this.sy.getParcelableArrayList("key_security_question_list").get(i)).desc);
                WalletPayUSecurityQuestionSettingUI.this.pGr = ((PayUSecurityQuestion) WalletPayUSecurityQuestionSettingUI.this.sy.getParcelableArrayList("key_security_question_list").get(i)).id;
                WalletPayUSecurityQuestionSettingUI.this.pGm.bqn();
                a.a(WalletPayUSecurityQuestionSettingUI.this.pGs);
            }
        };
        this.pGs = new a(this);
        this.pGl = (WalletPayUSecurityQuestionView) findViewById(f.payu_sec_ques);
        this.pGm = (WalletFormView) findViewById(f.payu_sec_answer);
        com.tencent.mm.wallet_core.ui.formview.a.g(this.pGm);
        this.eWk = (Button) findViewById(f.payu_next);
        this.pGl.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                WalletPayUSecurityQuestionSettingUI.this.pGq.dZ();
            }
        });
        this.pGm.setOnInputValidChangeListener(new WalletFormView.a() {
            public final void fE(boolean z) {
                a.a(WalletPayUSecurityQuestionSettingUI.this.pGs);
            }
        });
        this.eWk.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (WalletPayUSecurityQuestionSettingUI.this.pGs.bRn()) {
                    WalletPayUSecurityQuestionSettingUI.this.sy.putString("key_question_id", WalletPayUSecurityQuestionSettingUI.this.pGr);
                    WalletPayUSecurityQuestionSettingUI.this.sy.putString("key_question_answer", WalletPayUSecurityQuestionSettingUI.this.pGm.getText());
                    com.tencent.mm.wallet_core.a.j(WalletPayUSecurityQuestionSettingUI.this, WalletPayUSecurityQuestionSettingUI.this.sy);
                    return;
                }
                a.a(WalletPayUSecurityQuestionSettingUI.this.pGs);
            }
        });
        a.a(this.pGs);
    }

    public void onResume() {
        super.onResume();
    }

    public final boolean d(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        if ((lVar instanceof com.tencent.mm.plugin.wallet_payu.security_question.model.d) && this.pGq.isShowing()) {
            this.pGq.dismiss();
        }
        return false;
    }

    protected final int getLayoutId() {
        return g.payu_ui_security_question_setting;
    }

    protected final boolean bND() {
        return true;
    }
}
