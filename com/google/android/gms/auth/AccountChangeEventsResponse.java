package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.w;
import java.util.List;

public class AccountChangeEventsResponse implements SafeParcelable {
    public static final Creator<AccountChangeEventsResponse> CREATOR = new g();
    final int aIs;
    final List<AccountChangeEvent> aIz;

    AccountChangeEventsResponse(int i, List<AccountChangeEvent> list) {
        this.aIs = i;
        this.aIz = (List) w.ah(list);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        g.a(this, parcel);
    }
}
