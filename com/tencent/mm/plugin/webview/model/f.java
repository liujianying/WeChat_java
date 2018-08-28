package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.plugin.webview.modeltools.e;
import com.tencent.mm.protocal.c.ant;
import com.tencent.mm.protocal.c.apz;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.LinkedList;
import java.util.List;

public final class f {
    public int pRe;
    public int pRf;
    public int pRg;
    public final List<apz> pRh;
    public int pRi;
    public long pRj;

    /* synthetic */ f(byte b) {
        this();
    }

    private f() {
        this.pRe = 20480;
        this.pRf = 30720;
        this.pRg = 51200;
        this.pRh = new LinkedList();
        this.pRi = 0;
        this.pRj = 0;
    }

    public static void cM(List<ant> list) {
        if (!bi.cX(list)) {
            for (ant ant : list) {
                e.bUZ().pRc.s(Integer.valueOf(ant.rQv), Long.valueOf(bi.VE() + ((long) ant.rQw)));
            }
            e.bUZ().bTV();
        }
    }
}
