package com.tencent.mm.ui.widget.a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.map.lib.mapstructure.MapRouteSectionWithName;
import com.tencent.mm.bw.a.f;
import com.tencent.mm.bw.a.g;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.a;
import com.tencent.mm.ui.base.n.b;
import com.tencent.mm.ui.base.n.c;

public class d implements OnGlobalLayoutListener {
    private ViewTreeObserver Jd;
    private RecyclerView Sa;
    private int bottomSheetStyle;
    private View eS;
    public View ilW;
    public Context mContext;
    public boolean mqO;
    public c ofp;
    public com.tencent.mm.ui.base.n.d ofq;
    private l ofr;
    private boolean qgI;
    private boolean qgJ;
    public boolean qgK;
    public boolean qgL;
    private int tZa;
    private BottomSheetBehavior tZb;
    public a uAx;
    public b uAy;
    public a uJQ;
    private Dialog uJR;
    private com.tencent.mm.ui.base.n.d uJS;
    private l uJT;
    public Boolean uJU;
    private LinearLayout uJV;
    private LinearLayout uJW;
    private b uJX;
    private boolean uJY;
    private boolean uJZ;
    private boolean uKa;
    private int uKb;
    public ImageView uKc;
    private int uKd;
    private int uKe;
    private int uKf;
    private boolean uKg;
    private boolean uKh;
    public boolean uKi;
    private boolean uKj;
    public int uKk;
    private boolean uKl;

    public d(Context context, int i, boolean z) {
        this.uJU = Boolean.valueOf(false);
        this.uJY = false;
        this.uJZ = false;
        this.uKa = false;
        this.qgI = false;
        this.uKd = 4;
        this.uKe = this.uKd * 3;
        this.uKf = 6;
        this.mqO = false;
        this.uKh = false;
        this.qgL = false;
        this.uKi = false;
        this.uKj = false;
        this.uKk = 0;
        this.uKl = false;
        this.bottomSheetStyle = i;
        this.mContext = context;
        this.uKg = z;
        this.uKj = false;
        if (this.mContext instanceof Activity) {
            ViewGroup viewGroup = (ViewGroup) ((Activity) this.mContext).getWindow().getDecorView();
            if (viewGroup.getChildCount() > 0) {
                this.eS = viewGroup.getChildAt(0);
            } else {
                this.eS = viewGroup;
            }
        }
        co(this.mContext);
    }

    public d(Context context) {
        this.uJU = Boolean.valueOf(false);
        this.uJY = false;
        this.uJZ = false;
        this.uKa = false;
        this.qgI = false;
        this.uKd = 4;
        this.uKe = this.uKd * 3;
        this.uKf = 6;
        this.mqO = false;
        this.uKh = false;
        this.qgL = false;
        this.uKi = false;
        this.uKj = false;
        this.uKk = 0;
        this.uKl = false;
        this.bottomSheetStyle = 1;
        this.mContext = context;
        this.uKl = true;
        if (this.mContext instanceof Activity) {
            ViewGroup viewGroup = (ViewGroup) ((Activity) this.mContext).getWindow().getDecorView();
            if (viewGroup.getChildCount() > 0) {
                this.eS = viewGroup.getChildAt(0);
            } else {
                this.eS = viewGroup;
            }
        }
        co(this.mContext);
    }

    public void onGlobalLayout() {
        if (isShowing()) {
            View view = this.eS;
            if (view == null || !view.isShown()) {
                bzW();
            } else if (!isShowing()) {
            } else {
                if (this.qgI != bdK() || this.uKb != getRotation()) {
                    bzW();
                }
            }
        }
    }

    @SuppressLint({"WrongConstant"})
    private int getRotation() {
        if (this.mContext instanceof Activity) {
            return ((Activity) this.mContext).getWindow().getWindowManager().getDefaultDisplay().getRotation();
        }
        return 0;
    }

