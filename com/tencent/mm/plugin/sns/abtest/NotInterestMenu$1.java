package com.tencent.mm.plugin.sns.abtest;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class NotInterestMenu$1 implements OnItemClickListener {
    final /* synthetic */ NotInterestMenu nhA;

    NotInterestMenu$1(NotInterestMenu notInterestMenu) {
        this.nhA = notInterestMenu;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (NotInterestMenu.a(this.nhA) != null) {
            NotInterestMenu.a(this.nhA).bwG();
        }
        if (NotInterestMenu.b(this.nhA) != null) {
            switch (i) {
                case 0:
                    NotInterestMenu.b(this.nhA).c(NotInterestMenu.c(this.nhA));
                    return;
                case 1:
                    NotInterestMenu.b(this.nhA).d(NotInterestMenu.c(this.nhA));
                    return;
                case 2:
                    NotInterestMenu.b(this.nhA).e(NotInterestMenu.c(this.nhA));
                    return;
                default:
                    return;
            }
        }
    }
}
