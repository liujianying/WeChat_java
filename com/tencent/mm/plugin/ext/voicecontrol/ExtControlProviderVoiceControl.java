package com.tencent.mm.plugin.ext.voicecontrol;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import com.qq.wx.voice.embed.recognizer.b.a;
import com.qq.wx.voice.embed.recognizer.c;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ac.f;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.au;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.ext.provider.ExtContentProviderBase;
import com.tencent.mm.plugin.sns.i$l;
import com.tencent.mm.pluginsdk.d.a.b;
import com.tencent.mm.protocal.c.dk;
import com.tencent.mm.protocal.c.dm;
import com.tencent.mm.protocal.c.dp;
import com.tencent.mm.protocal.c.dq;
import com.tencent.mm.protocal.c.dr;
import com.tencent.mm.protocal.c.ds;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;

public class ExtControlProviderVoiceControl extends ExtContentProviderBase implements e {
    private static final String[] iJr = new String[]{"retCode"};
    private Context context;
    private String[] iJE = null;
    private int iJF = -1;
    private int iLb = 4;
    private long iLc;
    private long iLd;
    private long iLe;
    b iLf = new b();
    private long iLg = 0;
    private boolean iLh;
    private c iLi = new 5(this);

    static /* synthetic */ void a(ExtControlProviderVoiceControl extControlProviderVoiceControl, String str) {
        extControlProviderVoiceControl.iLh = false;
        extControlProviderVoiceControl.iLg = System.currentTimeMillis();
        x.i("MicroMsg.ext.ExtControlProviderVoiceControl", "localVoiceControl  hasInit:%s", new Object[]{Boolean.valueOf(ad.chZ().getBoolean("hasInitVoiceControlData", true))});
        if (ad.chZ().getBoolean("hasInitVoiceControlData", true)) {
            byte[] f = com.tencent.mm.a.e.f(str, 0, -1);
            com.qq.wx.voice.embed.recognizer.b bVar = a.bgm;
            int a = bVar.bgl.a(extControlProviderVoiceControl.iLi, f);
            x.i("MicroMsg.ext.ExtControlProviderVoiceControl", "recognize ret:%s", new Object[]{Integer.valueOf(a)});
        }
    }

    static /* synthetic */ void c(ExtControlProviderVoiceControl extControlProviderVoiceControl, String str) {
        Intent intent;
        if (f.kM(str)) {
            intent = new Intent();
            intent.putExtra("enterprise_biz_name", str);
            intent.putExtra("enterprise_biz_display_name", r.gT(str));
            d.e(extControlProviderVoiceControl.context, ".ui.conversation.EnterpriseConversationUI", intent);
        } else if (f.eZ(str)) {
            intent = new Intent();
            intent.putExtra("Contact_User", str);
            intent.addFlags(67108864);
            intent.putExtra("biz_chat_from_scene", 7);
            d.e(extControlProviderVoiceControl.context, ".ui.bizchat.BizChatConversationUI", intent);
        } else if (f.kN(str)) {
            com.tencent.mm.ac.d kH = f.kH(str);
            String Mc = kH == null ? null : kH.Mc();
            if (Mc == null) {
                Mc = "";
            }
            Intent intent2 = new Intent();
            intent2.putExtra("rawUrl", Mc);
            intent2.putExtra("useJs", true);
            intent2.putExtra("srcUsername", str);
            intent2.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
            intent2.addFlags(67108864);
            d.b(extControlProviderVoiceControl.context, "webview", ".ui.tools.WebViewUI", intent2);
        } else {
            intent = new Intent();
            intent.putExtra("Chat_User", str);
            intent.addFlags(268435456);
            intent.addFlags(32768);
            com.tencent.mm.plugin.ext.a.ezn.e(intent, extControlProviderVoiceControl.context);
        }
    }

