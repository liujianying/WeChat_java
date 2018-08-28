package com.tencent.tinker.a.a;

import com.tencent.mm.plugin.appbrand.s$l;
import com.tencent.tinker.a.a.b.a;
import com.tencent.tinker.a.a.k.1;

public final class m {
    private int type;
    protected final a vpb;
    public int vpc;
    private int vpd;

    public m(a aVar, int i) {
        this.type = -1;
        this.vpb = aVar;
        this.type = i;
    }

    public m(k kVar, int i) {
        this(new 1(kVar), i);
    }

    public final int cGC() {
        if (this.type == -1) {
            int readByte = this.vpb.readByte() & 255;
            this.type = readByte & 31;
            this.vpd = (readByte & 224) >> 5;
        }
        return this.type;
    }

    public final int cGD() {
        Hw(28);
        this.type = -1;
        return o.b(this.vpb);
    }

    public final int cGE() {
        Hw(29);
        this.type = -1;
        this.vpc = o.b(this.vpb);
        return o.b(this.vpb);
    }

    public final int cGF() {
        return o.b(this.vpb);
    }

    public final byte readByte() {
        Hw(0);
        this.type = -1;
        return (byte) l.a(this.vpb, this.vpd);
    }

    public final short readShort() {
        Hw(2);
        this.type = -1;
        return (short) l.a(this.vpb, this.vpd);
    }

    public final char readChar() {
        Hw(3);
        this.type = -1;
        return (char) l.a(this.vpb, this.vpd, false);
    }

    public final int readInt() {
        Hw(4);
        this.type = -1;
        return l.a(this.vpb, this.vpd);
    }

    public final long readLong() {
        Hw(6);
        this.type = -1;
        a aVar = this.vpb;
        int i = this.vpd;
        long j = 0;
        for (int i2 = i; i2 >= 0; i2--) {
            j = (j >>> 8) | ((((long) aVar.readByte()) & 255) << 56);
        }
        return j >> ((7 - i) * 8);
    }

    public final float readFloat() {
        Hw(16);
        this.type = -1;
        return Float.intBitsToFloat(l.a(this.vpb, this.vpd, true));
    }

    public final double readDouble() {
        Hw(17);
        this.type = -1;
        a aVar = this.vpb;
        long j = 0;
        for (int i = this.vpd; i >= 0; i--) {
            j = (j >>> 8) | ((((long) aVar.readByte()) & 255) << 56);
        }
        return Double.longBitsToDouble(j);
    }

    public final int cGG() {
        Hw(23);
        this.type = -1;
        return l.a(this.vpb, this.vpd, false);
    }

    public final int cGH() {
        Hw(24);
        this.type = -1;
        return l.a(this.vpb, this.vpd, false);
    }

    public final int cGI() {
        Hw(25);
        this.type = -1;
        return l.a(this.vpb, this.vpd, false);
    }

    public final int cGJ() {
        Hw(27);
        this.type = -1;
        return l.a(this.vpb, this.vpd, false);
    }

    public final int cGK() {
        Hw(26);
        this.type = -1;
        return l.a(this.vpb, this.vpd, false);
    }

    public final void cGL() {
        Hw(30);
        this.type = -1;
    }

    public final boolean readBoolean() {
        Hw(31);
        this.type = -1;
        return this.vpd != 0;
    }

    public final void skipValue() {
        int i = 0;
        int cGD;
        switch (cGC()) {
            case 0:
                readByte();
                return;
            case 2:
                readShort();
                return;
            case 3:
                readChar();
                return;
            case 4:
                readInt();
                return;
            case 6:
                readLong();
                return;
            case 16:
                readFloat();
                return;
            case 17:
                readDouble();
                return;
            case 23:
                cGG();
                return;
            case 24:
                cGH();
                return;
            case 25:
                cGI();
                return;
            case 26:
                cGK();
                return;
            case 27:
                cGJ();
                return;
            case s$l.AppCompatTheme_actionModeCloseButtonStyle /*28*/:
                cGD = cGD();
                while (i < cGD) {
                    skipValue();
                    i++;
                }
                return;
            case s$l.AppCompatTheme_actionModeBackground /*29*/:
                cGD = cGE();
                while (i < cGD) {
                    o.b(this.vpb);
                    skipValue();
                    i++;
                }
                return;
            case s$l.AppCompatTheme_actionModeSplitBackground /*30*/:
                cGL();
                return;
            case s$l.AppCompatTheme_actionModeCloseDrawable /*31*/:
                readBoolean();
                return;
            default:
                throw new j("Unexpected type: " + Integer.toHexString(this.type));
        }
    }

    private void Hw(int i) {
        if (cGC() != i) {
            throw new IllegalStateException(String.format("Expected %x but was %x", new Object[]{Integer.valueOf(i), Integer.valueOf(cGC())}));
        }
    }
}
