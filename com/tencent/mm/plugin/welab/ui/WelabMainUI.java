package com.tencent.mm.plugin.welab.ui;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.welab.a.c;
import com.tencent.mm.plugin.welab.a.d;
import com.tencent.mm.plugin.welab.c.a.a;
import com.tencent.mm.plugin.welab.d.b;
import com.tencent.mm.plugin.welab.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class WelabMainUI extends MMActivity {
    private boolean qmX = false;
    private LinearLayout qni;
    private LinearLayout qnj;
    private LinearLayout qnk;
    private LinearLayout qnl;
    private View qnm;
    private View qnn;
    private List<String> qno;
    private Comparator<a> qnp = new 3(this);
    private OnClickListener qnq = new 4(this);

    public void onCreate(Bundle bundle) {
        boolean z = false;
        super.onCreate(bundle);
        lC(true);
        cqh();
        if (getIntent() != null) {
            if (getIntent().getIntExtra("para_from_with_red_point", 0) == 1) {
                z = true;
            }
            this.qmX = z;
            this.qno = getIntent().getStringArrayListExtra("key_exclude_apps");
        }
        initView();
        b.bYX();
        ad.chZ().edit().putBoolean("key_has_enter_welab", true).commit();
        b.bYY();
        e.n("", 1, this.qmX);
    }

    protected final int getLayoutId() {
        return c.welab_main;
    }

    protected final void initView() {
        setMMTitle(d.welab_name);
        s.cqq();
        if (VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.clearFlags(201326592);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(getResources().getColor(com.tencent.mm.plugin.welab.a.a.welab_main_color));
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().getCustomView().setBackgroundColor(getResources().getColor(com.tencent.mm.plugin.welab.a.a.welab_main_color));
        }
        this.qni = (LinearLayout) findViewById(com.tencent.mm.plugin.welab.a.b.online_composite_container);
        this.qnk = (LinearLayout) findViewById(com.tencent.mm.plugin.welab.a.b.online_container);
        this.qnj = (LinearLayout) findViewById(com.tencent.mm.plugin.welab.a.b.stopped_composite_container);
        this.qnl = (LinearLayout) findViewById(com.tencent.mm.plugin.welab.a.b.stopped_container);
        this.qnm = findViewById(com.tencent.mm.plugin.welab.a.b.privacy_detail);
        this.qnn = findViewById(com.tencent.mm.plugin.welab.a.b.no_app_view);
        this.qnm.setOnClickListener(new 1(this));
        setBackBtn(new 2(this));
    }

    public void onResume() {
        super.onResume();
        this.qnk.removeAllViews();
        this.qnl.removeAllViews();
        List<a> bYJ = com.tencent.mm.plugin.welab.b.bYI().bYJ();
        if (bYJ == null || bYJ.isEmpty()) {
            this.qni.setVisibility(8);
        } else {
            a aVar;
            Iterator it = bYJ.iterator();
            while (it.hasNext()) {
                aVar = (a) it.next();
                if (!bi.oW(aVar.field_LabsAppId) && this.qno.contains(aVar.field_LabsAppId)) {
                    it.remove();
                }
            }
            if (bYJ.isEmpty()) {
                this.qni.setVisibility(8);
            } else {
                this.qni.setVisibility(0);
                Collections.sort(bYJ, this.qnp);
                for (a aVar2 : bYJ) {
                    a(aVar2, this.qnk);
                }
                x.d("MicroMsg.WelabMainUI", "get online app count " + this.qnk.getChildCount());
            }
        }
        bYW();
        if (this.qni.getVisibility() == 0 || this.qnj.getVisibility() == 0) {
            this.qnn.setVisibility(8);
        } else {
            this.qnn.setVisibility(0);
        }
    }

    public void onPause() {
        super.onPause();
    }

    private void bYW() {
        a aVar;
        List<a> bYS = com.tencent.mm.plugin.welab.b.bYI().qmM.bYS();
        Iterator it = bYS.iterator();
        while (it.hasNext()) {
            aVar = (a) it.next();
            if ((System.currentTimeMillis() / 1000) - aVar.field_endtime >= 2592000 || "labs1de6f3".equals(aVar.field_LabsAppId)) {
                it.remove();
                com.tencent.mm.plugin.welab.b.bYI().qmM.a(aVar, new String[0]);
            } else if (aVar.bTJ() && aVar.field_Switch != 3) {
                aVar.field_Switch = 3;
                com.tencent.mm.plugin.welab.b.bYI().qmM.c(aVar, new String[0]);
            } else if (aVar.field_Switch != 3) {
                it.remove();
            }
        }
        x.i("WelabMgr", new StringBuilder("stopped lab ").append(bYS).toString() != null ? bYS.toString() : "");
        if (bYS.isEmpty()) {
            this.qnj.setVisibility(8);
            return;
        }
        this.qnj.setVisibility(0);
        Collections.sort(bYS, this.qnp);
        for (a aVar2 : bYS) {
            a(aVar2, this.qnl);
        }
        x.d("MicroMsg.WelabMainUI", "get online app count " + this.qnl.getChildCount());
    }

    private void a(a aVar, LinearLayout linearLayout) {
        LinearLayout linearLayout2 = (LinearLayout) getLayoutInflater().inflate(c.welab_app_view, linearLayout, false);
        ImageView imageView = (ImageView) linearLayout2.findViewById(com.tencent.mm.plugin.welab.a.b.title_prospect);
        ImageView imageView2 = (ImageView) linearLayout2.findViewById(com.tencent.mm.plugin.welab.a.b.app_img);
        TextView textView = (TextView) linearLayout2.findViewById(com.tencent.mm.plugin.welab.a.b.title);
        TextView textView2 = (TextView) linearLayout2.findViewById(com.tencent.mm.plugin.welab.a.b.summary);
        if (b.bYX().e(aVar)) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
        com.tencent.mm.ak.a.a.Pq().a(aVar.Sa("field_ThumbUrl"), imageView2, com.tencent.mm.plugin.welab.b.bYI().pNL);
        com.tencent.mm.plugin.welab.b.bYI();
        textView.setText(com.tencent.mm.plugin.welab.b.a(aVar));
        textView2.setText(aVar.Sa("field_Desc"));
        linearLayout2.setTag(aVar);
        linearLayout2.setOnClickListener(this.qnq);
        linearLayout.addView(linearLayout2);
    }
}
