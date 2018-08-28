package com.tencent.mm.plugin.account.bind.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a$a;
import com.tencent.mm.plugin.account.a$f;
import com.tencent.mm.plugin.account.a$g;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.plugin.account.a.d;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.friend.a.ag;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.a.l$a;
import com.tencent.mm.plugin.game.f$k;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.c;
import java.util.List;

public class FindMContactAlertUI extends MMWizardActivity {
    private int X = 0;
    private int Y = 0;
    private String bTi;
    private String eHA;
    private int eHB = 0;
    private final int eHC = 200;
    private int eHD = 0;
    private int eHE = 0;
    private int eHF = 0;
    private int eHG = 0;
    private String eHp = null;
    private String eHq = "";
    private int eHr = 2;
    private String eHs = null;
    private String eHt = null;
    private boolean eHu = false;
    private List<String[]> eHv = null;
    private ProgressDialog eHw = null;
    private ag eHx;
    private String eHy;
    private String eHz;
    private e ehD = null;

    static /* synthetic */ void a(FindMContactAlertUI findMContactAlertUI, int i, int i2) {
        findMContactAlertUI.eHD = i;
        findMContactAlertUI.eHE = i2;
        if (findMContactAlertUI.eHF > 0 && findMContactAlertUI.eHG > 0) {
            findMContactAlertUI.WQ();
        }
    }

