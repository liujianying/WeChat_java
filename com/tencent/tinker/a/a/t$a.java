package com.tencent.tinker.a.a;

public class t$a implements Comparable<t$a> {
    public int off = -1;
    public int size = 0;
    public final short vpH;
    public boolean vpI;
    public int vpJ = 0;

    public final /* synthetic */ int compareTo(Object obj) {
        t$a t_a = (t$a) obj;
        if (this.off != t_a.off) {
            return this.off < t_a.off ? -1 : 1;
        } else {
            int Hx = Hx(this.vpH);
            int Hx2 = Hx(t_a.vpH);
            if (Hx != Hx2) {
                return Hx >= Hx2 ? 1 : -1;
            } else {
                return 0;
            }
        }
    }

    public t$a(int i, boolean z) {
        this.vpH = (short) i;
        this.vpI = z;
        if (i == 0) {
            this.off = 0;
            this.size = 1;
            this.vpJ = 112;
        } else if (i == 4096) {
            this.size = 1;
        }
    }

    public final boolean exists() {
        return this.size > 0;
    }

    private static int Hx(int i) {
        switch (i) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 6;
            case 4096:
                return 17;
            case 4097:
                return 8;
            case 4098:
                return 11;
            case 4099:
                return 10;
            case 8192:
                return 15;
            case 8193:
                return 14;
            case 8194:
                return 7;
            case 8195:
                return 13;
            case 8196:
                return 9;
            case 8197:
                return 16;
            case 8198:
                return 12;
            default:
                throw new IllegalArgumentException("unknown section type: " + i);
        }
    }

    public final String toString() {
        return String.format("Section[type=%#x,off=%#x,size=%#x]", new Object[]{Short.valueOf(this.vpH), Integer.valueOf(this.off), Integer.valueOf(this.size)});
    }
}
