package com.tencent.mm.plugin.report.service;

import com.tencent.mars.BaseEvent;
import com.tencent.mars.smc.IDKey;
import com.tencent.mars.smc.SmcLogic;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.lw;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

public enum h implements d {
    ;
    
    private long mEK;
    private int mEL;
    private HashMap<String, Long> mEM;
    private int mEN;
    private int mEO;
    private long mEP;
    private volatile boolean mEQ;
    private int uin;

    private h(String str) {
        this.mEK = 0;
        if (ad.cic()) {
            g.Em().H(new Runnable() {
                public final void run() {
                    h.a(h.this);
                }
            });
            final Runnable anonymousClass2 = new Runnable() {
                public final void run() {
                    h.b(h.this);
                }
            };
            a.sFg.a(new c<lw>() {
                public final /* synthetic */ boolean a(b bVar) {
                    if (h.this.mEP <= 0) {
                        Object obj = g.Ei().DT().get(aa.a.USERINFO_CLOG_SAMPLING_REFRESH_TIME_LONG, null);
                        if (obj != null && (obj instanceof Long)) {
                            h.this.mEP = ((Long) obj).longValue();
                        }
                    }
                    if (h.this.mEQ || System.currentTimeMillis() - h.this.mEP > 86400000) {
                        g.Em().h(anonymousClass2, 100);
                    }
                    return true;
                }
            });
            g.DF().a((int) HardCoderJNI.SCENE_SNS_SCROLL, new e() {
                public final void a(int i, int i2, String str, l lVar) {
                    if (i == 0) {
                        g.Em().h(anonymousClass2, 5000);
                    }
                }
            });
        }
    }

    public static Object a(int i, int[] iArr, int i2, int i3) {
        return f.a(i, iArr, i2, i3);
    }

    private static void g(int i, String str, boolean z) {
        KVReportDataInfo kVReportDataInfo = new KVReportDataInfo();
        kVReportDataInfo.mEv = (long) i;
        kVReportDataInfo.value = str;
        kVReportDataInfo.mDZ = false;
        kVReportDataInfo.mEw = z;
        KVCommCrossProcessReceiver.a(kVReportDataInfo);
    }

    public final void k(int i, String str) {
        if (com.tencent.mm.plugin.report.a.c.mDC) {
            a(i, str, com.tencent.mm.plugin.report.a.c.mDD, com.tencent.mm.plugin.report.a.c.mDD);
        } else {
            a(i, str, false, false);
        }
    }

    public final void a(int i, String str, boolean z, boolean z2) {
        if (!ad.cic()) {
            g(i, str, z);
        } else if (com.tencent.mm.plugin.report.a.c.mDC) {
            e.a((long) i, str, com.tencent.mm.plugin.report.a.c.mDD, com.tencent.mm.plugin.report.a.c.mDD);
        } else {
            e.a((long) i, str, z, false);
        }
    }

    public final void h(int i, Object... objArr) {
        if (com.tencent.mm.plugin.report.a.c.mDC) {
            a(i, com.tencent.mm.plugin.report.a.c.mDD, com.tencent.mm.plugin.report.a.c.mDD, objArr);
        } else {
            a(i, false, false, objArr);
        }
    }

    public final void a(int i, boolean z, boolean z2, Object... objArr) {
        String str;
        if (objArr == null || objArr.length <= 0) {
            x.w("MicroMsg.ReportManagerKvCheck", "vals is null, use '' as value");
            str = "";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            int length = objArr.length - 1;
            for (int i2 = 0; i2 < length; i2++) {
                stringBuilder.append(String.valueOf(objArr[i2]).replace(',', ' ')).append(',');
            }
            stringBuilder.append(String.valueOf(objArr[length]));
            str = stringBuilder.toString();
        }
        if (com.tencent.mm.sdk.a.b.chp()) {
            x.v("MicroMsg.ReportManagerKvCheck", "kvTypedStat id:%d [%b,%b] val:%s", Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(false), str);
        }
        if (ad.cic()) {
            e.a((long) i, str, z, false);
        } else {
            g(i, str, z);
        }
    }

