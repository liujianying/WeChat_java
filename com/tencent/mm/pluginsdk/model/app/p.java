package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Bundle;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.ac.a.a;
import com.tencent.mm.plugin.comm.a.h;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedHashMap;
import java.util.Map;

public final class p {
    public static String h(Context context, String str, String str2) {
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            x.e("MicroMsg.AppUtil", "buildSourceUrl fail, invalid arguments");
            return null;
        }
        String d = w.d(context.getSharedPreferences(ad.chY(), 0));
        if (d == null || d.length() == 0) {
            d = "zh_CN";
        } else if (d.equals("en")) {
            d = "en_US";
        }
        return context.getString(h.openapi_source_url, new Object[]{str, Integer.valueOf(d.qVN), d, d.DEVICE_TYPE, str2});
    }

    public static String y(Context context, String str, String str2) {
        if (str == null || str.length() == 0 || str2.length() == 0) {
            x.e("MicroMsg.AppUtil", "buildUnistallUrl fail, invalid arguments");
            return null;
        }
        String d = w.d(context.getSharedPreferences(ad.chY(), 0));
        if (d == null || d.length() == 0) {
            d = "zh_CN";
        } else if (d.equals("en")) {
            d = "en_US";
        }
        return context.getString(h.openapi_uninstall_url, new Object[]{str, Integer.valueOf(d.qVN), d, d.DEVICE_TYPE, str2, Integer.valueOf(0)});
    }

    public static String B(String str, String str2) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.AppUtil", "buildRedirectUrl fail, invalid arguments");
            return null;
        }
        String str3;
        Object str22;
        int indexOf = str.indexOf("#");
        String str4 = "";
        if (indexOf >= 0) {
            str4 = str.substring(indexOf);
            str = str.substring(0, indexOf);
            str3 = str4;
        } else {
            str3 = str4;
        }
        int indexOf2 = str.indexOf("?");
        str4 = "";
        if (indexOf2 >= 0) {
            str4 = str.substring(indexOf2 + 1);
            str = str.substring(0, indexOf2);
        }
        x.v("MicroMsg.AppUtil", "buildRedirectUrl, sharpStr = %s, paramStr = %s, srcUrl = %s", new Object[]{str3, str4, str});
        Map linkedHashMap = new LinkedHashMap();
        if (!bi.oW(str4)) {
            String[] split = str4.split("&");
            if (split != null && split.length > 0) {
                for (String str5 : split) {
                    if (!bi.oW(str5)) {
                        Object substring;
                        Object substring2;
                        int indexOf3 = str5.indexOf("=");
                        x.v("MicroMsg.AppUtil", "buildRedirectUrl, equalIdx = %d", new Object[]{Integer.valueOf(indexOf3)});
                        if (indexOf3 >= 0) {
                            substring = str5.substring(0, indexOf3 + 1);
                            substring2 = str5.substring(indexOf3 + 1);
                        } else {
                            substring2 = "";
                            str4 = str5;
                        }
                        linkedHashMap.put(substring, substring2);
                    }
                }
            }
        }
        str4 = "from=";
        if (str22 == null) {
            str22 = "";
        }
        linkedHashMap.put(str4, str22);
        x.v("MicroMsg.AppUtil", "buildRedirectUrl, pMap size = %d", new Object[]{Integer.valueOf(linkedHashMap.size())});
        StringBuilder stringBuilder = new StringBuilder();
        for (String str42 : linkedHashMap.keySet()) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append("&");
            }
            stringBuilder.append(str42);
            stringBuilder.append((String) linkedHashMap.get(str42));
        }
        str42 = str + "?" + stringBuilder.toString();
        if (!bi.oW(str3)) {
            str42 = str42 + str3;
        }
        x.v("MicroMsg.AppUtil", "buildRedirectUrl, ret url = %s", new Object[]{str42});
        return str42;
    }

    public static boolean r(Context context, String str) {
        return getPackageInfo(context, str) != null;
    }

    public static PackageInfo getPackageInfo(Context context, String str) {
        PackageInfo packageInfo = null;
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.AppUtil", "getPackageInfo, packageName is null");
            return packageInfo;
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 0);
        } catch (NameNotFoundException e) {
            x.w("MicroMsg.AppUtil", "app not installed, packageName = " + str);
            return packageInfo;
        }
    }

    public static String bg(Context context, String str) {
        Signature[] bh = bh(context, str);
        if (bh != null && bh.length != 0) {
            return Tb(g.u(bh[0].toByteArray()));
        }
        x.e("MicroMsg.AppUtil", "signs is null");
        return null;
    }

    public static String Ta(String str) {
        if (str != null && str.length() != 0) {
            return Tb(str);
        }
        x.e("MicroMsg.AppUtil", "getDbSignature, svrSign is null");
        return null;
    }

    public static boolean c(Context context, f fVar, String str) {
        a bmm = a.a.bmm();
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.AppUtil", "isAppValid, packageName is null");
            bmm.c(fVar);
            return false;
        } else if (fVar == null) {
            x.i("MicroMsg.AppUtil", "app does not exist");
            return true;
        } else if (fVar.field_packageName == null || fVar.field_packageName.length() == 0) {
            x.e("MicroMsg.AppUtil", "isAppValid fail, local packageName is null");
            bmm.c(fVar);
            return false;
        } else if (fVar.field_signature == null || fVar.field_signature.length() == 0) {
            x.e("MicroMsg.AppUtil", "isAppValid fail, local signature is null");
            bmm.c(fVar);
            return false;
        } else {
            Signature[] bh = bh(context, str);
            if (bh == null || bh.length == 0) {
                x.e("MicroMsg.AppUtil", "isAppValid, apk signatures is null");
                bmm.c(fVar);
                return false;
            } else if (fVar.field_packageName.equals(str)) {
                x.i("MicroMsg.AppUtil", "server signatures:%s", new Object[]{fVar.field_signature});
                int length = bh.length;
                int i = 0;
                while (i < length) {
                    x.i("MicroMsg.AppUtil", "local signatures:%s", new Object[]{Tb(g.u(bh[i].toByteArray()))});
                    if (fVar.field_signature == null || !fVar.field_signature.equals(r6)) {
                        i++;
                    } else {
                        bmm.d(fVar);
                        return true;
                    }
                }
                x.w("MicroMsg.AppUtil", "isAppValid, signature is diff");
                bmm.c(fVar);
                return false;
            } else {
                x.e("MicroMsg.AppUtil", "isAppValid, packageName is diff, src:%s,local:%s", new Object[]{fVar.field_packageName, str});
                bmm.c(fVar);
                return false;
            }
        }
    }

    public static void ae(Bundle bundle) {
        bundle.putString("wx_token_key", "com.tencent.mm.openapi.token");
    }

    public static void af(Bundle bundle) {
        bundle.putString("platformId", "wechat");
    }

    public static void g(Bundle bundle, String str) {
        bundle.putString("platformId", "wechat");
        if (!bi.oW(str)) {
            bundle.putString("launchParam", str);
        }
    }

    public static Signature[] bh(Context context, String str) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.AppUtil", "getSignature, packageName is null");
            return null;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo != null) {
                return packageInfo.signatures;
            }
            x.e("MicroMsg.AppUtil", "info is null, packageName = " + str);
            return null;
        } catch (NameNotFoundException e) {
            x.e("MicroMsg.AppUtil", "NameNotFoundException");
            return null;
        }
    }

    public static String Tb(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str.toLowerCase());
        stringBuffer.append("mMHc ItnStR");
        return g.u(stringBuffer.toString().getBytes());
    }

    public static boolean b(Context context, f fVar) {
        x.i("MicroMsg.AppUtil", "check the signature of the Application.");
        if (context == null) {
            x.e("MicroMsg.AppUtil", "context is null.");
            return true;
        } else if (fVar == null) {
            x.e("MicroMsg.AppUtil", "appInfo is null.");
            return true;
        } else if (bi.oW(fVar.field_packageName)) {
            x.e("MicroMsg.AppUtil", "packageName is null.");
            return true;
        } else if (bi.oW(fVar.field_signature)) {
            x.e("MicroMsg.AppUtil", "app.field_signature is null. app.field_packageName is %s", new Object[]{fVar.field_packageName});
            return true;
        } else {
            Signature[] bh = bh(context, fVar.field_packageName);
            if (bh == null || bh.length == 0) {
                x.e("MicroMsg.AppUtil", "apk signatures is null");
                return false;
            }
            for (Signature toByteArray : bh) {
                if (fVar.field_signature.equals(Tb(g.u(toByteArray.toByteArray())))) {
                    x.i("MicroMsg.AppUtil", "app_name : %s ,signature : %s", new Object[]{fVar.field_appName, fVar.field_signature});
                    return true;
                }
            }
            x.w("MicroMsg.AppUtil", "signature is diff.(app_name:%s)", new Object[]{fVar.field_appName});
            return false;
        }
    }

    public static void Tc(String str) {
        if (bi.oW(str)) {
            x.e("MicroMsg.AppUtil", "appid is null");
            return;
        }
        SharedPreferences chZ = ad.chZ();
        if (chZ != null) {
            String string = chZ.getString("key_app_ids_registion_while_not_login", "");
            if (string.contains(str)) {
                x.i("MicroMsg.AppUtil", "this app has been saved : %s in %s", new Object[]{str, string});
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("|");
            stringBuilder.append(string);
            chZ.edit().putString("key_app_ids_registion_while_not_login", stringBuilder.toString()).commit();
        }
    }

    public static void cbS() {
        aq.qBc = null;
        aq.qBd = -1;
    }
}
