package com.tencent.matrix.iocanary.core;

import com.tencent.matrix.c.b;
import java.util.List;

public class a implements com.tencent.matrix.c.c.a, b {
    public static final /* synthetic */ boolean $assertionsDisabled = (!a.class.desiredAssertionStatus());
    public boolean bpL;
    public final com.tencent.matrix.iocanary.a.a bqJ;
    private final com.tencent.matrix.iocanary.a bqU;
    public com.tencent.matrix.iocanary.b.a bqV;

    public a(com.tencent.matrix.iocanary.a aVar) {
        this.bqJ = aVar.bqJ;
        this.bqU = aVar;
    }

    public final void a(b bVar) {
        this.bqU.a(bVar);
    }

    public final void y(List<IOIssue> list) {
        if (list != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    this.bqU.a(com.tencent.matrix.iocanary.c.a.a((IOIssue) list.get(i2)));
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
