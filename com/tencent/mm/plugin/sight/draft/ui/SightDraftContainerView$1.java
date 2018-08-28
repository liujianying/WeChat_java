package com.tencent.mm.plugin.sight.draft.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class SightDraftContainerView$1 implements OnTouchListener {
    final /* synthetic */ SightDraftContainerView neS;

    SightDraftContainerView$1(SightDraftContainerView sightDraftContainerView) {
        this.neS = sightDraftContainerView;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        SightDraftContainerView sightDraftContainerView = this.neS;
        if (sightDraftContainerView.neR != null) {
            b bVar = sightDraftContainerView.neR;
            bVar.a(null);
            bVar.neu.bwe();
        }
        return false;
    }
}
