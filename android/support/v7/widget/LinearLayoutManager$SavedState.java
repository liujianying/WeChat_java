package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class LinearLayoutManager$SavedState implements Parcelable {
    public static final Creator<LinearLayoutManager$SavedState> CREATOR = new 1();
    int PA;
    int PB;
    boolean PC;

    LinearLayoutManager$SavedState(Parcel parcel) {
        boolean z = true;
        this.PA = parcel.readInt();
        this.PB = parcel.readInt();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.PC = z;
    }

    public LinearLayoutManager$SavedState(LinearLayoutManager$SavedState linearLayoutManager$SavedState) {
        this.PA = linearLayoutManager$SavedState.PA;
        this.PB = linearLayoutManager$SavedState.PB;
        this.PC = linearLayoutManager$SavedState.PC;
    }

    final boolean fl() {
        return this.PA >= 0;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.PA);
        parcel.writeInt(this.PB);
        parcel.writeInt(this.PC ? 1 : 0);
    }
}
