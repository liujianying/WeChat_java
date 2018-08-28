package com.tencent.mm.plugin.sns.f;

import com.tencent.mm.plugin.sns.f.d.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class f {
    public static final Pattern nuG = Pattern.compile("\\{([\\s\\S]*?)\\}");
    public static String[] nuH = new String[]{"{sex", "{username", "{richtext"};
    public static HashMap<String, a> nuI = new HashMap();

    public static String a(a aVar) {
        if (!nuI.containsKey(aVar.nuD)) {
            Object obj = aVar.nuD;
            if (bi.oW(obj)) {
                return aVar.nuC;
            }
            Object obj2;
            do {
                Matcher matcher = nuG.matcher(obj);
                if (matcher.find()) {
                    int groupCount = matcher.groupCount();
                    Object group = matcher.group();
                    x.i("MicroMsg.SnsAbTestUtil", "hello matcher group() " + groupCount + " " + group);
                    obj = obj.replace(group, "");
                    for (String indexOf : nuH) {
                        if (group.indexOf(indexOf) >= 0) {
                            obj2 = 1;
                            continue;
                            break;
                        }
                    }
                    obj2 = null;
                    continue;
                } else {
                    nuI.put(aVar.nuD, a.nuJ);
                    return aVar.nuD;
                }
            } while (obj2 != null);
            nuI.put(aVar.nuD, a.nuK);
            return aVar.nuC;
        } else if (((a) nuI.get(aVar.nuD)) == a.nuJ) {
            return aVar.nuD;
        } else {
            return aVar.nuC;
        }
    }
}
