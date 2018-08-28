package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.model.m;
import com.tencent.mm.plugin.webview.model.n;
import com.tencent.mm.plugin.webview.model.o;
import com.tencent.mm.plugin.webview.model.p;
import com.tencent.mm.plugin.webview.stub.WebViewStubTempUI;
import com.tencent.mm.protocal.c.aoc;
import com.tencent.mm.protocal.c.aod;
import com.tencent.mm.protocal.c.aoe;
import com.tencent.mm.protocal.c.aol;
import com.tencent.mm.protocal.c.aom;
import com.tencent.mm.protocal.c.aoo;
import com.tencent.mm.protocal.c.aop;
import com.tencent.mm.protocal.c.apd;
import com.tencent.mm.protocal.c.bxq;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class c implements e {
    private Context context;
    final HashMap<String, d> jJK = new HashMap();
    private com.tencent.mm.plugin.webview.stub.e pRY;
    final int pRn;
    final HashMap<String, aoc> qgX = new HashMap();
    final HashMap<String, String> qgY = new HashMap();

    public final String RE(String str) {
        if (str == null) {
            return null;
        }
        String str2 = (String) this.qgY.get(str);
        if (!bi.oW(str2)) {
            return str2;
        }
        String Dq = Dq(str);
        x.i("MicroMsg.webview.JSVerifyHelper", "appid = %s, url = %s, drophash url = %s", new Object[]{str2, str, Dq});
        if (bi.oW(Dq)) {
            return str2;
        }
        return (String) this.qgY.get(Dq);
    }

    public c(int i) {
        this.pRn = i;
    }

    final void a(Context context, com.tencent.mm.plugin.webview.stub.e eVar) {
        this.context = context;
        this.pRY = eVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.webview.JSVerifyHelper", "JSVerifyHelper onSceneEnd: type[%d], errType[%s], errCode[%s], errMsg[%s]", new Object[]{Integer.valueOf(lVar.getType()), Integer.valueOf(i), Integer.valueOf(i2), str});
        if (!(lVar instanceof b)) {
            x.i("MicroMsg.webview.JSVerifyHelper", "JSVerifyHelper onSceneEnd: net scene type mismatched, return");
        } else if (((b) lVar).bUa() != this.pRn) {
            x.i("MicroMsg.webview.JSVerifyHelper", "JSVerifyHelper onSceneEnd: this.binderId = %d, incoming binderId = %d, not equal, return", new Object[]{Integer.valueOf(this.pRn), Integer.valueOf(((b) lVar).bUa())});
        } else {
            int type = lVar.getType();
            if (type == 1093) {
                au.DF().b(1093, this);
                n nVar = (n) lVar;
                if (nVar == null) {
                    x.e("MicroMsg.webview.JSVerifyHelper", "");
                } else if (nVar.pRl == null) {
                    x.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIPreVerify, VerifyCallback is null");
                } else {
                    int i3 = 0;
                    if (!(nVar.bUb() == null || nVar.bUb().rQI == null)) {
                        i3 = nVar.bUb().rQI.bMH;
                    }
                    if (i == 0 && i2 == 0) {
                        aom bUb = nVar.bUb();
                        aol aol = nVar.diG == null ? null : (aol) nVar.diG.dID.dIL;
                        if (bUb == null || bi.oW(nVar.gsE) || aol == null || bi.oW(aol.bPS)) {
                            String str2 = "MicroMsg.webview.JSVerifyHelper";
                            String str3 = "something null %b, %b, %b";
                            Object[] objArr = new Object[3];
                            objArr[0] = Boolean.valueOf(bUb == null);
                            objArr[1] = Boolean.valueOf(bi.oW(nVar.gsE));
                            objArr[2] = Boolean.valueOf(aol == null);
                            x.e(str2, str3, objArr);
                            nVar.pRl.a(a.qhd, null, null, i2, i3);
                        } else if (bUb.rQI == null) {
                            x.e("MicroMsg.webview.JSVerifyHelper", "jsapi_baseresponse null");
                            nVar.pRl.a(a.qhd, null, null, i2, i3);
                        } else if (bUb.rQI.bMH != 0) {
                            x.e("MicroMsg.webview.JSVerifyHelper", "jsapi baseresponse errcode fail : %d, errmsg = %s", new Object[]{Integer.valueOf(bUb.rQI.bMH), bUb.rQI.bMI});
                            nVar.pRl.a(a.qhd, bUb.rQI.bMI, null, i2, i3);
                        } else {
                            this.qgY.put(Dq(aol.url), aol.bPS);
                            d dVar = new d();
                            dVar.appId = aol.bPS;
                            dVar.qhi = bUb.rQX;
                            this.jJK.put(Dq(aol.url), dVar);
                            nVar.pRl.a(a.qhc, null, bUb.rQW, i2, i3);
                        }
                    } else if (i == 4) {
                        nVar.pRl.a(a.qhd, i2 + "_" + str, null, i2, i3);
                    } else {
                        nVar.pRl.a(a.qhd, null, null, i2, i3);
                    }
                }
            } else if (type == 1095) {
                au.DF().b(1095, this);
                a(i, i2, str, (m) lVar);
            } else if (type == 1094) {
                au.DF().b(1094, this);
                o oVar = (o) lVar;
                if (oVar == null) {
                    x.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIRealtimeVerify scene is null");
                    return;
                }
                int i4;
                h.mEJ.a(157, 24, 1, false);
                if (oVar.bUc() == null || oVar.bUc().rQI == null) {
                    i4 = 0;
                } else {
                    i4 = oVar.bUc().rQI.bMH;
                }
                if (i == 0 && i2 == 0) {
                    aoo bUc = oVar.bUc();
                    if (bUc == null || bUc.rQI == null) {
                        x.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIRealtimeVerify resp is null");
                        oVar.pRl.a(a.qhd, null, null, i2, i4);
                        return;
                    } else if (bUc.rQI.bMH != 0) {
                        x.e("MicroMsg.webview.JSVerifyHelper", "realtime jsapi_baseresponse %s, %s", new Object[]{Integer.valueOf(bUc.rQI.bMH), bUc.rQI.bMI});
                        oVar.pRl.a(a.qhd, bUc.rQI.bMI, null, i2, i4);
                        return;
                    } else {
                        bxq bxq = bUc.rQY;
                        if (bxq == null) {
                            x.e("MicroMsg.webview.JSVerifyHelper", "realtime not ok, vInfo is null");
                            oVar.pRl.a(a.qhd, "verifyFail", null, i2, i4);
                            return;
                        } else if (bxq.stR != 1) {
                            x.e("MicroMsg.webview.JSVerifyHelper", "realtime not ok, %s", new Object[]{Integer.valueOf(bxq.stR)});
                            oVar.pRl.a(a.qhd, "verifyFail", null, i2, i4);
                            return;
                        } else {
                            oVar.pRl.a(a.qhc, null, null, i2, i4);
                            return;
                        }
                    }
                }
                x.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIRealtimeVerify netscene error", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                h.mEJ.a(157, 25, 1, false);
                if (i == 4) {
                    oVar.pRl.a(a.qhd, i2 + "_" + str, null, i2, i4);
                } else {
                    oVar.pRl.a(a.qhd, null, null, i2, i4);
                }
            } else if (type == 1096) {
                au.DF().b(1096, this);
                p pVar = (p) lVar;
                aop aop = pVar.diG == null ? null : (aop) pVar.diG.dID.dIL;
                if (aop == null) {
                    x.e("MicroMsg.webview.JSVerifyHelper", "JSAPISetOAuth, setAuthReq is null");
                } else if (i != 0 || i2 != 0) {
                    x.e("MicroMsg.webview.JSVerifyHelper", "JSAPISetOAuth, errType[%s], errCode[%s], %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), aop.rQC});
                } else if (com.tencent.mm.protocal.c.Ux(bi.oV(aop.rQC)) == null) {
                    x.e("MicroMsg.webview.JSVerifyHelper", "JSAPISetOAuth, errType[%s], errCode[%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                } else {
                    aoc aoc = ((p) lVar).pRo;
                    aoc.reL = 1;
                    this.qgX.put(aop.rQC + aop.url, aoc);
                }
            }
        }
    }

    private void a(int i, int i2, String str, m mVar) {
        if (mVar == null) {
            x.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIAuth scene is null");
            return;
        }
        int i3 = 0;
        if (!(mVar.bTZ() == null || mVar.bTZ().rQI == null)) {
            i3 = mVar.bTZ().rQI.bMH;
        }
        if (i != 0 || i2 != 0) {
            x.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIAuth netscene error, %s, %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            if (i == 4) {
                mVar.pRl.a(a.qhd, str, null, i2, i3);
            } else {
                mVar.pRl.a(a.qhd, null, null, i2, i3);
            }
        } else if (bi.oW(mVar.pRm)) {
            x.e("MicroMsg.webview.JSVerifyHelper", "scene.jsapi is null or nil.");
            mVar.pRl.a(a.qhd, null, null, i2, i3);
        } else {
            aoe bTZ = mVar.bTZ();
            if (bTZ == null || bTZ.rQI == null) {
                x.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIAuth resp is null");
                mVar.pRl.a(a.qhd, null, null, i2, i3);
            } else if (bTZ.rQI.bMH != 0) {
                x.e("MicroMsg.webview.JSVerifyHelper", "auth jsapi_baseresponse %s, %s", new Object[]{Integer.valueOf(bTZ.rQI.bMH), bTZ.rQI.bMI});
                mVar.pRl.a(a.qhd, bTZ.rQI.bMI, null, i2, i3);
            } else {
                x.i("MicroMsg.webview.JSVerifyHelper", "signature flag : %d.", new Object[]{Integer.valueOf(mVar.bTY() == null ? 0 : mVar.bTY().rQH)});
                if ((mVar.bTY() == null ? 0 : mVar.bTY().rQH) == 1) {
                    if (bTZ.rQL == null) {
                        x.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPI scope_auth_info is null.");
                        mVar.pRl.a(a.qhd, null, null, i2, i3);
                        return;
                    }
                    Iterator it = bTZ.rQL.iterator();
                    while (it.hasNext()) {
                        apd apd = (apd) it.next();
                        if (apd.rRn == null) {
                            x.e("MicroMsg.webview.JSVerifyHelper", "authInfo.apiname is null.");
                        } else {
                            Iterator it2 = apd.rRn.iterator();
                            while (it2.hasNext()) {
                                String str2 = (String) it2.next();
                                if (!bi.oW(str2)) {
                                    aoc aoc = new aoc();
                                    aoc.rQC = str2;
                                    aoc.reL = apd.rRm;
                                    aoc.rQD = apd.mPl;
                                    this.qgX.put(aoc.rQC + mVar.url, aoc);
                                }
                            }
                        }
                    }
                } else if (bTZ.rQJ == null) {
                    x.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIAuth auth_info is null");
                    mVar.pRl.a(a.qhd, "nullAuthInfo", null, i2, i3);
                    return;
                } else {
                    Iterator it3 = bTZ.rQJ.iterator();
                    while (it3.hasNext()) {
                        aoc aoc2 = (aoc) it3.next();
                        if (!bi.oW(aoc2.rQC)) {
                            this.qgX.put(aoc2.rQC + mVar.url, aoc2);
                        }
                    }
                }
                aoc aoc3 = (aoc) this.qgX.get(mVar.pRm + mVar.url);
                if (aoc3 == null) {
                    x.e("MicroMsg.webview.JSVerifyHelper", "The JSAPIAuthInfo is null. (jsapi : %s , url : %s)", new Object[]{mVar.pRm, mVar.url});
                    mVar.pRl.a(a.qhd, null, null, i2, i3);
                } else if (aoc3.reL == 1) {
                    mVar.pRl.a(a.qhc, null, null, i2, i3);
                } else if (this.context == null) {
                    x.e("MicroMsg.webview.JSVerifyHelper", "JSVerify context not activity");
                    a(mVar, i2, aoc3);
                } else {
                    WebViewStubTempUI.a(this.context, this.pRY, bi.oV(aoc3.rQD), "", this.context.getString(R.l.js_oauth_yes), this.context.getString(R.l.js_oauth_no), new 1(this, mVar, i2, aoc3), new 2(this, mVar, i2));
                }
            }
        }
    }

    final void a(m mVar, int i, aoc aoc) {
        aod bTY = mVar.bTY();
        aoe bTZ = mVar.bTZ();
        if (bTY == null) {
            x.e("MicroMsg.webview.JSVerifyHelper", "authReq is null");
            mVar.pRl.a(a.qhd, null, null, i, mVar.bTZ().rQI.bMH);
        } else if (bTZ == null) {
            x.e("MicroMsg.webview.JSVerifyHelper", "authResp is null");
            mVar.pRl.a(a.qhd, null, null, i, mVar.bTZ().rQI.bMH);
        } else {
            au.DF().a(1096, this);
            LinkedList linkedList = bTZ.rQL;
            if (linkedList != null) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    apd apd = (apd) it.next();
                    if (apd != null) {
                        x.i("MicroMsg.webview.JSVerifyHelper", "apiname = %s, scope = %s, scope desc = %s, status = %d, now jsapi name = %s", new Object[]{apd.rRn, apd.scope, apd.mPl, Integer.valueOf(apd.rRm), bTY.rQC});
                        apd.rRm = 1;
                    }
                }
                it = linkedList.iterator();
                while (it.hasNext()) {
                    if (((apd) it.next()) != null) {
                        x.i("MicroMsg.webview.JSVerifyHelper", "apiname = %s, scope = %s, scope desc = %s, status = %d, now jsapi name = %s", new Object[]{((apd) it.next()).rRn, ((apd) it.next()).scope, ((apd) it.next()).mPl, Integer.valueOf(((apd) it.next()).rRm), bTY.rQC});
                    }
                }
            }
            au.DF().a(new p(aoc, bTY.url, bTY.jPc, bTY.rQC, bTY.bJT, bTY.rQE, bTY.signature, bTY.rQF, bTY.rQG, bTY.rQH, linkedList, this.pRn), 0);
            mVar.pRl.a(a.qhc, null, null, i, mVar.bTZ().rQI.bMH);
        }
    }

    static String Dq(String str) {
        int indexOf = str.indexOf("#");
        return indexOf < 0 ? str : str.substring(0, indexOf);
    }
}
