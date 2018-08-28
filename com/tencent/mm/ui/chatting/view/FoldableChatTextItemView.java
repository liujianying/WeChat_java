package com.tencent.mm.ui.chatting.view;

import android.content.Context;
import android.support.v4.view.e;
import android.util.AttributeSet;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.comm.a;

public class FoldableChatTextItemView extends LinearLayout {
    private e XZ;
    private int maxHeight;
    private a tYW;

    public FoldableChatTextItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FoldableChatTextItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        setTagObject(motionEvent);
        if (this.XZ != null) {
            this.XZ.onTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    private void setTagObject(MotionEvent motionEvent) {
        setTag(a.e.touch_loc, new int[]{(int) motionEvent.getRawX(), (int) motionEvent.getRawY()});
    }

    public void setMaxHeight(int i) {
        this.maxHeight = i;
    }

    public void setOnGestureListener(OnGestureListener onGestureListener) {
        this.XZ = new e(getContext(), onGestureListener);
    }

    public void setFoldTextListener(a aVar) {
        this.tYW = aVar;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }
}
