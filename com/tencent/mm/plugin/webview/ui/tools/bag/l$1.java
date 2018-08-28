package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.graphics.Point;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.x;

class l$1 implements f {
    final /* synthetic */ l qcG;

    l$1(l lVar) {
        this.qcG = lVar;
    }

    public final void b(float f, int i) {
        x.i("MicroMsg.WebViewUIBagHelper", "showBag swipedPosX:%f reportScene:%d", new Object[]{Float.valueOf(f), Integer.valueOf(i)});
        l.a(this.qcG, i);
        h.a(l.a(this.qcG), (Point) l.b(this.qcG, 8).getParcelable("key_current_bag_pos"), f, l.b(this.qcG));
    }

    public final void ax(float f) {
        Bundle bundle = new Bundle();
        bundle.putFloat("key_alpha", f);
        l.a(this.qcG, bundle);
    }
}
