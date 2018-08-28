package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class sy {
    private static sy b = null;
    private SharedPreferences a;

    private sy() {
    }

    public static sy a() {
        if (b == null) {
            synchronized (sy.class) {
                b = new sy();
            }
        }
        return b;
    }

    public final String a(String str) {
        return this.a == null ? null : this.a.getString(str, null);
    }

    public final void a(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext.getSharedPreferences(applicationContext.getPackageName(), 0);
    }

    public final boolean a(String str, int i) {
        return this.a == null ? false : this.a.edit().putInt(str, i).commit();
    }

    public final boolean a(String str, String str2) {
        return this.a == null ? false : this.a.edit().putString(str, str2).commit();
    }

    public final boolean a(String str, boolean z) {
        return this.a == null ? false : this.a.edit().putBoolean(str, z).commit();
    }

    public final boolean a(String[] strArr) {
        int i = 0;
        if (this.a == null) {
            return false;
        }
        Editor edit = this.a.edit();
        int length = strArr.length;
        while (i < length) {
            edit.remove(strArr[i]);
            i++;
        }
        return edit.commit();
    }

    public final int b(String str) {
        return this.a == null ? -1 : this.a.getInt(str, -1);
    }

    public final boolean c(String str) {
        return this.a == null ? false : this.a.getBoolean(str, false);
    }
}
