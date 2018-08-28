package com.tencent.mm.plugin.backup.backupui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.ui.widget.d;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@a(3)
public class BackupSelectExtUI extends MMPreference {
    private int afv = 0;
    private f eOE;
    private long endTime = 0;
    private int gRy;
    private long gTv = 0;
    private int gVj = 0;
    private SimpleDateFormat gVk = new SimpleDateFormat("yyyy.MM.dd");
    private CheckPreference gYV;
    private CheckPreference gYW;
    private Preference gYX;
    private Preference gYY;
    private boolean gYZ = false;
    private long startTime = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eOE = this.tCL;
        initView();
    }

    public final int Ys() {
        return R.o.backup_select_ext_preference;
    }

    public final boolean a(f fVar, Preference preference) {
        if (preference.mKey.equals("backup_select_ext_time")) {
            this.gVj = this.gVj == 0 ? 1 : 0;
            switch (this.gVj) {
                case 0:
                    this.gYV.qpJ = false;
                    fVar.c(this.gYY);
                    fVar.c(this.gYX);
                    enableOptionMenu(true);
                    fVar.notifyDataSetChanged();
                    return true;
                case 1:
                    aL();
                    return true;
                default:
                    return true;
            }
        } else if (preference.mKey.equals("backup_select_ext_content")) {
            if (!this.gYZ) {
                return true;
            }
            int i;
            if (this.afv == 0) {
                i = 1;
            } else {
                i = 0;
            }
            this.afv = i;
            switch (this.afv) {
                case 0:
                    this.gYW.qpJ = false;
                    fVar.notifyDataSetChanged();
                    return true;
                case 1:
                    this.gYW.qpJ = true;
                    fVar.notifyDataSetChanged();
                    return true;
                default:
                    return true;
            }
        } else if (preference.mKey.equals("backup_select_begin_time")) {
            showDialog(1);
            return true;
        } else if (!preference.mKey.equals("backup_select_end_time")) {
            return false;
        } else {
            showDialog(2);
            return true;
        }
    }

    protected Dialog onCreateDialog(int i) {
        Calendar instance = Calendar.getInstance();
        switch (i) {
            case 1:
                instance.setTimeInMillis(this.startTime == 0 ? bi.VF() : this.startTime);
                break;
            case 2:
                instance.setTimeInMillis(this.endTime == 0 ? bi.VF() : this.endTime - 86400000);
                break;
        }
        Dialog dVar = new d(this.mController.tml, new 1(this, i), instance.get(1), instance.get(2), instance.get(5), instance.getTimeInMillis(), (byte) 0);
        dVar.setCanceledOnTouchOutside(false);
        long VF = (((bi.VF() / 86400000) * 86400000) + 57600000) - 1;
        if (VF > this.gTv) {
            dVar.gP(VF);
            dVar.gQ(this.gTv);
        }
        return dVar;
    }

    protected final void initView() {
        this.gRy = getIntent().getIntExtra("BACKUP_MODE", 0);
        setMMTitle(R.l.backup_select_ext_more_choose);
        this.gVj = getIntent().getIntExtra("BACKUP_SELECT_TIME_MODE", 0);
        this.gYZ = getIntent().getBooleanExtra("BACKUP_SELECT_SUPPORT_CONTENT_TYPE", false);
        this.afv = getIntent().getIntExtra("BACKUP_SELECT_CONTENT_TYPE", 0);
        this.startTime = getIntent().getLongExtra("BACKUP_SELECT_TIME_START_TIME", 0);
        this.endTime = getIntent().getLongExtra("BACKUP_SELECT_TIME_END_TIME", 0);
        this.gTv = getIntent().getLongExtra("BACKUP_SELECT_TIME_MIN_CONVERSATION_TIME", 0);
        aL();
        setBackBtn(new 2(this));
        a(0, getString(R.l.bak_chat_choose_finish), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (BackupSelectExtUI.this.gVj != 1 || BackupSelectExtUI.this.startTime < BackupSelectExtUI.this.endTime) {
                    Intent intent = new Intent();
                    intent.putExtra("BACKUP_SELECT_TIME_MODE", BackupSelectExtUI.this.gVj);
                    intent.putExtra("BACKUP_SELECT_CONTENT_TYPE", BackupSelectExtUI.this.afv);
                    intent.putExtra("BACKUP_SELECT_TIME_START_TIME", BackupSelectExtUI.this.startTime);
                    intent.putExtra("BACKUP_SELECT_TIME_END_TIME", BackupSelectExtUI.this.endTime);
                    BackupSelectExtUI.this.setResult(-1, intent);
                    BackupSelectExtUI.this.finish();
                } else if (BackupSelectExtUI.this.gRy == 1) {
                    h.b(BackupSelectExtUI.this.mController.tml, BackupSelectExtUI.this.getString(R.l.backup_pc_choose_time_finish_date_error), "", true);
                } else if (BackupSelectExtUI.this.gRy == 2) {
                    h.b(BackupSelectExtUI.this.mController.tml, BackupSelectExtUI.this.getString(R.l.backup_move_choose_time_finish_date_error), "", true);
                }
                return true;
            }
        }, b.tmX);
    }

    private void aL() {
        this.eOE.removeAll();
        this.eOE.addPreferencesFromResource(R.o.backup_select_ext_preference);
        this.gYV = (CheckPreference) this.eOE.ZZ("backup_select_ext_time");
        this.gYY = this.eOE.ZZ("backup_select_begin_time");
        this.gYX = this.eOE.ZZ("backup_select_end_time");
        this.gYW = (CheckPreference) this.eOE.ZZ("backup_select_ext_content");
        if (!this.gYZ) {
            this.eOE.c(this.eOE.ZZ("backup_select_ext_content_title"));
            this.eOE.c(this.gYW);
        }
        if (this.gRy == 1) {
            this.eOE.ZZ("backup_select_ext_time_title").setTitle(R.l.backup_pc_select_ext_time_title);
            this.gYV.setTitle(R.l.backup_pc_select_ext_time);
            if (this.gYZ) {
                this.eOE.ZZ("backup_select_ext_content_title").setTitle(R.l.backup_pc_select_ext_content_title);
                this.gYW.setTitle(R.l.backup_pc_select_ext_content_text_only);
            }
        } else if (this.gRy == 2) {
            this.eOE.ZZ("backup_select_ext_time_title").setTitle(R.l.backup_move_select_ext_time_title);
            this.gYV.setTitle(R.l.backup_move_select_ext_time);
            if (this.gYZ) {
                this.eOE.ZZ("backup_select_ext_content_title").setTitle(R.l.backup_move_select_ext_content_title);
                this.gYW.setTitle(R.l.backup_move_select_ext_content_text_only);
            }
        }
        switch (this.gVj) {
            case 0:
                this.gYY.setEnabled(false);
                this.gYX.setEnabled(false);
                this.gYV.qpJ = false;
                this.eOE.c(this.gYY);
                this.eOE.c(this.gYX);
                enableOptionMenu(true);
                break;
            case 1:
                boolean z;
                BackupSelectExtUI backupSelectExtUI;
                if (this.startTime != 0 && this.endTime != 0) {
                    this.gYY.setSummary(this.gVk.format(new Date(this.startTime)));
                    this.gYX.setSummary(this.gVk.format(new Date(this.endTime - 86400000)));
                    if (this.startTime != 0 && this.endTime != 0) {
                        z = true;
                        backupSelectExtUI = this;
                        backupSelectExtUI.enableOptionMenu(z);
                        this.gYY.setEnabled(true);
                        this.gYX.setEnabled(true);
                        this.gYV.qpJ = true;
                        break;
                    }
                    backupSelectExtUI = this;
                } else {
                    this.gYY.setSummary(R.l.backup_select_time_choose_date);
                    this.gYX.setSummary(R.l.backup_select_time_choose_date);
                    backupSelectExtUI = this;
                }
                z = false;
                backupSelectExtUI.enableOptionMenu(z);
                this.gYY.setEnabled(true);
                this.gYX.setEnabled(true);
                this.gYV.qpJ = true;
                break;
        }
        if (this.gYZ) {
            switch (this.afv) {
                case 0:
                    this.gYW.qpJ = false;
                    break;
                case 1:
                    this.gYW.qpJ = true;
                    break;
            }
        }
        this.eOE.notifyDataSetChanged();
    }
}
