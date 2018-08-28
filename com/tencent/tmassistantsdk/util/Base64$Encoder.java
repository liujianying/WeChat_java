package com.tencent.tmassistantsdk.util;

import com.tencent.tmassistantsdk.util.Base64.Coder;

class Base64$Encoder extends Coder {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final byte[] ENCODE = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 43, (byte) 47};
    private static final byte[] ENCODE_WEBSAFE = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 45, (byte) 95};
    public static final int LINE_GROUPS = 19;
    private final byte[] alphabet;
    private int count;
    public final boolean do_cr;
    public final boolean do_newline;
    public final boolean do_padding;
    private final byte[] tail;
    int tailLen;

    static {
        boolean z;
        if (Base64.class.desiredAssertionStatus()) {
            z = false;
        } else {
            z = true;
        }
        $assertionsDisabled = z;
    }

    public Base64$Encoder(int i, byte[] bArr) {
        boolean z;
        boolean z2 = true;
        this.output = bArr;
        this.do_padding = (i & 1) == 0;
        if ((i & 2) == 0) {
            z = true;
        } else {
            z = false;
        }
        this.do_newline = z;
        if ((i & 4) == 0) {
            z2 = false;
        }
        this.do_cr = z2;
        this.alphabet = (i & 8) == 0 ? ENCODE : ENCODE_WEBSAFE;
        this.tail = new byte[2];
        this.tailLen = 0;
        this.count = this.do_newline ? 19 : -1;
    }

    public int maxOutputSize(int i) {
        return ((i * 8) / 5) + 10;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean process(byte[] r11, int r12, int r13, boolean r14) {
        /*
        r10 = this;
        r6 = r10.alphabet;
        r7 = r10.output;
        r4 = 0;
        r1 = r10.count;
        r8 = r13 + r12;
        r0 = -1;
        r2 = r10.tailLen;
        switch(r2) {
            case 0: goto L_0x00a8;
            case 1: goto L_0x00ac;
            case 2: goto L_0x00d0;
            default: goto L_0x000f;
        };
    L_0x000f:
        r3 = r0;
        r2 = r12;
    L_0x0011:
        r0 = -1;
        if (r3 == r0) goto L_0x0245;
    L_0x0014:
        r0 = 0;
        r4 = r3 >> 18;
        r4 = r4 & 63;
        r4 = r6[r4];
        r7[r0] = r4;
        r0 = 1;
        r4 = r3 >> 12;
        r4 = r4 & 63;
        r4 = r6[r4];
        r7[r0] = r4;
        r0 = 2;
        r4 = r3 >> 6;
        r4 = r4 & 63;
        r4 = r6[r4];
        r7[r0] = r4;
        r4 = 3;
        r0 = 4;
        r3 = r3 & 63;
        r3 = r6[r3];
        r7[r4] = r3;
        r1 = r1 + -1;
        if (r1 != 0) goto L_0x0241;
    L_0x003b:
        r1 = r10.do_cr;
        if (r1 == 0) goto L_0x0045;
    L_0x003f:
        r1 = 4;
        r0 = 5;
        r3 = 13;
        r7[r1] = r3;
    L_0x0045:
        r4 = r0 + 1;
        r1 = 10;
        r7[r0] = r1;
        r0 = 19;
        r5 = r0;
    L_0x004e:
        r0 = r2 + 3;
        if (r0 > r8) goto L_0x00f4;
    L_0x0052:
        r0 = r11[r2];
        r0 = r0 & 255;
        r0 = r0 << 16;
        r1 = r2 + 1;
        r1 = r11[r1];
        r1 = r1 & 255;
        r1 = r1 << 8;
        r0 = r0 | r1;
        r1 = r2 + 2;
        r1 = r11[r1];
        r1 = r1 & 255;
        r0 = r0 | r1;
        r1 = r0 >> 18;
        r1 = r1 & 63;
        r1 = r6[r1];
        r7[r4] = r1;
        r1 = r4 + 1;
        r3 = r0 >> 12;
        r3 = r3 & 63;
        r3 = r6[r3];
        r7[r1] = r3;
        r1 = r4 + 2;
        r3 = r0 >> 6;
        r3 = r3 & 63;
        r3 = r6[r3];
        r7[r1] = r3;
        r1 = r4 + 3;
        r0 = r0 & 63;
        r0 = r6[r0];
        r7[r1] = r0;
        r2 = r2 + 3;
        r1 = r4 + 4;
        r0 = r5 + -1;
        if (r0 != 0) goto L_0x023d;
    L_0x0094:
        r0 = r10.do_cr;
        if (r0 == 0) goto L_0x023a;
    L_0x0098:
        r0 = r1 + 1;
        r3 = 13;
        r7[r1] = r3;
    L_0x009e:
        r4 = r0 + 1;
        r1 = 10;
        r7[r0] = r1;
        r0 = 19;
        r5 = r0;
        goto L_0x004e;
    L_0x00a8:
        r3 = r0;
        r2 = r12;
        goto L_0x0011;
    L_0x00ac:
        r2 = r12 + 2;
        if (r2 > r8) goto L_0x000f;
    L_0x00b0:
        r0 = r10.tail;
        r2 = 0;
        r0 = r0[r2];
        r0 = r0 & 255;
        r0 = r0 << 16;
        r2 = r12 + 1;
        r3 = r11[r12];
        r3 = r3 & 255;
        r3 = r3 << 8;
        r0 = r0 | r3;
        r12 = r2 + 1;
        r2 = r11[r2];
        r2 = r2 & 255;
        r0 = r0 | r2;
        r2 = 0;
        r10.tailLen = r2;
        r3 = r0;
        r2 = r12;
        goto L_0x0011;
    L_0x00d0:
        r2 = r12 + 1;
        if (r2 > r8) goto L_0x000f;
    L_0x00d4:
        r0 = r10.tail;
        r2 = 0;
        r0 = r0[r2];
        r0 = r0 & 255;
        r0 = r0 << 16;
        r2 = r10.tail;
        r3 = 1;
        r2 = r2[r3];
        r2 = r2 & 255;
        r2 = r2 << 8;
        r0 = r0 | r2;
        r2 = r12 + 1;
        r3 = r11[r12];
        r3 = r3 & 255;
        r0 = r0 | r3;
        r3 = 0;
        r10.tailLen = r3;
        r3 = r0;
        goto L_0x0011;
    L_0x00f4:
        if (r14 == 0) goto L_0x0200;
    L_0x00f6:
        r0 = r10.tailLen;
        r0 = r2 - r0;
        r1 = r8 + -1;
        if (r0 != r1) goto L_0x0160;
    L_0x00fe:
        r3 = 0;
        r0 = r10.tailLen;
        if (r0 <= 0) goto L_0x015b;
    L_0x0103:
        r0 = r10.tail;
        r1 = 0;
        r3 = 1;
        r0 = r0[r1];
        r1 = r2;
    L_0x010a:
        r0 = r0 & 255;
        r2 = r0 << 4;
        r0 = r10.tailLen;
        r0 = r0 - r3;
        r10.tailLen = r0;
        r3 = r4 + 1;
        r0 = r2 >> 6;
        r0 = r0 & 63;
        r0 = r6[r0];
        r7[r4] = r0;
        r0 = r3 + 1;
        r2 = r2 & 63;
        r2 = r6[r2];
        r7[r3] = r2;
        r2 = r10.do_padding;
        if (r2 == 0) goto L_0x0135;
    L_0x0129:
        r2 = r0 + 1;
        r3 = 61;
        r7[r0] = r3;
        r0 = r2 + 1;
        r3 = 61;
        r7[r2] = r3;
    L_0x0135:
        r2 = r10.do_newline;
        if (r2 == 0) goto L_0x014b;
    L_0x0139:
        r2 = r10.do_cr;
        if (r2 == 0) goto L_0x0144;
    L_0x013d:
        r2 = r0 + 1;
        r3 = 13;
        r7[r0] = r3;
        r0 = r2;
    L_0x0144:
        r2 = r0 + 1;
        r3 = 10;
        r7[r0] = r3;
        r0 = r2;
    L_0x014b:
        r2 = r1;
        r4 = r0;
    L_0x014d:
        r0 = $assertionsDisabled;
        if (r0 != 0) goto L_0x01f4;
    L_0x0151:
        r0 = r10.tailLen;
        if (r0 == 0) goto L_0x01f4;
    L_0x0155:
        r0 = new java.lang.AssertionError;
        r0.<init>();
        throw r0;
    L_0x015b:
        r1 = r2 + 1;
        r0 = r11[r2];
        goto L_0x010a;
    L_0x0160:
        r0 = r10.tailLen;
        r0 = r2 - r0;
        r1 = r8 + -2;
        if (r0 != r1) goto L_0x01d8;
    L_0x0168:
        r3 = 0;
        r0 = r10.tailLen;
        r1 = 1;
        if (r0 <= r1) goto L_0x01cc;
    L_0x016e:
        r0 = r10.tail;
        r3 = 0;
        r1 = 1;
        r0 = r0[r3];
        r3 = r1;
    L_0x0175:
        r0 = r0 & 255;
        r9 = r0 << 10;
        r0 = r10.tailLen;
        if (r0 <= 0) goto L_0x01d2;
    L_0x017d:
        r0 = r10.tail;
        r1 = r3 + 1;
        r0 = r0[r3];
        r3 = r1;
    L_0x0184:
        r0 = r0 & 255;
        r0 = r0 << 2;
        r0 = r0 | r9;
        r1 = r10.tailLen;
        r1 = r1 - r3;
        r10.tailLen = r1;
        r1 = r4 + 1;
        r3 = r0 >> 12;
        r3 = r3 & 63;
        r3 = r6[r3];
        r7[r4] = r3;
        r3 = r1 + 1;
        r4 = r0 >> 6;
        r4 = r4 & 63;
        r4 = r6[r4];
        r7[r1] = r4;
        r1 = r3 + 1;
        r0 = r0 & 63;
        r0 = r6[r0];
        r7[r3] = r0;
        r0 = r10.do_padding;
        if (r0 == 0) goto L_0x0237;
    L_0x01ae:
        r0 = r1 + 1;
        r3 = 61;
        r7[r1] = r3;
    L_0x01b4:
        r1 = r10.do_newline;
        if (r1 == 0) goto L_0x01ca;
    L_0x01b8:
        r1 = r10.do_cr;
        if (r1 == 0) goto L_0x01c3;
    L_0x01bc:
        r1 = r0 + 1;
        r3 = 13;
        r7[r0] = r3;
        r0 = r1;
    L_0x01c3:
        r1 = r0 + 1;
        r3 = 10;
        r7[r0] = r3;
        r0 = r1;
    L_0x01ca:
        r4 = r0;
        goto L_0x014d;
    L_0x01cc:
        r1 = r2 + 1;
        r0 = r11[r2];
        r2 = r1;
        goto L_0x0175;
    L_0x01d2:
        r1 = r2 + 1;
        r0 = r11[r2];
        r2 = r1;
        goto L_0x0184;
    L_0x01d8:
        r0 = r10.do_newline;
        if (r0 == 0) goto L_0x014d;
    L_0x01dc:
        if (r4 <= 0) goto L_0x014d;
    L_0x01de:
        r0 = 19;
        if (r5 == r0) goto L_0x014d;
    L_0x01e2:
        r0 = r10.do_cr;
        if (r0 == 0) goto L_0x0235;
    L_0x01e6:
        r0 = r4 + 1;
        r1 = 13;
        r7[r4] = r1;
    L_0x01ec:
        r4 = r0 + 1;
        r1 = 10;
        r7[r0] = r1;
        goto L_0x014d;
    L_0x01f4:
        r0 = $assertionsDisabled;
        if (r0 != 0) goto L_0x0210;
    L_0x01f8:
        if (r2 == r8) goto L_0x0210;
    L_0x01fa:
        r0 = new java.lang.AssertionError;
        r0.<init>();
        throw r0;
    L_0x0200:
        r0 = r8 + -1;
        if (r2 != r0) goto L_0x0216;
    L_0x0204:
        r0 = r10.tail;
        r1 = r10.tailLen;
        r3 = r1 + 1;
        r10.tailLen = r3;
        r2 = r11[r2];
        r0[r1] = r2;
    L_0x0210:
        r10.op = r4;
        r10.count = r5;
        r0 = 1;
        return r0;
    L_0x0216:
        r0 = r8 + -2;
        if (r2 != r0) goto L_0x0210;
    L_0x021a:
        r0 = r10.tail;
        r1 = r10.tailLen;
        r3 = r1 + 1;
        r10.tailLen = r3;
        r3 = r11[r2];
        r0[r1] = r3;
        r0 = r10.tail;
        r1 = r10.tailLen;
        r3 = r1 + 1;
        r10.tailLen = r3;
        r2 = r2 + 1;
        r2 = r11[r2];
        r0[r1] = r2;
        goto L_0x0210;
    L_0x0235:
        r0 = r4;
        goto L_0x01ec;
    L_0x0237:
        r0 = r1;
        goto L_0x01b4;
    L_0x023a:
        r0 = r1;
        goto L_0x009e;
    L_0x023d:
        r5 = r0;
        r4 = r1;
        goto L_0x004e;
    L_0x0241:
        r5 = r1;
        r4 = r0;
        goto L_0x004e;
    L_0x0245:
        r5 = r1;
        goto L_0x004e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tmassistantsdk.util.Base64$Encoder.process(byte[], int, int, boolean):boolean");
    }
}
