package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.plugin.game.ui.r.c;
import com.tencent.mm.protocal.c.yd;
import com.tencent.mm.protocal.c.ye;
import java.util.LinkedList;

public class r$b {
    public int actionType;
    public String appId;
    public String bHt;
    public long createTime;
    public String dCS;
    public String fky;
    public String iconUrl;
    public String kcb;
    public ye kcc;
    public String kcd;
    public LinkedList<String> kce;
    public int kcf;
    public int kcg;
    public boolean kch = false;
    public boolean kci = false;
    public c kcj;
    public String name;
    public int type;

    public static r$b ap(int i, String str) {
        r$b r_b = new r$b();
        r_b.type = i;
        r_b.name = str;
        r_b.kcj = new c();
        return r_b;
    }

    public static r$b a(yd ydVar) {
        r$b r_b = new r$b();
        r_b.type = 2;
        r_b.name = ydVar.bHD;
        r_b.fky = ydVar.jOS;
        r_b.iconUrl = ydVar.lPl;
        r_b.kcd = ydVar.rDG;
        r_b.kcf = ydVar.rEb;
        r_b.kcg = ydVar.rEc;
        r_b.appId = ydVar.jQb;
        r_b.dCS = ydVar.jSv;
        r_b.createTime = (long) ydVar.create_time;
        r_b.kcj = new c(ydVar.rDG, (byte) 0);
        return r_b;
    }
}
