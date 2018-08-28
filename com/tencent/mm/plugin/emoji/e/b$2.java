package com.tencent.mm.plugin.emoji.e;

import com.tencent.mm.g.a.hy;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class b$2 extends c<hy> {
    final /* synthetic */ b ifh;

    b$2(b bVar) {
        this.ifh = bVar;
        this.sFo = hy.class.getName().hashCode();
    }

    public final /* bridge */ /* synthetic */ boolean a(b bVar) {
        switch (((hy) bVar).bRu.errorCode) {
            case 101:
                h.mEJ.a(401, 3, 1, false);
                break;
            case 102:
                h.mEJ.a(401, 4, 1, false);
                break;
            case 104:
                h.mEJ.a(401, 6, 1, false);
                break;
            case 105:
                h.mEJ.a(401, 7, 1, false);
                break;
            case 106:
                h.mEJ.a(401, 8, 1, false);
                break;
            case 107:
                h.mEJ.a(401, 9, 1, false);
                break;
            case 108:
                h.mEJ.a(401, 10, 1, false);
                break;
            case 109:
                h.mEJ.a(401, 11, 1, false);
                break;
            case 110:
                h.mEJ.a(401, 12, 1, false);
                break;
            case 111:
                h.mEJ.a(401, 13, 1, false);
                break;
            case MMGIFException.D_GIF_ERR_IMAGE_DEFECT /*112*/:
                h.mEJ.a(401, 14, 1, false);
                break;
            case 113:
                h.mEJ.a(401, 15, 1, false);
                break;
        }
        return false;
    }
}
