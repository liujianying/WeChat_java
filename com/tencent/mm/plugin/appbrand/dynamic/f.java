package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class f {
    private static f fuH = new f();
    Map<String, b> fuI = new ConcurrentHashMap();
    a fuJ = new 1(this);

    public static f aeS() {
        return fuH;
    }

    public final boolean ax(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.fuI.containsKey(str)) {
            return ((b) this.fuI.get(str)).fuM.add(Integer.valueOf(i));
        }
        x.w("MicroMsg.DynamicPageViewStateMonitor", "no keyList exists, widgetId[%s]", new Object[]{str});
        return false;
    }

    public static void sw(String str) {
        Parcelable bundle = new Bundle();
        String sx = sx(str);
        bundle.putString("id", sx);
        bundle.putInt("widgetState", 2109);
        com.tencent.mm.ipcinvoker.f.a(i.aeT().sz(sx), bundle, a.class, null);
    }

    public static void f(int i, String str, String str2) {
        Parcelable bundle = new Bundle();
        bundle.putBoolean("isOpenWeappFial", true);
        bundle.putInt("widgetState", i);
        bundle.putString("appid", str);
        bundle.putString("sceneNote", str2);
        com.tencent.mm.ipcinvoker.f.a(i.aeT().sz(sx(str2)), bundle, a.class, null);
    }

    private static String sx(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Matcher matcher = Pattern.compile(":widgetId=.*:").matcher(str);
        if (matcher.matches()) {
            String group = matcher.group();
            if (!TextUtils.isEmpty(group)) {
                return group.substring(group.indexOf("=") + 1, group.lastIndexOf(":"));
            }
        }
        return "";
    }
}
