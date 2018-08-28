package com.tencent.mm.plugin.clean.ui.newui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.clean.c.a;
import com.tencent.mm.plugin.clean.c.b;
import com.tencent.mm.plugin.clean.c.c;
import com.tencent.mm.plugin.clean.c.d;
import com.tencent.mm.plugin.clean.c.e;
import com.tencent.mm.plugin.clean.c.g;
import com.tencent.mm.plugin.clean.c.h;
import com.tencent.mm.plugin.clean.ui.PieView;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class CleanMsgUI extends MMActivity implements g, h {
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
    private View hSu;
    private PieView hSv;
    private TextView hSw;
    private Button hSx;
    private Button hSy;
    private TextView hSz;
    private e hTq;
    private c hTw;

    static /* synthetic */ void a(CleanMsgUI cleanMsgUI) {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        arrayList.add(cleanMsgUI.getString(R.l.quick_clean));
        arrayList2.add(Integer.valueOf(0));
        com.tencent.mm.ui.base.h.a((Context) cleanMsgUI, null, arrayList, arrayList2, null, false, new 6(cleanMsgUI));
    }

    static /* synthetic */ long aBA() {
        Calendar instance = Calendar.getInstance();
        if (instance.get(2) <= 3) {
            instance.set(instance.get(1) - 1, instance.get(2) + 9, instance.get(5));
        } else {
            instance.set(instance.get(1), instance.get(2) - 3, instance.get(5));
        }
        long timeInMillis = instance.getTimeInMillis();
        long j = 0;
        if (d.aBi() == null) {
            return 0;
        }
        Iterator it = d.aBi().iterator();
        while (true) {
            long j2 = j;
            if (!it.hasNext()) {
                return j2;
            }
            b bVar = (b) it.next();
            if (bVar.hQM != null) {
                Iterator it2 = bVar.hQM.iterator();
                while (it2.hasNext()) {
                    a aVar = (a) it2.next();
                    if (aVar.enK < timeInMillis) {
                        j2 += aVar.size;
                    }
                }
            }
            j = j2;
        }
    }

    static /* synthetic */ ArrayList aBB() {
        Calendar instance = Calendar.getInstance();
        if (instance.get(2) <= 3) {
            instance.set(instance.get(1) - 1, instance.get(2) + 9, instance.get(5));
        } else {
            instance.set(instance.get(1), instance.get(2) - 3, instance.get(5));
        }
        long timeInMillis = instance.getTimeInMillis();
        ArrayList arrayList = new ArrayList();
        for (int size = d.aBi().size() - 1; size >= 0; size--) {
            b bVar = (b) d.aBi().get(size);
            for (int size2 = bVar.hQM.size() - 1; size2 >= 0; size2--) {
                if (((a) bVar.hQM.get(size2)).enK < timeInMillis) {
                    arrayList.add(bVar.hQM.get(size2));
                    bVar.hQM.remove(size2);
                }
            }
            if (!bVar.aAY()) {
                d.aBi().remove(size);
            }
        }
        return arrayList;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.plugin.report.service.h.mEJ.a(282, 3, 1, false);
        d.aBp();
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
        this.hSG = (TextView) findViewById(R.h.wechat_tip);
        this.hSH = (TextView) findViewById(R.h.other_acc_tip);
        this.hSI = (TextView) findViewById(R.h.other_tip);
        this.hSD = findViewById(R.h.other_acc_data_layout);
        setMMTitle(R.l.clean_ui_title);
        d.a(new com.tencent.mm.plugin.clean.c.a.b());
        setBackBtn(new 1(this));
        this.hSy.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                com.tencent.mm.ui.base.h.a(CleanMsgUI.this, CleanMsgUI.this.getString(R.l.clean_other_acc_tips, new Object[]{bi.gc(d.aBl())}), "", CleanMsgUI.this.getString(R.l.app_ok), CleanMsgUI.this.getString(R.l.app_cancel), new 1(this), null);
            }
        });
        this.hSx.setOnClickListener(new 3(this));
        addIconOptionMenu(0, R.k.actionbar_icon_dark_more, new 4(this));
        enableOptionMenu(0, false);
        getString(R.l.app_tip);
        this.eHw = com.tencent.mm.ui.base.h.a((Context) this, getString(R.l.clean_del_data), false, new 5(this));
        this.eHw.dismiss();
        if (d.aBi() != null) {
            this.hSw.setVisibility(8);
            this.hSx.setEnabled(true);
            enableOptionMenu(0, true);
            d.aBm();
            d(d.aBj(), d.aBl(), d.aBk());
            return;
        }
        com.tencent.mm.plugin.clean.c.a.b aBg = d.aBg();
        if (aBg != null) {
            this.hTw = new c(aBg, this);
            com.tencent.mm.sdk.f.e.post(this.hTw, "CleanUI_clean");
            this.hSw.setText(getString(R.l.analyse_file_profress, new Object[]{"0%"}));
        }
    }

    protected final int getLayoutId() {
        return R.i.clean_msg_ui;
    }

    private void d(long j, long j2, long j3) {
        int i;
        int i2 = (int) ((360 * j3) / j);
        if (i2 < 5) {
            i = 5;
        } else {
            i = i2;
        }
        i2 = 0;
        if (j2 > 0) {
            i2 = (int) ((360 * j2) / j);
            if (i2 < 5) {
                i2 = 5;
            }
        }
        long j4 = (j - j3) - j2;
        int i3 = (int) ((360 * j4) / j);
        x.i("MicroMsg.CleanMsgUI", "update [%d %d] [%d %d] [%d %d] wechatSize[%d]", new Object[]{Long.valueOf(j3), Integer.valueOf(i), Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j4), Integer.valueOf(i3), Long.valueOf(j)});
        this.hSv.setGreenTargetAngle(i);
        this.hSv.setOtherAccTargetAngle(i2);
        this.hSv.setStage(1);
        this.hSu.setVisibility(0);
        this.hSz.setText(bi.bF(j3));
        this.hSA.setText(bi.bF(j2));
        this.hSB.setText(bi.bF(j4));
        if (j2 > 0) {
            this.hSD.setVisibility(0);
            this.hSy.setVisibility(0);
        } else {
            this.hSy.setVisibility(8);
            this.hSD.setVisibility(8);
        }
        i2 = (int) ((100 * j3) / j);
        this.hSG.setText(getString(R.l.clean_acc_tips, new Object[]{i2 + "%"}));
        i2 = (int) ((100 * j2) / j);
        this.hSH.setText(getString(R.l.clean_other_acc_size_tips, new Object[]{i2 + "%"}));
        i2 = (int) ((100 * j4) / j);
        this.hSI.setText(getString(R.l.clean_other_size_tips, new Object[]{i2 + "%"}));
    }

    protected void onDestroy() {
        if (this.hTw != null) {
            c cVar = this.hTw;
            x.i("MicroMsg.CleanController", "stop CleanController [%d]", new Object[]{Integer.valueOf(cVar.hashCode())});
            cVar.isStop = true;
            com.tencent.mm.sdk.f.e.S(cVar);
        }
        if (this.hTq != null) {
            this.hTq.aBr();
        }
        if (d.aBg() != null) {
            com.tencent.mm.plugin.clean.c.a.b aBg = d.aBg();
            for (ag removeCallbacksAndMessages : aBg.hRt.values()) {
                removeCallbacksAndMessages.removeCallbacksAndMessages(null);
            }
            for (ag removeCallbacksAndMessages2 : aBg.hRt.values()) {
                removeCallbacksAndMessages2.getLooper().getThread().interrupt();
                removeCallbacksAndMessages2.getLooper().quit();
            }
            x.i("MicroMsg.ThreadController", "finish thread controller [%d]", new Object[]{Integer.valueOf(aBg.hashCode())});
        }
        d.aBq();
        d.aBo();
        super.onDestroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        d.aBm();
        d(d.aBj(), d.aBl(), d.aBk());
    }

    public final void cp(int i, int i2) {
        this.hSw.setText(getString(R.l.analyse_file_profress, new Object[]{((i * 100) / i2) + "%"}));
    }

    public final void a(long j, long j2, long j3, ArrayList<b> arrayList, long j4, HashSet<String> hashSet) {
        x.i("MicroMsg.CleanMsgUI", "%d on clean result cleanDataSize[%d] wechatSize[%d] otherAccSize[%d]", new Object[]{Integer.valueOf(hashCode()), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j4)});
        this.hSw.setVisibility(8);
        this.hSx.setEnabled(true);
        enableOptionMenu(0, true);
        d(j2, j4, j3);
        if (j > 0) {
            this.hSE.setVisibility(0);
            this.hSE.setText(getString(R.l.clean_del_temp_data, new Object[]{bi.bF(j)}));
        } else {
            this.hSE.setVisibility(8);
            this.hSE.setText("");
        }
        d.ci(j);
        d.cf(j2);
        d.ch(j4);
        d.b(hashSet);
        d.cg(j3);
        d.m(arrayList);
        if (j4 > 0) {
            com.tencent.mm.plugin.report.service.h.mEJ.a(282, 9, 1, false);
        } else {
            com.tencent.mm.plugin.report.service.h.mEJ.a(282, 10, 1, false);
        }
    }

    public final void cq(int i, int i2) {
        this.eHw.setMessage(getString(R.l.clean_progress_tip, new Object[]{((i * 100) / i2) + "%"}));
    }

    public final void ck(long j) {
        this.eHw.dismiss();
        d.cf(d.aBj() - j);
        d.ci(d.aBm() + j);
        d.aBm();
        d(d.aBj(), d.aBl(), d.aBk());
    }
}
