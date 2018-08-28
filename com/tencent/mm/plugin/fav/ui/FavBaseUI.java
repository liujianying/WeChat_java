package com.tencent.mm.plugin.fav.ui;

import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.View;
import android.view.ViewStub;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ab.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.aj;
import com.tencent.mm.plugin.fav.a.ak;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.ui.m.f;
import com.tencent.mm.plugin.fav.ui.widget.c;
import com.tencent.mm.plugin.fav.ui.widget.c.a;
import com.tencent.mm.pluginsdk.wallet.i;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.y;

public abstract class FavBaseUI extends MMActivity implements OnItemClickListener {
    protected ag dvh = new ag(Looper.getMainLooper());
    private boolean iXW = false;
    protected boolean iXX = false;
    private boolean iXY = false;
    private long iXZ = 0;
    protected ListView iYa;
    protected TextView iYb;
    private HandlerThread iYc;
    protected ag iYd;
    protected View iYe;
    private View iYf;
    protected c iYg;
    protected k iYh;
    protected a iYi = null;
    private e iYj = new 6(this);
    private e iYk = new 7(this);
    private Runnable iYl = new 8(this);
    protected Runnable iYm = new 9(this);
    private Runnable iYn = new Runnable() {
        public final void run() {
            synchronized (FavBaseUI.this.lockObj) {
                FavBaseUI.this.aMd();
                FavBaseUI.this.aMc().aME();
                FavBaseUI.this.aMg();
            }
        }
    };
    private j.a iYo = new 2(this);
    private final Object lockObj = new Object();

    public abstract com.tencent.mm.plugin.fav.ui.a.a aMc();

    protected abstract void aMd();

    protected abstract boolean aMe();

    protected abstract void aMf();

    static /* synthetic */ boolean b(FavBaseUI favBaseUI) {
        x.v("MicroMsg.FavoriteBaseUI", "on pull down callback");
        if (!((ae) g.n(ae.class)).getFavItemInfoStorage().r(favBaseUI.aMc().aMB(), favBaseUI.aMc().getType())) {
            if (b.aKY()) {
                x.w("MicroMsg.FavoriteBaseUI", "doing batchget, do not load data");
            } else if (favBaseUI.iXW) {
                x.w("MicroMsg.FavoriteBaseUI", "onBottomLoadData loading, return");
            } else {
                favBaseUI.iXW = true;
                x.i("MicroMsg.FavoriteBaseUI", "on bottom load data listener");
                favBaseUI.iYd.removeCallbacks(favBaseUI.iYl);
                favBaseUI.iYd.post(favBaseUI.iYl);
            }
        }
        return true;
    }

    protected final int getLayoutId() {
        return f.favorite_base_ui;
    }

