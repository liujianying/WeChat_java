package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.f;
import com.tencent.mm.g.a.bc;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.g.a.ix;
import com.tencent.mm.g.a.ln;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsimple.z;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.plugin.appbrand.q.n;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.api.p;
import com.tencent.mm.pluginsdk.model.app.ac;
import com.tencent.mm.pluginsdk.model.app.ac.a;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.tools.ShowImageUI;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.y.g;
import com.tencent.smtt.sdk.TbsReaderView$ReaderCallback;
import java.io.File;

public class AppAttachDownloadUI extends MMActivity implements e, a, j.a {
    private long bJC;
    private String bSS;
    private boolean bUY;
    private String bWW;
    private bd bXQ;
    private int dPU;
    private String dwK;
    private TextView eGD;
    private ProgressBar eVR;
    private String fileName;
    private String fjS;
    private f ijX;
    private Button jcg;
    private View jck;
    private Button jnr;
    private String kni;
    private String mediaId;
    private MMImageView mel;
    private ImageView mem;
    private ac qzW;
    private View tGd;
    private TextView tGe;
    private TextView tGf;
    private boolean tGg;
    private g.a tGh;
    private boolean tGi = false;
    private boolean tGj = false;
    private boolean tGk = true;
    private int tGl = TbsReaderView$ReaderCallback.GET_BAR_ANIMATING;
    private LinearLayout tGm;
    private LinearLayout tGn;
    private boolean tGo = false;

    static /* synthetic */ void c(AppAttachDownloadUI appAttachDownloadUI) {
        boolean z;
        if (appAttachDownloadUI.tGh != null) {
            z = appAttachDownloadUI.tGh.dws != 0 || appAttachDownloadUI.tGh.dwo > 26214400;
            h hVar = h.mEJ;
            Object[] objArr = new Object[6];
            objArr[0] = appAttachDownloadUI.tGh.dwD;
            objArr[1] = Integer.valueOf(appAttachDownloadUI.tGh.dws == 1 ? 7 : 5);
            objArr[2] = Integer.valueOf(appAttachDownloadUI.tGh.dwo);
            objArr[3] = Integer.valueOf(2);
            objArr[4] = Long.valueOf((System.currentTimeMillis() - appAttachDownloadUI.bXQ.field_createTime) / 1000);
            objArr[5] = appAttachDownloadUI.fjS;
            hVar.h(14665, objArr);
        } else {
            z = false;
        }
        Intent intent = new Intent(appAttachDownloadUI, MsgRetransmitUI.class);
        intent.putExtra("Retr_Msg_content", appAttachDownloadUI.bWW);
        intent.putExtra("Retr_Msg_Type", 2);
        intent.putExtra("Retr_Msg_Id", appAttachDownloadUI.bXQ.field_msgId);
        intent.putExtra("Retr_Big_File", z);
        appAttachDownloadUI.startActivity(intent);
    }

    static /* synthetic */ void d(AppAttachDownloadUI appAttachDownloadUI) {
        if (!appAttachDownloadUI.tGi && appAttachDownloadUI.bXQ.aQm()) {
            g.a gp = g.a.gp(appAttachDownloadUI.bXQ.field_content);
            if (gp.type == 6 && !bi.oW(gp.dwu)) {
                b d = l.d(appAttachDownloadUI.bXQ, gp.bGP);
                if (!(d == null || (com.tencent.mm.a.e.cn(d.field_fileFullPath) && ((long) com.tencent.mm.a.e.cm(d.field_fileFullPath)) == d.field_totalLen))) {
                    appAttachDownloadUI.tGo = true;
                    d.field_status = 101;
                    d.field_lastModifyTime = bi.VE();
                    ao.asF().c(d, new String[0]);
                    appAttachDownloadUI.csC();
                    return;
                }
            }
        }
        appAttachDownloadUI.csB();
    }

