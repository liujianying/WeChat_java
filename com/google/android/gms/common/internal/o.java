package com.google.android.gms.common.internal;

import android.content.Intent;
import android.net.Uri;

public final class o {
    private static final Uri aOJ;
    private static final Uri aOK;

    static {
        Uri parse = Uri.parse("http://plus.google.com/");
        aOJ = parse;
        aOK = parse.buildUpon().appendPath("circles").appendPath("find").build();
    }

    public static Intent be(String str) {
        Uri fromParts = Uri.fromParts("package", str, null);
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(fromParts);
        return intent;
    }

    public static Intent bf(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("market://details").buildUpon().appendQueryParameter("id", str).build());
        intent.setPackage("com.android.vending");
        intent.addFlags(524288);
        return intent;
    }

    public static Intent pp() {
        Intent intent = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
        intent.setPackage("com.google.android.wearable.app");
        return intent;
    }
}
