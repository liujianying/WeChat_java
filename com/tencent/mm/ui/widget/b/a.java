package com.tencent.mm.ui.widget.b;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnKeyListener;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.mm.bw.a.c;
import com.tencent.mm.bw.a.e;
import com.tencent.mm.bw.a.g;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.base.MMListPopupWindow;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.o;

public class a implements OnKeyListener, OnItemClickListener, OnDismissListener {
    private static int uKO;
    private static int uKP;
    private static boolean uKQ = false;
    private LayoutInflater Bc;
    private DisplayMetrics bvm;
    private View kPa;
    private Context mContext = null;
    public d ofq;
    private l ofr;
    private MMListPopupWindow tIc;
    private View tZA = null;
    public OnDismissListener uCi;
    private a uKR = null;
    private o uKS;
    private int uKT;
    private boolean uKU = false;
    public View uKV;
    public OnCreateContextMenuListener uKW;
    public boolean uKX = false;

    public a(Context context, View view) {
        this.mContext = context;
        this.tZA = view;
        this.Bc = (LayoutInflater) context.getSystemService("layout_inflater");
        initView();
        cAM();
    }

    public a(Context context) {
        this.mContext = context;
        this.Bc = (LayoutInflater) context.getSystemService("layout_inflater");
        initView();
    }

    public final void c(View view, OnCreateContextMenuListener onCreateContextMenuListener, d dVar) {
        this.tZA = view;
        cAM();
        this.ofq = dVar;
        if (view instanceof AbsListView) {
            ao.r("registerForPopupMenu AbsListView", new Object[0]);
            ((AbsListView) view).setOnItemLongClickListener(new 1(this, onCreateContextMenuListener));
            return;
        }
        ao.r("registerForPopupMenu normal view", new Object[0]);
        view.setOnLongClickListener(new 2(this, onCreateContextMenuListener));
    }

    public final void a(View view, int i, long j, OnCreateContextMenuListener onCreateContextMenuListener, d dVar, int i2, int i3) {
        this.ofq = dVar;
        this.tZA = view;
        cAM();
        this.ofr.clear();
        ContextMenuInfo adapterContextMenuInfo = new AdapterContextMenuInfo(view, i, j);
        onCreateContextMenuListener.onCreateContextMenu(this.ofr, view, adapterContextMenuInfo);
        for (MenuItem menuItem : this.ofr.twb) {
            ((m) menuItem).twe = adapterContextMenuInfo;
        }
        if (i2 == 0 && i3 == 0) {
            bU(0, 0);
        } else {
            bU(i2, i3);
        }
    }

    public final void a(View view, OnCreateContextMenuListener onCreateContextMenuListener, d dVar, int i, int i2) {
        this.ofq = dVar;
        this.tZA = view;
        if (!(view instanceof TextView) && (i == 0 || i2 == 0)) {
            cAM();
        }
        this.ofr.clear();
        onCreateContextMenuListener.onCreateContextMenu(this.ofr, view, null);
        if (i == 0 && i2 == 0) {
            bU(0, 0);
        } else {
            bU(i, i2);
        }
    }

    private boolean fl(int i, int i2) {
        if (isShowing() || cAL()) {
            return false;
        }
        int itemViewType;
        if (this.uKW != null) {
            this.uKW.onCreateContextMenu(this.ofr, this.tZA, null);
        }
        int count = this.uKR.getCount() * this.mContext.getResources().getDimensionPixelSize(com.tencent.mm.bw.a.d.SmallListHeight);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(com.tencent.mm.bw.a.d.edgePadding);
        a aVar = this.uKR;
        int i3 = 0;
        View view = null;
        int i4 = 0;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
        int count2 = aVar.getCount();
        int i5 = 0;
        while (i5 < count2) {
            itemViewType = aVar.getItemViewType(i5);
            if (itemViewType != i4) {
                view = null;
            } else {
                itemViewType = i4;
            }
            view = aVar.getView(i5, view, new FrameLayout(this.mContext));
            if (view != null) {
                view.measure(makeMeasureSpec, makeMeasureSpec2);
                i3 = Math.max(i3, view.getMeasuredWidth());
            }
            i5++;
            i4 = itemViewType;
        }
        itemViewType = ap.ae(this.mContext, com.tencent.mm.bw.a.d.minMenuWidth);
        if (i3 >= itemViewType) {
            itemViewType = i3;
        }
        boolean z = true;
        if (this.ofr.size() >= 3) {
            z = false;
        }
        if (!this.uKU) {
            if (this.uKV != null) {
                this.uKV.setSelected(true);
            } else {
                this.tZA.setSelected(true);
            }
        }
        if (this.uKX) {
            fm(i, i2);
        } else {
            com.tencent.mm.ui.widget.b.b.a a = b.a(this.mContext, itemViewType, i, i2, count, dimensionPixelSize, z);
            this.uKT = i2 - this.mContext.getResources().getDimensionPixelSize(com.tencent.mm.bw.a.d.edgePadding);
            ao.s("showPointY=" + i2 + "verticalOffset=" + this.uKT, new Object[0]);
            this.tIc = new MMListPopupWindow(this.mContext, null, 0);
            this.tIc.setOnDismissListener(this);
            this.tIc.PY = new 3(this);
            this.tIc.setAdapter(this.uKR);
            this.tIc.crA();
            this.tIc.setBackgroundDrawable(this.mContext.getResources().getDrawable(e.sub_menu_bg));
            this.tIc.setAnimationStyle(a.uLa);
            this.tIc.PN = a.gLi;
            this.tIc.setVerticalOffset(a.ohR);
            this.tIc.PW = this.tZA;
            this.tIc.setContentWidth(itemViewType);
            this.tIc.fo();
            this.tIc.show();
            this.tIc.tvU.setOnKeyListener(this);
            this.tIc.tvU.setDivider(new ColorDrawable(this.mContext.getResources().getColor(c.small_line_color)));
            this.tIc.tvU.setSelector(this.mContext.getResources().getDrawable(e.popup_menu_selector));
            this.tIc.tvU.setDividerHeight(0);
            this.tIc.tvU.setVerticalScrollBarEnabled(false);
            this.tIc.tvU.setHorizontalScrollBarEnabled(false);
        }
        return true;
    }

