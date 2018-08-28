package com.tencent.mm.pluginsdk.model;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.tencent.mm.plugin.e.a$b;
import com.tencent.mm.plugin.e.a.e;
import com.tencent.mm.plugin.e.a.f;
import com.tencent.mm.pluginsdk.model.s.a;
import java.net.URLEncoder;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class o extends r {
    public static final String[] qzh = new String[]{"application/msword", "application/vnd.ms-powerpoint", "application/vnd.ms-excel", "application/pdf", "application/epub+zip", "text/plain", "application/vnd.openxmlformats-officedocument.wordprocessingml.document", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", "application/vnd.openxmlformats-officedocument.presentationml.presentation", "application/zip", "application/rar"};
    public static final int[] qzi = new int[]{e.app_attach_file_icon_word, e.app_attach_file_icon_ppt, e.app_attach_file_icon_excel, e.app_attach_file_icon_pdf, e.app_attach_file_icon_epub, e.app_attach_file_icon_txt, e.app_attach_file_icon_word, e.app_attach_file_icon_excel, e.app_attach_file_icon_ppt, e.app_attach_file_icon_rar, e.app_attach_file_icon_rar};
    public static final int[] qzj = new int[]{e.app_attach_file_icon_word, e.app_attach_file_icon_ppt, e.app_attach_file_icon_excel, e.app_attach_file_icon_pdf, e.app_attach_file_icon_epub, e.app_attach_file_icon_txt, e.app_attach_file_icon_word, e.app_attach_file_icon_excel, e.app_attach_file_icon_ppt, e.app_attach_file_icon_rar, e.app_attach_file_icon_rar};

    public final boolean eM(Context context) {
        a eO = eO(context);
        if (eO.qzk == -1) {
            return false;
        }
        if (eO.qzk != 2 || eO.ver >= 33) {
            return true;
        }
        return false;
    }

    public static boolean SP(String str) {
        for (String equals : qzh) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean eN(Context context) {
        if (eO(context).qzk == -1) {
            return false;
        }
        return true;
    }

    public final boolean SK(String str) {
        if ("com.tencent.mtt".equals(str) || "com.tencent.qbx".equals(str) || "com.tencent.mtt.x86".equals(str) || "com.tencent.qbx5".equals(str)) {
            return true;
        }
        return false;
    }

    public final String Vw() {
        return "http://mdc.html5.qq.com/d/directdown.jsp?channel_id=10318";
    }

    public final String cbq() {
        return "qq_browser.apk";
    }

    public final a cbr() {
        a aVar = new a();
        aVar.qzq = f.qq_browser_desc_for_wb;
        aVar.qzs = f.qq_browser_lable;
        aVar.qzp = a$b.icon_qqbrowser;
        return aVar;
    }

    public final String a(Context context, ResolveInfo resolveInfo) {
        if (context == null || resolveInfo == null || resolveInfo.activityInfo == null || resolveInfo.activityInfo.packageName == null) {
            return null;
        }
        String str = resolveInfo.activityInfo.packageName;
        if ("com.qihoo.browser".equals(str)) {
            return "360浏览器";
        }
        if ("com.mx.browser".equals(str)) {
            return "傲游云浏览器";
        }
        if ("com.dolphin.browser.xf".equals(str)) {
            return "海豚浏览器";
        }
        if ("com.UCMobile".equals(str)) {
            return "UC浏览器";
        }
        if ("com.baidu.browser.apps".equals(str)) {
            return "百度浏览器";
        }
        if ("sogou.mobile.explorer".equals(str)) {
            return "搜狗浏览器";
        }
        if ("com.ijinshan.browser".equals(str)) {
            return "猎豹浏览器";
        }
        if ("com.mediawoz.xbrowser".equals(str)) {
            return "GO浏览器";
        }
        if ("com.oupeng.browser".equals(str)) {
            return "欧朋浏览器";
        }
        if ("com.tiantianmini.android.browser".equals(str)) {
            return "天天浏览器";
        }
        CharSequence loadLabel = resolveInfo.activityInfo.loadLabel(context.getPackageManager());
        if (loadLabel != null) {
            Matcher matcher = Pattern.compile("\\(.*推荐.*\\)", 2).matcher(loadLabel.toString());
            if (matcher.find()) {
                return matcher.replaceAll("");
            }
        }
        return resolveInfo.activityInfo.loadLabel(context.getPackageManager()).toString();
    }

    public static int bf(Context context, String str) {
        if (context == null) {
            return 3;
        }
        boolean z;
        int indexOf;
        if (str == null || str.length() == 0) {
            z = false;
        } else {
            String trim = str.trim();
            indexOf = trim.toLowerCase().indexOf("://");
            int indexOf2 = trim.toLowerCase().indexOf(46);
            z = (indexOf <= 0 || indexOf2 <= 0 || indexOf <= indexOf2) ? trim.toLowerCase().contains("://") : false;
        }
        if (!z) {
            str = "http://" + str;
        }
        try {
            Uri parse = Uri.parse(str);
            if (parse == null) {
                return 2;
            }
            if (parse.getScheme().toLowerCase().equals("qb")) {
                Object obj;
                a eO = eO(context);
                if (eO.qzk == -1) {
                    obj = null;
                } else if (eO.qzk != 2 || eO.ver >= 42) {
                    indexOf = 1;
                } else {
                    obj = null;
                }
                if (obj == null) {
                    parse = Uri.parse("http://mdc.html5.qq.com/d/directdown.jsp?channel_id=10375" + URLEncoder.encode(str, "UTF-8"));
                }
            }
            a eO2 = eO(context);
            if (eO2.qzk == -1) {
                return 4;
            }
            if (eO2.qzk == 2 && eO2.ver < 33) {
                return 5;
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            b e;
            if (eO2.qzk == 2) {
                if (eO2.ver >= 33 && eO2.ver <= 39) {
                    intent.setClassName("com.tencent.mtt", "com.tencent.mtt.PhotoEditUI");
                } else if (eO2.ver >= 40 && eO2.ver <= 45) {
                    intent.setClassName("com.tencent.mtt", "com.tencent.mtt.SplashActivity");
                } else if (eO2.ver >= 46) {
                    intent = new Intent("com.tencent.QQBrowser.action.VIEW");
                    e = e(context, parse);
                    if (!(e == null || TextUtils.isEmpty(e.classname))) {
                        intent.setClassName(e.qzm, e.classname);
                    }
                }
            } else if (eO2.qzk == 1) {
                if (eO2.ver == 1) {
                    intent.setClassName("com.tencent.qbx5", "com.tencent.qbx5.PhotoEditUI");
                } else if (eO2.ver == 2) {
                    intent.setClassName("com.tencent.qbx5", "com.tencent.qbx5.SplashActivity");
                }
            } else if (eO2.qzk != 0) {
                intent = new Intent("com.tencent.QQBrowser.action.VIEW");
                e = e(context, parse);
                if (!(e == null || TextUtils.isEmpty(e.classname))) {
                    intent.setClassName(e.qzm, e.classname);
                }
            } else if (eO2.ver >= 4 && eO2.ver <= 6) {
                intent.setClassName("com.tencent.qbx", "com.tencent.qbx.SplashActivity");
            } else if (eO2.ver > 6) {
                intent = new Intent("com.tencent.QQBrowser.action.VIEW");
                e = e(context, parse);
                if (!(e == null || TextUtils.isEmpty(e.classname))) {
                    intent.setClassName(e.qzm, e.classname);
                }
            }
            intent.setData(parse);
            try {
                intent.putExtra("loginType", 24);
                intent.putExtra("ChannelID", "com.tencent.mm");
                intent.putExtra("PosID", 0);
                context.startActivity(intent);
                return 0;
            } catch (ActivityNotFoundException e2) {
                return 4;
            }
        } catch (Exception e3) {
            return 2;
        }
    }

    private static a eO(Context context) {
        a aVar = new a();
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = null;
            try {
                packageInfo = packageManager.getPackageInfo("com.tencent.mtt", 0);
                aVar.qzk = 2;
                aVar.qzl = "ADRQB_";
                if (packageInfo != null && packageInfo.versionCode > 420000) {
                    aVar.ver = packageInfo.versionCode;
                    aVar.qzl += packageInfo.versionName.replaceAll("\\.", "");
                    return aVar;
                }
            } catch (NameNotFoundException e) {
            }
            try {
                packageInfo = packageManager.getPackageInfo("com.tencent.qbx", 0);
                aVar.qzk = 0;
                aVar.qzl = "ADRQBX_";
            } catch (NameNotFoundException e2) {
                try {
                    packageInfo = packageManager.getPackageInfo("com.tencent.qbx5", 0);
                    aVar.qzk = 1;
                    aVar.qzl = "ADRQBX5_";
                } catch (NameNotFoundException e3) {
                    try {
                        packageInfo = packageManager.getPackageInfo("com.tencent.mtt", 0);
                        aVar.qzk = 2;
                        aVar.qzl = "ADRQB_";
                    } catch (NameNotFoundException e4) {
                        try {
                            packageInfo = packageManager.getPackageInfo("com.tencent.mtt.x86", 0);
                            aVar.qzk = 2;
                            aVar.qzl = "ADRQB_";
                        } catch (Exception e5) {
                            try {
                                b e6 = e(context, Uri.parse("http://mdc.html5.qq.com/d/directdown.jsp?channel_id=10375"));
                                if (!(e6 == null || TextUtils.isEmpty(e6.qzm))) {
                                    packageInfo = packageManager.getPackageInfo(e6.qzm, 0);
                                    aVar.qzk = 2;
                                    aVar.qzl = "ADRQB_";
                                }
                            } catch (Exception e7) {
                            }
                        }
                    }
                }
            }
            if (packageInfo != null) {
                aVar.ver = packageInfo.versionCode;
                aVar.qzl += packageInfo.versionName.replaceAll("\\.", "");
            }
        } catch (Exception e8) {
        }
        return aVar;
    }

    private static b e(Context context, Uri uri) {
        Intent intent = new Intent("com.tencent.QQBrowser.action.VIEW");
        intent.setData(uri);
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (queryIntentActivities.size() <= 0) {
            return null;
        }
        b bVar = new b((byte) 0);
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            String str = resolveInfo.activityInfo.packageName;
            if (str.contains("com.tencent.mtt")) {
                bVar.classname = resolveInfo.activityInfo.name;
                bVar.qzm = resolveInfo.activityInfo.packageName;
                return bVar;
            } else if (str.contains("com.tencent.qbx")) {
                bVar.classname = resolveInfo.activityInfo.name;
                bVar.qzm = resolveInfo.activityInfo.packageName;
            }
        }
        return bVar;
    }

    public final boolean z(Context context, Intent intent) {
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
            for (ResolveInfo resolveInfo : queryIntentActivities) {
                String str = resolveInfo.activityInfo.packageName;
                if (str.contains("com.tencent.mtt")) {
                    return true;
                }
                if (str.contains("com.tencent.qbx")) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int SQ(String str) {
        Object obj = null;
        if (str != null && str.length() > 0) {
            obj = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str);
        }
        if (obj == null || obj.length() == 0) {
            obj = "*/" + str;
        }
        int i = -1;
        for (int i2 = 0; i2 < qzh.length; i2++) {
            if (qzh[i2].equals(obj)) {
                i = i2;
            }
        }
        return i != -1 ? qzi[i] : e.app_attach_file_icon_unknow;
    }
}
