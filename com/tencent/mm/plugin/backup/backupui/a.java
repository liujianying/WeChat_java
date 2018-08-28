package com.tencent.mm.plugin.backup.backupui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.a.d;
import com.tencent.mm.plugin.backup.a.e;
import com.tencent.mm.plugin.backup.backuppcmodel.c;
import com.tencent.mm.plugin.sns.i$l;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.smtt.sdk.WebViewClient;

public final class a extends b {
    private static String TAG = "MicroMsg.BackupChatBanner";
    private View gYR = null;
    private com.tencent.mm.plugin.backup.a.b.a gYS = new a(this);

    public a(Context context) {
        super(context);
        x.i(TAG, "BackupChatBanner.");
        com.tencent.mm.plugin.backup.backuppcmodel.b.arV().aqP().gRC = -100;
        com.tencent.mm.plugin.backup.c.b.arv().aqP().gRC = -100;
        x.i(TAG, "initialize");
        if (this.view != null) {
            this.gYR = this.view.findViewById(R.h.bakchat_banner_view);
            this.gYR.setOnClickListener(new 1(this));
        }
        anR();
        com.tencent.mm.plugin.backup.backuppcmodel.b.arV().arX().gWJ = this.gYS;
        com.tencent.mm.plugin.backup.backuppcmodel.b.arV().arY().gWJ = this.gYS;
        com.tencent.mm.plugin.backup.c.b.arv().ary().gTP = this.gYS;
    }

    public final int getLayoutId() {
        return R.i.bakchat_banner_view;
    }

    private void dB(boolean z) {
        x.i(TAG, "jumpToBackupPcUI");
        if (bi.ci((Context) this.qJS.get())) {
            Intent className = new Intent().setClassName((Context) this.qJS.get(), "com.tencent.mm.plugin.backup.backuppcui.BackupPcUI");
            className.putExtra("isRecoverTransferFinishFromBanner", z);
            MMWizardActivity.D((Context) this.qJS.get(), className);
        }
    }

    private void dC(boolean z) {
        x.i(TAG, "jumpToBackupMoveRecoverUI, isRecoverTransferFinishFromBanner[%b]", new Object[]{Boolean.valueOf(z)});
        if (bi.ci((Context) this.qJS.get())) {
            Intent className = new Intent().setClassName((Context) this.qJS.get(), "com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI");
            className.putExtra("isRecoverTransferFinishFromBanner", z);
            MMWizardActivity.D((Context) this.qJS.get(), className);
        }
    }

    public final boolean anR() {
        x.d(TAG, "refreshAndReturnIsVisible, backupMode[%d]", new Object[]{Integer.valueOf(d.aqS())});
        switch (d.aqS()) {
            case 1:
                return mL(com.tencent.mm.plugin.backup.backuppcmodel.b.arV().aqP().gRC);
            case 22:
                return mM(com.tencent.mm.plugin.backup.c.b.arv().aqP().gRC);
            default:
                this.gYR.setVisibility(8);
                return false;
        }
    }

