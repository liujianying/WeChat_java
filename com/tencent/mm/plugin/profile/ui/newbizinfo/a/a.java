package com.tencent.mm.plugin.profile.ui.newbizinfo.a;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mm.sdk.platformtools.ad;

public final class a implements com.tencent.mm.pluginsdk.cmd.a {
    public final boolean a(Context context, String[] strArr) {
        if ("//usenewprofile".equals(strArr[0])) {
            SharedPreferences chZ = ad.chZ();
            if (strArr.length > 1) {
                String str = strArr[1];
                boolean z = true;
                switch (str.hashCode()) {
                    case 3569038:
                        if (str.equals("true")) {
                            z = false;
                            break;
                        }
                        break;
                    case 97196323:
                        if (str.equals("false")) {
                            z = true;
                            break;
                        }
                        break;
                }
                switch (z) {
                    case false:
                        chZ.edit().putBoolean("use_new_profile", true).commit();
                        break;
                    case true:
                        chZ.edit().putBoolean("use_new_profile", false).commit();
                        break;
                }
            }
            chZ.edit().putBoolean("use_new_profile", true).commit();
        }
        return true;
    }
}
