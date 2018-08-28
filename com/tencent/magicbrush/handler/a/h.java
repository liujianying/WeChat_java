package com.tencent.magicbrush.handler.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import java.util.ArrayList;
import java.util.List;

final class h {
    private List<k> bnR = new ArrayList();
    g bnW;
    e bnX;
    Canvas bnY;
    Paint bnZ;
    char[] boa = new char[1];
    Rect bob = new Rect();
    private Rect boc = new Rect();
    FontMetrics bod = new FontMetrics();

    h(e eVar, g gVar) {
        this.bnX = eVar;
        this.bnY = new Canvas(this.bnX.bnH);
        this.bnW = gVar;
        this.bnZ = new Paint(1);
        this.bnZ.setTextAlign(Align.LEFT);
        this.bnZ.setColor(-1);
    }

    static float x(List<k> list) {
        if (list == null || list.size() == 0) {
            return 0.0f;
        }
        float f = 0.0f;
        for (k kVar : list) {
            if (kVar != null) {
                f = kVar.bos + f;
            }
        }
        return f;
    }
}