    static /* synthetic */ void e(AppAttachDownloadUI appAttachDownloadUI) {
        Intent intent = new Intent(appAttachDownloadUI, AppAttachFileListUI.class);
        intent.setFlags(67108864);
        appAttachDownloadUI.startActivity(intent);
        h.mEJ.h(11168, new Object[]{Integer.valueOf(6), Integer.valueOf(1)});
    }

    static /* synthetic */ void f(AppAttachDownloadUI appAttachDownloadUI) {
        Intent intent = new Intent(appAttachDownloadUI, ChattingSendDataToDeviceUI.class);
        intent.putExtra("Retr_Msg_Id", appAttachDownloadUI.bXQ.field_msgId);
        appAttachDownloadUI.startActivity(intent);
    }

    static /* synthetic */ void g(AppAttachDownloadUI appAttachDownloadUI) {
        if (appAttachDownloadUI.csE() != null) {
            ix ixVar = new ix();
            ixVar.bSA.bIC = 27;
            ixVar.bSA.bID = 1;
            if (appAttachDownloadUI.csE() != null) {
                ixVar.bSA.filePath = appAttachDownloadUI.csE().field_fileFullPath;
            }
            com.tencent.mm.sdk.b.a.sFg.m(ixVar);
            s.makeText(ad.getContext(), String.format("current template is %d", new Object[]{Integer.valueOf(p.zP(0))}), 1).show();
        }
    }

    static /* synthetic */ void h(AppAttachDownloadUI appAttachDownloadUI) {
        bc bcVar = new bc();
        bcVar.bIB.bIC = 35;
        bcVar.bIB.bID = 1;
        if (appAttachDownloadUI.csE() != null) {
            bcVar.bIB.filePath = appAttachDownloadUI.csE().field_fileFullPath;
        }
        com.tencent.mm.sdk.b.a.sFg.m(bcVar);
        s.makeText(ad.getContext(), String.format("apply success", new Object[0]), 1).show();
    }

    static /* synthetic */ void i(AppAttachDownloadUI appAttachDownloadUI) {
        ix ixVar = new ix();
        ixVar.bSA.bIC = 40;
        ixVar.bSA.bID = 1;
        if (appAttachDownloadUI.csE() != null) {
            ixVar.bSA.filePath = appAttachDownloadUI.csE().field_fileFullPath;
            ixVar.bSA.filePath = appAttachDownloadUI.csE().field_fileFullPath;
        }
        com.tencent.mm.sdk.b.a.sFg.m(ixVar);
        s.makeText(ad.getContext(), String.format("current wxa template is %d", new Object[]{Integer.valueOf(n.adQ())}), 1).show();
    }

    static /* synthetic */ void j(AppAttachDownloadUI appAttachDownloadUI) {
        ix ixVar = new ix();
        ixVar.bSA.bIC = 27;
        ixVar.bSA.bID = 2;
        if (appAttachDownloadUI.csE() != null) {
            ixVar.bSA.filePath = appAttachDownloadUI.csE().field_fileFullPath;
        }
        com.tencent.mm.sdk.b.a.sFg.m(ixVar);
        s.makeText(ad.getContext(), String.format("current browse template is %d", new Object[]{Integer.valueOf(p.zP(1))}), 1).show();
    }

