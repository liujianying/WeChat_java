package com.tencent.mm.plugin.account.bind.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.o;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.f;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.friend.a.ag;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import java.util.List;

public class FindMContactIntroUI extends MMWizardActivity {
    private String bTi;
    private Button eHK;
    private TextView eHL;
    private TextView eHM;
    private String eHp = null;
    private String eHq = "";
    private int eHr = 2;
    private boolean eHu = false;
    private List<String[]> eHv = null;
    private ProgressDialog eHw = null;
    private ag eHx;
    private String eHy;
    private e ehD = null;

    static /* synthetic */ void a(FindMContactIntroUI findMContactIntroUI) {
        StringBuilder stringBuilder;
        if (findMContactIntroUI.eHu) {
            stringBuilder = new StringBuilder();
            g.Eg();
            stringBuilder = stringBuilder.append(a.DA()).append(",").append(findMContactIntroUI.getClass().getName()).append(",R300_200_phone,");
            g.Eg();
            com.tencent.mm.plugin.c.a.pV(stringBuilder.append(a.gd("R300_200_phone")).append(",1").toString());
            h.a(findMContactIntroUI, j.find_mcontact_bind_alert_content, j.app_tip, j.app_ok, j.app_cancel, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    g.Ei().DT().set(12322, Boolean.valueOf(true));
                    com.tencent.mm.plugin.c.a.pU("R200_100");
                    Intent intent = new Intent();
                    intent.putExtra("mobile_input_purpose", 4);
                    intent.putExtra("regsetinfo_ticket", FindMContactIntroUI.this.eHp);
                    intent.putExtra("regsetinfo_NextStep", FindMContactIntroUI.this.eHq);
                    intent.putExtra("regsetinfo_NextStyle", FindMContactIntroUI.this.eHr);
                    com.tencent.mm.plugin.account.a.a.ezn.a(FindMContactIntroUI.this, intent);
                    com.tencent.mm.plugin.c.a.pU("R300_300_phone");
                    StringBuilder stringBuilder = new StringBuilder();
                    g.Eg();
                    stringBuilder = stringBuilder.append(a.DA()).append(",").append(FindMContactIntroUI.this.getClass().getName()).append(",R300_200_phone,");
                    g.Eg();
                    com.tencent.mm.plugin.c.a.d(false, stringBuilder.append(a.gd("R300_200_phone")).append(",2").toString());
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    g.Ei().DT().set(12322, Boolean.valueOf(false));
                }
            });
        } else if (l.XB()) {
            stringBuilder = new StringBuilder();
            g.Eg();
            stringBuilder = stringBuilder.append(a.DA()).append(",").append(findMContactIntroUI.getClass().getName()).append(",R300_200_phone,");
            g.Eg();
            com.tencent.mm.plugin.c.a.pV(stringBuilder.append(a.gd("R300_200_phone")).append(",1").toString());
            h.a(findMContactIntroUI, j.find_mcontact_bind_alert_content, j.app_tip, j.app_ok, j.app_cancel, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    g.Ei().DT().set(12322, Boolean.valueOf(true));
                    FindMContactIntroUI.this.WR();
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    g.Ei().DT().set(12322, Boolean.valueOf(false));
                }
            });
        } else {
            findMContactIntroUI.WR();
        }
    }

    public void onCreate(Bundle bundle) {
        boolean z;
        super.onCreate(bundle);
        setMMTitle(j.find_mcontact_title);
        com.tencent.mm.plugin.account.a.a.ezo.vo();
        this.eHp = getIntent().getStringExtra("regsetinfo_ticket");
        this.eHq = getIntent().getStringExtra("regsetinfo_NextStep");
        this.eHr = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
        if (l.XC() != l.a.eKt) {
            z = true;
        } else {
            z = false;
        }
        this.eHu = z;
        this.eHy = com.tencent.mm.plugin.c.a.Zu();
        x.d("MicroMsg.FindMContactIntroUI", "tigerreg mNextStep %s  mNextStyle %s ", new Object[]{this.eHq, Integer.valueOf(this.eHr)});
    }

    public void onDestroy() {
        if (this.ehD != null) {
            g.DF().b(431, this.ehD);
            this.ehD = null;
        }
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        initView();
        StringBuilder stringBuilder;
        if (this.eHu) {
            stringBuilder = new StringBuilder();
            g.Eg();
            stringBuilder = stringBuilder.append(a.DA()).append(",").append(getClass().getName()).append(",R300_100_QQ,");
            g.Eg();
            com.tencent.mm.plugin.c.a.d(true, stringBuilder.append(a.gd("R300_100_QQ")).append(",1").toString());
            com.tencent.mm.plugin.c.a.pT("R300_100_QQ");
            return;
        }
        stringBuilder = new StringBuilder();
        g.Eg();
        stringBuilder = stringBuilder.append(a.DA()).append(",").append(getClass().getName()).append(",R300_100_phone,");
        g.Eg();
        com.tencent.mm.plugin.c.a.d(true, stringBuilder.append(a.gd("R300_100_phone")).append(",1").toString());
        com.tencent.mm.plugin.c.a.pT("R300_100_phone");
    }

    protected void onPause() {
        super.onPause();
        com.tencent.mm.plugin.c.a.pU("RE900_100");
        StringBuilder stringBuilder;
        if (this.eHu) {
            stringBuilder = new StringBuilder();
            g.Eg();
            stringBuilder = stringBuilder.append(a.DA()).append(",").append(getClass().getName()).append(",R300_100_QQ,");
            g.Eg();
            com.tencent.mm.plugin.c.a.d(false, stringBuilder.append(a.gd("R300_100_QQ")).append(",4").toString());
            return;
        }
        stringBuilder = new StringBuilder();
        g.Eg();
        stringBuilder = stringBuilder.append(a.DA()).append(",").append(getClass().getName()).append(",R300_100_phone,");
        g.Eg();
        com.tencent.mm.plugin.c.a.d(false, stringBuilder.append(a.gd("R300_100_phone")).append(",4").toString());
    }

    protected final void initView() {
        this.eHK = (Button) findViewById(f.setting_bind_mobile_friend_btn);
        this.eHM = (TextView) findViewById(f.findmcontact_skip_tv);
        this.eHL = (TextView) findViewById(f.findmcontact_intro_tv);
        if (this.eHq == null || !this.eHq.contains("2")) {
            this.eHL.setText(getString(j.find_mcontact_add_frined_tip_noinvite));
        } else {
            this.eHL.setText(getString(j.find_mcontact_add_frined_tip));
        }
        this.bTi = (String) g.Ei().DT().get(6, null);
        if (this.bTi == null || this.bTi.equals("")) {
            this.bTi = (String) g.Ei().DT().get(4097, null);
        }
        this.eHK.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                FindMContactIntroUI.a(FindMContactIntroUI.this);
            }
        });
        this.eHM.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                h.a(FindMContactIntroUI.this, FindMContactIntroUI.this.getString(j.find_mcontact_skip_alert), null, FindMContactIntroUI.this.getString(j.find_mcontact_skip_btn), FindMContactIntroUI.this.getString(j.find_mcontact_skip_add_friend), new 1(this), new 2(this));
            }
        });
    }

    private void WR() {
        x.i("MicroMsg.FindMContactIntroUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)), bi.cjd()});
        if (com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)) {
            o DF = g.DF();
            9 9 = new 9(this);
            this.ehD = 9;
            DF.a(431, 9);
            ActionBarActivity actionBarActivity = this.mController.tml;
            getString(j.app_tip);
            this.eHw = h.a(actionBarActivity, getString(j.app_loading), true, new 10(this));
            g.Em().a(new 11(this));
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        WL();
        return true;
    }

    private void WL() {
        com.tencent.mm.plugin.c.a.pU(this.eHy);
        YC();
        DT(1);
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.account.a.g.findmcontact_intro;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.FindMContactIntroUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 48:
                if (iArr[0] == 0) {
                    WR();
                    return;
                } else {
                    h.a(this, getString(j.permission_contacts_request_again_msg), getString(j.permission_tips_title), getString(j.jump_to_settings), getString(j.app_cancel), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            FindMContactIntroUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new 3(this));
                    return;
                }
            default:
                return;
        }
    }
}
