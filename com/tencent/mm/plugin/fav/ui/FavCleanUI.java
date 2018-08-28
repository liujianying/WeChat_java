package com.tencent.mm.plugin.fav.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.ak;
import com.tencent.mm.plugin.fav.a.d;
import com.tencent.mm.plugin.fav.ui.a.b;
import com.tencent.mm.plugin.fav.ui.d.a.c;
import com.tencent.mm.plugin.fav.ui.m.f;
import com.tencent.mm.plugin.fav.ui.m.i;
import com.tencent.mm.plugin.fav.ui.widget.a;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.y;
import java.util.Iterator;
import java.util.List;

public class FavCleanUI extends MMActivity implements c {
    protected ag dvh = new ag(Looper.getMainLooper());
    private boolean iXW = false;
    protected boolean iXX = false;
    private long iXZ = 0;
    private HandlerThread iYc;
    protected ag iYd;
    protected View iYe;
    private View iYf;
    private Runnable iYl = new 7(this);
    protected Runnable iYm = new Runnable() {
        public final void run() {
            if (FavCleanUI.this.iYs != null) {
                if (FavCleanUI.this.iYs.isEmpty() || SystemClock.elapsedRealtime() - FavCleanUI.this.iXZ >= 1000) {
                    FavCleanUI.this.iXW = false;
                    FavCleanUI.this.iXZ = SystemClock.elapsedRealtime();
                    x.v("MicroMsg.FavCleanUI", "do refresh job");
                    FavCleanUI.d(FavCleanUI.this);
                    if (FavCleanUI.this.iXX) {
                        x.v("MicroMsg.FavCleanUI", "do scroll to first");
                        FavCleanUI.this.iYt.setSelection(0);
                        FavCleanUI.this.iXX = false;
                        return;
                    }
                    return;
                }
                x.d("MicroMsg.FavCleanUI", "try refresh, time limit, now %d last %d delay %d", new Object[]{Long.valueOf(SystemClock.elapsedRealtime()), Long.valueOf(FavCleanUI.this.iXZ), Integer.valueOf(1000)});
                FavCleanUI.this.dvh.postDelayed(this, 500);
            }
        }
    };
    private k iYr;
    private b iYs;
    private ListView iYt;
    private TextView iYu;
    private a iYv;
    private boolean iYw = false;
    private int iYx = 0;
    private d.a iYy = new 3(this);
    private e iYz = new e() {
        public final void a(int i, int i2, String str, l lVar) {
            x.i("MicroMsg.FavCleanUI", "on getfavinfo scene end");
            if (FavCleanUI.this.iYv != null) {
                FavCleanUI.this.iYv.jfd = com.tencent.mm.plugin.fav.a.b.aKR();
            }
        }
    };

    static /* synthetic */ boolean a(FavCleanUI favCleanUI) {
        if (favCleanUI.iYt.getChildAt(favCleanUI.iYt.getChildCount() - 1) == null || favCleanUI.iYt.getLastVisiblePosition() != favCleanUI.iYt.getAdapter().getCount() - 1) {
            return false;
        }
        x.i("MicroMsg.FavCleanUI", "at bottom call back");
        return true;
    }

    static /* synthetic */ void b(FavCleanUI favCleanUI) {
        x.v("MicroMsg.FavCleanUI", "on pull down callback");
        if (favCleanUI.iYs.jbR) {
            x.i("MicroMsg.FavCleanUI", "has shown all, do not load data");
        } else if (favCleanUI.iXW) {
            x.w("MicroMsg.FavCleanUI", "onBottomLoadData loading, return");
        } else {
            favCleanUI.iXW = true;
            favCleanUI.eS(true);
            x.i("MicroMsg.FavCleanUI", "on bottom load data listener");
            favCleanUI.iYd.removeCallbacks(favCleanUI.iYl);
            favCleanUI.iYd.post(favCleanUI.iYl);
        }
    }

