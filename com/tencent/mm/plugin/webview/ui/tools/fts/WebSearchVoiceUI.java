package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;

@a(7)
public class WebSearchVoiceUI extends WebSearchBaseActivity {
    private String bJK;
    private String bWr;
    private View qfA;
    private int qfB;
    private com.tencent.mm.pluginsdk.ui.websearch.a qfz;
    private int scene;

    protected final int getLayoutId() {
        return R.i.websearch_voice_ui;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() != null) {
            this.bJK = getIntent().getStringExtra("sessionId");
            this.bWr = getIntent().getStringExtra("subSessionId");
            this.scene = getIntent().getIntExtra("key_scene", -1);
            this.qfB = getIntent().getIntExtra("key_is_nav_voice", 0);
        }
        this.qfA = findViewById(R.h.voiceinput_mask_view);
        this.mController.hideTitleView();
        if (this.qfz == null) {
            this.qfz = new com.tencent.mm.pluginsdk.ui.websearch.a(this.mController.tml);
            this.qfz.setCallback(new 1(this));
        }
        this.qfz.ceU();
        com.tencent.mm.pluginsdk.ui.websearch.a aVar = this.qfz;
        x.d("MicroMsg.VoiceInputPanel", "refreshHeight DISPLAY_HEIGHT_PORT_IN_PX %s,needRefreshProtHeight %s", new Object[]{Integer.valueOf(aVar.qKG), Boolean.valueOf(aVar.qNS)});
        if (aVar.qNS) {
            aVar.qNS = false;
            View findViewById = aVar.findViewById(R.h.voice_panel_display_view);
            LayoutParams layoutParams = findViewById.getLayoutParams();
            int i = aVar.qKG;
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-1, i);
            }
            layoutParams.height = i;
            findViewById.setLayoutParams(layoutParams);
            aVar.d();
            aVar.requestLayout();
        }
        this.qfz.setVisibility(0);
        LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(12);
        ((ViewGroup) findViewById(R.h.root)).addView(this.qfz, layoutParams2);
        h.mEJ.h(15178, new Object[]{Integer.valueOf(1), Long.valueOf(System.currentTimeMillis()), "", this.bJK, this.bWr, Integer.valueOf(this.scene), Integer.valueOf(this.qfB)});
    }

    public void onBackPressed() {
        super.onBackPressed();
        setResult(0);
        finish();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.qfz != null) {
            this.qfz.destroy();
        }
    }
}
