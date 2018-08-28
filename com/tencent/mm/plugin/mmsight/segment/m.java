package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.mm.plugin.report.service.h;

public final class m {
    public static void sX(int i) {
        h.mEJ.a(440, 165, 1, false);
        if (i == 1) {
            h.mEJ.a(440, 166, 1, false);
        } else if (i == 2) {
            h.mEJ.a(440, 167, 1, false);
        } else if (i == 3) {
            h.mEJ.a(440, 168, 1, false);
        }
    }

    public static void sY(int i) {
        h.mEJ.a(440, 169, 1, false);
        if (i == 1) {
            h.mEJ.a(440, 170, 1, false);
        } else if (i == 2) {
            h.mEJ.a(440, 171, 1, false);
        } else if (i == 3) {
            h.mEJ.a(440, 172, 1, false);
        }
    }

    public static void C(int i, long j) {
        if (i == 1) {
            h.mEJ.a(440, 150, 1, false);
            h.mEJ.a(440, 151, j, false);
        } else if (i == 2) {
            h.mEJ.a(440, 155, 1, false);
            h.mEJ.a(440, 156, j, false);
        } else if (i == 3) {
            h.mEJ.a(440, 159, 1, false);
            h.mEJ.a(440, 160, j, false);
        }
    }
}
