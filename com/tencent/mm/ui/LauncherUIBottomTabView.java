package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.kiss.a.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.c.a;
import com.tencent.mm.ui.tools.r;

public class LauncherUIBottomTabView extends RelativeLayout implements c {
    protected int iQP = 0;
    private long kaR = 0;
    private a tkB;
    protected a tkC;
    protected a tkD;
    protected a tkE;
    protected a tkF;
    private int tkG = 0;
    private int tkH;
    private int tkI;
    private int tkJ;
    private int tkK = 0;
    private int tkL;
    private int tkM;
    private int tkN;
    private int tkO;
    private int tkP;
    private int tkQ;
    private int tkR = -1;
    private int tkS = 0;
    protected OnClickListener tkT = new 1(this);
    private ag tkU = new 2(this);
    private int tkV = 0;
    private int tkW = 0;
    private int tkX = 0;
    private boolean tkY = false;
    private int tkZ = 0;
    private boolean tla = false;

    public LauncherUIBottomTabView(Context context) {
        super(context);
        init();
    }

    public LauncherUIBottomTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public LauncherUIBottomTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public void setOnTabClickListener(a aVar) {
        this.tkB = aVar;
    }

    private a DI(int i) {
        a aVar = new a(this);
        if (com.tencent.mm.bp.a.fi(getContext())) {
            aVar.tlc = b.EY().a((Activity) getContext(), "R.layout.mm_bottom_tabitem_large", R.i.mm_bottom_tabitem_large);
        } else {
            aVar.tlc = b.EY().a((Activity) getContext(), "R.layout.mm_bottom_tabitem", R.i.mm_bottom_tabitem);
        }
        aVar.tld = (TabIconView) aVar.tlc.findViewById(R.h.icon_iv);
        aVar.tle = (TextView) aVar.tlc.findViewById(R.h.icon_tv);
        aVar.tlf = (TextView) aVar.tlc.findViewById(R.h.unread_tv);
        aVar.tlf.setBackgroundResource(r.hd(getContext()));
        aVar.tlg = (ImageView) aVar.tlc.findViewById(R.h.dot_iv);
        aVar.tlc.setTag(Integer.valueOf(i));
        aVar.tlc.setOnClickListener(this.tkT);
        aVar.tle.setTextSize(0, ((float) com.tencent.mm.bp.a.ae(getContext(), R.f.SmallestTextSize)) * com.tencent.mm.bp.a.fg(getContext()));
        return aVar;
    }

