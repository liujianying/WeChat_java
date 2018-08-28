package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.wearable.f;
import com.google.android.gms.wearable.g;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public final class d implements f {
    private Uri aMJ;
    private byte[] bdf;
    private Map<String, g> ber;

    public d(f fVar) {
        this.aMJ = fVar.getUri();
        this.bdf = fVar.getData();
        Map hashMap = new HashMap();
        for (Entry entry : fVar.rQ().entrySet()) {
            if (entry.getKey() != null) {
                hashMap.put(entry.getKey(), ((g) entry.getValue()).freeze());
            }
        }
        this.ber = Collections.unmodifiableMap(hashMap);
    }

    public final /* synthetic */ Object freeze() {
        return this;
    }

    public final byte[] getData() {
        return this.bdf;
    }

    public final Uri getUri() {
        return this.aMJ;
    }

    public final Map<String, g> rQ() {
        return this.ber;
    }

    public final String toString() {
        boolean isLoggable = Log.isLoggable("DataItem", 3);
        StringBuilder stringBuilder = new StringBuilder("DataItemEntity{ ");
        stringBuilder.append("uri=" + this.aMJ);
        stringBuilder.append(", dataSz=" + (this.bdf == null ? "null" : Integer.valueOf(this.bdf.length)));
        stringBuilder.append(", numAssets=" + this.ber.size());
        if (isLoggable && !this.ber.isEmpty()) {
            stringBuilder.append(", assets=[");
            String str = "";
            Iterator it = this.ber.entrySet().iterator();
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
