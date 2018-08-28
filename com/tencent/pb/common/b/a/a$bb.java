package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;
import com.tencent.pb.common.b.a.a.av;

public final class a$bb extends e {
    public String groupId;
    public int oLB;
    public long oLC;
    public int vcN;
    public av[] vea;
    public int vfY;
    public String vfZ;
    public String vfp;
    public String[] vga;
    public long vgb;

    public a$bb() {
        this.groupId = "";
        this.oLB = 0;
        this.oLC = 0;
        this.vcN = 0;
        this.vfY = 0;
        this.vfp = "";
        this.vea = av.cEA();
        this.vfZ = "";
        this.vga = g.EMPTY_STRING_ARRAY;
        this.vgb = 0;
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
        if (this.vcN != 0) {
            bVar.aF(4, this.vcN);
        }
        if (this.vfY != 0) {
            bVar.aE(5, this.vfY);
        }
        if (!this.vfp.equals("")) {
            bVar.g(6, this.vfp);
        }
        if (this.vea != null && this.vea.length > 0) {
            for (e eVar : this.vea) {
                if (eVar != null) {
                    bVar.a(7, eVar);
                }
            }
        }
        if (!this.vfZ.equals("")) {
            bVar.g(8, this.vfZ);
        }
        if (this.vga != null && this.vga.length > 0) {
            while (i < this.vga.length) {
                String str = this.vga[i];
                if (str != null) {
                    bVar.g(9, str);
                }
                i++;
            }
        }
        if (this.vgb != 0) {
            bVar.i(10, this.vgb);
        }
        super.a(bVar);
    }

    protected final int sl() {
        int i;
        int i2;
        int i3 = 0;
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
        if (this.vcN != 0) {
            sl += b.aH(4, this.vcN);
        }
        if (this.vfY != 0) {
            sl += b.aG(5, this.vfY);
        }
        if (!this.vfp.equals("")) {
            sl += b.h(6, this.vfp);
        }
        if (this.vea != null && this.vea.length > 0) {
            i = 0;
            while (true) {
                i2 = sl;
                if (i >= this.vea.length) {
                    break;
                }
                e eVar = this.vea[i];
                if (eVar != null) {
                    i2 += b.b(7, eVar);
                }
                sl = i + 1;
            }
            sl = i2;
        }
        if (!this.vfZ.equals("")) {
            sl += b.h(8, this.vfZ);
        }
        if (this.vga != null && this.vga.length > 0) {
            int i4;
            i = 0;
            i2 = 0;
            while (true) {
                i4 = i3;
                if (i >= this.vga.length) {
                    break;
                }
                String str = this.vga[i];
                if (str != null) {
                    i4++;
                    i2 += b.bE(str);
                }
                i3 = i + 1;
            }
            sl = (sl + i2) + (i4 * 1);
        }
        if (this.vgb != 0) {
            return sl + b.k(10, this.vgb);
        }
        return sl;
    }
}
