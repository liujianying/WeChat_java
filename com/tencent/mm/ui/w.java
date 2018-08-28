package com.tencent.mm.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ja;
import com.tencent.mm.k.g;
import com.tencent.mm.model.au;
import com.tencent.mm.pluginsdk.f.i;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.c;
import java.util.Map;
import org.xwalk.core.XWalkResourceClient;

public final class w {
    static ProgressDialog eHw = null;
    static SecurityImage eIX = null;
    private static boolean tnw = false;

    public static boolean a(final Activity activity, int i, int i2, final Intent intent, String str) {
        if (i != 4) {
            return false;
        }
        x.d("MicroMsg.MMErrorProcessor", "errType = " + i + " errCode = " + i2);
        switch (i2) {
            case -205:
            case -72:
            case XWalkResourceClient.ERROR_REDIRECT_LOOP /*-9*/:
            case XWalkResourceClient.ERROR_AUTHENTICATION /*-4*/:
            case -3:
                x.e("MicroMsg.MMErrorProcessor", "account expired=" + i2);
                h.a(activity, R.l.main_err_relogin, R.l.app_tip, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        if (intent != null) {
                            activity.finish();
                            activity.startActivity(intent);
                            b.E(activity, intent);
                            com.tencent.mm.platformtools.x.ca(activity);
                        }
                    }
                });
                return true;
            case -140:
            case -104:
                x.e("MicroMsg.MMErrorProcessor", "accout errCode[%d], errMsg[%s]", new Object[]{Integer.valueOf(i2), str});
                if (bi.oW(str) || !str.startsWith("autoauth_errmsg_")) {
                    if (i2 == -104) {
                        x.i("MicroMsg.MMErrorProcessor", "MM_ERR_LOGIC but not autoauth showMsg[%s] break", new Object[]{str});
                        break;
                    }
                }
                str = str.substring(16);
                if (!bi.oW(str) && str.startsWith("<")) {
                    Map z = bl.z(str, "e");
                    if (!(z == null || bi.oW((String) z.get(".e.Content")))) {
                        str = (String) z.get(".e.Content");
                    }
                }
                if (bi.oW(str)) {
                    str = ad.getContext().getString(R.l.main_err_relogin);
                }
                h.a(activity, str, ad.getContext().getString(R.l.app_tip), new 12(intent, activity));
                return true;
            case -100:
                String Dh = au.Dh();
                x.e("MicroMsg.MMErrorProcessor", "account expired=" + i2 + " lastKickReason=" + Dh);
                a.sFg.m(new com.tencent.mm.g.a.w());
                com.tencent.mm.kernel.a.hold();
                ja jaVar = new ja();
                jaVar.bSG.status = 0;
                jaVar.bSG.aAk = 1;
                a.sFg.m(jaVar);
                ad.getContext().getSharedPreferences("switch_account_preferences", 0).edit().putBoolean("last_logout_switch_account", false).commit();
                String str2;
                if (tnw) {
                    String str3 = "MicroMsg.MMErrorProcessor";
                    String str4 = "already show kickout dialog before, ignore. lastKickReason[%s]";
                    Object[] objArr = new Object[1];
                    if (bi.oW(Dh)) {
                        str2 = "";
                    } else {
                        str2 = Dh;
                    }
                    objArr[0] = str2;
                    x.i(str3, str4, objArr);
                    return true;
                }
                if (!bi.oW(Dh)) {
                    com.tencent.mm.h.a eV = com.tencent.mm.h.a.eV(Dh);
                    if (eV != null) {
                        x.i("MicroMsg.MMErrorProcessor", "account expired br showType[%d]", new Object[]{Integer.valueOf(eV.showType)});
                        if ((eV.showType == 3 || eV.showType == 4) && eV.a(activity, new 7(intent, activity, eV), new 8(intent, activity))) {
                            tnw = true;
                            x.i("MicroMsg.MMErrorProcessor", "show kickout dialog by new logic.");
                            return true;
                        }
                    }
                }
                if (!bi.oW(Dh) && Dh.startsWith("<")) {
                    Map z2 = bl.z(Dh, "e");
                    if (!(z2 == null || bi.oW((String) z2.get(".e.Content")))) {
                        str2 = (String) z2.get(".e.Content");
                        x.i("MicroMsg.MMErrorProcessor", "account expired summerauthkick errmsg=" + str2 + " |v=" + z2);
                        Dh = str2;
                    }
                }
                x.i("MicroMsg.MMErrorProcessor", "account expired lastKickReason[%s]", new Object[]{Dh});
                if (bi.oW(Dh)) {
                    Dh = com.tencent.mm.bp.a.af(activity, R.l.main_err_another_place);
                }
                h.a(activity, Dh, activity.getString(R.l.app_tip), new 9(intent, activity), new 10(intent, activity));
                tnw = true;
                x.i("MicroMsg.MMErrorProcessor", "show kickout dialog by old logic.");
                return true;
            case -75:
                x.e("MicroMsg.MMErrorProcessor", "account expired=" + i2);
                h.a(activity, R.l.alpha_version_tip_login, R.l.app_tip, new 11(intent, activity));
                return true;
        }
        return false;
    }

    public static c a(final Activity activity, String str, final String str2, final Intent intent) {
        ja jaVar = new ja();
        jaVar.bSG.status = 0;
        jaVar.bSG.aAk = 1;
        a.sFg.m(jaVar);
        return h.a(activity, str, activity.getString(R.l.app_tip), new 1(str2, activity, intent), new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                com.tencent.mm.plugin.report.service.h.mEJ.a(322, 24, 1, true);
                com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.mEJ;
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(4024);
                objArr[1] = String.format("%b|%s", new Object[]{Boolean.valueOf(bi.oW(str2)), str2});
                hVar.h(11098, objArr);
                activity.startActivity(intent);
                b.E(activity, intent);
                com.tencent.mm.platformtools.x.ca(activity);
            }
        });
    }

    public static boolean W(Activity activity) {
        boolean z = true;
        if (bi.WU(g.AT().getValue("SilentDownloadApkAtWiFi")) != 0) {
            return false;
        }
        au.HU();
        boolean z2 = (((Integer) com.tencent.mm.model.c.DT().get(7, Integer.valueOf(0))).intValue() & 16777216) == 0;
        if (!(ao.isWifi(activity) && z2)) {
            z = false;
        }
        if ((e.bxm & 1) != 0) {
            x.d("MicroMsg.MMErrorProcessor", "channel pack, not silence download.");
            z = false;
        } else {
            x.d("MicroMsg.MMErrorProcessor", "not channel pack.");
        }
        if (z && i.cch()) {
            return X(activity);
        }
        return false;
    }

    public static boolean gp(Context context) {
        String cce = i.cce();
        x.i("MicroMsg.MMErrorProcessor", "installRequired %s, updateType: %d", new Object[]{cce, Integer.valueOf(i.ccf())});
        if (bi.oW(cce) || i.ccg()) {
            return false;
        }
        au.Em().H(new 3(r3, cce, context));
        return true;
    }

    public static boolean c(final Activity activity, int i, int i2) {
        x.w("MicroMsg.MMErrorProcessor", "updateRequired [%d,%d] current version:%d  channel:%d updateMode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(d.qVN), Integer.valueOf(e.bxk), Integer.valueOf(e.bxm)});
        if (i != 4) {
            return false;
        }
        com.tencent.mm.plugin.y.a b;
        switch (i2) {
            case -17:
                long j = ad.getContext().getSharedPreferences("system_config_prefs", 0).getLong("recomended_update_ignore", -1);
                x.i("MicroMsg.MMErrorProcessor", "updateRequired last:%d  now:%d", new Object[]{Long.valueOf(j), Long.valueOf(bi.bG(j))});
                if (j != -1 && bi.bG(j) < 86400) {
                    return true;
                }
                if ((e.bxm & 2) != 0) {
                    x.d("MicroMsg.MMErrorProcessor", "channel pack, not silence download.");
                    return true;
                }
                x.d("MicroMsg.MMErrorProcessor", "not channel pack.");
                String value = g.AT().getValue("SilentDownloadApkAtWiFi");
                au.HU();
                boolean z = ((((Integer) com.tencent.mm.model.c.DT().get(7, Integer.valueOf(0))).intValue() & 16777216) == 0 ? 1 : null) != null && (bi.oW(value) || bi.WU(value) == 0);
                if ((e.bxm & 1) != 0) {
                    x.d("MicroMsg.MMErrorProcessor", "channel pack, not silence download.");
                    z = false;
                } else {
                    x.d("MicroMsg.MMErrorProcessor", "not channel pack.");
                }
                if (bi.WU(value) != 0) {
                    x.d("MicroMsg.MMErrorProcessor", "dynaCfg close silence wifi download.");
                }
                x.d("MicroMsg.MMErrorProcessor", "summerupdate updateRequired silenceDownload[%b]", new Object[]{Boolean.valueOf(z)});
                if (z) {
                    com.tencent.mm.plugin.report.service.h.mEJ.a(405, 40, 1, true);
                    return X(activity);
                } else if (com.tencent.mm.plugin.y.d.bfB() == null) {
                    return false;
                } else {
                    b = com.tencent.mm.plugin.y.d.bfB().b(activity, new 5(activity));
                    com.tencent.mm.plugin.report.service.h.mEJ.a(405, 38, 1, true);
                    b.update(2);
                    return true;
                }
            case -16:
                if (com.tencent.mm.plugin.y.d.bfB() == null) {
                    return false;
                }
                b = com.tencent.mm.plugin.y.d.bfB().b(activity, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        com.tencent.mm.plugin.report.service.h.mEJ.a(405, 37, 1, true);
                        activity.finish();
                        MMAppMgr.h(activity, true);
                    }
                });
                com.tencent.mm.plugin.report.service.h.mEJ.a(405, 36, 1, true);
                b.update(1);
                return true;
            default:
                return false;
        }
    }

    private static boolean X(Activity activity) {
        com.tencent.mm.pluginsdk.model.app.a cbF = com.tencent.mm.pluginsdk.model.app.a.cbF();
        if (cbF != null) {
            cbF.cbI();
            x.i("MicroMsg.MMErrorProcessor", "alpha download in silence.");
            return true;
        } else if (com.tencent.mm.plugin.y.d.bfB() == null) {
            return false;
        } else {
            com.tencent.mm.plugin.y.d.bfB().dS(activity).update(2);
            return true;
        }
    }
}
