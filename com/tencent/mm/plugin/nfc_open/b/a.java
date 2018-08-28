package com.tencent.mm.plugin.nfc_open.b;

import android.content.ComponentName;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.nfc_open.a.b;
import com.tencent.mm.protocal.c.awf;
import com.tencent.mm.protocal.c.kw;
import com.tencent.mm.protocal.c.pl;
import com.tencent.mm.protocal.c.qi;
import com.tencent.mm.protocal.c.qj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;

public final class a implements e {
    public awf lFu;

    public a() {
        init();
    }

    private void init() {
        this.lFu = new awf();
        au.HU();
        String valueOf = String.valueOf(c.DT().get(com.tencent.mm.storage.aa.a.USERINFO_NFC_CPU_CARD_CONFIG_STRING, null));
        if (bi.oW(valueOf)) {
            this.lFu.ruL = new LinkedList();
            this.lFu.lastUpdateTime = 0;
            this.lFu.ruM = 86400;
            this.lFu.version = 0;
            return;
        }
        try {
            this.lFu.aG(valueOf.getBytes("ISO-8859-1"));
        } catch (Exception e) {
            x.w("MicroMsg.CpuCardConfigManager", "parseConfig exp, " + e.getLocalizedMessage());
            this.lFu.ruL = new LinkedList();
            this.lFu.lastUpdateTime = 0;
            this.lFu.ruM = 86400;
            this.lFu.version = 0;
        }
    }

    private void a(awf awf) {
        if (!au.HX()) {
            x.i("MicroMsg.CpuCardConfigManager", "setConfig account not ready");
        } else if (awf != null) {
            x.i("MicroMsg.CpuCardConfigManager", "setConfig config");
            this.lFu = awf;
            try {
                Object str = new String(this.lFu.toByteArray(), "ISO-8859-1");
                au.HU();
                c.DT().a(com.tencent.mm.storage.aa.a.USERINFO_NFC_CPU_CARD_CONFIG_STRING, str);
            } catch (UnsupportedEncodingException e) {
                x.w("MicroMsg.CpuCardConfigManager", "save config exp, " + e.getLocalizedMessage());
            } catch (IOException e2) {
                x.w("MicroMsg.CpuCardConfigManager", "save config exp, " + e2.getLocalizedMessage());
            }
        }
    }

    private awf bju() {
        if (this.lFu == null) {
            init();
        }
        return this.lFu;
    }

    public final void a(int i, int i2, String str, l lVar) {
        au.DF().b(1561, (e) this);
        if (lVar instanceof b) {
            awf bju = bju();
            bju.lastUpdateTime = bi.VE();
            if (i == 0 && i2 == 0) {
                qi qiVar = (qi) ((b) lVar).diG.dIE.dIL;
                if (qiVar != null) {
                    bju.ruM = qiVar.ruM;
                    bju.ruN = qiVar.ruN;
                    au.HU();
                    if (((Integer) c.DT().get(com.tencent.mm.storage.aa.a.USERINFO_NFC_OPEN_SWITCH_INT_SYNC, Integer.valueOf(0))).intValue() == 0) {
                        if (qiVar.ruN == 1) {
                            ad.getContext().getPackageManager().setComponentEnabledSetting(new ComponentName(ad.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 1, 1);
                        } else {
                            ad.getContext().getPackageManager().setComponentEnabledSetting(new ComponentName(ad.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 2, 1);
                        }
                    }
                    au.HU();
                    c.DT().a(com.tencent.mm.storage.aa.a.USERINFO_NFC_OPEN_DEFAULT_SWITCH_INT_SYNC, Integer.valueOf(qiVar.ruN));
                    au.HU();
                    c.DT().a(com.tencent.mm.storage.aa.a.USERINFO_NFC_OPEN_SWITCH_WORDING_STRING_SYNC, qiVar.pjK);
                    if (bju.version != qiVar.version) {
                        bju.version = qiVar.version;
                        if (qiVar.ruL != null && !qiVar.ruL.isEmpty()) {
                            if (bju.ruL == null) {
                                bju.ruL = new LinkedList();
                            } else {
                                bju.ruL.clear();
                            }
                            int i3 = 0;
                            while (true) {
                                int i4 = i3;
                                if (i4 >= qiVar.ruL.size()) {
                                    break;
                                }
                                kw kwVar = new kw();
                                kwVar.qYo = ((kw) qiVar.ruL.get(i4)).qYo;
                                kwVar.rmT = ((kw) qiVar.ruL.get(i4)).rmT;
                                x.d("MicroMsg.CpuCardConfigManager", "nfc-onSceneEnd sflag=" + bi.f(Integer.valueOf(kwVar.rmT)) + ", url=" + bi.oV(kwVar.qYo));
                                if (kwVar.rmS == null) {
                                    kwVar.rmS = new LinkedList();
                                } else {
                                    kwVar.rmS.clear();
                                }
                                i3 = 0;
                                while (true) {
                                    int i5 = i3;
                                    if (i5 >= ((kw) qiVar.ruL.get(i4)).rmS.size()) {
                                        break;
                                    }
                                    qj qjVar = new qj();
                                    if (qjVar.ruO == null) {
                                        qjVar.ruO = new LinkedList();
                                    } else {
                                        qjVar.ruO.clear();
                                    }
                                    i3 = 0;
                                    while (true) {
                                        int i6 = i3;
                                        if (i6 >= ((qj) ((kw) qiVar.ruL.get(i4)).rmS.get(i5)).ruO.size()) {
                                            break;
                                        }
                                        pl plVar = new pl();
                                        plVar.rtL = ((pl) ((qj) ((kw) qiVar.ruL.get(i4)).rmS.get(i5)).ruO.get(i6)).rtL;
                                        plVar.kQE = ((pl) ((qj) ((kw) qiVar.ruL.get(i4)).rmS.get(i5)).ruO.get(i6)).kQE;
                                        x.d("MicroMsg.CpuCardConfigManager", "nfc-onSceneEnd cmd=" + bi.oV(plVar.rtL) + ", answer=" + bi.oV(plVar.kQE));
                                        qjVar.ruO.add(plVar);
                                        i3 = i6 + 1;
                                    }
                                    kwVar.rmS.add(qjVar);
                                    i3 = i5 + 1;
                                }
                                bju.ruL.add(kwVar);
                                i3 = i4 + 1;
                            }
                        } else {
                            bju.ruL.clear();
                        }
                    } else {
                        x.i("MicroMsg.CpuCardConfigManager", "nfc-onSceneEnd no config change return version = " + qiVar.version);
                        a(bju);
                        return;
                    }
                }
            }
            a(bju);
        }
    }
}
