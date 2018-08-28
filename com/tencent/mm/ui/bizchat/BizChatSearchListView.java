package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;

public class BizChatSearchListView extends ListView {
    private a tEI;

    public BizChatSearchListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BizChatSearchListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.tEI != null) {
            this.tEI.auW();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setOnTouchListener(a aVar) {
        this.tEI = aVar;
    }
}
