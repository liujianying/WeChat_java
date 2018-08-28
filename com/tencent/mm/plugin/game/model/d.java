package com.tencent.mm.plugin.game.model;

import com.tencent.mm.plugin.game.d.bw;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.LinkedList;

public final class d extends f {
    public String bHF = "";
    public int bPG = 0;
    public int bYq = 0;
    public int dPU = 0;
    public String fmD = "";
    public String jLb = "";
    public String jLc = "";
    public String jLd = "#929292";
    public String jLe = "";
    public String jLf = "";
    public boolean jLg = false;
    public String jLh = "";
    public String jLi = "";
    public String jLj = "";
    public LinkedList<String> jLk = new LinkedList();
    public String jLl = "";
    public LinkedList<String> jLm = new LinkedList();
    public boolean jLn = false;
    public boolean jLo = false;
    public String jLp = "";
    public String jLq = "#fca28a";
    public String jLr = "";
    public String jLs = "#222222";
    public String jLt = "";
    public boolean jLu = false;
    public String jLv = "";
    public long jLw = 0;
    public bw jLx;
    public String name = "";
    public int position = 1;
    public int scene = 0;
    public int status = 0;
    public int type = 0;
    public int versionCode = 0;

    public final boolean aTx() {
        return ((this.dPU != 1 && this.dPU != 2) || this.jLx == null || bi.oW(this.jLx.jSu)) ? false : true;
    }
}