    private void init() {
        View linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        addView(linearLayout, new LayoutParams(-1, -2));
        this.tkS = (int) (((float) com.tencent.mm.bp.a.ae(getContext(), R.f.DefaultTabbarHeight)) * com.tencent.mm.bp.a.fg(getContext()));
        a DI = DI(0);
        DI.tlc.setId(-16777215);
        DI.tle.setText(R.l.main_title);
        DI.tle.setTextColor(getResources().getColor(R.e.navbar_text_focus));
        DI.tld.g(R.k.navbar_chat_icon_focus, R.k.navbar_chat_icon_middle, R.k.navbar_chat_icon_normal, com.tencent.mm.bp.a.fi(getContext()));
        DI.tlf.setVisibility(4);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, this.tkS);
        layoutParams.weight = 1.0f;
        linearLayout.addView(DI.tlc, layoutParams);
        this.tkC = DI;
        DI = DI(1);
        DI.tlc.setId(-16777214);
        DI.tle.setText(R.l.main_contact);
        DI.tle.setTextColor(getResources().getColor(R.e.navbar_text_normal));
        DI.tld.g(R.k.navbar_addresslist_icon_focus, R.k.navbar_addresslist_icon_middle, R.k.navbar_addresslist_icon_normal, com.tencent.mm.bp.a.fi(getContext()));
        DI.tlf.setVisibility(4);
        layoutParams = new LinearLayout.LayoutParams(0, this.tkS);
        layoutParams.weight = 1.0f;
        linearLayout.addView(DI.tlc, layoutParams);
        this.tkE = DI;
        DI = DI(2);
        DI.tlc.setId(-16777213);
        DI.tle.setText(R.l.main_addcontact);
        DI.tle.setTextColor(getResources().getColor(R.e.navbar_text_normal));
        DI.tld.g(R.k.navbar_discovery_icon_focus, R.k.navbar_discovery_icon_middle, R.k.navbar_discovery_icon_normal, com.tencent.mm.bp.a.fi(getContext()));
        DI.tlf.setVisibility(4);
        layoutParams = new LinearLayout.LayoutParams(0, this.tkS);
        layoutParams.weight = 1.0f;
        linearLayout.addView(DI.tlc, layoutParams);
        this.tkD = DI;
        DI = DI(3);
        DI.tlc.setId(-16777212);
        DI.tle.setText(R.l.main_more);
        DI.tle.setTextColor(getResources().getColor(R.e.navbar_text_normal));
        DI.tld.g(R.k.navbar_me_icon_focus, R.k.navbar_me_icon_middle, R.k.navbar_me_icon_normal, com.tencent.mm.bp.a.fi(getContext()));
        DI.tlf.setVisibility(4);
        layoutParams = new LinearLayout.LayoutParams(0, this.tkS);
        layoutParams.weight = 1.0f;
        linearLayout.addView(DI.tlc, layoutParams);
        this.tkF = DI;
        this.tkG = getResources().getColor(R.e.navbar_text_focus);
        this.tkH = (this.tkG & 16711680) >> 16;
        this.tkI = (this.tkG & 65280) >> 8;
        this.tkJ = this.tkG & 255;
        this.tkK = getResources().getColor(R.e.navbar_text_normal);
        this.tkL = (this.tkK & 16711680) >> 16;
        this.tkM = (this.tkK & 65280) >> 8;
        this.tkN = this.tkK & 255;
        this.tkO = this.tkH - this.tkL;
        this.tkP = this.tkI - this.tkM;
        this.tkQ = this.tkJ - this.tkN;
    }

    public final void DD(int i) {
        x.d("MicroMsg.LauncherUITabView", "updateMainTabUnread %d", new Object[]{Integer.valueOf(i)});
        this.tkV = i;
        if (i <= 0) {
            this.tkC.tlf.setText("");
            this.tkC.tlf.setVisibility(4);
        } else if (i > 99) {
            this.tkC.tlf.setText(getContext().getString(R.l.unread_count_overt_100));
            this.tkC.tlf.setVisibility(0);
            this.tkC.tlg.setVisibility(4);
        } else {
            this.tkC.tlf.setText(String.valueOf(i));
            this.tkC.tlf.setVisibility(0);
            this.tkC.tlg.setVisibility(4);
        }
    }

    public final void coM() {
        if (this.tkC != null && this.tkE != null && this.tkD != null) {
        }
    }

    public final void DE(int i) {
        this.tkW = i;
        if (i <= 0) {
            this.tkE.tlf.setText("");
            this.tkE.tlf.setVisibility(4);
        } else if (i > 99) {
            this.tkE.tlf.setText(getContext().getString(R.l.unread_count_overt_100));
            this.tkE.tlf.setVisibility(0);
            this.tkE.tlg.setVisibility(4);
        } else {
            this.tkE.tlf.setText(String.valueOf(i));
            this.tkE.tlf.setVisibility(0);
            this.tkE.tlg.setVisibility(4);
        }
    }

    public final void DF(int i) {
        this.tkX = i;
        if (i <= 0) {
            this.tkD.tlf.setText("");
            this.tkD.tlf.setVisibility(4);
        } else if (i > 99) {
            this.tkD.tlf.setText(getContext().getString(R.l.unread_count_overt_100));
            this.tkD.tlf.setVisibility(0);
            this.tkD.tlg.setVisibility(4);
        } else {
            this.tkD.tlf.setText(String.valueOf(i));
            this.tkD.tlf.setVisibility(0);
            this.tkD.tlg.setVisibility(4);
        }
    }

    public final void ls(boolean z) {
        int i = 4;
        this.tkY = z;
        this.tkD.tlf.setVisibility(4);
        ImageView imageView = this.tkD.tlg;
        if (z) {
            i = 0;
        }
        imageView.setVisibility(i);
    }

    public final void DG(int i) {
        this.tkZ = i;
        if (i <= 0) {
            this.tkF.tlf.setText("");
            this.tkF.tlf.setVisibility(4);
        } else if (i > 99) {
            this.tkF.tlf.setText(getContext().getString(R.l.unread_count_overt_100));
            this.tkF.tlf.setVisibility(0);
            this.tkF.tlg.setVisibility(4);
        } else {
            this.tkF.tlf.setText(String.valueOf(i));
            this.tkF.tlf.setVisibility(0);
            this.tkF.tlg.setVisibility(4);
        }
    }

    public final void lt(boolean z) {
        int i = 4;
        this.tla = z;
        this.tkF.tlf.setVisibility(4);
        ImageView imageView = this.tkF.tlg;
        if (z) {
            i = 0;
        }
        imageView.setVisibility(i);
    }

    public final void h(int i, float f) {
        int i2 = (int) (255.0f * f);
        int i3 = 255 - i2;
        int i4 = (((((int) ((((float) this.tkO) * f) + ((float) this.tkL))) << 16) + (((int) ((((float) this.tkP) * f) + ((float) this.tkM))) << 8)) + ((int) ((((float) this.tkQ) * f) + ((float) this.tkN)))) - 16777216;
        int i5 = (((((int) ((((float) this.tkO) * (1.0f - f)) + ((float) this.tkL))) << 16) + (((int) ((((float) this.tkP) * (1.0f - f)) + ((float) this.tkM))) << 8)) + ((int) ((((float) this.tkQ) * (1.0f - f)) + ((float) this.tkN)))) - 16777216;
        switch (i) {
            case 0:
                this.tkC.tld.setFocusAlpha(i3);
                this.tkE.tld.setFocusAlpha(i2);
                this.tkC.tle.setTextColor(i5);
                this.tkE.tle.setTextColor(i4);
                return;
            case 1:
                this.tkE.tld.setFocusAlpha(i3);
                this.tkD.tld.setFocusAlpha(i2);
                this.tkE.tle.setTextColor(i5);
                this.tkD.tle.setTextColor(i4);
                return;
            case 2:
                this.tkD.tld.setFocusAlpha(i3);
                this.tkF.tld.setFocusAlpha(i2);
                this.tkD.tle.setTextColor(i5);
                this.tkF.tle.setTextColor(i4);
                return;
            default:
                return;
        }
    }

    public int getCurIdx() {
        return this.iQP;
    }

    public void setTo(int i) {
        this.iQP = i;
        switch (i) {
            case 0:
                this.tkC.tld.setFocusAlpha(255);
                this.tkD.tld.setFocusAlpha(0);
                this.tkE.tld.setFocusAlpha(0);
                this.tkF.tld.setFocusAlpha(0);
                this.tkC.tle.setTextColor(this.tkG);
                this.tkD.tle.setTextColor(this.tkK);
                this.tkE.tle.setTextColor(this.tkK);
                this.tkF.tle.setTextColor(this.tkK);
                break;
            case 1:
                this.tkC.tld.setFocusAlpha(0);
                this.tkD.tld.setFocusAlpha(0);
                this.tkE.tld.setFocusAlpha(255);
                this.tkF.tld.setFocusAlpha(0);
                this.tkC.tle.setTextColor(this.tkK);
                this.tkD.tle.setTextColor(this.tkK);
                this.tkE.tle.setTextColor(this.tkG);
                this.tkF.tle.setTextColor(this.tkK);
                break;
            case 2:
                this.tkC.tld.setFocusAlpha(0);
                this.tkD.tld.setFocusAlpha(255);
                this.tkE.tld.setFocusAlpha(0);
                this.tkF.tld.setFocusAlpha(0);
                this.tkC.tle.setTextColor(this.tkK);
                this.tkD.tle.setTextColor(this.tkG);
                this.tkE.tle.setTextColor(this.tkK);
                this.tkF.tle.setTextColor(this.tkK);
                break;
            case 3:
                this.tkC.tld.setFocusAlpha(0);
                this.tkD.tld.setFocusAlpha(0);
                this.tkE.tld.setFocusAlpha(0);
                this.tkF.tld.setFocusAlpha(255);
                this.tkC.tle.setTextColor(this.tkK);
                this.tkD.tle.setTextColor(this.tkK);
                this.tkE.tle.setTextColor(this.tkK);
                this.tkF.tle.setTextColor(this.tkG);
                break;
        }
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
