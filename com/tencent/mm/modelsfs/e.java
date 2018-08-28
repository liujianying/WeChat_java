package com.tencent.mm.modelsfs;

public final class e extends SFSOutputStream {
    private a eex;

    public e(long j, String str) {
        super(j);
        this.eex = new a(str);
    }

    public final void write(int i) {
        super.write(i);
    }

    public final void write(byte[] bArr, int i, int i2) {
        this.eex.y(bArr, i2);
        super.write(bArr, i, i2);
    }

    public final void close() {
        super.close();
        if (this.eex != null) {
            this.eex.free();
        }
    }

    protected final void finalize() {
        super.finalize();
    }
}
