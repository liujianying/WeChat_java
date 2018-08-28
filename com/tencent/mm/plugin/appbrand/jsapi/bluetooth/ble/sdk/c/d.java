package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.c;

import android.os.ParcelUuid;
import android.util.Base64;
import android.util.SparseArray;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.scan.ScanResultCompat;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.smtt.sdk.WebView;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d {
    public int bMF;
    public String byN;
    private JSONObject fMp;
    public SparseArray<byte[]> fMq;
    public List<ParcelUuid> fMr;
    public String fMs;
    public Map<ParcelUuid, byte[]> fMt;
    public String name;

    public d(String str, String str2) {
        this.name = str;
        this.byN = str2;
    }

    public d(ScanResultCompat scanResultCompat) {
        this.name = bi.oV(scanResultCompat.getDevice().getName());
        this.byN = bi.oV(scanResultCompat.getDevice().getAddress());
        this.bMF = scanResultCompat.fNP;
        this.fMq = scanResultCompat.fNO.fNJ;
        this.fMr = scanResultCompat.fNO.fNI;
        this.fMs = bi.oV(scanResultCompat.fNO.fNv);
        this.fMt = scanResultCompat.fNO.fNK;
    }

    public final JSONObject ahS() {
        if (this.fMp == null) {
            this.fMp = new JSONObject();
            this.fMp.put("deviceId", this.byN);
            this.fMp.put("name", this.name);
            this.fMp.put("RSSI", this.bMF);
            byte[] bArr = new byte[0];
            StringBuilder stringBuilder = new StringBuilder();
            if (this.fMq != null && this.fMq.size() >= 0) {
                int i = 0;
                Object obj = bArr;
                while (i < this.fMq.size()) {
                    int keyAt = this.fMq.keyAt(0);
                    Object obj2 = new byte[]{(byte) (keyAt & WebView.NORMAL_MODE_ALPHA), (byte) ((keyAt >> 8) & WebView.NORMAL_MODE_ALPHA)};
                    bArr = (byte[]) this.fMq.valueAt(i);
                    Object obj3 = new byte[((obj.length + 2) + bArr.length)];
                    System.arraycopy(obj, 0, obj3, 0, obj.length);
                    System.arraycopy(obj2, 0, obj3, obj.length, 2);
                    System.arraycopy(bArr, 0, obj3, obj.length + 2, bArr.length);
                    i++;
                    obj = obj3;
                }
                bArr = obj;
            }
            stringBuilder.append(new String(Base64.encode(bArr, 2)));
            this.fMp.put("advertisData", stringBuilder);
            JSONArray jSONArray = new JSONArray();
            if (this.fMr != null) {
                for (ParcelUuid uuid : this.fMr) {
                    jSONArray.put(uuid.getUuid().toString().toUpperCase());
                }
            }
            this.fMp.put("advertisServiceUUIDs", jSONArray);
            this.fMp.put("localName", this.fMs);
            JSONObject jSONObject = new JSONObject();
            if (this.fMt != null && this.fMt.size() > 0) {
                for (ParcelUuid uuid2 : this.fMt.keySet()) {
                    jSONObject.put(uuid2.getUuid().toString().toUpperCase(), new String(Base64.encode((byte[]) this.fMt.get(uuid2), 2)));
                }
            }
            this.fMp.put("serviceData", jSONObject);
        }
        return this.fMp;
    }
}
