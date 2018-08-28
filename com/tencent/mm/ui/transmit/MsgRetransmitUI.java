package com.tencent.mm.ui.transmit;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.f;
import com.tencent.mm.ak.l;
import com.tencent.mm.ak.o;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.n;
import com.tencent.mm.g.a.ow;
import com.tencent.mm.g.a.px;
import com.tencent.mm.g.a.py;
import com.tencent.mm.model.au;
import com.tencent.mm.model.br;
import com.tencent.mm.model.ca;
import com.tencent.mm.model.m;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.i$l;
import com.tencent.mm.pluginsdk.model.app.aa;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.j;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.y.g.a;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class MsgRetransmitUI extends MMBaseActivity implements e {
    public long bJC;
    private String bOX;
    private float bSx;
    public String bWW;
    private int dTO = 0;
    private float dVI;
    private String dVJ;
    private f dVg = null;
    private ProgressDialog eHw = null;
    public String fileName;
    private String fmS;
    long hpD;
    private int length;
    private ag mHandler = new ag();
    public int msgType;
    boolean qIZ;
    private long startTime = 0;
    private boolean tFy = false;
    private boolean uDA;
    private boolean uDB = true;
    private boolean uDC = true;
    private int uDD = 0;
    private int uDE;
    private String uDF;
    private String uDG;
    private int uDH;
    private int uDI;
    private boolean uDJ = true;
    boolean uDK = false;
    public List<String> uDl;
    private String uDm = null;
    private boolean uDn = true;
    private boolean uDo = false;
    private c uDp;
    private int uDq = 0;
    private int uDr = 0;
    private l uDs = null;
    private boolean uDt = false;
    private List<String> uDu = null;
    private int uDv = 0;
    private int uDw = 0;
    private boolean uDx = false;
    private boolean uDy = false;
    private int uDz;
    private int ubT = -1;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        ak.a(getWindow());
        x.i("MicroMsg.MsgRetransmitUI", "on activity create");
        this.startTime = bi.VE();
        this.msgType = getIntent().getIntExtra("Retr_Msg_Type", -1);
        this.bWW = getIntent().getStringExtra("Retr_Msg_content");
        this.bJC = getIntent().getLongExtra("Retr_Msg_Id", -1);
        this.fileName = getIntent().getStringExtra("Retr_File_Name");
        this.uDu = getIntent().getStringArrayListExtra("Retr_File_Path_List");
        boolean z = this.uDu != null && this.uDu.size() > 0;
        this.uDx = z;
        this.dTO = getIntent().getIntExtra("Retr_Compress_Type", 0);
        this.uDr = getIntent().getIntExtra("Retr_Scene", 0);
        this.length = getIntent().getIntExtra("Retr_length", 0);
        this.uDq = getIntent().getIntExtra("Retr_video_isexport", 0);
        this.uDm = getIntent().getStringExtra("Retr_Msg_thumb_path");
        this.uDn = getIntent().getBooleanExtra("Retr_go_to_chattingUI", true);
        this.uDB = getIntent().getBooleanExtra("Retr_start_where_you_are", true);
        Intent intent = getIntent();
        String str = "Multi_Retr";
        if (this.uDr == 0) {
            z = true;
        } else {
            z = false;
        }
        this.uDC = intent.getBooleanExtra(str, z);
        if (this.uDC) {
            this.uDB = true;
        }
        this.uDo = getIntent().getBooleanExtra("Retr_show_success_tips", this.uDB);
        this.uDy = getIntent().getBooleanExtra("Edit_Mode_Sigle_Msg", false);
        this.tFy = getIntent().getBooleanExtra("is_group_chat", false);
        this.ubT = getIntent().getIntExtra("Retr_Biz_Msg_Selected_Msg_Index", -1);
        this.bOX = getIntent().getStringExtra("Retr_NewYear_Thumb_Path");
        this.uDz = getIntent().getIntExtra("Retr_MsgImgScene", 0);
        this.dVI = getIntent().getFloatExtra("Retr_Longtitude", -1000.0f);
        this.bSx = getIntent().getFloatExtra("Retr_Latitude", -1000.0f);
        this.dVJ = getIntent().getStringExtra("Retr_AttachedContent");
        this.uDA = "gallery".equals(getIntent().getStringExtra("Retr_From"));
        this.fmS = getIntent().getStringExtra("reportSessionId");
        this.uDE = getIntent().getIntExtra("Retr_MsgFromScene", 0);
        this.uDF = getIntent().getStringExtra("Retr_MsgFromUserName");
        this.uDG = getIntent().getStringExtra("Retr_MsgTalker");
        this.uDH = getIntent().getIntExtra("Retr_MsgAppBrandFromScene", 1);
        this.uDI = getIntent().getIntExtra("Retr_MsgAppBrandServiceType", 0);
        au.DF().a(i$l.AppCompatTheme_spinnerStyle, this);
        if (!d.fR(19)) {
            setContentView(R.i.black_empty_layout);
        }
        Intent intent2 = new Intent(this, SelectConversationUI.class);
        intent2.putExtra("scene", 8);
        intent2.putExtra("select_is_ret", true);
        if (this.uDC) {
            intent2.putExtra("mutil_select_is_ret", true);
        }
        switch (this.msgType) {
            case 2:
            case 6:
            case 7:
            case 14:
            case 15:
            case 16:
                intent2.putExtra("appbrand_params", getIntent().getSerializableExtra("appbrand_params"));
                if (this.uDE == 3) {
                    intent2.putExtra("scene_from", 3);
                }
                intent2.putExtra("Retr_Biz_Msg_Selected_Msg_Index", this.ubT);
                intent2.putExtra("Retr_Big_File", getIntent().getBooleanExtra("Retr_Big_File", false));
                intent2.putExtra("Select_Conv_Type", 3);
                break;
            case 13:
                intent2.putExtra("Select_Conv_Type", 11);
                break;
            default:
                intent2.putExtra("Select_Conv_Type", 3);
                break;
        }
        intent2.putExtra("Retr_Msg_Type", this.msgType);
        intent2.putExtra("Retr_Msg_Id", this.bJC);
        intent2.putExtra("Retr_Msg_content", this.bWW);
        intent2.putExtra("image_path", this.fileName);
        startActivityForResult(intent2, 0);
    }

    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    protected void onDestroy() {
        if (!this.uDt) {
            au.DF().b(i$l.AppCompatTheme_spinnerStyle, this);
        }
        super.onDestroy();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void cAb() {
        /*
        r15 = this;
        r14 = 3;
        r8 = 2;
        r1 = 0;
        r4 = 1;
        r6 = 0;
        r0 = r15.uDr;
        switch(r0) {
            case 0: goto L_0x0021;
            case 1: goto L_0x0406;
            case 2: goto L_0x04ca;
            default: goto L_0x000a;
        };
    L_0x000a:
        r0 = "MicroMsg.MsgRetransmitUI";
        r1 = "unknown scene %s";
        r2 = new java.lang.Object[r4];
        r3 = r15.uDr;
        r3 = java.lang.Integer.valueOf(r3);
        r2[r6] = r3;
        com.tencent.mm.sdk.platformtools.x.e(r0, r1, r2);
        r15.finish();
    L_0x0020:
        return;
    L_0x0021:
        r0 = r15.msgType;
        switch(r0) {
            case 0: goto L_0x007c;
            case 1: goto L_0x007c;
            case 2: goto L_0x0039;
            case 3: goto L_0x0026;
            case 4: goto L_0x0087;
            case 5: goto L_0x007c;
            case 6: goto L_0x0039;
            case 7: goto L_0x00a9;
            case 8: goto L_0x007c;
            case 9: goto L_0x00c7;
            case 10: goto L_0x0039;
            case 11: goto L_0x007c;
            case 12: goto L_0x0039;
            case 13: goto L_0x0039;
            case 14: goto L_0x0039;
            case 15: goto L_0x00a4;
            case 16: goto L_0x0039;
            default: goto L_0x0026;
        };
    L_0x0026:
        r0 = "MicroMsg.MsgRetransmitUI";
        r2 = "unknown type %s";
        r3 = new java.lang.Object[r4];
        r5 = r15.msgType;
        r5 = java.lang.Integer.valueOf(r5);
        r3[r6] = r5;
        com.tencent.mm.sdk.platformtools.x.e(r0, r2, r3);
    L_0x0039:
        r0 = r4;
    L_0x003a:
        if (r0 == 0) goto L_0x0020;
    L_0x003c:
        r0 = r15.msgType;
        r2 = 11;
        if (r0 == r2) goto L_0x0046;
    L_0x0042:
        r0 = r15.msgType;
        if (r0 != r4) goto L_0x013d;
    L_0x0046:
        r0 = r15.uDl;
        r1 = "MicroMsg.MsgRetransmitUI";
        r2 = "processVideoTransfer";
        com.tencent.mm.sdk.platformtools.x.i(r1, r2);
        r1 = 11;
        r2 = r15.msgType;
        if (r1 != r2) goto L_0x00e5;
    L_0x0057:
        r1 = r15.fileName;
        r1 = com.tencent.mm.modelvideo.t.nY(r1);
        if (r1 == 0) goto L_0x00e5;
    L_0x005f:
        r0 = r15.getResources();
        r1 = com.tencent.mm.R.l.sendrequest_send_fail;
        r0 = r0.getString(r1);
        r1 = "";
        com.tencent.mm.ui.widget.snackbar.b.d(r15, r0, r1);
        r0 = r15.mHandler;
        r1 = new com.tencent.mm.ui.transmit.MsgRetransmitUI$15;
        r1.<init>(r15);
        r2 = 1800; // 0x708 float:2.522E-42 double:8.893E-321;
        r0.postDelayed(r1, r2);
        goto L_0x0020;
    L_0x007c:
        r0 = r15.cAc();
        if (r0 != 0) goto L_0x0039;
    L_0x0082:
        r15.finish();
        r0 = r6;
        goto L_0x003a;
    L_0x0087:
        r0 = r15.bWW;
        if (r0 == 0) goto L_0x0096;
    L_0x008b:
        r0 = r15.bWW;
        r2 = "";
        r0 = r0.equals(r2);
        if (r0 == 0) goto L_0x0039;
    L_0x0096:
        r0 = "MicroMsg.MsgRetransmitUI";
        r2 = "Transfer text erro: content null";
        com.tencent.mm.sdk.platformtools.x.e(r0, r2);
        r15.finish();
        r0 = r6;
        goto L_0x003a;
    L_0x00a4:
        r15.finish();
        r0 = r6;
        goto L_0x003a;
    L_0x00a9:
        r0 = r15.cAc();
        if (r0 != 0) goto L_0x00b4;
    L_0x00af:
        r15.finish();
        r0 = r6;
        goto L_0x003a;
    L_0x00b4:
        r0 = r15.fileName;
        if (r0 != 0) goto L_0x0039;
    L_0x00b8:
        r0 = "MicroMsg.MsgRetransmitUI";
        r2 = "Transfer fileName erro: fileName null";
        com.tencent.mm.sdk.platformtools.x.e(r0, r2);
        r15.finish();
        r0 = r6;
        goto L_0x003a;
    L_0x00c7:
        r0 = r15.bWW;
        if (r0 == 0) goto L_0x00d6;
    L_0x00cb:
        r0 = r15.bWW;
        r2 = "";
        r0 = r0.equals(r2);
        if (r0 == 0) goto L_0x0039;
    L_0x00d6:
        r0 = "MicroMsg.MsgRetransmitUI";
        r2 = "Transfer text erro: content null";
        com.tencent.mm.sdk.platformtools.x.e(r0, r2);
        r15.finish();
        r0 = r6;
        goto L_0x003a;
    L_0x00e5:
        r1 = r15.fileName;
        r1 = com.tencent.mm.modelvideo.t.nW(r1);
        if (r1 == 0) goto L_0x00f3;
    L_0x00ed:
        r2 = r1.status;
        r3 = 199; // 0xc7 float:2.79E-43 double:9.83E-322;
        if (r2 != r3) goto L_0x00f8;
    L_0x00f3:
        r15.ec(r0);
        goto L_0x0020;
    L_0x00f8:
        r2 = new com.tencent.mm.ui.transmit.MsgRetransmitUI$9;
        r2.<init>(r15, r0);
        r0 = com.tencent.mm.modelvideo.o.Ta();
        r3 = android.os.Looper.getMainLooper();
        r0.a(r2, r3);
        r0 = "MicroMsg.MsgRetransmitUI";
        r2 = "oreh sendVideo start  fileName:%s";
        r3 = new java.lang.Object[r4];
        r4 = r15.fileName;
        r3[r6] = r4;
        com.tencent.mm.sdk.platformtools.x.i(r0, r2, r3);
        r0 = r1.To();
        if (r0 == 0) goto L_0x012d;
    L_0x011d:
        r0 = "MicroMsg.MsgRetransmitUI";
        r1 = "start complete online video";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        r0 = r15.fileName;
        com.tencent.mm.modelvideo.t.oa(r0);
        goto L_0x0020;
    L_0x012d:
        r0 = "MicroMsg.MsgRetransmitUI";
        r1 = "start complete offline video";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        r0 = r15.fileName;
        com.tencent.mm.modelvideo.t.nS(r0);
        goto L_0x0020;
    L_0x013d:
        r0 = r15.msgType;
        if (r0 != 0) goto L_0x0149;
    L_0x0141:
        r0 = r15.uDl;
        r0 = r0.size();
        r15.uDD = r0;
    L_0x0149:
        r0 = r15.uDl;
        r0 = r0.size();
        r2 = r15.uDl;
        r9 = r2.iterator();
        r2 = r0;
        r3 = r4;
    L_0x0157:
        r0 = r9.hasNext();
        if (r0 == 0) goto L_0x0269;
    L_0x015d:
        r0 = r9.next();
        r0 = (java.lang.String) r0;
        r2 = r2 + -1;
        if (r2 != 0) goto L_0x0177;
    L_0x0167:
        r5 = r4;
    L_0x0168:
        r7 = r15.msgType;
        switch(r7) {
            case 0: goto L_0x0179;
            case 1: goto L_0x016d;
            case 2: goto L_0x018e;
            case 3: goto L_0x016d;
            case 4: goto L_0x0194;
            case 5: goto L_0x01ab;
            case 6: goto L_0x01b1;
            case 7: goto L_0x01cd;
            case 8: goto L_0x01e3;
            case 9: goto L_0x0207;
            case 10: goto L_0x021a;
            case 11: goto L_0x016d;
            case 12: goto L_0x0241;
            case 13: goto L_0x0247;
            case 14: goto L_0x024d;
            case 15: goto L_0x016d;
            case 16: goto L_0x018e;
            default: goto L_0x016d;
        };
    L_0x016d:
        r0 = r3;
    L_0x016e:
        r3 = r15.uDy;
        if (r3 == 0) goto L_0x0175;
    L_0x0172:
        com.tencent.mm.ui.chatting.k.lR(r5);
    L_0x0175:
        r3 = r0;
        goto L_0x0157;
    L_0x0177:
        r5 = r6;
        goto L_0x0168;
    L_0x0179:
        r7 = com.tencent.mm.model.au.Em();
        r7.uW();
        r7 = com.tencent.mm.model.au.Em();
        r10 = new com.tencent.mm.ui.transmit.MsgRetransmitUI$1;
        r10.<init>(r0);
        r7.H(r10);
        r0 = r3;
        goto L_0x016e;
    L_0x018e:
        r3 = r15.abh(r0);
        r0 = r3;
        goto L_0x016e;
    L_0x0194:
        com.tencent.mm.model.q.GF();
        r3 = new com.tencent.mm.modelmulti.i;
        r7 = r15.bWW;
        r10 = com.tencent.mm.model.s.hQ(r0);
        r3.<init>(r0, r7, r10);
        r0 = com.tencent.mm.model.au.DF();
        r0.a(r3, r6);
        r0 = r4;
        goto L_0x016e;
    L_0x01ab:
        r3 = r15.bB(r0, r6);
        r0 = r3;
        goto L_0x016e;
    L_0x01b1:
        r3 = r15.bWW;
        r3 = com.tencent.mm.sdk.platformtools.bi.WT(r3);
        r3 = com.tencent.mm.y.g.a.gp(r3);
        if (r3 != 0) goto L_0x01c8;
    L_0x01bd:
        r0 = "MicroMsg.MsgRetransmitUI";
        r3 = "transfer app message error: app content null";
        com.tencent.mm.sdk.platformtools.x.e(r0, r3);
        r0 = r6;
        goto L_0x016e;
    L_0x01c8:
        r15.a(r0, r3, r1, r1);
        r0 = r4;
        goto L_0x016e;
    L_0x01cd:
        r3 = r15.fileName;
        r7 = r15.length;
        r0 = com.tencent.mm.modelvoice.q.e(r0, r3, r7);
        r3 = new com.tencent.mm.modelvoice.f;
        r3.<init>(r0, r4);
        r0 = com.tencent.mm.model.au.DF();
        r0.a(r3, r6);
        r0 = r4;
        goto L_0x016e;
    L_0x01e3:
        r7 = r15.bWW;
        r7 = com.tencent.mm.storage.bd.a.YV(r7);
        r10 = new com.tencent.mm.modelmulti.i;
        r11 = r15.bWW;
        r7 = r7.otZ;
        r7 = com.tencent.mm.storage.ab.XR(r7);
        if (r7 == 0) goto L_0x0204;
    L_0x01f5:
        r7 = 66;
    L_0x01f7:
        r10.<init>(r0, r11, r7);
        r0 = com.tencent.mm.model.au.DF();
        r0.a(r10, r6);
        r0 = r3;
        goto L_0x016e;
    L_0x0204:
        r7 = 42;
        goto L_0x01f7;
    L_0x0207:
        r3 = new com.tencent.mm.modelmulti.i;
        r7 = r15.bWW;
        r10 = 48;
        r3.<init>(r0, r7, r10);
        r0 = com.tencent.mm.model.au.DF();
        r0.a(r3, r6);
        r0 = r4;
        goto L_0x016e;
    L_0x021a:
        r7 = new com.tencent.mm.g.a.mw;
        r7.<init>();
        r10 = r7.bXL;
        r11 = 4;
        r10.type = r11;
        r10 = r7.bXL;
        com.tencent.mm.model.au.HU();
        r11 = com.tencent.mm.model.c.FT();
        r12 = r15.bJC;
        r11 = r11.dW(r12);
        r10.bXQ = r11;
        r10 = r7.bXL;
        r10.toUser = r0;
        r0 = com.tencent.mm.sdk.b.a.sFg;
        r0.m(r7);
        r0 = r3;
        goto L_0x016e;
    L_0x0241:
        com.tencent.mm.ui.chatting.k.k(r15, r0, r5);
        r0 = r3;
        goto L_0x016e;
    L_0x0247:
        com.tencent.mm.ui.chatting.k.j(r15, r0, r5);
        r0 = r3;
        goto L_0x016e;
    L_0x024d:
        r7 = new com.tencent.mm.g.a.pi;
        r7.<init>();
        r10 = r7.cag;
        r12 = r15.bJC;
        r10.bIZ = r12;
        r10 = r7.cag;
        r11 = r15.bWW;
        r10.bRw = r11;
        r10 = r7.cag;
        r10.bRx = r0;
        r0 = com.tencent.mm.sdk.b.a.sFg;
        r0.m(r7);
        goto L_0x016d;
    L_0x0269:
        r0 = r15.uDl;
        r0 = r0.get(r6);
        r0 = (java.lang.String) r0;
        r1 = r15.msgType;
        switch(r1) {
            case 0: goto L_0x027b;
            case 1: goto L_0x0020;
            case 2: goto L_0x027b;
            case 3: goto L_0x0276;
            case 4: goto L_0x027b;
            case 5: goto L_0x027b;
            case 6: goto L_0x027b;
            case 7: goto L_0x027b;
            case 8: goto L_0x027b;
            case 9: goto L_0x027b;
            case 10: goto L_0x027b;
            case 11: goto L_0x0020;
            case 12: goto L_0x027b;
            case 13: goto L_0x027b;
            case 14: goto L_0x027b;
            case 15: goto L_0x0276;
            case 16: goto L_0x027b;
            default: goto L_0x0276;
        };
    L_0x0276:
        r15.finish();
        goto L_0x0020;
    L_0x027b:
        r1 = r15.msgType;
        if (r1 == r8) goto L_0x0285;
    L_0x027f:
        r1 = r15.msgType;
        r2 = 16;
        if (r1 != r2) goto L_0x030d;
    L_0x0285:
        r1 = r15.bWW;
        r1 = com.tencent.mm.sdk.platformtools.bi.WT(r1);
        r5 = com.tencent.mm.y.g.a.gp(r1);
        if (r5 == 0) goto L_0x0375;
    L_0x0291:
        r1 = r5.type;
        r2 = 5;
        if (r1 != r2) goto L_0x0375;
    L_0x0296:
        r1 = r5.url;
        r1 = com.tencent.mm.sdk.platformtools.bi.oW(r1);
        if (r1 != 0) goto L_0x0375;
    L_0x029e:
        r2 = "";
        r1 = r5.url;	 Catch:{ UnsupportedEncodingException -> 0x0364 }
        r7 = "UTF-8";
        r1 = java.net.URLEncoder.encode(r1, r7);	 Catch:{ UnsupportedEncodingException -> 0x0364 }
        r2 = r1;
    L_0x02ab:
        if (r3 == 0) goto L_0x0372;
    L_0x02ad:
        r1 = r4;
    L_0x02ae:
        r7 = "MicroMsg.MsgRetransmitUI";
        r9 = "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d";
        r10 = 6;
        r10 = new java.lang.Object[r10];
        r11 = 13378; // 0x3442 float:1.8747E-41 double:6.6096E-320;
        r11 = java.lang.Integer.valueOf(r11);
        r10[r6] = r11;
        r5 = r5.url;
        r10[r4] = r5;
        r12 = r15.startTime;
        r5 = java.lang.Long.valueOf(r12);
        r10[r8] = r5;
        r5 = r15.uDE;
        r5 = java.lang.Integer.valueOf(r5);
        r10[r14] = r5;
        r5 = 4;
        r11 = java.lang.Integer.valueOf(r4);
        r10[r5] = r11;
        r5 = 5;
        r11 = java.lang.Integer.valueOf(r1);
        r10[r5] = r11;
        com.tencent.mm.sdk.platformtools.x.d(r7, r9, r10);
        r5 = com.tencent.mm.plugin.report.service.h.mEJ;
        r7 = 13378; // 0x3442 float:1.8747E-41 double:6.6096E-320;
        r9 = 5;
        r9 = new java.lang.Object[r9];
        r9[r6] = r2;
        r10 = r15.startTime;
        r2 = java.lang.Long.valueOf(r10);
        r9[r4] = r2;
        r2 = r15.uDE;
        r2 = java.lang.Integer.valueOf(r2);
        r9[r8] = r2;
        r2 = java.lang.Integer.valueOf(r4);
        r9[r14] = r2;
        r2 = 4;
        r1 = java.lang.Integer.valueOf(r1);
        r9[r2] = r1;
        r5.h(r7, r9);
    L_0x030d:
        if (r3 == 0) goto L_0x0401;
    L_0x030f:
        r1 = r15.uDo;
        if (r1 == 0) goto L_0x031c;
    L_0x0313:
        r1 = com.tencent.mm.R.l.has_send;
        r1 = r15.getString(r1);
        com.tencent.mm.ui.widget.snackbar.b.h(r15, r1);
    L_0x031c:
        r1 = new android.content.Intent;
        r1.<init>();
        r2 = new java.util.ArrayList;
        r2.<init>();
        r3 = r15.uDl;
        r2.addAll(r3);
        r3 = "SendMsgUsernames";
        r1.putStringArrayListExtra(r3, r2);
        r2 = -1;
        r15.setResult(r2, r1);
        r1 = r15.uDJ;
        if (r1 == 0) goto L_0x0345;
    L_0x0339:
        r1 = r15.mHandler;
        r2 = new com.tencent.mm.ui.transmit.MsgRetransmitUI$5;
        r2.<init>(r15);
        r4 = 1800; // 0x708 float:2.522E-42 double:8.893E-321;
        r1.postDelayed(r2, r4);
    L_0x0345:
        r1 = r15.uDn;
        if (r1 == 0) goto L_0x0020;
    L_0x0349:
        r1 = r15.uDB;
        if (r1 != 0) goto L_0x0020;
    L_0x034d:
        r1 = new android.content.Intent;
        r2 = com.tencent.mm.ui.chatting.ChattingUI.class;
        r1.<init>(r15, r2);
        r2 = 67108864; // 0x4000000 float:1.5046328E-36 double:3.31561842E-316;
        r1.addFlags(r2);
        r2 = "Chat_User";
        r1.putExtra(r2, r0);
        r15.startActivity(r1);
        goto L_0x0020;
    L_0x0364:
        r1 = move-exception;
        r7 = "MicroMsg.MsgRetransmitUI";
        r9 = "";
        r10 = new java.lang.Object[r6];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r7, r1, r9, r10);
        goto L_0x02ab;
    L_0x0372:
        r1 = r8;
        goto L_0x02ae;
    L_0x0375:
        if (r3 != 0) goto L_0x030d;
    L_0x0377:
        if (r5 == 0) goto L_0x030d;
    L_0x0379:
        r1 = r5.type;
        r2 = 33;
        if (r1 != r2) goto L_0x030d;
    L_0x037f:
        r1 = new com.tencent.mm.g.a.n;
        r1.<init>();
        r2 = r1.bGE;
        r6 = r15.uDH;
        r2.scene = r6;
        r2 = r1.bGE;
        r6 = r15.uDI;
        r2.bGM = r6;
        r2 = r15.uDH;
        if (r8 != r2) goto L_0x03f5;
    L_0x0394:
        r2 = r1.bGE;
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = r15.uDG;
        r6 = r6.append(r7);
        r7 = ":";
        r6 = r6.append(r7);
        r7 = r15.uDF;
        r6 = r6.append(r7);
        r6 = r6.toString();
        r2.bGG = r6;
    L_0x03b4:
        r2 = "@chatroom";
        r2 = r0.endsWith(r2);
        if (r2 == 0) goto L_0x03fc;
    L_0x03bd:
        r2 = r1.bGE;
        r2.action = r8;
    L_0x03c1:
        r2 = r1.bGE;
        r4 = r5.dyZ;
        r4 = r4 + 1;
        r2.bGF = r4;
        r2 = r1.bGE;
        r4 = r5.dyR;
        r2.bGH = r4;
        r2 = r1.bGE;
        r4 = r5.dyS;
        r2.bGy = r4;
        r2 = r1.bGE;
        r4 = r5.dyT;
        r2.appId = r4;
        r2 = r1.bGE;
        r4 = "";
        r2.bGI = r4;
        r2 = r1.bGE;
        r4 = com.tencent.mm.sdk.platformtools.bi.VE();
        r2.bGJ = r4;
        r2 = r1.bGE;
        r2.bGK = r8;
        r2 = com.tencent.mm.sdk.b.a.sFg;
        r2.m(r1);
        goto L_0x030d;
    L_0x03f5:
        r2 = r1.bGE;
        r6 = r15.uDG;
        r2.bGG = r6;
        goto L_0x03b4;
    L_0x03fc:
        r2 = r1.bGE;
        r2.action = r4;
        goto L_0x03c1;
    L_0x0401:
        r15.finish();
        goto L_0x0020;
    L_0x0406:
        r0 = r15.uDl;
        r0 = r0.get(r6);
        r0 = (java.lang.String) r0;
        r1 = r15.cAc();
        if (r1 != 0) goto L_0x0419;
    L_0x0414:
        r15.finish();
        goto L_0x0020;
    L_0x0419:
        r1 = r15.msgType;
        switch(r1) {
            case 0: goto L_0x0433;
            case 1: goto L_0x049e;
            case 5: goto L_0x04c5;
            case 11: goto L_0x049e;
            default: goto L_0x041e;
        };
    L_0x041e:
        r0 = "MicroMsg.MsgRetransmitUI";
        r1 = "doRetransmitOnSceneShareFromSystemGallery unknown msg type:%d";
        r2 = new java.lang.Object[r4];
        r3 = r15.msgType;
        r3 = java.lang.Integer.valueOf(r3);
        r2[r6] = r3;
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);
        goto L_0x0020;
    L_0x0433:
        r1 = r15.uDu;
        if (r1 == 0) goto L_0x0447;
    L_0x0437:
        r1 = r15.uDu;
        r1 = r1.size();
        if (r1 <= 0) goto L_0x0447;
    L_0x043f:
        r1 = r15.uDu;
        r1 = r1.size();
        r15.uDw = r1;
    L_0x0447:
        r1 = new com.tencent.mm.ui.transmit.MsgRetransmitUI$2;
        r1.<init>(r15);
        r15.dVg = r1;
        r1 = com.tencent.mm.R.l.msgretr_uploading_img;
        r2 = new java.lang.Object[r14];
        r3 = java.lang.Integer.valueOf(r4);
        r2[r6] = r3;
        r3 = r15.uDw;
        r3 = java.lang.Integer.valueOf(r3);
        r2[r4] = r3;
        r3 = java.lang.Integer.valueOf(r6);
        r2[r8] = r3;
        r1 = r15.getString(r1, r2);
        r2 = com.tencent.mm.R.l.app_tip;
        r2 = r15.getString(r2);
        r3 = new com.tencent.mm.ui.transmit.MsgRetransmitUI$3;
        r3.<init>(r15);
        r1 = com.tencent.mm.ui.base.h.a(r15, r1, r2, r3);
        r15.uDp = r1;
        r1 = r15.uDp;
        r2 = new com.tencent.mm.ui.transmit.MsgRetransmitUI$4;
        r2.<init>(r15);
        r1.setOnCancelListener(r2);
        r1 = r15.uDp;
        r1.setCanceledOnTouchOutside(r6);
        r1 = r15.uDp;
        r2 = -1;
        r1 = r1.getButton(r2);
        r2 = com.tencent.mm.R.l.app_cancel;
        r1.setText(r2);
        r1 = 6;
        r2 = r15.dVg;
        r15.a(r0, r1, r2);
        goto L_0x0020;
    L_0x049e:
        r1 = com.tencent.mm.network.ab.bU(r15);
        if (r1 != 0) goto L_0x04bc;
    L_0x04a4:
        r1 = com.tencent.mm.R.l.video_export_file_warning;
        r2 = com.tencent.mm.R.l.app_tip;
        r3 = com.tencent.mm.R.l.app_ok;
        r4 = com.tencent.mm.R.l.app_cancel;
        r5 = new com.tencent.mm.ui.transmit.MsgRetransmitUI$13;
        r5.<init>(r15, r0);
        r6 = new com.tencent.mm.ui.transmit.MsgRetransmitUI$14;
        r6.<init>(r15);
        r0 = r15;
        com.tencent.mm.ui.base.h.a(r0, r1, r2, r3, r4, r5, r6);
        goto L_0x0020;
    L_0x04bc:
        r1 = r15.getIntent();
        r15.m(r1, r0);
        goto L_0x0020;
    L_0x04c5:
        r15.bB(r0, r4);
        goto L_0x0020;
    L_0x04ca:
        r0 = r15.msgType;
        switch(r0) {
            case 2: goto L_0x04d1;
            case 16: goto L_0x04d1;
            default: goto L_0x04cf;
        };
    L_0x04cf:
        goto L_0x0020;
    L_0x04d1:
        r0 = r15.uDl;
        r0.get(r6);
        r0 = r15.getIntent();
        r0 = r0.getExtras();
        r2 = "_mmessage_appPackage";
        r0 = r0.getString(r2);
        r5 = new com.tencent.mm.pluginsdk.model.app.f;
        r5.<init>();
        r5.field_packageName = r0;
        r0 = com.tencent.mm.pluginsdk.model.app.ao.bmf();
        r2 = new java.lang.String[r4];
        r3 = "packageName";
        r2[r6] = r3;
        r0.b(r5, r2);
        r0 = new com.tencent.mm.opensdk.modelmsg.SendMessageToWX$Req;
        r2 = r15.getIntent();
        r2 = r2.getExtras();
        r0.<init>(r2);
        r4 = r0.message;
        r0 = new com.tencent.mm.ui.transmit.MsgRetransmitUI$11;
        r0.<init>(r15);
        r7 = new com.tencent.mm.ui.transmit.c;
        r7.<init>(r0);
        r0 = r4.thumbData;
        if (r0 != 0) goto L_0x053f;
    L_0x0517:
        r2 = r1;
    L_0x0518:
        r0 = r4.mediaObject;
        r0 = r0.type();
        switch(r0) {
            case 1: goto L_0x0547;
            case 2: goto L_0x0588;
            case 3: goto L_0x05a8;
            case 4: goto L_0x05d5;
            case 5: goto L_0x0631;
            case 6: goto L_0x0603;
            case 7: goto L_0x065f;
            default: goto L_0x0521;
        };
    L_0x0521:
        r0 = "MicroMsg.SendAppMessage";
        r1 = new java.lang.StringBuilder;
        r2 = "unkown app message type, skipped, type=";
        r1.<init>(r2);
        r2 = r4.mediaObject;
        r2 = r2.type();
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        goto L_0x0020;
    L_0x053f:
        r0 = r4.thumbData;
        r0 = com.tencent.mm.sdk.platformtools.c.bs(r0);
        r2 = r0;
        goto L_0x0518;
    L_0x0547:
        r0 = com.tencent.mm.R.i.appmsg_transmit_confirm_text;
        r2 = android.view.View.inflate(r15, r0, r1);
        r0 = com.tencent.mm.R.h.title_tv;
        r0 = r2.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r3 = r4.title;
        r0.setText(r3);
    L_0x055a:
        r0 = com.tencent.mm.R.h.source_tv;
        r0 = r2.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r3 = com.tencent.mm.pluginsdk.model.app.g.b(r15, r5, r1);
        r0.setText(r3);
        r0 = com.tencent.mm.R.l.app_send;
        r3 = r15.getString(r0);
        r0 = com.tencent.mm.R.l.app_cancel;
        r4 = r15.getString(r0);
        r5 = new com.tencent.mm.ui.transmit.c$1;
        r5.<init>(r7);
        r6 = new com.tencent.mm.ui.transmit.c$2;
        r6.<init>(r7);
        r0 = r15;
        r0 = com.tencent.mm.ui.base.h.a(r0, r1, r2, r3, r4, r5, r6);
        r7.eIW = r0;
        goto L_0x0020;
    L_0x0588:
        r0 = com.tencent.mm.R.i.appmsg_transmit_confirm_image;
        r3 = android.view.View.inflate(r15, r0, r1);
        r0 = com.tencent.mm.R.h.thumb_iv;
        r0 = r3.findViewById(r0);
        r0 = (android.widget.ImageView) r0;
        r0.setImageBitmap(r2);
        r0 = com.tencent.mm.R.h.title_tv;
        r0 = r3.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r2 = r4.title;
        r0.setText(r2);
        r2 = r3;
        goto L_0x055a;
    L_0x05a8:
        r0 = com.tencent.mm.R.i.appmsg_transmit_confirm_file;
        r3 = android.view.View.inflate(r15, r0, r1);
        r0 = com.tencent.mm.R.h.thumb_iv;
        r0 = r3.findViewById(r0);
        r0 = (android.widget.ImageView) r0;
        r0.setImageBitmap(r2);
        r0 = com.tencent.mm.R.h.title_tv;
        r0 = r3.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r2 = com.tencent.mm.R.h.desc_tv;
        r2 = r3.findViewById(r2);
        r2 = (android.widget.TextView) r2;
        r6 = r4.title;
        r0.setText(r6);
        r0 = r4.description;
        r2.setText(r0);
        r2 = r3;
        goto L_0x055a;
    L_0x05d5:
        r0 = com.tencent.mm.R.i.appmsg_transmit_confirm_file;
        r3 = android.view.View.inflate(r15, r0, r1);
        r0 = com.tencent.mm.R.h.thumb_iv;
        r0 = r3.findViewById(r0);
        r0 = (android.widget.ImageView) r0;
        r0.setImageBitmap(r2);
        r0 = com.tencent.mm.R.h.title_tv;
        r0 = r3.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r2 = com.tencent.mm.R.h.desc_tv;
        r2 = r3.findViewById(r2);
        r2 = (android.widget.TextView) r2;
        r6 = r4.title;
        r0.setText(r6);
        r0 = r4.description;
        r2.setText(r0);
        r2 = r3;
        goto L_0x055a;
    L_0x0603:
        r0 = com.tencent.mm.R.i.appmsg_transmit_confirm_file;
        r3 = android.view.View.inflate(r15, r0, r1);
        r0 = com.tencent.mm.R.h.thumb_iv;
        r0 = r3.findViewById(r0);
        r0 = (android.widget.ImageView) r0;
        r0.setImageBitmap(r2);
        r0 = com.tencent.mm.R.h.title_tv;
        r0 = r3.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r2 = com.tencent.mm.R.h.desc_tv;
        r2 = r3.findViewById(r2);
        r2 = (android.widget.TextView) r2;
        r6 = r4.title;
        r0.setText(r6);
        r0 = r4.description;
        r2.setText(r0);
        r2 = r3;
        goto L_0x055a;
    L_0x0631:
        r0 = com.tencent.mm.R.i.appmsg_transmit_confirm_file;
        r3 = android.view.View.inflate(r15, r0, r1);
        r0 = com.tencent.mm.R.h.thumb_iv;
        r0 = r3.findViewById(r0);
        r0 = (android.widget.ImageView) r0;
        r0.setImageBitmap(r2);
        r0 = com.tencent.mm.R.h.title_tv;
        r0 = r3.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r2 = com.tencent.mm.R.h.desc_tv;
        r2 = r3.findViewById(r2);
        r2 = (android.widget.TextView) r2;
        r6 = r4.title;
        r0.setText(r6);
        r0 = r4.description;
        r2.setText(r0);
        r2 = r3;
        goto L_0x055a;
    L_0x065f:
        r0 = com.tencent.mm.R.i.appmsg_transmit_confirm_file;
        r3 = android.view.View.inflate(r15, r0, r1);
        r0 = com.tencent.mm.R.h.thumb_iv;
        r0 = r3.findViewById(r0);
        r0 = (android.widget.ImageView) r0;
        r0.setImageBitmap(r2);
        r0 = com.tencent.mm.R.h.title_tv;
        r0 = r3.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r2 = com.tencent.mm.R.h.desc_tv;
        r2 = r3.findViewById(r2);
        r2 = (android.widget.TextView) r2;
        r6 = r4.title;
        r0.setText(r6);
        r0 = r4.description;
        r2.setText(r0);
        r2 = r3;
        goto L_0x055a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.transmit.MsgRetransmitUI.cAb():void");
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        String str;
        if (i2 != -1) {
            a gp = a.gp(bi.WT(this.bWW));
            if (gp != null && gp.type == 5 && gp.url != null) {
                x.d("MicroMsg.MsgRetransmitUI", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[]{Integer.valueOf(13378), gp.url, Long.valueOf(this.startTime), Integer.valueOf(this.uDE), Integer.valueOf(1), Integer.valueOf(3)});
                str = "";
                try {
                    str = URLEncoder.encode(gp.url, "UTF-8");
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.MsgRetransmitUI", e, "", new Object[0]);
                }
                h.mEJ.h(13378, new Object[]{str, Long.valueOf(this.startTime), Integer.valueOf(this.uDE), Integer.valueOf(1), Integer.valueOf(3)});
            } else if (gp != null && gp.type == 33) {
                n nVar = new n();
                nVar.bGE.bGM = this.uDI;
                nVar.bGE.scene = this.uDH;
                if (2 == this.uDH) {
                    nVar.bGE.bGG = this.uDG + ":" + this.uDF;
                } else {
                    nVar.bGE.bGG = this.uDG;
                }
                nVar.bGE.bGF = gp.dyZ + 1;
                nVar.bGE.bGH = gp.dyR;
                nVar.bGE.bGy = gp.dyS;
                nVar.bGE.appId = gp.dyT;
                nVar.bGE.action = 1;
                nVar.bGE.bGI = "";
                nVar.bGE.bGJ = bi.VE();
                nVar.bGE.bGK = 3;
                com.tencent.mm.sdk.b.a.sFg.m(nVar);
            }
            finish();
        } else if (i != 0) {
            x.e("MicroMsg.MsgRetransmitUI", "onActivityResult, unknown requestCode = " + i);
        } else {
            this.uDl = bi.F(intent.getStringExtra("Select_Conv_User").split(","));
            Object stringExtra = intent.getStringExtra("custom_send_text");
            this.qIZ = intent.getBooleanExtra("key_is_biz_chat", false);
            if (this.qIZ) {
                this.hpD = intent.getLongExtra("key_biz_chat_id", -1);
            }
            int intExtra = intent.getIntExtra("Retr_Msg_Type", -1);
            if (intExtra != -1) {
                x.i("MicroMsg.MsgRetransmitUI", "summerbig replace msgType %d->%d", new Object[]{Integer.valueOf(this.msgType), Integer.valueOf(intExtra)});
                this.msgType = intExtra;
            }
            x.i("MicroMsg.MsgRetransmitUI", "summersafecdn onActivityResult doRetransmit msgType[%d], iScene[%d], size[%d]", new Object[]{Integer.valueOf(this.msgType), Integer.valueOf(this.uDr), Integer.valueOf(this.uDl.size())});
            cAb();
            if (!TextUtils.isEmpty(stringExtra)) {
                for (String str2 : this.uDl) {
                    ow owVar = new ow();
                    owVar.bZQ.bZR = str2;
                    owVar.bZQ.content = stringExtra;
                    owVar.bZQ.type = s.hQ(str2);
                    owVar.bZQ.flags = 0;
                    com.tencent.mm.sdk.b.a.sFg.m(owVar);
                }
            }
        }
    }

    private boolean abh(String str) {
        byte[] bArr = null;
        a gp = a.gp(bi.WT(this.bWW));
        x.d("MicroMsg.MsgRetransmitUI", "summerbig processAppMessageTransfer msgContent[%s], content[%s]", new Object[]{this.bWW, gp});
        if (gp == null) {
            x.e("MicroMsg.MsgRetransmitUI", "transfer app message error: app content null");
            return false;
        }
        au.HU();
        bd dW = com.tencent.mm.model.c.FT().dW(this.bJC);
        if (!dW.cky()) {
            if (this.uDm != null) {
                try {
                    bArr = FileOp.e(this.uDm, 0, -1);
                    if (!bG(bArr)) {
                        return false;
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.MsgRetransmitUI", e, "", new Object[0]);
                    x.e("MicroMsg.MsgRetransmitUI", "send appmsg to %s, error:%s", new Object[]{str, e.getLocalizedMessage()});
                }
            } else if (!(this.ubT >= 0 || dW.field_imgPath == null || dW.field_imgPath.equals(""))) {
                try {
                    bArr = FileOp.e(o.Pf().E(dW.field_imgPath, true), 0, -1);
                    if (!bG(bArr)) {
                        return false;
                    }
                } catch (Exception e2) {
                    x.e("MicroMsg.MsgRetransmitUI", "send appmsg to %s, error:%s", new Object[]{str, e2.getLocalizedMessage()});
                }
            }
            au.Em().H(new 12(this, str, gp, bArr, dW));
        } else if (gp.type == 33) {
            com.tencent.mm.ui.chatting.l.b(str, gp, ca.f(((HashMap) getIntent().getSerializableExtra("appbrand_params")).get("img_url"), null));
        } else {
            j.a(this, str, this.bWW, dW.field_isSend, this.tFy);
        }
        return true;
    }

    private void a(String str, a aVar, byte[] bArr, bd bdVar) {
        x.d("MicroMsg.MsgRetransmitUI", "summerbig send toUser[%s], attachid[%s]", new Object[]{str, aVar.bGP});
        b d = com.tencent.mm.pluginsdk.model.app.l.d(bdVar, aVar.bGP);
        String str2 = "";
        if (!(d == null || d.field_fileFullPath == null || d.field_fileFullPath.equals(""))) {
            au.HU();
            str2 = com.tencent.mm.pluginsdk.model.app.l.al(com.tencent.mm.model.c.Gk(), aVar.title, aVar.dwp);
            FileOp.y(d.field_fileFullPath, str2);
            x.i("MicroMsg.MsgRetransmitUI", "summerbig send old path[%s], title[%s] attachPath[%s]， finish[%b]", new Object[]{d.field_fileFullPath, aVar.title, str2, Boolean.valueOf(d.aSc())});
        }
        a a = a.a(aVar);
        a.dwr = 3;
        if (bdVar != null && aVar.type == 6 && !bi.oW(aVar.dwu) && d != null && (!com.tencent.mm.a.e.cn(d.field_fileFullPath) || ((long) com.tencent.mm.a.e.cm(d.field_fileFullPath)) != d.field_totalLen)) {
            i iVar = new i();
            iVar.dPV = new 17(this, d, bdVar, a, str, str2, bArr);
            iVar.field_mediaId = com.tencent.mm.modelcdntran.d.a("checkExist", bi.VF(), bdVar.field_talker, bdVar.field_msgId);
            iVar.field_aesKey = a.dwK;
            iVar.field_fileType = 19;
            iVar.field_authKey = a.dwA;
            iVar.dPW = a.dwu;
            iVar.field_fullpath = str2;
            if (!g.ND().b(iVar, -1)) {
                x.e("MicroMsg.MsgRetransmitUI", "openim attach download failed before rescend");
            }
        } else if (!bi.oW(str2) || (aVar.dws == 0 && aVar.dwo <= 26214400)) {
            com.tencent.mm.pluginsdk.model.app.l.a(a, aVar.appId, aVar.appName, str, str2, bArr, this.fmS);
            if (a.type == 36) {
                int i = str.endsWith("chatroom") ? 1 : 0;
                String encode = URLEncoder.encode(bi.oV(a.url));
                String encode2 = URLEncoder.encode(bi.oV(a.title));
                String encode3 = URLEncoder.encode(bi.oV(a.description));
                String encode4 = URLEncoder.encode(bi.oV(a.dyR));
                h.mEJ.h(14127, new Object[]{a.appId, a.dyS, encode4, encode2, encode3, "", encode, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(i), str});
            }
        } else {
            x.i("MicroMsg.MsgRetransmitUI", "summerbig send attachPath is null islargefilemsg[%d], attachlen[%d]", new Object[]{Integer.valueOf(aVar.dws), Integer.valueOf(aVar.dwo)});
            au.DF().a(new aa(aVar, null, str, new 16(this, aVar, a, str, bArr)), 0);
        }
    }

    private boolean bB(String str, boolean z) {
        if (this.fileName == null) {
            return false;
        }
        EmojiInfo zi = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().zi(this.fileName);
        int cm = zi == null ? com.tencent.mm.a.e.cm(this.fileName) : com.tencent.mm.a.e.cm(zi.cnF());
        String cnF = zi == null ? this.fileName : zi.cnF();
        Options options = new Options();
        options.inJustDecodeBounds = true;
        boolean z2;
        if ((com.tencent.mm.sdk.platformtools.c.decodeFile(cnF, options) == null || options.outHeight <= com.tencent.mm.k.b.Az()) && options.outWidth <= com.tencent.mm.k.b.Az()) {
            z2 = false;
        } else {
            z2 = true;
        }
        Object[] objArr;
        if (cm > com.tencent.mm.k.b.AA() || z2) {
            String str2 = "MicroMsg.MsgRetransmitUI";
            String str3 = "emoji is over size. md5:%s size:%d";
            objArr = new Object[2];
            objArr[0] = zi == null ? "fileName" : zi.Xh();
            objArr[1] = Integer.valueOf(this.length);
            x.i(str2, str3, objArr);
            this.uDJ = false;
            this.uDo = false;
            com.tencent.mm.ui.base.h.a(this, getString(R.l.emoji_custom_gif_max_size_limit_cannot_send), "", getString(R.l.i_know_it), new 18(this));
            if (this.uDz != 1) {
                return true;
            }
            h.mEJ.h(13459, new Object[]{Integer.valueOf(cm), Integer.valueOf(1), zi.Xh(), Integer.valueOf(1)});
            return true;
        }
        if (this.uDz == 1) {
            h hVar = h.mEJ;
            objArr = new Object[4];
            objArr[0] = Integer.valueOf(cm);
            objArr[1] = Integer.valueOf(0);
            objArr[2] = zi == null ? "" : zi.Xh();
            objArr[3] = Integer.valueOf(1);
            hVar.h(13459, objArr);
        }
        if (z) {
            EmojiInfo zi2;
            if (zi == null) {
                zi2 = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().zi(((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().a(getApplicationContext(), new WXMediaMessage(new WXEmojiObject(this.fileName)), ""));
            } else {
                zi2 = zi;
            }
            h.mEJ.h(13459, new Object[]{Integer.valueOf(cm), Integer.valueOf(0), zi2.Xh(), Integer.valueOf(2)});
            j.b(zi2, str);
            finish();
            return true;
        } else if (zi != null && cm > com.tencent.mm.k.b.Ay()) {
            j.b(zi, str);
            return true;
        } else if (((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().o(this, str, this.fileName)) {
            return true;
        } else {
            x.e("MicroMsg.MsgRetransmitUI", "Retransmit emoji failed.");
            return false;
        }
    }

    private boolean cAc() {
        au.HU();
        if (com.tencent.mm.model.c.isSDCardAvailable()) {
            return true;
        }
        x.e("MicroMsg.MsgRetransmitUI", "sdcard is not available, type = " + this.msgType);
        com.tencent.mm.ui.base.s.gH(this);
        return false;
    }

    private void m(Intent intent, String str) {
        if (this.uDx) {
            this.uDw = this.uDu.size();
            ArrayList parcelableArrayList = intent.getExtras().getParcelableArrayList("android.intent.extra.STREAM");
            if (parcelableArrayList == null || parcelableArrayList.size() <= 0) {
                finish();
                return;
            }
            Iterator it = parcelableArrayList.iterator();
            while (it.hasNext()) {
                it.next();
                if (!this.uDK) {
                    abi(str);
                } else {
                    return;
                }
            }
            return;
        }
        this.uDw = 1;
        abi(str);
    }

    private void abi(String str) {
        x.i("MicroMsg.MsgRetransmitUI", "sendMultiVedeo");
        com.tencent.mm.pluginsdk.model.j jVar = new com.tencent.mm.pluginsdk.model.j(this, null, getIntent(), str, 1, new 6(this));
        com.tencent.mm.sdk.f.e.post(jVar, "ChattingUI_importMultiVideo");
        getString(R.l.app_tip);
        this.eHw = com.tencent.mm.ui.base.h.a(this, getString(R.l.app_waiting), true, new 7(this, jVar));
    }

    private void a(String str, int i, f fVar) {
        String str2;
        String GF = q.GF();
        String str3 = "";
        au.HU();
        bd dW = com.tencent.mm.model.c.FT().dW(this.bJC);
        if (dW.field_msgId == this.bJC) {
            str3 = dW.field_content;
        }
        com.tencent.mm.ak.e eVar = null;
        if (dW.field_msgId > 0) {
            eVar = o.Pf().br(dW.field_msgId);
        }
        if ((eVar == null || eVar.dTK <= 0) && dW.field_msgSvrId > 0) {
            eVar = o.Pf().bq(dW.field_msgSvrId);
        }
        if (str3 != null || dW.field_msgSvrId <= 0) {
            str2 = str3;
        } else {
            str2 = eVar.dTV;
        }
        if (eVar == null || ((eVar.offset >= eVar.dHI && eVar.dHI != 0) || this.uDx)) {
            a(str, i, GF, str2, fVar);
            return;
        }
        int i2;
        com.tencent.mm.ak.e bq = o.Pf().bq(dW.field_msgSvrId);
        if (dW.field_isSend == 1) {
            int i3;
            if (bq.ON()) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            i2 = i3;
        } else if (bq.ON()) {
            if (com.tencent.mm.a.e.cn(o.Pf().o(com.tencent.mm.ak.f.a(bq).dTL, "", ""))) {
                i2 = 1;
            } else {
                i2 = 0;
            }
        } else {
            i2 = 0;
        }
        PString pString = new PString();
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        pString.value = this.fileName;
        long a = o.Pf().a(this.fileName, i2, i, 0, pString, pInt, pInt2);
        eVar = o.Pf().b(Long.valueOf(a));
        eVar.hO(1);
        bd bdVar = new bd();
        bdVar.setType(s.hR(str));
        bdVar.ep(str);
        bdVar.eX(1);
        bdVar.setStatus(1);
        bdVar.eq(pString.value);
        bdVar.fh(pInt.value);
        bdVar.fi(pInt2.value);
        bdVar.ay(com.tencent.mm.model.bd.iD(bdVar.field_talker));
        if (com.tencent.mm.ac.f.eZ(bdVar.field_talker)) {
            dW.dt(com.tencent.mm.ac.a.e.Ir());
        }
        au.HU();
        long T = com.tencent.mm.model.c.FT().T(bdVar);
        Assert.assertTrue(T >= 0);
        x.i("MicroMsg.MsgRetransmitUI", "NetSceneUploadMsgImg: local msgId = " + T);
        eVar.bo((long) ((int) T));
        o.Pf().a(Long.valueOf(a), eVar);
        HashMap hashMap = new HashMap();
        hashMap.put(Long.valueOf(T), bq);
        o.Pg().a(bq.dTK, dW.field_msgId, i2, hashMap, R.g.chat_img_template, new 8(this, str, i, GF, str2, fVar));
    }

    private void a(String str, int i, String str2, String str3, f fVar) {
        if (!bi.oW(this.fileName)) {
            this.uDv = 1;
            this.uDw = 1;
            if (abj(this.fileName)) {
                if (q.a(this.fileName, str, this.dTO == 0)) {
                    this.dTO = 1;
                } else {
                    this.dTO = 0;
                }
                long currentTimeMillis = System.currentTimeMillis();
                h.mEJ.a(106, 96, 1, false);
                this.uDs = new l(i, str2, str, this.fileName, this.dTO, fVar, 0, str3, "", true, R.g.chat_img_template, this.uDz, this.dVI, this.bSx);
                if (this.uDr == 1) {
                    this.uDs.OV();
                }
                au.DF().a(this.uDs, 0);
                this.uDt = true;
                x.d("MicroMsg.MsgRetransmitUI", "summersafecdn jacks consumption: %d, compressType:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(this.dTO)});
                br.IE().c(br.dDm, null);
            }
        } else if (this.uDx) {
            this.uDv++;
            if (abj((String) this.uDu.get(0))) {
                if (q.a((String) this.uDu.get(0), str, this.dTO == 0)) {
                    this.dTO = 1;
                } else {
                    this.dTO = 0;
                }
                x.d("MicroMsg.MsgRetransmitUI", "summersafecdn multiSendType compressType:%d", new Object[]{Integer.valueOf(this.dTO)});
                this.uDs = new l(i, str2, str, (String) this.uDu.get(0), this.dTO, fVar, 0, str3, "", true, R.g.chat_img_template);
                if (this.uDr == 1) {
                    this.uDs.OV();
                }
                this.uDt = true;
                au.DF().a(this.uDs, 0);
                br.IE().c(br.dDm, null);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean abj(java.lang.String r6) {
        /*
        r5 = 7;
        r1 = 1;
        r0 = 0;
        r2 = "MicroMsg.MsgRetransmitUI";
        r3 = "isImage called, fn:%s, scene:%d";
        r4 = 2;
        r4 = new java.lang.Object[r4];
        r4[r0] = r6;
        r5 = java.lang.Integer.valueOf(r5);
        r4[r1] = r5;
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);
        r2 = 0;
        r2 = com.tencent.mm.modelsfs.FileOp.openRead(r6);	 Catch:{ FileNotFoundException -> 0x0051, all -> 0x006a }
        r3 = new com.tencent.mm.sdk.platformtools.MMBitmapFactory$DecodeResultLogger;	 Catch:{ FileNotFoundException -> 0x007a, all -> 0x006a }
        r3.<init>();	 Catch:{ FileNotFoundException -> 0x007a, all -> 0x006a }
        r4 = com.tencent.mm.sdk.platformtools.MMBitmapFactory.checkIsImageLegal(r2, r3);	 Catch:{ FileNotFoundException -> 0x007a, all -> 0x006a }
        if (r4 != 0) goto L_0x004a;
    L_0x0027:
        r4 = r3.getDecodeResult();	 Catch:{ FileNotFoundException -> 0x007a, all -> 0x006a }
        r5 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
        if (r4 < r5) goto L_0x004a;
    L_0x002f:
        r1 = "MicroMsg.MsgRetransmitUI";
        r4 = "try to send illegal image.";
        com.tencent.mm.sdk.platformtools.x.w(r1, r4);	 Catch:{ FileNotFoundException -> 0x007a, all -> 0x006a }
        r1 = 7;
        r1 = com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper.getKVStatString(r6, r1, r3);	 Catch:{ FileNotFoundException -> 0x007a, all -> 0x006a }
        r3 = com.tencent.mm.plugin.report.service.h.mEJ;	 Catch:{ FileNotFoundException -> 0x007a, all -> 0x006a }
        r4 = 12712; // 0x31a8 float:1.7813E-41 double:6.2806E-320;
        r3.k(r4, r1);	 Catch:{ FileNotFoundException -> 0x007a, all -> 0x006a }
        if (r2 == 0) goto L_0x0049;
    L_0x0046:
        r2.close();	 Catch:{ Exception -> 0x0071 }
    L_0x0049:
        return r0;
    L_0x004a:
        if (r2 == 0) goto L_0x004f;
    L_0x004c:
        r2.close();	 Catch:{ Exception -> 0x0073 }
    L_0x004f:
        r0 = r1;
        goto L_0x0049;
    L_0x0051:
        r1 = move-exception;
        r1 = r2;
    L_0x0053:
        r2 = "MicroMsg.MsgRetransmitUI";
        r3 = "fn:%s not found.";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0077 }
        r5 = 0;
        r4[r5] = r6;	 Catch:{ all -> 0x0077 }
        com.tencent.mm.sdk.platformtools.x.w(r2, r3, r4);	 Catch:{ all -> 0x0077 }
        if (r1 == 0) goto L_0x0049;
    L_0x0064:
        r1.close();	 Catch:{ Exception -> 0x0068 }
        goto L_0x0049;
    L_0x0068:
        r1 = move-exception;
        goto L_0x0049;
    L_0x006a:
        r0 = move-exception;
    L_0x006b:
        if (r2 == 0) goto L_0x0070;
    L_0x006d:
        r2.close();	 Catch:{ Exception -> 0x0075 }
    L_0x0070:
        throw r0;
    L_0x0071:
        r1 = move-exception;
        goto L_0x0049;
    L_0x0073:
        r0 = move-exception;
        goto L_0x004f;
    L_0x0075:
        r1 = move-exception;
        goto L_0x0070;
    L_0x0077:
        r0 = move-exception;
        r2 = r1;
        goto L_0x006b;
    L_0x007a:
        r1 = move-exception;
        r1 = r2;
        goto L_0x0053;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.transmit.MsgRetransmitUI.abj(java.lang.String):boolean");
    }

    private static boolean bG(byte[] bArr) {
        x.i("MicroMsg.MsgRetransmitUI", "isImage called, data[0-4]:[%d,%d,%d,%d,%d], scene:%d", new Object[]{Byte.valueOf(bArr[0]), Byte.valueOf(bArr[1]), Byte.valueOf(bArr[2]), Byte.valueOf(bArr[3]), Byte.valueOf(bArr[4]), Integer.valueOf(6)});
        DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
        if (MMBitmapFactory.checkIsImageLegal(bArr, decodeResultLogger) || decodeResultLogger.getDecodeResult() < 2000) {
            return true;
        }
        x.w("MicroMsg.MsgRetransmitUI", "try to send illegal image.");
        h.mEJ.k(12712, KVStatHelper.getKVStatString(bArr, 6, decodeResultLogger));
        return false;
    }

    private void ec(List<String> list) {
        b bVar = new b((byte) 0);
        bVar.uEd = new LinkedList();
        bVar.uEd.addAll(list);
        for (String str : list) {
            a aVar = new a();
            getString(R.l.app_tip);
            this.eHw = com.tencent.mm.ui.base.h.a(this, getString(R.l.app_sending), true, new 10(this, aVar));
            aVar.context = this;
            aVar.fileName = this.fileName;
            aVar.eXG = this.eHw;
            aVar.uDq = this.uDq;
            aVar.enM = this.length;
            aVar.elY = this.msgType;
            aVar.uDX = false;
            aVar.userName = str;
            aVar.uDY = true;
            aVar.uDo = this.uDo;
            aVar.uEb = bVar;
            r nW = t.nW(this.fileName);
            if (!(nW == null || nW.enV == null)) {
                x.d("MicroMsg.MsgRetransmitUI", "msgRetrans streamvideo");
                aVar.uEa = nW.enV;
                aVar.cqb = nW.Tj();
            }
            aVar.execute(new Object[0]);
            br.IE().c(br.dDn, null);
            if (this.bJC != -1) {
                au.HU();
                bd dW = com.tencent.mm.model.c.FT().dW(this.bJC);
                boolean fq = s.fq(str);
                com.tencent.mm.ui.chatting.a.a(fq ? com.tencent.mm.ui.chatting.a.c.tFW : com.tencent.mm.ui.chatting.a.c.tFV, this.uDA ? com.tencent.mm.ui.chatting.a.d.tGa : com.tencent.mm.ui.chatting.a.d.tFZ, dW, fq ? m.gK(str) : 0);
            } else {
                return;
            }
        }
    }

    @com.tencent.mm.sdk.platformtools.f
    public final void a(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        if (lVar.getType() == i$l.AppCompatTheme_spinnerStyle && (lVar instanceof l)) {
            String stringExtra;
            l lVar2 = (l) lVar;
            if (getIntent().getBooleanExtra("Retr_FromMainTimeline", false)) {
                stringExtra = getIntent().getStringExtra("Retr_KSnsId");
                if (s.fq(lVar2.bZR)) {
                    px pxVar = new px();
                    pxVar.caD.bSZ = stringExtra;
                    com.tencent.mm.sdk.b.a.sFg.m(pxVar);
                } else {
                    py pyVar = new py();
                    pyVar.caE.bSZ = stringExtra;
                    com.tencent.mm.sdk.b.a.sFg.m(pyVar);
                }
            }
            if (this.uDu == null || this.uDu.size() <= 1) {
                if (this.uDp != null) {
                    this.uDp.dismiss();
                    this.uDp = null;
                }
                this.uDD--;
                if (this.uDD <= 0 || !this.uDC) {
                    this.uDt = false;
                    au.DF().b(i$l.AppCompatTheme_spinnerStyle, this);
                    if (this.uDr != 0) {
                        if (this.uDn && !this.uDB) {
                            Intent intent = new Intent(this, ChattingUI.class);
                            intent.addFlags(67108864);
                            intent.putExtra("Chat_User", lVar2.bZR);
                            startActivity(intent);
                        }
                        finish();
                        return;
                    }
                    return;
                }
                return;
            }
            this.uDu.remove(0);
            stringExtra = lVar2.bZR;
            if (bi.oW(stringExtra) && this.uDl != null) {
                stringExtra = (String) this.uDl.get(0);
            }
            a(stringExtra, 3, this.dVg);
        }
    }
}
