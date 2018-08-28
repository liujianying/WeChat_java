package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;

public final class a$a extends e {
    public String groupId;
    public int oLB;
    public long oLC;
    public int[] vcF;
    public int vcG;
    public String[] vcH;

    public a$a() {
        this.groupId = "";
        this.oLB = 0;
        this.oLC = 0;
        this.vcF = g.bfQ;
        this.vcG = 0;
        this.vcH = g.EMPTY_STRING_ARRAY;
        this.bfP = -1;
    }

    public final void a(b bVar) {
        int i = 0;
        if (!this.groupId.equals("")) {
            bVar.g(1, this.groupId);
        }
        if (this.oLB != 0) {
            bVar.aE(2, this.oLB);
        }
        if (this.oLC != 0) {
            bVar.j(3, this.oLC);
        }
        if (this.vcF != null && this.vcF.length > 0) {
            for (int aF : this.vcF) {
                bVar.aF(4, aF);
            }
        }
        if (this.vcG != 0) {
            bVar.aE(5, this.vcG);
        }
        if (this.vcH != null && this.vcH.length > 0) {
            while (i < this.vcH.length) {
                String str = this.vcH[i];
                if (str != null) {
                    bVar.g(100, str);
                }
                i++;
            }
        }
        super.a(bVar);
    }

    protected final int sl() {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        int sl = super.sl();
        if (!this.groupId.equals("")) {
            sl += b.h(1, this.groupId);
        }
        if (this.oLB != 0) {
            sl += b.aG(2, this.oLB);
        }
        if (this.oLC != 0) {
            sl += b.l(3, this.oLC);
        }
        if (this.vcF != null && this.vcF.length > 0) {
            i = 0;
            for (int i32 : this.vcF) {
                i += b.ee(i32);
            }
            sl = (sl + i) + (this.vcF.length * 1);
        }
        if (this.vcG != 0) {
            sl += b.aG(5, this.vcG);
        }
        if (this.vcH == null || this.vcH.length <= 0) {
            return sl;
        }
        i2 = 0;
        i = 0;
        while (true) {
            i32 = i4;
            if (i2 >= this.vcH.length) {
                return (sl + i) + (i32 * 2);
            }
            String str = this.vcH[i2];
            if (str != null) {
                i32++;
                i += b.bE(str);
            }
            i4 = i2 + 1;
        }
    }
}
