package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import com.tencent.mm.bw.a.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.ui.base.o;
import java.util.Locale;

public class AutoFillListPopupWindowBase {
    ListAdapter Do;
    int MU;
    int PM;
    int PN;
    int PO;
    boolean PQ;
    boolean PR;
    boolean PS;
    int PT;
    private View PU;
    private int PV;
    View PW;
    private Drawable PX;
    private OnItemClickListener PY;
    private OnItemSelectedListener PZ;
    private Runnable Qe;
    boolean Qf;
    private Rect bJ;
    o eZB;
    a gKo;
    private final f gKp;
    private final e gKq;
    private final d gKr;
    private final b gKs;
    private boolean gKt;
    private Context mContext;
    private ag mHandler;
    DataSetObserver mObserver;

    public AutoFillListPopupWindowBase(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.listPopupWindowStyle);
    }

    public AutoFillListPopupWindowBase(Context context, AttributeSet attributeSet, int i) {
        this.PM = -2;
        this.MU = -2;
        this.PR = false;
        this.PS = false;
        this.PT = Integer.MAX_VALUE;
        this.PV = 0;
        this.gKp = new f(this, (byte) 0);
        this.gKq = new e(this, (byte) 0);
        this.gKr = new d(this, (byte) 0);
        this.gKs = new b(this, (byte) 0);
        this.mHandler = new ag();
        this.bJ = new Rect();
        this.gKt = false;
        this.mContext = context;
        this.eZB = new o(context);
        this.eZB.setInputMethodMode(1);
        Locale locale = this.mContext.getResources().getConfiguration().locale;
    }

    public final void setVerticalOffset(int i) {
        this.PO = i;
        this.PQ = true;
    }

    public void show() {
        int i;
        int i2;
        boolean z;
        boolean z2 = true;
        int i3 = -1;
        View frameLayout;
        if (this.gKo == null) {
            Context context = this.mContext;
            this.Qe = new Runnable() {
                public final void run() {
                    View view = AutoFillListPopupWindowBase.this.PW;
                    if (view != null && view.getWindowToken() != null) {
                        AutoFillListPopupWindowBase.this.show();
                    }
                }
            };
            this.gKo = new a(context, !this.Qf);
            if (this.PX != null) {
                this.gKo.setSelector(this.PX);
            }
            this.gKo.setAdapter(this.Do);
            this.gKo.setOnItemClickListener(this.PY);
            this.gKo.setFocusable(true);
            this.gKo.setFocusableInTouchMode(true);
            this.gKo.setDivider(null);
            this.gKo.setDividerHeight(0);
            this.gKo.setOnItemSelectedListener(new 2(this));
            this.gKo.setOnScrollListener(this.gKr);
            if (this.PZ != null) {
                this.gKo.setOnItemSelectedListener(this.PZ);
            }
            a aVar = this.gKo;
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
                        new StringBuilder("Invalid hint position ").append(this.PV);
                        break;
                }
                view.measure(MeasureSpec.makeMeasureSpec(this.MU, Integer.MIN_VALUE), 0);
            } else {
                frameLayout = aVar;
            }
            this.eZB.setContentView(frameLayout);
            i = 0;
        } else {
            this.eZB.getContentView();
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
            i5 = this.gKo.S(makeMeasureSpec, i5 - i);
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
                this.eZB.update(this.PW, this.PN, this.PO, this.eZB.getWidth(), this.eZB.getHeight());
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
        this.eZB.setTouchInterceptor(this.gKq);
        if (this.gKt) {
            this.eZB.showAtLocation(this.PW, 17, 0, 0);
        } else if (VERSION.SDK_INT >= 19) {
            this.eZB.showAsDropDown(this.PW, this.PN, this.PO, 53);
        } else {
            this.eZB.showAtLocation(this.PW, 53, this.PN, this.PO);
        }
        this.gKo.setSelection(-1);
        if (!this.Qf || this.gKo.isInTouchMode()) {
            clearListSelection();
        }
        if (!this.Qf) {
            this.mHandler.post(this.gKs);
        }
    }

    public final void dismiss() {
        this.eZB.dismiss();
        aqa();
        this.eZB.setContentView(null);
        this.gKo = null;
        this.mHandler.removeCallbacks(this.gKp);
    }

    private void aqa() {
        if (this.PU != null) {
            ViewParent parent = this.PU.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.PU);
            }
        }
    }

    public final void clearListSelection() {
        a aVar = this.gKo;
        if (aVar != null) {
            a.a(aVar, true);
            aVar.requestLayout();
        }
    }

    public final boolean isInputMethodNotNeeded() {
        return this.eZB.getInputMethodMode() == 2;
    }
}
