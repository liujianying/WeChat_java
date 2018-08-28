package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b.a;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b.b;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b.c;
import com.tencent.mm.ui.base.l;

public final class d implements OnGlobalLayoutListener {
    private ViewTreeObserver Jd;
    private View eS;
    private Context mContext;
    private l ofr;
    private e qgE;
    public b qgF;
    private GameMenuView qgG;
    private f qgH;
    private boolean qgI = false;
    private boolean qgJ;
    public boolean qgK;
    public boolean qgL = false;

    public final void onGlobalLayout() {
        if (isShowing()) {
            View view = this.eS;
            if (view == null || !view.isShown()) {
                bzW();
            } else if (isShowing() && this.qgI != bdK()) {
                bzW();
            }
        }
    }

    public d(Context context) {
        this.mContext = context;
        if (this.mContext instanceof Activity) {
            ViewGroup viewGroup = (ViewGroup) ((Activity) this.mContext).getWindow().getDecorView();
            if (viewGroup.getChildCount() > 0) {
                this.eS = viewGroup.getChildAt(0);
            } else {
                this.eS = viewGroup;
            }
        }
        Context context2 = this.mContext;
        this.ofr = new l(context2);
        this.qgE = new e(context2);
        this.qgG = new GameMenuView(context2);
        this.qgH = new f(context2);
        this.qgG.setAdapter(this.qgH);
        this.qgI = bdK();
        this.qgE.setContentView(this.qgG);
    }

    public final void bXO() {
        int i = 0;
        this.qgI = bdK();
        if (this.qgF != null) {
            this.qgF.a(this.ofr);
        }
        if (this.qgE != null) {
            if (this.qgH != null) {
                f fVar = this.qgH;
                fVar.ofr = this.ofr;
                fVar.notifyDataSetChanged();
            }
            if (VERSION.SDK_INT >= 21) {
                this.qgE.getWindow().addFlags(Integer.MIN_VALUE);
            }
            if (this.qgJ && VERSION.SDK_INT >= 23 && this.qgE != null) {
                this.qgE.getWindow().getDecorView().setSystemUiVisibility(9216);
                this.qgE.getWindow().setStatusBarColor(0);
            }
            if (this.qgK) {
                this.qgE.getWindow().addFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            }
            if (this.qgL) {
                this.qgE.getWindow().setFlags(8, 8);
                this.qgE.getWindow().addFlags(131200);
                this.qgE.getWindow().getDecorView().setSystemUiVisibility(6);
            } else {
                this.qgE.getWindow().clearFlags(8);
                this.qgE.getWindow().clearFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
                this.qgE.getWindow().clearFlags(128);
                this.qgE.getWindow().getDecorView().setSystemUiVisibility(0);
            }
            if (this.eS != null) {
                if (this.Jd == null) {
                    i = 1;
                }
                this.Jd = this.eS.getViewTreeObserver();
                if (i != 0) {
                    this.Jd.addOnGlobalLayoutListener(this);
                }
            }
            this.qgE.setOnDismissListener(new 1(this));
            if (this.qgG != null) {
                this.qgG.setDismissListener(new a() {
                    public final void onDismiss() {
                        d.this.bzW();
                    }
                });
            }
            this.qgE.show();
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
        if (this.qgE != null) {
            this.qgE.dismiss();
        }
    }

    private boolean isShowing() {
        if (this.qgE == null || !this.qgE.isShowing()) {
            return false;
        }
        return true;
    }

    public final void a(c cVar) {
        if (this.qgG != null) {
            this.qgG.setGameMenuItemSelectedListener(cVar);
        }
    }

    private boolean bdK() {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
            return true;
        }
        return false;
    }
}
