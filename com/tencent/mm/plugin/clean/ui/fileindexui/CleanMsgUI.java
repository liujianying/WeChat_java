package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.clean.c.f;
import com.tencent.mm.plugin.clean.c.j;
import com.tencent.mm.plugin.clean.ui.PieView;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.HashSet;

public class CleanMsgUI extends MMActivity {
    private ProgressDialog eHw;
    private TextView hSA;
    private TextView hSB;
    private TextView hSC;
    private View hSD;
    private TextView hSE;
    private TextView hSF;
    private TextView hSG;
    private TextView hSH;
    private TextView hSI;
    private TextView hSJ;
    private LinearLayout hSK;
    private View hSu;
    private PieView hSv;
    private TextView hSw;
    private Button hSx;
    private Button hSy;
    private TextView hSz;

    static /* synthetic */ void a(CleanMsgUI cleanMsgUI, HashSet hashSet) {
        x.i("MicroMsg.CleanMsgUI", "%d begin deleteOtherAcc", new Object[]{Integer.valueOf(cleanMsgUI.hashCode())});
        h.mEJ.a(714, 11, 1, false);
        new f(hashSet, new 5(cleanMsgUI)).start();
        cleanMsgUI.eHw.show();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        h.mEJ.a(714, 10, 1, false);
        this.hSw = (TextView) findViewById(R.h.process_info_tv);
        this.hSv = (PieView) findViewById(R.h.pie_view);
        this.hSx = (Button) findViewById(R.h.clean_btn);
        this.hSy = (Button) findViewById(R.h.clean_other_btn);
        this.hSu = findViewById(R.h.analyse_data_layout);
        this.hSz = (TextView) findViewById(R.h.wechat_data_tv);
        this.hSz.setTextSize(1, 16.0f);
        this.hSA = (TextView) findViewById(R.h.other_acc_data_tv);
        this.hSA.setTextSize(1, 16.0f);
        this.hSB = (TextView) findViewById(R.h.other_data_tv);
        this.hSB.setTextSize(1, 16.0f);
        this.hSC = (TextView) findViewById(R.h.free_data_tv);
        this.hSC.setTextSize(1, 16.0f);
        this.hSE = (TextView) findViewById(R.h.clean_data_tv);
        this.hSF = (TextView) findViewById(R.h.clean_suggest_tv);
        this.hSJ = (TextView) findViewById(R.h.debug);
        this.hSK = (LinearLayout) findViewById(R.h.debug_root);
        this.hSG = (TextView) findViewById(R.h.wechat_tip);
        this.hSH = (TextView) findViewById(R.h.other_acc_tip);
        this.hSI = (TextView) findViewById(R.h.other_tip);
        this.hSD = findViewById(R.h.other_acc_data_layout);
        setMMTitle(R.l.clean_msg_ui_title);
        setBackBtn(new 1(this));
        this.hSy.setOnClickListener(new 2(this));
        this.hSx.setEnabled(true);
        this.hSx.setOnClickListener(new 3(this));
        getString(R.l.app_tip);
        this.eHw = com.tencent.mm.ui.base.h.a((Context) this, getString(R.l.clean_del_data), false, new 4(this));
        this.eHw.dismiss();
        c(j.aBt().hQC, j.aBt().hQD, j.aBt().hQE);
    }

    protected final int getLayoutId() {
        return R.i.clean_msg_ui;
    }

    private void c(long j, long j2, long j3) {
        int i;
        if (j <= 0) {
            j = 1;
            h.mEJ.a(714, 61, 1, false);
        }
        int i2 = (int) ((360 * j2) / j);
        if (j2 <= 0 || i2 >= 5) {
            i = i2;
        } else {
            i = 5;
        }
        i2 = 0;
        if (j3 > 0) {
            i2 = (int) ((360 * j3) / j);
            if (i2 < 5) {
                i2 = 5;
            }
        }
        long j4 = (j - j2) - j3;
        int i3 = (int) ((100 * j2) / j);
        int i4 = (int) ((100 * j3) / j);
        int i5 = (int) ((100 * j4) / j);
        x.i("MicroMsg.CleanMsgUI", "update acc[%d %d] otherAcc[%d %d] other[%d %d] wechat[%d] stack[%s]", new Object[]{Long.valueOf(j2), Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i4), Long.valueOf(j4), Integer.valueOf(i5), Long.valueOf(j), bi.cjd()});
        this.hSv.setGreenTargetAngle(i);
        this.hSv.setOtherAccTargetAngle(i2);
        this.hSv.setStage(1);
        this.hSu.setVisibility(0);
        this.hSz.setText(bi.bF(j2));
        this.hSA.setText(bi.bF(j3));
        this.hSB.setText(bi.bF(j4));
        if (j3 > 0) {
            this.hSD.setVisibility(0);
            this.hSy.setEnabled(true);
        } else {
            this.hSy.setEnabled(false);
            this.hSD.setVisibility(0);
        }
        this.hSG.setText(getString(R.l.clean_acc_tips));
        this.hSH.setText(getString(R.l.clean_other_acc_size_tips));
        this.hSI.setText(getString(R.l.clean_other_size_tips));
        if (((Integer) g.Ei().DT().get(a.sYn, Integer.valueOf(0))).intValue() > 0) {
            this.hSK.setVisibility(0);
            this.hSJ.setVisibility(0);
            TextView textView = this.hSJ;
            HashMap hashMap = j.aBt().hRp;
            StringBuffer stringBuffer = new StringBuffer();
            if (!hashMap.isEmpty()) {
                for (String str : hashMap.keySet()) {
                    stringBuffer.append(str).append(" : ").append(bi.bF(((Long) hashMap.get(str)).longValue())).append("\n");
                }
            }
            textView.setText(stringBuffer.toString());
        }
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        c(j.aBt().hQC, j.aBt().hQD, j.aBt().hQE);
    }
}
