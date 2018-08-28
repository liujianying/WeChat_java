package com.tencent.mm.plugin.freewifi.f;

import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.c.xm;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class b {
    private static volatile boolean jlI = true;
    static Pattern jlJ = Pattern.compile("\"result\":(-?[0-9]+)");
    static Pattern jlK = Pattern.compile("\"stageName\":\"(.+?)\"");

    public static void kB(int i) {
        j.aOO().aOv().post(new 1(i));
    }

    static String M(LinkedList<xm> linkedList) {
        if (linkedList == null || linkedList.size() == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            xm xmVar = (xm) it.next();
            stringBuilder.append("|id=").append(m.BR(xmVar.id)).append("|");
            for (CharSequence charSequence : m.BR(xmVar.rDq).split("\\},")) {
                Matcher matcher = jlK.matcher(charSequence);
                String str = "";
                if (matcher.find()) {
                    str = matcher.group(1);
                }
                matcher = jlJ.matcher(charSequence);
                String str2 = "0";
                if (matcher.find()) {
                    str2 = matcher.group(1);
                }
                stringBuilder.append(k.BP(str) + "=" + str2).append("|");
            }
        }
        return stringBuilder.toString();
    }
}
