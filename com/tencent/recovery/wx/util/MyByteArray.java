package com.tencent.recovery.wx.util;

class MyByteArray {
    public byte[] bwd;
    public int bwe;

    public MyByteArray() {
        this.bwe = 0;
        this.bwd = new byte[256];
    }

    public MyByteArray(byte b) {
        this.bwe = 0;
        this.bwd = new byte[]{b};
    }

    public MyByteArray(byte[] bArr) {
        this.bwe = 0;
        this.bwd = bArr;
    }
}