    private void co(Context context) {
        int ae;
        this.ofr = new l(context);
        this.uJT = new l(context);
        if (this.uKl) {
            this.uJR = new b(context);
        } else {
            this.uJR = new android.support.design.widget.c(context);
        }
        this.ilW = View.inflate(context, g.mm_bottom_sheet, null);
        this.uJV = (LinearLayout) this.ilW.findViewById(f.bottom_sheet_title);
        this.uJW = (LinearLayout) this.ilW.findViewById(f.bottom_sheet_footer);
        this.uKc = (ImageView) this.ilW.findViewById(f.deviderline);
        this.Sa = (RecyclerView) this.ilW.findViewById(f.bottom_sheet_menu_reccycleview);
        this.Sa.setHasFixedSize(true);
        this.qgI = bdK();
        if (this.bottomSheetStyle == 0) {
            if (this.qgI) {
                this.uKd = 7;
                this.uKe = this.uKd * 2;
                this.tZa = ap.ae(this.mContext, com.tencent.mm.bw.a.d.BottomSheetGridMaxHeight_Landscape) + ap.ae(this.mContext, com.tencent.mm.bw.a.d.grid_item_top_bottom_padding);
            } else {
                this.tZa = ap.ae(this.mContext, com.tencent.mm.bw.a.d.BottomSheetGridMaxHeight) + ap.ae(this.mContext, com.tencent.mm.bw.a.d.grid_item_top_bottom_padding);
            }
            if (this.uKg) {
                this.tZa += ap.ae(this.mContext, com.tencent.mm.bw.a.d.grid_item_top_bottom_padding);
            }
        } else if (this.bottomSheetStyle == 2) {
            this.uJZ = true;
            ae = ap.ae(this.mContext, com.tencent.mm.bw.a.d.bottomsheet_list_checkbox_item_height);
            if (this.qgI) {
                this.uKf = 2;
                this.tZa = ((int) (((double) ae) * 2.5d)) + ap.ae(this.mContext, com.tencent.mm.bw.a.d.bottomsheet_dividing_line_height);
            } else {
                this.uKf = 3;
                this.tZa = ((int) (((double) ae) * 3.5d)) + ap.ae(this.mContext, com.tencent.mm.bw.a.d.bottomsheet_dividing_line_height);
            }
            if (this.uKg) {
                this.tZa += ap.fromDPToPix(this.mContext, 88);
            }
        } else {
            this.uKa = true;
            ae = ap.ae(this.mContext, com.tencent.mm.bw.a.d.bottomsheet_list_item_height);
            if (this.qgI) {
                this.uKf = 4;
                this.tZa = ((int) (((double) ae) * 4.5d)) + ap.ae(this.mContext, com.tencent.mm.bw.a.d.bottomsheet_dividing_line_height);
            } else {
                this.uKf = 6;
                this.tZa = ((int) (((double) ae) * 6.5d)) + ap.ae(this.mContext, com.tencent.mm.bw.a.d.bottomsheet_dividing_line_height);
            }
            if (this.uKg) {
                this.tZa += ap.ae(this.mContext, com.tencent.mm.bw.a.d.grid_item_top_bottom_padding);
            }
            if (this.uKl) {
                ae = ap.fromDPToPix(this.mContext, 24);
                this.uKc.setPadding(ae, 0, ae, 0);
            }
        }
        if (this.uKg && this.uKc != null && this.uKj) {
            this.uKc.setVisibility(0);
        }
        if (this.bottomSheetStyle == 0) {
            this.Sa.setLayoutManager(new GridLayoutManager(this.uKd));
            int ae2 = ap.ae(this.mContext, com.tencent.mm.bw.a.d.grid_item_left_right_padding);
            ae = ap.ae(this.mContext, com.tencent.mm.bw.a.d.grid_item_top_bottom_padding);
            if (this.uKg) {
                ae = ap.fromDPToPix(this.mContext, 0);
            }
            this.Sa.setPadding(ae2, ae, ae2, 0);
        } else {
            this.Sa.setLayoutManager(new LinearLayoutManager());
        }
        this.uJX = new b(this);
        this.uJX.PY = new 1(this);
        this.Sa.setAdapter(this.uJX);
        this.Sa.setOverScrollMode(1);
        this.uJR.setContentView(this.ilW);
        if (!this.uKl) {
            this.tZb = BottomSheetBehavior.h((View) this.ilW.getParent());
            this.tZb.q(this.tZa);
            this.tZb.cD = new 2(this);
        }
        this.uJR.setOnDismissListener(new 3(this));
    }

    public final void dS(View view) {
        if (view != null) {
            this.uKg = true;
            if (this.uKc != null) {
                this.uKc.setVisibility(0);
            }
            if (this.uJV != null) {
                this.uJV.setVisibility(0);
                this.uJV.removeAllViews();
                this.uJV.setGravity(17);
                this.uJV.addView(view, -1, -2);
            }
        }
    }

    public final void i(CharSequence charSequence, int i) {
        if (this.uJV != null && this.uKg) {
            this.uJV.setVisibility(0);
            this.uJV.removeAllViews();
            this.uJV.setGravity(i);
            View inflate = LayoutInflater.from(this.mContext).inflate(g.mm_bottom_sheet_title_text, null);
            TextView textView = (TextView) inflate.findViewById(f.title_text);
            textView.setText(charSequence);
            textView.setGravity(i | 80);
            this.uJV.addView(inflate, -1, -2);
        }
    }

