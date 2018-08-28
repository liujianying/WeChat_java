package com.tencent.mm.plugin.backup.backuppcui;

import android.support.design.a$i;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.opensdk.modelbase.BaseResp.ErrCode;
import com.tencent.mm.plugin.backup.a.b.c;
import com.tencent.mm.plugin.backup.a.e;
import com.tencent.mm.plugin.backup.a.g;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.plugin.backup.backuppcmodel.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.ui.base.h;

class BackupPcUI$3 implements c {
    final /* synthetic */ BackupPcUI gXl;

    BackupPcUI$3(BackupPcUI backupPcUI) {
        this.gXl = backupPcUI;
    }

    public final void aqN() {
        x.i("MicroMsg.BackupPcUI", "onBackupPcUpdateUICallback onBackupPcStart, commandMode[%d]", new Object[]{Integer.valueOf(b.arV().arW().gWw)});
        switch (b.arV().arW().gWw) {
            case 1:
                b.arV().aqP().gRC = 11;
                mw(11);
                return;
            case 2:
                b.arV().aqP().gRC = 21;
                mw(21);
                return;
            case 3:
                b.arV().aqP().gRC = 12;
                mw(12);
                return;
            case 4:
                b.arV().aqP().gRC = 22;
                mw(22);
                return;
            default:
                return;
        }
    }

