package com.tencent.mm.view.b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.tencent.mm.bi.b;

public final class c extends a {
    public c(Context context, b bVar) {
        super(context, bVar);
    }

    public final Rect getAliveRect() {
        return super.getAliveRect().isEmpty() ? getBoardRect() : super.getAliveRect();
    }

    public final boolean cCg() {
        return false;
    }

    protected final boolean cCf() {
        return false;
    }

    protected final void onDraw(Canvas canvas) {
        canvas.drawColor(0);
        canvas.setMatrix(this.bBo);
        getPresenter().onDraw(canvas);
    }
}
