package com.tencent.mm.plugin.base.stub;

import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.tencent.mm.plugin.base.stub.MMPluginProvider.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

public final class c extends a {
    private static final Map<String, Object> hdD;

    static {
        Map hashMap = new HashMap();
        hdD = hashMap;
        hashMap.put("_build_info_sdk_int_", Integer.valueOf(620823808));
        hdD.put("_build_info_sdk_name_", "android 5.1.5");
        hdD.put("_wxapp_pay_entry_classname_", "com.tencent.mm.plugin.base.stub.WXPayEntryActivity");
    }

    public final boolean cR(Context context) {
        super.cR(context);
        return true;
    }

    public static Uri atu() {
        return null;
    }

    public static int atv() {
        return 0;
    }

    public static int atw() {
        return 0;
    }

    public static Cursor a(String[] strArr, String[] strArr2) {
        String str = strArr2[0];
        Object obj = hdD.get(str);
        if (obj == null) {
            x.w("MicroMsg.MMPluginProviderSharedPrefImpl", "not found value for key: " + str);
            return null;
        }
        int i;
        if (obj == null) {
            x.e("MicroMsg.SDK.PluginProvider.Resolver", "unresolve failed, null value");
            i = 0;
        } else if (obj instanceof Integer) {
            i = 1;
        } else if (obj instanceof Long) {
            i = 2;
        } else if (obj instanceof String) {
            i = 3;
        } else if (obj instanceof Boolean) {
            i = 4;
        } else if (obj instanceof Float) {
            i = 5;
        } else if (obj instanceof Double) {
            i = 6;
        } else {
            x.e("MicroMsg.SDK.PluginProvider.Resolver", "unresolve failed, unknown type=" + obj.getClass().toString());
            i = 0;
        }
        MatrixCursor matrixCursor = new MatrixCursor(strArr);
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(0);
        objArr[1] = str;
        objArr[2] = Integer.valueOf(i);
        objArr[3] = obj == null ? null : obj.toString();
        matrixCursor.addRow(objArr);
        return matrixCursor;
    }
}
