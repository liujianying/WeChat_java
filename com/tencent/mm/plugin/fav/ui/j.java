package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;

public final class j {
    public static String C(Context context, int i) {
        int i2 = i / 1000;
        if (i2 <= 0) {
            return context.getString(m$i.favorite_voice_length, new Object[]{Integer.valueOf(0)});
        }
        int i3 = i2 / 60;
        i2 %= 60;
        if (i3 == 0) {
            return context.getString(m$i.favorite_voice_length, new Object[]{Integer.valueOf(i2)});
        }
        return context.getString(m$i.favorite_video_length, new Object[]{Integer.valueOf(i3), Integer.valueOf(i2)});
    }

    public static boolean BC(String str) {
        if (bi.oW(str) || str.equals(ad.getContext().getResources().getString(m$i.location_sub_title_location_with_bracket))) {
            return false;
        }
        return true;
    }

    public static String D(Context context, int i) {
        return "[" + context.getResources().getString(i) + "]";
    }
}