    public void onCreate(Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        super.onCreate(bundle);
        x.i("MicroMsg.FavoriteBaseUI", "onCreate MMCore.accHasReady[%b]", Boolean.valueOf(g.Eg().Dx()));
        g.DF().a(new ak(), 0);
        ((ae) g.n(ae.class)).getFavItemInfoStorage().c(this.iYo);
        g.DF().a(400, this.iYj);
        g.DF().a(402, this.iYk);
        this.iYc = com.tencent.mm.sdk.f.e.Xs(getClass().getName() + "_handlerThread_" + System.currentTimeMillis());
        this.iYc.start();
        this.iYd = new ag(this.iYc.getLooper());
        this.iYh = new k(this.mController.tml, 64);
        initView();
        lF(this.mController.tml.getResources().getColor(m.b.normal_actionbar_color));
        if (bi.f((Integer) g.Ei().DT().get(8217, null)) == 0) {
            x.i("MicroMsg.FavoriteBaseUI", "do init data for first time");
            this.iXY = true;
            g.DF().a(new aj(), 0);
            if (this.iXY) {
                x.i("MicroMsg.FavoriteBaseUI", "show loading dialog");
                if (aMc() == null || aMc().isEmpty()) {
                    eP(true);
                }
                eQ(false);
            }
        } else {
            b.startSync();
            if (aMc().isEmpty()) {
                eP(true);
                eQ(false);
                this.iYe.setVisibility(8);
            } else {
                eP(false);
                eQ(false);
            }
        }
        ((ae) g.n(ae.class)).getFavCdnService().run();
        ((ae) g.n(ae.class)).getCheckCdnService().run();
        ((ae) g.n(ae.class)).getSendService().run();
        ((ae) g.n(ae.class)).getModService().run();
        g.Em().H(new 1(this));
        x.d("MicroMsg.FavoriteBaseUI", "on create use %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    protected void onResume() {
        super.onResume();
        i.Cx(5);
    }

    protected void onPause() {
        super.onPause();
        aMc();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (((ae) g.n(ae.class)).getFavItemInfoStorage().aLz() != null) {
            this.iYh.destory();
            this.iYh = null;
            this.iYc.quit();
            ((ae) g.n(ae.class)).getFavItemInfoStorage().d(this.iYo);
            g.DF().b(400, this.iYj);
            g.DF().b(402, this.iYk);
        }
    }

    protected final void initView() {
        long currentTimeMillis = System.currentTimeMillis();
        this.iYa = (ListView) findViewById(m.e.favorite_lv);
        this.iYa.setDrawingCacheEnabled(false);
        3 3 = new 3(this);
        initHeaderView();
        this.iYe = y.gq(this).inflate(f.fav_loading_footer, null);
        this.iYa.setOnScrollListener(new 4(this));
        this.iYa.setOnItemClickListener(this);
        this.iYa.setOnTouchListener(new 5(this));
        this.iYa.setAdapter(aMc());
        a(aMc());
        x.d("MicroMsg.FavoriteBaseUI", "init view use %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    protected final void eP(boolean z) {
        if (z) {
            if (this.iYf == null) {
                this.iYf = ((ViewStub) findViewById(m.e.empty_load_view_stub)).inflate();
            }
            this.iYf.setVisibility(0);
        } else if (this.iYf != null) {
            this.iYf.setVisibility(8);
        }
    }

    private void eQ(boolean z) {
        if (z) {
            if (this.iYb == null) {
                this.iYb = (TextView) ((ViewStub) findViewById(m.e.empty_view_stub)).inflate().findViewById(m.e.empty_fav_view);
            }
            this.iYb.setVisibility(0);
        } else if (this.iYb != null) {
            this.iYb.setVisibility(8);
        }
    }

    protected void initHeaderView() {
        this.iYg = new c(this.mController.tml);
        this.iYg.setCleanFavSpace(this.iYi);
        this.iYg.eX(false);
        this.iYg.jfp.setVisibility(8);
        this.iYg.jfq.setVisibility(8);
        x.d("MicroMsg.FavoriteBaseUI", "padding %s, %s", Integer.valueOf(this.iYg.getPaddingTop()), Integer.valueOf(this.iYg.getPaddingBottom()));
        this.iYa.addHeaderView(this.iYg);
    }

    protected void aMg() {
        x.i("MicroMsg.FavoriteBaseUI", "on storage change, try refresh job");
        this.dvh.removeCallbacks(this.iYm);
        this.dvh.post(this.iYm);
    }

    protected final void a(com.tencent.mm.plugin.fav.ui.a.a aVar) {
        if (aVar == null) {
            x.w("MicroMsg.FavoriteBaseUI", "handle empty view fail, adapter is null");
            return;
        }
        if (!aVar.isEmpty()) {
            eP(false);
            eQ(false);
        } else if (aMe()) {
            eP(true);
            eQ(false);
        } else {
            eP(false);
            eQ(true);
            aMf();
        }
        if (aVar.isEmpty() || ((ae) g.n(ae.class)).getFavItemInfoStorage().r(aVar.aMB(), aVar.getType())) {
            this.iYa.removeFooterView(this.iYe);
        } else if (this.iYa.getFooterViewsCount() == 0) {
            this.iYa.addFooterView(this.iYe);
        }
    }
}
