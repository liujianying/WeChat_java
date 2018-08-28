package com.tencent.mm.plugin.account.bind.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.f;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.friend.a.ag;
import com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.plugin.wxpay.a$k;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FindMContactLearmMoreUI extends MMWizardActivity {
    private String bTi;
    private Button eHP;
    private TextView eHQ;
    private String eHp = null;
    private String eHq = "";
    private int eHr = 2;
    private List<String[]> eHv = null;
    private ProgressDialog eHw = null;
    private ag eHx;
    private e ehD = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eHp = getIntent().getStringExtra("regsetinfo_ticket");
        this.eHq = getIntent().getStringExtra("regsetinfo_NextStep");
        this.eHr = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
        initView();
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
        a.pT("R300_100_phone");
        StringBuilder stringBuilder = new StringBuilder();
        g.Eg();
        stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",RE300_600,");
        g.Eg();
        a.d(true, stringBuilder.append(com.tencent.mm.kernel.a.gd("RE300_600")).append(",1").toString());
    }

    protected void onPause() {
        super.onPause();
        StringBuilder stringBuilder = new StringBuilder();
        g.Eg();
        stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",RE300_600,");
        g.Eg();
        a.d(false, stringBuilder.append(com.tencent.mm.kernel.a.gd("RE300_600")).append(",2").toString());
    }

    protected final void initView() {
        setMMTitle(j.find_mcontact_upload_title);
        this.eHP = (Button) findViewById(f.ok_btn);
        this.eHQ = (TextView) findViewById(f.cancel_btn);
        this.eHP.setOnClickListener(new 1(this));
        this.eHQ.setOnClickListener(new 2(this));
        g.Ei().DT().set(12323, Boolean.valueOf(true));
        this.bTi = (String) g.Ei().DT().get(6, null);
        if (this.bTi == null || this.bTi.equals("")) {
            this.bTi = (String) g.Ei().DT().get(4097, null);
        }
    }

    private void WR() {
        x.i("MicroMsg.FindMContactLearmMoreUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)), bi.cjd()});
        if (com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)) {
            o DF = g.DF();
            AnonymousClass3 anonymousClass3 = new e() {
                public final void a(int i, int i2, String str, l lVar) {
                    if (FindMContactLearmMoreUI.this.eHw != null) {
                        FindMContactLearmMoreUI.this.eHw.dismiss();
                        FindMContactLearmMoreUI.this.eHw = null;
                    }
                    if (FindMContactLearmMoreUI.this.ehD != null) {
                        g.DF().b(431, FindMContactLearmMoreUI.this.ehD);
                        FindMContactLearmMoreUI.this.ehD = null;
                    }
                    if (i == 0 && i2 == 0) {
                        int i3;
                        LinkedList XR = ((ag) lVar).XR();
                        ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).setFriendData(XR);
                        int i4;
                        if (XR == null || XR.size() <= 0) {
                            i4 = 0;
                            i3 = 0;
                        } else {
                            Iterator it = XR.iterator();
                            i3 = 0;
                            while (it.hasNext()) {
                                arf arf = (arf) it.next();
                                if (arf != null) {
                                    if (arf.hcd == 1) {
                                        i4 = i3 + 1;
                                    } else {
                                        i4 = i3;
                                    }
                                    i3 = i4;
                                }
                            }
                            i4 = i3 > 0 ? 1 : 0;
                        }
                        String str2 = "MicroMsg.FindMContactLearmMoreUI";
                        String str3 = "tigerreg data size=%d, addcount=%s";
                        Object[] objArr = new Object[2];
                        objArr[0] = Integer.valueOf(XR == null ? 0 : XR.size());
                        objArr[1] = Integer.valueOf(i3);
                        x.d(str2, str3, objArr);
                        if (FindMContactLearmMoreUI.this.eHq == null || !FindMContactLearmMoreUI.this.eHq.contains("1") || i4 == 0) {
                            FindMContactLearmMoreUI.this.WL();
                            return;
                        }
                        a.pU("R300_300_phone");
                        Intent intent = new Intent(FindMContactLearmMoreUI.this, FindMContactAddUI.class);
                        intent.putExtra("regsetinfo_ticket", FindMContactLearmMoreUI.this.eHp);
                        intent.putExtra("regsetinfo_NextStep", FindMContactLearmMoreUI.this.eHq);
                        intent.putExtra("regsetinfo_NextStyle", FindMContactLearmMoreUI.this.eHr);
                        intent.putExtra("login_type", 0);
                        MMWizardActivity.D(FindMContactLearmMoreUI.this, intent);
                        return;
                    }
                    Toast.makeText(FindMContactLearmMoreUI.this, FindMContactLearmMoreUI.this.getString(j.app_err_system_busy_tip, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                    FindMContactLearmMoreUI.this.WL();
                }
            };
            this.ehD = anonymousClass3;
            DF.a(431, anonymousClass3);
            ActionBarActivity actionBarActivity = this.mController.tml;
            getString(j.app_tip);
            this.eHw = h.a(actionBarActivity, getString(j.app_loading), true, new 4(this));
            g.Em().a(new ah.a() {
                public final boolean Ks() {
                    if (FindMContactLearmMoreUI.this.eHv == null || FindMContactLearmMoreUI.this.eHv.size() == 0) {
                        if (FindMContactLearmMoreUI.this.eHw != null) {
                            FindMContactLearmMoreUI.this.eHw.dismiss();
                            FindMContactLearmMoreUI.this.eHw = null;
                        }
                        FindMContactLearmMoreUI.this.WL();
                    } else {
                        FindMContactLearmMoreUI.this.eHx = new ag(FindMContactLearmMoreUI.this.eHp, FindMContactLearmMoreUI.this.eHv);
                        g.DF().a(FindMContactLearmMoreUI.this.eHx, 0);
                    }
                    return false;
                }

                public final boolean Kr() {
                    try {
                        FindMContactLearmMoreUI.this.eHv = com.tencent.mm.pluginsdk.a.cz(FindMContactLearmMoreUI.this);
                        x.d("MicroMsg.FindMContactLearmMoreUI", "tigerreg mobileList size " + (FindMContactLearmMoreUI.this.eHv == null ? 0 : FindMContactLearmMoreUI.this.eHv.size()));
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.FindMContactLearmMoreUI", e, "", new Object[0]);
                    }
                    return true;
                }

                public final String toString() {
                    return super.toString() + "|doUpload";
                }
            });
            ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).syncUploadMContactStatus(true, false);
            ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).syncAddrBookAndUpload();
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
        YC();
        DT(1);
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.account.a.g.findmcontact_intro_learn_more;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.FindMContactLearmMoreUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case a$k.AppCompatTheme_homeAsUpIndicator /*48*/:
                if (iArr[0] == 0) {
                    WR();
                    return;
                } else {
                    h.a(this, getString(j.permission_contacts_request_again_msg), getString(j.permission_tips_title), getString(j.jump_to_settings), getString(j.app_cancel), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            FindMContactLearmMoreUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new 7(this));
                    return;
                }
            default:
                return;
        }
    }
}
