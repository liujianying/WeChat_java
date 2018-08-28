package com.tencent.mm.plugin.pwdgroup.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;
import com.tencent.mm.sdk.platformtools.ag;

public class MMCallBackScrollView extends ScrollView {
    private ag mHandler = new 1(this);
    private int mState = 0;
    private int maC;
    private a maD;

    public void setMMOnScrollListener(a aVar) {
        this.maD = aVar;
    }

    private void uR(int i) {
        if (this.maD != null && this.mState != i) {
            this.mState = i;
            this.maD.br(i);
        }
    }

    public MMCallBackScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MMCallBackScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        this.maC = getScrollY();
        switch (motionEvent.getAction()) {
            case 1:
                if (this.mHandler != null) {
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(), 5);
                    break;
                }
                break;
            case 2:
                uR(1);
                break;
        }
        return onTouchEvent;
    }
}
