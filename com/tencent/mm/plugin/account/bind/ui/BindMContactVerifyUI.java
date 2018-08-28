package com.tencent.mm.plugin.account.bind.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.al.b;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.sf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.account.a;
import com.tencent.mm.plugin.account.a.f;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.protocal.c.xt;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

public class BindMContactVerifyUI extends MMWizardActivity implements e {
    private String bTi;
    private SharedPreferences duR;
    private boolean eFl = false;
    private EditText eGC;
    private TextView eGD;
    private Button eGE;
    private boolean eGF = false;
    private boolean eGb = false;
    private boolean eGc = false;
    private boolean eGx = false;
    private boolean eGy = false;
    private boolean eGz = false;
    private int fromScene = 0;
    private int status;
    private p tipDialog = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g.DF().a(132, this);
        setMMTitle(j.bind_mcontact_title_verify);
        this.duR = getSharedPreferences(getPackageName() + "_preferences", 0);
        this.status = q.GJ();
        initView();
    }

    public void onDestroy() {
        g.DF().b(132, this);
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return a.g.bindmcontact_verify;
    }

    protected final void initView() {
        this.bTi = (String) g.Ei().DT().get(4097, null);
        this.eGC = (EditText) findViewById(f.bind_mcontact_verify_num);
        this.eGb = getIntent().getBooleanExtra("is_bind_for_safe_device", false);
        this.eGc = getIntent().getBooleanExtra("is_bind_for_contact_sync", false);
        this.eGx = getIntent().getBooleanExtra("BIND_FOR_QQ_REG", false);
        this.eGF = getIntent().getBooleanExtra("BIND_FIND_ME_BY_MOBILE", false);
        this.eGy = getIntent().getBooleanExtra("is_bind_for_change_mobile", false);
        this.eGz = getIntent().getBooleanExtra("is_bind_for_reset_pwd", false);
        this.eFl = getIntent().getBooleanExtra("KEnterFromBanner", false);
        this.fromScene = getIntent().getIntExtra("bind_scene", 0);
        Button button = (Button) findViewById(f.bind_mcontact_verify_btn);
        if (this.bTi == null || this.bTi.equals("")) {
            this.bTi = (String) g.Ei().DT().get(6, null);
        }
        this.eGC.setFilters(new InputFilter[]{new 1(this)});
        this.eGE = (Button) findViewById(f.bind_mcontact_voice_code);
        this.eGD = (TextView) findViewById(f.bind_mcontact_verify_hint);
        boolean z = this.eGF;
        if (z) {
            this.status &= -513;
        } else {
            this.status |= 512;
        }
        this.duR.edit().putBoolean("settings_find_me_by_mobile", z).commit();
        x.d("MicroMsg.BindMContactVerifyUI", "Bind mobile update = " + this.status);
        this.eGD.setText(getString(j.bind_mcontact_input_verify_hint, new Object[]{this.bTi}));
        button.setOnClickListener(new 2(this));
        setBackBtn(new 3(this));
        this.eGE.setVisibility(b.mj(this.bTi) ? 0 : 8);
        this.eGE.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                BindMContactVerifyUI.this.YC();
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("bindmcontact_mobile", BindMContactVerifyUI.this.bTi);
                bundle.putInt("voice_verify_type", 4);
                intent.putExtras(bundle);
                com.tencent.mm.plugin.account.a.a.ezn.f(BindMContactVerifyUI.this, intent);
            }
        });
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        DT(1);
        return true;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.BindMContactVerifyUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (((com.tencent.mm.plugin.account.friend.a.x) lVar).Oh() == 2 || ((com.tencent.mm.plugin.account.friend.a.x) lVar).Oh() == 19) {
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            boolean z;
            if (i != 0 || i2 != 0) {
                com.tencent.mm.h.a eV = com.tencent.mm.h.a.eV(str);
                if (eV != null) {
                    eV.a(this, null, null);
                    return;
                }
                if (!com.tencent.mm.plugin.account.a.a.ezo.a(this, i, i2, str)) {
                    switch (i2) {
                        case -214:
                            eV = com.tencent.mm.h.a.eV(str);
                            if (eV != null) {
                                eV.a(this, null, null);
                            }
                            z = true;
                            break;
                        case -43:
                            Toast.makeText(this, j.bind_mcontact_err_binded, 0).show();
                            z = true;
                            break;
                        case -41:
                            Toast.makeText(this, j.bind_mcontact_err_format, 0).show();
                            z = true;
                            break;
                        case -36:
                            Toast.makeText(this, j.bind_mcontact_err_unbinded_notbinded, 0).show();
                            z = true;
                            break;
                        case -35:
                            Toast.makeText(this, j.bind_mcontact_err_binded_by_other, 0).show();
                            z = true;
                            break;
                        case -34:
                            Toast.makeText(this, j.bind_mcontact_err_freq_limit, 0).show();
                            z = true;
                            break;
                        case -33:
                            h.a(this, j.bind_mcontact_verify_err_time_out_content, j.bind_mcontact_verify_tip, null);
                            z = true;
                            break;
                        case -32:
                            h.a(this, j.bind_mcontact_verify_err_unmatch_content, j.bind_mcontact_verify_tip, null);
                            z = true;
                            break;
                        default:
                            z = false;
                            break;
                    }
                }
                z = true;
                if (!z) {
                    Toast.makeText(this, getString(j.bind_mcontact_verify_err, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                }
            } else if (((com.tencent.mm.plugin.account.friend.a.x) lVar).Oh() != 2 && ((com.tencent.mm.plugin.account.friend.a.x) lVar).Oh() != 19) {
            } else {
                Intent intent;
                if (this.fromScene == 5) {
                    x.i("MicroMsg.BindMContactVerifyUI", "onScene end, finish wizard from app brand reg phone");
                    DT(-1);
                } else if (this.eGb) {
                    if (!q.GN()) {
                        sf sfVar = new sf();
                        sfVar.ccY.ccZ = true;
                        sfVar.ccY.cda = true;
                        com.tencent.mm.sdk.b.a.sFg.m(sfVar);
                    }
                    DT(1);
                    intent = new Intent();
                    intent.addFlags(67108864);
                    com.tencent.mm.plugin.account.a.a.ezn.e((Context) this, intent);
                } else if (this.eGx) {
                    DT(1);
                    startActivity(new Intent(this, FindMContactAddUI.class));
                } else if (this.eGz) {
                    x.i("MicroMsg.BindMContactVerifyUI", "to RegByMobileSetPwdUI for reset pwd");
                    finish();
                    intent = new Intent();
                    intent.addFlags(603979776);
                    intent.putExtra("setpwd_ticket", ((com.tencent.mm.plugin.account.friend.a.x) lVar).Oj());
                    d.b(this, "account", ".ui.RegByMobileSetPwdUI", intent);
                } else {
                    int i3;
                    z = (this.status & 512) > 0;
                    g.Ei().DT().set(7, Integer.valueOf(this.status));
                    xt xtVar = new xt();
                    xtVar.rDz = 8;
                    if (z) {
                        i3 = 1;
                    } else {
                        i3 = 2;
                    }
                    xtVar.rDA = i3;
                    ((i) g.l(i.class)).FQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.h.a(23, xtVar));
                    com.tencent.mm.plugin.account.a.a.ezo.vl();
                    if (!this.eGc) {
                        ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).syncAddrBookAndUpload();
                    }
                    if (this.eGy) {
                        h.bA(this, getString(j.bind_mcontact_change_bind_success));
                    }
                    if (this.eFl) {
                        if (this.eGc) {
                            com.tencent.mm.plugin.report.service.h.mEJ.h(11002, new Object[]{Integer.valueOf(3), Integer.valueOf(3)});
                        } else {
                            com.tencent.mm.plugin.report.service.h.mEJ.h(11002, new Object[]{Integer.valueOf(1), Integer.valueOf(2)});
                        }
                    }
                    D(this, new Intent(this, BindMContactStatusUI.class));
                }
            }
        }
    }
}