    private boolean mL(int i) {
        x.i(TAG, "refreshPcState backupPcState[%d]", new Object[]{Integer.valueOf(i)});
        e aqP = com.tencent.mm.plugin.backup.backuppcmodel.b.arV().aqP();
        TextView textView;
        Context context;
        int i2;
        Object[] objArr;
        switch (i) {
            case WebViewClient.ERROR_AUTHENTICATION /*-4*/:
                this.gYR.setVisibility(0);
                if (1 == com.tencent.mm.plugin.backup.backuppcmodel.b.arV().arW().gWw || 3 == com.tencent.mm.plugin.backup.backuppcmodel.b.arV().arW().gWw) {
                    ((ImageView) this.view.findViewById(R.h.bakchat_icon)).setImageResource(R.k.backup_pc_banner);
                    ((TextView) this.view.findViewById(R.h.bakchat_info)).setText(ad.getContext().getString(R.l.backup_pc_error_banner_disconnect));
                } else if (2 == com.tencent.mm.plugin.backup.backuppcmodel.b.arV().arW().gWw || 4 == com.tencent.mm.plugin.backup.backuppcmodel.b.arV().arW().gWw) {
                    ((ImageView) this.view.findViewById(R.h.bakchat_icon)).setImageResource(R.k.backup_pc_recover_banner);
                    ((TextView) this.view.findViewById(R.h.bakchat_info)).setText(ad.getContext().getString(R.l.backup_pc_error_banner_recover_disconnect));
                }
                return true;
            case 4:
            case 5:
                this.gYR.setVisibility(0);
                if (1 == com.tencent.mm.plugin.backup.backuppcmodel.b.arV().arW().gWw || 3 == com.tencent.mm.plugin.backup.backuppcmodel.b.arV().arW().gWw) {
                    ((ImageView) this.view.findViewById(R.h.bakchat_icon)).setImageResource(R.k.backup_pc_banner);
                    textView = (TextView) this.view.findViewById(R.h.bakchat_info);
                    context = ad.getContext();
                    i2 = R.l.backup_pc_transfer;
                    objArr = new Object[3];
                    objArr[0] = Integer.valueOf(aqP.gRD);
                    objArr[1] = Integer.valueOf(aqP.gRE);
                    com.tencent.mm.plugin.backup.backuppcmodel.b.arV().arW();
                    objArr[2] = c.asb();
                    textView.setText(context.getString(i2, objArr));
                } else if (2 == com.tencent.mm.plugin.backup.backuppcmodel.b.arV().arW().gWw || 4 == com.tencent.mm.plugin.backup.backuppcmodel.b.arV().arW().gWw) {
                    ((ImageView) this.view.findViewById(R.h.bakchat_icon)).setImageResource(R.k.backup_pc_recover_banner);
                    textView = (TextView) this.view.findViewById(R.h.bakchat_info);
                    context = ad.getContext();
                    i2 = R.l.backup_pc_recover_transfer;
                    objArr = new Object[3];
                    objArr[0] = Integer.valueOf(aqP.gRD);
                    objArr[1] = Integer.valueOf(aqP.gRE);
                    com.tencent.mm.plugin.backup.backuppcmodel.b.arV().arW();
                    objArr[2] = c.asb();
                    textView.setText(context.getString(i2, objArr));
                }
                return true;
            case 12:
            case 22:
                this.gYR.setVisibility(0);
                if (1 == com.tencent.mm.plugin.backup.backuppcmodel.b.arV().arW().gWw || 3 == com.tencent.mm.plugin.backup.backuppcmodel.b.arV().arW().gWw) {
                    ((ImageView) this.view.findViewById(R.h.bakchat_icon)).setImageResource(R.k.backup_pc_banner);
                } else if (2 == com.tencent.mm.plugin.backup.backuppcmodel.b.arV().arW().gWw || 4 == com.tencent.mm.plugin.backup.backuppcmodel.b.arV().arW().gWw) {
                    ((ImageView) this.view.findViewById(R.h.bakchat_icon)).setImageResource(R.k.backup_pc_recover_banner);
                }
                ((TextView) this.view.findViewById(R.h.bakchat_info)).setText(ad.getContext().getString(R.l.backup_pc_prepare));
                return true;
            case 14:
                this.gYR.setVisibility(0);
                ((ImageView) this.view.findViewById(R.h.bakchat_icon)).setImageResource(R.k.backup_pc_banner);
                textView = (TextView) this.view.findViewById(R.h.bakchat_info);
                context = ad.getContext();
                i2 = R.l.backup_pc_transfer;
                objArr = new Object[3];
                objArr[0] = Integer.valueOf(aqP.gRD);
                objArr[1] = Integer.valueOf(aqP.gRE);
                com.tencent.mm.plugin.backup.backuppcmodel.b.arV().arW();
                objArr[2] = c.asb();
                textView.setText(context.getString(i2, objArr));
                return true;
            case 15:
                this.gYR.setVisibility(0);
                ((ImageView) this.view.findViewById(R.h.bakchat_icon)).setImageResource(R.k.backup_pc_banner);
                ((TextView) this.view.findViewById(R.h.bakchat_info)).setText(ad.getContext().getString(R.l.backup_pc_backup_finish));
                return true;
            case 23:
                this.gYR.setVisibility(0);
                ((ImageView) this.view.findViewById(R.h.bakchat_icon)).setImageResource(R.k.backup_pc_recover_banner);
                textView = (TextView) this.view.findViewById(R.h.bakchat_info);
                context = ad.getContext();
                i2 = R.l.backup_pc_recover_transfer;
                objArr = new Object[3];
                objArr[0] = Integer.valueOf(aqP.gRD);
                objArr[1] = Integer.valueOf(aqP.gRE);
                com.tencent.mm.plugin.backup.backuppcmodel.b.arV().arW();
                objArr[2] = c.asb();
                textView.setText(context.getString(i2, objArr));
                return true;
            case 24:
                dB(true);
                return true;
            case 25:
                this.gYR.setVisibility(0);
                ((ImageView) this.view.findViewById(R.h.bakchat_icon)).setImageResource(R.k.backup_pc_recover_banner);
                ((TextView) this.view.findViewById(R.h.bakchat_info)).setText(ad.getContext().getString(R.l.backup_pc_recover_transfer_finish_start_merge));
                return true;
            case 26:
            case i$l.AppCompatTheme_actionModeStyle /*27*/:
                this.gYR.setVisibility(8);
                if (bi.ci((Context) this.qJS.get())) {
                    dB(true);
                }
                return true;
            default:
                this.gYR.setVisibility(8);
                return false;
        }
    }

