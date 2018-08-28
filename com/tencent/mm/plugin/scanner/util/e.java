package com.tencent.mm.plugin.scanner.util;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.aa.q;
import com.tencent.mm.ab.l;
import com.tencent.mm.ac.d.b;
import com.tencent.mm.ac.z;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.lo;
import com.tencent.mm.g.a.op;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.network.ab;
import com.tencent.mm.plugin.af.a.c.a;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.plugin.sns.i$l;
import com.tencent.mm.pluginsdk.ui.j;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.protocal.c.bja;
import com.tencent.mm.protocal.c.bjp;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class e implements com.tencent.mm.ab.e, a {
    public String appId;
    public int bJt;
    public String bJw;
    public String bhd;
    private ProgressDialog hpV = null;
    public int iVT;
    public String imagePath;
    private Activity mActivity;
    private int mMR;
    private String mMS;
    private Bundle mMT;
    a mMU = null;
    private Map<l, Integer> mMV = new HashMap();

    public e() {
        onResume();
    }

    public final void a(Activity activity, String str, int i, int i2, int i3, a aVar, Bundle bundle) {
        x.i("MicroMsg.QBarStringHandler", "deal QBarString %s, source:%d, codeType: %s, codeVersion: %s", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        this.mActivity = activity;
        this.mMR = i;
        this.mMS = str;
        this.mMU = aVar;
        this.mMT = bundle;
        if (bi.oW(str)) {
            x.e("MicroMsg.QBarStringHandler", "qbarstring is null or nil");
        } else if (au.DF().Lg() == 0) {
            Toast.makeText(activity, activity.getString(R.l.fmt_iap_err), 0).show();
            if (this.mMU != null) {
                this.mMU.o(0, null);
            }
        } else {
            String str2 = "";
            if (str.startsWith("weixin://qr/")) {
                str2 = str.substring(12) + "@qr";
            } else if (str.startsWith("http://weixin.qq.com/r/")) {
                str2 = str.substring(23) + "@qr";
            }
            if (bi.oW(str2)) {
                x.d("MicroMsg.QBarStringHandler", "qbarString: %s, auth native: %s, remittance: %s", new Object[]{str, Boolean.valueOf(true), Boolean.valueOf(true)});
                int vE;
                int vc;
                int vc2;
                op opVar;
                if (str.startsWith("weixin://wxpay/bizpayurl")) {
                    x.i("MicroMsg.QBarStringHandler", "do native pay");
                    vE = vE(this.mMR);
                    vc = vc(vE);
                    lo loVar = new lo();
                    loVar.bVS.url = str;
                    loVar.bVS.bVU = vc;
                    loVar.bVS.scene = vE;
                    loVar.bVS.context = this.mActivity;
                    if (vc == 13) {
                        x.d("MicroMsg.QBarStringHandler", "add source and sourceType");
                        loVar.bVS.bhd = this.bhd;
                        loVar.bVS.bJt = this.bJt;
                    }
                    loVar.bJX = new 1(this, loVar);
                    com.tencent.mm.sdk.b.a.sFg.a(loVar, Looper.myLooper());
                    new ag(Looper.getMainLooper()).postDelayed(new 4(this), 200);
                    return;
                } else if (str.startsWith("https://wx.tenpay.com/f2f") || str.startsWith("wxp://f2f")) {
                    if (this.mMU != null) {
                        this.mMU.o(5, null);
                    }
                    h.a(this.mActivity, 1, str, vc(vE(this.mMR)), null);
                    if (this.mMU != null) {
                        this.mMU.o(3, null);
                        return;
                    }
                    return;
                } else if (str.startsWith("wxp://wbf2f")) {
                    if (this.mMU != null) {
                        this.mMU.o(5, null);
                    }
                    h.a(this.mActivity, 6, str, vc(vE(this.mMR)), null);
                    if (this.mMU != null) {
                        this.mMU.o(3, null);
                        return;
                    }
                    return;
                } else if (i2 == 22 && str.startsWith("m")) {
                    x.d("MicroMsg.QBarStringHandler", "go to reward");
                    if (this.mMU != null) {
                        this.mMU.o(5, null);
                    }
                    vc2 = vc(vE(this.mMR));
                    str2 = "";
                    if (bundle != null) {
                        str2 = bundle.getString("stat_url", "");
                    }
                    vc = 1;
                    if (this.iVT == 37) {
                        vc = 2;
                    } else if (this.iVT == 38) {
                        vc = 3;
                    } else if (this.iVT == 40) {
                        vc = 4;
                    }
                    h.a(this.mActivity, str, vc2, str2, vc);
                    if (this.mMU != null) {
                        this.mMU.o(3, null);
                        return;
                    }
                    return;
                } else if (str.startsWith("https://payapp.weixin.qq.com/qr/")) {
                    x.d("MicroMsg.QBarStringHandler", "f2f pay material");
                    if (this.mMU != null) {
                        this.mMU.o(5, null);
                    }
                    vE = vE(this.mMR);
                    vc = vc(vE);
                    opVar = new op();
                    opVar.bZx.bZz = str;
                    opVar.bZx.scene = vE;
                    opVar.bZx.type = 0;
                    opVar.bZx.YC = new WeakReference(this.mActivity);
                    opVar.bZx.bJX = new 5(this, opVar, vc);
                    com.tencent.mm.sdk.b.a.sFg.m(opVar);
                    return;
                } else if (i2 == 22 && str.startsWith("n")) {
                    x.d("MicroMsg.QBarStringHandler", "qr reward pay material");
                    if (this.mMU != null) {
                        this.mMU.o(5, null);
                    }
                    String str3 = "";
                    if (bundle != null) {
                        str3 = bundle.getString("stat_url", "");
                    }
                    int vE2 = vE(this.mMR);
                    int vc3 = vc(vE2);
                    opVar = new op();
                    opVar.bZx.bZz = str;
                    opVar.bZx.scene = vE2;
                    opVar.bZx.type = 1;
                    opVar.bZx.YC = new WeakReference(this.mActivity);
                    opVar.bZx.bJX = new 6(this, opVar, vc3, str3, vE2);
                    com.tencent.mm.sdk.b.a.sFg.m(opVar);
                    return;
                } else if (str.startsWith("wxhb://f2f")) {
                    x.i("MicroMsg.QBarStringHandler", "scan f2f hb url");
                    if (i2 == 19) {
                        if (this.mMU != null) {
                            this.mMU.o(5, null);
                        }
                        Intent intent = new Intent();
                        intent.putExtra("key_share_url", str);
                        d.b(this.mActivity, "luckymoney", ".f2f.ui.LuckyMoneyF2FReceiveUI", intent, 1);
                        return;
                    }
                    return;
                } else {
                    String str4 = this.appId;
                    x.i("MicroMsg.QBarStringHandler", "getA8Key text:%s, mQBarStringSource: %s, sceneValue: %s", new Object[]{str, Integer.valueOf(this.mMR), Integer.valueOf(this.iVT > 0 ? this.iVT : vE(this.mMR))});
                    com.tencent.mm.modelsimple.h hVar = new com.tencent.mm.modelsimple.h(str, vc2, i2, i3, str4, (int) System.currentTimeMillis(), new byte[0]);
                    this.mMV.put(hVar, Integer.valueOf(1));
                    au.DF().a(hVar, 0);
                    if (this.hpV != null) {
                        this.hpV.dismiss();
                    }
                    activity.getString(R.l.app_tip);
                    this.hpV = com.tencent.mm.ui.base.h.a(activity, activity.getString(R.l.qrcode_scan_default), true, new 9(this, hVar));
                    if (this.mMU != null) {
                        this.mMU.o(5, null);
                        return;
                    }
                    return;
                }
            }
            a(activity, i, str2, false);
        }
    }

    private static int vc(int i) {
        if (i == 30 || i == 37 || i == 38 || i == 40) {
            return 13;
        }
        if (i == 4 || i == 47) {
            return 12;
        }
        if (i == 34) {
            return 24;
        }
        return 0;
    }

    public final void bsY() {
        x.i("MicroMsg.QBarStringHandler", "cancel Deal");
        this.mMS = null;
        this.mActivity = null;
        onPause();
    }

    public final void onResume() {
        x.i("MicroMsg.QBarStringHandler", "onResume");
        au.DF().a(i$l.AppCompatTheme_ratingBarStyle, this);
        au.DF().a(233, this);
        au.DF().a(666, this);
        au.DF().a(372, this);
    }

    public final void onPause() {
        x.i("MicroMsg.QBarStringHandler", "onPause");
        au.DF().b(i$l.AppCompatTheme_ratingBarStyle, this);
        au.DF().b(233, this);
        au.DF().b(666, this);
        au.DF().b(372, this);
    }

    private void a(Activity activity, int i, String str, boolean z) {
        int i2 = 2;
        x.i("MicroMsg.QBarStringHandler", "start search contact %s", new Object[]{str});
        if (i != 2) {
            i2 = 1;
        }
        f fVar = new f(str, i2, 5, z);
        this.mMV.put(fVar, Integer.valueOf(1));
        au.DF().a(fVar, 0);
        activity.getString(R.l.app_tip);
        this.hpV = com.tencent.mm.ui.base.h.b(activity, activity.getString(R.l.scan_loading_tip), new 7(this, fVar));
    }

    private static int vE(int i) {
        if (i == 1) {
            return 34;
        }
        if (i == 0) {
            return 4;
        }
        if (i == 3) {
            return 42;
        }
        return 30;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.QBarStringHandler", "onSceneEnd: errType = [%s] errCode = [%s] errMsg = [%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        String str2;
        if (lVar == null) {
            String str3 = "MicroMsg.QBarStringHandler";
            str2 = "onSceneEnd() scene is null [%s]";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(lVar == null);
            x.e(str3, str2, objArr);
            if (this.mMU != null) {
                this.mMU.o(2, null);
                return;
            }
            return;
        }
        if (!this.mMV.containsKey(lVar)) {
            if (lVar instanceof u) {
                x.e("MicroMsg.QBarStringHandler", "emotion scan scene");
            } else {
                x.e("MicroMsg.QBarStringHandler", "not my scene, don't care it");
                return;
            }
        }
        this.mMV.remove(lVar);
        if (this.hpV != null) {
            this.hpV.dismiss();
            this.hpV = null;
        }
        com.tencent.mm.modelsimple.h hVar;
        if (lVar.getType() == 372 && i == 4 && i2 == -2034) {
            hVar = new com.tencent.mm.modelsimple.h(((com.tencent.mm.openim.b.e) lVar).eux, null, 50, 0, new byte[0]);
            g.Ek();
            g.Eh().dpP.a(hVar, 0);
            this.mMV.put(hVar, Integer.valueOf(1));
        } else if (i == 4 && i2 == -4) {
            com.tencent.mm.ui.base.h.a(this.mActivity, R.l.qrcode_no_user_tip, R.l.app_tip, new 10(this));
        } else {
            Object obj;
            switch (i) {
                case 1:
                    if (au.DF().Lh()) {
                        au.DF().getNetworkServerIp();
                        new StringBuilder().append(i2);
                    } else if (ab.bU(this.mActivity)) {
                        j.eY(this.mActivity);
                    } else {
                        Toast.makeText(this.mActivity, this.mActivity.getString(R.l.fmt_http_err, new Object[]{Integer.valueOf(1), Integer.valueOf(i2)}), 1).show();
                    }
                    obj = 1;
                    break;
                case 2:
                    Toast.makeText(this.mActivity, this.mActivity.getString(R.l.fmt_iap_err, new Object[]{Integer.valueOf(2), Integer.valueOf(i2)}), 1).show();
                    obj = 1;
                    break;
                default:
                    obj = null;
                    break;
            }
            Bundle bundle;
            String str4;
            if (obj != null) {
                if (this.mMU != null) {
                    this.mMU.o(1, null);
                }
            } else if (i == 4 && i2 == -2004) {
                com.tencent.mm.ui.base.h.i(this.mActivity, R.l.qrcode_ban_by_expose, R.l.app_tip);
                if (this.mMU != null) {
                    this.mMU.o(1, null);
                }
            } else if (i != 0 || i2 != 0) {
                Toast.makeText(this.mActivity, this.mActivity.getString(R.l.fmt_search_err, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                if (this.mMU != null) {
                    this.mMU.o(1, null);
                }
            } else if (lVar.getType() == i$l.AppCompatTheme_ratingBarStyle) {
                f fVar = (f) lVar;
                if (!fVar.lbK) {
                    bja bcS = fVar.bcS();
                    if (com.tencent.mm.storage.ab.Dk(bcS.rTe) && bcS.rTl != null && !bi.oW(bcS.rTl.eJW) && com.tencent.mm.modelappbrand.a.jh(bcS.rTl.eJW)) {
                        int vE = this.iVT > 0 ? this.iVT : vE(this.mMR);
                        x.i("MicroMsg.QBarStringHandler", "getA8Key text:%s, mQBarStringSource: %s, sceneValue: %s", new Object[]{this.mMS, Integer.valueOf(this.mMR), Integer.valueOf(vE)});
                        hVar = new com.tencent.mm.modelsimple.h(this.mMS, null, 43, 0, new byte[0]);
                        this.mMV.put(hVar, Integer.valueOf(1));
                        au.DF().a(hVar, 0);
                        if (this.hpV != null) {
                            this.hpV.dismiss();
                        }
                        Context context = this.mActivity;
                        this.mActivity.getString(R.l.app_tip);
                        this.hpV = com.tencent.mm.ui.base.h.a(context, this.mActivity.getString(R.l.qrcode_scan_default), true, new 3(this, hVar));
                        obj = 1;
                        if (obj == null) {
                            bja bcS2 = ((f) lVar).bcS();
                            str2 = com.tencent.mm.platformtools.ab.a(bcS2.rvi);
                            x.d("MicroMsg.QBarStringHandler", "handle search contact result, username:" + bcS2.rvi);
                            q.Kp().g(str2, com.tencent.mm.platformtools.ab.a(bcS2.rcn));
                            if (this.hpV != null && this.hpV.isShowing()) {
                                x.d("MicroMsg.QBarStringHandler", "tip dialog dismiss");
                                this.hpV.dismiss();
                            }
                            if (bi.oV(str2).length() > 0) {
                                au.HU();
                                com.tencent.mm.storage.ab Yg = c.FR().Yg(str2);
                                if (Yg != null && com.tencent.mm.l.a.gd(Yg.field_type) && Yg.ckW()) {
                                    com.tencent.mm.ac.d kA = z.MY().kA(str2);
                                    kA.bG(false);
                                    b bVar = kA.dKP;
                                    if (bVar.dKT != null) {
                                        bVar.dLj = bVar.dKT.optInt("ScanQRCodeType", 0);
                                    }
                                    if (!((bVar.dLj == 1 ? 1 : null) == null || kA.LY())) {
                                        Intent intent = new Intent();
                                        intent.putExtra("Chat_User", str2);
                                        intent.putExtra("finish_direct", true);
                                        com.tencent.mm.plugin.scanner.b.ezn.e(intent, this.mActivity);
                                        obj = 1;
                                    }
                                }
                                vE = bsZ();
                                Intent intent2 = new Intent();
                                com.tencent.mm.pluginsdk.ui.tools.c.a(intent2, bcS2, vE);
                                if (!(Yg == null || com.tencent.mm.l.a.gd(Yg.field_type))) {
                                    intent2.putExtra("Contact_IsLBSFriend", true);
                                }
                                if ((bcS2.rTe & 8) > 0) {
                                    com.tencent.mm.plugin.report.service.h.mEJ.k(10298, str2 + "," + vE);
                                }
                                if (this.mActivity != null) {
                                    com.tencent.mm.plugin.scanner.b.ezn.d(intent2, this.mActivity);
                                    com.tencent.mm.plugin.report.service.h hVar2 = com.tencent.mm.plugin.report.service.h.mEJ;
                                    Object[] objArr2 = new Object[6];
                                    objArr2[0] = Integer.valueOf(com.tencent.mm.storage.ab.Dk(bcS2.rTe) ? 0 : 1);
                                    objArr2[1] = Integer.valueOf(this.bJt);
                                    objArr2[2] = Integer.valueOf(this.mMR);
                                    objArr2[3] = this.imagePath;
                                    objArr2[4] = this.mMS;
                                    objArr2[5] = bi.oV(this.bJw);
                                    hVar2.h(14268, objArr2);
                                }
                                obj = 1;
                            } else {
                                if (this.mActivity != null) {
                                    Toast.makeText(this.mActivity, R.l.scan_search_contact_fail, 0).show();
                                }
                                obj = null;
                            }
                            if (obj != null) {
                                if (this.mMU != null) {
                                    bundle = new Bundle();
                                    bundle.putString("geta8key_fullurl", com.tencent.mm.platformtools.ab.a(((f) lVar).bcS().rvi));
                                    bundle.putInt("geta8key_action_code", 4);
                                    this.mMU.o(3, bundle);
                                }
                            } else if (this.mMU != null) {
                                this.mMU.o(1, null);
                            }
                        }
                    }
                }
                obj = null;
                if (obj == null) {
                    bja bcS22 = ((f) lVar).bcS();
                    str2 = com.tencent.mm.platformtools.ab.a(bcS22.rvi);
                    x.d("MicroMsg.QBarStringHandler", "handle search contact result, username:" + bcS22.rvi);
                    q.Kp().g(str2, com.tencent.mm.platformtools.ab.a(bcS22.rcn));
                    if (this.hpV != null && this.hpV.isShowing()) {
                        x.d("MicroMsg.QBarStringHandler", "tip dialog dismiss");
                        this.hpV.dismiss();
                    }
                    if (bi.oV(str2).length() > 0) {
                        au.HU();
                        com.tencent.mm.storage.ab Yg2 = c.FR().Yg(str2);
                        if (Yg2 != null && com.tencent.mm.l.a.gd(Yg2.field_type) && Yg2.ckW()) {
                            com.tencent.mm.ac.d kA2 = z.MY().kA(str2);
                            kA2.bG(false);
                            b bVar2 = kA2.dKP;
                            if (bVar2.dKT != null) {
                                bVar2.dLj = bVar2.dKT.optInt("ScanQRCodeType", 0);
                            }
                            if (!((bVar2.dLj == 1 ? 1 : null) == null || kA2.LY())) {
                                Intent intent3 = new Intent();
                                intent3.putExtra("Chat_User", str2);
                                intent3.putExtra("finish_direct", true);
                                com.tencent.mm.plugin.scanner.b.ezn.e(intent3, this.mActivity);
                                obj = 1;
                            }
                        }
                        vE = bsZ();
                        Intent intent22 = new Intent();
                        com.tencent.mm.pluginsdk.ui.tools.c.a(intent22, bcS22, vE);
                        if (!(Yg2 == null || com.tencent.mm.l.a.gd(Yg2.field_type))) {
                            intent22.putExtra("Contact_IsLBSFriend", true);
                        }
                        if ((bcS22.rTe & 8) > 0) {
                            com.tencent.mm.plugin.report.service.h.mEJ.k(10298, str2 + "," + vE);
                        }
                        if (this.mActivity != null) {
                            com.tencent.mm.plugin.scanner.b.ezn.d(intent22, this.mActivity);
                            com.tencent.mm.plugin.report.service.h hVar22 = com.tencent.mm.plugin.report.service.h.mEJ;
                            Object[] objArr22 = new Object[6];
                            objArr22[0] = Integer.valueOf(com.tencent.mm.storage.ab.Dk(bcS22.rTe) ? 0 : 1);
                            objArr22[1] = Integer.valueOf(this.bJt);
                            objArr22[2] = Integer.valueOf(this.mMR);
                            objArr22[3] = this.imagePath;
                            objArr22[4] = this.mMS;
                            objArr22[5] = bi.oV(this.bJw);
                            hVar22.h(14268, objArr22);
                        }
                        obj = 1;
                    } else {
                        if (this.mActivity != null) {
                            Toast.makeText(this.mActivity, R.l.scan_search_contact_fail, 0).show();
                        }
                        obj = null;
                    }
                    if (obj != null) {
                        if (this.mMU != null) {
                            bundle = new Bundle();
                            bundle.putString("geta8key_fullurl", com.tencent.mm.platformtools.ab.a(((f) lVar).bcS().rvi));
                            bundle.putInt("geta8key_action_code", 4);
                            this.mMU.o(3, bundle);
                        }
                    } else if (this.mMU != null) {
                        this.mMU.o(1, null);
                    }
                }
            } else if (lVar.getType() == 372) {
                bjp bjp = ((com.tencent.mm.openim.b.e) lVar).euw;
                str4 = bjp.hbL;
                x.d("MicroMsg.QBarStringHandler", "handle search openim contact result, username:" + str4);
                if (this.hpV != null && this.hpV.isShowing()) {
                    x.d("MicroMsg.QBarStringHandler", "tip dialog dismiss");
                    this.hpV.dismiss();
                }
                if (bi.oV(str4).length() > 0) {
                    au.HU();
                    com.tencent.mm.storage.ab Yg3 = c.FR().Yg(str4);
                    int bsZ = bsZ();
                    Intent intent4 = new Intent();
                    com.tencent.mm.pluginsdk.ui.tools.c.a(intent4, bjp, bsZ);
                    if (!(Yg3 == null || com.tencent.mm.l.a.gd(Yg3.field_type))) {
                        intent4.putExtra("Contact_IsLBSFriend", true);
                    }
                    if (this.mActivity != null) {
                        com.tencent.mm.plugin.scanner.b.ezn.d(intent4, this.mActivity);
                        com.tencent.mm.plugin.report.service.h.mEJ.h(14268, new Object[]{Integer.valueOf(2), Integer.valueOf(this.bJt), Integer.valueOf(this.mMR), this.imagePath, this.mMS, bi.oV(this.bJw)});
                    }
                    obj = 1;
                } else {
                    if (this.mActivity != null) {
                        Toast.makeText(this.mActivity, R.l.scan_search_contact_fail, 0).show();
                    }
                    obj = null;
                }
                if (obj != null) {
                    if (this.mMU != null) {
                        bundle = new Bundle();
                        bundle.putString("geta8key_fullurl", bjp.hbL);
                        bundle.putInt("geta8key_action_code", 4);
                        this.mMU.o(3, bundle);
                    }
                } else if (this.mMU != null) {
                    this.mMU.o(1, null);
                }
            } else if (lVar.getType() == 233) {
                int i3;
                String QL = ((com.tencent.mm.modelsimple.h) lVar).QL();
                Bundle bundle2 = new Bundle();
                bundle2.putString("geta8key_fullurl", QL);
                bundle2.putInt("geta8key_action_code", ((com.tencent.mm.modelsimple.h) lVar).QN());
                if (this.mMU != null) {
                    this.mMU.o(4, bundle2);
                }
                if (this.iVT > 0) {
                    i3 = this.iVT;
                } else {
                    i3 = vE(this.mMR);
                }
                x.i("MicroMsg.QBarStringHandler", "handleGetA8KeyRedirect, sceneValue: %s", new Object[]{Integer.valueOf(i3)});
                boolean a = com.tencent.mm.plugin.af.a.c.a(this, (com.tencent.mm.modelsimple.h) lVar, new 11(this), this.mMS, i3, this.mMR, new 2(this), this.mMT);
                if (!a && ((com.tencent.mm.modelsimple.h) lVar).QN() == 4) {
                    a(this.mActivity, this.mMR, QL, true);
                } else if (a || ((com.tencent.mm.modelsimple.h) lVar).QN() != 29) {
                    x.i("MicroMsg.QBarStringHandler", "scene geta8key, redirect result = [%s]", new Object[]{Boolean.valueOf(a)});
                    if (!a && this.mMU != null) {
                        this.mMU.o(1, null);
                    }
                } else {
                    Context context2 = this.mActivity;
                    x.i("MicroMsg.QBarStringHandler", "start search contact %s", new Object[]{QL});
                    com.tencent.mm.openim.b.e eVar = new com.tencent.mm.openim.b.e(QL);
                    this.mMV.put(eVar, Integer.valueOf(1));
                    au.DF().a(eVar, 0);
                    context2.getString(R.l.app_tip);
                    this.hpV = com.tencent.mm.ui.base.h.b(context2, context2.getString(R.l.scan_loading_tip), new 8(this, eVar));
                }
            } else if (lVar.getType() != 666) {
            } else {
                if (i != 0 || i2 != 0) {
                    x.i("MicroMsg.QBarStringHandler", "jump emotion detail failed.");
                } else if (lVar instanceof u) {
                    x.d("MicroMsg.QBarStringHandler", "[oneliang]NetSceneScanEmoji productId:%s", new Object[]{((u) lVar).Rt().rem});
                    Intent intent5 = new Intent();
                    intent5.putExtra("extra_id", str4);
                    intent5.putExtra("preceding_scence", 11);
                    intent5.putExtra("download_entrance_scene", 14);
                    d.b(this.mActivity, "emoji", ".ui.EmojiStoreDetailUI", intent5);
                    x.i("MicroMsg.QBarStringHandler", "[oneliang]NetSceneScanEmoji onSceneEnd.");
                    if (this.mMU != null) {
                        this.mMU.o(3, null);
                    }
                }
            }
        }
    }

    private int bsZ() {
        switch (this.mMR) {
            case 1:
                return 45;
            default:
                return 30;
        }
    }

    public final Context getContext() {
        return this.mActivity;
    }

    public final void hk(boolean z) {
        if (z) {
            if (this.mMU != null) {
                this.mMU.o(1, null);
            }
        } else if (this.mMU != null) {
            this.mMU.o(3, null);
        }
    }
}
