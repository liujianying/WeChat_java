package com.tencent.mm.plugin.fts.ui;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.g;
import android.support.v7.widget.RecyclerView.q;
import android.view.View;

class FTSChattingConvUI$1 extends g {
    Paint fBa = new Paint(1);
    final /* synthetic */ FTSChattingConvUI jwt;
    final int offset = ((int) this.jwt.getResources().getDimension(n$b.BigPadding));

    FTSChattingConvUI$1(FTSChattingConvUI fTSChattingConvUI) {
        this.jwt = fTSChattingConvUI;
    }

    public final void a(Rect rect, View view, RecyclerView recyclerView, q qVar) {
        super.a(rect, view, recyclerView, qVar);
        rect.set(this.offset, this.offset, this.offset, this.offset);
    }

    public final void a(Canvas canvas, RecyclerView recyclerView, q qVar) {
        super.a(canvas, recyclerView, qVar);
        this.fBa.setColor(-2434342);
        this.fBa.setStrokeWidth(1.0f);
        this.fBa.setStyle(Style.FILL);
        int childCount = recyclerView.getChildCount();
        int i = 0;
        while (i < childCount) {
            if (i == 1 || i == 4) {
                View childAt = recyclerView.getChildAt(i);
                if (FTSChattingConvUI.a(this.jwt)) {
                    canvas.drawLine((float) (childAt.getLeft() - this.offset), (float) childAt.getTop(), (float) (childAt.getLeft() - this.offset), (float) childAt.getBottom(), this.fBa);
                } else {
                    canvas.drawLine((float) (childAt.getLeft() - this.offset), (float) childAt.getTop(), (float) (childAt.getLeft() - this.offset), (float) childAt.getBottom(), this.fBa);
                    canvas.drawLine((float) (childAt.getRight() + this.offset), (float) childAt.getTop(), (float) (childAt.getRight() + this.offset), (float) childAt.getBottom(), this.fBa);
                }
            }
            i++;
        }
    }
}
