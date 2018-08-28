package com.tencent.mm.a;

final class i {
    public byte[] bwd;
    public int bwe;

    public i() {
        this.bwe = 0;
        this.bwd = new byte[256];
    }

    public i(byte b) {
        this.bwe = 0;
        this.bwd = new byte[]{b};
    }

    public i(byte[] bArr) {
        this.bwe = 0;
        this.bwd = bArr;
    }
}
