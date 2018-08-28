package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import java.util.Locale;

public final class w {
    public static Locale sGk = Locale.getDefault();

    public static boolean Wk(String str) {
        if (bi.oW(str)) {
            return false;
        }
        if (str.equalsIgnoreCase("zh_TW") || str.equalsIgnoreCase("zh_HK") || str.equalsIgnoreCase("zh_CN") || str.equalsIgnoreCase("en") || str.equalsIgnoreCase("th") || str.equals("id") || str.equals("vi") || str.equalsIgnoreCase("pt") || str.equalsIgnoreCase("es") || str.equalsIgnoreCase("ru") || str.equalsIgnoreCase("ar") || str.equalsIgnoreCase("ja") || str.equalsIgnoreCase("it") || str.equalsIgnoreCase("ko") || str.equalsIgnoreCase("ms") || str.equalsIgnoreCase("tr") || str.equalsIgnoreCase("de") || str.equalsIgnoreCase("fr") || str.equalsIgnoreCase("my") || str.equalsIgnoreCase("lo")) {
            return true;
        }
        return false;
    }

    public static boolean chL() {
        String chP = chP();
        return chP.equals("zh_CN") || chP.equals("zh_TW") || chP.equals("zh_HK");
    }

    public static boolean chM() {
        if (chP().equals("zh_CN")) {
            return true;
        }
        return false;
    }

    public static boolean chN() {
        return chP().equals("zh_TW") || chP().equals("zh_HK");
    }

    public static void a(Context context, Locale locale) {
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        configuration.locale = locale;
        resources.updateConfiguration(configuration, displayMetrics);
        Resources.getSystem().updateConfiguration(configuration, displayMetrics);
    }

    public static Locale Wl(String str) {
        if (str.equals("zh_TW")) {
            return Locale.TAIWAN;
        }
        if (str.equals("zh_HK")) {
            return new Locale("zh", "HK");
        }
        if (str.equals("en")) {
            return Locale.ENGLISH;
        }
        if (str.equals("zh_CN")) {
            return Locale.CHINA;
        }
        if (str.equalsIgnoreCase("th") || str.equalsIgnoreCase("id") || str.equalsIgnoreCase("vi") || str.equalsIgnoreCase("pt") || str.equalsIgnoreCase("es") || str.equalsIgnoreCase("ru") || str.equalsIgnoreCase("ar") || str.equalsIgnoreCase("ja") || str.equalsIgnoreCase("it") || str.equalsIgnoreCase("ko") || str.equalsIgnoreCase("ms") || str.equalsIgnoreCase("tr") || str.equalsIgnoreCase("de") || str.equalsIgnoreCase("fr") || str.equalsIgnoreCase("my") || str.equalsIgnoreCase("lo")) {
            return new Locale(str);
        }
        if (str.equalsIgnoreCase("in_ID")) {
            return new Locale("id");
        }
        x.e("MicroMsg.LocaleUtil", "transLanguageToLocale country = " + str);
        return Locale.ENGLISH;
    }

    public static void c(Configuration configuration) {
        if (VERSION.SDK_INT >= 24 && configuration != null) {
            Locale.setDefault(configuration.locale);
            sGk = Locale.getDefault();
            x.i("MicroMsg.LocaleUtil", "current locale:%s", sGk);
        }
    }

    public static String chO() {
        return Locale.getDefault().getCountry().trim();
    }

    private static String Wm(String str) {
        String trim = Locale.getDefault().getLanguage().trim();
        String str2 = trim + "_" + Locale.getDefault().getCountry().trim();
        if (trim.equals("en")) {
            return trim;
        }
        if (str2.equals("zh_TW")) {
            return "zh_TW";
        }
        if (str2.equals("zh_HK")) {
            return "zh_HK";
        }
        if (str2.equals("zh_CN")) {
            return "zh_CN";
        }
        if (trim.equals("th")) {
            return "th";
        }
        if (trim.equals("id")) {
            return "id";
        }
        if (str2.equals("in_ID")) {
            return "id";
        }
        if (trim.equals("vi")) {
            return "vi";
        }
        if (trim.equals("pt")) {
            return "pt";
        }
        if (trim.equals("es")) {
            return "es";
        }
        if (trim.equals("ru")) {
            return "ru";
        }
        if (trim.equals("ar")) {
            return "ar";
        }
        if (trim.equals("ja")) {
            return "ja";
        }
        if (trim.equals("it")) {
            return "it";
        }
        if (trim.equals("ko")) {
            return "ko";
        }
        if (trim.equals("ms")) {
            return "ms";
        }
        if (trim.equals("tr")) {
            return "tr";
        }
        if (trim.equals("de")) {
            return "de";
        }
        if (trim.equals("fr")) {
            return "fr";
        }
        if (trim.equals("my")) {
            return "my";
        }
        if (trim.equals("lo")) {
            return "lo";
        }
        return str;
    }

    public static String chP() {
        String oV = bi.oV(be.getProperty("language_key"));
        return (oV.length() <= 0 || oV.equals("language_default")) ? Wm("en") : oV;
    }

    public static String d(SharedPreferences sharedPreferences) {
        String oV = bi.oV(sharedPreferences.getString("language_key", null));
        if (oV.length() <= 0 || oV.equals("language_default")) {
            oV = Wm("en");
            be.setProperty("language_key", oV);
            return oV;
        }
        be.setProperty("language_key", oV);
        return oV;
    }

    public static String e(SharedPreferences sharedPreferences) {
        String oV = bi.oV(sharedPreferences.getString("language_key", null));
        return !bi.oW(oV) ? oV : "language_default";
    }

    public static void a(SharedPreferences sharedPreferences, String str) {
        if (sharedPreferences.edit().putString("language_key", str).commit()) {
            be.setProperty("language_key", str);
            x.w("MicroMsg.LocaleUtil", "save application lang as:" + str);
            return;
        }
        x.e("MicroMsg.LocaleUtil", "saving application lang failed");
    }

    public static String fD(Context context) {
        String e = e(context.getSharedPreferences(ad.chY(), 0));
        return e.equalsIgnoreCase("language_default") ? chP() : e;
    }

    public static String h(Context context, int i, int i2) {
        String[] stringArray = context.getResources().getStringArray(i);
        String e = e(context.getSharedPreferences(ad.chY(), 0));
        if (e == null) {
            return context.getString(i2);
        }
        String[] strArr = v.mSn;
        int length = strArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            if (strArr[i3].equals(e)) {
                return stringArray[i4];
            }
            i3++;
            i4++;
        }
        return context.getString(i2);
    }

    public static Locale initLanguage(Context context) {
        String d = d(context.getSharedPreferences(ad.chY(), 0));
        if (d.equals("language_default")) {
            a(context, Locale.ENGLISH);
            return Locale.getDefault();
        }
        Locale Wl = Wl(d);
        a(context, Wl);
        return Wl;
    }
}
