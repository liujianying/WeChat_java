package com.tencent.mm.plugin.music.model;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.LinkedList;

public final class a {
    public String album;
    public String fHZ;
    private int iQP = 0;
    public ArrayList<a> lxL = new ArrayList();
    public LinkedList<Long> lxM = new LinkedList();
    public String lxN;
    public String lxO;
    public String lxP;
    private boolean lxQ = false;
    public long mb;
    public String title;

    public static String dT(String str, String str2) {
        if (bi.oW(str) || bi.oW(str2)) {
            return str;
        }
        if (str2.length() >= str.length() - 1) {
            return "";
        }
        x.d("MicroMsg.Music.LyricObj", "str[%s] prefix[%s] attr[%s]", new Object[]{str, str2, str.substring(str2.length(), str.length() - 1)});
        return str.substring(str2.length(), str.length() - 1);
    }

    public static long Ir(String str) {
        try {
            int cH;
            int cH2;
            String[] split = str.split(":");
            int cH3 = g.cH(split[0]);
            if (split.length > 1) {
                split = split[1].split("\\.");
                cH = g.cH(split[0]);
                cH2 = split.length > 1 ? g.cH(split[1]) : 0;
            } else {
                cH2 = 0;
                cH = 0;
            }
            return ((long) (cH2 * 10)) + (((long) (cH * 1000)) + ((((long) cH3) * 60) * 1000));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Music.LyricObj", e, "", new Object[0]);
            x.w("MicroMsg.Music.LyricObj", "strToLong error: %s", new Object[]{e.getLocalizedMessage()});
            return 0;
        }
    }

    public final a tx(int i) {
        if (i < 0 || i >= this.lxL.size()) {
            return null;
        }
        return (a) this.lxL.get(i);
    }
}
