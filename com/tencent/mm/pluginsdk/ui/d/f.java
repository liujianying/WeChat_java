package com.tencent.mm.pluginsdk.ui.d;

import android.text.style.CharacterStyle;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.plugin.comm.a.e;
import com.tencent.neattextview.textview.view.NeatTextView;
import com.tencent.neattextview.textview.view.b;

public final class f extends b {
    private m qPI;

    public f(NeatTextView neatTextView, m mVar) {
        super(neatTextView.getContext(), neatTextView);
        this.qPI = mVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        view.setTag(e.touch_loc, new int[]{(int) motionEvent.getRawX(), (int) motionEvent.getRawY()});
        if (view instanceof NeatTextView) {
            NeatTextView neatTextView = (NeatTextView) view;
            if (!neatTextView.cAs() || neatTextView.vbj) {
                if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                    neatTextView.getWrappedTextView().setPressed(false);
                } else if (motionEvent.getAction() == 0) {
                    neatTextView.getWrappedTextView().setPressed(true);
                }
                return this.qPI.onTouch(neatTextView.getWrappedTextView(), motionEvent);
            }
        }
        return super.onTouch(view, motionEvent);
    }

    public final boolean onDown(MotionEvent motionEvent) {
        boolean onDown = super.onDown(motionEvent);
        if (this.vbB != null) {
            CharacterStyle characterStyle = this.vbB.vab;
            if (characterStyle instanceof n) {
                ((n) characterStyle).lmQ = true;
            }
        }
        return onDown;
    }

    protected final void cancel(int i) {
        if (this.vbB != null) {
            CharacterStyle characterStyle = this.vbB.vab;
            if (characterStyle instanceof n) {
                ((n) characterStyle).lmQ = false;
            }
        }
        super.cancel(i);
    }
}