    public final void mw(int i) {
        while (true) {
            x.i("MicroMsg.BackupPcUI", "onUpdateUIProgress backupPcState:%d", new Object[]{Integer.valueOf(i)});
            e aqP = b.arV().aqP();
            TextView c;
            BackupPcUI backupPcUI;
            int i2;
            Object[] objArr;
            switch (i) {
                case -100:
                    BackupPcUI.a(this.gXl);
                    return;
                case -23:
                    asi();
                    BackupPcUI.c(this.gXl).setText(R.l.backup_pc_error_empty_records);
                    BackupPcUI.d(this.gXl).setVisibility(4);
                    BackupPcUI.e(this.gXl).setVisibility(4);
                    BackupPcUI.f(this.gXl).setVisibility(4);
                    arQ();
                    return;
                case -22:
                    asi();
                    BackupPcUI.c(this.gXl).setText(R.l.backup_pc_error_miss_recover_merge_data);
                    b.arV().arw().stop();
                    BackupPcUI.d(this.gXl).setVisibility(4);
                    BackupPcUI.e(this.gXl).setVisibility(4);
                    BackupPcUI.f(this.gXl).setVisibility(4);
                    arQ();
                    return;
                case -21:
                    asi();
                    BackupPcUI.c(this.gXl).setText(R.l.backup_pc_error_programme_error);
                    BackupPcUI.d(this.gXl).setVisibility(4);
                    BackupPcUI.e(this.gXl).setVisibility(4);
                    BackupPcUI.f(this.gXl).setVisibility(4);
                    arQ();
                    return;
                case -13:
                    asi();
                    BackupPcUI.c(this.gXl).setText(R.l.backup_pc_error_not_enough_space_for_recover);
                    b.arV().arw().stop();
                    BackupPcUI.d(this.gXl).setVisibility(4);
                    BackupPcUI.e(this.gXl).setVisibility(4);
                    BackupPcUI.f(this.gXl).setVisibility(4);
                    arQ();
                    return;
                case ErrCode.ERR_UNSUPPORT /*-5*/:
                    asi();
                    BackupPcUI.c(this.gXl).setText(R.l.backup_pc_error_connect_fail);
                    BackupPcUI.d(this.gXl).setVisibility(4);
                    BackupPcUI.e(this.gXl).setVisibility(4);
                    BackupPcUI.f(this.gXl).setVisibility(4);
                    arQ();
                    return;
                case ErrCode.ERR_AUTH_DENIED /*-4*/:
                    if (1 == b.arV().arW().gWw || 3 == b.arV().arW().gWw) {
                        BackupPcUI.b(this.gXl).setImageResource(R.k.backup_pc_error);
                        BackupPcUI.c(this.gXl).setText(this.gXl.getString(R.l.backup_pc_transfer, new Object[]{Integer.valueOf(aqP.gRD), Integer.valueOf(aqP.gRE), "0M"}));
                        BackupPcUI.d(this.gXl).setText(R.l.backup_pc_error_network_disconnect);
                        BackupPcUI.f(this.gXl).setText(R.l.backup_pc_stop_backup);
                        BackupPcUI.f(this.gXl).setOnClickListener(new 3(this));
                    } else if (2 == b.arV().arW().gWw || 4 == b.arV().arW().gWw) {
                        BackupPcUI.b(this.gXl).setImageResource(R.k.backup_pc_recover_error);
                        BackupPcUI.c(this.gXl).setText(this.gXl.getString(R.l.backup_pc_recover_transfer, new Object[]{Integer.valueOf(aqP.gRD), Integer.valueOf(aqP.gRE), "0M"}));
                        BackupPcUI.d(this.gXl).setText(R.l.backup_pc_error_recover_network_disconnect);
                        BackupPcUI.f(this.gXl).setText(R.l.backup_pc_stop_transfer);
                        BackupPcUI.f(this.gXl).setOnClickListener(new 4(this));
                    }
                    BackupPcUI.d(this.gXl).setTextColor(this.gXl.getResources().getColor(R.e.backup_red));
                    BackupPcUI.d(this.gXl).setVisibility(0);
                    BackupPcUI.e(this.gXl).setVisibility(4);
                    BackupPcUI.f(this.gXl).setVisibility(0);
                    arS();
                    return;
                case -3:
                    asi();
                    BackupPcUI.c(this.gXl).setText(R.l.backup_pc_error_complex_wifi);
                    BackupPcUI.f(this.gXl).setText(R.l.backup_pc_error_see_connect_details);
                    BackupPcUI.d(this.gXl).setVisibility(4);
                    BackupPcUI.e(this.gXl).setVisibility(4);
                    BackupPcUI.f(this.gXl).setVisibility(0);
                    BackupPcUI.f(this.gXl).setOnClickListener(new 6(this));
                    arQ();
                    return;
                case -2:
                case -1:
                    asi();
                    BackupPcUI.c(this.gXl).setText(R.l.backup_pc_error_not_same_wifi);
                    String cQ = g.cQ(this.gXl);
                    if (cQ == null || cQ.equals("")) {
                        BackupPcUI.d(this.gXl).setText(this.gXl.getString(R.l.backup_pc_error_not_same_wifi_wifiname, new Object[]{b.arV().arW().gWx, "移动网络"}));
                    } else {
                        BackupPcUI.d(this.gXl).setText(this.gXl.getString(R.l.backup_pc_error_not_same_wifi_wifiname, new Object[]{b.arV().arW().gWx, cQ}));
                    }
                    BackupPcUI.d(this.gXl).setTextColor(this.gXl.getResources().getColor(R.e.backup_red));
                    BackupPcUI.f(this.gXl).setText(R.l.backup_pc_error_see_connect_details);
                    BackupPcUI.d(this.gXl).setVisibility(0);
                    BackupPcUI.e(this.gXl).setVisibility(4);
                    BackupPcUI.f(this.gXl).setVisibility(0);
                    BackupPcUI.f(this.gXl).setOnClickListener(new 5(this));
                    arQ();
                    return;
                case 1:
                    BackupPcUI.b(this.gXl).setImageResource(R.k.backup_pc_icon);
                    BackupPcUI.c(this.gXl).setText(R.l.backup_pc_connecting);
                    BackupPcUI.d(this.gXl).setVisibility(4);
                    BackupPcUI.e(this.gXl).setVisibility(4);
                    BackupPcUI.f(this.gXl).setVisibility(4);
                    arQ();
                    return;
                case 4:
                    switch (b.arV().arW().gWw) {
                        case 1:
                        case 3:
                            BackupPcUI.b(this.gXl).setImageResource(R.k.backup_pc_icon);
                            c = BackupPcUI.c(this.gXl);
                            backupPcUI = this.gXl;
                            i2 = R.l.backup_pc_transfer;
                            objArr = new Object[3];
                            objArr[0] = Integer.valueOf(aqP.gRD);
                            objArr[1] = Integer.valueOf(aqP.gRE);
                            b.arV().arW();
                            objArr[2] = com.tencent.mm.plugin.backup.backuppcmodel.c.asb();
                            c.setText(backupPcUI.getString(i2, objArr));
                            break;
                        case 2:
                        case 4:
                            BackupPcUI.b(this.gXl).setImageResource(R.k.backup_pc_recover_icon);
                            c = BackupPcUI.c(this.gXl);
                            backupPcUI = this.gXl;
                            i2 = R.l.backup_pc_recover_transfer;
                            objArr = new Object[3];
                            objArr[0] = Integer.valueOf(aqP.gRD);
                            objArr[1] = Integer.valueOf(aqP.gRE);
                            b.arV().arW();
                            objArr[2] = com.tencent.mm.plugin.backup.backuppcmodel.c.asb();
                            c.setText(backupPcUI.getString(i2, objArr));
                            break;
                    }
                    BackupPcUI.d(this.gXl).setText(R.l.backup_pc_transfer_weak_network);
                    BackupPcUI.d(this.gXl).setTextColor(this.gXl.getResources().getColor(R.e.backup_red));
                    BackupPcUI.d(this.gXl).setVisibility(0);
                    BackupPcUI.e(this.gXl).setVisibility(4);
                    BackupPcUI.f(this.gXl).setVisibility(4);
                    arS();
                    return;
                case 5:
                    switch (b.arV().arW().gWw) {
                        case 1:
                        case 3:
                            BackupPcUI.b(this.gXl).setImageResource(R.k.backup_pc_icon);
                            c = BackupPcUI.c(this.gXl);
                            backupPcUI = this.gXl;
                            i2 = R.l.backup_pc_transfer;
                            objArr = new Object[3];
                            objArr[0] = Integer.valueOf(aqP.gRD);
                            objArr[1] = Integer.valueOf(aqP.gRE);
                            b.arV().arW();
                            objArr[2] = com.tencent.mm.plugin.backup.backuppcmodel.c.asb();
                            c.setText(backupPcUI.getString(i2, objArr));
                            BackupPcUI.f(this.gXl).setText(R.l.backup_pc_stop_backup);
                            BackupPcUI.f(this.gXl).setOnClickListener(new 16(this));
                            break;
                        case 2:
                        case 4:
                            BackupPcUI.b(this.gXl).setImageResource(R.k.backup_pc_recover_icon);
                            c = BackupPcUI.c(this.gXl);
                            backupPcUI = this.gXl;
                            i2 = R.l.backup_pc_recover_transfer;
                            objArr = new Object[3];
                            objArr[0] = Integer.valueOf(aqP.gRD);
                            objArr[1] = Integer.valueOf(aqP.gRE);
                            b.arV().arW();
                            objArr[2] = com.tencent.mm.plugin.backup.backuppcmodel.c.asb();
                            c.setText(backupPcUI.getString(i2, objArr));
                            BackupPcUI.f(this.gXl).setText(R.l.backup_pc_stop_transfer);
                            BackupPcUI.f(this.gXl).setOnClickListener(new 2(this));
                            break;
                    }
                    BackupPcUI.d(this.gXl).setText(R.l.backup_pc_transfer_reconnecting);
                    BackupPcUI.d(this.gXl).setTextColor(this.gXl.getResources().getColor(R.e.backup_red));
                    BackupPcUI.d(this.gXl).setVisibility(0);
                    BackupPcUI.e(this.gXl).setVisibility(4);
                    BackupPcUI.f(this.gXl).setVisibility(0);
                    arS();
                    return;
                case 11:
                    BackupPcUI.b(this.gXl).setImageResource(R.k.backup_pc_icon);
                    BackupPcUI.c(this.gXl).setText(R.l.backup_pc_start_tip);
                    BackupPcUI.d(this.gXl).setText(R.l.backup_pc_start_no_new_message);
                    BackupPcUI.d(this.gXl).setTextColor(this.gXl.getResources().getColor(R.e.backup_status_content));
                    BackupPcUI.e(this.gXl).setText(R.l.backup_pc_start_backup_allrecords);
                    BackupPcUI.f(this.gXl).setText(R.l.backup_pc_start_choose_records);
                    BackupPcUI.d(this.gXl).setVisibility(0);
                    BackupPcUI.e(this.gXl).setVisibility(0);
                    BackupPcUI.f(this.gXl).setVisibility(0);
                    arQ();
                    BackupPcUI.e(this.gXl).setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            au.HU();
                            x.i("MicroMsg.BackupPcUI", "onBackupPcUpdateUICallback onUpdateUIProgress startbackup all, hasMove:%s", new Object[]{Boolean.valueOf(((Boolean) com.tencent.mm.model.c.DT().get(a.sVe, Boolean.valueOf(false))).booleanValue())});
                            if (((Boolean) com.tencent.mm.model.c.DT().get(a.sVe, Boolean.valueOf(false))).booleanValue()) {
                                h.a(BackupPcUI$3.this.gXl, R.l.backup_pc_has_move_tip, 0, R.l.backup_sure, 0, false, new 1(this), null, R.e.backup_green);
                                return;
                            }
                            b.arV().arW().mF(2);
                            b.arV().aqP().gRC = 12;
                            BackupPcUI$3.this.mw(12);
                            b.arV().arZ().cancel();
                            b.arV().arZ().art();
                            b.arV().arZ().dy(true);
                            com.tencent.mm.plugin.report.service.h.mEJ.a(400, 7, 1, false);
                            com.tencent.mm.plugin.report.service.h.mEJ.h(13735, new Object[]{Integer.valueOf(9), Integer.valueOf(b.arV().arW().gWC)});
                        }
                    });
                    BackupPcUI.f(this.gXl).setOnClickListener(new 9(this));
                    return;
                case 12:
                    BackupPcUI.b(this.gXl).setImageResource(R.k.backup_pc_icon);
                    BackupPcUI.c(this.gXl).setText(R.l.backup_pc_prepare);
                    BackupPcUI.d(this.gXl).setText(R.l.backup_pc_prepare_keep_screen_on);
                    BackupPcUI.d(this.gXl).setTextColor(this.gXl.getResources().getColor(R.e.backup_status_content));
                    BackupPcUI.d(this.gXl).setVisibility(0);
                    BackupPcUI.e(this.gXl).setVisibility(4);
                    BackupPcUI.f(this.gXl).setVisibility(4);
                    arS();
                    return;
                case 14:
                    BackupPcUI.b(this.gXl).setImageResource(R.k.backup_pc_icon);
                    c = BackupPcUI.c(this.gXl);
                    backupPcUI = this.gXl;
                    i2 = R.l.backup_pc_transfer;
                    objArr = new Object[3];
                    objArr[0] = Integer.valueOf(aqP.gRD);
                    objArr[1] = Integer.valueOf(aqP.gRE);
                    b.arV().arW();
                    objArr[2] = com.tencent.mm.plugin.backup.backuppcmodel.c.asb();
                    c.setText(backupPcUI.getString(i2, objArr));
                    BackupPcUI.d(this.gXl).setText(R.l.backup_pc_prepare_keep_screen_on);
                    BackupPcUI.d(this.gXl).setTextColor(this.gXl.getResources().getColor(R.e.backup_status_content));
                    BackupPcUI.d(this.gXl).setVisibility(0);
                    BackupPcUI.e(this.gXl).setVisibility(4);
                    BackupPcUI.f(this.gXl).setVisibility(4);
                    arS();
                    return;
                case 15:
                    BackupPcUI.b(this.gXl).setImageResource(R.k.backup_pc_finished);
                    BackupPcUI.c(this.gXl).setText(R.l.backup_pc_backup_finish);
                    BackupPcUI.d(this.gXl).setText(this.gXl.getString(R.l.backup_pc_backup_finish_detail, new Object[]{Integer.valueOf(aqP.gRD), Integer.valueOf(aqP.gRE)}));
                    BackupPcUI.d(this.gXl).setTextColor(this.gXl.getResources().getColor(R.e.backup_status_content));
                    BackupPcUI.e(this.gXl).setText(R.l.backup_finish);
                    BackupPcUI.d(this.gXl).setVisibility(0);
                    BackupPcUI.e(this.gXl).setVisibility(0);
                    BackupPcUI.f(this.gXl).setVisibility(4);
                    BackupPcUI.e(this.gXl).setOnClickListener(new 10(this));
                    arQ();
                    return;
                case 21:
                    BackupPcUI.b(this.gXl).setImageResource(R.k.backup_pc_recover_icon);
                    BackupPcUI.c(this.gXl).setText(R.l.backup_pc_recover_start_tip);
                    BackupPcUI.e(this.gXl).setText(R.l.backup_pc_recover_start_recover);
                    BackupPcUI.d(this.gXl).setVisibility(4);
                    BackupPcUI.e(this.gXl).setVisibility(0);
                    BackupPcUI.f(this.gXl).setVisibility(4);
                    BackupPcUI.e(this.gXl).setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            com.tencent.mm.plugin.report.service.h.mEJ.h(13735, new Object[]{Integer.valueOf(23), Integer.valueOf(b.arV().arW().gWC)});
                            b.arV().arW().mF(4);
                            b.arV().aqP().gRC = 22;
                            BackupPcUI$3.this.mw(22);
                            com.tencent.mm.plugin.report.service.h.mEJ.a(400, 16, 1, false);
                        }
                    });
                    arQ();
                    return;
                case 22:
                    BackupPcUI.b(this.gXl).setImageResource(R.k.backup_pc_recover_icon);
                    BackupPcUI.c(this.gXl).setText(R.l.backup_pc_prepare);
                    BackupPcUI.d(this.gXl).setText(R.l.backup_pc_prepare_keep_screen_on);
                    BackupPcUI.d(this.gXl).setTextColor(this.gXl.getResources().getColor(R.e.backup_status_content));
                    BackupPcUI.d(this.gXl).setVisibility(0);
                    BackupPcUI.e(this.gXl).setVisibility(4);
                    BackupPcUI.f(this.gXl).setVisibility(4);
                    arS();
                    return;
                case 23:
                    BackupPcUI.b(this.gXl).setImageResource(R.k.backup_pc_recover_icon);
                    c = BackupPcUI.c(this.gXl);
                    backupPcUI = this.gXl;
                    i2 = R.l.backup_pc_recover_transfer;
                    objArr = new Object[3];
                    objArr[0] = Integer.valueOf(aqP.gRD);
                    objArr[1] = Integer.valueOf(aqP.gRE);
                    b.arV().arW();
                    objArr[2] = com.tencent.mm.plugin.backup.backuppcmodel.c.asb();
                    c.setText(backupPcUI.getString(i2, objArr));
                    BackupPcUI.d(this.gXl).setText(R.l.backup_pc_prepare_keep_screen_on);
                    BackupPcUI.d(this.gXl).setTextColor(this.gXl.getResources().getColor(R.e.backup_status_content));
                    BackupPcUI.d(this.gXl).setVisibility(0);
                    BackupPcUI.e(this.gXl).setVisibility(4);
                    BackupPcUI.f(this.gXl).setVisibility(4);
                    arS();
                    return;
                case 24:
                    if (BackupPcUI.access$700()) {
                        BackupPcUI.b(this.gXl).setImageResource(R.k.backup_pc_recover_icon);
                        BackupPcUI.c(this.gXl).setText(R.l.backup_pc_recover_transfer_finish);
                        BackupPcUI.d(this.gXl).setText(R.l.backup_pc_recover_transfer_finish_tip);
                        BackupPcUI.d(this.gXl).setTextColor(this.gXl.getResources().getColor(R.e.backup_status_content));
                        BackupPcUI.e(this.gXl).setText(R.l.backup_pc_recover_start_merge);
                        BackupPcUI.f(this.gXl).setText(R.l.backup_pc_recover_stop_recover);
                        BackupPcUI.h(this.gXl).setText(R.l.backup_remind_later);
                        BackupPcUI.d(this.gXl).setVisibility(0);
                        BackupPcUI.e(this.gXl).setVisibility(0);
                        BackupPcUI.f(this.gXl).setVisibility(0);
                        BackupPcUI.e(this.gXl).setOnClickListener(new 12(this));
                        BackupPcUI.f(this.gXl).setOnClickListener(new 13(this));
                        BackupPcUI.h(this.gXl).setOnClickListener(new 14(this));
                        return;
                    } else if (bi.ci(this.gXl)) {
                        b.arV().arY();
                        if (d.arA()) {
                            b.arV().arY().arg();
                            return;
                        }
                        b.arV().aqP().gRC = -22;
                        mw(-22);
                        com.tencent.mm.plugin.report.service.h.mEJ.a(400, 64, 1, false);
                        return;
                    } else {
                        return;
                    }
                case 25:
                    if (bi.ci(this.gXl)) {
                        b.arV().aqP().gRC = 24;
                        i = 24;
                    } else {
                        return;
                    }
                case 26:
                    BackupPcUI.b(this.gXl).setImageResource(R.k.backup_pc_recover_icon);
                    BackupPcUI.c(this.gXl).setText(this.gXl.getString(R.l.backup_pc_recover_merge, new Object[]{Integer.valueOf(aqP.gRD), Integer.valueOf(aqP.gRE)}));
                    BackupPcUI.d(this.gXl).setText(R.l.backup_pc_recover_merge_tip);
                    BackupPcUI.d(this.gXl).setTextColor(this.gXl.getResources().getColor(R.e.backup_status_content));
                    BackupPcUI.h(this.gXl).setText(R.l.backup_pc_recover_stop_recover);
                    BackupPcUI.d(this.gXl).setVisibility(0);
                    BackupPcUI.e(this.gXl).setVisibility(4);
                    BackupPcUI.f(this.gXl).setVisibility(4);
                    arQ();
                    return;
                case a$i.AppCompatTheme_actionModeStyle /*27*/:
                    BackupPcUI.b(this.gXl).setImageResource(R.k.backup_pc_recover_finished);
                    BackupPcUI.c(this.gXl).setText(R.l.backup_pc_recover_merge_finish);
                    BackupPcUI.d(this.gXl).setText(this.gXl.getString(R.l.backup_pc_recover_merge_finish_detail, new Object[]{Integer.valueOf(aqP.gRD), Integer.valueOf(aqP.gRE)}));
                    BackupPcUI.d(this.gXl).setTextColor(this.gXl.getResources().getColor(R.e.backup_status_content));
                    BackupPcUI.e(this.gXl).setText(R.l.backup_finish);
                    BackupPcUI.d(this.gXl).setVisibility(0);
                    BackupPcUI.e(this.gXl).setVisibility(0);
                    BackupPcUI.f(this.gXl).setVisibility(4);
                    BackupPcUI.e(this.gXl).setOnClickListener(new 15(this));
                    arQ();
                    return;
                default:
                    return;
            }
        }
    }

    private void asi() {
        if (1 == b.arV().arW().gWw || 3 == b.arV().arW().gWw) {
            BackupPcUI.b(this.gXl).setImageResource(R.k.backup_pc_error);
        } else if (2 == b.arV().arW().gWw || 4 == b.arV().arW().gWw) {
            BackupPcUI.b(this.gXl).setImageResource(R.k.backup_pc_recover_error);
        }
    }

    private void arQ() {
        BackupPcUI.h(this.gXl).setText(R.l.backup_close);
        BackupPcUI.h(this.gXl).setOnClickListener(new 7(this));
    }

    private void arS() {
        BackupPcUI.h(this.gXl).setText(R.l.backup_minimize);
        BackupPcUI.h(this.gXl).setOnClickListener(new 8(this));
    }

    public final void aqO() {
    }
}
