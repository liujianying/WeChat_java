package com.tencent.mm.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.Switch;
import com.tencent.mm.api.b;
import com.tencent.mm.api.d;
import com.tencent.mm.api.n;
import com.tencent.mm.api.o;
import com.tencent.mm.bd.a.c;
import com.tencent.mm.bd.a.e;
import com.tencent.mm.bd.a.f;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.ak;
import com.tencent.mm.view.footer.SelectColorBar;

public abstract class a extends b implements OnGlobalLayoutListener {
    private com.tencent.mm.bi.b bBn;
    private com.tencent.mm.view.b.a bwB;
    private com.tencent.mm.api.m.a bwU;
    public boolean bwY = true;
    private View gxg;
    private Button iRz;
    private Button lqN;
    protected d[] uSp;
    private View uSq;
    private com.tencent.mm.view.footer.a uSr;
    private View uSs;
    private View uSt;
    public ChatFooterPanel uSu;
    private PhotoEditText uSv;
    private Switch uSw;
    private boolean uSx = true;

    protected abstract com.tencent.mm.view.b.a cBZ();

    protected abstract com.tencent.mm.view.footer.a cCa();

    public abstract d[] getFeatures();

    public a(Context context, com.tencent.mm.api.m.a aVar) {
        super(context);
        this.bwU = aVar;
        getPresenter().a(getConfig());
        removeAllViews();
        addView(getBaseBoardView(), new LayoutParams(-1, -1));
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, (int) getResources().getDimension(c.feature_select_all_layout_height));
        layoutParams.gravity = 80;
        addView(getFooterBg(), layoutParams);
        addView(getBaseFooterView(), layoutParams);
        layoutParams = new LayoutParams(-1, -1);
        getTextEditView().setVisibility(8);
        addView(getTextEditView(), layoutParams);
        getViewTreeObserver().addOnGlobalLayoutListener(this);
        layoutParams = new LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        getRubbishView().setVisibility(8);
        addView(getRubbishView(), layoutParams);
        layoutParams = new LayoutParams(-1, (int) getResources().getDimension(c.emoji_feature_layout_height));
        layoutParams.gravity = 80;
        addView(getChatFooterPanel(), layoutParams);
        new LayoutParams(-1, (int) getResources().getDimension(c.DefaultActionbarHeightLand)).gravity = 48;
        if (this.bwU.bwY) {
            addView(getActionBar());
        }
    }

    public com.tencent.mm.api.m.a getConfig() {
        return this.bwU;
    }

    public <T extends com.tencent.mm.view.footer.a> T getBaseFooterView() {
        if (this.uSr == null) {
            this.uSr = cCa();
        }
        return this.uSr;
    }

    public <T extends com.tencent.mm.view.b.a> T getBaseBoardView() {
        if (this.bwB == null) {
            this.bwB = cBZ();
        }
        return this.bwB;
    }

    public View getFooterBg() {
        if (this.uSq == null) {
            this.uSq = LayoutInflater.from(getContext()).inflate(f.footer_bg_view, null);
            this.uSq.setVisibility(0);
        }
        return this.uSq;
    }

    public View getActionBar() {
        if (this.gxg == null) {
            int gv;
            this.gxg = LayoutInflater.from(getContext()).inflate(f.photoedit_actionbar_view, null);
            if (ak.gw(getContext())) {
                gv = ak.gv(getContext()) + 0;
            } else {
                gv = 0;
            }
            this.gxg.setPadding(0, gv, 0, 0);
            this.lqN = (Button) this.gxg.findViewById(e.edit_text_ok);
            this.lqN.setOnClickListener(new 1(this));
            this.iRz = (Button) this.gxg.findViewById(e.edit_text_cancel);
            this.iRz.setOnClickListener(new 6(this));
        }
        return this.gxg;
    }

    public View getTextEditView() {
        if (this.uSs == null) {
            this.uSs = LayoutInflater.from(getContext()).inflate(f.edit_text_view, null);
            this.uSv = (PhotoEditText) this.uSs.findViewById(e.text_edit);
            SelectColorBar selectColorBar = (SelectColorBar) this.uSs.findViewById(e.select_color_bar);
            this.uSw = (Switch) this.uSs.findViewById(e.bg_switch);
            this.uSw.setTag(Integer.valueOf(-707825));
            this.uSw.setOnCheckedChangeListener(new 7(this, selectColorBar));
            this.uSv.setTextColor(-1);
            selectColorBar.setSelectColor(-1);
            selectColorBar.setSelectColorListener(new 8(this));
        }
        return this.uSs;
    }

    public View getRubbishView() {
        if (this.uSs == null) {
            this.uSt = LayoutInflater.from(getContext()).inflate(f.rubbish_view, null);
        }
        return this.uSt;
    }

    public ChatFooterPanel getChatFooterPanel() {
        boolean z = false;
        if (this.uSu == null) {
            try {
                this.uSu = o.bxf.aS(getContext());
                this.uSu.setEntranceScene(ChatFooterPanel.qFf);
                this.uSu.setBackgroundResource(com.tencent.mm.bd.a.d.bottombar_bg);
                this.uSu.uo();
                this.uSu.aE(true);
                this.uSu.i(true, true);
                this.uSu.setVisibility(8);
                this.uSu.onResume();
                n ur = o.bxf.ur();
                ur.bxe = new 9(this);
                this.uSu.setCallback(ur);
            } catch (Exception e) {
                String str = "MicroMsg.BaseDrawingView";
                String str2 = "exception:%s,getContext() is null?";
                Object[] objArr = new Object[2];
                objArr[0] = e.getMessage();
                if (getContext() == null) {
                    z = true;
                }
                objArr[1] = Boolean.valueOf(z);
                x.e(str, str2, objArr);
                throw e;
            }
        }
        return this.uSu;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        post(new 10(this));
    }

    public com.tencent.mm.bi.b getPresenter() {
        if (this.bBn == null) {
            this.bBn = new com.tencent.mm.bi.a();
            this.bBn.a(this);
        }
        return this.bBn;
    }

    public void setActionBarCallback(com.tencent.mm.api.e eVar) {
        getPresenter().setActionBarCallback(eVar);
    }

    public void setAutoShowFooterAndBar(boolean z) {
        getPresenter().setAutoShowFooterAndBar(z);
    }

    public void setFooterVisible(boolean z) {
        if (this.uSx != z) {
            getBaseFooterView().setFooterVisible(z);
            setFooterBgVisible(z);
            this.uSx = z;
        }
    }

    public void setActionBarVisible(boolean z) {
        if (this.bwY == z) {
            x.w("MicroMsg.BaseDrawingView", "[setActionBarVisible] isShowActionBar == isShow");
            return;
        }
        this.bwY = z;
        Animation loadAnimation;
        if (z) {
            loadAnimation = AnimationUtils.loadAnimation(getContext(), com.tencent.mm.bd.a.a.alpha_in);
            loadAnimation.setAnimationListener(new 11(this));
            getActionBar().startAnimation(loadAnimation);
            return;
        }
        loadAnimation = AnimationUtils.loadAnimation(getContext(), com.tencent.mm.bd.a.a.alpha_out);
        loadAnimation.setAnimationListener(new 12(this));
        getActionBar().startAnimation(loadAnimation);
    }

    public void setFooterBgVisible(boolean z) {
        Animation loadAnimation;
        if (z) {
            loadAnimation = AnimationUtils.loadAnimation(getContext(), com.tencent.mm.bd.a.a.alpha_in);
            loadAnimation.setAnimationListener(new 13(this));
            getActionBar().startAnimation(loadAnimation);
            return;
        }
        loadAnimation = AnimationUtils.loadAnimation(getContext(), com.tencent.mm.bd.a.a.alpha_out);
        loadAnimation.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                a.this.getFooterBg().setVisibility(8);
                a.this.getActionBar().setVisibility(8);
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        getActionBar().startAnimation(loadAnimation);
    }

    public final void mK(boolean z) {
        x.i("MicroMsg.BaseDrawingView", "[hideSimleyPanel] isHide:%s", new Object[]{Boolean.valueOf(z)});
        Animation loadAnimation;
        if (this.uSu.getVisibility() == 0 && z) {
            this.uSu.setVisibility(8);
            loadAnimation = AnimationUtils.loadAnimation(getContext(), com.tencent.mm.bd.a.a.push_down_out);
            loadAnimation.setAnimationListener(new AnimationListener() {
                public final void onAnimationStart(Animation animation) {
                    a.this.uSu.setVisibility(0);
                }

                public final void onAnimationEnd(Animation animation) {
                    a.this.uSu.setVisibility(8);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
            this.uSu.startAnimation(loadAnimation);
        } else if (this.uSu.getVisibility() == 8 && !z) {
            loadAnimation = AnimationUtils.loadAnimation(getContext(), com.tencent.mm.bd.a.a.push_up_in);
            loadAnimation.setAnimationListener(new 4(this));
            this.uSu.startAnimation(loadAnimation);
        }
    }

    public void onGlobalLayout() {
        if (getTextEditView().getVisibility() == 0) {
            getViewTreeObserver().removeOnGlobalLayoutListener(this);
            this.uSv.postDelayed(new Runnable() {
                public final void run() {
                    int s;
                    Rect rect = new Rect();
                    a.this.getWindowVisibleDisplayFrame(rect);
                    boolean z = a.this.getBottom() - rect.bottom >= 300;
                    DisplayMetrics displayMetrics = a.this.getResources().getDisplayMetrics();
                    if (z) {
                        s = (displayMetrics.heightPixels - j.s(a.this.getContext(), false)) - ((int) a.this.getResources().getDimension(c.color_select_layout_height));
                    } else {
                        s = displayMetrics.heightPixels - ((int) a.this.getResources().getDimension(c.color_select_layout_height));
                    }
                    if (a.this.uSv.getHeight() != s) {
                        a.this.uSv.setHeight(s);
                    }
                    a.this.getViewTreeObserver().removeOnGlobalLayoutListener(a.this);
                    a.this.getViewTreeObserver().addOnGlobalLayoutListener(a.this);
                }
            }, 160);
        }
    }
}