    static /* synthetic */ void b(FindMContactAlertUI findMContactAlertUI, int i, int i2) {
        findMContactAlertUI.eHF = i;
        findMContactAlertUI.eHG = i2;
        if (findMContactAlertUI.eHD > 0 && findMContactAlertUI.eHE > 0) {
            findMContactAlertUI.WQ();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(j.find_mcontact_title);
        a.ezo.vo();
        this.eHp = getIntent().getStringExtra("regsetinfo_ticket");
        this.eHq = getIntent().getStringExtra("regsetinfo_NextStep");
        this.eHr = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
        this.eHs = getIntent().getStringExtra("alert_title");
        this.eHt = getIntent().getStringExtra("alert_message");
        this.eHu = l.XC() != l$a.SUCC;
        this.eHy = com.tencent.mm.plugin.c.a.Zu();
        x.d("MicroMsg.FindMContactAlertUI", "tigerreg mNextStep %s  mNextStyle %s ", new Object[]{this.eHq, Integer.valueOf(this.eHr)});
        if (!isFinishing()) {
            initView();
            WP();
        }
    }

    public void onDestroy() {
        x.d("MicroMsg.FindMContactAlertUI", "ondestroy");
        if (this.ehD != null) {
            g.DF().b(431, this.ehD);
            this.ehD = null;
        }
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        StringBuilder stringBuilder;
        if (this.eHu) {
            com.tencent.mm.plugin.c.a.pT("R300_100_QQ");
            stringBuilder = new StringBuilder();
            g.Eg();
            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",R300_100_QQ,");
            g.Eg();
            com.tencent.mm.plugin.c.a.d(true, stringBuilder.append(com.tencent.mm.kernel.a.gd("R300_100_QQ")).append(",1").toString());
            return;
        }
        com.tencent.mm.plugin.c.a.pT("R300_100_phone");
        stringBuilder = new StringBuilder();
        g.Eg();
        stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",RE300_100,");
        g.Eg();
        com.tencent.mm.plugin.c.a.d(true, stringBuilder.append(com.tencent.mm.kernel.a.gd("RE300_100")).append(",1").toString());
    }

    protected void onPause() {
        super.onPause();
        StringBuilder stringBuilder;
        if (this.eHu) {
            stringBuilder = new StringBuilder();
            g.Eg();
            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",R300_100_QQ,");
            g.Eg();
            com.tencent.mm.plugin.c.a.d(false, stringBuilder.append(com.tencent.mm.kernel.a.gd("R300_100_QQ")).append(",2").toString());
            return;
        }
        stringBuilder = new StringBuilder();
        g.Eg();
        stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",RE300_100,");
        g.Eg();
        com.tencent.mm.plugin.c.a.d(false, stringBuilder.append(com.tencent.mm.kernel.a.gd("RE300_100")).append(",2").toString());
    }

    protected final void initView() {
        this.eHz = getString(j.find_mcontact_bind_alert_title);
        this.eHA = getString(j.find_mcontact_bind_alert_content);
        if (!bi.oW(this.eHs)) {
            this.eHz = this.eHs;
        }
        if (!bi.oW(this.eHt)) {
            this.eHA = this.eHt;
        }
        this.bTi = (String) g.Ei().DT().get(6, null);
        if (this.bTi == null || this.bTi.equals("")) {
            this.bTi = (String) g.Ei().DT().get(4097, null);
        }
    }

    private void WP() {
        if (this.eHu) {
            StringBuilder stringBuilder = new StringBuilder();
            g.Eg();
            stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(getClass().getName()).append(",R300_200_phone,");
            g.Eg();
            com.tencent.mm.plugin.c.a.pV(stringBuilder.append(com.tencent.mm.kernel.a.gd("R300_200_phone")).append(",1").toString());
            h.a(this, false, getString(j.find_mcontact_bind_alert_content), getString(j.app_tip), getString(j.app_ok), getString(j.app_cancel), new 1(this), new 4(this));
        } else if (l.XB()) {
            CharSequence charSequence = this.eHA;
            CharSequence charSequence2 = this.eHz;
            int i = j.find_mcontact_upload_ok;
            int i2 = j.find_mcontact_upload_learn_more;
            OnClickListener anonymousClass5 = new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    g.Ei().DT().set(12322, Boolean.valueOf(true));
                    FindMContactAlertUI.this.WR();
                    dialogInterface.dismiss();
                }
            };
            OnClickListener anonymousClass6 = new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent(FindMContactAlertUI.this, FindMContactLearmMoreUI.class);
                    intent.putExtra("regsetinfo_ticket", FindMContactAlertUI.this.eHp);
                    intent.putExtra("regsetinfo_NextStep", FindMContactAlertUI.this.eHq);
                    intent.putExtra("regsetinfo_NextStyle", FindMContactAlertUI.this.eHr);
                    MMWizardActivity.D(FindMContactAlertUI.this, intent);
                }
            };
            final c cVar = new c(this);
            cVar.setTitle(charSequence2);
            cVar.setMessage(charSequence);
            cVar.a(i, anonymousClass5);
            cVar.b(i2, anonymousClass6);
            cVar.pxh.setVisibility(0);
            cVar.setCancelable(false);
            cVar.show();
            cVar.getWindow().clearFlags(2);
            addDialog(cVar);
            cVar.getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
                public final void onGlobalLayout() {
                    int measuredWidth;
                    cVar.getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    int measuredWidth2 = cVar.getWindow().getDecorView().getMeasuredWidth();
                    int measuredHeight = cVar.getWindow().getDecorView().getMeasuredHeight();
                    View a = FindMContactAlertUI.this.f((ViewGroup) cVar.getWindow().getDecorView());
                    if (a != null) {
                        measuredWidth = a.getMeasuredWidth() * 2;
                    } else {
                        measuredWidth = measuredWidth2;
                    }
                    x.d("MicroMsg.FindMContactAlertUI", "dialog width: %s height: %s", new Object[]{Integer.valueOf(measuredWidth), Integer.valueOf(measuredHeight)});
                    FindMContactAlertUI.a(FindMContactAlertUI.this, measuredWidth, measuredHeight);
                }
            });
            final View findViewById = findViewById(a$f.background);
            findViewById.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
                public final void onGlobalLayout() {
                    findViewById.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    int measuredHeight = findViewById.getMeasuredHeight();
                    x.d("MicroMsg.FindMContactAlertUI", "bg width: %s height: %s", new Object[]{Integer.valueOf(findViewById.getMeasuredWidth()), Integer.valueOf(measuredHeight)});
                    FindMContactAlertUI.b(FindMContactAlertUI.this, r1, measuredHeight);
                }
            });
        } else {
            WR();
        }
    }

    private View f(ViewGroup viewGroup) {
        if (this.eHB >= 200) {
            return null;
        }
        this.eHB++;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof Button) {
                return childAt;
            }
            if (childAt instanceof ViewGroup) {
                childAt = f((ViewGroup) childAt);
                if (childAt != null) {
                    return childAt;
                }
            }
        }
        return null;
    }

    private void WQ() {
        int height = getWindowManager().getDefaultDisplay().getHeight();
        int dimensionPixelSize = this.eHF - (getResources().getDimensionPixelSize(d.PopPadding) + com.tencent.mm.bp.a.fromDPToPix(this, 48));
        int fromDPToPix = com.tencent.mm.bp.a.fromDPToPix(this, 20) + (((height / 2) + (this.eHE / 2)) - (height - this.eHG));
        if (dimensionPixelSize != this.X || fromDPToPix != this.Y) {
            this.X = dimensionPixelSize;
            this.Y = fromDPToPix;
            View findViewById = findViewById(a$f.findmcontact_arrow);
            findViewById.setVisibility(0);
            LayoutParams layoutParams = (LayoutParams) findViewById.getLayoutParams();
            layoutParams.setMargins(dimensionPixelSize - (findViewById.getMeasuredWidth() / 2), fromDPToPix, 0, 0);
            x.d("MicroMsg.FindMContactAlertUI", "attachArrow x: %s y: %s view.width: %s", new Object[]{Integer.valueOf(dimensionPixelSize), Integer.valueOf(fromDPToPix), Integer.valueOf(findViewById.getMeasuredWidth())});
            findViewById.setLayoutParams(layoutParams);
            findViewById.startAnimation(AnimationUtils.loadAnimation(this, a$a.arrow_appare));
        }
    }

    private void WR() {
        x.i("MicroMsg.FindMContactAlertUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)), bi.cjd()});
        if (com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)) {
            View findViewById = findViewById(a$f.findmcontact_arrow);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            o DF = g.DF();
            9 9 = new 9(this);
            this.ehD = 9;
            DF.a(431, 9);
            ActionBarActivity actionBarActivity = this.mController.tml;
            getString(j.app_tip);
            this.eHw = h.a(actionBarActivity, getString(j.app_loading), true, new 10(this));
            g.Em().a(new ah.a() {
                public final boolean Ks() {
                    if (FindMContactAlertUI.this.eHv == null || FindMContactAlertUI.this.eHv.size() == 0) {
                        if (FindMContactAlertUI.this.eHw != null) {
                            FindMContactAlertUI.this.eHw.dismiss();
                            FindMContactAlertUI.this.eHw = null;
                        }
                        FindMContactAlertUI.this.WL();
                    } else {
                        FindMContactAlertUI.this.eHx = new ag(FindMContactAlertUI.this.eHp, FindMContactAlertUI.this.eHv);
                        g.DF().a(FindMContactAlertUI.this.eHx, 0);
                    }
                    return false;
                }

                public final boolean Kr() {
                    try {
                        FindMContactAlertUI.this.eHv = com.tencent.mm.pluginsdk.a.cz(FindMContactAlertUI.this);
                        x.d("MicroMsg.FindMContactAlertUI", "tigerreg mobileList size " + (FindMContactAlertUI.this.eHv == null ? 0 : FindMContactAlertUI.this.eHv.size()));
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.FindMContactAlertUI", e, "", new Object[0]);
                    }
                    return true;
                }

                public final String toString() {
                    return super.toString() + "|doUpload";
                }
            });
            ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).syncUploadMContactStatus(true, false);
            ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).syncAddrBookAndUpload();
            com.tencent.mm.plugin.report.service.h.mEJ.h(11438, new Object[]{Integer.valueOf(1)});
            x.i("MicroMsg.FindMContactAlertUI", "[cpan] kv report logid:%d scene:%d", new Object[]{Integer.valueOf(11438), Integer.valueOf(1)});
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
        return a$g.findmcontact_intro_with_alert;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.FindMContactAlertUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case f$k.AppCompatTheme_homeAsUpIndicator /*48*/:
                if (iArr[0] == 0) {
                    WR();
                    return;
                } else {
                    h.a(this, getString(j.permission_contacts_request_again_msg), getString(j.permission_tips_title), getString(j.jump_to_settings), getString(j.app_cancel), false, new 2(this), new 3(this));
                    return;
                }
            default:
                return;
        }
    }
}
