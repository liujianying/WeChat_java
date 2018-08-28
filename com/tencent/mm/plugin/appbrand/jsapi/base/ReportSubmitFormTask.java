package com.tencent.mm.plugin.appbrand.jsapi.base;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.v;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.protocal.c.chu;
import com.tencent.mm.protocal.c.ge;
import com.tencent.mm.protocal.c.gf;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public class ReportSubmitFormTask extends MainProcessTask {
    public static final Creator<ReportSubmitFormTask> CREATOR = new 2();
    public String appId;
    public int bGF;
    public String bVs;
    public int cbu;
    public String fKK;
    public int type;

    static /* synthetic */ void u(LinkedList linkedList) {
        linkedList.addAll(aim());
        JSONArray jSONArray = new JSONArray();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            chu chu = (chu) it.next();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(DownloadSettingTable$Columns.TYPE, chu.type);
                jSONObject.put("appid", chu.bPS);
                jSONObject.put("formid", chu.sBN);
                jSONObject.put("pageid", chu.sBO);
                jSONObject.put("appstate", chu.sBP);
                jSONObject.put("appversion", chu.sBQ);
                jSONArray.put(jSONObject);
            } catch (Exception e) {
                x.e("MicroMsg.ReportSubmitFormTask", e.getMessage());
            }
        }
        g.Ei().DT().a(a.sUv, jSONArray.toString());
    }

    public ReportSubmitFormTask(AppBrandSysConfig appBrandSysConfig) {
        this.appId = appBrandSysConfig.appId;
        this.bGF = appBrandSysConfig.frm.fih;
        this.cbu = appBrandSysConfig.frm.fii;
    }

    public final void aai() {
        b.a aVar = new b.a();
        aVar.dIG = new ge();
        aVar.dIH = new gf();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxausrevent/batchrecordwxatemplatemsgevent";
        aVar.dIF = 1129;
        b KT = aVar.KT();
        final ge geVar = (ge) KT.dID.dIL;
        geVar.rgJ = new LinkedList();
        chu chu = new chu();
        chu.type = this.type;
        chu.bPS = this.appId;
        chu.sBN = this.fKK;
        chu.sBO = this.bVs;
        chu.sBP = this.bGF;
        chu.sBQ = this.cbu;
        geVar.rgJ.add(chu);
        synchronized (getClass()) {
            geVar.rgJ.addAll(aim());
        }
        v.a(KT, new v.a() {
            public final int a(int i, int i2, String str, b bVar, l lVar) {
                if (!(i == 0 && i2 == 0)) {
                    synchronized (ReportSubmitFormTask.this.getClass()) {
                        ReportSubmitFormTask.u(geVar.rgJ);
                    }
                    x.e("MicroMsg.ReportSubmitFormTask", "Error: %d, %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                }
                return 0;
            }
        });
    }

    private static LinkedList<chu> aim() {
        LinkedList<chu> linkedList = new LinkedList();
        try {
            JSONArray jSONArray = new JSONArray((String) g.Ei().DT().get(a.sUv, null));
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                chu chu = new chu();
                chu.type = jSONObject.getInt(DownloadSettingTable$Columns.TYPE);
                chu.bPS = jSONObject.getString("appid");
                chu.sBN = jSONObject.getString("formid");
                chu.sBO = jSONObject.getString("pageid");
                chu.sBP = jSONObject.getInt("appstate");
                chu.sBQ = jSONObject.getInt("appversion");
                linkedList.add(chu);
            }
        } catch (Exception e) {
            x.e("MicroMsg.ReportSubmitFormTask", e.getMessage());
        }
        g.Ei().DT().a(a.sUv, "");
        return linkedList;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.type);
        parcel.writeString(this.appId);
        parcel.writeString(this.fKK);
        parcel.writeString(this.bVs);
        parcel.writeInt(this.bGF);
        parcel.writeInt(this.cbu);
    }

    public final void g(Parcel parcel) {
        this.type = parcel.readInt();
        this.appId = parcel.readString();
        this.fKK = parcel.readString();
        this.bVs = parcel.readString();
        this.bGF = parcel.readInt();
        this.cbu = parcel.readInt();
    }
}
