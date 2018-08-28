package com.tencent.mm.ui.chatting.g;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.g;
import android.support.v7.widget.RecyclerView.q;
import android.view.View;
import com.tencent.mm.R;

class e$8 extends g {
    final /* synthetic */ e tYu;
    final /* synthetic */ Context val$context;

    e$8(e eVar, Context context) {
        this.tYu = eVar;
        this.val$context = context;
    }

    public final void a(Rect rect, View view, RecyclerView recyclerView, q qVar) {
        int dimension = (int) this.val$context.getResources().getDimension(R.f.OneDPPadding);
        rect.bottom = dimension;
        rect.top = dimension;
        rect.left = dimension;
        rect.right = dimension;
    }
}
