package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.design.a$i;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelbase.BaseResp.ErrCode;
import com.tencent.mm.plugin.backup.a.b.d;
import com.tencent.mm.plugin.backup.a.e;
import com.tencent.mm.plugin.backup.a.g;
import com.tencent.mm.plugin.backup.c.b;
import com.tencent.mm.plugin.backup.c.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import java.lang.reflect.Method;

@a(3)
public class BackupMoveRecoverUI extends MMWizardActivity implements d {
    private static boolean eFl = false;
    private static boolean gVx = false;
    public TextView gVr;
    public TextView gVs;
    public TextView gVt;
    public TextView gVu;
    public TextView gVv;
    public ImageView gVw;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            x.i("MicroMsg.BackupMoveRecoverUI", "onCreate.");
            getSupportActionBar().hide();
            com.tencent.mm.plugin.backup.a.ezn.vo();
            initView();
            try {
                Method method = WifiManager.class.getMethod("isWifiApEnabled", new Class[0]);
                WifiManager wifiManager = (WifiManager) getSystemService(TencentLocationListener.WIFI);
                b.arv().ary().gTY = ((Boolean) method.invoke(wifiManager, new Object[0])).booleanValue();
                x.d("MicroMsg.BackupMoveRecoverUI", "new isWifiAp:%s", new Object[]{Boolean.valueOf(b.arv().ary().gTY)});
            } catch (Exception e) {
                x.e("MicroMsg.BackupMoveRecoverUI", "no such method WifiManager.isWifiApEnabled:%s", new Object[]{bi.cjd()});
            }
        }
    }

    public final void initView() {
        this.gVv = (TextView) findViewById(R.h.backup_close_btn);
        this.gVw = (ImageView) findViewById(R.h.backup_image);
        this.gVt = (TextView) findViewById(R.h.backup_status_title);
        this.gVu = (TextView) findViewById(R.h.backup_status_content);
        this.gVr = (TextView) findViewById(R.h.backup_btn);
        this.gVs = (TextView) findViewById(R.h.backup_bottom_btn);
    }

    public void onResume() {
        super.onResume();
        x.i("MicroMsg.BackupMoveRecoverUI", "onResume.");
        gVx = true;
        b.arv().ary().gSW = this;
        eFl = getIntent().getBooleanExtra("isRecoverTransferFinishFromBanner", false);
        mw(b.arv().aqP().gRC);
    }

    protected void onPause() {
        super.onPause();
        x.i("MicroMsg.BackupMoveRecoverUI", "onPause.");
        gVx = false;
    }

    public void onDestroy() {
        x.i("MicroMsg.BackupMoveRecoverUI", "BackupMoveRecoverUI onDestroy.");
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        arR();
        return true;
    }

    public final void mw(int i) {
        Context context = this;
        while (true) {
            e aqP = b.arv().aqP();
            x.i("MicroMsg.BackupMoveRecoverUI", "onUpdateUIProgress state[%d], isActivityOnTop[%b], transferSession[%d], totalSession[%d]", new Object[]{Integer.valueOf(i), Boolean.valueOf(gVx), Integer.valueOf(aqP.gRD), Integer.valueOf(aqP.gRE)});
            TextView textView;
            int i2;
            Object[] objArr;
            switch (i) {
                case -100:
                    DT(1);
                    return;
                case -22:
                    context.gVw.setImageResource(R.k.backup_move_error);
                    context.gVt.setText(R.l.backup_pc_error_miss_recover_merge_data);
                    b.arv().arw().stop();
                    context.gVu.setVisibility(4);
                    context.gVr.setVisibility(4);
                    context.gVs.setVisibility(4);
                    arQ();
                    return;
                case -21:
                    context.gVw.setImageResource(R.k.backup_move_error);
                    context.gVt.setText(R.l.backup_pc_error_programme_error);
                    context.gVu.setVisibility(4);
                    context.gVr.setVisibility(4);
                    context.gVs.setVisibility(4);
                    arQ();
                    return;
                case -13:
                    context.gVw.setImageResource(R.k.backup_move_error);
                    context.gVt.setText(R.l.backup_move_error_not_enough_space_for_recover);
                    context.gVu.setText(getString(R.l.backup_move_error_not_enough_space_for_recover_tip, new Object[]{bi.bF(b.arv().ary().gUm)}));
                    context.gVu.setVisibility(0);
                    context.gVr.setVisibility(4);
                    context.gVs.setVisibility(4);
                    arQ();
                    return;
                case -12:
                    context.gVw.setImageResource(R.k.backup_move);
                    context.gVt.setText(R.l.backup_move_connecting);
                    context.gVu.setText(R.l.backup_move_keep_screen_on);
                    context.gVu.setVisibility(0);
                    context.gVr.setVisibility(4);
                    context.gVs.setVisibility(4);
                    arQ();
                    h.a(context, R.l.backup_move_error_move_phone_old_version, 0, R.l.backup_sure, 0, false, new 5(context), null, R.e.backup_green);
                    return;
                case ErrCode.ERR_UNSUPPORT /*-5*/:
                    context.gVw.setImageResource(R.k.backup_move_error);
                    context.gVt.setText(R.l.backup_move_error_connect_fail);
                    context.gVr.setText(R.l.backup_move_recover_scan_qrcode_again);
                    context.gVs.setText(R.l.backup_move_recover_stop_move);
                    context.gVu.setVisibility(4);
                    context.gVr.setVisibility(0);
                    context.gVs.setVisibility(0);
                    context.gVr.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            com.tencent.mm.plugin.report.service.h.mEJ.h(11788, new Object[]{Integer.valueOf(9)});
                            Intent intent = new Intent();
                            intent.putExtra("BaseScanUI_select_scan_mode", 1);
                            intent.setFlags(268435456);
                            com.tencent.mm.bg.d.b(BackupMoveRecoverUI.this.mController.tml, "scanner", ".ui.BaseScanUI", intent);
                        }
                    });
                    context.gVs.setOnClickListener(new 4(context, i));
                    arQ();
                    return;
                case ErrCode.ERR_AUTH_DENIED /*-4*/:
                    context.gVw.setImageResource(R.k.backup_move_error);
                    context.gVt.setText(getString(R.l.backup_move_network_disconnect_transfer_state, new Object[]{Integer.valueOf(aqP.gRD), Integer.valueOf(aqP.gRE), "0M"}));
                    context.gVu.setText(R.l.backup_move_error_network_disconnect);
                    context.gVr.setText(R.l.backup_move_recover_scan_qrcode_again);
                    context.gVs.setText(R.l.backup_move_recover_stop_move);
                    context.gVr.setOnClickListener(new 15(context));
                    context.gVs.setOnClickListener(new 16(context, i));
                    context.gVu.setTextColor(getResources().getColor(R.e.backup_red));
                    context.gVu.setVisibility(0);
                    context.gVr.setVisibility(0);
                    context.gVs.setVisibility(0);
                    arS();
                    return;
                case -3:
                    context.gVw.setImageResource(R.k.backup_move_error);
                    context.gVt.setText(R.l.backup_move_error_complex_wifi);
                    context.gVu.setText(R.l.backup_move_error_complex_wifi_wifiap_tip);
                    context.gVr.setText(R.l.backup_move_recover_open_wifia_word);
                    context.gVs.setText(R.l.backup_move_recover_stop_move);
                    context.gVu.setTextColor(getResources().getColor(R.e.backup_red));
                    context.gVu.setVisibility(0);
                    context.gVr.setVisibility(0);
                    context.gVs.setVisibility(0);
                    context.gVr.setOnClickListener(new 17(context));
                    context.gVs.setOnClickListener(new 2(context, i));
                    arQ();
                    return;
                case -2:
                case -1:
                    context.gVw.setImageResource(R.k.backup_move_error);
                    context.gVt.setText(R.l.backup_move_error_not_same_wifi);
                    String cQ = g.cQ(context);
                    if (cQ == null || cQ.equals("")) {
                        context.gVu.setText(getString(R.l.backup_move_error_not_same_wifi_wifiname, new Object[]{"移动网络", b.arv().ary().gUe}));
                    } else {
                        context.gVu.setText(getString(R.l.backup_move_error_not_same_wifi_wifiname, new Object[]{cQ, b.arv().ary().gUe}));
                    }
                    context.gVu.setTextColor(getResources().getColor(R.e.backup_red));
                    context.gVu.setVisibility(0);
                    context.gVr.setVisibility(4);
                    context.gVs.setVisibility(4);
                    arQ();
                    return;
                case 1:
                    context.gVw.setImageResource(R.k.backup_move);
                    context.gVt.setText(R.l.backup_move_connecting);
                    context.gVu.setText(R.l.backup_move_keep_screen_on);
                    context.gVu.setVisibility(0);
                    context.gVr.setVisibility(4);
                    context.gVs.setVisibility(4);
                    arQ();
                    return;
                case 3:
                    finish();
                    return;
                case 4:
                    context.gVw.setImageResource(R.k.backup_move);
                    textView = context.gVt;
                    i2 = R.l.backup_move_recover_transfer;
                    objArr = new Object[3];
                    objArr[0] = Integer.valueOf(aqP.gRD);
                    objArr[1] = Integer.valueOf(aqP.gRE);
                    b.arv().ary();
                    objArr[2] = c.arD();
                    textView.setText(getString(i2, objArr));
                    context.gVu.setText(R.l.backup_pc_transfer_weak_network);
                    context.gVu.setTextColor(getResources().getColor(R.e.backup_red));
                    context.gVu.setVisibility(0);
                    context.gVr.setVisibility(4);
                    context.gVs.setVisibility(4);
                    arS();
                    return;
                case 22:
                    context.gVw.setImageResource(R.k.backup_move);
                    context.gVt.setText(R.l.backup_move_recover_preparing);
                    context.gVu.setText(R.l.backup_move_keep_screen_on);
                    context.gVu.setTextColor(getResources().getColor(R.e.backup_status_content));
                    context.gVu.setVisibility(0);
                    context.gVr.setVisibility(4);
                    context.gVs.setVisibility(4);
                    arS();
                    return;
                case 23:
                    context.gVw.setImageResource(R.k.backup_move);
                    textView = context.gVt;
                    i2 = R.l.backup_move_recover_transfer;
                    objArr = new Object[3];
                    objArr[0] = Integer.valueOf(aqP.gRD);
                    objArr[1] = Integer.valueOf(aqP.gRE);
                    b.arv().ary();
                    objArr[2] = c.arD();
                    textView.setText(getString(i2, objArr));
                    context.gVu.setText(R.l.backup_move_keep_screen_on);
                    context.gVu.setTextColor(getResources().getColor(R.e.backup_status_content));
                    context.gVu.setVisibility(0);
                    context.gVr.setVisibility(4);
                    context.gVs.setVisibility(4);
                    arS();
                    return;
                case 24:
                    x.i("MicroMsg.BackupMoveRecoverUI", "backupmove BACKUP_STATE_RECOVER_TRANSFER_FINISH isFromBanner[%b]", new Object[]{Boolean.valueOf(eFl)});
                    if (eFl) {
                        context.gVw.setImageResource(R.k.backup_move);
                        context.gVt.setText(R.l.backup_move_recover_transfer_finish);
                        context.gVu.setText(R.l.backup_move_recover_transfer_finish_tip);
                        context.gVu.setTextColor(getResources().getColor(R.e.backup_status_content));
                        context.gVr.setText(R.l.backup_move_recover_start_merge);
                        context.gVs.setText(R.l.backup_move_recover_stop_merge);
                        context.gVv.setText(R.l.backup_remind_later);
                        context.gVu.setVisibility(0);
                        context.gVr.setVisibility(0);
                        context.gVs.setVisibility(0);
                        context.gVr.setOnClickListener(new 11(context));
                        context.gVs.setOnClickListener(new 12(context, i));
                        context.gVv.setOnClickListener(new 13(context));
                        return;
                    } else if (gVx) {
                        b.arv().ary();
                        if (c.arA()) {
                            b.arv().ary().arg();
                            return;
                        }
                        x.e("MicroMsg.BackupMoveRecoverUI", "miss recover merge data.");
                        b.arv().aqP().gRC = -22;
                        mw(-22);
                        com.tencent.mm.plugin.report.service.h.mEJ.a(485, 6, 1, false);
                        return;
                    } else {
                        return;
                    }
                case 25:
                    if (gVx) {
                        b.arv().aqP().gRC = 24;
                        i = 24;
                    } else {
                        return;
                    }
                case 26:
                    context.gVw.setImageResource(R.k.backup_move_recover);
                    context.gVt.setText(getString(R.l.backup_move_recover_merging, new Object[]{Integer.valueOf(aqP.gRD), Integer.valueOf(aqP.gRE)}));
                    context.gVu.setText(R.l.backup_move_recover_merging_tip);
                    context.gVu.setTextColor(getResources().getColor(R.e.backup_status_content));
                    context.gVu.setVisibility(0);
                    context.gVr.setVisibility(4);
                    context.gVs.setVisibility(4);
                    arQ();
                    return;
                case a$i.AppCompatTheme_actionModeStyle /*27*/:
                    context.gVw.setImageResource(R.k.backup_move_recover_finish);
                    context.gVt.setText(R.l.backup_move_recover_merge_finish);
                    context.gVu.setText(getString(R.l.backup_move_recover_merge_finish_detail, new Object[]{Integer.valueOf(aqP.gRD), Integer.valueOf(aqP.gRE)}));
                    context.gVu.setTextColor(getResources().getColor(R.e.backup_status_content));
                    context.gVr.setText(R.l.backup_finish);
                    context.gVu.setVisibility(0);
                    context.gVr.setVisibility(0);
                    context.gVs.setVisibility(4);
                    context.gVr.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            b.arv().arw().stop();
                            b.arv().aqP().gRC = -100;
                            BackupMoveRecoverUI.this.DT(1);
                        }
                    });
                    arQ();
                    return;
                case 52:
                    context.gVw.setImageResource(R.k.backup_move);
                    context.gVt.setText(R.l.backup_move_has_move_before);
                    context.gVr.setText(R.l.backup_move_has_move_before_move_resume);
                    context.gVs.setText(R.l.backup_move_has_move_before_move_all);
                    context.gVu.setVisibility(4);
                    context.gVr.setVisibility(0);
                    context.gVs.setVisibility(0);
                    context.gVr.setOnClickListener(new 1(context));
                    context.gVs.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            b.arv().ary().du(true);
                        }
                    });
                    arQ();
                    return;
                default:
                    return;
            }
        }
    }

    public final void aqO() {
    }

    private void arQ() {
        this.gVv.setText(R.l.backup_close);
        this.gVv.setOnClickListener(new 6(this));
    }

    private void arR() {
        int i = b.arv().aqP().gRC;
        x.i("MicroMsg.BackupMoveRecoverUI", "close btn, backupPcState:%d, backupPcState:%d ", new Object[]{Integer.valueOf(i), Integer.valueOf(i)});
        switch (i) {
            case -22:
            case -21:
            case -13:
            case ErrCode.ERR_UNSUPPORT /*-5*/:
            case -3:
            case -2:
            case -1:
            case 1:
                b.arv().ary().a(false, false, -100);
                return;
            case 24:
                b.arv().aqP().gRC = 25;
                break;
            case 26:
                h.a((Context) this, R.l.backup_pc_error_alert_stop_recover_tip, R.l.backup_pc_error_alert_stop_recover, R.l.backup_pc_stop_recover, R.l.backup_cancel, false, new 8(this, i), null, R.e.backup_red);
                return;
            case a$i.AppCompatTheme_actionModeStyle /*27*/:
                x.i("MicroMsg.BackupMoveRecoverUI", "recover finish, user click close, backupState[%d].", new Object[]{Integer.valueOf(i)});
                b.arv().ary().a(true, false, -100);
                b.arv().arw().stop();
                return;
            case 52:
                h.a((Context) this, R.l.backup_move_error_alert_stop_move_tip, R.l.backup_move_error_alert_stop_move, R.l.backup_move_recover_stop_move, R.l.backup_cancel, false, new 7(this, i), null, R.e.backup_red);
                return;
        }
        DT(1);
    }

    private void arS() {
        this.gVv.setText(R.l.backup_minimize);
        this.gVv.setOnClickListener(new 9(this));
    }

    protected final int getLayoutId() {
        return R.i.backup_pc;
    }
}
