package com.tencent.mm.pluginsdk.ui.tools;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.webkit.MimeTypeMap;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.e.a.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.e.i;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public final class a {
    private static Intent qQV;
    private static WeakReference<Activity> qQW;
    private static final HashMap<String, String> qQX;

    public static boolean a(Activity activity, String str, String str2, int i) {
        x.i("MicroMsg.AppChooserIntentUtil", "path:%s, isExisted:%b, size:%d", new Object[]{str, Boolean.valueOf(r0.exists()), Long.valueOf(new File(str).length())});
        if (new File(str).exists()) {
            int i2;
            String TV = TV(str2);
            String TU = TU(TV);
            if (!TU.equals("")) {
                x.i("MicroMsg.AppChooserIntentUtil", "User exist always config, package is %s", new Object[]{TU});
                Intent fE = fE(TV, str);
                fE.setPackage(TU);
                if (bi.k(activity, fE)) {
                    x.i("MicroMsg.AppChooserIntentUtil", "Always package support mimeType");
                    activity.startActivity(fE);
                    return false;
                }
                x.i("MicroMsg.AppChooserIntentUtil", "Always package do not support mimeType");
                x.i("MicroMsg.AppChooserIntentUtil", "Always package do not support mimeType");
            }
            x.i("MicroMsg.AppChooserIntentUtil", "QQBrowser status is %s", new Object[]{z(activity, TV, str).name()});
            if (z(activity, TV, str) == a.qRc) {
                Intent fG = fG(str, str2);
                if (bi.k(activity, fG)) {
                    fG.setFlags(268435456);
                    activity.startActivity(fG);
                    h.mEJ.h(11168, new Object[]{Integer.valueOf(5), Integer.valueOf(i)});
                    return false;
                }
                fG.setFlags(268435456);
                Intent fF = fF(TV, str);
                if (bi.k(activity, fF)) {
                    activity.startActivity(fF);
                    h.mEJ.h(11168, new Object[]{Integer.valueOf(5), Integer.valueOf(i)});
                    x.e("MicroMsg.AppChooserIntentUtil", "Occur error, has bugs, status is install and support but not found support activity");
                } else {
                    x.e("MicroMsg.AppChooserIntentUtil", "Occur error, has bugs, status is install and support but not found support activity");
                    return true;
                }
            }
            if (!bi.oW(str2)) {
                TV = (String) g.Ei().DT().get(com.tencent.mm.storage.aa.a.sTp, "");
                if (!bi.oW(TV) && TV.contains(str2)) {
                    i2 = 1;
                    if (i2 != 0) {
                        return true;
                    }
                    c(activity, str, str2);
                    return false;
                }
            }
            i2 = 0;
            if (i2 != 0) {
                return true;
            }
            c(activity, str, str2);
            return false;
        }
        x.e("MicroMsg.AppChooserIntentUtil", "Cannot open file not existed!");
        return true;
    }

    public static void b(Activity activity, String str, String str2, int i) {
        boolean z = true;
        x.i("MicroMsg.AppChooserIntentUtil", "path:%s, isExisted:%b, size:%d", new Object[]{str, Boolean.valueOf(r0.exists()), Long.valueOf(new File(str).length())});
        if (new File(str).exists()) {
            Parcelable fE;
            boolean z2;
            boolean z3;
            String TV = TV(str2);
            String TU = TU(TV);
            if (!TU.equals("")) {
                x.i("MicroMsg.AppChooserIntentUtil", "User exist always config, package is %s", new Object[]{TU});
                Intent fE2 = fE(TV, str);
                fE2.setPackage(TU);
                if (bi.k(activity, fE2)) {
                    x.i("MicroMsg.AppChooserIntentUtil", "Always package support mimeType");
                    activity.startActivity(fE2);
                    return;
                }
                x.i("MicroMsg.AppChooserIntentUtil", "Always package do not support mimeType");
            }
            x.i("MicroMsg.AppChooserIntentUtil", "QQBrowser status is %s", new Object[]{z(activity, TV, str).name()});
            switch (1.qQY[z(activity, TV, str).ordinal()]) {
                case 1:
                    fE = fE(TV, str);
                    z2 = true;
                    z3 = false;
                    break;
                case 2:
                    fE = fE(TV, str);
                    z2 = false;
                    z3 = false;
                    break;
                case 3:
                    fE = fE(TV, str);
                    z2 = true;
                    z3 = true;
                    break;
                case 4:
                    Intent fG = fG(str, str2);
                    if (!bi.k(activity, fG)) {
                        fE = fE(TV, str);
                        z2 = true;
                        z3 = false;
                        break;
                    }
                    activity.startActivity(fG);
                    return;
                default:
                    fE = fE(TV, str);
                    z2 = true;
                    z3 = false;
                    break;
            }
            String TV2 = TV(str2);
            Uri fromFile = Uri.fromFile(new File(str));
            Bundle bundle = new Bundle();
            bundle.putString("targeturl", fromFile.toString());
            bundle.putString("filepath", str);
            bundle.putString("fileext", str2);
            bundle.putParcelable("targetintent", fE);
            Intent intent = new Intent();
            intent.putExtra(DownloadSettingTable$Columns.TYPE, 0);
            intent.putExtra("title", activity.getResources().getString(f.choose_app));
            intent.putExtra("needupate", z3);
            TU = "not_show_recommend_app";
            if (z2) {
                z = false;
            }
            intent.putExtra(TU, z);
            intent.putExtra("mimetype", TV2);
            intent.putExtra("targetintent", fE);
            intent.putExtra("transferback", bundle);
            intent.putExtra("scene", i);
            c(activity, str, str2);
            qQV = intent;
            qQW = new WeakReference(activity);
            return;
        }
        x.e("MicroMsg.AppChooserIntentUtil", "Cannot open file not existed!");
    }

    private static void c(Activity activity, String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra("file_path", str);
        intent.putExtra("file_ext", str2);
        intent.setComponent(new ComponentName(i.thA, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CHECK_MINIQB_CAN_OPEN_FILE");
        activity.sendBroadcast(intent);
    }

    public static void an(Intent intent) {
        boolean booleanExtra = intent.getBooleanExtra("MINIQB_OPEN_RET_VAL", false);
        intent.getStringExtra("file_path");
        Object stringExtra = intent.getStringExtra("file_ext");
        x.i("MicroMsg.AppChooserIntentUtil", "miniQB retVal:%b", new Object[]{Boolean.valueOf(booleanExtra)});
        if (g.Eg().Dx()) {
            Object obj = (String) g.Ei().DT().get(com.tencent.mm.storage.aa.a.sTp, "");
            if (!booleanExtra) {
                obj = obj.replace(stringExtra, "");
            } else if (!obj.contains(stringExtra)) {
                obj = obj.concat(stringExtra);
            }
            g.Ei().DT().a(com.tencent.mm.storage.aa.a.sTp, obj);
            if (!(booleanExtra || qQV == null || qQW == null || qQW.get() == null)) {
                qQV.setClass((Context) qQW.get(), AppChooserUI.class);
                ((Activity) qQW.get()).startActivityForResult(qQV, 2);
            }
            qQV = null;
        }
    }

    public static void a(Activity activity, int i, int i2, Intent intent, boolean z, int i3, int i4, int i5) {
        if (i != 2) {
            return;
        }
        if (-1 == i2 && intent != null) {
            String stringExtra = intent.getStringExtra("selectpkg");
            Bundle bundleExtra = intent.getBundleExtra("transferback");
            Intent intent2 = (Intent) bundleExtra.getParcelable("targetintent");
            String string = bundleExtra.getString("filepath");
            String string2 = bundleExtra.getString("fileext");
            if (intent2 != null) {
                Intent fG;
                x.i("MicroMsg.AppChooserIntentUtil", "AppChooserUI select package name %s and target intent is not null", new Object[]{stringExtra});
                if ("com.tencent.mtt".equals(stringExtra) && string != null) {
                    fG = fG(string, string2);
                    fG.addFlags(524288);
                    fG.putExtra("ChannelID", "com.tencent.mm");
                    fG.putExtra("PosID", 4);
                    if (bi.k(activity, fG)) {
                        x.i("MicroMsg.AppChooserIntentUtil", "user has installed new version of QQbrowser");
                        activity.startActivity(fG);
                        h.mEJ.h(11168, new Object[]{Integer.valueOf(5), Integer.valueOf(i5)});
                        return;
                    }
                }
                fG = new Intent(intent2);
                fG.setPackage(stringExtra);
                fG.addFlags(524288);
                if (bi.k(activity, fG)) {
                    activity.startActivity(fG);
                    return;
                }
                x.e("MicroMsg.AppChooserIntentUtil", "Always Intent is not support mimetype");
                if (z) {
                    com.tencent.mm.ui.base.h.i(activity, i3, i4);
                    return;
                }
                return;
            }
            x.e("MicroMsg.AppChooserIntentUtil", "AppChooserUI target intent is null in handlerResultOfAppChooserUI");
            if (z) {
                com.tencent.mm.ui.base.h.i(activity, i3, i4);
            }
        } else if (4098 == i2) {
            x.e("MicroMsg.AppChooserIntentUtil", "Not Found App Support media type");
            if (z) {
                com.tencent.mm.ui.base.h.i(activity, i3, i4);
            }
        } else if (4097 == i2) {
            x.i("MicroMsg.AppChooserIntentUtil", "AppChooserUI result code is no choice");
            if (z) {
                com.tencent.mm.ui.base.h.i(activity, i3, i4);
            }
        } else {
            x.i("MicroMsg.AppChooserIntentUtil", "AppChooserUI result code is not ok or data is null");
        }
    }

    private static Intent fE(String str, String str2) {
        Uri fromFile = Uri.fromFile(new File(str2));
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setDataAndType(fromFile, str);
        return intent;
    }

    private static Intent fF(String str, String str2) {
        Intent intent = new Intent();
        intent.setPackage("com.tencent.mtt");
        intent.setAction("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(new File(str2)), str);
        return intent;
    }

    private static Intent fG(String str, String str2) {
        Intent intent = new Intent("com.tencent.QQBrowser.action.sdk.document");
        File file = new File(str);
        intent.setPackage("com.tencent.mtt");
        intent.putExtra("ChannelID", "com.tencent.mm");
        intent.putExtra("PosID", 4);
        intent.putExtra("key_reader_sdk_id", 1);
        intent.putExtra("key_reader_sdk_type", 0);
        intent.putExtra("key_reader_sdk_format", str2);
        intent.putExtra("key_reader_sdk_path", str);
        intent.setData(Uri.fromFile(file));
        return intent;
    }

    private static String TU(String str) {
        int i = 274528;
        com.tencent.mm.storage.x DT = g.Ei().DT();
        if (str != null) {
            i = 274528 + str.hashCode();
        }
        return (String) DT.get(i, "");
    }

    private static a z(Context context, String str, String str2) {
        if (!o.eN(context)) {
            return a.qQZ;
        }
        if (bi.k(context, fF(str, str2))) {
            return a.qRc;
        }
        if (o.SP(str)) {
            return a.qRa;
        }
        return a.qRb;
    }

    private static String TV(String str) {
        String str2 = null;
        if (str != null && str.length() > 0) {
            str2 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str);
        }
        if (str2 == null || str2.length() == 0) {
            str2 = (String) qQX.get(str);
        }
        if (str2 != null && str2.length() != 0) {
            return str2;
        }
        x.w("MicroMsg.AppChooserIntentUtil", "getMimeType fail, not a built-in mimetype, use \"*/{fileext}\" instead");
        return "*/" + str;
    }

    static {
        HashMap hashMap = new HashMap();
        qQX = hashMap;
        hashMap.put("wps", "application/wps");
        qQX.put("ett", "application/ett");
        qQX.put("log", "application/log");
        qQX.put("wpt", "application/wpt");
        qQX.put("et", "application/et");
        qQX.put("ksdps", "application/ksdps");
        qQX.put("kset", "application/kset");
        qQX.put("kswps", "application/kswps");
    }
}
