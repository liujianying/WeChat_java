package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.ac.z;
import com.tencent.mm.g.a.k;
import com.tencent.mm.plugin.brandservice.b$e;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.plugin.brandservice.b.g;
import com.tencent.mm.plugin.brandservice.b.h;
import com.tencent.mm.plugin.brandservice.ui.timeline.d.1;
import com.tencent.mm.plugin.brandservice.ui.timeline.g.2;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.r;
import com.tencent.mm.storage.r$a;
import com.tencent.mm.storage.r.c;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.statusbar.DrawStatusBarActivity;
import java.util.List;

public class BizTimeLineUI extends DrawStatusBarActivity implements i {
    private static long hsm = 0;
    private static long hsn = 0;
    private static long hso = 0;
    private static int hsp = 0;
    private View eLM;
    private ListView eVT;
    private TextView emptyTipTv;
    private g hqQ = new g();
    private View hsd;
    private View hse;
    private ImageView hsf;
    private LinearLayout hsg;
    private TextView hsh;
    private TextView hsi;
    private View hsj;
    private a hsk;
    private e hsl;
    private long hsq = 0;
    private c hsr = new 6(this);
    private com.tencent.mm.sdk.b.c hss = new com.tencent.mm.sdk.b.c<k>() {
        {
            this.sFo = k.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            k kVar = (k) bVar;
            if (!(kVar == null || kVar.bGu == null || kVar.bGu.bGv)) {
                BizTimeLineUI.this.hsq = 0;
            }
            return false;
        }
    };

    static /* synthetic */ void b(BizTimeLineUI bizTimeLineUI) {
        if (bizTimeLineUI.hsk != null && bizTimeLineUI.eVT != null && hso != 0) {
            List list = bizTimeLineUI.hsk.gxs;
            int i = 0;
            while (i < list.size()) {
                q qVar = (q) list.get(i);
                if (qVar == null || qVar.field_orderFlag != hso) {
                    i++;
                } else {
                    bizTimeLineUI.eVT.setSelection(i);
                    bizTimeLineUI.eVT.postDelayed(new 10(bizTimeLineUI, qVar), 50);
                    x.i("MicroMsg.BizTimeLineUI", "setListViewPosition %d", new Object[]{Integer.valueOf(i)});
                    return;
                }
            }
        }
    }

