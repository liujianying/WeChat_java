package com.tencent.mm.plugin.websearch.api;

import com.tencent.mm.loader.stub.b;
import java.io.File;

public final class ae {
    private int pMt = 1;
    private long pMu;
    private String pMv;
    String pMw;
    String pMx;

    public ae(String str, String str2, String str3) {
        this.pMv = str;
        this.pMw = str2;
        this.pMx = str3;
    }

    public final int Oe() {
        if (this.pMt <= 1 || bTo().lastModified() > this.pMu) {
            bTn();
        }
        return this.pMt;
    }

    public final int bTn() {
        this.pMt = Integer.valueOf(p.A(bTo()).getProperty("version", "1")).intValue();
        this.pMu = System.currentTimeMillis();
        return this.pMt;
    }

    private File bTo() {
        return new File(adP(), "config.conf");
    }

    public final String adP() {
        File file = new File(b.duO.replace("/data/user/0", "/data/data"), this.pMv);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public final String bTp() {
        return new File(adP(), this.pMw).getAbsolutePath();
    }
}
