package com.tencent.mm.ui.widget.listview;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.ui.widget.listview.AnimatedExpandableListView.a;
import com.tencent.mm.ui.widget.listview.AnimatedExpandableListView.b;

class AnimatedExpandableListView$a$1 implements AnimationListener {
    final /* synthetic */ int nXM;
    final /* synthetic */ b uKC;
    final /* synthetic */ a uKD;

    AnimatedExpandableListView$a$1(a aVar, int i, b bVar) {
        this.uKD = aVar;
        this.nXM = i;
        this.uKC = bVar;
    }

    public final void onAnimationEnd(Animation animation) {
        a.b(this.uKD, this.nXM);
        this.uKD.notifyDataSetChanged();
        this.uKC.setTag(Integer.valueOf(0));
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationStart(Animation animation) {
    }
}
