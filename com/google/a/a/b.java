package com.google.a.a;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public final class b {
    private final byte[] buffer;
    final int limit;
    int position = 0;

    public static class a extends IOException {
        a(int i, int i2) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space (pos " + i + " limit " + i2 + ").");
        }
    }

    b(byte[] bArr, int i) {
        this.buffer = bArr;
        this.limit = i + 0;
    }

    public final void i(int i, long j) {
        aI(i, 0);
        ag(j);
    }

    public final void j(int i, long j) {
        aI(i, 0);
        ag(j);
    }

    public final void aE(int i, int i2) {
        aI(i, 0);
        if (i2 >= 0) {
            ed(i2);
        } else {
            ag((long) i2);
        }
    }

    public final void g(int i, String str) {
        aI(i, 2);
        byte[] bytes = str.getBytes("UTF-8");
        ed(bytes.length);
        p(bytes);
    }

    public final void a(int i, e eVar) {
        aI(i, 2);
        if (eVar.bfP < 0) {
            eVar.sk();
        }
        ed(eVar.bfP);
        eVar.a(this);
    }

    public final void b(int i, byte[] bArr) {
        aI(i, 2);
        ed(bArr.length);
        p(bArr);
    }

    public final void aF(int i, int i2) {
        aI(i, 0);
        ed(i2);
    }

    public static int k(int i, long j) {
        return ec(i) + ah(j);
    }

    public static int l(int i, long j) {
        return ec(i) + ah(j);
    }

    public static int aG(int i, int i2) {
        return ec(i) + ea(i2);
    }

    public static int h(int i, String str) {
        return ec(i) + bE(str);
    }

    public static int b(int i, e eVar) {
        int ec = ec(i);
        int sk = eVar.sk();
        return ec + (sk + ee(sk));
    }

    public static int c(int i, byte[] bArr) {
        return ec(i) + (ee(bArr.length) + bArr.length);
    }

    public static int aH(int i, int i2) {
        return ec(i) + ee(i2);
    }

    public static int ea(int i) {
        if (i >= 0) {
            return ee(i);
        }
        return 10;
    }

    public static int bE(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return bytes.length + ee(bytes.length);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported.");
        }
    }

    private void eb(int i) {
        byte b = (byte) i;
        if (this.position == this.limit) {
            throw new a(this.position, this.limit);
        }
        byte[] bArr = this.buffer;
        int i2 = this.position;
        this.position = i2 + 1;
        bArr[i2] = b;
    }

    private void p(byte[] bArr) {
        int length = bArr.length;
        if (this.limit - this.position >= length) {
            System.arraycopy(bArr, 0, this.buffer, this.position, length);
            this.position = length + this.position;
            return;
        }
        throw new a(this.position, this.limit);
    }

    private void aI(int i, int i2) {
        ed(g.aJ(i, i2));
    }

    private static int ec(int i) {
        return ee(g.aJ(i, 0));
    }

    private void ed(int i) {
        while ((i & -128) != 0) {
            eb((i & 127) | 128);
            i >>>= 7;
        }
        eb(i);
    }

    public static int ee(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        if ((-268435456 & i) == 0) {
            return 4;
        }
        return 5;
    }

    private void ag(long j) {
        while ((-128 & j) != 0) {
            eb((((int) j) & 127) | 128);
            j >>>= 7;
        }
        eb((int) j);
    }

    private static int ah(long j) {
        if ((-128 & j) == 0) {
            return 1;
        }
        if ((-16384 & j) == 0) {
            return 2;
        }
        if ((-2097152 & j) == 0) {
            return 3;
        }
        if ((-268435456 & j) == 0) {
            return 4;
        }
        if ((-34359738368L & j) == 0) {
            return 5;
        }
        if ((-4398046511104L & j) == 0) {
            return 6;
        }
        if ((-562949953421312L & j) == 0) {
            return 7;
        }
        if ((-72057594037927936L & j) == 0) {
            return 8;
        }
        if ((Long.MIN_VALUE & j) == 0) {
            return 9;
        }
        return 10;
    }
}
