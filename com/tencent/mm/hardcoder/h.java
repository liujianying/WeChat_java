package com.tencent.mm.hardcoder;

import android.os.Build;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class h implements com.tencent.mm.hardcoder.g.a {
    public static int dlm = -1;
    public static int dln = -1;
    final Map<Integer, a> dlk = new TreeMap();
    private int dll = 0;

    public static class a {
        public final Map<Long, Integer> dlq = new TreeMap();
    }

    public final void initialize() {
        this.dlk.clear();
        try {
            String str = Build.MODEL;
            if (str != null) {
                Iterator keys;
                x.i("MicroMsg.PowerConsumption", "[oneliang] device model:%s", str);
                str = str.toUpperCase();
                InputStream open = ad.getContext().getAssets().open("hardcoder/power.json");
                final StringBuilder stringBuilder = new StringBuilder();
                g.a(open, new com.tencent.mm.hardcoder.g.a() {
                    public final boolean fx(String str) {
                        stringBuilder.append(str);
                        return true;
                    }
                });
                JSONObject jSONObject = new JSONObject(stringBuilder.toString());
                if (jSONObject.has(str)) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(str);
                    keys = jSONObject2.keys();
                    int i = 0;
                    while (keys.hasNext()) {
                        keys.next();
                        i++;
                    }
                    int i2 = 0;
                    while (i2 < i && jSONObject2.has("cluster" + i2)) {
                        JSONArray jSONArray = jSONObject2.getJSONArray("cluster" + i2);
                        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                            fx(jSONArray.getString(i3));
                        }
                        this.dll = this.dlk.size();
                        switch (i2) {
                            case 0:
                                dlm = this.dll - 1;
                                break;
                            case 1:
                                dln = this.dll - 1;
                                break;
                            default:
                                break;
                        }
                        i2++;
                    }
                }
                x.i("MicroMsg.PowerConsumption", "[oneliang] cluster0:%s,cluster1:%s", Integer.valueOf(dlm), Integer.valueOf(dln));
                for (Entry entry : this.dlk.entrySet()) {
                    x.i("MicroMsg.PowerConsumption", "config cpu:" + entry.getKey());
                    for (Entry entry2 : ((a) entry2.getValue()).dlq.entrySet()) {
                        x.i("MicroMsg.PowerConsumption", entry2.getKey() + "," + entry2.getValue());
                    }
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.PowerConsumption", "initialize exception:" + e.getMessage());
        }
    }

    public final boolean fx(String str) {
        String[] split = str.trim().split(",");
        if (split.length > 0) {
            long j = bi.getLong(split[0], 0);
            for (int i = 1; i < split.length; i++) {
                a aVar;
                Integer valueOf = Integer.valueOf((this.dll + i) - 1);
                if (this.dlk.containsKey(valueOf)) {
                    aVar = (a) this.dlk.get(valueOf);
                } else {
                    aVar = new a();
                    this.dlk.put(valueOf, aVar);
                }
                aVar.dlq.put(Long.valueOf(j), Integer.valueOf(bi.getInt(split[i], 0)));
            }
        }
        return true;
    }
}