    static /* synthetic */ void u(AppAttachDownloadUI appAttachDownloadUI) {
        b csE = appAttachDownloadUI.csE();
        if (csE == null) {
            x.e("MicroMsg.AppAttachDownloadUI", "open fail, info is null");
        } else if (csE.field_fileFullPath == null || csE.field_fileFullPath.length() == 0) {
            x.e("MicroMsg.AppAttachDownloadUI", "open fail, field fileFullPath is null");
        } else {
            com.tencent.mm.pluginsdk.ui.tools.a.b(appAttachDownloadUI, csE.field_fileFullPath, appAttachDownloadUI.fjS, 1);
            appAttachDownloadUI.jcg.setEnabled(false);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        init();
    }

    private void init() {
        boolean z;
        setMMTitle(R.l.download_title);
        this.bJC = getIntent().getLongExtra("app_msg_id", -1);
        if (this.bJC == -1) {
            z = false;
        } else {
            au.HU();
            this.bXQ = c.FT().dW(this.bJC);
            if (this.bXQ == null || this.bXQ.field_msgId == 0 || this.bXQ.field_content == null) {
                z = false;
            } else {
                this.tGg = com.tencent.mm.model.s.fq(this.bXQ.field_talker);
                this.bWW = this.bXQ.field_content;
                if (this.tGg && this.bXQ.field_isSend == 0) {
                    String str = this.bXQ.field_content;
                    if (this.tGg && str != null) {
                        str = com.tencent.mm.model.bd.iC(str);
                    }
                    this.bWW = str;
                }
                this.tGh = g.a.gp(this.bWW);
                if (this.tGh == null) {
                    x.e("MicroMsg.AppAttachDownloadUI", "summerapp parse msgContent error, %s", new Object[]{this.bWW});
                    z = false;
                } else {
                    if (ai.oW(this.tGh.bGP) && !ai.oW(this.tGh.dwD)) {
                        x.e("MicroMsg.AppAttachDownloadUI", "summerapp msgContent format error, %s", new Object[]{this.bWW});
                        this.tGh.bGP = this.tGh.dwD.hashCode();
                    }
                    this.dPU = this.tGh.type;
                    this.mediaId = this.tGh.bGP;
                    this.fileName = ai.oV(this.tGh.title);
                    this.fjS = ai.oV(this.tGh.dwp).toLowerCase();
                    this.kni = ai.oV(this.tGh.filemd5);
                    this.bSS = ai.oV(this.tGh.bSS);
                    this.dwK = ai.oV(this.tGh.dwK);
                    x.i("MicroMsg.AppAttachDownloadUI", "summerapp initParams msgId[%d], sender[%d], msgContent[%s], appType[%d], mediaId[%s], fileName[%s]", new Object[]{Long.valueOf(this.bJC), Integer.valueOf(this.bXQ.field_isSend), this.bWW, Integer.valueOf(this.dPU), this.mediaId, this.fileName});
                    b csE = csE();
                    if (csE == null) {
                        x.i("MicroMsg.AppAttachDownloadUI", "summerapp initParams attInfo is null");
                        this.tGj = false;
                    } else {
                        File file = new File(csE.field_fileFullPath);
                        if (csE.field_offset > 0) {
                            this.tGj = true;
                        } else {
                            this.tGj = false;
                        }
                        x.i("MicroMsg.AppAttachDownloadUI", "summerapp initParams attInfo field_fileFullPath[%s], field_offset[%d], isDownloadStarted[%b]", new Object[]{csE.field_fileFullPath, Long.valueOf(csE.field_offset), Boolean.valueOf(this.tGj)});
                    }
                    z = a(csE) ? com.tencent.mm.pluginsdk.ui.tools.a.a(this, csE.field_fileFullPath, this.fjS, 1) : true;
                }
            }
        }
        if (z) {
            File file2 = new File(com.tencent.mm.compatible.util.e.dgj);
            if (!file2.exists()) {
                file2.mkdir();
            }
            ao.asF().c(this);
            initView();
            return;
        }
        finish();
    }

    protected void onDestroy() {
        ao.asF().d(this);
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        au.DF().a(221, this);
        au.DF().a(728, this);
        ln lnVar = new ln();
        lnVar.bVQ.bVR = true;
        com.tencent.mm.sdk.b.a.sFg.a(lnVar, getMainLooper());
        x.d("MicroMsg.AppAttachDownloadUI", "AppAttachDownloadUI req pause auto download logic");
        this.jcg.setEnabled(true);
    }

    protected void onPause() {
        au.DF().b(221, this);
        au.DF().b(728, this);
        super.onPause();
        ln lnVar = new ln();
        lnVar.bVQ.bVR = false;
        com.tencent.mm.sdk.b.a.sFg.a(lnVar, getMainLooper());
        x.d("MicroMsg.AppAttachDownloadUI", "AppAttachDownloadUI cancel pause auto download logic");
    }

    protected final void initView() {
        this.mel = (MMImageView) findViewById(R.h.download_type_icon);
        this.jck = findViewById(R.h.download_progress_area);
        this.eVR = (ProgressBar) findViewById(R.h.download_pb);
        this.mem = (ImageView) findViewById(R.h.download_stop_btn);
        this.jnr = (Button) findViewById(R.h.download_continue_btn);
        this.jcg = (Button) findViewById(R.h.download_open_btn);
        this.tGd = findViewById(R.h.download_data_area);
        this.eGD = (TextView) findViewById(R.h.download_hint);
        this.tGe = (TextView) findViewById(R.h.download_data_size);
        this.tGf = (TextView) findViewById(R.h.download_file_name);
        this.tGm = (LinearLayout) findViewById(R.h.download_ll);
        this.tGn = (LinearLayout) findViewById(R.h.load_fail_ll);
        this.mem.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppAttachDownloadUI.this.jck.setVisibility(8);
                AppAttachDownloadUI.this.jnr.setVisibility(0);
                AppAttachDownloadUI.this.tGd.setVisibility(8);
                x.i("MicroMsg.AppAttachDownloadUI", "summerapp stopBtn downloadAppAttachScene[%s]", new Object[]{AppAttachDownloadUI.this.qzW});
                if (AppAttachDownloadUI.this.qzW != null) {
                    ac a = AppAttachDownloadUI.this.qzW;
                    AppAttachDownloadUI appAttachDownloadUI = AppAttachDownloadUI.this;
                    if (!a.qAk) {
                        com.tencent.mm.modelcdntran.g.ND().lx(a.dVk);
                        a.qAe = ao.asF().SR(a.mediaId);
                    }
                    x.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig pause listener[%s], info[%s], justSaveFile[%b], stack[%s]", new Object[]{appAttachDownloadUI, a.qAe, Boolean.valueOf(a.qAk), bi.cjd()});
                    if (a.qAe != null) {
                        if (a.qAe.field_status == 101 && appAttachDownloadUI != null) {
                            appAttachDownloadUI.cbU();
                        }
                        a.qAe.field_status = 102;
                        if (!a.qAk) {
                            ao.asF().c(a.qAe, new String[0]);
                        }
                    }
                    com.tencent.mm.kernel.g.DF().c(AppAttachDownloadUI.this.qzW);
                    return;
                }
                b o = AppAttachDownloadUI.this.csE();
                if (o != null && o.field_status != 199) {
                    x.i("MicroMsg.AppAttachDownloadUI", "summerapp stopBtn onClick but scene is null and set status[%d] paused", new Object[]{Long.valueOf(o.field_status)});
                    o.field_status = 102;
                    ao.asF().c(o, new String[0]);
                }
            }
        });
        this.jnr.setOnClickListener(new 6(this));
        this.jcg.setOnClickListener(new 7(this));
        switch (this.dPU) {
            case 0:
            case 7:
                if (!bi.Xi(this.fjS)) {
                    this.mel.setImageResource(R.k.app_attach_file_icon_unknow);
                    break;
                } else {
                    this.mel.setImageResource(R.g.app_attach_file_icon_pic);
                    break;
                }
            case 2:
                this.mel.setImageResource(R.g.app_attach_file_icon_pic);
                break;
            case 4:
                this.mel.setImageResource(R.k.app_attach_file_icon_video);
                break;
            case 6:
                this.mel.setImageResource(o.SQ(this.fjS));
                break;
            default:
                this.mel.setImageResource(R.k.app_attach_file_icon_unknow);
                break;
        }
        setBackBtn(new 1(this));
        this.bUY = getIntent().getBooleanExtra("app_show_share", true);
        if (this.bUY) {
            addIconOptionMenu(0, R.k.actionbar_icon_dark_more, new 2(this));
        }
        this.tGi = false;
        b csE = csE();
        boolean z = (csE == null || !new File(csE.field_fileFullPath).exists()) ? false : csE.aSc() || (this.bXQ.field_isSend == 1 && csE.field_isUpload);
        if (z) {
            x.i("MicroMsg.AppAttachDownloadUI", "summerapp isCanOpenFile");
            this.tGi = true;
            csF();
        } else if (csE != null && csE.aSc() && !new File(csE.field_fileFullPath).exists()) {
            x.i("MicroMsg.AppAttachDownloadUI", "summerapp set fail info[%s]", new Object[]{csE});
            this.tGm.setVisibility(8);
            this.tGn.setVisibility(0);
        } else if (!this.tGi) {
            this.ijX = new 4(this);
            switch (this.dPU) {
                case 0:
                case 6:
                    if (this.tGj) {
                        this.jnr.setVisibility(0);
                    } else {
                        this.jnr.setVisibility(8);
                    }
                    this.jck.setVisibility(8);
                    this.tGd.setVisibility(8);
                    this.jcg.setVisibility(8);
                    this.eGD.setVisibility(8);
                    this.tGf.setVisibility(0);
                    if (this.fileName.equals("")) {
                        this.tGf.setText(getString(R.l.openapi_app_file));
                    } else {
                        this.tGf.setText(this.fileName);
                    }
                    String mimeType = getMimeType();
                    if (mimeType == null || mimeType.equals("")) {
                        this.eGD.setText(getString(R.l.download_can_not_open));
                    } else {
                        this.eGD.setText(getString(R.l.download_can_not_open_by_wechat));
                    }
                    if (bi.Xi(this.fjS)) {
                        this.eGD.setVisibility(8);
                        break;
                    }
                    break;
                case 2:
                    this.jck.setVisibility(8);
                    this.tGd.setVisibility(8);
                    if (this.tGj) {
                        this.jnr.setVisibility(0);
                    } else {
                        this.jnr.setVisibility(8);
                    }
                    this.jcg.setVisibility(8);
                    this.tGf.setVisibility(8);
                    this.eGD.setVisibility(8);
                    break;
                case 7:
                    if (this.tGj) {
                        this.jnr.setVisibility(0);
                    } else {
                        this.jnr.setVisibility(8);
                    }
                    this.jck.setVisibility(8);
                    this.tGd.setVisibility(8);
                    this.jcg.setVisibility(8);
                    this.tGf.setVisibility(8);
                    this.eGD.setVisibility(8);
                    this.eGD.setText(getString(R.l.download_can_not_open_by_wechat));
                    break;
            }
            x.i("MicroMsg.AppAttachDownloadUI", "summerapp progressCallBack[%s], isDownloadFinished[%b], isDownloadStarted[%b]", new Object[]{this.ijX, Boolean.valueOf(this.tGi), Boolean.valueOf(this.tGj)});
            if (this.dPU == 2 || !(this.tGi || this.tGj)) {
                csC();
            }
        }
    }

    private void csB() {
        ch chVar = new ch();
        com.tencent.mm.pluginsdk.model.e.a(chVar, this.bXQ);
        chVar.bJF.activity = this;
        chVar.bJF.bJM = 39;
        com.tencent.mm.sdk.b.a.sFg.m(chVar);
    }

    private void csC() {
        this.jck.setVisibility(0);
        this.jnr.setVisibility(8);
        this.tGd.setVisibility(0);
        if (csD()) {
            this.qzW = new ac(this.bJC, this.mediaId, this.ijX);
            au.DF().a(this.qzW, 0);
            z.w(this.bXQ);
        }
    }

    private boolean csD() {
        boolean z;
        int i = -1;
        b csE = csE();
        String str;
        if (csE == null) {
            l.c(this.bJC, this.bWW, null);
            csE = csE();
            if (csE != null) {
                String str2 = "MicroMsg.AppAttachDownloadUI";
                str = "summerapp tryInitAttachInfo newInfo systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], signature len[%d]";
                Object[] objArr = new Object[8];
                objArr[0] = Long.valueOf(csE.sKx);
                objArr[1] = Long.valueOf(csE.field_totalLen);
                objArr[2] = csE.field_fileFullPath;
                objArr[3] = Long.valueOf(csE.field_type);
                objArr[4] = csE.field_mediaId;
                objArr[5] = Long.valueOf(csE.field_msgInfoId);
                objArr[6] = Boolean.valueOf(csE.field_isUpload);
                if (csE.field_signature != null) {
                    i = csE.field_signature.length();
                }
                objArr[7] = Integer.valueOf(i);
                x.i(str2, str, objArr);
                if (this.tGh.dws != 0 || this.tGh.dwo > 26214400) {
                    boolean z2;
                    if (ai.oW(csE.field_signature)) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    z = z2;
                }
            }
            z = true;
        } else {
            File file = new File(csE.field_fileFullPath);
            if (csE.field_status == 199 && !file.exists()) {
                x.i("MicroMsg.AppAttachDownloadUI", "summerapp tryInitAttachInfo info exist but file not!");
                l.c(this.bJC, this.bWW, null);
            }
            str = "MicroMsg.AppAttachDownloadUI";
            String str3 = "summerapp tryInitAttachInfo info exist systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], file.exists[%b], status[%d], signature len[%d]";
            Object[] objArr2 = new Object[10];
            objArr2[0] = Long.valueOf(csE.sKx);
            objArr2[1] = Long.valueOf(csE.field_totalLen);
            objArr2[2] = csE.field_fileFullPath;
            objArr2[3] = Long.valueOf(csE.field_type);
            objArr2[4] = csE.field_mediaId;
            objArr2[5] = Long.valueOf(csE.field_msgInfoId);
            objArr2[6] = Boolean.valueOf(csE.field_isUpload);
            objArr2[7] = Boolean.valueOf(file.exists());
            objArr2[8] = Long.valueOf(csE.field_status);
            if (csE.field_signature != null) {
                i = csE.field_signature.length();
            }
            objArr2[9] = Integer.valueOf(i);
            x.i(str, str3, objArr2);
            z = true;
        }
        if (!z) {
            au.DF().a(new com.tencent.mm.pluginsdk.model.app.z(csE, this.dwK, this.kni, this.fileName, this.fjS, this.bSS), 0);
        }
        return z;
    }

    private String getMimeType() {
        g.a gp = g.a.gp(this.bWW);
        String str = null;
        if (gp.dwp != null && gp.dwp.length() > 0) {
            str = MimeTypeMap.getSingleton().getMimeTypeFromExtension(gp.dwp);
        }
        if (str != null && str.length() != 0) {
            return str;
        }
        x.w("MicroMsg.AppAttachDownloadUI", "getMimeType fail, not a built-in mimetype, use \"*/{fileext}\" instead");
        return "*/" + gp.dwp;
    }

    private b csE() {
        b fH = ao.asF().fH(this.bJC);
        if (fH != null) {
            x.i("MicroMsg.AppAttachDownloadUI", "summerapp getAppAttachInfo by msgId [%d] stack[%s]", new Object[]{Long.valueOf(this.bJC), ai.VI()});
        } else {
            fH = l.SZ(this.mediaId);
            if (fH == null) {
                x.i("MicroMsg.AppAttachDownloadUI", "summerapp getAppAttachInfo by msgId and mediaId is null stack[%s]", new Object[]{ai.VI()});
            } else if (!(fH.field_msgInfoId == this.bJC || com.tencent.mm.a.e.cn(fH.field_fileFullPath))) {
                l.c(this.bJC, this.bWW, null);
                b fH2 = ao.asF().fH(this.bJC);
                if (fH2 == null) {
                    x.w("MicroMsg.AppAttachDownloadUI", "summerapp getAppAttachInfo create new info from local but failed stack[%s]", new Object[]{ai.VI()});
                } else {
                    com.tencent.mm.sdk.f.e.post(new 8(this, fH, fH2), "copyAttachFromLocal");
                }
            }
        }
        return fH;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        com.tencent.mm.pluginsdk.ui.tools.a.a(this, i, i2, intent, this.tGk, R.l.download_no_match_msg, R.l.download_no_match_title, 1);
    }

    public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
        b csE = csE();
        if (csE != null) {
            long j = csE.field_totalLen;
            this.tGe.setText(getString(R.l.download_data, new Object[]{ai.bF(csE.field_offset), ai.bF(j)}));
            int i = csE.field_totalLen == 0 ? 0 : (int) ((csE.field_offset * 100) / csE.field_totalLen);
            x.v("MicroMsg.AppAttachDownloadUI", "summerapp attach progress:" + i + " offset:" + r4 + " totallen:" + j);
            this.eVR.setProgress(i);
            if (csE.field_status == 199 && i >= 100 && !this.tGi) {
                this.tGi = true;
                if (this.tGo) {
                    this.tGo = false;
                    csB();
                }
                if (csE != null) {
                    Toast.makeText(this, getString(R.l.download_success) + " : " + csE.field_fileFullPath.replaceFirst(com.tencent.mm.compatible.util.e.bnC, com.tencent.mm.compatible.util.e.dgi), this.tGl).show();
                    com.tencent.mm.pluginsdk.ui.tools.a.b(this, csE.field_fileFullPath, this.fjS, 1);
                }
                ah.i(new Runnable() {
                    public final void run() {
                        AppAttachDownloadUI.this.csF();
                    }
                }, 200);
            }
            if (this.jck.getVisibility() != 0 && i < 100 && !csE.field_isUpload && csE.field_status == 101) {
                x.i("MicroMsg.AppAttachDownloadUI", "summerapp still downloading updateProgress progress[%d]", new Object[]{Integer.valueOf(i)});
                this.jck.setVisibility(0);
                this.jnr.setVisibility(8);
                this.tGd.setVisibility(0);
            }
        }
    }

    private void csF() {
        Intent intent;
        switch (this.dPU) {
            case 0:
            case 6:
                if (!csG()) {
                    return;
                }
                if (bi.Xi(this.fjS)) {
                    b csE = csE();
                    Intent intent2 = new Intent(this, ShowImageUI.class);
                    intent2.putExtra("key_message_id", this.bXQ.field_msgId);
                    intent2.putExtra("key_image_path", csE.field_fileFullPath);
                    intent2.putExtra("key_favorite", true);
                    startActivity(intent2);
                    finish();
                    return;
                }
                String mimeType = getMimeType();
                this.eGD.setVisibility(0);
                this.jck.setVisibility(8);
                this.tGd.setVisibility(8);
                this.jnr.setVisibility(8);
                this.tGf.setVisibility(0);
                if (this.fileName.equals("")) {
                    this.tGf.setText(getString(R.l.openapi_app_file));
                } else {
                    this.tGf.setText(this.fileName);
                }
                if (mimeType == null || mimeType.equals("")) {
                    this.jcg.setVisibility(8);
                    this.eGD.setText(getString(R.l.download_can_not_open));
                    return;
                }
                this.jcg.setVisibility(0);
                this.eGD.setText(getString(R.l.download_can_not_open_by_wechat));
                return;
            case 2:
                if (csG()) {
                    intent = new Intent(this, ImageGalleryUI.class);
                    intent.putExtra("img_gallery_msg_id", this.bXQ.field_msgId);
                    intent.putExtra("img_gallery_talker", this.bXQ.field_talker);
                    startActivity(intent);
                    finish();
                    overridePendingTransition(0, 0);
                    return;
                }
                return;
            case 7:
                intent = new Intent();
                intent.putExtra("App_MsgId", this.bJC);
                setResult(-1, intent);
                finish();
                return;
            default:
                this.jcg.setVisibility(0);
                this.jck.setVisibility(8);
                this.tGd.setVisibility(8);
                return;
        }
    }

    private boolean csG() {
        b csE = csE();
        if (csE == null) {
            return true;
        }
        if (com.tencent.mm.a.e.cn(csE.field_fileFullPath)) {
            this.jck.setVisibility(8);
            this.tGd.setVisibility(8);
            this.jnr.setVisibility(8);
            return true;
        }
        this.tGm.setVisibility(8);
        this.tGn.setVisibility(0);
        return false;
    }

    protected final int getLayoutId() {
        return R.i.download_ui;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        x.i("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd type[%d], [%d, %d, %s]", new Object[]{Integer.valueOf(lVar.getType()), Integer.valueOf(i), Integer.valueOf(i2), str});
        if (lVar.getType() != 221 && lVar.getType() != 728) {
            return;
        }
        if (lVar.getType() == 728 && i == 0 && i2 == 0) {
            b csE = csE();
            if (csE == null) {
                x.i("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd getAppAttachInfo is null");
            } else {
                String str2 = "MicroMsg.AppAttachDownloadUI";
                String str3 = "summerapp onSceneEnd CheckBigFileDownload ok signature len[%d] start NetSceneDownloadAppAttach";
                Object[] objArr = new Object[1];
                objArr[0] = Integer.valueOf(csE.field_signature == null ? -1 : csE.field_signature.length());
                x.i(str2, str3, objArr);
            }
            this.qzW = new ac(this.bJC, this.mediaId, this.ijX);
            au.DF().a(this.qzW, 0);
            return;
        }
        if (this.qzW == null && (lVar instanceof ac)) {
            ac acVar = (ac) lVar;
            b csE2 = csE();
            if (!(csE2 == null || ai.oW(csE2.field_mediaSvrId) || !csE2.field_mediaSvrId.equals(acVar.getMediaId()))) {
                this.qzW = acVar;
                x.i("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd reset downloadAppAttachScene[%s] by mediaSvrId[%s]", new Object[]{this.qzW, csE2.field_mediaSvrId});
            }
        }
        h hVar;
        Object[] objArr2;
        if (i == 0 && i2 == 0) {
            hVar = h.mEJ;
            objArr2 = new Object[6];
            objArr2[0] = this.tGh.dwD;
            objArr2[1] = Integer.valueOf(this.tGh.dws == 1 ? 7 : 5);
            objArr2[2] = Integer.valueOf(this.tGh.dwo);
            objArr2[3] = Integer.valueOf(0);
            objArr2[4] = Integer.valueOf(0);
            objArr2[5] = this.fjS;
            hVar.h(14665, objArr2);
            return;
        }
        if (i2 != 0 && com.tencent.mm.sdk.a.b.chp()) {
            Toast.makeText(this, "errCode[" + i2 + "]", 0).show();
        }
        if (i2 == -5103059) {
            this.tGn.setVisibility(0);
            this.tGm.setVisibility(8);
            if (this.dPU == 6) {
                hVar = h.mEJ;
                objArr2 = new Object[6];
                objArr2[0] = this.tGh.dwD;
                objArr2[1] = Integer.valueOf(this.tGh.dws == 1 ? 7 : 5);
                objArr2[2] = Integer.valueOf(this.tGh.dwo);
                objArr2[3] = Integer.valueOf(1);
                objArr2[4] = Integer.valueOf(0);
                objArr2[5] = this.fjS;
                hVar.h(14665, objArr2);
                return;
            }
            return;
        }
        this.jck.setVisibility(8);
        this.jnr.setVisibility(0);
        this.tGd.setVisibility(8);
        x.e("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd, download fail, type = " + lVar.getType() + " errType = " + i + ", errCode = " + i2);
    }

    public final void cbU() {
        Toast.makeText(this, R.l.download_pause_tip, 0).show();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        init();
    }

    private static boolean a(b bVar) {
        if (bVar == null) {
            return false;
        }
        File file = new File(bVar.field_fileFullPath);
        if (file.exists() && file.length() == bVar.field_totalLen) {
            return true;
        }
        return false;
    }
}
