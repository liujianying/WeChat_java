package com.tencent.mm.plugin.readerapp.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.plugin.readerapp.ui.ReaderItemListView.a;
import com.tencent.mm.ui.tools.k;

class ReaderItemListView$a$1 implements OnLongClickListener {
    final /* synthetic */ a mop;

    ReaderItemListView$a$1(a aVar) {
        this.mop = aVar;
    }

    public final boolean onLongClick(View view) {
        new k(this.mop.moo.getContext()).b(view, ReaderItemListView.c(this.mop.moo), ReaderItemListView.e(this.mop.moo));
        return true;
    }
}
