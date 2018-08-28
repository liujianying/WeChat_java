package com.tencent.mm.ui.base;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mm.bw.a$b;
import com.tencent.mm.ui.ao;

public class MMListPopupWindow {
    private ListAdapter Do;
    private int MU;
    public int PM;
    public int PN;
    private int PO;
    private boolean PQ;
    private boolean PR;
    private boolean PS;
    int PT;
    public View PU;
    public int PV;
    public View PW;
    private Drawable PX;
    public OnItemClickListener PY;
    private OnItemSelectedListener PZ;
    private Runnable Qe;
    private boolean Qf;
    private Rect bJ;
    public o eZB;
    public boolean gKt;
    private Context mContext;
    private Handler mHandler;
    private DataSetObserver mObserver;
    private final f tvQ;
    private final e tvR;
    private final d tvS;
    private final b tvT;
    public a tvU;

    private class b implements Runnable {
        private b() {
        }

        /* synthetic */ b(MMListPopupWindow mMListPopupWindow, byte b) {
            this();
        }

        public final void run() {
            MMListPopupWindow.this.clearListSelection();
        }
    }

    public MMListPopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a$b.listPopupWindowStyle);
    }

    public MMListPopupWindow(Context context, AttributeSet attributeSet, int i) {
        this.tvQ = new f(this, (byte) 0);
        this.tvR = new e(this, (byte) 0);
        this.tvS = new d(this, (byte) 0);
        this.tvT = new b(this, (byte) 0);
        this.PT = Integer.MAX_VALUE;
        this.PM = -2;
        this.MU = -2;
        this.PR = false;
        this.PS = false;
        this.PV = 0;
        this.mHandler = new Handler();
        this.bJ = new Rect();
        this.gKt = false;
        this.mContext = context;
        this.eZB = new o(context);
        this.eZB.setInputMethodMode(1);
    }

    public final void setAdapter(ListAdapter listAdapter) {
        if (this.mObserver == null) {
            this.mObserver = new c(this, (byte) 0);
        } else if (this.Do != null) {
            this.Do.unregisterDataSetObserver(this.mObserver);
        }
        this.Do = listAdapter;
        if (this.Do != null) {
            listAdapter.registerDataSetObserver(this.mObserver);
        }
        if (this.tvU != null) {
            this.tvU.setAdapter(this.Do);
        }
    }

    public final void crA() {
        this.Qf = true;
        this.eZB.setFocusable(true);
    }

    public final void setBackgroundDrawable(Drawable drawable) {
        this.eZB.setBackgroundDrawable(drawable);
    }

    public final void setAnimationStyle(int i) {
        this.eZB.setAnimationStyle(i);
    }

    public final void setVerticalOffset(int i) {
        this.PO = i;
        this.PQ = true;
    }

    public final void setContentWidth(int i) {
        Drawable background = this.eZB.getBackground();
        if (background != null) {
            background.getPadding(this.bJ);
            this.MU = (this.bJ.left + this.bJ.right) + i;
            return;
        }
        this.MU = i;
    }

    public final void show() {
        int i;
        int i2;
        boolean z;
        boolean z2 = true;
        int i3 = -1;
        View frameLayout;
        if (this.tvU == null) {
            Context context = this.mContext;
            this.Qe = new 1(this);
            this.tvU = new a(context, !this.Qf, (byte) 0);
            if (this.PX != null) {
                this.tvU.setSelector(this.PX);
            }
            this.tvU.setAdapter(this.Do);
            this.tvU.setOnItemClickListener(this.PY);
            this.tvU.setFocusable(true);
            this.tvU.setFocusableInTouchMode(true);
            this.tvU.setDivider(null);
            this.tvU.setDividerHeight(0);
            this.tvU.setOnItemSelectedListener(new OnItemSelectedListener() {
                public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                    if (i != -1) {
                        a a = MMListPopupWindow.this.tvU;
                        if (a != null) {
                            a.a(a, false);
                        }
                    }
                }

                public final void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            this.tvU.setOnScrollListener(this.tvS);
            if (this.PZ != null) {
                this.tvU.setOnItemSelectedListener(this.PZ);
            }
            a aVar = this.tvU;
            View view = this.PU;
            if (view != null) {
                aqa();
                frameLayout = new FrameLayout(context);
                LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
                switch (this.PV) {
                    case 0:
                        layoutParams2.gravity = 48;
                        frameLayout.addView(aVar, layoutParams);
                        frameLayout.addView(view, layoutParams2);
                        break;
                    case 1:
                        layoutParams2.gravity = 80;
                        frameLayout.addView(aVar, layoutParams);
                        frameLayout.addView(view, layoutParams2);
                        break;
                    default:
                        ao.v("Invalid hint position " + this.PV, new Object[0]);
                        break;
                }
                view.measure(MeasureSpec.makeMeasureSpec(this.MU, Integer.MIN_VALUE), 0);
            } else {
                frameLayout = aVar;
            }
            this.eZB.setContentView(frameLayout);
            i = 0;
        } else {
            frameLayout = this.PU;
            i = frameLayout != null ? frameLayout.getMeasuredHeight() : 0;
        }
        Drawable background = this.eZB.getBackground();
        if (background != null) {
            background.getPadding(this.bJ);
            i2 = this.bJ.top + this.bJ.bottom;
            if (!this.PQ) {
                this.PO = -this.bJ.top;
            }
        } else {
            this.bJ.setEmpty();
            i2 = 0;
        }
        if (this.eZB.getInputMethodMode() == 2) {
            z = true;
        } else {
            z = false;
        }
        View view2 = this.PW;
        int i4 = this.PO;
        Rect rect = new Rect();
        view2.getWindowVisibleDisplayFrame(rect);
        view2.getLocationOnScreen(new int[2]);
        int i5 = (z ? view2.getContext().getResources().getDisplayMetrics().heightPixels : rect.bottom) - i4;
        if (this.eZB.getBackground() != null) {
            this.eZB.getBackground().getPadding(this.bJ);
            i5 -= this.bJ.top + this.bJ.bottom;
        }
        if (this.PR || this.PM == -1) {
            i = i5 + i2;
        } else {
            int makeMeasureSpec;
            switch (this.MU) {
                case -2:
                    makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.bJ.left + this.bJ.right), Integer.MIN_VALUE);
                    break;
                case -1:
                    makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.bJ.left + this.bJ.right), 1073741824);
                    break;
                default:
                    makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.MU, 1073741824);
                    break;
            }
            i5 = this.tvU.S(makeMeasureSpec, i5 - i);
            if (i5 > 0) {
                i += i2;
            }
            i += i5;
        }
        boolean isInputMethodNotNeeded = isInputMethodNotNeeded();
        o oVar;
        if (this.eZB.isShowing()) {
            if (this.MU == -1) {
                i2 = -1;
            } else if (this.MU == -2) {
                i2 = this.PW.getWidth();
            } else {
                i2 = this.MU;
            }
            if (this.PM == -1) {
                if (isInputMethodNotNeeded) {
                    i5 = i;
                } else {
                    i5 = -1;
                }
                if (isInputMethodNotNeeded) {
                    oVar = this.eZB;
                    if (this.MU != -1) {
                        i3 = 0;
                    }
                    oVar.setWindowLayoutMode(i3, 0);
                    i = i5;
                } else {
                    this.eZB.setWindowLayoutMode(this.MU == -1 ? -1 : 0, -1);
                    i = i5;
                }
            } else if (this.PM != -2) {
                i = this.PM;
            }
            this.eZB.update(i2, i);
            oVar = this.eZB;
            if (this.PS || this.PR) {
                z2 = false;
            }
            oVar.setOutsideTouchable(z2);
            if (this.gKt) {
                this.eZB.showAtLocation(this.PW, 17, 0, 0);
                return;
            } else {
                this.eZB.showAtLocation(this.PW, 53, this.PN, this.PO);
                return;
            }
        }
        if (this.MU == -1) {
            i2 = -1;
        } else if (this.MU == -2) {
            this.eZB.setWidth(this.PW.getWidth());
            i2 = 0;
        } else {
            this.eZB.setWidth(this.MU);
            i2 = 0;
        }
        if (this.PM == -1) {
            i = -1;
        } else if (this.PM == -2) {
            this.eZB.setHeight(i);
            i = 0;
        } else {
            this.eZB.setHeight(this.PM);
            i = 0;
        }
        this.eZB.setWindowLayoutMode(i2, i);
        oVar = this.eZB;
        if (this.PS || this.PR) {
            z2 = false;
        }
        oVar.setOutsideTouchable(z2);
        this.eZB.setTouchInterceptor(this.tvR);
        if (this.gKt) {
            this.eZB.showAtLocation(this.PW, 17, 0, 0);
        } else {
            this.eZB.showAtLocation(this.PW, 53, this.PN, this.PO);
        }
        this.tvU.setSelection(-1);
        if (!this.Qf || this.tvU.isInTouchMode()) {
            clearListSelection();
        }
        if (!this.Qf) {
            this.mHandler.post(this.tvT);
        }
    }

    public final void dismiss() {
        this.eZB.dismiss();
        aqa();
        this.eZB.setContentView(null);
        this.tvU = null;
        this.mHandler.removeCallbacks(this.tvQ);
    }

    public final void setOnDismissListener(OnDismissListener onDismissListener) {
        this.eZB.setOnDismissListener(onDismissListener);
    }

    public final void aqa() {
        if (this.PU != null) {
            ViewParent parent = this.PU.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.PU);
            }
        }
    }

    public final void fo() {
        this.eZB.setInputMethodMode(2);
    }

    public final void clearListSelection() {
        a aVar = this.tvU;
        if (aVar != null) {
            a.a(aVar, true);
            aVar.requestLayout();
        }
    }

    public final boolean isInputMethodNotNeeded() {
        return this.eZB.getInputMethodMode() == 2;
    }
}
