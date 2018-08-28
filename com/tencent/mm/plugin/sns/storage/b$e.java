package com.tencent.mm.plugin.sns.storage;

import java.util.ArrayList;

public class b$e {
    final /* synthetic */ b nzD;
    public String nzF = "";
    public ArrayList<b$f> nzG = new ArrayList();

    public b$e(b bVar) {
        this.nzD = bVar;
    }

    public final String wJ(int i) {
        if (i < 0 || i >= this.nzG.size()) {
            return "";
        }
        return ((b$f) this.nzG.get(i)).nzJ;
    }

    public final String wK(int i) {
        if (i < 0 || i >= this.nzG.size()) {
            return "";
        }
        return ((b$f) this.nzG.get(i)).title;
    }
}
