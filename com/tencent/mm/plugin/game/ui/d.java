package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.game.a.b;
import com.tencent.mm.plugin.game.f$d;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.f.i;
import com.tencent.mm.plugin.game.f.j;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.plugin.game.model.be;
import com.tencent.mm.plugin.game.model.f;
import com.tencent.mm.plugin.game.model.n;
import com.tencent.mm.plugin.game.model.y;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Set;

public final class d {
    private static Object lock = new Object();
    private al icJ = new al(Looper.getMainLooper(), new 1(this), false);
    private Dialog jJX;
    int jNv = 0;
    String jTR = null;
    private h jUc = null;
    private u jUd = null;
    private q jUe = null;
    private t jUf = null;
    OnClickListener jUg = null;
    private int jUh = 3000;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
    }

    public final void a(com.tencent.mm.plugin.game.model.d dVar, n nVar) {
        if (dVar == null || nVar == null) {
            x.e("MicroMsg.GameActionBtnHandler", "Null appInfo or null downloadInfo");
            return;
        }
        View view = new View(this.mContext);
        view.setTag(dVar);
        x.i("MicroMsg.GameActionBtnHandler", "App Status: %d, Download Mode: %d, Download Status: %d", new Object[]{Integer.valueOf(dVar.status), Integer.valueOf(nVar.mode), Integer.valueOf(nVar.status)});
        if (g.r(this.mContext, dVar.field_appId) || dVar.aTx()) {
            nVar.mode = 1;
        }
        if (nVar.mode == 3) {
            be.aUD();
            int i = be.i(this.mContext, "com.tencent.android.qqdownloader", dVar.cmT);
            x.i("MicroMsg.GameActionBtnHandler", "qqdownloader install status:[%d], yybSupportedVersionCode:[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(dVar.cmT)});
            if (i == -1 || i == 1 || i == 2) {
                nVar.mode = 1;
            }
        }
        FileDownloadTaskInfo yO;
        switch (dVar.status) {
            case 0:
            case 3:
            case 4:
                switch (nVar.mode) {
                    case 3:
                        yO = com.tencent.mm.plugin.downloader.model.d.aCU().yO(dVar.field_appId);
                        if (yO != null && yO.id > 0) {
                            com.tencent.mm.plugin.downloader.model.d.aCU().cl(yO.id);
                        }
                        if (this.jUd == null) {
                            this.jUd = new u(this.mContext);
                        }
                        u uVar = this.jUd;
                        int i2 = this.jNv;
                        String str = this.jTR;
                        uVar.jNv = i2;
                        uVar.jTR = str;
                        this.jUd.onClick(view);
                        break;
                    case 4:
                        if (!bi.oW(dVar.cmK)) {
                            x.i("MicroMsg.GameActionBtnHandler", "gp download url is not null and download flag is download directly by gp store");
                            q.bi(this.mContext, dVar.cmK);
                            an.a(this.mContext, dVar.scene, dVar.bYq, dVar.position, 25, dVar.field_appId, this.jNv, dVar.bHF, this.jTR);
                            break;
                        }
                        break;
                    default:
                        x.d("MicroMsg.GameActionBtnHandler", "summertoken downloadInfo.mode[%d]", new Object[]{Integer.valueOf(nVar.mode)});
                        if (this.jUc == null) {
                            this.jUc = new h(this.mContext);
                        }
                        this.jUc.setSourceScene(this.jNv);
                        this.jUc.dc(this.jTR, "");
                        this.jUc.onClick(view);
                        break;
                }
                if (dVar.jLn) {
                    Set dv = f.dv(this.mContext);
                    if (!a(dv, dVar.field_appId)) {
                        if (nVar.mode != 3) {
                            View inflate = LayoutInflater.from(this.mContext).inflate(com.tencent.mm.plugin.game.f.f.game_gift_tips, null);
                            ((LinearLayout) inflate.findViewById(e.mm_alert_msg_area)).setGravity(17);
                            TextView textView = (TextView) inflate.findViewById(e.mm_alert_msg);
                            TextView textView2 = (TextView) inflate.findViewById(e.mm_alert_msg_subdesc);
                            ((ImageView) inflate.findViewById(e.mm_alert_msg_icon)).setBackgroundResource(f$d.download_gift);
                            textView.setText(i.game_gift_title);
                            textView2.setText(i.game_gift_content);
                            this.jJX = new com.tencent.mm.ui.base.i(this.mContext, j.GameNoticStyle);
                            this.jJX.setContentView(inflate);
                            this.jJX.setCancelable(true);
                            this.jJX.setCanceledOnTouchOutside(true);
                            this.jJX.show();
                            long j = (long) this.jUh;
                            this.icJ.J(j, j);
                        }
                        ((b) com.tencent.mm.kernel.g.l(b.class)).aSh();
                        y.b(dVar.field_appId, 1, 0, null, null);
                        dv.add(dVar.field_appId);
                        f.a(this.mContext, dv);
                        return;
                    }
                    return;
                }
                return;
            case 1:
                if (this.jUf == null) {
                    this.jUf = new t(this.mContext);
                    this.jUf.kcI = this.jUg;
                }
                this.jUf.jNv = this.jNv;
                this.jUf.onClick(view);
                an.a(this.mContext, dVar.scene, dVar.bYq, dVar.position, 9, dVar.field_appId, this.jNv, dVar.bHF, this.jTR);
                return;
            case 2:
                yO = com.tencent.mm.plugin.downloader.model.d.aCU().yO(dVar.field_appId);
                if (yO != null && yO.id > 0) {
                    com.tencent.mm.plugin.downloader.model.d.aCU().cl(yO.id);
                }
                if (this.jUe == null) {
                    this.jUe = new q(this.mContext);
                }
                this.jUe.hop = this.jNv;
                this.jUe.kbt = dVar.cmO;
                this.jUe.onClick(view);
                return;
            default:
                return;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.widget.ProgressBar r8, android.widget.Button r9, com.tencent.mm.plugin.game.model.d r10, com.tencent.mm.plugin.game.model.n r11) {
        /*
        r7 = this;
        r4 = 3;
        r6 = 1;
        r3 = 12;
        r2 = 8;
        r5 = 0;
        if (r8 == 0) goto L_0x000b;
    L_0x0009:
        if (r9 != 0) goto L_0x000c;
    L_0x000b:
        return;
    L_0x000c:
        r9.setEnabled(r6);
        r9.setVisibility(r5);
        r0 = r10.status;
        if (r0 != r6) goto L_0x0035;
    L_0x0016:
        r0 = r10.jLg;
        if (r0 == 0) goto L_0x0029;
    L_0x001a:
        r9.setEnabled(r5);
        r0 = com.tencent.mm.plugin.game.f.i.game_action_subscribed;
        r9.setText(r0);
        r9.setVisibility(r5);
        r8.setVisibility(r2);
        goto L_0x000b;
    L_0x0029:
        r0 = com.tencent.mm.plugin.game.f.i.game_action_subscribe;
        r9.setText(r0);
        r9.setVisibility(r5);
        r8.setVisibility(r2);
        goto L_0x000b;
    L_0x0035:
        r0 = r7.mContext;
        r0 = com.tencent.mm.pluginsdk.model.app.g.a(r0, r10);
        if (r0 == 0) goto L_0x00a1;
    L_0x003d:
        r0 = r10.field_packageName;
        r0 = com.tencent.mm.plugin.game.e.c.DP(r0);
        r1 = r10.versionCode;
        if (r1 <= r0) goto L_0x008b;
    L_0x0047:
        r1 = r11.status;
        if (r1 != r6) goto L_0x0075;
    L_0x004b:
        r8.setVisibility(r5);
        r1 = r11.progress;
        r8.setProgress(r1);
        r9.setVisibility(r2);
    L_0x0056:
        r1 = "MicroMsg.GameActionBtnHandler";
        r2 = "AppId: %s installed, local: %d, server: %d";
        r3 = new java.lang.Object[r4];
        r4 = r10.field_appId;
        r3[r5] = r4;
        r0 = java.lang.Integer.valueOf(r0);
        r3[r6] = r0;
        r0 = 2;
        r4 = r10.versionCode;
        r4 = java.lang.Integer.valueOf(r4);
        r3[r0] = r4;
        com.tencent.mm.sdk.platformtools.x.i(r1, r2, r3);
        goto L_0x000b;
    L_0x0075:
        r1 = r10.scene;
        if (r1 != r3) goto L_0x0085;
    L_0x0079:
        r1 = com.tencent.mm.plugin.game.f.i.game_detail_rank_update;
        r9.setText(r1);
    L_0x007e:
        r9.setVisibility(r5);
        r8.setVisibility(r2);
        goto L_0x0056;
    L_0x0085:
        r1 = com.tencent.mm.plugin.game.f.i.game_action_update;
        r9.setText(r1);
        goto L_0x007e;
    L_0x008b:
        r9.setVisibility(r5);
        r8.setVisibility(r2);
        r1 = r10.scene;
        if (r1 != r3) goto L_0x009b;
    L_0x0095:
        r1 = com.tencent.mm.plugin.game.f.i.game_detail_rank_launch;
        r9.setText(r1);
        goto L_0x0056;
    L_0x009b:
        r1 = com.tencent.mm.plugin.game.f.i.game_list_launch;
        r9.setText(r1);
        goto L_0x0056;
    L_0x00a1:
        r0 = r10.aTx();
        if (r0 == 0) goto L_0x00bf;
    L_0x00a7:
        r9.setVisibility(r5);
        r8.setVisibility(r2);
        r0 = r10.scene;
        if (r0 != r3) goto L_0x00b8;
    L_0x00b1:
        r0 = com.tencent.mm.plugin.game.f.i.game_detail_rank_launch;
        r9.setText(r0);
        goto L_0x000b;
    L_0x00b8:
        r0 = com.tencent.mm.plugin.game.f.i.game_list_launch;
        r9.setText(r0);
        goto L_0x000b;
    L_0x00bf:
        r0 = r10.status;
        switch(r0) {
            case 0: goto L_0x00ea;
            case 1: goto L_0x016f;
            case 2: goto L_0x0190;
            case 3: goto L_0x019d;
            case 4: goto L_0x0203;
            default: goto L_0x00c4;
        };
    L_0x00c4:
        r9.setVisibility(r2);
        r8.setVisibility(r2);
    L_0x00ca:
        r0 = "MicroMsg.GameActionBtnHandler";
        r1 = "updateBtnStateAndText: %s, Status: %d, Text: %s";
        r2 = new java.lang.Object[r4];
        r3 = r10.field_appId;
        r2[r5] = r3;
        r3 = r10.status;
        r3 = java.lang.Integer.valueOf(r3);
        r2[r6] = r3;
        r3 = 2;
        r4 = r9.getText();
        r2[r3] = r4;
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);
        goto L_0x000b;
    L_0x00ea:
        if (r11 != 0) goto L_0x00f4;
    L_0x00ec:
        r9.setVisibility(r2);
        r8.setVisibility(r2);
        goto L_0x000b;
    L_0x00f4:
        r0 = r11.status;
        switch(r0) {
            case 0: goto L_0x00fa;
            case 1: goto L_0x0128;
            case 2: goto L_0x0148;
            case 3: goto L_0x015f;
            default: goto L_0x00f9;
        };
    L_0x00f9:
        goto L_0x00ca;
    L_0x00fa:
        r0 = r10.scene;
        if (r0 != r3) goto L_0x0122;
    L_0x00fe:
        r0 = r10.jLn;
        if (r0 == 0) goto L_0x011c;
    L_0x0102:
        r0 = r10.field_appId;
        r1 = r7.mContext;
        r1 = com.tencent.mm.plugin.game.model.f.dv(r1);
        r0 = a(r1, r0);
        if (r0 != 0) goto L_0x011c;
    L_0x0110:
        r0 = com.tencent.mm.plugin.game.f.i.game_download_gift;
        r9.setText(r0);
    L_0x0115:
        r9.setVisibility(r5);
        r8.setVisibility(r2);
        goto L_0x00ca;
    L_0x011c:
        r0 = com.tencent.mm.plugin.game.f.i.game_list_download_app;
        r9.setText(r0);
        goto L_0x0115;
    L_0x0122:
        r0 = com.tencent.mm.plugin.game.f.i.game_list_download;
        r9.setText(r0);
        goto L_0x0115;
    L_0x0128:
        r0 = r11.mode;
        if (r0 != r4) goto L_0x0138;
    L_0x012c:
        r0 = com.tencent.mm.plugin.game.f.i.game_list_download_view;
        r9.setText(r0);
    L_0x0131:
        r9.setVisibility(r5);
        r8.setVisibility(r2);
        goto L_0x00ca;
    L_0x0138:
        r0 = r11.mode;
        if (r0 != r6) goto L_0x00ca;
    L_0x013c:
        r0 = r11.progress;
        r8.setProgress(r0);
        r9.setVisibility(r2);
        r8.setVisibility(r5);
        goto L_0x00ca;
    L_0x0148:
        r0 = r10.scene;
        if (r0 != r3) goto L_0x0159;
    L_0x014c:
        r0 = com.tencent.mm.plugin.game.f.i.game_download_continue_task;
        r9.setText(r0);
    L_0x0151:
        r9.setVisibility(r5);
        r8.setVisibility(r2);
        goto L_0x00ca;
    L_0x0159:
        r0 = com.tencent.mm.plugin.game.f.i.game_list_download_continue;
        r9.setText(r0);
        goto L_0x0151;
    L_0x015f:
        r0 = r10.scene;
        if (r0 != r3) goto L_0x0169;
    L_0x0163:
        r0 = com.tencent.mm.plugin.game.f.i.game_list_app_install_btn;
        r9.setText(r0);
        goto L_0x0131;
    L_0x0169:
        r0 = com.tencent.mm.plugin.game.f.i.game_list_app_install;
        r9.setText(r0);
        goto L_0x0131;
    L_0x016f:
        r0 = r10.jLg;
        if (r0 == 0) goto L_0x0183;
    L_0x0173:
        r9.setEnabled(r5);
        r0 = com.tencent.mm.plugin.game.f.i.game_action_subscribed;
        r9.setText(r0);
        r9.setVisibility(r5);
        r8.setVisibility(r2);
        goto L_0x00ca;
    L_0x0183:
        r0 = com.tencent.mm.plugin.game.f.i.game_action_subscribe;
        r9.setText(r0);
        r9.setVisibility(r5);
        r8.setVisibility(r2);
        goto L_0x00ca;
    L_0x0190:
        r0 = com.tencent.mm.plugin.game.f.i.game_action_preemptive;
        r9.setText(r0);
        r9.setVisibility(r5);
        r8.setVisibility(r2);
        goto L_0x00ca;
    L_0x019d:
        if (r11 != 0) goto L_0x01ac;
    L_0x019f:
        r0 = com.tencent.mm.plugin.game.f.i.game_action_grab;
        r9.setText(r0);
        r9.setVisibility(r5);
        r8.setVisibility(r2);
        goto L_0x000b;
    L_0x01ac:
        r0 = r11.status;
        switch(r0) {
            case 0: goto L_0x01b3;
            case 1: goto L_0x01c0;
            case 2: goto L_0x01dc;
            case 3: goto L_0x01f3;
            default: goto L_0x01b1;
        };
    L_0x01b1:
        goto L_0x00ca;
    L_0x01b3:
        r0 = com.tencent.mm.plugin.game.f.i.game_action_grab;
        r9.setText(r0);
    L_0x01b8:
        r9.setVisibility(r5);
        r8.setVisibility(r2);
        goto L_0x00ca;
    L_0x01c0:
        r0 = r11.mode;
        if (r0 != r4) goto L_0x01cb;
    L_0x01c4:
        r0 = com.tencent.mm.plugin.game.f.i.game_list_download_view;
        r9.setText(r0);
        goto L_0x00ca;
    L_0x01cb:
        r0 = r11.mode;
        if (r0 != r6) goto L_0x00ca;
    L_0x01cf:
        r0 = r11.progress;
        r8.setProgress(r0);
        r9.setVisibility(r2);
        r8.setVisibility(r5);
        goto L_0x00ca;
    L_0x01dc:
        r0 = r10.scene;
        if (r0 != r3) goto L_0x01ed;
    L_0x01e0:
        r0 = com.tencent.mm.plugin.game.f.i.game_download_continue_task;
        r9.setText(r0);
    L_0x01e5:
        r9.setVisibility(r5);
        r8.setVisibility(r2);
        goto L_0x00ca;
    L_0x01ed:
        r0 = com.tencent.mm.plugin.game.f.i.game_list_download_continue;
        r9.setText(r0);
        goto L_0x01e5;
    L_0x01f3:
        r0 = r10.scene;
        if (r0 != r3) goto L_0x01fd;
    L_0x01f7:
        r0 = com.tencent.mm.plugin.game.f.i.game_list_app_install_btn;
        r9.setText(r0);
        goto L_0x01b8;
    L_0x01fd:
        r0 = com.tencent.mm.plugin.game.f.i.game_list_app_install;
        r9.setText(r0);
        goto L_0x01b8;
    L_0x0203:
        r0 = com.tencent.mm.plugin.game.f.i.game_action_trial;
        r9.setText(r0);
        r9.setVisibility(r5);
        r8.setVisibility(r2);
        goto L_0x00ca;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.game.ui.d.a(android.widget.ProgressBar, android.widget.Button, com.tencent.mm.plugin.game.model.d, com.tencent.mm.plugin.game.model.n):void");
    }

    private static boolean a(Set<String> set, String str) {
        if (set == null || set.isEmpty() || !set.contains(str)) {
            return false;
        }
        return true;
    }
}
