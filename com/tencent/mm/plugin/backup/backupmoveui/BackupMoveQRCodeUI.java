package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.backup.a.b.d;
import com.tencent.mm.plugin.backup.a.c;
import com.tencent.mm.plugin.backup.c.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import org.xwalk.core.XWalkResourceClient;

public class BackupMoveQRCodeUI extends MMWizardActivity implements d {
    private ImageView gVm;
    private TextView gVn;
    private TextView gVo;
    private boolean gVp = false;

    static /* synthetic */ void d(BackupMoveQRCodeUI backupMoveQRCodeUI) {
        backupMoveQRCodeUI.gVp = false;
        b.arv().arx().dw(false);
        b.arv().arw().stop();
        b.arv().arx().an(false);
        b.arv().aqP().gRC = -100;
        backupMoveQRCodeUI.DT(1);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            if (au.HX()) {
                initView();
                com.tencent.mm.plugin.backup.f.b.clear();
                com.tencent.mm.plugin.backup.f.b.d arx = b.arv().arx();
                com.tencent.mm.plugin.backup.f.b.a(arx.gUq);
                com.tencent.mm.plugin.backup.a.d.mx(21);
                com.tencent.mm.plugin.backup.f.b.a(arx.gUo);
                b.arv().aqQ();
                com.tencent.mm.plugin.backup.f.b.a(arx);
                com.tencent.mm.plugin.backup.f.b.a(b.arv().arw());
                com.tencent.mm.plugin.backup.f.b.mx(2);
                b.arv().gRx = null;
                arx.gUz = false;
                b.arv().arx().gUA = c.gRn;
                com.tencent.mm.plugin.backup.a.d.aqV();
                return;
            }
            finish();
        }
    }

    public void onStart() {
        super.onStart();
        com.tencent.mm.plugin.backup.f.b.a(b.arv().arx());
        b.arv().arx().gSW = this;
        b.arv().arx().gUF.start();
    }

    public void onResume() {
        super.onResume();
        mw(b.arv().aqP().gRC);
    }

    public final void initView() {
        setMMTitle(R.l.backup_move);
        this.gVm = (ImageView) findViewById(R.h.backup_move_qrcode_image);
        this.gVn = (TextView) findViewById(R.h.backup_move_qrcode_status_title);
        this.gVo = (TextView) findViewById(R.h.backup_move_qrcode_status_content);
        setBackBtn(new 1(this));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        arP();
        return true;
    }

    private void arP() {
        if (au.Dr()) {
            h.a(this, R.l.backup_move_qrcode_exit_move_tip, R.l.backup_move_qrcode_exit_move, R.l.backup_move_stop_move, R.l.backup_cancel, false, new 2(this), null, R.e.backup_red);
            return;
        }
        x.i("MicroMsg.BackupMoveQRCodeUI", "user click close. stop move.");
        b.arv().arw().stop();
        b.arv().arx().an(true);
        b.arv().aqP().gRC = -100;
        DT(1);
    }

    public void onStop() {
        x.i("MicroMsg.BackupMoveQRCodeUI", "BackupMoveQRCodeUI onStop.");
        if (b.arv().arx().gUF != null) {
            b.arv().arx().gUF.stop();
        }
        super.onStop();
    }

    protected final int getLayoutId() {
        return R.i.backup_move_qrcode;
    }

    public final void mw(int i) {
        x.i("MicroMsg.BackupMoveQRCodeUI", "onUpdateUIProgress backupState:%d", new Object[]{Integer.valueOf(i)});
        if (!this.gVp) {
            switch (i) {
                case -33:
                    this.gVp = true;
                    h.a(this, R.l.backup_move_error_not_support_quick_backup, 0, R.l.backup_all_types, R.l.backup_cancel, false, new 8(this), new 9(this), R.e.backup_green);
                    return;
                case -32:
                    this.gVp = true;
                    h.a(this, R.l.backup_move_error_not_support_select_time, 0, R.l.backup_all_records, R.l.backup_cancel, false, new 5(this), new 6(this), R.e.backup_green);
                    return;
                case -31:
                    this.gVp = true;
                    h.a(this, R.l.backup_move_error_not_support_select_time_and_quick_backup, 0, R.l.backup_all_types, R.l.backup_cancel, false, new 3(this), new 4(this), R.e.backup_green);
                    return;
                case XWalkResourceClient.ERROR_BAD_URL /*-12*/:
                    h.a(this, R.l.backup_move_error_recover_phone_old_version, 0, R.l.backup_sure, 0, false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            x.i("MicroMsg.BackupMoveQRCodeUI", "move phone old version");
                        }
                    }, null, R.e.backup_green);
                    return;
                case -11:
                case XWalkResourceClient.ERROR_AUTHENTICATION /*-4*/:
                    this.gVn.setText(R.l.backup_move_error_move_gencode_err);
                    this.gVn.setTextColor(this.mController.tml.getResources().getColor(R.e.red));
                    this.gVm.setImageResource(R.k.backup_move_qrcode_light);
                    this.gVo.setVisibility(4);
                    return;
                case 2:
                    x.i("MicroMsg.BackupMoveQRCodeUI", "auth success. go to BackupMoveUI.");
                    b.arv().aqP().gRC = 12;
                    MMWizardActivity.D(this, new Intent(this, BackupMoveUI.class));
                    return;
                case 51:
                    byte[] bArr = b.arv().arx().bitmapData;
                    this.gVm.setImageBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                    this.gVn.setText(R.l.backup_move_qrcode_success_tip);
                    this.gVn.setTextColor(this.mController.tml.getResources().getColor(R.e.black));
                    this.gVo.setVisibility(4);
                    return;
                default:
                    return;
            }
        }
    }

    public final void aqO() {
    }
}
