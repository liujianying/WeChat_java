package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.ac.f;
import com.tencent.mm.ac.i;
import com.tencent.mm.ac.z;
import com.tencent.mm.g.a.eq;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bd.a;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

public final class b {
    private static boolean isDeleteCancel = false;
    private static p tipDialog = null;

    public static void a(d dVar, Activity activity, ab abVar, int i) {
        a(dVar, activity, abVar, false, null, i);
    }

    public static void a(d dVar, Activity activity, ab abVar, boolean z, Runnable runnable, int i) {
        if (dVar == null || activity == null || abVar == null) {
            boolean z2;
            String str = "MicroMsg.BizContactDeleteUtil";
            String str2 = "bizInfo null : %s, context null : %s, ct null : %s";
            Object[] objArr = new Object[3];
            if (dVar == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[0] = Boolean.valueOf(z2);
            if (activity == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[1] = Boolean.valueOf(z2);
            if (abVar == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[2] = Boolean.valueOf(z2);
            x.e(str, str2, objArr);
            return;
        }
        String string;
        if (dVar.LZ()) {
            string = activity.getString(R.l.brandservice_remove_enterprise_tips);
        } else {
            string = activity.getString(R.l.brandservice_remove_subscribe_tips, new Object[]{abVar.BL()});
        }
        h.a(activity, string, "", activity.getString(R.l.contact_info_remove_biz_alert_sure), activity.getString(R.l.app_cancel), new 1(dVar, activity, abVar, z, i, runnable), null);
    }

    public static void c(d dVar, Activity activity, ab abVar) {
        a(dVar, activity, abVar, false, 0);
    }

    public static void a(d dVar, Activity activity, ab abVar, boolean z, int i) {
        boolean z2 = true;
        if (dVar == null || activity == null || abVar == null) {
            boolean z3;
            String str = "MicroMsg.BizContactDeleteUtil";
            String str2 = "error args, %b, %b, %b";
            Object[] objArr = new Object[3];
            if (dVar == null) {
                z3 = true;
            } else {
                z3 = false;
            }
            objArr[0] = Boolean.valueOf(z3);
            if (activity == null) {
                z3 = true;
            } else {
                z3 = false;
            }
            objArr[1] = Boolean.valueOf(z3);
            if (abVar != null) {
                z2 = false;
            }
            objArr[2] = Boolean.valueOf(z2);
            x.e(str, str2, objArr);
            return;
        }
        final String str3 = abVar.field_username;
        abVar.Bc();
        au.HU();
        c.FQ().b(new com.tencent.mm.aq.c(str3, i));
        if (s.hc(str3)) {
            au.HU();
            c.FR().Ym(str3);
            au.HU();
            c.Ga().in(str3);
        } else {
            isDeleteCancel = false;
            activity.getString(R.l.app_tip);
            tipDialog = h.a(activity, activity.getString(R.l.app_waiting), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    b.isDeleteCancel = true;
                }
            });
            AnonymousClass3 anonymousClass3 = new a() {
                public final boolean Ip() {
                    return b.isDeleteCancel;
                }

                public final void Io() {
                    z.MY().delete(str3);
                    if (b.tipDialog != null) {
                        b.tipDialog.dismiss();
                        b.tipDialog = null;
                    }
                }
            };
            au.HU();
            c.FR().a(str3, abVar);
            if (dVar.LY()) {
                f.kP(dVar.field_username);
            } else {
                bd.a(str3, anonymousClass3);
                au.HU();
                c.FW().Yp(str3);
            }
            if (activity != null && z) {
                activity.setResult(-1, activity.getIntent().putExtra("_delete_ok_", true));
            }
        }
        if (com.tencent.mm.app.plugin.a.a.a(dVar)) {
            eq eqVar = new eq();
            eqVar.bMu.bKC = str3;
            com.tencent.mm.sdk.b.a.sFg.m(eqVar);
        }
        i MX = z.MX();
        if (!bi.oW(str3)) {
            int delete = MX.diF.delete("BizKF", "brandUsername = ?", new String[]{str3});
            x.i("MicroMsg.BizKFStorage", "deleteKFWorker by brand username(u:%s, r:%d).", new Object[]{str3, Integer.valueOf(delete)});
        }
        z.Ne().Gy(str3);
        z.Nf().Gy(str3);
        if (z) {
            if (activity.getIntent().getIntExtra("Kdel_from", -1) == 0) {
                Intent intent = new Intent(activity, LauncherUI.class);
                intent.addFlags(67108864);
                activity.startActivity(intent);
            }
            activity.finish();
        }
    }
}
