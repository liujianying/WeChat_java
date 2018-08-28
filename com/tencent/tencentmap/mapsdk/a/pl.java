package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import com.tencent.map.lib.util.StringUtil;
import java.util.Map;

public class pl {
    public static void a(Context context) {
        try {
            da.a(false, false);
            da.b(jy.c());
            da.a("4.0.8");
            da.a(context);
            if (!StringUtil.isEmpty(kh.a)) {
                da.c(Integer.toString(kh.a.hashCode()));
            }
        } catch (Exception e) {
        } catch (Error e2) {
        }
    }

    public static void a() {
    }

    public static boolean a(String str, boolean z, long j, long j2, Map<String, String> map, boolean z2) {
        try {
            return da.a(str, z, j, j2, map, z2);
        } catch (Exception e) {
        } catch (Error e2) {
        }
        return false;
    }
}
