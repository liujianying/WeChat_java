package com.tencent.mm.ui.base;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.ui.base.HorizontalListViewV2.d.a;

class HorizontalListViewV2$a extends SimpleOnGestureListener {
    final /* synthetic */ HorizontalListViewV2 tti;

    private HorizontalListViewV2$a(HorizontalListViewV2 horizontalListViewV2) {
        this.tti = horizontalListViewV2;
    }

    /* synthetic */ HorizontalListViewV2$a(HorizontalListViewV2 horizontalListViewV2, byte b) {
        this(horizontalListViewV2);
    }

    public final boolean onDown(MotionEvent motionEvent) {
        return this.tti.onDown(motionEvent);
    }

    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return this.tti.aC(f);
    }

    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        HorizontalListViewV2.a(this.tti, Boolean.valueOf(true));
        HorizontalListViewV2.a(this.tti, a.ttk);
        HorizontalListViewV2.d(this.tti);
        HorizontalListViewV2 horizontalListViewV2 = this.tti;
        horizontalListViewV2.tsD += (int) f;
        HorizontalListViewV2.b(this.tti, Math.round(f));
        this.tti.requestLayout();
        return true;
    }

    public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        HorizontalListViewV2.d(this.tti);
        OnItemClickListener onItemClickListener = this.tti.getOnItemClickListener();
        int a = HorizontalListViewV2.a(this.tti, (int) motionEvent.getX(), (int) motionEvent.getY());
        if (a >= 0 && !HorizontalListViewV2.f(this.tti)) {
            View childAt = this.tti.getChildAt(a);
            int g = HorizontalListViewV2.g(this.tti) + a;
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(this.tti, childAt, g, this.tti.Do.getItemId(g));
                return true;
            }
        }
        if (!(HorizontalListViewV2.h(this.tti) == null || HorizontalListViewV2.f(this.tti))) {
            HorizontalListViewV2.h(this.tti).onClick(this.tti);
        }
        return false;
    }

    public final void onLongPress(MotionEvent motionEvent) {
        HorizontalListViewV2.d(this.tti);
        int a = HorizontalListViewV2.a(this.tti, (int) motionEvent.getX(), (int) motionEvent.getY());
        if (a >= 0 && !HorizontalListViewV2.f(this.tti)) {
            View childAt = this.tti.getChildAt(a);
            OnItemLongClickListener onItemLongClickListener = this.tti.getOnItemLongClickListener();
            if (onItemLongClickListener != null) {
                int g = HorizontalListViewV2.g(this.tti) + a;
                if (onItemLongClickListener.onItemLongClick(this.tti, childAt, g, this.tti.Do.getItemId(g))) {
                    this.tti.performHapticFeedback(0);
                }
            }
        }
    }
}
