package com.tencent.mm.plugin.mmsight.a;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    public static void a(a aVar) {
        x.i("MicroMsg.VideoEditReporter", "[report-VideoEditCountData] %s", new Object[]{aVar.toString()});
        h.mEJ.h(14529, new Object[]{Integer.valueOf(aVar.scene), Integer.valueOf(aVar.source)});
    }
}
