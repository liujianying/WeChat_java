package com.tencent.mm.plugin.sns.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.LinkedList;
import java.util.List;

public class SnsCmdList implements Parcelable {
    public static final Creator<SnsCmdList> CREATOR = new 1();
    private int nkL = 0;
    private int nkM = 0;
    public List<Integer> nkN = new LinkedList();
    public List<Integer> nkO = new LinkedList();

    public final void wj(int i) {
        this.nkN.add(Integer.valueOf(i));
    }

    public final void wk(int i) {
        this.nkO.add(Integer.valueOf(i));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 0;
        this.nkL = this.nkN.size();
        parcel.writeInt(this.nkL);
        for (int i3 = 0; i3 < this.nkL; i3++) {
            parcel.writeInt(((Integer) this.nkN.get(i3)).intValue());
        }
        this.nkM = this.nkO.size();
        parcel.writeInt(this.nkM);
        while (i2 < this.nkM) {
            parcel.writeInt(((Integer) this.nkO.get(i2)).intValue());
            i2++;
        }
    }
}
