package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.a.f;
import com.tencent.mm.plugin.backup.b.b.b;
import com.tencent.mm.plugin.backup.c.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.s;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class BackupMoveChooseUI extends MMWizardActivity implements b {
    private static int afv = 0;
    private static long endTime;
    private static int gVj = 0;
    private static long startTime;
    private a gUZ = new a(this);
    private ListView gVa;
    private View gVb;
    private TextView gVc;
    private CheckBox gVd;
    private TextView gVe;
    private TextView gVf;
    private RelativeLayout gVg;
    private TextView gVh;
    private ProgressBar gVi;
    private SimpleDateFormat gVk = new SimpleDateFormat("yyyy.MM.dd");

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public void onStart() {
        super.onStart();
        com.tencent.mm.plugin.backup.c.b.arv().arz().gTu = this;
    }

    public void onStop() {
        super.onStop();
        com.tencent.mm.plugin.backup.c.b.arv().arz().gTu = null;
    }

    public final void initView() {
        setMMTitle(R.l.backup_start_choose_move_records);
        this.gVa = (ListView) findViewById(R.h.backup_choose_conversation_lv);
        this.gVa.setAdapter(this.gUZ);
        this.gVa.setEmptyView(findViewById(R.h.backup_choose_empty_view));
        this.gVb = findViewById(R.h.backup_choose_select_all_click_area);
        this.gVc = (TextView) findViewById(R.h.backup_choose_session_info_tv);
        this.gVd = (CheckBox) findViewById(R.h.backup_choose_select_all_cb);
        this.gVe = (TextView) findViewById(R.h.backup_choose_select_all_tv);
        this.gVf = (TextView) findViewById(R.h.backup_choose_empty_tv);
        this.gVi = (ProgressBar) findViewById(R.h.backup_choose_loading_pb);
        this.gVg = (RelativeLayout) findViewById(R.h.backup_choose_ext_rl);
        this.gVh = (TextView) findViewById(R.h.backup_choose_ext_info_tv);
        if (!w.chL()) {
            this.gVc.setTextSize(1, 14.0f);
            this.gVe.setTextSize(1, 14.0f);
        }
        setBackBtn(new 1(this));
        a(0, getString(R.l.bak_chat_choose_finish), new 2(this), s.b.tmX);
        enableOptionMenu(false);
        dx(true);
        this.gVg.setOnClickListener(new 3(this));
        this.gVb.setOnClickListener(new 4(this));
        if (com.tencent.mm.plugin.backup.c.b.arv().arz().gTz) {
            if (com.tencent.mm.plugin.backup.c.b.arv().arz().arr() == null || com.tencent.mm.plugin.backup.c.b.arv().arz().arr().size() == 0) {
                switch (gVj) {
                    case 0:
                        this.gVf.setText(R.l.backup_move_choose_empty_records);
                        break;
                    case 1:
                        this.gVf.setText(R.l.backup_select_empty_records_in_select_time);
                        break;
                }
                this.gVf.setVisibility(0);
            }
            this.gVi.setVisibility(4);
        } else if (com.tencent.mm.plugin.backup.c.b.arv().arz().gTz) {
            this.gVi.setVisibility(4);
        } else {
            this.gVd.setClickable(false);
            this.gVd.setVisibility(4);
            this.gVe.setVisibility(4);
            this.gVi.setVisibility(0);
        }
    }

    private void dx(boolean z) {
        if (z) {
            com.tencent.mm.plugin.backup.c.b.arv();
            SharedPreferences aqU = com.tencent.mm.plugin.backup.c.b.aqU();
            gVj = aqU.getInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0);
            afv = aqU.getInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", 0);
            startTime = aqU.getLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0);
            endTime = aqU.getLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0);
        }
        switch (gVj) {
            case 0:
                this.gVh.setText("");
                break;
            case 1:
                this.gVh.setText(this.gVk.format(new Date(startTime)) + "~" + this.gVk.format(new Date(endTime - 86400000)));
                break;
        }
        if (afv == 1) {
            this.gVh.setText(this.gVh.getText() + (gVj == 1 ? ";" : "") + this.mController.tml.getResources().getString(R.l.backup_move_select_ext_content_text_only_short));
        }
    }

    public final void a(HashSet<Integer> hashSet) {
        LinkedList arr = com.tencent.mm.plugin.backup.c.b.arv().arz().arr();
        if (arr == null) {
            x.e("MicroMsg.BackupMoveChooseUI", "onClickCheckBox convInfo is null.");
            return;
        }
        HashSet hashSet2 = new HashSet();
        Iterator it = hashSet.iterator();
        long j = 0;
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            if (intValue < arr.size()) {
                j = ((f.b) arr.get(intValue)).gRL + j;
            } else {
                hashSet2.add(Integer.valueOf(intValue));
            }
        }
        Iterator it2 = hashSet2.iterator();
        while (it2.hasNext()) {
            hashSet.remove((Integer) it2.next());
        }
        if (hashSet.size() != 0 || j > 0) {
            enableOptionMenu(true);
            if (hashSet.size() == this.gUZ.getCount()) {
                this.gVd.setChecked(true);
            } else {
                this.gVd.setChecked(false);
            }
            this.gVc.setText(getString(R.l.backup_choose_session_info, new Object[]{Integer.valueOf(hashSet.size())}));
            return;
        }
        enableOptionMenu(false);
        this.gVd.setChecked(false);
        this.gVc.setText("");
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 != -1) {
            x.e("MicroMsg.BackupMoveChooseUI", "onActivityResult result error! resultCode:%d", Integer.valueOf(i2));
            return;
        }
        int i3 = gVj;
        long j = startTime;
        long j2 = endTime;
        gVj = intent.getIntExtra("BACKUP_SELECT_TIME_MODE", gVj);
        startTime = intent.getLongExtra("BACKUP_SELECT_TIME_START_TIME", 0);
        endTime = intent.getLongExtra("BACKUP_SELECT_TIME_END_TIME", 0);
        afv = intent.getIntExtra("BACKUP_SELECT_CONTENT_TYPE", afv);
        x.i("MicroMsg.BackupMoveChooseUI", "onActivityResult timeMode/preTimeMode[%d/%d], startTime/preStartTime[%d/%d], endTime/preEndTime[%d/%d], contentType[%d]", Integer.valueOf(gVj), Integer.valueOf(i3), Long.valueOf(startTime), Long.valueOf(j), Long.valueOf(endTime), Long.valueOf(j2), Integer.valueOf(afv));
        com.tencent.mm.plugin.backup.c.b.arv().arx();
        d.c(gVj, startTime, endTime, afv);
        dx(false);
        if (i3 == gVj) {
            if (gVj == 0) {
                return;
            }
            if (gVj == 1 && startTime == j && endTime == j2) {
                return;
            }
        }
        com.tencent.mm.plugin.backup.c.b.arv().arz().a(gVj, startTime, endTime, com.tencent.mm.plugin.backup.c.b.arv().arz().arq());
        a aVar = this.gUZ;
        aVar.gUV.clear();
        aVar.gUU.a(aVar.gUV);
        if (com.tencent.mm.plugin.backup.c.b.arv().arz().arr() == null || com.tencent.mm.plugin.backup.c.b.arv().arz().arr().size() == 0) {
            switch (gVj) {
                case 0:
                    this.gVf.setText(R.l.backup_move_choose_empty_records);
                    break;
                case 1:
                    this.gVf.setText(R.l.backup_select_empty_records_in_select_time);
                    break;
            }
            this.gVf.setVisibility(0);
        } else {
            this.gVf.setVisibility(4);
        }
        this.gUZ.notifyDataSetChanged();
    }

    protected final int getLayoutId() {
        return R.i.backup_choose;
    }

    public final void y(LinkedList<f.b> linkedList) {
        if (linkedList != null) {
            if (linkedList.size() == 0) {
                this.gVi.setVisibility(8);
                this.gVf.setVisibility(0);
                switch (gVj) {
                    case 0:
                        this.gVf.setText(R.l.backup_move_choose_empty_records);
                        return;
                    case 1:
                        this.gVf.setText(R.l.backup_select_empty_records_in_select_time);
                        return;
                    default:
                        return;
                }
            }
            this.gVd.setClickable(true);
            this.gVd.setVisibility(0);
            this.gVe.setVisibility(0);
            this.gVi.setVisibility(8);
            this.gUZ.notifyDataSetChanged();
        }
    }

    public final void a(LinkedList<f.b> linkedList, f.b bVar, int i) {
    }

    public final void z(LinkedList<f.b> linkedList) {
    }
}
