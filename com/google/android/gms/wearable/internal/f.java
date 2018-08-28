package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.g;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public final class f extends com.google.android.gms.common.data.f implements com.google.android.gms.wearable.f {
    private final int beK;

    public f(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.beK = i2;
    }

    public final /* synthetic */ Object freeze() {
        return new d(this);
    }

    public final byte[] getData() {
        return getByteArray("data");
    }

    public final Uri getUri() {
        return Uri.parse(getString("path"));
    }

    public final Map<String, g> rQ() {
        Map<String, g> hashMap = new HashMap(this.beK);
        for (int i = 0; i < this.beK; i++) {
            c cVar = new c(this.aMb, this.aMx + i);
            if (cVar.getString("asset_key") != null) {
                hashMap.put(cVar.getString("asset_key"), cVar);
            }
        }
        return hashMap;
    }

    public final String toString() {
        boolean isLoggable = Log.isLoggable("DataItem", 3);
        byte[] byteArray = getByteArray("data");
        Map rQ = rQ();
        StringBuilder stringBuilder = new StringBuilder("DataItemInternal{ ");
        stringBuilder.append("uri=" + getUri());
        stringBuilder.append(", dataSz=" + (byteArray == null ? "null" : Integer.valueOf(byteArray.length)));
        stringBuilder.append(", numAssets=" + rQ.size());
        if (isLoggable && !rQ.isEmpty()) {
            stringBuilder.append(", assets=[");
            String str = "";
            Iterator it = rQ.entrySet().iterator();
            while (true) {
                String str2 = str;
                if (!it.hasNext()) {
                    break;
                }
                Entry entry = (Entry) it.next();
                stringBuilder.append(str2 + ((String) entry.getKey()) + ": " + ((g) entry.getValue()).getId());
                str = ", ";
            }
            stringBuilder.append("]");
        }
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }
}
