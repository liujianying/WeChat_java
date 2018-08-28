package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.LinearLayout;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.sns.i$f;
import com.tencent.mm.plugin.sns.i$g;
import com.tencent.mm.plugin.sns.i$i;
import com.tencent.mm.plugin.sns.i$j;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ah;
import com.tencent.mm.ui.e.h;
import com.tencent.mm.ui.s.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SightUploadUI extends MMActivity {
    private String desc = "";
    DisplayMetrics mon;
    private String nQQ = "";
    private String nQR = "";
    private SnsEditText nRk;
    private z nRl = null;
    private LinearLayout nRm;
    private SnsSightUploadSayFooter nRn;
    private int nRo = 0;
    private int nRp = 0;
    private ArrayList<String> nRq;
    private boolean nRr = false;
    private int nRs = 0;
    private boolean nRt = false;
    private long nRu = 0;

    public void onCreate(Bundle bundle) {
        e.k(this);
        super.onCreate(bundle);
        this.mon = getResources().getDisplayMetrics();
        this.nRl = new al(this);
        this.nRl.G(bundle);
        this.nRm = (LinearLayout) findViewById(i$f.widget_content);
        this.nRm.addView(this.nRl.bBV());
        setMMTitle(i$j.sns_timeline_ui_title);
        getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(c.black));
        this.nRt = getIntent().getBooleanExtra("KSnsPostManu", false);
        this.nRu = getIntent().getLongExtra("KTouchCameraTime", 0);
        initView();
        e.l(this);
    }

    protected final int getLayoutId() {
        return i$g.sns_sight_upload_ui;
    }

    protected final void initView() {
        this.nRk = (SnsEditText) findViewById(i$f.sns_desc_tv);
        this.nRk.setTextSize(1, (ah.fe(this.mController.tml) * this.nRk.getTextSize()) / a.getDensity(this.mController.tml));
        this.nRk.postDelayed(new 1(this, this.mon.widthPixels - (this.nRk.getPaddingLeft() + this.nRm.getPaddingRight())), 100);
        if (!bi.oW(getIntent().getStringExtra(h.thz))) {
            this.nRk.setText(getIntent().getStringExtra(h.thz));
        }
        this.nRk.setBackListener(new 2(this));
        this.nRn = (SnsSightUploadSayFooter) findViewById(i$f.say_footer);
        this.nRn.setMMEditText(this.nRk);
        this.nRn.setVisibility(0);
        setBackBtn(new 3(this));
        if (getIntent().getBooleanExtra("KSightDraftEntrance", true)) {
            addIconOptionMenu(1, i$i.sight_draft_menu, new 4(this));
        }
        a(0, getString(i$j.app_send), new 5(this), b.tmZ);
        enableOptionMenu(true);
    }

    public void onResume() {
        super.onResume();
        x.d("MicroMsg.SightUploadUI", "onResume");
        SnsSightUploadSayFooter snsSightUploadSayFooter = this.nRn;
        if (snsSightUploadSayFooter.kXH.getVisibility() == 8) {
            snsSightUploadSayFooter.bGc.showVKB();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        this.nRl.bBW();
        this.nRn.obi.stop();
        SnsSightUploadSayFooter snsSightUploadSayFooter = this.nRn;
        if (snsSightUploadSayFooter.kXH != null) {
            snsSightUploadSayFooter.kXH.um();
            snsSightUploadSayFooter.kXH.destroy();
        }
    }

    protected void onPause() {
        super.onPause();
        YC();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 6 || i == 5 || i == 10) {
                SnsSightUploadSayFooter snsSightUploadSayFooter = this.nRn;
                if (intent != null) {
                    if (i == 10) {
                        snsSightUploadSayFooter.obi.Y(intent);
                    } else if (i == 5) {
                        snsSightUploadSayFooter.obh.a(i, i2, intent, null);
                    }
                }
            }
            if (i == 5 && intent != null) {
                int intExtra = intent.getIntExtra("Ktag_range_index", 0);
                if (intExtra >= 2) {
                    this.nQQ = intent.getStringExtra("Klabel_name_list");
                    this.nQR = intent.getStringExtra("Kother_user_name_list");
                    List<String> asList = Arrays.asList(this.nQQ.split(","));
                    List list;
                    if (bi.oW(this.nQR)) {
                        list = null;
                    } else {
                        list = Arrays.asList(this.nQR.split(","));
                    }
                    this.nRq = new ArrayList();
                    if (asList != null && asList.size() > 0) {
                        for (String FA : asList) {
                            List<String> FD = com.tencent.mm.plugin.label.a.a.aYK().FD(com.tencent.mm.plugin.label.a.a.aYK().FA(FA));
                            if (FD == null || FD.size() == 0) {
                                x.e("MicroMsg.SightUploadUI", "dz: getContactNamesFromLabels,namelist get bu label is null");
                                break;
                            }
                            for (String FA2 : FD) {
                                if (!this.nRq.contains(FA2)) {
                                    this.nRq.add(FA2);
                                    x.d("MicroMsg.SightUploadUI", "dz:name : %s", new Object[]{FA2});
                                }
                            }
                        }
                    }
                    if (asList != null) {
                        int i3 = 0;
                        for (String FA22 : asList) {
                            int i4;
                            if (bi.oW(FA22)) {
                                i4 = i3;
                            } else {
                                i4 = i3 + 1;
                            }
                            i3 = i4;
                        }
                        this.nRo = i3;
                    }
                    this.nRp = 0;
                    if (list != null && list.size() > 0) {
                        for (String FA222 : list) {
                            if (!this.nRq.contains(FA222)) {
                                this.nRq.add(FA222);
                                this.nRp++;
                            }
                        }
                    }
                    if (intExtra == 2) {
                        this.nRr = false;
                    } else {
                        this.nRr = true;
                    }
                }
                if (1 == intExtra) {
                    this.nRs = 1;
                } else {
                    this.nRs = 0;
                }
            }
        }
    }
}
