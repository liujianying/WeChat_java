package com.tencent.mm.ipcinvoker.wx_extension;

import com.tencent.mm.ipcinvoker.h.a.a;
import com.tencent.mm.sdk.platformtools.x;

final class e$b implements a {
    static final a dnj = new e$b();

    private e$b() {
    }

    public final void a(int i, String str, String str2, Object... objArr) {
        switch (i) {
            case 2:
                x.v(str, str2, objArr);
                return;
            case 3:
                x.d(str, str2, objArr);
                return;
            case 4:
                x.i(str, str2, objArr);
                return;
            case 5:
                x.w(str, str2, objArr);
                return;
            case 6:
                x.e(str, str2, objArr);
                return;
            case 7:
                x.e(str, str2, objArr);
                return;
            default:
                return;
        }
    }
}
