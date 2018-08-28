package com.tencent.mm.plugin.game.gamewebview.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameMMToClientEvent;
import com.tencent.mm.plugin.webview.ui.tools.game.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.i;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.SwipeBackLayout.a;
import com.tencent.mm.ui.widget.g;

public final class b extends SwipeBackLayout implements a, g.a {
    private boolean gmD;
    d jGU;
    c jIE;
    boolean jIF;
    private Context mContext;
    boolean mSwiping = false;
    private Bundle sy = new Bundle();

    public b(Context context, c cVar) {
        super(context);
        this.mContext = context;
        this.jIE = cVar;
        setLayoutParams(new LayoutParams(-1, -1));
        init();
        setNeedRequestActivityTranslucent(false);
        mC(true);
        addView(getContentView());
        setContentView(getContentView());
        setSwipeGestureDelegate(this);
    }

    public final void setBundle(Bundle bundle) {
        this.sy = bundle;
        getContentView().setBundle(bundle);
    }

    public final d getContentView() {
        if (this.jGU == null) {
            this.jGU = new d(this);
        }
        return this.jGU;
    }

    public final String getCurrentUrl() {
        return this.jGU.getCurrentURL();
    }

    public final d getPageView() {
        return this.jGU;
    }

    public final void agE() {
        d dVar;
        x.d("MicroMsg.GameWebPage", "onPageForeground: %s", new Object[]{getPageView().getRawUrl()});
        g.b(this);
        this.uIg = false;
        setEnableGesture(aSF());
        this.gmD = false;
        setVisibility(0);
        if (this.sy.getBoolean("transparent_page", false)) {
            dVar = this.jGU;
            dVar.jIZ.setBackgroundColor(0);
            dVar.jIX.pXt = true;
            dVar.jIX.fpo = false;
            dVar.jIX.jY(true);
            dVar.jIX.AH(0);
        }
        if (this.mContext instanceof GameWebViewUI) {
            GameWebViewUI gameWebViewUI = (GameWebViewUI) this.mContext;
            gameWebViewUI.qP(this.sy.getInt("screen_orientation", -1));
            if (isFullScreen()) {
                gameWebViewUI.getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                gameWebViewUI.getWindow().getDecorView().setSystemUiVisibility(5894);
            } else {
                gameWebViewUI.getWindow().clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                gameWebViewUI.getWindow().getDecorView().setSystemUiVisibility(0);
            }
        }
        getPageView().setFullScreen(isFullScreen());
        dVar = getPageView();
        dVar.aSR();
        dVar.Dl("onResume");
        dVar.Dm("onResume");
        dVar.jIS.jIr = System.currentTimeMillis();
        dVar.jJI.qfW.onResume();
    }

    public final void fo(boolean z) {
        x.d("MicroMsg.GameWebPage", "onPageBackground: %s", new Object[]{getPageView().getRawUrl()});
        if (z) {
            g.a(this);
        }
        this.gmD = true;
        d pageView = getPageView();
        com.tencent.mm.plugin.game.gamewebview.d.a aVar = pageView.jIS;
        aVar.jIs += System.currentTimeMillis() - aVar.jIr;
        pageView.jJI.qfW.onPause();
        pageView.Dl("onPause");
        pageView.Dm("onPause");
        pageView.goJ.onHideCustomView();
    }

