package com.tencent.mm.plugin.fts.a;

import com.tencent.mm.plugin.fts.a.b.b;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.HashMap;

public final class g {
    public static HashMap<String, String> eww = new HashMap();
    public static final a jqS = new a(19968, 40869);
    public static final a jqT = new a(40870, 40907);
    public static final a jqU = new a(13312, 19893);
    public static final a jqV = new a(131072, 173782);
    public static final a jqW = new a(173824, 177972);
    public static final a jqX = new a(177984, 178205);
    public static final a jqY = new a(12032, 12245);
    public static final a jqZ = new a(63744, 64217);
    public static final a jra = new a(194560, 195101);
    public static final a jrb = new a(59413, 59503);
    public static final a jrc = new a(58368, 58856);
    public static final a jrd = new a(58880, 59087);
    public static final a jre = new a(12736, 12771);
    public static final a jrf = new a(12272, 12283);
    public static final a jrg = new a(12549, 12576);
    public static final a jrh = new a(12704, 12730);
    public static final a jri = new a(65, 90);
    public static final a jrj = new a(97, 122);
    public static final a jrk = new a(48, 57);
    public static b jrl = new b();
    public static HashMap<String, String[]> jrm = new HashMap();

    public static boolean i(char c) {
        return jqS.l(c) || jqT.l(c) || jqU.l(c) || jqV.l(c) || jqW.l(c) || jqX.l(c);
    }

    public static boolean j(char c) {
        return jri.l(c) || jrj.l(c);
    }

    public static boolean k(char c) {
        return jrk.l(c);
    }

    public static final String Cz(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (char c : str.toCharArray()) {
            if (i(c)) {
                String str2 = (String) eww.get(String.valueOf(c));
                if (!bi.oW(str2)) {
                    stringBuffer.append(str2);
                }
            }
            stringBuffer.append(c);
        }
        return stringBuffer.toString();
    }
}