    private boolean mM(int i) {
        x.i(TAG, "refreshMoveRecoverState backupMoveState[%d]", new Object[]{Integer.valueOf(i)});
        e aqP = com.tencent.mm.plugin.backup.c.b.arv().aqP();
        switch (i) {
            case WebViewClient.ERROR_AUTHENTICATION /*-4*/:
                this.gYR.setVisibility(0);
                ((ImageView) this.view.findViewById(R.h.bakchat_icon)).setImageResource(R.k.backup_move_banner);
                ((TextView) this.view.findViewById(R.h.bakchat_info)).setText(ad.getContext().getString(R.l.backup_move_error_banner_recover_disconnect));
                return true;
            case 4:
            case 5:
            case 23:
                this.gYR.setVisibility(0);
                ((ImageView) this.view.findViewById(R.h.bakchat_icon)).setImageResource(R.k.backup_move_banner);
                TextView textView = (TextView) this.view.findViewById(R.h.bakchat_info);
                Context context = ad.getContext();
                int i2 = R.l.backup_move_recover_transfer;
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(aqP.gRD);
                objArr[1] = Integer.valueOf(aqP.gRE);
                com.tencent.mm.plugin.backup.c.b.arv().ary();
                objArr[2] = com.tencent.mm.plugin.backup.c.c.arD();
                textView.setText(context.getString(i2, objArr));
                return true;
            case 22:
                this.gYR.setVisibility(0);
                ((ImageView) this.view.findViewById(R.h.bakchat_icon)).setImageResource(R.k.backup_move_banner);
                ((TextView) this.view.findViewById(R.h.bakchat_info)).setText(ad.getContext().getString(R.l.backup_move_recover_preparing));
                return true;
            case 24:
            case i$l.AppCompatTheme_selectableItemBackground /*52*/:
                if (bi.ci((Context) this.qJS.get())) {
                    dC(true);
                }
                return true;
            case 25:
                this.gYR.setVisibility(0);
                ((ImageView) this.view.findViewById(R.h.bakchat_icon)).setImageResource(R.k.backup_move_banner);
                ((TextView) this.view.findViewById(R.h.bakchat_info)).setText(ad.getContext().getString(R.l.backup_move_recover_transfer_finish_start_merge));
                return true;
            case 26:
            case i$l.AppCompatTheme_actionModeStyle /*27*/:
                this.gYR.setVisibility(8);
                if (bi.ci((Context) this.qJS.get())) {
                    dC(true);
                }
                return true;
            default:
                this.gYR.setVisibility(8);
                return false;
        }
    }

    public final void destroy() {
    }

    public final int getOrder() {
        return 3;
    }
}
