package com.tencent.mm.ui.transmit;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.model.au;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView;
import com.tencent.mm.plugin.sight.encode.ui.MainSightSelectContactView;
import com.tencent.mm.plugin.sight.encode.ui.SightCameraView;
import com.tencent.mm.plugin.sight.encode.ui.c;
import com.tencent.mm.pluginsdk.i.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import java.util.HashSet;

public class SightForwardUI extends MMActivity {
    private String ben;
    private MainSightForwardContainerView uEZ;

    protected final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        getSupportActionBar().hide();
        this.ben = getIntent().getStringExtra("sight_local_path");
        if (!d.Ln(this.ben)) {
            x.e("MicroMsg.SightForwardUI", "Path:%s, NOT SIGHT!", new Object[]{this.ben});
            finish();
        } else if (au.HX()) {
            String nJ = s.nJ(String.valueOf(SystemClock.elapsedRealtime()));
            o.Ta();
            nJ = s.nK(nJ);
            if (e.y(this.ben, nJ) <= 0) {
                x.e("MicroMsg.SightForwardUI", "Copy File %s to %s FAIL!", new Object[]{this.ben, nJ});
                finish();
                return;
            }
            this.ben = nJ;
            x.i("MicroMsg.SightForwardUI", "Doing Forward Sight, path %s", new Object[]{this.ben});
            this.uEZ = (MainSightForwardContainerView) findViewById(R.h.forward_view);
            this.uEZ.setIMainSightViewCallback(new 1(this));
            MainSightForwardContainerView mainSightForwardContainerView = this.uEZ;
            nJ = this.ben;
            mainSightForwardContainerView.nfG = this;
            mainSightForwardContainerView.nfC = nJ;
            mainSightForwardContainerView.nfA = g.cu(nJ);
            long currentTimeMillis = System.currentTimeMillis();
            mainSightForwardContainerView.nfD = 1.3333334f;
            mainSightForwardContainerView.nft = (SightCameraView) ((ViewStub) mainSightForwardContainerView.findViewById(R.h.camera_video_view)).inflate();
            mainSightForwardContainerView.nft.setTargetWidth(a.lgO);
            mainSightForwardContainerView.nft.setFixPreviewRate(mainSightForwardContainerView.nfD);
            mainSightForwardContainerView.nft.setVisibility(0);
            mainSightForwardContainerView.nfx = mainSightForwardContainerView.findViewById(R.h.top_virtual_actionbar);
            mainSightForwardContainerView.nfx.setLayoutParams(new LayoutParams(-1, getSupportActionBar().getHeight()));
            mainSightForwardContainerView.nfw = mainSightForwardContainerView.findViewById(R.h.main_sight_close);
            mainSightForwardContainerView.kWn = mainSightForwardContainerView.findViewById(R.h.main_sight_send);
            mainSightForwardContainerView.nfv = mainSightForwardContainerView.findViewById(R.h.camera_shadow);
            mainSightForwardContainerView.nfw.setOnClickListener(new MainSightForwardContainerView$1(mainSightForwardContainerView));
            mainSightForwardContainerView.kWn.setOnClickListener(new MainSightForwardContainerView$2(mainSightForwardContainerView));
            mainSightForwardContainerView.bwo();
            x.d("MicroMsg.MainSightContainerView", "init concrol view use %dms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            this.uEZ.bwn();
            mainSightForwardContainerView = this.uEZ;
            if (mainSightForwardContainerView.nfs == null) {
                DisplayMetrics displayMetrics = mainSightForwardContainerView.getResources().getDisplayMetrics();
                float f = ((float) displayMetrics.widthPixels) / mainSightForwardContainerView.nfD;
                mainSightForwardContainerView.nfs = (MainSightSelectContactView) mainSightForwardContainerView.findViewById(R.h.select_contact_root);
                MainSightSelectContactView mainSightSelectContactView = mainSightForwardContainerView.nfs;
                MMFragmentActivity mMFragmentActivity = mainSightForwardContainerView.nfG;
                int i = (int) (((float) displayMetrics.heightPixels) - f);
                int i2 = displayMetrics.heightPixels;
                mainSightSelectContactView.nfG = mMFragmentActivity;
                mainSightSelectContactView.ngf = i;
                mainSightSelectContactView.setMainSightContentView(mainSightForwardContainerView);
                mainSightSelectContactView.addView(View.inflate(mainSightSelectContactView.getContext(), R.i.main_sight_select_contact_view, null), -1, -2);
                mainSightSelectContactView.CU = (ListView) mainSightSelectContactView.findViewById(R.h.select_contact_lv);
                mainSightSelectContactView.ngi = new c(mainSightSelectContactView);
                mainSightSelectContactView.ngl = new LinearLayout(mainSightSelectContactView.getContext());
                mainSightSelectContactView.ngl.addView(new View(mainSightSelectContactView.getContext()), -1, mainSightSelectContactView.ngk.getViewHeight() - mainSightSelectContactView.ngf);
                mainSightSelectContactView.ngl.getChildAt(0).setBackgroundColor(0);
                mainSightSelectContactView.CU.addHeaderView(mainSightSelectContactView.ngl);
                mainSightSelectContactView.CU.setAdapter(mainSightSelectContactView.ngi);
                mainSightSelectContactView.CU.setOnItemClickListener(mainSightForwardContainerView);
                mainSightSelectContactView.ngp = new HashSet();
                mainSightSelectContactView.ngq = new HashSet();
                mainSightSelectContactView.CU.setOnScrollListener(mainSightSelectContactView);
                mainSightSelectContactView.ngg = new com.tencent.mm.plugin.sight.encode.ui.d();
                mainSightSelectContactView.ngg.ngb = mainSightSelectContactView;
                mainSightForwardContainerView.nfs.setSearchView(mainSightForwardContainerView.findViewById(R.h.search_view));
                mainSightForwardContainerView.nfs.setEmptyBgView(mainSightForwardContainerView.findViewById(R.h.empty_bg));
                mainSightForwardContainerView.nfs.setMainSightContentView(mainSightForwardContainerView);
            }
            mainSightForwardContainerView.hP(true);
            mainSightForwardContainerView.nft.postDelayed(new MainSightForwardContainerView$3(mainSightForwardContainerView), 50);
        } else {
            x.e("MicroMsg.SightForwardUI", "acc not ready");
            finish();
        }
    }

    protected final int getLayoutId() {
        return R.i.main_sight_forward_view;
    }

    protected void onResume() {
        super.onResume();
        this.uEZ.onResume();
    }

    protected void onPause() {
        super.onPause();
        this.uEZ.onPause();
    }
}