    protected final void agD() {
        x.d("MicroMsg.GameWebPage", "onPageDestroy: %s", new Object[]{getCurrentUrl()});
        d pageView = getPageView();
        x.d("MicroMsg.GameWebPageView", "onPageDestroy");
        pageView.ief = true;
        if (pageView.jJF != null) {
            pageView.jJF.cancel();
        }
        if (pageView.jJl != null) {
            pageView.jJl.onDestroy();
        }
        com.tencent.mm.plugin.game.gamewebview.d.a aVar = pageView.jIS;
        x.d("MicroMsg.GameWebViewReportManager", "totalTime = %d, visitTime = %d, loadSuccess = %d", new Object[]{Long.valueOf(System.currentTimeMillis() - aVar.jIq), Long.valueOf(aVar.jIs), Integer.valueOf(aVar.jIo)});
        aVar.a(aVar.jGU.getCurrentURL(), 4, r4, aVar.jIo, 0);
        aVar.a(aVar.jGU.getCurrentURL(), 1, aVar.jIs, aVar.jIo, 0);
        pageView.Dl("onDestroy");
        c.a(pageView.jJI.qfW.qfX);
        x.d("MicroMsg.GameWebPageView", "destroy");
        GameMMToClientEvent.qJ(pageView.hashCode());
        com.tencent.mm.plugin.game.gamewebview.model.a.b(pageView);
        pageView.jIX.release();
        if (pageView.jJi != null) {
            pageView.jJi.detach();
            pageView.jJi = null;
        }
        pageView.jIY.fwr.getLooper().quit();
        pageView.jIZ.setWebChromeClient(null);
        pageView.jIZ.setWebChromeClient(null);
        pageView.jIZ.setOnTouchListener(null);
        pageView.jIZ.setOnLongClickListener(null);
        try {
            pageView.jIZ.destroy();
        } catch (Exception e) {
            x.e("MicroMsg.GameWebPageView", "destroy, webview destroy, excepiton: " + e.getMessage());
        }
        pageView.jIZ = null;
        System.gc();
    }

    public final boolean aSF() {
        if (!(this.sy.getBoolean("disable_swipe_back", false) || this.sy.getBoolean("transparent_page", false) || this.jIF)) {
            if (this.jIE.jII.size() > 1) {
                return true;
            }
        }
        return false;
    }

    public final void hide() {
        if (this.gmD) {
            x.d("MicroMsg.GameWebPage", "hide, %d", new Object[]{Integer.valueOf(hashCode())});
            setVisibility(4);
        }
    }

    protected final c getContainer() {
        return this.jIE;
    }

    public final void onSwipe(float f) {
        x.d("MicroMsg.GameWebPage", "onSwipe， " + hashCode());
        if (this.gmD) {
            if (f != 1.0f) {
                setVisibility(0);
            } else {
                hide();
            }
        }
        if (Float.compare(1.0f, f) <= 0) {
            i.n(getContentView(), 0.0f);
            return;
        }
        i.n(getContentView(), (((float) (getContentView().getWidth() / 4)) * (1.0f - f)) * -1.0f);
    }

    public final void onSettle(boolean z, int i) {
        long j = 110;
        x.d("MicroMsg.GameWebPage", "onSettle(%d), %b, %d ", new Object[]{Integer.valueOf(hashCode()), Boolean.valueOf(z), Integer.valueOf(i)});
        View contentView;
        if (z) {
            contentView = getContentView();
            if (i <= 0) {
                j = 220;
            }
            i.a(contentView, j, 0.0f, null);
            return;
        }
        contentView = getContentView();
        if (i <= 0) {
            j = 220;
        }
        i.a(contentView, j, (float) ((getContentView().getWidth() * -1) / 4), null);
    }

    public final boolean forceRemoveNoMatchOnPath() {
        return false;
    }

    public final void onSwipeBack() {
        this.jIE.fp(true);
    }

    public final void onDrag() {
        this.mSwiping = true;
    }

    public final void onCancel() {
        this.mSwiping = false;
    }

    public final Bundle getBundle() {
        return this.sy;
    }

    public final void setHasKeepTop(boolean z) {
        this.jIF = z;
        setEnableGesture(aSF());
    }

    public final boolean aSG() {
        return this.sy.getBoolean("is_from_keep_top", false);
    }

    public final void aSH() {
        this.jIE.fp(true);
    }

    public final void setFromKeepTop(boolean z) {
        this.sy.putBoolean("is_from_keep_top", z);
    }

    public final boolean isFullScreen() {
        return this.sy.getBoolean("show_full_screen", false);
    }

    public final void setPageOrientation(int i) {
        this.sy.putInt("screen_orientation", i);
        if (this.mContext instanceof GameWebViewUI) {
            ((GameWebViewUI) this.mContext).qP(i);
        }
    }
}
