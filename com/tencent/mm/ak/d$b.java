package com.tencent.mm.ak;

import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

class d$b {
    private int aeo = 0;
    public long dTD;
    public long dTE;
    public int dTF;
    public int dTG;
    public List<c> dTH;

    public d$b(long j, long j2, int i) {
        this.dTD = j;
        this.dTE = j2;
        this.dTF = i;
        this.dTG = 0;
    }

    public final boolean a(a aVar, Object obj) {
        if (this.dTH == null) {
            this.dTH = new LinkedList();
        }
        c cVar = new c(aVar, obj);
        if (this.dTH.contains(cVar)) {
            x.d("ModelImage.DownloadImgService.Task", "task item already exists");
            return false;
        }
        this.dTH.add(cVar);
        return true;
    }

    public final boolean b(a aVar) {
        c cVar = new c(aVar, null);
        if (!this.dTH.contains(cVar)) {
            return false;
        }
        this.dTH.remove(cVar);
        return true;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof d$b)) {
            return false;
        }
        d$b d_b = (d$b) obj;
        if (d_b.dTD == this.dTD && d_b.dTE == this.dTE && d_b.dTF == this.dTF) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        if (this.aeo == 0) {
            this.aeo = (this.dTD + "_" + this.dTE + "_" + this.dTF).hashCode();
        }
        return this.aeo;
    }
}
