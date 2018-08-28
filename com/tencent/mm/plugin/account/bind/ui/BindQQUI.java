package com.tencent.mm.plugin.account.bind.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.a.o;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.bg.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.r;
import com.tencent.mm.plugin.account.a;
import com.tencent.mm.plugin.account.a$j;
import com.tencent.mm.plugin.account.a.f;
import com.tencent.mm.plugin.account.friend.a.y;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.smtt.sdk.WebView;

public class BindQQUI extends MMWizardActivity implements e {
    private String eFZ = null;
    private String eGa = null;
    p tipDialog;
    private int type = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.type = getIntent().getIntExtra("bindqq_regbymobile", 0);
        g.DF().a(254, this);
        g.DF().a(WebView.NORMAL_MODE_ALPHA, this);
    }

    public void onDestroy() {
        g.DF().b(254, this);
        g.DF().b(WebView.NORMAL_MODE_ALPHA, this);
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        initView();
    }

    protected final int getLayoutId() {
        return a.g.bindqq;
    }

    protected final void initView() {
        long longValue = new o(bi.f((Integer) g.Ei().DT().get(9, null))).longValue();
        TextView textView;
        Button button;
        if (longValue == 0) {
            setMMTitle(a$j.bind_qq_start_title);
            textView = (TextView) findViewById(f.setting_bind_qq_hint);
            textView.setVisibility(8);
            textView.setText(a$j.bind_qq_start_hint);
            ((TextView) findViewById(f.setting_bind_qq_qq)).setVisibility(8);
            button = (Button) findViewById(f.bind_qq_start_btn);
            button.setVisibility(0);
            button.setText(a$j.bind_qq_start_btn);
            button.setOnClickListener(new 5(this));
            removeOptionMenu(1);
        } else {
            setMMTitle(a$j.bind_qq_finish_title);
            textView = (TextView) findViewById(f.setting_bind_qq_hint);
            textView.setVisibility(8);
            textView.setText(a$j.bind_qq_finish_hint);
            textView = (TextView) findViewById(f.setting_bind_qq_qq);
            textView.setVisibility(0);
            textView.setText(getString(a$j.bind_qq_finish_textview_hint) + longValue);
            button = (Button) findViewById(f.bind_qq_start_btn);
            button.setVisibility(8);
            button.setText(a$j.hardcode_plugin_qqfriend_nick);
            button.setOnClickListener(new 6(this));
            addIconOptionMenu(1, a.e.mm_title_btn_menu, new 7(this));
        }
        if (this.type == 1) {
            addTextOptionMenu(0, getString(a$j.app_ignore_it), new 1(this));
        } else {
            setBackBtn(new 4(this));
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.d("MicroMsg.BindQQUI", "onSceneEnd " + i + " errCode " + i2 + " errMsg " + str + "  " + lVar.getType());
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        if (lVar.getType() == 254) {
            if (i == 0 && i2 == 0) {
                this.eFZ = ((y) lVar).XL();
                if (this.eFZ != null && this.eFZ.length() > 0) {
                    g.Ei().DT().set(102407, this.eFZ);
                }
                if (bi.oW(this.eGa)) {
                    g.DF().a(new r(2), 0);
                    return;
                }
                Intent intent = new Intent(this, StartUnbindQQ.class);
                intent.putExtra("notice", this.eGa);
                D(this, intent);
                return;
            }
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            if (i2 == -3) {
                x.d("MicroMsg.BindQQUI", "summerunbind MMFunc_QueryHasPasswd err and set psw");
                h.a(this.mController.tml, getString(a$j.settings_unbind_tips_set_user_password), null, getString(a$j.settings_unbind_tips_unbind_btn), getString(a$j.settings_unbind_tips_cancel_btn), true, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent();
                        intent.putExtra("kintent_hint", BindQQUI.this.getString(a$j.settings_unbind_set_password_tip));
                        intent.putExtra("from_unbind", true);
                        d.b(BindQQUI.this, "account", "com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI", intent, 1);
                    }
                }, new 9(this));
            } else if (i2 == -81) {
                h.a((Context) this, a$j.setting_unbind_qq_err_norbindqq, a$j.app_tip, null);
            } else if (i2 == -82) {
                h.a((Context) this, a$j.setting_unbind_qq_err_one_left, a$j.app_tip, null);
            } else if (i2 == -83) {
                h.a((Context) this, a$j.setting_unbind_qq_err_has_unbind, a$j.app_tip, null);
            } else if (i2 == -84) {
                h.a((Context) this, a$j.setting_unbind_qq_err_hasbinded, a$j.app_tip, null);
            } else if (i2 == -85) {
                h.a((Context) this, a$j.setting_unbind_qq_err_bindedbyother, a$j.app_tip, null);
            } else if (i2 == -86) {
                h.a((Context) this, a$j.setting_unbind_qq_err_qmail, a$j.app_tip, null);
            }
        } else if (lVar.getType() != WebView.NORMAL_MODE_ALPHA) {
        } else {
            if (i2 == 0) {
                D(this, new Intent(this, StartUnbindQQ.class));
            } else {
                h.a(this.mController.tml, getString(a$j.settings_unbind_tips_set_user_password), null, getString(a$j.settings_unbind_tips_unbind_btn), getString(a$j.settings_unbind_tips_cancel_btn), true, new 10(this), new 11(this));
            }
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x.d("MicroMsg.BindQQUI", "summerunbind onAcvityResult requestCode:%d, resultCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        switch (i) {
            case 1:
                if (i2 == -1) {
                    x.i("MicroMsg.BindQQUI", "summerunbind REQUEST_CODE_SET_PSW ok and start NetSceneCheckUnBind again qq");
                    g.DF().a(new y(y.eKP), 0);
                    getString(a$j.app_tip);
                    this.tipDialog = h.a((Context) this, getString(a$j.app_loading), true, new 3(this));
                    return;
                }
                return;
            default:
                return;
        }
    }
}
