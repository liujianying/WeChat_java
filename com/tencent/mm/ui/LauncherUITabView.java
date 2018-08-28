package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.c.a;

public class LauncherUITabView extends RelativeLayout implements c {
    private Matrix aaw = new Matrix();
    protected int iQP = 0;
    private long kaR = 0;
    private a tkB;
    private int tkR = -1;
    protected OnClickListener tkT = new 1(this);
    private ag tkU = new 2(this);
    private int tkV = 0;
    private int tkW = 0;
    private int tkX = 0;
    private boolean tkY = false;
    private int tkZ = 0;
    private boolean tla = false;
    private int tlj;
    private Bitmap tlk;
    private ImageView tll;
    protected a tlm;
    protected a tln;
    protected a tlo;
    protected a tlp;

    public LauncherUITabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public LauncherUITabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public void setOnTabClickListener(a aVar) {
        this.tkB = aVar;
    }

    private a DJ(int i) {
        a aVar = new a(this);
        aVar.tlr = new MMTabView(getContext(), i);
        aVar.tlr.setTag(Integer.valueOf(i));
        aVar.tlr.setOnClickListener(this.tkT);
        return aVar;
    }

    private void init() {
        View linearLayout = new LinearLayout(getContext());
        linearLayout.setBackgroundResource(R.e.white);
        linearLayout.setId(2307141);
        linearLayout.setOrientation(0);
        addView(linearLayout, new LayoutParams(-1, -2));
        this.tll = new ImageView(getContext());
        this.tll.setImageMatrix(this.aaw);
        this.tll.setScaleType(ScaleType.MATRIX);
        this.tll.setId(2307142);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, com.tencent.mm.bp.a.fromDPToPix(getContext(), 3));
        layoutParams.addRule(8, 2307141);
        addView(this.tll, layoutParams);
        a DJ = DJ(0);
        DJ.tlr.setText(R.l.main_chat);
        ViewGroup.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(R.f.topTabbarHeight));
        layoutParams2.weight = 1.0f;
        linearLayout.addView(DJ.tlr, layoutParams2);
        this.tlm = DJ;
        DJ = DJ(1);
        DJ.tlr.setText(R.l.main_contact);
        layoutParams2 = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(R.f.topTabbarHeight));
        layoutParams2.weight = 1.0f;
        linearLayout.addView(DJ.tlr, layoutParams2);
        this.tln = DJ;
        DJ = DJ(2);
        DJ.tlr.setText(R.l.main_addcontact);
        layoutParams2 = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(R.f.topTabbarHeight));
        layoutParams2.weight = 1.0f;
        linearLayout.addView(DJ.tlr, layoutParams2);
        this.tlo = DJ;
        DJ = DJ(3);
        DJ.tlr.setText(R.l.main_more);
        layoutParams2 = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(R.f.topTabbarHeight));
        layoutParams2.weight = 1.0f;
        linearLayout.addView(DJ.tlr, layoutParams2);
        this.tlp = DJ;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        x.d("MicroMsg.LauncherUITabView", "on layout, width %d", new Object[]{Integer.valueOf(i3 - i)});
        this.tlj = (i3 - i) / 4;
        int i5 = this.tlj;
        if (this.tlk == null || this.tlk.getWidth() != i5) {
            String str = "MicroMsg.LauncherUITabView";
            String str2 = "sharp width changed, from %d to %d";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(this.tlk == null ? -1 : this.tlk.getWidth());
            objArr[1] = Integer.valueOf(i5);
            x.w(str, str2, objArr);
            this.tlk = Bitmap.createBitmap(i5, com.tencent.mm.bp.a.fromDPToPix(getContext(), 3), Config.ARGB_8888);
            new Canvas(this.tlk).drawColor(getResources().getColor(R.e.wechat_green));
            h(this.iQP, 0.0f);
            this.tll.setImageBitmap(this.tlk);
        }
        setTo(this.iQP);
    }

    public final void DD(int i) {
        x.d("MicroMsg.LauncherUITabView", "updateMainTabUnread %d", new Object[]{Integer.valueOf(i)});
        this.tkV = i;
        if (i <= 0) {
            this.tlm.tlr.setUnread(null);
        } else if (i > 99) {
            this.tlm.tlr.setUnread(getContext().getString(R.l.unread_count_overt_100));
        } else {
            this.tlm.tlr.setUnread(String.valueOf(i));
        }
    }

    public final void coM() {
        if (this.tlm != null && this.tln != null && this.tlo != null && this.tlp != null) {
            this.tlm.tlr.cqw();
            this.tln.tlr.cqw();
            this.tlo.tlr.cqw();
            this.tlp.tlr.cqw();
        }
    }

    public final void DE(int i) {
        this.tkW = i;
        if (i <= 0) {
            this.tln.tlr.setUnread(null);
        } else if (i > 99) {
            this.tln.tlr.setUnread(getContext().getString(R.l.unread_count_overt_100));
        } else {
            this.tln.tlr.setUnread(String.valueOf(i));
        }
    }

    public final void DF(int i) {
        this.tkX = i;
        if (i <= 0) {
            this.tlo.tlr.setUnread(null);
        } else if (i > 99) {
            this.tlo.tlr.setUnread(getContext().getString(R.l.unread_count_overt_100));
        } else {
            this.tlo.tlr.setUnread(String.valueOf(i));
        }
    }

    public final void DG(int i) {
        this.tkZ = i;
        if (i <= 0) {
            this.tlp.tlr.setUnread(null);
        } else if (i > 99) {
            this.tlp.tlr.setUnread(getContext().getString(R.l.unread_count_overt_100));
        } else {
            this.tlp.tlr.setUnread(String.valueOf(i));
        }
    }

    public final void ls(boolean z) {
        this.tkY = z;
        this.tlo.tlr.lF(z);
    }

    public final void lt(boolean z) {
        this.tla = z;
        this.tlp.tlr.lF(z);
    }

    public final void h(int i, float f) {
        this.aaw.setTranslate(((float) this.tlj) * (((float) i) + f), 0.0f);
        this.tll.setImageMatrix(this.aaw);
    }

    public int getCurIdx() {
        return this.iQP;
    }

    public void setTo(int i) {
        this.iQP = i;
        this.tlm.tlr.setTextColor(i == 0 ? getResources().getColorStateList(R.e.wechat_green) : getResources().getColorStateList(R.e.launcher_tab_text_selector));
        this.tln.tlr.setTextColor(i == 1 ? getResources().getColorStateList(R.e.wechat_green) : getResources().getColorStateList(R.e.launcher_tab_text_selector));
        this.tlo.tlr.setTextColor(i == 2 ? getResources().getColorStateList(R.e.wechat_green) : getResources().getColorStateList(R.e.launcher_tab_text_selector));
        this.tlp.tlr.setTextColor(i == 3 ? getResources().getColorStateList(R.e.wechat_green) : getResources().getColorStateList(R.e.launcher_tab_text_selector));
        this.kaR = System.currentTimeMillis();
        this.tkR = this.iQP;
    }

    public int getMainTabUnread() {
        return this.tkV;
    }

    public int getContactTabUnread() {
        return this.tkW;
    }

    public int getFriendTabUnread() {
        return this.tkX;
    }

    public int getSettingsTabUnread() {
        return this.tkZ;
    }

    public boolean getShowFriendPoint() {
        return this.tkY;
    }

    public boolean getSettingsPoint() {
        return this.tla;
    }
}
