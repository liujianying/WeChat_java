package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Looper;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.a.g;
import com.tencent.mm.plugin.backup.c.a;
import com.tencent.mm.plugin.backup.c.a.1;
import com.tencent.mm.plugin.backup.c.b;
import com.tencent.mm.plugin.backup.g.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;

public class BackupUI extends MMWizardActivity {
    private static boolean gVG = false;
    private al gUM = new al(Looper.getMainLooper(), new 4(this), true);
    private Button gVF;
    private TextView gVs;
    private TextView gVu;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            setMMTitle(R.l.backup_move);
            h.mEJ.h(11788, new Object[]{Integer.valueOf(1)});
            this.gVu = (TextView) findViewById(R.h.backup_move_status_content);
            this.gVF = (Button) findViewById(R.h.backup_move_bt);
            this.gVs = (TextView) findViewById(R.h.backup_move_bottom_btn);
            b.arv();
            Editor edit = b.aqU().edit();
            edit.putInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0);
            edit.putInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", 0);
            edit.putLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0);
            edit.putLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0);
            edit.commit();
            if (b.arv().arz().gTz) {
                b.arv().arz().aru();
            } else {
                a arz = b.arv().arz();
                d.asG().asJ();
                e.post(new 1(arz), "BakMoveChooseServer.calculateToChoose");
            }
            if (bi.oW(g.cQ(this))) {
                this.gVu.setText(R.l.backup_status_content_no_wifi);
                this.gVu.setTextColor(getResources().getColor(R.e.backup_red));
                this.gVF.setEnabled(false);
                gVG = false;
                h.mEJ.h(11788, new Object[]{Integer.valueOf(2)});
            } else {
                this.gVu.setText(R.l.backup_status_content_open_wifi);
                this.gVu.setTextColor(getResources().getColor(R.e.backup_green));
                this.gVF.setEnabled(true);
                gVG = true;
            }
            this.gVF.setOnClickListener(new 1(this));
            this.gVs.setOnClickListener(new 2(this));
            setBackBtn(new 3(this));
        }
    }

    public void onStart() {
        super.onStart();
        this.gUM.J(5000, 5000);
    }

    public void onStop() {
        super.onStop();
        this.gUM.SO();
    }

    public void onDestroy() {
        x.d("MicroMsg.BackupUI", "BackupUI onDestroy.");
        super.onDestroy();
        b.arv().arz().cancel();
        b.arv().arz().art();
    }

    protected final int getLayoutId() {
        return R.i.backup_ui;
    }
}
