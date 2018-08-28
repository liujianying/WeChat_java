package com.tencent.mm.plugin.webwx.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.jq;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.webwx.a.c;
import com.tencent.mm.protocal.c.ux;
import com.tencent.mm.protocal.c.xt;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;

@a(3)
public class ExtDeviceWXLoginUI extends MMActivity implements e {
    private boolean bTs = false;
    private String bZD = null;
    private int efG = 0;
    private ProgressDialog kxR = null;
    private boolean qma = false;
    private String qmk = null;
    private int qml;
    private int qmm;
    private boolean qmn = false;
    private Button qmo;
    private TextView qmp;
    private int type = 0;

    static /* synthetic */ boolean a(ExtDeviceWXLoginUI extDeviceWXLoginUI) {
        final c cVar = new c(extDeviceWXLoginUI.bZD);
        au.DF().a(cVar, 0);
        extDeviceWXLoginUI.kxR = h.a(extDeviceWXLoginUI.mController.tml, extDeviceWXLoginUI.getString(R.l.loading_tips), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                au.DF().c(cVar);
                if (ExtDeviceWXLoginUI.this.kxR != null) {
                    ExtDeviceWXLoginUI.this.kxR.cancel();
                }
            }
        });
        return true;
    }

    static /* synthetic */ boolean b(ExtDeviceWXLoginUI extDeviceWXLoginUI, boolean z) {
        com.tencent.mm.plugin.webwx.a.e eVar = new com.tencent.mm.plugin.webwx.a.e(extDeviceWXLoginUI.bZD, extDeviceWXLoginUI.qmk, z);
        au.DF().a(eVar, 0);
        extDeviceWXLoginUI.kxR = h.a(extDeviceWXLoginUI.mController.tml, extDeviceWXLoginUI.getString(R.l.loading_tips), true, new 5(extDeviceWXLoginUI, eVar));
        return true;
    }

    static /* synthetic */ void d(ExtDeviceWXLoginUI extDeviceWXLoginUI) {
        int[] iArr = new int[2];
        View findViewById = extDeviceWXLoginUI.findViewById(R.h.webwx_login_action_bar);
        int height = findViewById.getHeight();
        findViewById.getLocationInWindow(iArr);
        int i = iArr[1];
        Point point = new Point();
        if (VERSION.SDK_INT >= 17) {
            extDeviceWXLoginUI.getWindowManager().getDefaultDisplay().getRealSize(point);
        } else {
            extDeviceWXLoginUI.getWindowManager().getDefaultDisplay().getSize(point);
        }
        x.i("MicroMsg.ExtDeviceWXLoginUI", "statusbarheight:%d,screenheight:%d,actionbarheight:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(point.y), Integer.valueOf(height)});
        extDeviceWXLoginUI.findViewById(R.h.status_icon).setPadding(0, (((int) (((double) r1) / 4.0d)) - i) - height, 0, 0);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getSupportActionBar().hide();
        initView();
        overridePendingTransition(R.a.push_up_in, R.a.anim_not_change);
    }

    protected void onResume() {
        super.onResume();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final void initView() {
        /*
        r14 = this;
        r13 = 3;
        r12 = 8;
        r11 = 2;
        r2 = 1;
        r3 = 0;
        r0 = r14.getIntent();
        r1 = "intent.key.login.url";
        r0 = r0.getStringExtra(r1);
        r14.bZD = r0;
        r0 = r14.getIntent();
        r1 = "intent.key.type";
        r0 = r0.getIntExtra(r1, r3);
        r14.type = r0;
        r0 = r14.getIntent();
        r1 = "intent.key.title.string";
        r1 = r0.getStringExtra(r1);
        r0 = r14.getIntent();
        r4 = "intent.key.icon.type";
        r0 = r0.getIntExtra(r4, r3);
        r14.efG = r0;
        r0 = r14.getIntent();
        r4 = "intent.key.ok.string";
        r4 = r0.getStringExtra(r4);
        r0 = r14.getIntent();
        r5 = "intent.key.cancel.string";
        r5 = r0.getStringExtra(r5);
        r0 = r14.getIntent();
        r6 = "intent.key.content.string";
        r6 = r0.getStringExtra(r6);
        r0 = r14.getIntent();
        r7 = "intent.key.ok.session.list";
        r0 = r0.getStringExtra(r7);
        r14.qmk = r0;
        r0 = r14.getIntent();
        r7 = "intent.key.login.client.version";
        r0 = r0.getIntExtra(r7, r3);
        r14.qml = r0;
        r0 = r14.getIntent();
        r7 = "intent.key.function.control";
        r0 = r0.getIntExtra(r7, r3);
        r14.qmm = r0;
        r0 = "MicroMsg.ExtDeviceWXLoginUI";
        r7 = "type:%s title:%s ok:%s content:%s";
        r8 = 4;
        r8 = new java.lang.Object[r8];
        r9 = r14.type;
        r9 = java.lang.Integer.valueOf(r9);
        r8[r3] = r9;
        r8[r2] = r1;
        r8[r11] = r4;
        r8[r13] = r6;
        com.tencent.mm.sdk.platformtools.x.i(r0, r7, r8);
        r0 = "";
        r14.setMMTitle(r0);
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r1);
        if (r0 != 0) goto L_0x00b1;
    L_0x00a6:
        r0 = com.tencent.mm.R.h.status_title;
        r0 = r14.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r0.setText(r1);
    L_0x00b1:
        r0 = new com.tencent.mm.g.a.jp;
        r0.<init>();
        r1 = com.tencent.mm.sdk.b.a.sFg;
        r1.m(r0);
        r1 = r0.bTl;
        r1 = r1.bTm;
        r7 = r0.bTl;
        r7 = r7.bTn;
        r0 = r0.bTl;
        r0 = r0.bTo;
        r8 = r14.efG;
        switch(r8) {
            case 1: goto L_0x0188;
            case 2: goto L_0x019a;
            default: goto L_0x00cc;
        };
    L_0x00cc:
        com.tencent.mm.model.au.HU();
        r8 = com.tencent.mm.model.c.DT();
        r9 = com.tencent.mm.storage.aa.a.sUX;
        r10 = java.lang.Integer.valueOf(r3);
        r8.a(r9, r10);
    L_0x00dc:
        r8 = com.tencent.mm.sdk.platformtools.bi.oW(r6);
        if (r8 != 0) goto L_0x01ad;
    L_0x00e2:
        r0 = com.tencent.mm.R.h.status_content_checkbox;
        r0 = r14.findViewById(r0);
        r0 = (android.widget.CheckBox) r0;
        r0.setVisibility(r12);
        r0 = com.tencent.mm.R.h.status_content;
        r0 = r14.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r0.setVisibility(r3);
        r0 = com.tencent.mm.R.h.status_content;
        r0 = r14.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r0.setText(r6);
    L_0x0103:
        r0 = com.tencent.mm.R.h.status_icon;
        r0 = r14.findViewById(r0);
        r0 = (android.widget.ImageView) r0;
        r1 = r14.efG;
        if (r1 == r2) goto L_0x0292;
    L_0x010f:
        r1 = r14.efG;
        if (r1 != r11) goto L_0x027b;
    L_0x0113:
        r1 = com.tencent.mm.R.k.connect_mac;
        r0.setImageResource(r1);
    L_0x0118:
        r0 = com.tencent.mm.R.h.webwx_logoutBt;
        r0 = r14.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r14.qmp = r0;
        r0 = r14.qmp;
        r0.setText(r5);
        r0 = r14.qmp;
        r1 = new com.tencent.mm.plugin.webwx.ui.ExtDeviceWXLoginUI$1;
        r1.<init>(r14);
        r0.setOnClickListener(r1);
        r0 = com.tencent.mm.R.h.webwx_loginBt;
        r0 = r14.findViewById(r0);
        r0 = (android.widget.Button) r0;
        r14.qmo = r0;
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r4);
        if (r0 != 0) goto L_0x02bb;
    L_0x0141:
        r0 = r14.qmo;
        r0.setText(r4);
        r0 = r14.type;
        if (r0 != 0) goto L_0x0299;
    L_0x014a:
        r0 = r14.qmo;
        r0.setEnabled(r2);
    L_0x014f:
        r0 = r14.qmo;
        r1 = new com.tencent.mm.plugin.webwx.ui.ExtDeviceWXLoginUI$2;
        r1.<init>(r14);
        r0.setOnClickListener(r1);
        r0 = r14.mController;
        r0 = r0.contentView;
        r1 = new com.tencent.mm.plugin.webwx.ui.ExtDeviceWXLoginUI$3;
        r1.<init>(r14);
        r0.post(r1);
        r0 = com.tencent.mm.R.h.webwx_login_closeBt;
        r0 = r14.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r1 = new com.tencent.mm.plugin.webwx.ui.ExtDeviceWXLoginUI$4;
        r1.<init>(r14);
        r0.setOnClickListener(r1);
        r0 = com.tencent.mm.model.au.DF();
        r1 = 972; // 0x3cc float:1.362E-42 double:4.8E-321;
        r0.a(r1, r14);
        r0 = com.tencent.mm.model.au.DF();
        r1 = 973; // 0x3cd float:1.363E-42 double:4.807E-321;
        r0.a(r1, r14);
        return;
    L_0x0188:
        com.tencent.mm.model.au.HU();
        r8 = com.tencent.mm.model.c.DT();
        r9 = com.tencent.mm.storage.aa.a.sUX;
        r10 = java.lang.Integer.valueOf(r13);
        r8.a(r9, r10);
        goto L_0x00dc;
    L_0x019a:
        com.tencent.mm.model.au.HU();
        r8 = com.tencent.mm.model.c.DT();
        r9 = com.tencent.mm.storage.aa.a.sUX;
        r10 = 4;
        r10 = java.lang.Integer.valueOf(r10);
        r8.a(r9, r10);
        goto L_0x00dc;
    L_0x01ad:
        if (r1 < 0) goto L_0x0103;
    L_0x01af:
        r1 = r14.qmm;
        r1 = r1 & 1;
        if (r1 <= 0) goto L_0x0224;
    L_0x01b5:
        r1 = r2;
    L_0x01b6:
        r6 = "MicroMsg.ExtDeviceWXLoginUI";
        r8 = "msgsynchronize needCheckedSync[%b], iconType[%d]";
        r9 = new java.lang.Object[r11];
        r10 = java.lang.Boolean.valueOf(r1);
        r9[r3] = r10;
        r10 = r14.efG;
        r10 = java.lang.Integer.valueOf(r10);
        r9[r2] = r10;
        com.tencent.mm.sdk.platformtools.x.i(r6, r8, r9);
        r6 = r14.efG;
        if (r6 != r2) goto L_0x0226;
    L_0x01d3:
        r6 = r14.qml;
        if (r6 < r7) goto L_0x0226;
    L_0x01d7:
        r14.qma = r2;
        r0 = com.tencent.mm.R.h.status_content;
        r0 = r14.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r0.setVisibility(r12);
        r0 = com.tencent.mm.R.h.status_content_checkbox;
        r0 = r14.findViewById(r0);
        r0 = (android.widget.CheckBox) r0;
        r0.setVisibility(r3);
        r0 = com.tencent.mm.R.h.status_content_checkbox;
        r0 = r14.findViewById(r0);
        r0 = (android.widget.CheckBox) r0;
        r6 = com.tencent.mm.R.l.webwx_login_msg_synchronize_windows;
        r0.setText(r6);
        if (r1 == 0) goto L_0x0217;
    L_0x01fe:
        com.tencent.mm.model.au.HU();
        r0 = com.tencent.mm.model.c.DT();
        r1 = com.tencent.mm.storage.aa.a.sUW;
        r6 = java.lang.Boolean.valueOf(r2);
        r0 = r0.get(r1, r6);
        r0 = (java.lang.Boolean) r0;
        r0 = r0.booleanValue();
        if (r0 != 0) goto L_0x0103;
    L_0x0217:
        r0 = com.tencent.mm.R.h.status_content_checkbox;
        r0 = r14.findViewById(r0);
        r0 = (android.widget.CheckBox) r0;
        r0.setChecked(r3);
        goto L_0x0103;
    L_0x0224:
        r1 = r3;
        goto L_0x01b6;
    L_0x0226:
        r6 = r14.efG;
        if (r6 != r11) goto L_0x0103;
    L_0x022a:
        r6 = r14.qml;
        if (r6 < r0) goto L_0x0103;
    L_0x022e:
        r14.qma = r2;
        r0 = com.tencent.mm.R.h.status_content;
        r0 = r14.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r0.setVisibility(r12);
        r0 = com.tencent.mm.R.h.status_content_checkbox;
        r0 = r14.findViewById(r0);
        r0 = (android.widget.CheckBox) r0;
        r0.setVisibility(r3);
        r0 = com.tencent.mm.R.h.status_content_checkbox;
        r0 = r14.findViewById(r0);
        r0 = (android.widget.CheckBox) r0;
        r6 = com.tencent.mm.R.l.webwx_login_msg_synchronize_mac;
        r0.setText(r6);
        if (r1 == 0) goto L_0x026e;
    L_0x0255:
        com.tencent.mm.model.au.HU();
        r0 = com.tencent.mm.model.c.DT();
        r1 = com.tencent.mm.storage.aa.a.sUW;
        r6 = java.lang.Boolean.valueOf(r2);
        r0 = r0.get(r1, r6);
        r0 = (java.lang.Boolean) r0;
        r0 = r0.booleanValue();
        if (r0 != 0) goto L_0x0103;
    L_0x026e:
        r0 = com.tencent.mm.R.h.status_content_checkbox;
        r0 = r14.findViewById(r0);
        r0 = (android.widget.CheckBox) r0;
        r0.setChecked(r3);
        goto L_0x0103;
    L_0x027b:
        r1 = r14.efG;
        if (r1 != r13) goto L_0x0286;
    L_0x027f:
        r1 = com.tencent.mm.R.k.connect_ipad;
        r0.setImageResource(r1);
        goto L_0x0118;
    L_0x0286:
        r1 = r14.efG;
        r6 = 5;
        if (r1 != r6) goto L_0x0292;
    L_0x028b:
        r1 = com.tencent.mm.R.k.connect_wx_album;
        r0.setImageResource(r1);
        goto L_0x0118;
    L_0x0292:
        r1 = com.tencent.mm.R.k.connect_pc;
        r0.setImageResource(r1);
        goto L_0x0118;
    L_0x0299:
        r0 = r14.type;
        r1 = -1;
        if (r0 != r1) goto L_0x02af;
    L_0x029e:
        r0 = r14.qmo;
        r0.setEnabled(r3);
        r0 = r14.efG;
        r1 = 5;
        if (r0 != r1) goto L_0x014f;
    L_0x02a8:
        r0 = r14.qmp;
        r0.setVisibility(r12);
        goto L_0x014f;
    L_0x02af:
        r0 = r14.type;
        r1 = -2;
        if (r0 != r1) goto L_0x014f;
    L_0x02b4:
        r0 = r14.qmo;
        r0.setEnabled(r2);
        goto L_0x014f;
    L_0x02bb:
        r0 = r14.qmo;
        r1 = 4;
        r0.setVisibility(r1);
        goto L_0x014f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webwx.ui.ExtDeviceWXLoginUI.initView():void");
    }

    protected void onPause() {
        super.onPause();
        if (this.qmn && au.HX()) {
            xt xtVar = new xt();
            xtVar.rDz = 27;
            xtVar.rDA = q.gT(q.GL()) ? 1 : 2;
            au.HU();
            com.tencent.mm.model.c.FQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.h.a(23, xtVar));
            this.qmn = false;
        }
    }

    protected final int getLayoutId() {
        return R.i.device_wx_login;
    }

    public void finish() {
        super.finish();
        overridePendingTransition(R.a.anim_not_change, R.a.push_down_out);
    }

    protected void onDestroy() {
        super.onDestroy();
        au.DF().b(972, this);
        au.DF().b(973, this);
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (this.kxR != null) {
            this.kxR.dismiss();
            this.kxR = null;
        }
        if (i == 0 && i2 == 0) {
            x.i("MicroMsg.ExtDeviceWXLoginUI", "onSceneEnd type[%d], [%d, %d]", new Object[]{Integer.valueOf(lVar.getType()), Integer.valueOf(i2), Integer.valueOf(i)});
            au.DF().b(972, this);
            if (lVar.getType() == 972) {
                com.tencent.mm.plugin.webwx.a.e eVar = (com.tencent.mm.plugin.webwx.a.e) lVar;
                if (eVar.qma || this.bTs) {
                    ux uxVar = (ux) eVar.dZf.dIE.dIL;
                    byte[] toByteArray = (uxVar == null || uxVar.ryo == null) ? null : uxVar.ryo.toByteArray();
                    jq jqVar = new jq();
                    jqVar.bTp.bTq = toByteArray;
                    jqVar.bTp.bTr = this.efG;
                    jqVar.bTp.bTs = this.bTs;
                    com.tencent.mm.sdk.b.a.sFg.m(jqVar);
                }
            } else {
                lVar.getType();
            }
            this.type = 0;
            finish();
            return;
        }
        if (i2 == -1) {
            this.type = -1;
        } else if (i2 == -2) {
            this.type = -2;
        }
        if (!bi.oW(str)) {
            ((CheckBox) findViewById(R.h.status_content_checkbox)).setVisibility(8);
            ((TextView) findViewById(R.h.status_content)).setVisibility(0);
            ((TextView) findViewById(R.h.status_content)).setText(str);
        }
        if (this.type == -1) {
            if (this.qmo != null) {
                this.qmo.setEnabled(false);
            }
        } else if (this.type == -2) {
            if (this.qmo != null) {
                this.qmo.setEnabled(true);
                this.qmo.setText(R.l.webwx_login_retry);
            }
            if (this.qmp != null) {
                this.qmp.setVisibility(4);
            }
        }
        x.i("MicroMsg.ExtDeviceWXLoginUI", "[oneliang][onSceneEnd]errType:%s,errCode:%s,errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
    }
}