    public final boolean c(int i, com.tencent.mm.bk.a aVar) {
        try {
            aVar.getClass().getField("import_ds_").setInt(aVar, Integer.MAX_VALUE);
            long VF = bi.VF();
            if (VF / TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC != this.mEK) {
                try {
                    this.mEL = bi.getInt(new SimpleDateFormat("yyyyMMdd").format(new Date()), 0);
                } catch (Exception e) {
                }
            }
            aVar.getClass().getField("ds_").setInt(aVar, this.mEL);
            aVar.getClass().getField("uin_").setLong(aVar, ((long) this.uin) & 4294967295L);
            aVar.getClass().getField("device_").setInt(aVar, 2);
            aVar.getClass().getField("clientVersion_").setInt(aVar, com.tencent.mm.protocal.d.qVN);
            aVar.getClass().getField("time_stamp_").setLong(aVar, VF);
            try {
                byte[] toByteArray = aVar.toByteArray();
                if (!ad.cic()) {
                    x.f("MicroMsg.ReportManagerKvCheck", "not in MM Process");
                    return true;
                } else if (com.tencent.mm.plugin.report.a.c.mDC) {
                    e.a((long) i, toByteArray, com.tencent.mm.plugin.report.a.c.mDD, com.tencent.mm.plugin.report.a.c.mDD);
                    return true;
                } else {
                    e.a((long) i, toByteArray, false, false);
                    return true;
                }
            } catch (IOException e2) {
                x.e("MicroMsg.ReportManagerKvCheck", "pbKVStat LocalReportPb error, %d, %s", Integer.valueOf(i), e2.toString());
                return false;
            }
        } catch (Exception e3) {
            x.e("MicroMsg.ReportManagerKvCheck", "pbKVStat  set values error, %d, %s", Integer.valueOf(i), e3.toString());
            return false;
        }
    }

    public static void e(int i, List<String> list) {
        if (com.tencent.mm.plugin.report.a.c.mDC) {
            b(i, list, com.tencent.mm.plugin.report.a.c.mDD);
        } else {
            b(i, list, false);
        }
    }

    private static void b(int i, List<String> list, boolean z) {
        String str;
        if (list == null || list.isEmpty()) {
            x.w("MicroMsg.ReportManagerKvCheck", "vals is null, use '' as value");
            str = "";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            int size = list.size() - 1;
            for (int i2 = 0; i2 < size; i2++) {
                stringBuilder.append((String) list.get(i2)).append(',');
            }
            stringBuilder.append((String) list.get(size));
            str = stringBuilder.toString();
        }
        if (ad.cic()) {
            e.a((long) i, str, z, false);
        } else {
            g(i, str, z);
        }
    }

    public final void e(long j, long j2, long j3) {
        a(j, j2, j3, false);
    }

