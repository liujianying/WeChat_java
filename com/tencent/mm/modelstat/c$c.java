package com.tencent.mm.modelstat;

import android.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;

class c$c {
    long eiD;
    float eiE;
    int eiF;
    String eiG;
    ArrayList<Pair<String, Boolean>> eiH;
    ArrayList<Pair<String, String>> eiI;
    int id;
    String name;

    private c$c() {
        this.eiH = new ArrayList();
        this.eiI = new ArrayList();
    }

    /* synthetic */ c$c(byte b) {
        this();
    }

    public final String toString() {
        Pair pair;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ReportConfigEvent{");
        stringBuilder.append("id=" + this.id);
        stringBuilder.append(", name='" + this.name + "'");
        stringBuilder.append(", expireTime=" + this.eiD);
        stringBuilder.append(", rate=" + this.eiE);
        stringBuilder.append(", logId=" + this.eiF);
        stringBuilder.append(", pagesType='" + this.eiG + "'");
        stringBuilder.append(", pageList=[");
        Iterator it = this.eiH.iterator();
        while (it.hasNext()) {
            pair = (Pair) it.next();
            stringBuilder.append("{" + ((String) pair.first) + "," + pair.second + "}");
            stringBuilder.append(",");
        }
        stringBuilder.append("]");
        stringBuilder.append(", specialPVPages=[");
        it = this.eiI.iterator();
        while (it.hasNext()) {
            pair = (Pair) it.next();
            stringBuilder.append("{" + ((String) pair.first) + "," + ((String) pair.second) + "}");
            stringBuilder.append(",");
        }
        stringBuilder.append("]}");
        return stringBuilder.toString();
    }
}
