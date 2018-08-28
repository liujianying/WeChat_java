package com.tencent.mm.plugin.scanner.ui;

import android.graphics.Point;
import android.util.DisplayMetrics;
import com.tencent.mm.R;
import com.tencent.mm.plugin.scanner.ui.i.b;
import com.tencent.mm.plugin.scanner.util.b.a;
import com.tencent.mm.plugin.scanner.util.k;

public class m extends c {
    public m(b bVar, Point point, DisplayMetrics displayMetrics, int i) {
        super(bVar, point, displayMetrics, i);
    }

    protected final float bsg() {
        return 1.586f;
    }

    protected final String bsh() {
        return "identity";
    }

    protected final int bsi() {
        return R.l.scan_entry_id_card;
    }

    protected final com.tencent.mm.plugin.scanner.util.b a(a aVar) {
        return new k(aVar, 1);
    }
}
