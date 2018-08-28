package com.tencent.neattextview.textview.view;

import android.content.Context;
import android.text.style.ClickableSpan;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.neattextview.textview.view.NeatTextView.c;
import java.util.Iterator;
import java.util.LinkedList;

public class b implements OnDoubleTapListener, OnGestureListener, c {
    private GestureDetector gbw;
    private View mView;
    private com.tencent.neattextview.textview.layout.b vaO;
    private a vbA;
    public com.tencent.neattextview.textview.b.c vbB;

    public b(Context context, a aVar) {
        this.vbA = aVar;
        this.gbw = new GestureDetector(context, this);
        this.gbw.setOnDoubleTapListener(this);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.vbA.getLayout() == null) {
            return false;
        }
        this.vaO = this.vbA.getLayout();
        this.mView = view;
        boolean onTouchEvent = this.gbw.onTouchEvent(motionEvent);
        if (motionEvent.getAction() != 3 && motionEvent.getAction() != 1) {
            return onTouchEvent;
        }
        cancel(2);
        return onTouchEvent;
    }

    public boolean onDown(MotionEvent motionEvent) {
        com.tencent.neattextview.textview.layout.b bVar = this.vaO;
        if (bVar.vaC == null) {
            bVar.vaC = new LinkedList();
            Iterator it = bVar.vam.iterator();
            while (it.hasNext()) {
                com.tencent.neattextview.textview.b.b bVar2 = (com.tencent.neattextview.textview.b.b) it.next();
                if (bVar2.getClass() == com.tencent.neattextview.textview.b.c.class) {
                    bVar.vaC.add((com.tencent.neattextview.textview.b.c) bVar2);
                }
            }
        }
        for (com.tencent.neattextview.textview.b.c cVar : bVar.vaC) {
            if (cVar.W(motionEvent.getX() - this.vbA.getHorizontalOffset(), motionEvent.getY() - this.vbA.getVerticalOffset())) {
                this.vbB = cVar;
                cVar.lmQ = true;
                this.mView.postInvalidate();
                break;
            }
        }
        return false;
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.vbB != null) {
            com.tencent.neattextview.textview.b.b bVar = this.vbB;
            View view = this.mView;
            if (bVar.vab != null) {
                ((ClickableSpan) bVar.vab).onClick(view);
            }
        }
        return false;
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    public void onLongPress(MotionEvent motionEvent) {
        cancel(1);
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        cancel(2);
        return false;
    }

    public void cancel(int i) {
        if (this.vbB != null) {
            this.vbB.lmQ = false;
            this.mView.invalidate();
            this.vbB = null;
        }
    }

    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return false;
    }

    public boolean onDoubleTap(MotionEvent motionEvent) {
        if (this.vbA.getOnDoubleClickListener() == null) {
            return false;
        }
        this.vbA.getOnDoubleClickListener().dK(this.mView);
        return true;
    }

    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }
}
