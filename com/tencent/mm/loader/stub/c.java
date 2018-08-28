package com.tencent.mm.loader.stub;

import android.content.SharedPreferences;
import com.tencent.mm.sdk.platformtools.ad;

public class c {
    public static c duQ = new c(null);
    public final SharedPreferences duR;

    public c(SharedPreferences sharedPreferences) {
        if (sharedPreferences == null) {
            this.duR = ad.getContext().getSharedPreferences(ad.chY(), 0);
        } else {
            this.duR = sharedPreferences;
        }
    }

    public final String I(String str, String str2) {
        return this.duR.getString(str, str2);
    }
}
