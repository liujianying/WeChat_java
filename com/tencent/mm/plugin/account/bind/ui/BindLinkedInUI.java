package com.tencent.mm.plugin.account.bind.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable.Factory;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.bg.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.account.a;
import com.tencent.mm.plugin.account.a.f;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.protocal.c.xt;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMSwitchBtn;

public class BindLinkedInUI extends MMActivity implements e {
    private String csV;
    private String csW;
    private ProgressDialog dId;
    private boolean eFA = false;
    private TextView eFB;
    private TextView eFC;
    private View eFD;
    private MMSwitchBtn eFE;
    private TextView eFF;
    private TextView eFG;
    private TextView eFH;
    private String eFI;
    private String eFJ;
    private String eFK;
    private String eFL;
    private boolean eFt = false;
    private String eFu;
    private boolean eFv = false;
    private boolean eFw = false;
    private boolean eFx = false;
    private Bundle eFy;
    private boolean eFz = false;
    private String name;
    private int status;

    static /* synthetic */ void c(BindLinkedInUI bindLinkedInUI) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", "http://www.linkedin.com/bind/plugin/");
        intent.putExtra("geta8key_username", q.GF());
        if (bindLinkedInUI.eFx) {
            intent.putExtra("geta8key_scene", 3);
        } else {
            intent.putExtra("geta8key_scene", 8);
        }
        d.b(bindLinkedInUI, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent, 100);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g.DF().a(549, this);
        g.DF().a(550, this);
        this.eFy = getIntent().getBundleExtra("qrcode_bundle");
        this.eFw = this.eFy != null;
        if (this.eFy != null) {
            this.csV = this.eFy.getString("i");
            this.csW = this.eFy.getString("n");
            this.eFI = this.eFy.getString("t");
            this.eFJ = this.eFy.getString("o");
            this.eFK = this.eFy.getString("s");
            this.eFL = this.eFy.getString("r");
            if (this.csV == null || this.csW == null || this.eFI == null || this.eFK == null || this.eFL == null) {
                h.a(this, getString(j.contact_info_linkedin_account_params_error), null, false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        BindLinkedInUI.this.goBack();
                    }
                });
            }
        }
        this.eFx = getIntent().getBooleanExtra("oversea_entry", false);
        Wj();
        if (this.eFw) {
            this.eFv = true;
        }
        initView();
        if (this.eFy != null && this.eFt && this.eFu.equals(this.csV)) {
            this.eFz = true;
            ce(true);
        }
    }

    protected void onDestroy() {
        g.DF().b(550, this);
        g.DF().b(549, this);
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }

    protected final int getLayoutId() {
        return a.g.bindlinkedin;
    }

    private void Wj() {
        boolean z = true;
        this.eFu = (String) g.Ei().DT().get(286721, null);
        this.eFt = !bi.oW(this.eFu);
        this.name = (String) g.Ei().DT().get(286722, null);
        this.status = q.GJ();
        if ((this.status & 4194304) == 0) {
            z = false;
        }
        this.eFv = z;
    }

    protected final void initView() {
        if (this.eFw) {
            setMMTitle(j.contact_info_linkedin_qrcode_title);
        } else if (this.eFx) {
            setMMTitle(j.contact_info_linkedin_title);
        } else {
            setMMTitle(j.contact_info_linkedin_bind_info);
        }
        this.eFB = (TextView) findViewById(f.setting_bind_linkedin_account);
        this.eFC = (TextView) findViewById(f.setting_bind_linkedin_brief);
        this.eFD = findViewById(f.show_name_option);
        this.eFE = (MMSwitchBtn) findViewById(f.show_name_checkbox);
        this.eFF = (TextView) findViewById(f.bind_linkedin_btn);
        this.eFG = (TextView) findViewById(f.unbind_linkedin_btn);
        this.eFH = (TextView) findViewById(f.cancel_bind_linkedin_btn);
        this.eFB.setOnClickListener(new 6(this));
        this.eFF.setOnClickListener(new 7(this));
        this.eFG.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                h.a(BindLinkedInUI.this, BindLinkedInUI.this.getString(j.contact_info_linkedin_account_unbind_alert), null, new 1(this), new 2(this));
            }
        });
        this.eFH.setOnClickListener(new 9(this));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                BindLinkedInUI.this.goBack();
                return true;
            }
        });
        aL();
    }

    private void goBack() {
        if (!this.eFw) {
            setResult(-1);
            finish();
        } else if (this.eFA) {
            Intent be = com.tencent.mm.plugin.account.a.a.ezn.be(this);
            be.addFlags(603979776);
            be.putExtra("preferred_tab", 2);
            startActivity(be);
        } else {
            setResult(-1);
            finish();
        }
    }

    private void ce(boolean z) {
        if (this.eFy == null) {
            x.e("MicroMsg.BindLinkedInUI", "bindBundle is null !!");
            return;
        }
        final com.tencent.mm.plugin.account.bind.a.a aVar = new com.tencent.mm.plugin.account.bind.a.a(this.eFE.uGQ ? 1 : 2, this.csV, this.csW, "", this.eFI, this.eFJ, this.eFK, this.eFL);
        if (!z) {
            this.dId = h.a(this, getString(j.loading_tips), false, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    g.DF().c(aVar);
                }
            });
        }
        g.DF().a(aVar, 0);
    }

    private void ph(String str) {
        int indexOf = getString(j.contact_info_linkedin_account_info_binded).indexOf("%s");
        CharSequence newSpannable = Factory.getInstance().newSpannable(getString(j.contact_info_linkedin_account_info_binded, new Object[]{str}));
        newSpannable.setSpan(new 12(this), indexOf, str.length() + indexOf, 33);
        this.eFB.setText(newSpannable);
    }

    private void a(boolean z, boolean z2, String str, boolean z3) {
        this.eFH.setVisibility(8);
        if (z) {
            this.eFC.setVisibility(8);
            this.eFB.setVisibility(0);
            ph(str);
            this.eFD.setVisibility(0);
            this.eFF.setVisibility(8);
            if (z2) {
                this.eFG.setVisibility(0);
            }
            this.eFE.setCheck(z3);
            this.eFE.setSwitchListener(new 3(this));
            return;
        }
        this.eFB.setVisibility(8);
        this.eFB.setText(getString(j.contact_info_linkedin_account_info_unbind));
        this.eFC.setVisibility(0);
        this.eFD.setVisibility(8);
        this.eFF.setVisibility(0);
        this.eFG.setVisibility(8);
    }

    private void aL() {
        boolean z = true;
        if (this.eFw && this.eFy == null) {
            x.e("MicroMsg.BindLinkedInUI", "bindBundle is null");
        } else if (this.eFx) {
            a(this.eFt, false, this.name, this.eFv);
        } else if (this.eFw) {
            if (!(this.eFt && this.eFu.equals(this.csV))) {
                z = false;
            }
            String str = this.csW;
            boolean z2 = this.eFv;
            this.eFB.setVisibility(0);
            ph(str);
            this.eFD.setVisibility(0);
            this.eFG.setVisibility(8);
            if (z) {
                this.eFC.setVisibility(8);
                this.eFF.setVisibility(8);
                this.eFH.setVisibility(8);
                this.eFE.setCheck(z2);
                this.eFE.setSwitchListener(new MMSwitchBtn.a() {
                    public final void cf(boolean z) {
                        BindLinkedInUI.this.m(z, true);
                    }
                });
                return;
            }
            this.eFC.setVisibility(0);
            this.eFF.setVisibility(0);
            this.eFH.setVisibility(0);
            this.eFE.setCheck(z2);
            this.eFE.setSwitchListener(new 2(this));
        } else {
            a(this.eFt, true, this.name, this.eFv);
        }
    }

    private void m(boolean z, boolean z2) {
        if (z) {
            this.status |= 4194304;
        } else {
            this.status &= -4194305;
        }
        int i = z ? 1 : 2;
        g.Ei().DT().set(7, Integer.valueOf(this.status));
        if (z2) {
            xt xtVar = new xt();
            xtVar.rDz = 33;
            xtVar.rDA = i;
            ((i) g.l(i.class)).FQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.h.a(23, xtVar));
            com.tencent.mm.plugin.account.a.a.ezo.vl();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.d("MicroMsg.BindLinkedInUI", "onActivityResult . requestCode:" + i + "  resultCode:" + i2);
        if (intent != null) {
            switch (i) {
                case 100:
                    Bundle bundleExtra = intent.getBundleExtra("result_data");
                    String string = bundleExtra.getString("ret");
                    String string2 = bundleExtra.getString("limid");
                    String string3 = bundleExtra.getString("liname");
                    String string4 = bundleExtra.getString("liurl");
                    String string5 = bundleExtra.getString("liswitch");
                    if (bi.oW(string)) {
                        x.e("MicroMsg.BindLinkedInUI", "linkedin oauth ret is null, maybe canceled");
                        return;
                    }
                    int WU = bi.WU(string);
                    if (WU != 0) {
                        x.e("MicroMsg.BindLinkedInUI", "linkedin oauth bind failed ret %s ", new Object[]{Integer.valueOf(WU)});
                        h.b(this, getString(WU == 1 ? j.contact_info_linkedin_err_bound : j.contact_info_linkedin_err_bind_failed), null, true);
                        return;
                    } else if (bi.oW(string2)) {
                        x.e("MicroMsg.BindLinkedInUI", "linkedin member id is null");
                        return;
                    } else {
                        x.d("MicroMsg.BindLinkedInUI", "%s, %s, %s, %s", new Object[]{string2, string3, string4, string5});
                        g.Ei().DT().set(286722, string3);
                        g.Ei().DT().set(286721, string2);
                        g.Ei().DT().set(286723, string4);
                        if (!bi.oW(string5)) {
                            m(bi.WU(string5) == 1, false);
                        }
                        Wj();
                        aL();
                        string5 = getString(j.contact_info_linkedin_bind_ok);
                        4 4 = new 4(this);
                        h.bA(this, string5);
                        return;
                    }
                default:
                    x.e("MicroMsg.BindLinkedInUI", "onActivityResult unknow request");
                    return;
            }
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (this.dId != null) {
            this.dId.dismiss();
            this.dId = null;
        }
        int i3;
        if (i == 0 && i2 == 0) {
            if (lVar.getType() == 549) {
                this.eFA = true;
                if (this.eFz) {
                    i3 = j.contact_info_linkedin_bind_update_ok;
                } else {
                    i3 = j.contact_info_linkedin_bind_ok;
                }
            } else if (lVar.getType() == 550) {
                i3 = j.contact_info_linkedin_unbind_ok;
            } else {
                return;
            }
            String string = getString(i3);
            5 5 = new 5(this);
            h.bA(this, string);
            Wj();
            this.eFv = this.eFE.uGQ;
            aL();
            return;
        }
        if (lVar.getType() == 549) {
            if (i2 == 1) {
                i3 = j.contact_info_linkedin_err_bound;
            } else {
                i3 = j.contact_info_linkedin_err_bind_failed;
            }
        } else if (lVar.getType() == 550) {
            i3 = j.contact_info_linkedin_err_unbind_failed;
        } else {
            return;
        }
        h.b(this, getString(i3), null, true);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }
}
