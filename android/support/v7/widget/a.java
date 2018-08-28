package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.view.ai;
import android.support.v4.view.am;
import android.support.v4.view.o;
import android.support.v4.view.z;
import android.support.v7.a.a.g;
import android.support.v7.a.a.k;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;

abstract class a extends ViewGroup {
    protected final a Jm = new a();
    protected final Context Jn;
    protected ActionMenuView Jo;
    protected ActionMenuPresenter Jp;
    protected int Jq;
    protected ai Jr;
    private boolean Js;
    private boolean Jt;

    protected class a implements am {
        private boolean Ju = false;
        int Jv;

        protected a() {
        }

        public final a a(ai aiVar, int i) {
            a.this.Jr = aiVar;
            this.Jv = i;
            return this;
        }

        public final void p(View view) {
            super.setVisibility(0);
            this.Ju = false;
        }

        public final void q(View view) {
            if (!this.Ju) {
                a.this.Jr = null;
                super.setVisibility(this.Jv);
            }
        }

        public final void ar(View view) {
            this.Ju = true;
        }
    }

    a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(android.support.v7.a.a.a.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.Jn = context;
        } else {
            this.Jn = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    protected void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, k.ActionBar, android.support.v7.a.a.a.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(k.ActionBar_height, 0));
        obtainStyledAttributes.recycle();
        if (this.Jp != null) {
            ActionMenuPresenter actionMenuPresenter = this.Jp;
            if (!actionMenuPresenter.Kw) {
                actionMenuPresenter.Kv = actionMenuPresenter.mContext.getResources().getInteger(g.abc_max_action_buttons);
            }
            if (actionMenuPresenter.bq != null) {
                actionMenuPresenter.bq.p(true);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int d = o.d(motionEvent);
        if (d == 0) {
            this.Js = false;
        }
        if (!this.Js) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (d == 0 && !onTouchEvent) {
                this.Js = true;
            }
        }
        if (d == 1 || d == 3) {
            this.Js = false;
        }
        return true;
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int d = o.d(motionEvent);
        if (d == 9) {
            this.Jt = false;
        }
        if (!this.Jt) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (d == 9 && !onHoverEvent) {
                this.Jt = true;
            }
        }
        if (d == 10 || d == 3) {
            this.Jt = false;
        }
        return true;
    }

    public void setContentHeight(int i) {
        this.Jq = i;
        requestLayout();
    }

    public int getContentHeight() {
        return this.Jq;
    }

    public int getAnimatedVisibility() {
        if (this.Jr != null) {
            return this.Jm.Jv;
        }
        return getVisibility();
    }

    public ai c(int i, long j) {
        if (this.Jr != null) {
            this.Jr.cancel();
        }
        ai t;
        if (i == 0) {
            if (getVisibility() != 0) {
                z.d(this, 0.0f);
            }
            t = z.U(this).t(1.0f);
            t.h(j);
            t.a(this.Jm.a(t, i));
            return t;
        }
        t = z.U(this).t(0.0f);
        t.h(j);
        t.a(this.Jm.a(t, i));
        return t;
    }

    public void setVisibility(int i) {
        if (i != getVisibility()) {
            if (this.Jr != null) {
                this.Jr.cancel();
            }
            super.setVisibility(i);
        }
    }

    public boolean showOverflowMenu() {
        if (this.Jp != null) {
            return this.Jp.showOverflowMenu();
        }
        return false;
    }

    protected static int f(View view, int i, int i2) {
        view.measure(MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) + 0);
    }

    protected static int c(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    protected static int a(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = ((i3 - measuredHeight) / 2) + i2;
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }
}
