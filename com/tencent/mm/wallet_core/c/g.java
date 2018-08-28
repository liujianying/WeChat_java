package com.tencent.mm.wallet_core.c;

import com.tencent.mm.a.o;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.kernel.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.tenpay.model.i;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class g extends i {
    public boolean caB = true;
    private int uXb = 0;
    private a uXc = null;

    private static void aA(Map<String, String> map) {
        int i;
        int i2 = 1;
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eg();
        String string = o.getString(a.Df());
        String deviceID = q.getDeviceID(ad.getContext());
        byte[] bArr = new byte[16];
        byte[] bytes = o.cDa().getBytes();
        if (bytes == null || bytes.length <= 0) {
            bytes = (System.currentTimeMillis()).getBytes();
        }
        int i3 = 0;
        int i4 = 0;
        do {
            bArr[i4] = bytes[i3];
            i4++;
            i3++;
            if (i3 >= bytes.length) {
                i3 = 0;
                continue;
            }
        } while (i4 < 16);
        String str = new String(bArr);
        String ce = ac.ce(string + deviceID);
        String ce2 = ac.ce(string + ce + new String(bArr));
        x.i("MicroMsg.NetSceneGendigitalcert", "salt " + new String(bArr));
        x.i("MicroMsg.NetSceneGendigitalcert", "crt_csr uin: %s: devideid: %s crt: %s", new Object[]{string, deviceID, ce2});
        a cCW = a.cCW();
        b.cCO();
        c fJ = com.tencent.mm.model.c.c.Jx().fJ("100369");
        if (fJ.isValid() && "1".equals(fJ.ckq().get("open"))) {
            i = 1;
        } else {
            i = 0;
        }
        x.d("MicroMsg.TenPaySdkAbTest", "isCertOpen2048 %s", new Object[]{Integer.valueOf(i)});
        if ((i > 0 ? 1 : 0) == 0) {
            i2 = 0;
        }
        String dw = cCW.dw(ce2, i2);
        try {
            map.put("sn_salt", p.encode(str));
            map.put("crt_csr", p.encode(dw));
            map.put("crt_device_id", ce);
            map.put("device_os", d.DEVICE_TYPE);
            map.put("device_name", d.qVK);
        } catch (Exception e) {
        }
    }

    public g(String str, int i, String str2) {
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        this.uXb = 1;
        aA(hashMap);
        hashMap.put(DownloadSettingTable$Columns.TYPE, p.encode("1"));
        hashMap.put("true_name", p.encode(str2));
        hashMap.put("id_no", p.encode(str));
        hashMap.put("id_type", p.encode(String.valueOf(i)));
        F(hashMap);
        aC(hashMap2);
    }

    public g(String str, String str2, a aVar, boolean z) {
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        this.caB = z;
        this.uXb = 2;
        aA(hashMap);
        hashMap.put(DownloadSettingTable$Columns.TYPE, p.encode("2"));
        hashMap.put("crt_sms", p.encode(str));
        hashMap.put("reqkey", p.encode(str2));
        this.uXc = aVar;
        F(hashMap);
        aC(hashMap2);
    }

    public g(String str, String str2, String str3, a aVar, boolean z) {
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        this.uXb = 4;
        this.uXc = aVar;
        this.caB = z;
        aA(hashMap);
        hashMap.put(DownloadSettingTable$Columns.TYPE, p.encode("4"));
        hashMap.put("id_type", p.encode(str));
        hashMap.put("cre_tail", p.encode(str2));
        hashMap.put("reqkey", p.encode(str3));
        F(hashMap);
        aC(hashMap2);
    }

    public final int aBO() {
        return 1580;
    }

    public final int If() {
        return 1580;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/gendigitalcert";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.i("MicroMsg.NetSceneGendigitalcert", "errCode %d errMsg %s", new Object[]{Integer.valueOf(i), str});
        try {
            String optString = jSONObject.optString("crt_crt");
            String optString2 = jSONObject.optString("crt_no");
            h.mEJ.a(414, 0, 1, true);
            boolean importCert = a.cCW().importCert(optString2, optString);
            s.abU(optString2);
            if (importCert) {
                h.mEJ.a(414, 1, 1, true);
                x.i("MicroMsg.NetSceneGendigitalcert", "importCert crt_crt success");
            } else {
                h.mEJ.a(414, 2, 1, true);
                x.e("MicroMsg.NetSceneGendigitalcert", "importCert crt_crt fail");
            }
            if (this.uXb == 1) {
                h.mEJ.h(13731, new Object[]{Integer.valueOf(3)});
            } else if (this.uXb == 2) {
                h.mEJ.h(13731, new Object[]{Integer.valueOf(7)});
            }
            x.i("MicroMsg.NetSceneGendigitalcert", "_crt_crt %s _crt_no %s", new Object[]{ac.ce(optString), optString2});
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetSceneGendigitalcert", e, "", new Object[0]);
        }
    }

    public final void a(c cVar, JSONObject jSONObject) {
        a.cCW().cCX();
        if (cVar.errCode != 0) {
            if (this.uXb == 1) {
                h.mEJ.h(13731, new Object[]{Integer.valueOf(4)});
            } else if (this.uXb == 2) {
                h.mEJ.h(13731, new Object[]{Integer.valueOf(8)});
            }
        }
        if (this.uXc == null) {
            return;
        }
        if (!this.caB || cVar.errCode == 0) {
            this.uXc.bQG();
        }
    }

    public final boolean bkU() {
        return this.caB;
    }
}