    static /* synthetic */ void c(FavCleanUI favCleanUI) {
        favCleanUI.iYr = new k(ad.getContext(), 16);
        favCleanUI.iYs = new b(favCleanUI.iYr, true);
        favCleanUI.iYs.jbP = favCleanUI;
        favCleanUI.iYt.setAdapter(favCleanUI.iYs);
        favCleanUI.iYt.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (FavCleanUI.this.iYs != null) {
                    FavCleanUI.this.iYs.onItemClick(adapterView, view, i, j);
                }
            }
        });
        favCleanUI.iYt.setOnTouchListener(null);
        favCleanUI.iYt.setOnItemLongClickListener(null);
    }

    static /* synthetic */ void d(FavCleanUI favCleanUI) {
        favCleanUI.iYs.notifyDataSetChanged();
        if (favCleanUI.iYs.isEmpty()) {
            favCleanUI.eR(true);
            if (8 != favCleanUI.iYt.getVisibility()) {
                favCleanUI.iYt.setVisibility(8);
            }
        } else {
            favCleanUI.eR(false);
            if (favCleanUI.iYv != null) {
                favCleanUI.iYv.show();
            }
            if (favCleanUI.iYt.getVisibility() != 0) {
                favCleanUI.iYt.setVisibility(0);
            }
        }
        favCleanUI.eS(false);
    }

    protected final int getLayoutId() {
        return f.fav_clean_ui;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iYx = getIntent().getIntExtra("key_enter_fav_cleanui_from", 0);
        this.iYc = com.tencent.mm.sdk.f.e.Xs(getClass().getName() + "_handlerThread_" + System.currentTimeMillis());
        this.iYc.start();
        this.iYd = new ag(this.iYc.getLooper());
        this.iYt = (ListView) findViewById(m.e.fav_clean_list);
        setMMTitle(i.fav_clean_title);
        this.iYw = true;
        g.DF().a(new ak(), 0);
        g.DF().a(438, this.iYz);
        setBackBtn(new 1(this));
        ViewStub viewStub = (ViewStub) findViewById(m.e.empty_load_view_stub);
        if (viewStub != null) {
            this.iYf = viewStub.inflate();
        } else {
            this.iYf = findViewById(m.e.favorite_loading);
        }
        this.iYu = (TextView) findViewById(m.e.empty_fav_view);
        this.iYf.setVisibility(0);
        this.iYu.setVisibility(8);
        this.iYt.removeFooterView(this.iYe);
        if (this.iYv != null) {
            this.iYv.hide();
        }
        this.iYe = y.gq(this).inflate(f.fav_loading_footer, null);
        this.iYt.setOnScrollListener(new 2(this));
        if (this.iYw) {
            this.iYv = new a();
            a aVar = this.iYv;
            View findViewById = findViewById(m.e.fav_clean_footer);
            aVar.jff = false;
            aVar.jfg = findViewById;
            this.iYv.jfh = new 5(this);
            this.iYw = false;
        }
        d.aLb().a(this.iYy);
    }

    protected void onDestroy() {
        super.onDestroy();
        d aLb = d.aLb();
        d.a aVar = this.iYy;
        if (aLb.iVy.contains(aVar)) {
            aLb.iVy.remove(aVar);
        }
        if (this.iYr != null) {
            this.iYr.destory();
            this.iYr = null;
        }
        if (this.iYs != null) {
            this.iYs.finish();
        }
        this.iYc.quit();
        g.DF().b(438, this.iYz);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        x.d("MicroMsg.FavCleanUI", "on create options menu");
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return super.onOptionsItemSelected(menuItem);
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    protected final void aMg() {
        x.i("MicroMsg.FavCleanUI", "on storage change, try refresh job");
        this.dvh.removeCallbacks(this.iYm);
        this.dvh.post(this.iYm);
    }

    private void eR(boolean z) {
        if (z) {
            this.iYf.setVisibility(8);
            this.iYu.setVisibility(0);
            this.iYt.removeFooterView(this.iYe);
            if (this.iYv != null) {
                this.iYv.hide();
                return;
            }
            return;
        }
        this.iYf.setVisibility(8);
        this.iYu.setVisibility(8);
        this.iYt.removeFooterView(this.iYe);
        if (this.iYv != null) {
            this.iYv.show();
        }
    }

    private void eS(boolean z) {
        if (!z) {
            this.iYt.removeFooterView(this.iYe);
        } else if (this.iYt.getFooterViewsCount() == 0) {
            this.iYt.addFooterView(this.iYe);
        }
    }

    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    public final void dC(long j) {
        long j2;
        com.tencent.mm.plugin.fav.a.g dy = ((ae) g.n(ae.class)).getFavItemInfoStorage().dy(j);
        if (!(dy == null || dy.field_favProto == null || dy.field_favProto.rBI.size() == 0)) {
            Iterator it = dy.field_favProto.rBI.iterator();
            while (it.hasNext()) {
                j2 = ((vx) it.next()).rzJ;
            }
        }
        if (this.iYs.jbQ) {
            boolean z;
            a aVar = this.iYv;
            if (this.iYs.aMG() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (aVar.jff) {
                aVar.eOQ.setEnabled(z);
            }
            a aVar2 = this.iYv;
            List eU = this.iYs.eU(false);
            j2 = this.iYs.aMH();
            if (eU.size() == 0 || j2 <= 0) {
                aVar2.aMR();
                return;
            }
            aVar2.hSo.setText(aVar2.hSo.getContext().getString(i.fav_clean_delete_info, new Object[]{com.tencent.mm.plugin.fav.a.b.dp(j2)}));
            aVar2.eOQ.setEnabled(true);
        }
    }
}