    public final void bXO() {
        this.qgI = bdK();
        this.uKb = getRotation();
        if (this.ofp != null) {
            this.ofp.a(this.ofr);
        }
        if (this.uJR != null) {
            int ae;
            LayoutParams layoutParams = (LayoutParams) this.ilW.getLayoutParams();
            int size = this.ofr.size();
            if (this.uJY) {
                size++;
            } else if (this.uJT.size() > 0) {
                size += this.uJT.size();
            }
            if (this.uKl) {
                ae = ap.ae(this.mContext, com.tencent.mm.bw.a.d.bottomsheet_list_item_height);
                if (this.uKg) {
                    this.tZa = (((int) (((double) ae) * 4.5d)) + ap.fromDPToPix(this.mContext, 132)) + ap.ae(this.mContext, com.tencent.mm.bw.a.d.bottomsheet_dividing_line_height);
                } else {
                    this.tZa = (int) (((double) ae) * 6.5d);
                }
            }
            if (this.bottomSheetStyle == 0) {
                if (this.uJX.getItemCount() > this.uKe) {
                    layoutParams.height = this.tZa;
                }
            } else if (size > this.uKf) {
                layoutParams.height = this.tZa;
            }
            if (this.qgI && this.eS != null) {
                Rect rect = new Rect();
                this.eS.getWindowVisibleDisplayFrame(rect);
                if (this.uKl) {
                    layoutParams.width = (int) ((((float) rect.right) * 1.0f) / 2.0f);
                    layoutParams.height = rect.bottom;
                    if (this.uKg) {
                        ae = ap.ae(this.mContext, com.tencent.mm.bw.a.d.bottomsheet_list_item_height);
                        if (size <= this.uKf) {
                            size = layoutParams.height - (size * ae);
                        } else {
                            size = layoutParams.height - ((int) (((double) ((float) ae)) * (((double) this.uKf) + 0.5d)));
                            if (size > ap.fromDPToPix(this.mContext, 150)) {
                                size -= ae;
                            }
                        }
                        if (this.uJV != null) {
                            this.uJV.setMinimumHeight(size);
                        }
                    }
                } else {
                    layoutParams.width = rect.right;
                }
            }
            this.ilW.setLayoutParams(layoutParams);
            if (!(this.uJT == null || this.uJX == null)) {
                this.uJX.RR.notifyChanged();
            }
            if (VERSION.SDK_INT >= 21) {
                this.uJR.getWindow().addFlags(Integer.MIN_VALUE);
            }
            if (this.qgJ && VERSION.SDK_INT >= 23 && this.uJR != null) {
                this.uJR.getWindow().getDecorView().setSystemUiVisibility(9216);
                this.uJR.getWindow().setStatusBarColor(0);
            }
            if (this.qgK) {
                this.uJR.getWindow().addFlags(1024);
            }
            if (this.qgL) {
                this.uJR.getWindow().setFlags(8, 8);
                this.uJR.getWindow().addFlags(131200);
                this.uJR.getWindow().getDecorView().setSystemUiVisibility(6);
            } else {
                this.uJR.getWindow().clearFlags(8);
                this.uJR.getWindow().clearFlags(131072);
                this.uJR.getWindow().clearFlags(MapRouteSectionWithName.kMaxRoadNameLength);
                this.uJR.getWindow().getDecorView().setSystemUiVisibility(0);
            }
            if (this.tZb != null) {
                this.tZb.cv = false;
            }
            if (this.uJQ != null) {
                this.uJR.setOnDismissListener(new 4(this));
            }
            if (this.eS != null) {
                boolean z = this.Jd == null;
                this.Jd = this.eS.getViewTreeObserver();
                if (z) {
                    this.Jd.addOnGlobalLayoutListener(this);
                }
            }
            this.uJR.show();
        }
    }

    public final void cAK() {
        if (this.uJR != null) {
            if (!(this.uJT == null || this.uJX == null)) {
                this.uJX.RR.notifyChanged();
            }
            this.uJR.show();
        }
    }

    public final void bzW() {
        if (this.Jd != null) {
            if (!this.Jd.isAlive()) {
                this.Jd = this.eS.getViewTreeObserver();
            }
            this.Jd.removeGlobalOnLayoutListener(this);
            this.Jd = null;
        }
        if (this.uJR != null) {
            if (this.tZb != null) {
                this.tZb.cv = true;
            }
            this.uJR.dismiss();
        }
    }

    public final boolean isShowing() {
        if (this.uJR == null || !this.uJR.isShowing()) {
            return false;
        }
        return true;
    }

    private boolean bdK() {
        return this.mContext.getResources().getConfiguration().orientation == 2;
    }
}
