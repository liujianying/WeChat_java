package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class StringToIntConverter implements SafeParcelable, a<String, Integer> {
    public static final b CREATOR = new b();
    final HashMap<String, Integer> aOQ;
    private final HashMap<Integer, String> aOR;
    private final ArrayList<Entry> aOS;
    final int mVersionCode;

    public StringToIntConverter() {
        this.mVersionCode = 1;
        this.aOQ = new HashMap();
        this.aOR = new HashMap();
        this.aOS = null;
    }

    StringToIntConverter(int i, ArrayList<Entry> arrayList) {
        this.mVersionCode = i;
        this.aOQ = new HashMap();
        this.aOR = new HashMap();
        this.aOS = null;
        b(arrayList);
    }

    private void b(ArrayList<Entry> arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            String str = entry.aOT;
            int i = entry.aOU;
            this.aOQ.put(str, Integer.valueOf(i));
            this.aOR.put(Integer.valueOf(i), str);
        }
    }

    public final /* synthetic */ Object convertBack(Object obj) {
        String str = (String) this.aOR.get((Integer) obj);
        return (str == null && this.aOQ.containsKey("gms_unknown")) ? "gms_unknown" : str;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        b.a(this, parcel);
    }
}