    static /* synthetic */ void e(BizTimeLineUI bizTimeLineUI) {
        if (bizTimeLineUI.hsk != null && bizTimeLineUI.eVT != null && bizTimeLineUI.hsk.getCount() > 0) {
            a.avg();
            bizTimeLineUI.avo();
            bizTimeLineUI.hsk.notifyDataSetChanged();
            bizTimeLineUI.eVT.setSelection(0);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        lF(-1052684);
        setTitleBarDoubleClickListener(new 13(this));
        com.tencent.mm.storage.c fJ = com.tencent.mm.model.c.c.Jx().fJ("100045");
        boolean z = fJ.isValid() && "1".equals(fJ.ckq().get("isOpenSearch"));
        x.d("MicroMsg.BizTimeLineUI", "open search entrance:%b", new Object[]{Boolean.valueOf(z)});
        if (z) {
            addIconOptionMenu(0, h.top_item_desc_search, g.actionbar_icon_dark_search, new 11(this));
        }
        addIconOptionMenu(1, g.actionbar_menu_list_icon, new 12(this));
        setMMTitle(h.biz_time_line_title);
        nS(-16777216);
        setBackBtn(new 2(this), g.actionbar_icon_dark_back);
        this.hse = getLayoutInflater().inflate(b$e.biz_time_line_action_bar_update_view, null);
        this.hsi = (TextView) this.hse.findViewById(d.biz_time_line_update_count_tv);
        this.hsi.setTextSize(1, 15.0f);
        this.hsj = this.hse.findViewById(d.biz_time_line_update_count_layout);
        ((LinearLayout) this.mController.mActionBar.getCustomView()).addView(this.hse);
        LayoutParams layoutParams = (LayoutParams) this.hse.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.weight = 1.0f;
        this.hse.setLayoutParams(layoutParams);
        this.hsj.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                BizTimeLineUI.e(BizTimeLineUI.this);
            }
        });
        this.hse.setVisibility(8);
        this.emptyTipTv = (TextView) findViewById(d.empty_msg_tip_tv);
        this.emptyTipTv.setText(h.biz_time_line_empty_biz_msg_tip);
        this.hsl = new e(this);
        a.sFg.b(this.hsl.fIu);
        d dVar = new d();
        if (d.avi()) {
            avl();
        } else {
            getString(h.app_tip);
            final p a = com.tencent.mm.ui.base.h.a(this, getString(h.app_waiting), false, null);
            e.post(new 1(dVar, new Runnable() {
                public final void run() {
                    if (a != null) {
                        a.dismiss();
                    }
                    BizTimeLineUI.this.avl();
                }
            }), "BizTimeLineMigrateThread");
        }
        z.Nf().a(this.hsr, Looper.getMainLooper());
        com.tencent.mm.pluginsdk.e.l(this);
        com.tencent.mm.kernel.g.Em().H(new 2(this.hqQ));
        this.hsq = System.currentTimeMillis();
        a.sFg.b(this.hss);
    }

    public final void avk() {
        if (z.Nf().axd() > 0) {
            this.hsg.setVisibility(0);
            this.hsh.setText(getString(h.biz_time_line_new_msg_count, new Object[]{Integer.valueOf(r0)}));
            q ckB = z.Nf().ckB();
            if (ckB != null) {
                this.hsf.setVisibility(0);
                com.tencent.mm.pluginsdk.ui.a.b.a(this.hsf, ckB.field_talker);
                return;
            }
            this.hsf.setVisibility(8);
            return;
        }
        this.hsg.setVisibility(8);
    }

    private void avl() {
        boolean z;
        List n;
        long currentTimeMillis = System.currentTimeMillis();
        if (hsm == 0 || hsn == 0 || hsp <= 0 || currentTimeMillis - hsm >= 180000) {
            z = false;
            n = r.n(z.Ne().dCZ.query("BizTimeLineInfo", null, null, null, null, null, "orderFlag DESC limit 10"));
        } else {
            z = true;
            n = z.Ne().gh(hsn);
        }
        x.i("MicroMsg.BizTimeLineUI", "initListView %d/%d  orderFlag %d, keep %b", new Object[]{Long.valueOf(hsm), Long.valueOf(currentTimeMillis), Long.valueOf(hsn), Boolean.valueOf(z)});
        this.hsk = new a(this, n, z);
        this.hsk.hqQ.hrZ = hsp;
        this.eVT = (ListView) findViewById(d.biz_time_line_lv);
        ListView listView = this.eVT;
        this.hsd = getLayoutInflater().inflate(b$e.biz_time_line_footer_layout, null);
        listView.addFooterView(this.hsd);
        listView = this.eVT;
        this.eLM = getLayoutInflater().inflate(b$e.biz_time_line_header_layout, null);
        listView.addHeaderView(this.eLM);
        this.hsg = (LinearLayout) findViewById(d.new_msg_tips_layout);
        this.hsh = (TextView) findViewById(d.new_msg_tips_tv);
        this.hsf = (ImageView) findViewById(d.new_msg_tips_icon_iv);
        avk();
        this.hsg.setOnClickListener(new 1(this));
        this.eVT.setAdapter(this.hsk);
        this.eVT.setFooterDividersEnabled(false);
        this.eVT.setOnScrollListener(new 8(this));
        if (this.hsk.getCount() <= 0) {
            this.emptyTipTv.setVisibility(0);
            this.eVT.setVisibility(8);
        } else {
            this.emptyTipTv.setVisibility(8);
            this.eVT.setVisibility(0);
        }
        this.eVT.postDelayed(new 9(this, z), 100);
        if (n.size() < 10) {
            avm();
        }
    }

    public final void avm() {
        if (this.hsd != null) {
            TextView textView = (TextView) findViewById(d.biz_time_line_loading_more_tv);
            ((ProgressBar) findViewById(d.biz_time_line_loading_more_pb)).setVisibility(8);
            textView.setText(getString(h.biz_time_line_loading_no_more_tips));
        }
    }

    protected final int getLayoutId() {
        return b$e.biz_time_line_activity;
    }

    public final void avn() {
        if (this.hsk != null && this.hsk.gxs.size() > 0) {
            long j = ((q) this.hsk.gxs.get(0)).field_orderFlag;
            x.d("MicroMsg.BizTimeLineUI", "updateActionBarCustomView %d", new Object[]{Integer.valueOf(z.Ne().gi(j))});
            if (z.Ne().gi(j) > 0) {
                DL(4);
                if (this.hse.getVisibility() == 8) {
                    this.hse.setVisibility(4);
                }
                this.hsi.setText(getString(h.biz_time_line_new_update_count, new Object[]{Integer.valueOf(r2)}));
                this.hse.post(new 4(this, j));
                return;
            }
            this.hse.setVisibility(8);
            DL(0);
        }
    }

    public final void avo() {
        x.d("MicroMsg.BizTimeLineUI", "hideActionBarCustomView");
        if (this.hse.getVisibility() != 8) {
            this.hse.setVisibility(8);
        }
        DL(0);
    }

    protected final int getStatusBarColor() {
        if (VERSION.SDK_INT >= 21) {
            return -1052684;
        }
        return super.getStatusBarColor();
    }

    public final void avj() {
        if (this.hsk != null) {
            this.hsk.notifyDataSetChanged();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        a.sFg.c(this.hsl.fIu);
        hsm = System.currentTimeMillis();
        if (!(this.hsk == null || this.eVT == null)) {
            q avf = this.hsk.avf();
            if (avf != null) {
                hsn = avf.field_orderFlag;
            }
            avf = this.hsk.getItem(hsp);
            if (avf != null) {
                hso = avf.field_orderFlag;
            } else {
                x.w("MicroMsg.BizTimeLineUI", "FirstVisibleItem is null %d", new Object[]{Integer.valueOf(hsp)});
            }
            a aVar = this.hsk;
            int i = hsp;
            z.Ne().a(aVar.hnE);
            aVar.hqQ.hsa = i;
            com.tencent.mm.kernel.g.Em().H(new g.1(aVar.hqQ));
        }
        z.Nf().a(this.hsr);
        if (this.hsq != 0) {
            com.tencent.mm.plugin.report.service.h.mEJ.h(13932, new Object[]{Integer.valueOf(((int) (System.currentTimeMillis() - this.hsq)) / 1000), Integer.valueOf(1)});
        }
        a.sFg.c(this.hss);
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
        if (this.hsk != null) {
            h hVar = this.hsk.hqN;
            if (hVar.isPlaying()) {
                hVar.avp().stopPlay();
            }
        }
        r Ne = z.Ne();
        Ne.dCZ.fV("BizTimeLineInfo", "update BizTimeLineInfo set hasShow = 1 where hasShow != 1 ");
        r$a r_a = new r$a();
        r_a.sNY = r.b.sOc;
        Ne.b(r_a);
    }
}
