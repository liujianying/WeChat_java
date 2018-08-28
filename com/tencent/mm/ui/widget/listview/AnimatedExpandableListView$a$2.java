package com.tencent.mm.ui.widget.listview;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ExpandableListView;
import com.tencent.mm.ui.widget.listview.AnimatedExpandableListView.a;
import com.tencent.mm.ui.widget.listview.AnimatedExpandableListView.b;
import com.tencent.mm.ui.widget.listview.AnimatedExpandableListView.d;

class AnimatedExpandableListView$a$2 implements AnimationListener {
    final /* synthetic */ int nXM;
    final /* synthetic */ b uKC;
    final /* synthetic */ a uKD;
    final /* synthetic */ ExpandableListView uKE;
    final /* synthetic */ d uKF;

    AnimatedExpandableListView$a$2(a aVar, int i, ExpandableListView expandableListView, d dVar, b bVar) {
        this.uKD = aVar;
        this.nXM = i;
        this.uKE = expandableListView;
        this.uKF = dVar;
        this.uKC = bVar;
    }

    public final void onAnimationEnd(Animation animation) {
        a.b(this.uKD, this.nXM);
        this.uKE.collapseGroup(this.nXM);
        this.uKD.notifyDataSetChanged();
        this.uKF.uKN = -1;
        this.uKC.setTag(Integer.valueOf(0));
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationStart(Animation animation) {
    }
}
