package com.tencent.mm.plugin.welab.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.welab.a$d;
import com.tencent.mm.plugin.welab.a.c;
import com.tencent.mm.plugin.welab.b;
import com.tencent.mm.plugin.welab.c.a.a;
import com.tencent.mm.plugin.welab.e;
import com.tencent.mm.plugin.welab.ui.widget.WelabRoundCornerImageView;
import com.tencent.mm.protocal.c.aqg;
import com.tencent.mm.protocal.c.aqh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import java.util.Iterator;
import java.util.List;

public class WelabAppInfoUI extends MMActivity {
    private String bPS;
    private TextView eBO;
    private TextView gxH;
    private Button jcg;
    private MMSwitchBtn kAq;
    private TextView lWL;
    private a qmV;
    private int qmW;
    private boolean qmX;
    private WelabRoundCornerImageView qmY;
    private RecyclerView qmZ;
    private View qna;
    private View qnb;
    private View qnc;
    private View qnd;
    private a qne;
    private OnClickListener qnf = new 5(this);

    public void onCreate(Bundle bundle) {
        boolean z = true;
        super.onCreate(bundle);
        lC(true);
        cqh();
        Intent intent = getIntent();
        if (intent != null) {
            this.bPS = intent.getStringExtra("para_appid");
            this.qmV = b.bYI().RT(this.bPS);
            this.qmW = this.qmV.field_Switch;
            if (getIntent().getIntExtra("para_from_with_red_point", 0) != 1) {
                z = false;
            }
            this.qmX = z;
        }
        initView();
        e.n(this.bPS, 2, this.qmX);
    }

    protected final int getLayoutId() {
        return c.welab_appinfo;
    }

    protected final void initView() {
        super.initView();
        if (this.qmV == null) {
            x.e("WelabAppInfoUI", "info is null");
            return;
        }
        DL(8);
        if (VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.clearFlags(201326592);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(getResources().getColor(com.tencent.mm.plugin.welab.a.a.welab_main_color));
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().getCustomView().setBackgroundColor(getResources().getColor(com.tencent.mm.plugin.welab.a.a.welab_main_color));
        }
        setBackBtn(new 1(this));
        this.qmY = (WelabRoundCornerImageView) findViewById(com.tencent.mm.plugin.welab.a.b.app_img);
        this.eBO = (TextView) findViewById(com.tencent.mm.plugin.welab.a.b.title);
        this.lWL = (TextView) findViewById(com.tencent.mm.plugin.welab.a.b.summary);
        this.qmZ = (RecyclerView) findViewById(com.tencent.mm.plugin.welab.a.b.img_recyclerview);
        this.qna = findViewById(com.tencent.mm.plugin.welab.a.b.app_switch);
        this.jcg = (Button) findViewById(com.tencent.mm.plugin.welab.a.b.open_btn);
        this.qnb = findViewById(com.tencent.mm.plugin.welab.a.b.feedback_btn);
        this.kAq = (MMSwitchBtn) findViewById(com.tencent.mm.plugin.welab.a.b.checkbox);
        this.gxH = (TextView) findViewById(com.tencent.mm.plugin.welab.a.b.switch_desc);
        this.qnc = findViewById(com.tencent.mm.plugin.welab.a.b.stopped_warning_tv);
        this.qnd = findViewById(com.tencent.mm.plugin.welab.a.b.online_view_container);
        this.qmZ.setLayoutManager(new LinearLayoutManager(0));
        this.qmZ.setOverScrollMode(2);
        this.qne = new a(this);
        this.qmZ.setAdapter(this.qne);
    }

    protected void onPause() {
        super.onPause();
        if (this.qmW != this.qmV.field_Switch) {
            b.bYI().qmM.c(this.qmV, new String[0]);
            aqh aqh = new aqh();
            aqg aqg = new aqg();
            aqg.rSI = bi.WU(this.qmV.field_expId);
            aqg.rSJ = this.qmV.field_LabsAppId;
            aqg.rDF = this.qmV.field_Switch == 2 ? 1 : 2;
            aqh.dav.add(aqg);
            ((i) g.l(i.class)).FQ().b(new h.a(TbsListener$ErrorCode.UNZIP_OTHER_ERROR, aqh));
            e.n(this.bPS, this.qmV.field_Switch == 2 ? 4 : 5, this.qmX);
        }
    }

