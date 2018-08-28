package com.tencent.mm.plugin.account.bind.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.al.b;
import com.tencent.mm.g.a.sf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.modelsimple.BindWordingContent;
import com.tencent.mm.plugin.account.a;
import com.tencent.mm.plugin.account.a.f;
import com.tencent.mm.plugin.account.a.h;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.p;
import java.util.Timer;

public class BindMobileVerifyUI extends MMWizardActivity implements e {
    private String bTi;
    private Timer bno;
    private EditText eGC;
    private Button eGE;
    private BindWordingContent eGQ;
    private int eGR;
    private boolean eGS;
    private boolean eGT;
    private boolean eGb = false;
    private boolean eGx = false;
    private boolean eHe = false;
    private TextView eHh;
    private TextView eHi;
    private boolean eHj = false;
    private Integer eHk = Integer.valueOf(15);
    private p tipDialog = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g.DF().a(132, this);
        setMMTitle(j.bind_mcontact_title_verify);
        this.eGQ = (BindWordingContent) getIntent().getParcelableExtra("kstyle_bind_wording");
        this.eGR = getIntent().getIntExtra("kstyle_bind_recommend_show", 0);
        this.eGS = getIntent().getBooleanExtra("Kfind_friend_by_mobile_flag", false);
        this.eGT = getIntent().getBooleanExtra("Krecom_friends_by_mobile_flag", false);
        this.eHe = getIntent().getBooleanExtra("is_bind_for_chatroom_upgrade", false);
        initView();
    }

    public void onDestroy() {
        g.DF().b(132, this);
        super.onDestroy();
    }

    protected void onStop() {
        WO();
        super.onStop();
    }

    protected final int getLayoutId() {
        return a.g.bindmcontact_verify;
    }

    protected final void initView() {
        this.bTi = (String) g.Ei().DT().get(4097, null);
        this.eGC = (EditText) findViewById(f.bind_mcontact_verify_num);
        this.eHh = (TextView) findViewById(f.bind_mcontact_verify_mobile_num);
        this.eHi = (TextView) findViewById(f.bind_mcontact_sms_time_hint);
        this.eGb = getIntent().getBooleanExtra("is_bind_for_safe_device", false);
        this.eHj = getIntent().getBooleanExtra("is_bind_for_contact_sync", false);
        this.eGx = getIntent().getBooleanExtra("BIND_FOR_QQ_REG", false);
        Button button = (Button) findViewById(f.bind_mcontact_verify_btn);
        if (this.bTi == null || this.bTi.equals("")) {
            this.bTi = (String) g.Ei().DT().get(6, null);
        }
        if (this.bTi != null && this.bTi.length() > 0) {
            this.eHh.setVisibility(0);
            this.eHh.setText(this.bTi);
        }
        this.eGC.setFilters(new InputFilter[]{new 1(this)});
        this.eGE = (Button) findViewById(f.bind_mcontact_voice_code);
        button.setVisibility(8);
        this.eHi.setText(getResources().getQuantityString(h.mobileverify_send_code_tip, this.eHk.intValue(), new Object[]{this.eHk}));
        if (this.bno == null) {
            this.bno = new Timer();
            5 5 = new 5(this);
            if (this.bno != null) {
                this.bno.schedule(5, 1000, 1000);
            }
        }
        addTextOptionMenu(0, getString(j.app_nextstep), new 2(this));
        setBackBtn(new 3(this));
        this.eGE.setVisibility(b.mj(this.bTi) ? 0 : 8);
        this.eGE.setOnClickListener(new 4(this));
    }

    private void WO() {
        if (this.bno != null) {
            this.bno.cancel();
            this.bno = null;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public final void a(int i, int i2, String str, l lVar) {
        boolean z = true;
        x.i("MicroMsg.BindMobileVerifyUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (((com.tencent.mm.plugin.account.friend.a.x) lVar).Oh() == 2) {
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            boolean z2;
            if (i != 0 || i2 != 0) {
                if (!com.tencent.mm.plugin.account.a.a.ezo.a(this, i, i2, str)) {
                    switch (i2) {
                        case -214:
                            com.tencent.mm.h.a eV = com.tencent.mm.h.a.eV(str);
                            if (eV != null) {
                                eV.a(this, null, null);
                            }
                            z2 = true;
                            break;
                        case -43:
                            Toast.makeText(this, j.bind_mcontact_err_binded, 0).show();
                            z2 = true;
                            break;
                        case -41:
                            Toast.makeText(this, j.bind_mcontact_err_format, 0).show();
                            z2 = true;
                            break;
                        case -36:
                            Toast.makeText(this, j.bind_mcontact_err_unbinded_notbinded, 0).show();
                            z2 = true;
                            break;
                        case -35:
                            Toast.makeText(this, j.bind_mcontact_err_binded_by_other, 0).show();
                            z2 = true;
                            break;
                        case -34:
                            Toast.makeText(this, j.bind_mcontact_err_freq_limit, 0).show();
                            z2 = true;
                            break;
                        case -33:
                            com.tencent.mm.ui.base.h.a(this, j.bind_mcontact_verify_err_time_out_content, j.bind_mcontact_verify_tip, null);
                            z2 = true;
                            break;
                        case -32:
                            com.tencent.mm.ui.base.h.a(this, j.bind_mcontact_verify_err_unmatch_content, j.bind_mcontact_verify_tip, null);
                            z2 = true;
                            break;
                        default:
                            z2 = false;
                            break;
                    }
                }
                z2 = true;
                if (!z2) {
                    Toast.makeText(this, getString(j.bind_mcontact_verify_err, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                }
            } else if (((com.tencent.mm.plugin.account.friend.a.x) lVar).Oh() != 2) {
            } else {
                Intent intent;
                if (this.eGb) {
                    if (!q.GN()) {
                        sf sfVar = new sf();
                        sfVar.ccY.ccZ = true;
                        sfVar.ccY.cda = true;
                        com.tencent.mm.sdk.b.a.sFg.m(sfVar);
                    }
                    DT(1);
                    intent = new Intent();
                    intent.addFlags(67108864);
                    com.tencent.mm.plugin.account.a.a.ezn.e(this, intent);
                } else if (this.eGx) {
                    DT(1);
                    startActivity(new Intent(this, FindMContactAddUI.class));
                } else if (this.eHe) {
                    if (this.eGS) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (this.eGT) {
                        z = false;
                    }
                    BindMobileStatusUI.c(this, z2, z);
                    exit(-1);
                } else {
                    if (!this.eHj) {
                        ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).syncAddrBookAndUpload();
                    }
                    intent = new Intent(this, BindMobileStatusUI.class);
                    intent.putExtra("kstyle_bind_wording", this.eGQ);
                    intent.putExtra("kstyle_bind_recommend_show", this.eGR);
                    intent.putExtra("Kfind_friend_by_mobile_flag", this.eGS);
                    intent.putExtra("Krecom_friends_by_mobile_flag", this.eGT);
                    D(this, intent);
                }
            }
        }
    }
}
