package com.tencent.mm.plugin.backup.backupmoveui;

import android.graphics.BitmapFactory;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.a.b.d;
import com.tencent.mm.plugin.backup.a.c;
import com.tencent.mm.plugin.backup.a.e;
import com.tencent.mm.plugin.backup.c.b;
import com.tencent.mm.plugin.game.f$k;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.lang.reflect.Method;

@a(3)
public class BackupMoveUI extends MMWizardActivity implements d {
    public TextView gVr;
    public TextView gVs;
    public TextView gVt;
    public TextView gVu;
    public TextView gVv;
    public ImageView gVw;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            x.i("MicroMsg.BackupMoveUI", "onCreate.");
            getSupportActionBar().hide();
            com.tencent.mm.plugin.backup.a.ezn.vo();
            initView();
            try {
                Method method = WifiManager.class.getMethod("isWifiApEnabled", new Class[0]);
                WifiManager wifiManager = (WifiManager) getSystemService("wifi");
                b.arv().arx().gTY = ((Boolean) method.invoke(wifiManager, new Object[0])).booleanValue();
                x.d("MicroMsg.BackupMoveUI", "old isWifiAp:%s", new Object[]{Boolean.valueOf(b.arv().arx().gTY)});
            } catch (Exception e) {
                x.e("MicroMsg.BackupMoveUI", "no such method WifiManager.isWifiApEnabled:%s", new Object[]{bi.cjd()});
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

    protected final int getLayoutId() {
        return R.i.backup_pc;
    }

    public void onResume() {
        super.onResume();
        b.arv().arx().gSW = this;
        mw(b.arv().aqP().gRC);
    }

    public void onDestroy() {
        x.d("MicroMsg.BackupMoveUI", "BackupMoveUI onDestroy.");
        if (b.arv().arx().gUF != null) {
            b.arv().arx().gUF.stop();
        }
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
        e aqP = b.arv().aqP();
        x.i("MicroMsg.BackupMoveUI", "onUpdateUIProgress state:%d, transferSession:%d, totalSession:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(aqP.gRD), Integer.valueOf(aqP.gRE)});
        TextView textView;
        int i2;
        Object[] objArr;
        switch (i) {
            case -100:
                DT(1);
                return;
            case DownloadResult.CODE_CONNECTION_TIMEOUT_EXCEPTION /*-23*/:
                this.gVw.setImageResource(R.k.backup_move_error);
                this.gVt.setText(R.l.backup_move_error_empty_records);
                this.gVu.setVisibility(4);
                this.gVr.setVisibility(4);
                this.gVs.setVisibility(4);
                arQ();
                return;
            case DownloadResult.CODE_URL_ERROR /*-21*/:
                this.gVw.setImageResource(R.k.backup_move_error);
                this.gVt.setText(R.l.backup_move_error_programme_error);
                this.gVu.setVisibility(4);
                this.gVr.setVisibility(4);
                this.gVs.setVisibility(4);
                arQ();
                return;
            case DownloadResult.CODE_RECEIVE_HTMLPAGE /*-11*/:
                this.gVw.setImageResource(R.k.backup_move_qrcode_dark);
                this.gVt.setText(getString(R.l.backup_move_network_disconnect_transfer_state, new Object[]{Integer.valueOf(aqP.gRD), Integer.valueOf(aqP.gRE), "0M"}));
                this.gVu.setText(R.l.backup_move_error_move_gencode_err);
                this.gVu.setTextColor(this.mController.tml.getResources().getColor(R.e.red));
                this.gVu.setVisibility(0);
                this.gVr.setVisibility(4);
                this.gVs.setVisibility(4);
                arQ();
                return;
            case -4:
                this.gVw.setImageResource(R.k.backup_move_qrcode_dark);
                b.arv().arx().gUF.start();
                this.gVt.setText(getString(R.l.backup_move_network_disconnect_transfer_state, new Object[]{Integer.valueOf(aqP.gRD), Integer.valueOf(aqP.gRE), "0M"}));
                this.gVu.setText(R.l.backup_move_error_network_disconnect);
                this.gVu.setTextColor(this.mController.tml.getResources().getColor(R.e.red));
                this.gVu.setVisibility(0);
                this.gVr.setVisibility(4);
                this.gVs.setVisibility(4);
                this.gVv.setText(R.l.backup_minimize);
                this.gVv.setOnClickListener(new 4(this));
                b.arv().arx().gUA = c.gRo;
                return;
            case 1:
                this.gVw.setImageResource(R.k.backup_move);
                this.gVt.setText(R.l.backup_move_connecting);
                this.gVu.setText(R.l.backup_move_keep_screen_on);
                this.gVu.setVisibility(0);
                this.gVr.setVisibility(4);
                this.gVs.setVisibility(4);
                arQ();
                return;
            case 3:
                finish();
                return;
            case 4:
                this.gVw.setImageResource(R.k.backup_move);
                textView = this.gVt;
                i2 = R.l.backup_move_transfer;
                objArr = new Object[3];
                objArr[0] = Integer.valueOf(aqP.gRD);
                objArr[1] = Integer.valueOf(aqP.gRE);
                b.arv().arx();
                objArr[2] = com.tencent.mm.plugin.backup.c.d.arK();
                textView.setText(getString(i2, objArr));
                this.gVu.setText(R.l.backup_pc_transfer_weak_network);
                this.gVu.setTextColor(getResources().getColor(R.e.backup_red));
                this.gVu.setVisibility(0);
                this.gVr.setVisibility(4);
                this.gVs.setVisibility(4);
                arQ();
                return;
            case 12:
                this.gVw.setImageResource(R.k.backup_move);
                this.gVt.setText(R.l.backup_move_preparing);
                this.gVu.setText(R.l.backup_move_keep_screen_on);
                this.gVu.setTextColor(getResources().getColor(R.e.backup_status_content));
                this.gVu.setVisibility(0);
                this.gVr.setVisibility(4);
                this.gVs.setVisibility(4);
                arQ();
                return;
            case 13:
                this.gVw.setImageResource(R.k.backup_move);
                this.gVt.setText(getString(R.l.backup_move_calculating, new Object[]{Integer.valueOf(aqP.gRD), Integer.valueOf(aqP.gRE)}));
                this.gVu.setText(R.l.backup_move_keep_screen_on);
                this.gVu.setTextColor(getResources().getColor(R.e.backup_status_content));
                this.gVu.setVisibility(0);
                this.gVr.setVisibility(4);
                this.gVs.setVisibility(4);
                arQ();
                return;
            case 14:
                this.gVw.setImageResource(R.k.backup_move);
                textView = this.gVt;
                i2 = R.l.backup_move_transfer;
                objArr = new Object[3];
                objArr[0] = Integer.valueOf(aqP.gRD);
                objArr[1] = Integer.valueOf(aqP.gRE);
                b.arv().arx();
                objArr[2] = com.tencent.mm.plugin.backup.c.d.arK();
                textView.setText(getString(i2, objArr));
                this.gVu.setText(R.l.backup_move_keep_screen_on);
                this.gVu.setTextColor(getResources().getColor(R.e.backup_status_content));
                this.gVu.setVisibility(0);
                this.gVr.setVisibility(4);
                this.gVs.setVisibility(4);
                arQ();
                return;
            case 15:
                this.gVw.setImageResource(R.k.backup_move_finish);
                this.gVt.setText(R.l.backup_move_finish);
                this.gVu.setText(getString(R.l.backup_move_finish_detail, new Object[]{Integer.valueOf(aqP.gRD), Integer.valueOf(aqP.gRE)}));
                this.gVu.setTextColor(getResources().getColor(R.e.backup_status_content));
                this.gVr.setText(R.l.backup_finish);
                this.gVu.setVisibility(0);
                this.gVr.setVisibility(0);
                this.gVs.setVisibility(4);
                this.gVr.setOnClickListener(new 1(this));
                arQ();
                return;
            case f$k.AppCompatTheme_buttonBarButtonStyle /*51*/:
                byte[] bArr = b.arv().arx().bitmapData;
                this.gVw.setImageBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                this.gVt.setText(R.l.backup_move_qrcode_success_tip);
                this.gVt.setTextColor(this.mController.tml.getResources().getColor(R.e.black));
                this.gVu.setVisibility(4);
                this.gVr.setVisibility(4);
                this.gVs.setVisibility(4);
                arQ();
                return;
            default:
                return;
        }
    }

    public final void aqO() {
    }

    private void arQ() {
        this.gVv.setText(R.l.backup_close);
        this.gVv.setOnClickListener(new 2(this));
    }

    private void arR() {
        x.i("MicroMsg.BackupMoveUI", "close btn, backupMoveState:%d", new Object[]{Integer.valueOf(b.arv().aqP().gRC)});
        switch (b.arv().aqP().gRC) {
            case DownloadResult.CODE_CONNECTION_TIMEOUT_EXCEPTION /*-23*/:
            case DownloadResult.CODE_URL_ERROR /*-21*/:
            case DownloadResult.CODE_RECEIVE_HTMLPAGE /*-11*/:
            case -4:
            case 1:
            case 4:
            case 12:
            case 13:
            case 14:
            case f$k.AppCompatTheme_buttonBarButtonStyle /*51*/:
                h.a(this, R.l.backup_move_qrcode_exit_move_tip, R.l.backup_move_qrcode_exit_move, R.l.backup_move_stop_move, R.l.backup_cancel, false, new 3(this), null, R.e.backup_red);
                return;
            case 15:
                x.i("MicroMsg.BackupMoveUI", "backup move finish, user click close.");
                b.arv().arz().cancel();
                b.arv().arz().art();
                b.arv().arx().an(true);
                b.arv().arw().stop();
                b.arv().aqP().gRC = -100;
                DT(1);
                return;
            default:
                DT(1);
                return;
        }
    }
}
