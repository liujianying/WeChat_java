package com.tencent.mm.ui.chatting.g;

import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.g;
import android.support.v7.widget.RecyclerView.q;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.a.b.b;

class b$1 extends g {
    int fi = ((int) this.tYf.mContext.getResources().getDimension(R.f.BasicPaddingSize));
    int tYd = this.tYf.mContext.getResources().getColor(R.e.fav_listitem_divider_bg);
    ColorDrawable tYe = new ColorDrawable(this.tYd);
    final /* synthetic */ b tYf;

    b$1(b bVar) {
        this.tYf = bVar;
    }

    public final void a(Canvas canvas, RecyclerView recyclerView, q qVar) {
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            if (childAt.getTag() != null) {
                b EZ = this.tYf.EZ(((Integer) childAt.getTag()).intValue() + 1);
                if (EZ == null || EZ.getType() != Integer.MAX_VALUE) {
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    int bottom = layoutParams.bottomMargin + childAt.getBottom();
                    this.tYe.setBounds(paddingLeft, bottom, width, this.fi + bottom);
                    this.tYe.draw(canvas);
                }
            }
        }
    }
}
