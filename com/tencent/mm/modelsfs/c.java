package com.tencent.mm.modelsfs;

import java.io.File;
import java.io.FileOutputStream;

public final class c extends FileOutputStream {
    private a eex;

    public c(File file, long j) {
        super(file);
        this.eex = new a(j);
    }

    public c(String str, String str2) {
        super(str);
        this.eex = new a(str2);
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
}
