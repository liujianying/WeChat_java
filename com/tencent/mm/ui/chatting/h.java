package com.tencent.mm.ui.chatting;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ac.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.MMListPopupWindow;
import java.util.Iterator;
import java.util.List;

public final class h implements OnKeyListener, OnItemClickListener, OnDismissListener {
    private LayoutInflater Bc;
    private int height;
    private Context mContext = null;
    private int mCount;
    OnItemClickListener tHZ = null;
    private ViewGroup tIa = null;
    private b tIb = null;
    private MMListPopupWindow tIc;
    private int tId = R.m.UpMenuAnimation;
    private int tIe;
    j tIf = null;
    private boolean tIg = true;

    public static class a {
        private static DisplayMetrics tIh = null;

        public static a a(Context context, TextPaint textPaint, List<j> list, int i) {
            float f;
            a aVar = new a();
            if (tIh == null) {
                tIh = context.getResources().getDisplayMetrics();
            }
            DisplayMetrics displayMetrics = tIh;
            Point gu = ar.gu(context);
            int i2 = gu.x;
            if (!(i2 == displayMetrics.widthPixels && gu.y == displayMetrics.heightPixels)) {
                x.e("MicroMsg.ChatFooterCustomSubmenu", "get screen param error!! width:%s, systermWidth:%s, height:%s, systermHeight:%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(gu.y), Integer.valueOf(displayMetrics.heightPixels)});
            }
            float f2 = 0.0f;
            Iterator it = list.iterator();
            while (true) {
                f = f2;
                if (!it.hasNext()) {
                    break;
                }
                f2 = textPaint.measureText(((j) it.next()).name);
                if (f >= f2) {
                    f2 = f;
                }
            }
            int fromDPToPix = (com.tencent.mm.bp.a.fromDPToPix(context, 30) * 2) + ((int) f);
            int fromDPToPix2 = com.tencent.mm.bp.a.fromDPToPix(context, 95);
            if (fromDPToPix >= fromDPToPix2) {
                fromDPToPix2 = fromDPToPix;
            }
            if (i - (fromDPToPix2 / 2) < 0) {
                aVar.gLh = 0;
                aVar.gLi = i2 - (fromDPToPix2 + 0);
            } else if (i2 - ((fromDPToPix2 / 2) + i) < 0) {
                aVar.gLh = i2 - (fromDPToPix2 + 0);
                aVar.gLi = 0;
            } else {
                aVar.gLh = i - (fromDPToPix2 / 2);
                aVar.gLi = i2 - ((fromDPToPix2 / 2) + i);
            }
            return aVar;
        }
    }

    public h(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.tIa = viewGroup;
        this.Bc = (LayoutInflater) context.getSystemService("layout_inflater");
        ctb();
        this.tIb = new b(this, (byte) 0);
    }

    @SuppressLint({"WrongCall"})
    public final boolean a(j jVar, int i, int i2) {
        if (isShowing() || jVar == null || jVar.dMj == null || jVar.dMj.size() <= 0) {
            return false;
        }
        this.tIg = false;
        this.tIf = jVar;
        this.mCount = jVar.dMj.size();
        this.tIb.notifyDataSetChanged();
        this.height = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getHeight();
        a a = a.a(this.mContext, ((TextView) ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(R.i.popup_submenu_item, null)).getPaint(), jVar.dMj, i);
        this.tIe = (i2 - (this.tIb.getCount() * this.mContext.getResources().getDimensionPixelSize(R.f.SmallListHeight))) - this.mContext.getResources().getDimensionPixelSize(R.f.FooterPadding);
        x.d("MicroMsg.ChatFooterCustomSubmenu", "showPointY=" + i2 + "verticalOffset=" + this.tIe);
        this.tIc = new MMListPopupWindow(this.mContext, null, 0);
        this.tIc.setOnDismissListener(this);
        this.tIc.PY = this.tHZ;
        this.tIc.setAdapter(this.tIb);
        this.tIc.crA();
        this.tIc.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.g.sub_menu_bg));
        this.tIc.setAnimationStyle(this.tId);
        this.tIc.PN = a.gLi;
        this.tIc.setVerticalOffset(this.tIe);
        this.tIc.PW = this.tIa;
        this.tIc.setContentWidth(a(this.tIb));
        this.tIc.fo();
        this.tIc.show();
        this.tIc.tvU.setOnKeyListener(this);
        this.tIc.tvU.setDivider(new ColorDrawable(this.mContext.getResources().getColor(R.e.small_line_color)));
        this.tIc.tvU.setSelector(this.mContext.getResources().getDrawable(R.g.popup_menu_selector));
        this.tIc.tvU.setDividerHeight(1);
        this.tIc.tvU.setVerticalScrollBarEnabled(false);
        this.tIc.tvU.setHorizontalScrollBarEnabled(false);
        return true;
    }

    public final boolean isShowing() {
        return this.tIc != null && this.tIc.eZB.isShowing();
    }

    public final boolean ctb() {
        if (!isShowing()) {
            return false;
        }
        this.tIc.dismiss();
        return true;
    }

    private int a(ListAdapter listAdapter) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        int i = 0;
        int i2 = 0;
        View view = null;
        int i3 = 0;
        while (i < count) {
            int itemViewType = listAdapter.getItemViewType(i);
            if (itemViewType != i2) {
                view = null;
            } else {
                itemViewType = i2;
            }
            if (this.tIa == null) {
                this.tIa = new FrameLayout(this.mContext);
            }
            view = listAdapter.getView(i, view, this.tIa);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i3 = Math.max(i3, view.getMeasuredWidth());
            i++;
            i2 = itemViewType;
        }
        return i3;
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        return false;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
    }

    public final void onDismiss() {
    }
}
