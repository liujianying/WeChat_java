package com.tencent.mm.plugin.fts.ui.b;

import android.content.Context;
import com.tencent.mm.plugin.fts.a.d.a;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.d.e$b;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

public final class f extends a {
    public final e a(Context context, e$b e_b, int i) {
        return new com.tencent.mm.plugin.fts.ui.d.f(context, e_b, i);
    }

    public final int getType() {
        return 160;
    }

    public final int getPriority() {
        return Downloads.RECV_BUFFER_SIZE;
    }
}
