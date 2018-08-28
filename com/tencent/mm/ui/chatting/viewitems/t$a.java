package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

class t$a implements Comparable<t$a> {
    public boolean caQ;
    public int color;
    public int fTC;
    public int offset;
    public boolean ucJ;
    public String ucK;

    private t$a() {
    }

    public final /* synthetic */ int compareTo(Object obj) {
        t$a t_a = (t$a) obj;
        if (t_a != null) {
            return this.offset - t_a.offset;
        }
        x.e("MicroMsg.LineNode", "compareTo fail, should not be null");
        return 1;
    }

    public static t$a w(Map<String, String> map, String str) {
        t$a t_a = new t$a();
        try {
            t_a.offset = bi.getInt((String) map.get(str + ".offset"), 0);
            String str2 = (String) map.get(str + ".font");
            if (bi.oW(str2)) {
                x.d("MicroMsg.LineNode", "parseFrom, font is null, use default value");
                str2 = "m";
            } else {
                str2 = str2.toLowerCase();
            }
            t_a.caQ = t.BD(str2);
            t_a.ucJ = t.qF(str2);
            t_a.fTC = t.aaF(str2);
            t_a.color = t.aaG((String) map.get(str + ".color"));
            t_a.ucK = (String) map.get(str + ".chars");
            if (!bi.oW(t_a.ucK)) {
                return t_a;
            }
            x.e("MicroMsg.LineNode", "parseFrom fail, chars is null");
            return null;
        } catch (Exception e) {
            x.e("MicroMsg.LineNode", "parseFrom fail, ex = " + e.getMessage());
            return null;
        }
    }
}
