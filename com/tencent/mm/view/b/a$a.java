package com.tencent.mm.view.b;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import com.tencent.mm.b.b;

class a$a extends b {
    float bwC;
    float bwD;
    ValueAnimator bwg;
    float cY;
    float dD;
    final /* synthetic */ a uUn;
    float uUo;
    float uUp;
    boolean uUq;
    a.b uUr;

    static /* synthetic */ void a(a$a a_a) {
        Rect rawImageRect = a_a.uUn.getRawImageRect();
        float width = (((float) rawImageRect.width()) * 1.0f) / ((float) rawImageRect.height());
        if (width < (((float) a_a.uUn.getBoardRect().width()) * 1.0f) / ((float) a_a.uUn.getBoardRect().height())) {
            width = ((float) a_a.uUn.getBoardRect().width()) / width;
            a_a.uUn.getBoardRect().height();
        } else {
            width = (float) a_a.uUn.getBoardRect().height();
            a_a.uUn.getBoardRect().width();
        }
        width = a_a.uUn.a(a_a.uUn.bBo) % 180.0f == 0.0f ? (width * 1.0f) / ((float) rawImageRect.height()) : (width * 1.0f) / ((float) rawImageRect.width());
        if (a_a.uUn.uUk < width) {
            a_a.uUn.uUk = width * 1.2f;
        }
    }

    public a$a(a aVar, float f, float f2, float f3, float f4, float f5, float f6, boolean z) {
        this.uUn = aVar;
        this.dD = f;
        this.uUo = f2;
        this.uUp = f3;
        this.bwC = f4;
        this.bwD = f5;
        this.cY = f6;
        this.uUq = z;
    }
}
