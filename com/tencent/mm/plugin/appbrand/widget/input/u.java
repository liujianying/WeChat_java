package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.plugin.appbrand.s.i;
import com.tencent.mm.plugin.appbrand.ui.j;
import com.tencent.mm.plugin.appbrand.widget.input.s.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

public class u extends LinearLayout implements a {
    private static final int fDq = g.app_brand_keyboard_smiley;
    private static final b gIr = new f((byte) 0);
    private MMActivity bGc;
    private final Runnable gIe = new 1(this);
    private d gIf;
    private c gIg;
    private boolean gIh = false;
    private e gIi;
    private AppBrandSmileyPanel gIj;
    private View gIk;
    private ImageButton gIl;
    private boolean gIm;
    private View gIn;
    private boolean gIo;
    public EditText gIp;
    private int gIq = 0;
    private int state = 2;

    public interface c {
        void dn(boolean z);
    }

    public static u cb(View view) {
        return (u) view.getRootView().findViewById(fDq);
    }

    public static u cc(View view) {
        l bV = l.bV(view);
        if (bV.getOnLayoutListener() == null || !(bV.getOnLayoutListener() instanceof s)) {
            bV.setOnLayoutListener(new s());
        }
        u cb = cb(view);
        if (cb != null) {
            return cb;
        }
        View uVar = new u(view.getContext());
        bV.bW(uVar);
        return uVar;
    }

    public final void ma(int i) {
        gIr.c(this, i);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        x.v("MicroMsg.AppBrandSoftKeyboardPanel", "[scrollUp] SoftKeyboardPanel onLayout measuredHeight = %d", new Object[]{Integer.valueOf(getMeasuredHeight())});
    }

    public final void dp(boolean z) {
        x.d("MicroMsg.AppBrandSoftKeyboardPanel", "onKeyboardStateChanged, kbShown = %b", new Object[]{Boolean.valueOf(z)});
        if (z) {
            md(0);
            hideSmileyPanel();
        } else if (!isShown()) {
        } else {
            if (this.gIm && 1 == this.state) {
                apI();
            } else {
                hide();
            }
        }
    }

    private void setPanelHeightImpl(int i) {
        Object obj;
        AppBrandSmileyPanel appBrandSmileyPanel = this.gIj;
        if (i <= 0 || appBrandSmileyPanel.gId == i) {
            obj = null;
        } else {
            appBrandSmileyPanel.gId = i;
            obj = 1;
        }
        if (obj != null) {
            this.gIe.run();
        }
    }

    public int getMinimumHeight() {
        return getVisibility() == 0 ? com.tencent.mm.bp.a.fromDPToPix(getContext(), 48) : 0;
    }

    public void setOnSmileyChosenListener(d dVar) {
        this.gIf = dVar;
    }

    public void setOnDoneListener(c cVar) {
        this.gIg = cVar;
    }

    protected final void dn(boolean z) {
        if (!this.gIh && this.gIg != null) {
            this.gIh = true;
            this.gIg.dn(z);
            this.gIh = false;
        }
    }

    public void setOnVisibilityChangedListener(e eVar) {
        this.gIi = eVar;
    }

    public u(Context context) {
        super(context);
        this.bGc = (MMActivity) context;
        super.setId(fDq);
        setOrientation(1);
        View ahq = ahq();
        this.gIk = ahq;
        addView(ahq);
        this.gIj = new AppBrandSmileyPanel(getContext());
        this.gIj.setVisibility(8);
        this.gIj.setBackgroundColor(0);
        this.gIj.setOnTextOperationListener(new 4(this));
        addView(this.gIj);
        aho();
    }

    public void setId(int i) {
    }

    public final void mb(int i) {
        super.setId(i);
    }