    public ExtControlProviderVoiceControl(String[] strArr, int i, Context context) {
        this.iJE = strArr;
        this.iJF = i;
        this.context = context;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        x.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] query(), ApiId=%s", new Object[]{Integer.valueOf(this.iJF)});
        this.iLc = 0;
        this.iLd = 0;
        a(uri, this.context, this.iJF, this.iJE);
        if (uri == null) {
            x.e("MicroMsg.ext.ExtControlProviderVoiceControl", "uri == null");
            cw(3, 5);
            return com.tencent.mm.pluginsdk.d.a.a.BA(5);
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (bi.oW(this.iJN)) {
            x.e("MicroMsg.ext.ExtControlProviderVoiceControl", "AppID == null");
            cw(3, 7);
            return com.tencent.mm.pluginsdk.d.a.a.BA(7);
        } else if (bi.oW(aIW())) {
            x.e("MicroMsg.ext.ExtControlProviderVoiceControl", "PkgName == null");
            cw(3, 6);
            return com.tencent.mm.pluginsdk.d.a.a.BA(6);
        } else {
            currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
            long currentTimeMillis2 = System.currentTimeMillis() - System.currentTimeMillis();
            int aIX = aIX();
            if (aIX != 1) {
                x.e("MicroMsg.ext.ExtControlProviderVoiceControl", "invalid appid ! return code = " + aIX);
                cw(2, aIX);
                return com.tencent.mm.pluginsdk.d.a.a.BA(aIX);
            }
            x.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[extApiCost][voiceControl] getAppIdAndPkg = %s, checkIsLogin = %s", new Object[]{Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis2)});
            switch (this.iJF) {
                case i$l.AppCompatTheme_actionModeBackground /*29*/:
                    x.i("MicroMsg.ext.ExtControlProviderVoiceControl", "voiceControl");
                    if (strArr2 == null || strArr2.length < 4) {
                        x.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] wrong args");
                        cw(3, 3501);
                        this.iLb = 3501;
                        return com.tencent.mm.pluginsdk.d.a.a.BA(3501);
                    }
                    String str3 = strArr2[0];
                    String str4 = strArr2[1];
                    String str5 = strArr2[2];
                    String str6 = strArr2[3];
                    String str7 = strArr2[4];
                    x.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] args: %s, %s, %s, %s %s", new Object[]{str3, str4, str5, str6, str7});
                    if (bi.oW(str3) || bi.oW(str4) || bi.oW(str5) || bi.oW(str6) || bi.oW(str7)) {
                        cw(3, 3502);
                        x.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] wrong args");
                        return com.tencent.mm.pluginsdk.d.a.a.BA(3502);
                    } else if (com.tencent.mm.a.e.cn(str7)) {
                        this.iLc = System.currentTimeMillis();
                        au.DF().a(985, this);
                        this.iLf.b(13000, new 1(this, str3, str7, str4, str5, str6));
                        x.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[extApiCost][voiceControl] finish uploadVoice = %s, getResult = %s", new Object[]{Long.valueOf(this.iLd - this.iLc), Long.valueOf(System.currentTimeMillis() - this.iLd)});
                        au.DF().b(985, this);
                        H(10, 0, 1);
                        if (1 != this.iLb) {
                            H(11, 4, 1);
                        } else {
                            H(10, 0, 1);
                        }
                        pr(0);
                        return com.tencent.mm.pluginsdk.d.a.a.BA(this.iLb);
                    } else {
                        x.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] speex file not exist");
                        cw(3, 3503);
                        return com.tencent.mm.pluginsdk.d.a.a.BA(3503);
                    }
                default:
                    cw(3, 15);
                    return com.tencent.mm.pluginsdk.d.a.a.BA(15);
            }
        }
    }

    public static boolean b(String str, int i, int i2, int i3, int i4, String str2) {
        String str3;
        byte[] f;
        x.i("MicroMsg.ext.ExtControlProviderVoiceControl", "uploadVoiceStart ");
        if (i != 4) {
            str3 = str2 + ".speex";
            com.tencent.mm.e.c.d dVar = new com.tencent.mm.e.c.d();
            if (!com.tencent.mm.e.c.d.C(str2, str3)) {
                x.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] decodePCMToSpeex error,pcmPath:%s,speexFilePath:%s", new Object[]{str2, str3});
                return false;
            }
        }
        str3 = str2;
        int cm = com.tencent.mm.a.e.cm(str3);
        ds dsVar = new ds();
        dsVar.rdY = 4;
        dsVar.rdZ = 4;
        dsVar.rea = i3;
        dsVar.reb = i4;
        dr drVar = new dr();
        drVar.rdV = cm;
        drVar.rdW = 0;
        if (cm <= 16384) {
            drVar.rdX = cm;
            f = com.tencent.mm.a.e.f(str3, 0, cm);
        } else {
            drVar.rdX = 16384;
            f = com.tencent.mm.a.e.f(str3, 0, 16384);
        }
        x.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoice appId=%s, FileType=%s, EncodeType=%s, sampleRate=%s, bps=%s, fileLen=%s, limit=%s", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(cm), Integer.valueOf(16384)});
        if (f == null || f.length <= 0) {
            x.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] buf empty");
            return false;
        }
        dq dqVar = new dq();
        dqVar.rdT = dsVar;
        dqVar.rdN = drVar;
        dqVar.rdU = com.tencent.mm.bk.b.bi(f);
        int hashCode = (bi.VF()).hashCode();
        au.DF().a(new a(hashCode != Integer.MIN_VALUE ? Math.abs(hashCode) : Integer.MIN_VALUE, str, cm, str3, dqVar), 0);
        return true;
    }

    private static boolean a(a aVar, int i, int i2) {
        if (aVar == null) {
            x.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue netscene null");
            return false;
        } else if (aVar.iLt == null) {
            x.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue uploadCmd null");
            return false;
        } else if (aVar.iLt.rdN == null) {
            x.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue UploadCtx null");
            return false;
        } else {
            dq dqVar = new dq();
            dq dqVar2 = aVar.iLt;
            dqVar2.rdN.rdW = i;
            dqVar2.rdN.rdX = i2;
            byte[] f = com.tencent.mm.a.e.f(aVar.iLs, i, i2);
            x.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue %s, startPos=%s, dataLen=%s", new Object[]{Integer.valueOf(aVar.iLq), Integer.valueOf(i), Integer.valueOf(i2)});
            if (f == null || f.length <= 0) {
                x.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] buf empty, %s", new Object[]{aVar.iLs});
                return false;
            }
            dqVar2.rdU = com.tencent.mm.bk.b.bi(f);
            a aVar2 = new a(aVar.iLq, aVar.appId, aVar.dHI, aVar.iLs, dqVar2);
            aVar2.dHJ = aVar.dHJ;
            au.DF().a(aVar2, 0);
            return true;
        }
    }

    public final boolean a(int i, String str, com.tencent.mm.bk.b bVar) {
        x.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] getVoiceControlResult voiceId=%s, appId=%s", new Object[]{Integer.valueOf(i), str});
        if (this.iLd == 0) {
            this.iLd = System.currentTimeMillis();
        }
        this.iLe = System.currentTimeMillis();
        dk dkVar = new dk();
        dkVar.rdG = bVar;
        au.DF().a(new a(i, str, dkVar, this.iLd), 0);
        return true;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] onSceneEnd errType=%s, errCode=%s, errMsg=%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (lVar == null) {
            x.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] scene null, countDown");
            this.iLb = 3506;
            this.iLf.countDown();
        } else if (i == 0 && i2 == 0) {
            x.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] scene.getType()=%s", new Object[]{Integer.valueOf(lVar.getType())});
            if (lVar.getType() != 985) {
                return;
            }
            if (this.iLh) {
                x.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] localVoiceControlSucess, no need to process");
                return;
            }
            final a aVar = (a) lVar;
            a aVar2 = (a) lVar;
            final dm dmVar = (aVar2.diG == null || aVar2.diG.dIE.dIL == null) ? null : (dm) aVar2.diG.dIE.dIL;
            if (dmVar == null) {
                x.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] resp null, countDown");
                this.iLb = 3508;
                this.iLf.countDown();
                return;
            }
            aVar.iLr = dmVar.rdG;
            String str2 = "MicroMsg.ext.ExtControlProviderVoiceControl";
            String str3 = "[voiceControl] opCode=%s, resp.Cookies=%s";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(aVar.bNI);
            objArr[1] = dmVar.rdG == null ? "null" : new String(dmVar.rdG.lR);
            x.i(str2, str3, objArr);
            if ((aVar.bNI == 1 ? 1 : null) == null) {
                if ((aVar.bNI == 2 ? 1 : null) != null) {
                    Object obj;
                    x.i("MicroMsg.ext.ExtControlProviderVoiceControl", "");
                    if (System.currentTimeMillis() - aVar.iLw > ((long) aVar.iLv)) {
                        x.w("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] isGetResultTimeOut %s, %s", new Object[]{Long.valueOf(System.currentTimeMillis() - aVar.iLw), Integer.valueOf(aVar.iLv)});
                        obj = 1;
                    } else {
                        x.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] time %s, %s", new Object[]{Long.valueOf(System.currentTimeMillis() - aVar.iLw), Integer.valueOf(aVar.iLv)});
                        obj = null;
                    }
                    if (obj != null) {
                        this.iLb = 3509;
                        this.iLf.countDown();
                        return;
                    }
                    if (dmVar.rdO != null) {
                        x.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] getResultMode resp VoiceId=%s, RecognizeRet=%s", new Object[]{Integer.valueOf(dmVar.rdO.rdH), Integer.valueOf(dmVar.rdO.rdP)});
                    }
                    if (dmVar.rdO == null || dmVar.rdO.rdP != 0) {
                        if (System.currentTimeMillis() - this.iLe >= ((long) dmVar.rdL)) {
                            ah.A(new 3(this, aVar));
                            return;
                        }
                        long currentTimeMillis = ((long) dmVar.rdL) - (System.currentTimeMillis() - this.iLe);
                        if (currentTimeMillis > ((long) dmVar.rdL)) {
                            currentTimeMillis = (long) dmVar.rdL;
                        }
                        ah.i(new 4(this, aVar), currentTimeMillis);
                    } else if (dmVar.rdO.rdQ == null) {
                        x.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] SearchContactResultInfo null, countDown");
                        this.iLb = 3511;
                        this.iLf.countDown();
                    } else if (dmVar.rdO.rdQ.rdR == null || dmVar.rdO.rdQ.rdR.size() <= 0) {
                        x.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] SearchContactResultInfo.Items null, countDown");
                        this.iLb = 3511;
                        this.iLf.countDown();
                    } else if (dmVar.rdO.rdQ.rdR.size() == 0) {
                        this.iLb = 3511;
                        this.iLf.countDown();
                    } else if (dmVar.rdO.rdQ.rdR.size() == 1) {
                        AP(((dp) dmVar.rdO.rdQ.rdR.get(0)).rdS);
                    } else {
                        String[] strArr = new String[dmVar.rdO.rdQ.rdR.size()];
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 < strArr.length) {
                                strArr[i4] = ((dp) dmVar.rdO.rdQ.rdR.get(i4)).rdS;
                                x.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] resp result item: %s", new Object[]{strArr[i4]});
                                i3 = i4 + 1;
                            } else {
                                Intent intent = new Intent();
                                intent.putExtra("VoiceSearchResultUI_Resultlist", strArr);
                                intent.putExtra("VoiceSearchResultUI_VoiceId", aVar.iLq);
                                intent.putExtra("VoiceSearchResultUI_IsVoiceControl", true);
                                intent.setFlags(67108864);
                                intent.putExtra("VoiceSearchResultUI_ShowType", 1);
                                d.e(this.context, ".ui.voicesearch.VoiceSearchResultUI", intent);
                                x.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] scene end countDown");
                                this.iLb = 1;
                                this.iLf.countDown();
                                return;
                            }
                        }
                    }
                }
            } else if (dmVar.rdN == null) {
                x.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] resp.UploadCtx is null");
                this.iLb = 3508;
                this.iLf.countDown();
            } else {
                x.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadMode resp: Interval=%s, Timeout=%s, StartPos=%s, DataLen=%s", new Object[]{Integer.valueOf(dmVar.rdL), Integer.valueOf(dmVar.rdM), Integer.valueOf(dmVar.rdN.rdW), Integer.valueOf(dmVar.rdN.rdX)});
                if (dmVar.rdN.rdW >= aVar.dHI) {
                    ah.i(new Runnable() {
                        public final void run() {
                            x.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] getResultMode getVoiceControlResult");
                            a aVar = aVar;
                            x.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] setGetResultTimeOut %s", new Object[]{Integer.valueOf(dmVar.rdM)});
                            aVar.iLv = r1;
                            ExtControlProviderVoiceControl.this.a(aVar.iLq, aVar.appId, aVar.iLr);
                        }
                    }, (long) dmVar.rdL);
                    return;
                }
                x.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] continue upload voice");
                if (dmVar.rdN.rdW == 0 || dmVar.rdN.rdW != aVar.dHJ) {
                    aVar.dHJ = dmVar.rdN.rdW;
                    if (dmVar.rdN.rdW + dmVar.rdN.rdX < aVar.dHI) {
                        if (!a(aVar, dmVar.rdN.rdW, dmVar.rdN.rdX)) {
                            x.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue fail1, countDown");
                            this.iLb = 3510;
                            this.iLf.countDown();
                            return;
                        }
                        return;
                    } else if (!a(aVar, dmVar.rdN.rdW, aVar.dHI - dmVar.rdN.rdW)) {
                        x.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue fail2, countDown");
                        this.iLb = 3510;
                        this.iLf.countDown();
                        return;
                    } else {
                        return;
                    }
                }
                x.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] avoid duplicate doscene");
            }
        } else {
            x.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] errType、errCode not ok, countDown");
            this.iLb = 3507;
            this.iLf.countDown();
        }
    }

    private void AP(String str) {
        au.HU();
        ab Yg = com.tencent.mm.model.c.FR().Yg(str);
        if (Yg == null || !com.tencent.mm.l.a.gd(Yg.field_type)) {
            x.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] username is not contact, countDown");
            this.iLb = 3505;
            this.iLf.countDown();
            return;
        }
        com.tencent.mm.compatible.a.a.a(11, new 6(this, str));
        this.iLb = 1;
        x.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] jump to chattingUI : %s, countDown", new Object[]{str});
        this.iLf.countDown();
    }
}
