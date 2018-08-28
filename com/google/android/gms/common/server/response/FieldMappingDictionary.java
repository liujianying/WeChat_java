package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FieldMappingDictionary implements SafeParcelable {
    public static final c CREATOR = new c();
    final HashMap<String, Map<String, Field<?, ?>>> aPf;
    private final ArrayList<Entry> aPg = null;
    final String aPh;
    final int mVersionCode;

    FieldMappingDictionary(int i, ArrayList<Entry> arrayList, String str) {
        this.mVersionCode = i;
        this.aPf = c(arrayList);
        this.aPh = (String) w.ah(str);
        pD();
    }

    private static HashMap<String, Map<String, Field<?, ?>>> c(ArrayList<Entry> arrayList) {
        HashMap<String, Map<String, Field<?, ?>>> hashMap = new HashMap();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Entry entry = (Entry) arrayList.get(i);
            hashMap.put(entry.className, entry.pE());
        }
        return hashMap;
    }

    private void pD() {
        for (String str : this.aPf.keySet()) {
            Map map = (Map) this.aPf.get(str);
            for (String str2 : map.keySet()) {
                ((Field) map.get(str2)).aPd = this;
            }
        }
    }

    public final Map<String, Field<?, ?>> bj(String str) {
        return (Map) this.aPf.get(str);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : this.aPf.keySet()) {
            stringBuilder.append(str).append(":\n");
            Map map = (Map) this.aPf.get(str);
            for (String str2 : map.keySet()) {
                stringBuilder.append("  ").append(str2).append(": ");
                stringBuilder.append(map.get(str2));
            }
        }
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        c.a(this, parcel);
    }
}
