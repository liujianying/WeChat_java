package com.google.android.gms.analytics.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.w;
import com.tencent.map.lib.gl.model.GLIcon;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class c {
    final Map<String, String> aFa;
    final List<Command> aFb;
    final long aFc;
    final long aFd;
    final int aFe;
    final boolean aFf;
    private final String aFg;

    public c(n nVar, Map<String, String> map, long j) {
        this(nVar, map, j, true, 0, 0, null);
    }

    public c(n nVar, Map<String, String> map, long j, boolean z, long j2, int i) {
        this(nVar, map, j, z, j2, i, null);
    }

    public c(n nVar, Map<String, String> map, long j, boolean z, long j2, int i, List<Command> list) {
        String a;
        w.ah(nVar);
        w.ah(map);
        this.aFd = j;
        this.aFf = z;
        this.aFc = j2;
        this.aFe = i;
        this.aFb = list != null ? list : Collections.EMPTY_LIST;
        this.aFg = r(list);
        Map hashMap = new HashMap();
        for (Entry entry : map.entrySet()) {
            if (aa(entry.getKey())) {
                a = a(nVar, entry.getKey());
                if (a != null) {
                    hashMap.put(a, b(nVar, entry.getValue()));
                }
            }
        }
        for (Entry entry2 : map.entrySet()) {
            if (!aa(entry2.getKey())) {
                a = a(nVar, entry2.getKey());
                if (a != null) {
                    hashMap.put(a, b(nVar, entry2.getValue()));
                }
            }
        }
        if (!TextUtils.isEmpty(this.aFg)) {
            k.a(hashMap, "_v", this.aFg);
            if (this.aFg.equals("ma4.0.0") || this.aFg.equals("ma4.0.1")) {
                hashMap.remove("adid");
            }
        }
        this.aFa = Collections.unmodifiableMap(hashMap);
    }

    private static String a(n nVar, Object obj) {
        if (obj == null) {
            return null;
        }
        Object obj2 = obj.toString();
        if (obj2.startsWith("&")) {
            obj2 = obj2.substring(1);
        }
        int length = obj2.length();
        if (length > GLIcon.TOP) {
            obj2 = obj2.substring(0, GLIcon.TOP);
            nVar.c("Hit param name is too long and will be trimmed", Integer.valueOf(length), obj2);
        }
        return TextUtils.isEmpty(obj2) ? null : obj2;
    }

    private static boolean aa(Object obj) {
        return obj == null ? false : obj.toString().startsWith("&");
    }

    private static String b(n nVar, Object obj) {
        String obj2 = obj == null ? "" : obj.toString();
        int length = obj2.length();
        if (length <= 8192) {
            return obj2;
        }
        obj2 = obj2.substring(0, 8192);
        nVar.c("Hit param value is too long and will be trimmed", Integer.valueOf(length), obj2);
        return obj2;
    }

    private static String r(List<Command> list) {
        CharSequence charSequence;
        if (list != null) {
            for (Command command : list) {
                if ("appendVersion".equals(command.aEN)) {
                    charSequence = command.mValue;
                    break;
                }
            }
        }
        charSequence = null;
        return TextUtils.isEmpty(charSequence) ? null : charSequence;
    }

    final String l(String str, String str2) {
        w.bg(str);
        w.e(!str.startsWith("&"), "Short param name required");
        String str3 = (String) this.aFa.get(str);
        return str3 != null ? str3 : str2;
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ht=").append(this.aFd);
        if (this.aFc != 0) {
            stringBuffer.append(", dbId=").append(this.aFc);
        }
        if (((long) this.aFe) != 0) {
            stringBuffer.append(", appUID=").append(this.aFe);
        }
        List<String> arrayList = new ArrayList(this.aFa.keySet());
        Collections.sort(arrayList);
        for (String str : arrayList) {
            stringBuffer.append(", ");
            stringBuffer.append(str);
            stringBuffer.append("=");
            stringBuffer.append((String) this.aFa.get(str));
        }
        return stringBuffer.toString();
    }
}
