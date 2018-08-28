package com.tencent.mm.plugin.clean.c;

import java.util.ArrayList;
import java.util.Iterator;

public final class b implements Comparable<b> {
    public long gTK;
    public ArrayList<a> hQM;
    public String username;

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        b bVar = (b) obj;
        if (this.gTK < bVar.gTK) {
            return -1;
        }
        return this.gTK > bVar.gTK ? 1 : 0;
    }

    public final boolean aAY() {
        this.gTK = 0;
        Iterator it = this.hQM.iterator();
        while (it.hasNext()) {
            this.gTK += ((a) it.next()).size;
        }
        if (this.hQM.size() == 0) {
            return false;
        }
        return true;
    }
}
