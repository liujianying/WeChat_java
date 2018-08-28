package com.tencent.mm.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.v;
import com.tencent.mm.ac.z;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.gw;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsimple.h;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.protocal.c.nm;
import com.tencent.mm.protocal.c.nn;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.tmassistantsdk.common.TMAssistantDownloadSDKErrorCode;
import java.util.ArrayList;
import java.util.LinkedList;

public class CheckCanSubscribeBizUI extends MMActivity implements e, a, b {
    private String appId;
    private String bMy;
    private boolean dDR = false;
    private String extInfo;
    private int fromScene;
    private String juZ;
    private int scene;
    private int source;
    private int tha;
    private LinkedList<bhz> thb;
    private boolean thc = false;
    private boolean thd = false;
    private boolean the = false;
    private boolean thf = false;
    private String thg;
    private int thh = 0;
    private String toUserName;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mController.hideTitleView();
        if (!au.HW() || au.Dr()) {
            MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class), getIntent());
            finish();
            return;
        }
        au.DF().a(TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_SOCKET_EXCEPTION, this);
        au.HU();
        c.FR().a(this);
        z.MY().c(this);
        if (afz()) {
            String str = this.appId;
            String str2 = this.toUserName;
            String str3 = this.extInfo;
            int i = this.tha;
            LinkedList linkedList = this.thb;
            String str4 = this.bMy;
            int i2 = this.source;
            int i3 = this.scene;
            com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
            aVar.dIG = new nm();
            aVar.dIH = new nn();
            aVar.uri = "/cgi-bin/micromsg-bin/checkcansubscribebiz";
            aVar.dIF = TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_SOCKET_EXCEPTION;
            com.tencent.mm.ab.b KT = aVar.KT();
            nm nmVar = (nm) KT.dID.dIL;
            nmVar.jPc = str;
            nmVar.jTu = str2;
            nmVar.jTB = str3;
            nmVar.rrx = i;
            nmVar.rry = linkedList;
            nmVar.rrz = null;
            nmVar.rrA = str4;
            nmVar.rdq = i2;
            nmVar.otY = i3;
            x.i("MicroMsg.CheckCanSubscribeBizUI", "appId(%s) , toUsername(%s) , extInfo(%s) , packNum(%d), scene(%d)", new Object[]{str, str2, str3, Integer.valueOf(i), Integer.valueOf(i3)});
            v.a(KT, new 2(this));
            return;
        }
        setResult(2);
        coQ();
        finish();
    }

    public void onStart() {
        super.onStart();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.thb != null) {
            this.thb.clear();
        }
        if (au.HX()) {
            au.DF().b(TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_SOCKET_EXCEPTION, this);
            z.MY().d(this);
            au.HU();
            c.FR().b(this);
        }
    }

    protected void onPause() {
        super.onPause();
    }

    protected final int getLayoutId() {
        return R.i.jump_to_biz_profile_loading;
    }

    private boolean afz() {
        Intent intent = getIntent();
        if (intent == null) {
            x.e("MicroMsg.CheckCanSubscribeBizUI", "intent is null.");
            return false;
        }
        this.appId = intent.getStringExtra("appId");
        this.toUserName = intent.getStringExtra("toUserName");
        if (bi.oW(this.toUserName)) {
            x.e("MicroMsg.CheckCanSubscribeBizUI", "toUserName is null.");
            return false;
        }
        this.extInfo = intent.getStringExtra("extInfo");
        this.source = intent.getIntExtra("source", -1);
        this.scene = intent.getIntExtra("scene", 0);
        this.thh = intent.getIntExtra("jump_profile_type", 0);
        switch (this.source) {
            case 1:
                if (!bi.oW(this.appId)) {
                    this.fromScene = 68;
                    ArrayList stringArrayListExtra = intent.getStringArrayListExtra("androidPackNameList");
                    if (stringArrayListExtra != null && stringArrayListExtra.size() != 0) {
                        this.thb = new LinkedList();
                        for (int i = 0; i < stringArrayListExtra.size(); i++) {
                            String str = (String) stringArrayListExtra.get(i);
                            if (!bi.oW(str)) {
                                x.i("MicroMsg.CheckCanSubscribeBizUI", "packName(%d) : %s", new Object[]{Integer.valueOf(i), str});
                                this.thb.add(ab.oT(str));
                            }
                        }
                        if (this.thb.size() != 0) {
                            this.tha = this.thb.size();
                            break;
                        }
                        x.e("MicroMsg.CheckCanSubscribeBizUI", "androidPackNameList is nil.");
                        return false;
                    }
                    x.e("MicroMsg.CheckCanSubscribeBizUI", "androidPackNameList is null or nil.");
                    return false;
                }
                x.e("MicroMsg.CheckCanSubscribeBizUI", "appId is null.");
                return false;
                break;
            case 2:
                this.fromScene = 69;
                break;
            default:
                x.e("MicroMsg.CheckCanSubscribeBizUI", "source(%d) is invalidated.", new Object[]{Integer.valueOf(this.source)});
                return false;
        }
        this.bMy = intent.getStringExtra("fromURL");
        return true;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.d("MicroMsg.CheckCanSubscribeBizUI", "onSceneEnd, errType = " + i + ", errCode = " + i2);
        if (lVar.getType() == TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_SOCKET_EXCEPTION) {
            return;
        }
        if (lVar.getType() == 233) {
            au.DF().b(233, this);
            if (i == 0 && i2 == 0) {
                h hVar = (h) lVar;
                int QN = hVar.QN();
                x.i("MicroMsg.CheckCanSubscribeBizUI", "geta8key, action code = %d", new Object[]{Integer.valueOf(QN)});
                if (QN == 15) {
                    x.d("MicroMsg.CheckCanSubscribeBizUI", "actionCode = %s, url = %s", new Object[]{Integer.valueOf(QN), hVar.QL()});
                    gw gwVar = new gw();
                    gwVar.bQd.actionCode = QN;
                    gwVar.bQd.result = r1;
                    gwVar.bQd.context = this;
                    com.tencent.mm.sdk.b.a.sFg.a(gwVar, Looper.myLooper());
                    finish();
                    return;
                }
                coP();
                return;
            }
            coP();
            return;
        }
        x.e("MicroMsg.CheckCanSubscribeBizUI", "un support scene type : %d", new Object[]{Integer.valueOf(lVar.getType())});
    }

    private synchronized void coN() {
        x.i("MicroMsg.CheckCanSubscribeBizUI", "dealSuccess..,canJump = " + this.thc);
        Intent intent;
        if (this.scene == 1) {
            intent = new Intent();
            intent.putExtra("rawUrl", this.thg);
            d.b(this, "webview", ".ui.tools.WebViewUI", intent);
            finish();
        } else if (this.scene == 0 && this.thh == 1) {
            if (this.the) {
                x.i("MicroMsg.CheckCanSubscribeBizUI", "has jump ignore this scene");
            } else {
                this.the = true;
                au.DF().a(233, this);
                au.DF().a(new h(this.extInfo, null, 4, (int) System.currentTimeMillis(), new byte[0]), 0);
            }
        } else if (coO() && this.thc) {
            if (!this.the) {
                x.i("MicroMsg.CheckCanSubscribeBizUI", "jump to ChattingUI");
                intent = new Intent().putExtra("Chat_User", this.toUserName);
                intent.putExtra("finish_direct", true);
                if (bi.oW(this.toUserName)) {
                    com.tencent.mm.ui.contact.e.a(intent, this.toUserName);
                }
                intent.setClass(this, ChattingUI.class);
                if (!this.thd) {
                    setResult(-1);
                    this.the = true;
                    startActivity(intent);
                    finish();
                }
            }
        } else if (this.thc && !this.the) {
            x.i("MicroMsg.CheckCanSubscribeBizUI", "jump to ContactInfoUI");
            au.HU();
            com.tencent.mm.storage.ab Yg = c.FR().Yg(this.toUserName);
            Intent intent2 = new Intent();
            intent2.putExtra("Contact_Scene", this.fromScene);
            intent2.putExtra("Verify_ticket", this.juZ);
            if (Yg != null) {
                intent2.putExtra("Contact_Alias", Yg.wM());
                intent2.putExtra("Contact_Nick", Yg.field_nickname);
                intent2.putExtra("Contact_Signature", Yg.signature);
                intent2.putExtra("Contact_RegionCode", Yg.csQ);
                intent2.putExtra("Contact_Sex", Yg.sex);
                intent2.putExtra("Contact_VUser_Info", Yg.csP);
                intent2.putExtra("Contact_VUser_Info_Flag", Yg.field_verifyFlag);
                intent2.putExtra("Contact_KWeibo_flag", Yg.field_weiboFlag);
                intent2.putExtra("Contact_KWeibo", Yg.csO);
                intent2.putExtra("Contact_KWeiboNick", Yg.field_weiboNickname);
            }
            com.tencent.mm.ui.contact.e.l(intent2, this.toUserName);
            if (!this.thd) {
                setResult(-1);
                this.the = true;
                d.b(this, "profile", ".ui.ContactInfoUI", intent2);
                finish();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean coO() {
        /*
        r7 = this;
        r0 = 0;
        r1 = 1;
        monitor-enter(r7);
        com.tencent.mm.model.au.HU();	 Catch:{ all -> 0x008c }
        r2 = com.tencent.mm.model.c.FR();	 Catch:{ all -> 0x008c }
        r3 = r7.toUserName;	 Catch:{ all -> 0x008c }
        r4 = r2.Yg(r3);	 Catch:{ all -> 0x008c }
        if (r4 == 0) goto L_0x0017;
    L_0x0012:
        r2 = r4.dhP;	 Catch:{ all -> 0x008c }
        r2 = (int) r2;	 Catch:{ all -> 0x008c }
        if (r2 != 0) goto L_0x00b4;
    L_0x0017:
        r2 = "MicroMsg.CheckCanSubscribeBizUI";
        r3 = "contact is null.";
        com.tencent.mm.sdk.platformtools.x.w(r2, r3);	 Catch:{ all -> 0x008c }
        r2 = r1;
    L_0x0021:
        r3 = 0;
        if (r2 != 0) goto L_0x002a;
    L_0x0024:
        r3 = r7.toUserName;	 Catch:{ all -> 0x008c }
        r3 = com.tencent.mm.ac.f.kH(r3);	 Catch:{ all -> 0x008c }
    L_0x002a:
        if (r3 == 0) goto L_0x0032;
    L_0x002c:
        r5 = r3.LS();	 Catch:{ all -> 0x008c }
        if (r5 == 0) goto L_0x0050;
    L_0x0032:
        r2 = "MicroMsg.CheckCanSubscribeBizUI";
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x008c }
        r6 = "BizInfo(";
        r5.<init>(r6);	 Catch:{ all -> 0x008c }
        r3 = r5.append(r3);	 Catch:{ all -> 0x008c }
        r5 = ") is null or should update.";
        r3 = r3.append(r5);	 Catch:{ all -> 0x008c }
        r3 = r3.toString();	 Catch:{ all -> 0x008c }
        com.tencent.mm.sdk.platformtools.x.e(r2, r3);	 Catch:{ all -> 0x008c }
        r2 = r1;
    L_0x0050:
        r3 = r7.thf;	 Catch:{ all -> 0x008c }
        if (r3 == 0) goto L_0x007b;
    L_0x0054:
        if (r4 != 0) goto L_0x0065;
    L_0x0056:
        r1 = 0;
        r7.thc = r1;	 Catch:{ all -> 0x008c }
        r1 = 5;
        r7.setResult(r1);	 Catch:{ all -> 0x008c }
        r7.coQ();	 Catch:{ all -> 0x008c }
        r7.finish();	 Catch:{ all -> 0x008c }
    L_0x0063:
        monitor-exit(r7);
        return r0;
    L_0x0065:
        r2 = 1;
        r7.thc = r2;	 Catch:{ all -> 0x008c }
        r2 = 1;
        r7.dDR = r2;	 Catch:{ all -> 0x008c }
        r2 = r4.field_type;	 Catch:{ all -> 0x008c }
        r2 = com.tencent.mm.l.a.gd(r2);	 Catch:{ all -> 0x008c }
        if (r2 == 0) goto L_0x0063;
    L_0x0073:
        r0 = 1;
        r7.thc = r0;	 Catch:{ all -> 0x008c }
        r0 = 1;
        r7.dDR = r0;	 Catch:{ all -> 0x008c }
        r0 = r1;
        goto L_0x0063;
    L_0x007b:
        if (r2 == 0) goto L_0x009f;
    L_0x007d:
        r1 = r7.thc;	 Catch:{ all -> 0x008c }
        if (r1 == 0) goto L_0x008f;
    L_0x0081:
        r1 = 5;
        r7.setResult(r1);	 Catch:{ all -> 0x008c }
        r7.coQ();	 Catch:{ all -> 0x008c }
        r7.finish();	 Catch:{ all -> 0x008c }
        goto L_0x0063;
    L_0x008c:
        r0 = move-exception;
        monitor-exit(r7);
        throw r0;
    L_0x008f:
        r1 = com.tencent.mm.model.am.a.dBr;	 Catch:{ all -> 0x008c }
        r2 = r7.toUserName;	 Catch:{ all -> 0x008c }
        r3 = "";
        r4 = new com.tencent.mm.ui.CheckCanSubscribeBizUI$1;	 Catch:{ all -> 0x008c }
        r4.<init>(r7);	 Catch:{ all -> 0x008c }
        r1.a(r2, r3, r4);	 Catch:{ all -> 0x008c }
        goto L_0x0063;
    L_0x009f:
        r2 = r4.field_type;	 Catch:{ all -> 0x008c }
        r2 = com.tencent.mm.l.a.gd(r2);	 Catch:{ all -> 0x008c }
        if (r2 != 0) goto L_0x0073;
    L_0x00a7:
        r1 = "MicroMsg.CheckCanSubscribeBizUI";
        r2 = "is not contact.";
        com.tencent.mm.sdk.platformtools.x.w(r1, r2);	 Catch:{ all -> 0x008c }
        r1 = 1;
        r7.thc = r1;	 Catch:{ all -> 0x008c }
        goto L_0x0063;
    L_0x00b4:
        r2 = r0;
        goto L_0x0021;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.CheckCanSubscribeBizUI.coO():boolean");
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            this.thd = true;
            if (this.the) {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void coP() {
        Toast.makeText(this, getString(R.l.verify_authority_err), 1).show();
        aHQ();
    }

    private void coQ() {
        Toast.makeText(this, R.l.regbyqq_auth_err_title, 1).show();
        aHQ();
    }

    private void aHQ() {
        if (this.source == 1) {
            LauncherUI.gm(this);
        }
    }

    public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
        new ag().post(new 3(this, str));
    }

    public final void a(int i, m mVar, Object obj) {
        if (obj == null || !(obj instanceof String)) {
            x.d("MicroMsg.CheckCanSubscribeBizUI", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), mVar, obj});
            return;
        }
        a((String) obj, null);
    }
}
