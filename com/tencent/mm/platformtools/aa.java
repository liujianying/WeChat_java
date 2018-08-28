package com.tencent.mm.platformtools;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.account.ui.q.e;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.pluginsdk.ui.BioHelperUI;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.xt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

public final class aa {
    public static void showAddrBookUploadConfirm(final Activity activity, final Runnable runnable, boolean z, int i) {
        if (l.XC() != a.eKt && l.XC() != a.eKu) {
            x.e("MicroMsg.PostLoginUtil", "not successfully binded, skip addrbook confirm");
        } else if (bi.d((Boolean) g.Ei().DT().get(12322, null))) {
            x.d("MicroMsg.PostLoginUtil", "addrbook upload confirmed");
        } else if (z || !bi.d((Boolean) g.Ei().DT().get(12323, null))) {
            g.Ei().DT().set(12322, Boolean.valueOf(false));
            String oV = bi.oV(bi.fR(activity));
            if (oV.length() <= 0 || !oV.equals(g.Ei().DT().get(6, null))) {
                h.a(activity, e.bind_mcontact_bind_alert_content, e.app_tip, e.app_yes, e.app_no, new 1(i, activity, runnable), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        g.Ei().DT().set(12322, Boolean.valueOf(false));
                        aa.syncUploadMContactStatus(false, false);
                        if (runnable != null) {
                            runnable.run();
                        }
                        activity.getSharedPreferences(ad.chY(), 0).edit().putBoolean("login_upload_contacts_already_displayed", true).commit();
                    }
                });
                g.Ei().DT().set(12323, Boolean.valueOf(true));
                return;
            }
            g.Ei().DT().set(12322, Boolean.valueOf(true));
            x.i("MicroMsg.PostLoginUtil", "same none-nil phone number, leave it");
        } else {
            x.d("MicroMsg.PostLoginUtil", "addrbook upload login confirmed showed");
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    public static void syncUploadMContactStatus(boolean z, boolean z2) {
        int GJ = q.GJ();
        if (z) {
            GJ &= -131073;
        } else {
            GJ |= 131072;
        }
        x.d("MicroMsg.PostLoginUtil", "Reg By mobile update = " + GJ);
        g.Ei().DT().set(7, Integer.valueOf(GJ));
        GJ = !z ? 1 : 2;
        xt xtVar = new xt();
        xtVar.rDz = 17;
        xtVar.rDA = GJ;
        ((i) g.l(i.class)).FQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.h.a(23, xtVar));
        if (z2) {
            com.tencent.mm.plugin.account.a.a.ezo.vl();
        }
    }

    public static void oS(String str) {
        at.dBv.T("login_user_name", str);
    }

    public static void ch(Context context) {
        String string = context.getString(e.alpha_version_tip_login);
        String string2 = context.getString(e.alpha_version_open_offical_url);
        String string3 = context.getString(e.confirm_dialog_ok);
        String string4 = context.getString(e.confirm_dialog_cancel);
        3 3 = new 3(string2, context);
        h.a(context, string, "", string3, string4, 3, null);
    }

    public static void n(final Context context, String str, final String str2) {
        com.tencent.mm.h.a eV = com.tencent.mm.h.a.eV(str);
        if (eV != null) {
            eV.a(context, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str2);
                    intent.putExtra("showShare", false);
                    intent.putExtra("show_bottom", false);
                    intent.putExtra("needRedirect", false);
                    intent.putExtra("neverGetA8Key", true);
                    intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.qWa);
                    intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.qVX);
                    com.tencent.mm.plugin.account.a.a.ezn.j(intent, context);
                }
            }, null);
        }
    }

    public static void a(Context context, com.tencent.mm.modelsimple.q.a aVar, int i) {
        Intent intent = new Intent(context, BioHelperUI.class);
        intent.putExtra("k_type", aVar.type);
        intent.putExtra("KVoiceHelpCode", i);
        intent.putExtra("Kvertify_key", aVar.bLe);
        intent.putExtra("KVoiceHelpUrl", aVar.efV);
        intent.putExtra("KVoiceHelpWording", aVar.bSc);
        intent.putExtra("Kusername", aVar.username);
        if (aVar.efW != null) {
            intent.getExtras().putAll(aVar.efW);
        }
    }

    public static void e(Context context, String str, int i) {
        com.tencent.mm.h.a eV = com.tencent.mm.h.a.eV(str);
        if (eV == null) {
            return;
        }
        if (eV.showType == 8) {
            a.b(context, eV.url, i, false);
            return;
        }
        String string = context.getString(e.app_ok);
        String string2 = context.getString(e.app_cancel);
        5 5 = new 5(context, eV, i);
        if (eV.showType != 1 && eV.showType != 4) {
            return;
        }
        if (bi.oW(eV.url)) {
            h.b(context, eV.desc, eV.bHD, true);
            return;
        }
        h.a(context, eV.desc, eV.bHD, string, string2, 5, null);
    }
}
