package com.tencent.mm.sdk.platformtools;

import android.content.Intent;
import android.os.Bundle;

public final class s {
    public static int a(Intent intent, String str, int i) {
        if (intent == null) {
            return i;
        }
        try {
            return intent.getIntExtra(str, i);
        } catch (Exception e) {
            x.e("MicroMsg.IntentUtil", "getIntExtra exception:%s", e.getMessage());
            return i;
        }
    }

    public static int h(Bundle bundle, String str) {
        int i = 0;
        if (bundle == null) {
            return i;
        }
        try {
            return bundle.getInt(str, 0);
        } catch (Exception e) {
            x.e("MicroMsg.IntentUtil", "getIntExtra exception:%s", e.getMessage());
            return i;
        }
    }

    public static long i(Intent intent, String str) {
        long j = 0;
        if (intent == null) {
            return j;
        }
        try {
            return intent.getLongExtra(str, 0);
        } catch (Exception e) {
            x.e("MicroMsg.IntentUtil", "getIntExtra exception:%s", e.getMessage());
            return j;
        }
    }

    public static Bundle aq(Intent intent) {
        Bundle bundle = null;
        if (intent == null) {
            return bundle;
        }
        try {
            return intent.getExtras();
        } catch (Exception e) {
            x.e("MicroMsg.IntentUtil", "getExtras exception:%s", e.getMessage());
            return bundle;
        }
    }

    public static boolean a(Intent intent, String str, boolean z) {
        if (intent == null) {
            return z;
        }
        try {
            return intent.getBooleanExtra(str, z);
        } catch (Exception e) {
            x.e("MicroMsg.IntentUtil", "getBooleanExtra exception:%s", e.getMessage());
            return z;
        }
    }

    public static String j(Intent intent, String str) {
        String str2 = null;
        if (intent == null) {
            return str2;
        }
        try {
            return intent.getStringExtra(str);
        } catch (Exception e) {
            x.e("MicroMsg.IntentUtil", "getStringExtra exception:%s", e.getMessage());
            return str2;
        }
    }

    public static String i(Bundle bundle, String str) {
        String str2 = null;
        if (bundle == null) {
            return str2;
        }
        try {
            return bundle.getString(str);
        } catch (Exception e) {
            x.e("MicroMsg.IntentUtil", "getStringExtra exception:%s", e.getMessage());
            return str2;
        }
    }

    public static byte[] k(Intent intent, String str) {
        byte[] bArr = null;
        if (intent == null) {
            return bArr;
        }
        try {
            return intent.getByteArrayExtra(str);
        } catch (Exception e) {
            x.e("MicroMsg.IntentUtil", "getByteArrayExtra exception:%s", e.getMessage());
            return bArr;
        }
    }

    public static void b(Intent intent, String str, boolean z) {
        try {
            intent.putExtra(str, z);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.IntentUtil", e, "", new Object[0]);
        }
    }
}