    public final void a(long j, long j2, long j3, boolean z) {
        if (j < 0 || j2 < 0 || j3 <= 0) {
            x.e("MicroMsg.ReportManagerKvCheck", "ID %d, key %d, value %d <0", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3));
        } else if (ad.cic()) {
            e.b(j, j2, j3, false);
        } else {
            StIDKeyDataInfo stIDKeyDataInfo = new StIDKeyDataInfo();
            stIDKeyDataInfo.mFa = j;
            stIDKeyDataInfo.key = j2;
            stIDKeyDataInfo.value = j3;
            stIDKeyDataInfo.mDZ = false;
            KVCommCrossProcessReceiver.a(stIDKeyDataInfo);
        }
    }

    public final void b(ArrayList<IDKey> arrayList, boolean z) {
        if (arrayList == null) {
            x.e("MicroMsg.ReportManagerKvCheck", "report idkeyGroupStat lstIdKeyDataInfos == null return");
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            IDKey iDKey = (IDKey) it.next();
            if (iDKey == null) {
                x.e("MicroMsg.ReportManagerKvCheck", "report idkeyGroupStat info == null return");
                return;
            } else if (iDKey.GetID() < 0 || iDKey.GetKey() < 0) {
                x.e("MicroMsg.ReportManagerKvCheck", "report idkeyGroupStat ID %d, key %d, value %d <0", Long.valueOf(iDKey.GetID()), Long.valueOf(iDKey.GetKey()), Long.valueOf(iDKey.GetValue()));
                return;
            } else if (iDKey.GetValue() <= 0) {
                x.e("MicroMsg.ReportManagerKvCheck", "report idkeyGroupStat ID %d, key %d, value %d <0", Long.valueOf(iDKey.GetID()), Long.valueOf(iDKey.GetKey()), Long.valueOf(iDKey.GetValue()));
                return;
            }
        }
        if (ad.cic()) {
            e.c(arrayList, false);
        } else {
            KVCommCrossProcessReceiver.K(arrayList);
        }
    }

    public final void a(int i, int i2, int i3, int i4, int i5, int i6, boolean z) {
        IDKey iDKey = new IDKey();
        iDKey.SetID(i);
        iDKey.SetKey(i3);
        iDKey.SetValue((long) i5);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(i2);
        iDKey2.SetKey(i4);
        iDKey2.SetValue((long) i6);
        ArrayList arrayList = new ArrayList();
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        b(arrayList, z);
    }

    public final void e(int i, int i2, int i3, int i4, boolean z) {
        IDKey iDKey = new IDKey();
        iDKey.SetID(i);
        iDKey.SetKey(i2);
        iDKey.SetValue((long) i4);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(i);
        iDKey2.SetKey(i3);
        iDKey2.SetValue(1);
        ArrayList arrayList = new ArrayList();
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        b(arrayList, false);
    }

    public final void U(int i, int i2, int i3) {
        IDKey iDKey = new IDKey();
        iDKey.SetID(i);
        iDKey.SetKey(i2);
        iDKey.SetValue(1);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(i);
        iDKey2.SetKey(i3);
        iDKey2.SetValue(1);
        ArrayList arrayList = new ArrayList();
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        b(arrayList, false);
    }

    public static void brU() {
        if (ad.cic()) {
            BaseEvent.onSingalCrash(0);
        } else {
            KVCommCrossProcessReceiver.brO();
        }
    }

    public final void ep(String str, String str2) {
        c(str, str2, null);
    }

    public final void c(String str, final String str2, final Map<String, Object> map) {
        a(str, new Callable<JSONArray>() {
            public final /* synthetic */ Object call() {
                return new JSONArray().put((map == null ? new JSONObject() : new JSONObject(map)).put("info", str2));
            }
        });
    }

    public final void n(String str, final List<String> list) {
        a(str, new Callable<JSONArray>() {
            public final /* synthetic */ Object call() {
                JSONArray jSONArray = new JSONArray();
                for (String put : list) {
                    jSONArray.put(new JSONObject().put("info", put));
                }
                return jSONArray;
            }
        });
    }

    private void a(String str, Callable<JSONArray> callable) {
        Long l;
        Object obj;
        final long currentTimeMillis = System.currentTimeMillis();
        if (this.mEM != null) {
            l = (Long) this.mEM.get(str);
        } else {
            l = null;
        }
        if (l != null) {
            byte[] v = com.tencent.mm.a.g.v((str + this.uin + currentTimeMillis).getBytes());
            if (v != null && v.length == 16) {
                String str2;
                long j = (((((long) (((v[0] + v[4]) + v[8]) + v[12])) & 255) | ((((long) (((v[1] + v[5]) + v[9]) + v[13])) & 255) << 8)) | ((((long) (((v[2] + v[6]) + v[10]) + v[14])) & 255) << 16)) | ((((long) (v[15] + ((v[3] + v[7]) + v[11]))) & 255) << 24);
                if (j < l.longValue()) {
                    obj = 1;
                } else {
                    obj = null;
                }
                String str3 = "MicroMsg.cLog";
                String str4 = "[%s] Sampling %s: 0x%08x / 0x%08x";
                Object[] objArr = new Object[4];
                objArr[0] = str;
                if (obj != null) {
                    str2 = "hit";
                } else {
                    str2 = "miss";
                }
                objArr[1] = str2;
                objArr[2] = Long.valueOf(j);
                objArr[3] = l;
                x.d(str3, str4, objArr);
                if (obj == null) {
                    final Callable<JSONArray> callable2 = callable;
                    str3 = str;
                    com.tencent.mm.sdk.f.e.post(new Runnable() {
                        public final void run() {
                            int Df;
                            String str;
                            int i;
                            String str2 = null;
                            if (ad.cic() && g.Eg().Dx()) {
                                g.Eg();
                                Df = com.tencent.mm.kernel.a.Df();
                                if (g.Ei().DT() != null) {
                                    str2 = q.GF();
                                }
                                str = str2;
                                i = Df;
                            } else {
                                str = null;
                                i = 0;
                            }
                            try {
                                String string = ad.getContext().getSharedPreferences("system_config_prefs", 0).getString("support.weixin.qq.com", "support.weixin.qq.com");
                                JSONArray jSONArray = (JSONArray) callable2.call();
                                int length = jSONArray.length();
                                for (Df = 0; Df < length; Df++) {
                                    JSONObject jSONObject = jSONArray.getJSONObject(Df);
                                    jSONObject.put("tag", str3);
                                    jSONObject.put("uin", i);
                                }
                                byte[] bytes = new JSONObject().put("head", new JSONObject().put("protocol_ver", 1).put("phone", com.tencent.mm.protocal.d.DEVICE_NAME).put("os_ver", com.tencent.mm.protocal.d.DEVICE_TYPE).put("report_time", currentTimeMillis).put("revision", bi.oV(com.tencent.mm.sdk.platformtools.d.REV))).put("items", jSONArray).toString().getBytes();
                                String toLowerCase = com.tencent.mm.a.g.u(String.format("weixin#$()%d%d", new Object[]{Integer.valueOf(com.tencent.mm.protocal.d.qVN), Integer.valueOf(bytes.length)}).getBytes()).toLowerCase();
                                bytes = com.tencent.mm.a.q.r(bytes);
                                PByteArray pByteArray = new PByteArray();
                                com.tencent.mm.a.c.a(pByteArray, bytes, toLowerCase.getBytes());
                                StringBuilder append = new StringBuilder(256).append("http://").append(string).append("/cgi-bin/mmsupport-bin/stackreport?version=").append(Integer.toHexString(com.tencent.mm.protocal.d.qVN)).append("&devicetype=").append(com.tencent.mm.protocal.d.DEVICE_TYPE).append("&filelength=").append(Df).append("&sum=").append(toLowerCase).append("&reporttype=1&NewReportType=110");
                                if (!(str == null || str.length() == 0)) {
                                    append.append("&username=").append(str);
                                }
                                if (i != 0) {
                                    append.append("&uin=").append(i);
                                }
                                str2 = append.toString();
                                HttpClient defaultHttpClient = new DefaultHttpClient();
                                HttpUriRequest httpPost = new HttpPost(str2);
                                HttpEntity byteArrayEntity = new ByteArrayEntity(pByteArray.value);
                                byteArrayEntity.setContentType("binary/octet-stream");
                                httpPost.setEntity(byteArrayEntity);
                                x.i("MicroMsg.cLog", "POST returned: " + bi.convertStreamToString(defaultHttpClient.execute(httpPost).getEntity().getContent()));
                            } catch (Throwable e) {
                                x.printErrStackTrace("MicroMsg.ReportManagerKvCheck", e, "Failed to upload cLog.", new Object[0]);
                            }
                        }
                    }, "ReportManager_cLog");
                }
            }
        }
        x.d("MicroMsg.cLog", "[%s] Sampling hit: (default)", str);
        obj = 1;
        if (obj == null) {
            final Callable<JSONArray> callable22 = callable;
            str3 = str;
            com.tencent.mm.sdk.f.e.post(/* anonymous class already generated */, "ReportManager_cLog");
        }
    }

    public final void eK(int i) {
        this.uin = i;
        SmcLogic.setUin((long) i);
    }
}
