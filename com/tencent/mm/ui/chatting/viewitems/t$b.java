package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

class t$b {
    public boolean caQ;
    public int color;
    public int fTC;
    public boolean ucJ;
    public int ucL;
    public int ucM;

    private t$b() {
    }

    public static t$b x(Map<String, String> map, String str) {
        String str2 = (String) map.get(str + ".range");
        if (bi.oW(str2)) {
            x.e("MicroMsg.StyleNode", "parseFrom fail, range is null");
            return null;
        } else if (str2.length() >= 5 && str2.charAt(0) == '{' && str2.charAt(str2.length() - 1) == '}' && str2.contains(",")) {
            x.d("MicroMsg.StyleNode", "parseFrom, range = " + str2);
            String[] split = str2.substring(1, str2.length() - 1).split(",");
            if (split == null || split.length != 2) {
                x.e("MicroMsg.StyleNode", "parseFrom fail, range wrong format, strs array length = " + split.length);
                return null;
            }
            t$b t_b = new t$b();
            try {
                t_b.ucL = bi.getInt(split[0], 0);
                t_b.ucM = bi.getInt(split[1], 0) + t_b.ucL;
                str2 = (String) map.get(str + ".font");
                if (bi.oW(str2)) {
                    x.d("MicroMsg.StyleNode", "parseFrom, font is null, use default value");
                    str2 = "m";
                } else {
                    str2 = str2.toLowerCase();
                }
                t_b.caQ = t.BD(str2);
                t_b.ucJ = t.qF(str2);
                t_b.fTC = t.aaF(str2);
                t_b.color = t.aaG((String) map.get(str + ".color"));
                return t_b;
            } catch (Exception e) {
                x.e("MicroMsg.StyleNode", "parseFrom fail, ex = " + e.getMessage());
                return null;
            }
        } else {
            x.e("MicroMsg.StyleNode", "parseFrom fail, range wrong format, range = " + str2);
            return null;
        }
    }
}
