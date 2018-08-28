package com.tencent.mm.bo;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.ad;

public class a$b {
    public static boolean CT(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("key", i);
        return ad.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/userinfo/"), "ConfigStorage.getBoolean", null, bundle).getBoolean("key", false);
    }

    public static String aX(int i, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("key", i);
        return ad.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/userinfo/"), "ConfigStorage.getString", null, bundle).getString("key", str);
    }

    public static void VP(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("type", Integer.valueOf(-29414086));
        contentValues.put("value", str);
        ad.getContext().getContentResolver().update(Uri.parse("content://com.tencent.mm.storage.provider.emotion/userinfo/"), contentValues, null, null);
    }
}
