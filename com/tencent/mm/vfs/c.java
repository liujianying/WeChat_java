package com.tencent.mm.vfs;

import java.io.FilterInputStream;

public final class c extends FilterInputStream {
    public c(String str) {
        super(d.openRead(str));
    }
}
