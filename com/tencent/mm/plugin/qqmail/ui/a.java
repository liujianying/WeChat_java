package com.tencent.mm.plugin.qqmail.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.qqmail.b.n;
import com.tencent.mm.plugin.qqmail.b.w;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;
import junit.framework.Assert;

public final class a implements e, com.tencent.mm.pluginsdk.b.a, b {
    private static boolean mfX = false;
    private boolean bKe;
    private Context context;
    private ProgressDialog dId;
    private ProgressDialog eHw;
    private f eOE;
    private ab guS;
    private boolean lUD;
    private boolean mfW;

    public a(Context context) {
        Assert.assertTrue(context != null);
        this.context = context;
    }

    public final boolean wX(String str) {
        boolean z = false;
        x.d("MicroMsg.ContactWidgetQQMail", "handleEvent : key = " + str);
        if (bi.oV(str).length() <= 0) {
            return false;
        }
        Intent intent;
        if (str.equals("contact_info_qqmailhelper_view")) {
            intent = new Intent();
            if (this.lUD) {
                intent.putExtra("Chat_User", this.guS.field_username);
                intent.putExtra("Chat_Mode", 1);
                intent.addFlags(67108864);
                ((Activity) this.context).setResult(-1, intent);
            } else {
                intent.putExtra("Chat_User", this.guS.field_username);
                intent.putExtra("Chat_Mode", 1);
                intent.addFlags(67108864);
                com.tencent.mm.plugin.qqmail.a.a.ezn.e(intent, this.context);
            }
            ((Activity) this.context).finish();
            return true;
        } else if (str.equals("contact_info_qqmailhelper_compose")) {
            intent = new Intent(this.context, ComposeUI.class);
            if (this.lUD) {
                intent.putExtra("Chat_User", this.guS.field_username);
                intent.addFlags(67108864);
                ((Activity) this.context).setResult(-1, intent);
            } else {
                intent.putExtra("Chat_User", this.guS.field_username);
                intent.addFlags(67108864);
                this.context.startActivity(intent);
            }
            ((Activity) this.context).finish();
            return true;
        } else if (str.equals("contact_info_qqmailhelper_set_files_view")) {
            au.HU();
            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(bi.oV((String) c.DT().get(29, null))));
            intent2.putExtra("title", this.context.getString(R.l.contact_info_qqmailhelper_set_files_view));
            intent2.putExtra("zoom", false);
            intent2.putExtra("show_bottom", false);
            intent2.putExtra("showShare", false);
            intent2.putExtra("vertical_scroll", false);
            com.tencent.mm.plugin.qqmail.a.a.ezn.j(intent2, this.context);
            return true;
        } else if (str.equals("contact_info_qqmailhelper_recv_remind")) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.eOE.ZZ(str);
            boolean isChecked = checkBoxPreference.isChecked();
            hi(isChecked);
            if (!isChecked) {
                z = true;
            }
            checkBoxPreference.qpJ = z;
            return true;
        } else if (str.equals("contact_info_qqmailhelper_clear_data")) {
            h.a(this.context, this.context.getString(R.l.contact_info_clear_data_wording), "", new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    w.boy();
                }
            }, null);
            return true;
        } else if (str.equals("contact_info_qqmailhelper_install")) {
            au.HU();
            if (bi.f((Integer) c.DT().get(9, null)) == 0) {
                h.b(this.context, R.l.settings_weibo_notice, R.l.app_tip, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        com.tencent.mm.plugin.qqmail.a.a.ezn.h(null, a.this.context);
                    }
                }, null);
                return true;
            }
            hh(true);
            return true;
        } else if (str.equals("contact_info_qqmailhelper_uninstall")) {
            h.a(this.context, this.context.getString(R.l.settings_plugins_uninstall_hint), "", this.context.getString(R.l.app_clear), this.context.getString(R.l.app_cancel), new 3(this), null);
            return true;
        } else {
            x.e("MicroMsg.ContactWidgetQQMail", "handleEvent : unExpected key = " + str);
            return false;
        }
    }

    public final boolean a(f fVar, ab abVar, boolean z, int i) {
        boolean z2 = false;
        Assert.assertTrue(fVar != null);
        if (abVar != null) {
            z2 = true;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(s.hi(abVar.field_username));
        au.HU();
        c.DT().a(this);
        au.DF().a(24, this);
        this.lUD = z;
        this.guS = abVar;
        this.eOE = fVar;
        fVar.addPreferencesFromResource(R.o.contact_info_pref_qqmail);
        auv();
        return true;
    }

    private void auv() {
        boolean z;
        int i;
        boolean z2 = true;
        this.bKe = (q.GQ() & 1) == 0;
        au.HU();
        if (bi.f((Integer) c.DT().get(17, null)) == 1) {
            z = true;
        } else {
            z = false;
        }
        this.mfW = z;
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.eOE.ZZ("contact_info_header_helper");
        helperHeaderPreference.an(this.guS.field_username, this.guS.BL(), this.context.getString(R.l.contact_info_qqmailhelper_tip));
        if (this.bKe) {
            i = 1;
        } else {
            i = 0;
        }
        helperHeaderPreference.nw(i);
        this.eOE.bw("contact_info_qqmailhelper_install", this.bKe);
        f fVar = this.eOE;
        String str = "contact_info_qqmailhelper_view";
        if (this.bKe) {
            z = false;
        } else {
            z = true;
        }
        fVar.bw(str, z);
        fVar = this.eOE;
        str = "contact_info_qqmailhelper_compose";
        if (this.bKe) {
            z = false;
        } else {
            z = true;
        }
        fVar.bw(str, z);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.eOE.ZZ("contact_info_qqmailhelper_recv_remind");
        if (checkBoxPreference != null) {
            checkBoxPreference.qpJ = this.mfW;
        }
        fVar = this.eOE;
        str = "contact_info_qqmailhelper_recv_remind";
        if (this.bKe) {
            z = false;
        } else {
            z = true;
        }
        fVar.bw(str, z);
        fVar = this.eOE;
        str = "contact_info_qqmailhelper_set_files_view";
        if ((this.bKe & this.mfW) == 0) {
            z = true;
        } else {
            z = false;
        }
        fVar.bw(str, z);
        this.eOE.bw("contact_info_qqmailhelper_download_mgr_view", true);
        fVar = this.eOE;
        str = "contact_info_qqmailhelper_clear_data";
        if (this.bKe) {
            z = false;
        } else {
            z = true;
        }
        fVar.bw(str, z);
        f fVar2 = this.eOE;
        String str2 = "contact_info_qqmailhelper_uninstall";
        if (this.bKe) {
            z2 = false;
        }
        fVar2.bw(str2, z2);
    }

    private void hh(boolean z) {
        String string = z ? this.context.getString(R.l.settings_plugins_installing) : this.context.getString(R.l.settings_plugins_uninstalling);
        Context context = this.context;
        this.context.getString(R.l.app_tip);
        this.dId = h.a(context, string, true, null);
        mfX = true;
        hi(z);
    }

    public final boolean auw() {
        au.HU();
        c.DT().b(this);
        au.DF().b(24, this);
        if (this.dId != null) {
            this.dId.dismiss();
            this.dId = null;
        }
        if (this.eHw != null) {
            this.eHw.dismiss();
            this.eHw = null;
        }
        return true;
    }

    public final void a(int i, m mVar, Object obj) {
        int p = bi.p(obj, 0);
        x.d("MicroMsg.ContactWidgetQQMail", "onNotifyChange event:%d obj:%d stg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(p), mVar});
        au.HU();
        if (mVar != c.DT() || p <= 0) {
            x.e("MicroMsg.ContactWidgetQQMail", "onNotifyChange error obj:%d stg:%s", new Object[]{Integer.valueOf(p), mVar});
        } else if (p == 17 || p == 34 || p == 7) {
            auv();
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    private boolean hi(boolean z) {
        n nVar = new n(z, "");
        if (!mfX) {
            this.eHw = h.a(this.context, this.context.getString(R.l.app_waiting), true, new 4(this, nVar));
        }
        au.DF().a(nVar, 0);
        return false;
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar.getType() != 24) {
            x.w("MicroMsg.ContactWidgetQQMail", "onSceneEnd : unExpected type = " + lVar.getType());
            return;
        }
        if (this.eHw != null) {
            this.eHw.dismiss();
            this.eHw = null;
        }
        if (this.dId != null) {
            this.dId.dismiss();
            this.dId = null;
        }
        if (i == 0 && i2 == 0) {
            boolean z = ((n) lVar).ccZ;
            au.HU();
            c.DT().set(17, Integer.valueOf(z ? 1 : 2));
            if (mfX && bi.ci(this.context)) {
                if (z) {
                    au.HU();
                    c.DT().set(17, Integer.valueOf(1));
                }
                int GQ = q.GQ();
                int i3 = z ? GQ & -2 : GQ | 1;
                au.HU();
                c.DT().set(34, Integer.valueOf(i3));
                au.HU();
                c.FQ().b(new com.tencent.mm.aq.l("", "", "", "", "", "", "", "", i3, "", ""));
                com.tencent.mm.plugin.qqmail.a.a.ezo.vl();
                if (!z) {
                    w.boy();
                }
            }
            mfX = false;
            return;
        }
        CharSequence string;
        boolean z2 = ((n) lVar).ccZ;
        x.e("MicroMsg.ContactWidgetQQMail", "NetSceneSwitchPushMail fail : errType = " + i + ", errCode = " + i2);
        if (i == 4) {
            switch (i2) {
                case -31:
                    x.i("MicroMsg.ContactWidgetQQMail", "need second pass");
                    View inflate = View.inflate(this.context, R.i.secondpass, null);
                    h.a(this.context, this.context.getString(R.l.contact_info_qqmailhelper_secondpass), inflate, new 5(this, z2, (EditText) inflate.findViewById(R.h.secondpass_et)));
                    return;
                case IX5WebViewClient.ERROR_UNKNOWN /*-1*/:
                    x.w("MicroMsg.ContactWidgetQQMail", "onSceneEnd, sys err");
                    break;
                default:
                    return;
            }
        }
        if (mfX) {
            string = this.context.getString(z2 ? R.l.settings_plugins_install_fail : R.l.settings_plugins_uninstall_fail);
        } else {
            string = this.context.getString(R.l.app_err_server_busy_tip);
        }
        Toast.makeText(this.context, string, 1).show();
        mfX = false;
    }
}