    private void fm(int i, int i2) {
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(com.tencent.mm.bw.a.d.NormalPadding);
        int dimensionPixelOffset2 = this.mContext.getResources().getDimensionPixelOffset(com.tencent.mm.bw.a.d.LargePadding);
        this.uKS = new o(this.mContext);
        this.uKS.setWidth(-2);
        this.uKS.setHeight(-2);
        this.uKS.setBackgroundDrawable(this.mContext.getResources().getDrawable(e.sub_menu_bg));
        View linearLayout = new LinearLayout(this.mContext);
        linearLayout.setLayoutParams(new LayoutParams(-2, -2));
        linearLayout.setOrientation(0);
        linearLayout.setBackgroundColor(this.mContext.getResources().getColor(c.white));
        for (int i3 = 0; i3 < this.ofr.size(); i3++) {
            TextView textView = (TextView) this.Bc.inflate(g.horizontal_popup_item, null, false);
            textView.setBackground(this.mContext.getResources().getDrawable(e.popup_menu_selector));
            if (i3 == 0) {
                textView.setPadding(dimensionPixelOffset2, 0, dimensionPixelOffset, 0);
            } else if (i3 == this.ofr.size() - 1) {
                textView.setPadding(dimensionPixelOffset, 0, dimensionPixelOffset2, 0);
            }
            textView.setText(((MenuItem) this.ofr.twb.get(i3)).getTitle());
            textView.setOnClickListener(new 4(this, i3));
            linearLayout.addView(textView);
        }
        linearLayout.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
        int measuredHeight = linearLayout.getMeasuredHeight();
        this.uKS.setContentView(linearLayout);
        this.uKS.showAtLocation(this.tZA, 0, i, i2 - measuredHeight);
    }

    private boolean isShowing() {
        return this.tIc != null && this.tIc.eZB.isShowing();
    }

    private boolean cAL() {
        return this.uKS != null && this.uKS.isShowing();
    }

    public final boolean ctb() {
        if (isShowing()) {
            if (this.tIc == null) {
                return true;
            }
            this.tIc.dismiss();
            return true;
        } else if (!cAL()) {
            return false;
        } else {
            if (this.uKS == null) {
                return true;
            }
            this.uKS.dismiss();
            return true;
        }
    }

    public boolean bU(int i, int i2) {
        int i3;
        if (!((this.tZA.equals(this.kPa) && uKQ) || (i == 0 && i2 == 0))) {
            uKO = i;
            uKP = i2;
        }
        this.kPa = null;
        int i4 = uKO;
        int i5 = uKP;
        uKQ = false;
        if (this.bvm == null) {
            this.bvm = this.mContext.getResources().getDisplayMetrics();
        }
        if (this.tZA != null) {
            int[] iArr = new int[2];
            this.tZA.getLocationOnScreen(iArr);
            if (i4 == 0) {
                i4 = iArr[0] + (this.tZA.getWidth() / 2);
            }
            i3 = iArr[1];
            int height = iArr[1] + this.tZA.getHeight();
            if (i3 < 0) {
                i3 = 0;
            }
            if (height > this.bvm.heightPixels) {
                height = this.bvm.heightPixels;
            }
            if (i5 == 0) {
                i3 = (i3 + height) / 2;
                ao.t("show popMenu , xDown:%s, yDown:%s, showPointX:%s, showPointY:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i3)});
                if (isShowing() || !cAL()) {
                    return fl(i4, i3);
                }
                return fl(i4, i3) & ctb();
            }
        }
        i3 = i5;
        ao.t("show popMenu , xDown:%s, yDown:%s, showPointX:%s, showPointY:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i3)});
        if (isShowing()) {
        }
        return fl(i4, i3);
    }

    private void initView() {
        ctb();
        this.ofr = new l(this.mContext);
        this.uKR = new a(this, (byte) 0);
        this.bvm = this.mContext.getResources().getDisplayMetrics();
    }

    private void cAM() {
        this.tZA.setOnTouchListener(new 5(this));
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        return false;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
    }

    public void onDismiss() {
        if (!this.uKU) {
            if (this.uKV != null) {
                this.uKV.setSelected(false);
            } else {
                this.tZA.setSelected(false);
            }
        }
        if (this.uCi != null) {
            this.uCi.onDismiss();
        }
    }
}
