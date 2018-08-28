package com.tencent.mm.bk;

import f.a.a.a.a.b;

public class a {
    protected static final int OPCODE_COMPUTESIZE = 1;
    protected static final int OPCODE_PARSEFROM = 2;
    protected static final int OPCODE_POPULATEBUILDERWITHFIELD = 3;
    protected static final int OPCODE_WRITEFIELDS = 0;
    public static b unknownTagHandler = new f.a.a.a.a.a();

    public byte[] toByteArray() {
        boj();
        byte[] bArr = new byte[boi()];
        f.a.a.c.a aVar = new f.a.a.c.a(bArr);
        a(aVar);
        if (aVar.dHY != null) {
            aVar.dHY.write(aVar.vHI);
            aVar.dHY.flush();
        }
        return bArr;
    }

    public static int a(f.a.a.a.a aVar) {
        int i = 0;
        f.a.a.b.a.a aVar2 = aVar.vHC;
        if (aVar2.bfI != aVar2.bufferSize || aVar2.nb(false)) {
            aVar2.bfJ = aVar2.rY();
            if (aVar2.bfJ == 0) {
                throw f.a.a.b.a.b.cJW();
            }
            i = aVar2.bfJ;
        } else {
            aVar2.bfJ = 0;
        }
        aVar.vHD = i;
        return f.a.a.b.a.eg(aVar.vHD);
    }

    public a boj() {
        return this;
    }

    public int a(int i, Object... objArr) {
        throw new Error("Cannot use this method");
    }

    public void a(f.a.a.c.a aVar) {
        a(0, aVar);
    }

    public int boi() {
        int i = 0;
        try {
            return a(1, new Object[0]);
        } catch (Exception e) {
            return i;
        }
    }

    public a aG(byte[] bArr) {
        a(2, bArr);
        return this;
    }

    public boolean a(f.a.a.a.a aVar, a aVar2, int i) {
        return a(3, aVar, aVar2, Integer.valueOf(i)) == 0;
    }
}
