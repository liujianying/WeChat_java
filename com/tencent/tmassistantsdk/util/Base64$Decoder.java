package com.tencent.tmassistantsdk.util;

class Base64$Decoder extends Base64$Coder {
    private static final int[] DECODE = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    private static final int[] DECODE_WEBSAFE = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    private static final int EQUALS = -2;
    private static final int SKIP = -1;
    private final int[] alphabet;
    private int state;
    private int value;

    public Base64$Decoder(int i, byte[] bArr) {
        this.output = bArr;
        this.alphabet = (i & 8) == 0 ? DECODE : DECODE_WEBSAFE;
        this.state = 0;
        this.value = 0;
    }

    public int maxOutputSize(int i) {
        return ((i * 3) / 4) + 10;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean process(byte[] r10, int r11, int r12, boolean r13) {
        /*
        r9 = this;
        r0 = r9.state;
        r1 = 6;
        if (r0 != r1) goto L_0x0007;
    L_0x0005:
        r0 = 0;
    L_0x0006:
        return r0;
    L_0x0007:
        r5 = r12 + r11;
        r3 = r9.state;
        r1 = r9.value;
        r0 = 0;
        r6 = r9.output;
        r7 = r9.alphabet;
        r2 = r11;
        r4 = r3;
    L_0x0014:
        if (r2 >= r5) goto L_0x0106;
    L_0x0016:
        if (r4 != 0) goto L_0x005d;
    L_0x0018:
        r3 = r2 + 4;
        if (r3 > r5) goto L_0x005b;
    L_0x001c:
        r1 = r10[r2];
        r1 = r1 & 255;
        r1 = r7[r1];
        r1 = r1 << 18;
        r3 = r2 + 1;
        r3 = r10[r3];
        r3 = r3 & 255;
        r3 = r7[r3];
        r3 = r3 << 12;
        r1 = r1 | r3;
        r3 = r2 + 2;
        r3 = r10[r3];
        r3 = r3 & 255;
        r3 = r7[r3];
        r3 = r3 << 6;
        r1 = r1 | r3;
        r3 = r2 + 3;
        r3 = r10[r3];
        r3 = r3 & 255;
        r3 = r7[r3];
        r1 = r1 | r3;
        if (r1 < 0) goto L_0x005b;
    L_0x0045:
        r3 = r0 + 2;
        r8 = (byte) r1;
        r6[r3] = r8;
        r3 = r0 + 1;
        r8 = r1 >> 8;
        r8 = (byte) r8;
        r6[r3] = r8;
        r3 = r1 >> 16;
        r3 = (byte) r3;
        r6[r0] = r3;
        r0 = r0 + 3;
        r2 = r2 + 4;
        goto L_0x0018;
    L_0x005b:
        if (r2 >= r5) goto L_0x0106;
    L_0x005d:
        r11 = r2 + 1;
        r2 = r10[r2];
        r2 = r2 & 255;
        r3 = r7[r2];
        switch(r4) {
            case 0: goto L_0x006a;
            case 1: goto L_0x0079;
            case 2: goto L_0x008c;
            case 3: goto L_0x00af;
            case 4: goto L_0x00eb;
            case 5: goto L_0x00fd;
            default: goto L_0x0068;
        };
    L_0x0068:
        r2 = r11;
        goto L_0x0014;
    L_0x006a:
        if (r3 < 0) goto L_0x0071;
    L_0x006c:
        r4 = r4 + 1;
        r1 = r3;
        r2 = r11;
        goto L_0x0014;
    L_0x0071:
        r2 = -1;
        if (r3 == r2) goto L_0x0068;
    L_0x0074:
        r0 = 6;
        r9.state = r0;
        r0 = 0;
        goto L_0x0006;
    L_0x0079:
        if (r3 < 0) goto L_0x0083;
    L_0x007b:
        r1 = r1 << 6;
        r1 = r1 | r3;
        r3 = r4 + 1;
        r2 = r11;
        r4 = r3;
        goto L_0x0014;
    L_0x0083:
        r2 = -1;
        if (r3 == r2) goto L_0x0068;
    L_0x0086:
        r0 = 6;
        r9.state = r0;
        r0 = 0;
        goto L_0x0006;
    L_0x008c:
        if (r3 < 0) goto L_0x0097;
    L_0x008e:
        r1 = r1 << 6;
        r1 = r1 | r3;
        r3 = r4 + 1;
        r2 = r11;
        r4 = r3;
        goto L_0x0014;
    L_0x0097:
        r2 = -2;
        if (r3 != r2) goto L_0x00a6;
    L_0x009a:
        r3 = r0 + 1;
        r2 = r1 >> 4;
        r2 = (byte) r2;
        r6[r0] = r2;
        r4 = 4;
        r0 = r3;
        r2 = r11;
        goto L_0x0014;
    L_0x00a6:
        r2 = -1;
        if (r3 == r2) goto L_0x0068;
    L_0x00a9:
        r0 = 6;
        r9.state = r0;
        r0 = 0;
        goto L_0x0006;
    L_0x00af:
        if (r3 < 0) goto L_0x00cc;
    L_0x00b1:
        r1 = r1 << 6;
        r1 = r1 | r3;
        r2 = r0 + 2;
        r3 = (byte) r1;
        r6[r2] = r3;
        r2 = r0 + 1;
        r3 = r1 >> 8;
        r3 = (byte) r3;
        r6[r2] = r3;
        r2 = r1 >> 16;
        r2 = (byte) r2;
        r6[r0] = r2;
        r0 = r0 + 3;
        r3 = 0;
        r2 = r11;
        r4 = r3;
        goto L_0x0014;
    L_0x00cc:
        r2 = -2;
        if (r3 != r2) goto L_0x00e2;
    L_0x00cf:
        r2 = r0 + 1;
        r3 = r1 >> 2;
        r3 = (byte) r3;
        r6[r2] = r3;
        r2 = r1 >> 10;
        r2 = (byte) r2;
        r6[r0] = r2;
        r0 = r0 + 2;
        r3 = 5;
        r2 = r11;
        r4 = r3;
        goto L_0x0014;
    L_0x00e2:
        r2 = -1;
        if (r3 == r2) goto L_0x0068;
    L_0x00e5:
        r0 = 6;
        r9.state = r0;
        r0 = 0;
        goto L_0x0006;
    L_0x00eb:
        r2 = -2;
        if (r3 != r2) goto L_0x00f4;
    L_0x00ee:
        r3 = r4 + 1;
        r2 = r11;
        r4 = r3;
        goto L_0x0014;
    L_0x00f4:
        r2 = -1;
        if (r3 == r2) goto L_0x0068;
    L_0x00f7:
        r0 = 6;
        r9.state = r0;
        r0 = 0;
        goto L_0x0006;
    L_0x00fd:
        r2 = -1;
        if (r3 == r2) goto L_0x0068;
    L_0x0100:
        r0 = 6;
        r9.state = r0;
        r0 = 0;
        goto L_0x0006;
    L_0x0106:
        r2 = r1;
        if (r13 != 0) goto L_0x0112;
    L_0x0109:
        r9.state = r4;
        r9.value = r2;
        r9.op = r0;
        r0 = 1;
        goto L_0x0006;
    L_0x0112:
        switch(r4) {
            case 0: goto L_0x0115;
            case 1: goto L_0x011c;
            case 2: goto L_0x0122;
            case 3: goto L_0x012b;
            case 4: goto L_0x013a;
            default: goto L_0x0115;
        };
    L_0x0115:
        r9.state = r4;
        r9.op = r0;
        r0 = 1;
        goto L_0x0006;
    L_0x011c:
        r0 = 6;
        r9.state = r0;
        r0 = 0;
        goto L_0x0006;
    L_0x0122:
        r1 = r0 + 1;
        r2 = r2 >> 4;
        r2 = (byte) r2;
        r6[r0] = r2;
        r0 = r1;
        goto L_0x0115;
    L_0x012b:
        r1 = r0 + 1;
        r3 = r2 >> 10;
        r3 = (byte) r3;
        r6[r0] = r3;
        r0 = r1 + 1;
        r2 = r2 >> 2;
        r2 = (byte) r2;
        r6[r1] = r2;
        goto L_0x0115;
    L_0x013a:
        r0 = 6;
        r9.state = r0;
        r0 = 0;
        goto L_0x0006;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tmassistantsdk.util.Base64$Decoder.process(byte[], int, int, boolean):boolean");
    }
}
