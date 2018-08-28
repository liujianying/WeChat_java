package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.os.Handler;
import android.os.Message;
import android.view.View;

class DynamicGridView$d extends Handler {
    final /* synthetic */ DynamicGridView omz;

    private DynamicGridView$d(DynamicGridView dynamicGridView) {
        this.omz = dynamicGridView;
    }

    /* synthetic */ DynamicGridView$d(DynamicGridView dynamicGridView, byte b) {
        this(dynamicGridView);
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                DynamicGridView dynamicGridView = this.omz;
                View childAt = dynamicGridView.getChildAt(dynamicGridView.omt);
                new StringBuilder("downView ").append(childAt).append(",downPos ").append(dynamicGridView.omt).append(",lastTouchX ").append(dynamicGridView.omu).append(",lastTouchY ").append(dynamicGridView.omv);
                if (!dynamicGridView.omd && !dynamicGridView.ome && f.c(childAt, dynamicGridView.omu, dynamicGridView.omv)) {
                    dynamicGridView.xK(dynamicGridView.omt);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