    public <T extends View & a> T ahq() {
        T gVar = new g(getContext());
        Drawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842913}, ad.getResources().getDrawable(i.textfield_icon_emoji_pressed));
        stateListDrawable.addState(new int[0], ad.getResources().getDrawable(i.textfield_icon_emoji_normal));
        this.gIl = (ImageButton) gVar.findViewById(g.smiley_toolbar_switcher_image);
        this.gIl.setSelected(false);
        this.gIl.setImageDrawable(stateListDrawable);
        this.gIl.setOnClickListener(new 2(this));
        this.gIn = gVar.findViewById(g.smiley_toolbar_done);
        this.gIn.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                u.this.dn(true);
            }
        });
        return gVar;
    }

    private void apF() {
        ((s) l.bV(this).getOnLayoutListener()).gHS = this;
    }

    private void apG() {
        ((s) l.bV(this).getOnLayoutListener()).gHS = null;
    }

    private void mc(int i) {
        post(new 5(this, i, this.gIh));
    }

    private void apH() {
        hideSmileyPanel();
        if (this.gIp != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.gIp.getContext().getSystemService("input_method");
            if (!inputMethodManager.showSoftInput(this.gIp, 1)) {
                inputMethodManager.showSoftInput(this.gIp, 2);
                return;
            }
            return;
        }
        this.bGc.showVKB();
    }

    private void apI() {
        gIr.l(this);
        if (this.gIl != null) {
            this.gIl.setSelected(true);
        }
        mc(1);
    }

    private void hideSmileyPanel() {
        gIr.k(this);
        if (this.gIl != null) {
            this.gIl.setSelected(false);
        }
        mc(0);
    }

    public void aho() {
        boolean z = false;
        if (this.gIk != null) {
            a aVar = (a) this.gIk;
            if (((!this.gIm ? 1 : 0) & (!this.gIo ? 1 : 0)) != 0 || j.bM(this)) {
                z = true;
            }
            aVar.setIsHide(z);
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        x.d("MicroMsg.AppBrandSoftKeyboardPanel", "smileyPanelWrapper, onMeasure");
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        apF();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        md(8);
        if (this.bGc != null) {
            if (this.gIp != null) {
                this.bGc.hideVKB(this.gIp);
            } else {
                this.bGc.YC();
            }
        }
        AppBrandSmileyPanel appBrandSmileyPanel = this.gIj;
        com.tencent.mm.plugin.appbrand.widget.input.panel.c cVar = appBrandSmileyPanel.gKF;
        cVar.gKX = null;
        cVar.gKE = null;
        if (appBrandSmileyPanel.FU != null) {
            ((ViewGroup) appBrandSmileyPanel.FU.getParent()).removeView(appBrandSmileyPanel.FU);
            ((ViewGroup) appBrandSmileyPanel.FU).removeAllViews();
            appBrandSmileyPanel.FU = null;
        }
        appBrandSmileyPanel.gKS = null;
        if (this.gIl != null) {
            this.gIl.setOnClickListener(null);
        }
        this.gIf = null;
        removeAllViews();
        this.bGc = null;
        apG();
    }

    public void setVisibility(int i) {
        if (i == 8) {
            if (getVisibility() != i) {
                dn(false);
            }
            hide();
        } else if (i == 0) {
            show();
        } else {
            md(i);
        }
    }

    final void md(int i) {
        if (i == 0 && j.bM(this)) {
            i = 8;
        }
        if (getVisibility() != i) {
            super.setVisibility(i);
            if (i == 0) {
                apF();
            } else {
                apG();
            }
        }
    }

    public void setCanSmileyInput(boolean z) {
        int i = 0;
        this.gIm = false;
        if (this.gIl != null) {
            ImageButton imageButton = this.gIl;
            if (!this.gIm) {
                i = 4;
            }
            imageButton.setVisibility(i);
        }
        aho();
    }

    public void setShowDoneButton(boolean z) {
        this.gIo = z;
        if (this.gIn != null) {
            this.gIn.setVisibility(this.gIo ? 0 : 4);
        }
        aho();
    }

    public EditText getAttachedEditText() {
        return this.gIp;
    }

    public final void b(EditText editText) {
        if (editText == this.gIp) {
            this.gIp = null;
        }
    }

    public void ahp() {
        setCanSmileyInput(this.gIm);
        setShowDoneButton(this.gIo);
        aho();
    }

    public void show() {
        apH();
        ahp();
        if (!isShown()) {
            md(0);
        }
        setPanelHeightImpl(com.tencent.mm.compatible.util.j.fA(getContext()));
    }

    public final void hide() {
        if (isShown()) {
            md(8);
            if (!(this.bGc == null || this.bGc.mController.hideVKB())) {
                af.cg(this).hideSoftInputFromWindow(getWindowToken(), 0);
            }
            hideSmileyPanel();
        }
    }
}