    protected void onResume() {
        TextView textView;
        com.tencent.mm.ak.a.a Pq;
        super.onResume();
        if (this.qmV.bYT() && this.qmV.field_Type == 1) {
            this.qna.setVisibility(0);
            this.gxH.setText(getResources().getString(a$d.welab_open) + this.qmV.Sa("field_Title"));
            SharedPreferences sharedPreferences = getSharedPreferences(getPackageName() + "_preferences", 0);
            this.kAq.setEnabled(true);
            if (this.qmV.field_Switch == 2) {
                sharedPreferences.edit().putBoolean(bYU(), true).commit();
                this.kAq.setCheck(true);
            } else {
                sharedPreferences.edit().putBoolean(bYU(), false).commit();
                this.kAq.setCheck(false);
            }
            this.kAq.setSwitchListener(new 2(this));
        } else {
            this.qna.setVisibility(8);
        }
        if (this.qmV.bYT()) {
            this.jcg.setText(getResources().getString(a$d.welab_goto) + this.qmV.Sa("field_Title"));
            if (this.qmV.field_Type != 1) {
                this.jcg.setVisibility(0);
                this.jcg.setOnClickListener(new 3(this));
                textView = this.eBO;
                b.bYI();
                textView.setText(b.a(this.qmV));
                this.lWL.setText(this.qmV.Sa("field_Introduce"));
                if (this.qmV.bYT()) {
                    this.qnb.setVisibility(8);
                } else {
                    this.qnb.setVisibility(0);
                    this.qnb.setOnClickListener(new 4(this));
                }
                if (this.qmV.bYT()) {
                    this.qnc.setVisibility(0);
                    this.qnd.setVisibility(8);
                } else {
                    this.qnc.setVisibility(8);
                    this.qnd.setVisibility(0);
                }
                bYV();
                this.qmY.setCornerRadiusPercent(0.5f);
                Pq = com.tencent.mm.ak.a.a.Pq();
                b.bYI();
                Pq.a(b.b(this.qmV), this.qmY, b.bYI().pNL);
            }
        }
        this.jcg.setVisibility(8);
        textView = this.eBO;
        b.bYI();
        textView.setText(b.a(this.qmV));
        this.lWL.setText(this.qmV.Sa("field_Introduce"));
        if (this.qmV.bYT()) {
            this.qnb.setVisibility(8);
        } else {
            this.qnb.setVisibility(0);
            this.qnb.setOnClickListener(new 4(this));
        }
        if (this.qmV.bYT()) {
            this.qnc.setVisibility(0);
            this.qnd.setVisibility(8);
        } else {
            this.qnc.setVisibility(8);
            this.qnd.setVisibility(0);
        }
        bYV();
        this.qmY.setCornerRadiusPercent(0.5f);
        Pq = com.tencent.mm.ak.a.a.Pq();
        b.bYI();
        Pq.a(b.b(this.qmV), this.qmY, b.bYI().pNL);
    }

    private String bYU() {
        return "switch_" + this.qmV.field_LabsAppId;
    }

    private void bYV() {
        String Sa = this.qmV.Sa("field_ImgUrl_android");
        if (TextUtils.isEmpty(Sa)) {
            Sa = this.qmV.Sa("field_ImgUrl");
        }
        List RW = com.tencent.mm.plugin.welab.g.RW(Sa);
        Iterator it = RW.iterator();
        while (it.hasNext()) {
            if (TextUtils.isEmpty((String) it.next())) {
                it.remove();
            }
        }
        if (RW.isEmpty()) {
            this.qmZ.setVisibility(8);
            return;
        }
        this.qmZ.setVisibility(0);
        this.qne.hWN = RW;
        this.qne.RR.notifyChanged();
    }
}
