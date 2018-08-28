package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;

class StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem implements Parcelable {
    public static final Creator<StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem> CREATOR = new 1();
    int Vh;
    int[] Vi;
    boolean Vj;
    int mPosition;

    public StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem(Parcel parcel) {
        boolean z = true;
        this.mPosition = parcel.readInt();
        this.Vh = parcel.readInt();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.Vj = z;
        int readInt = parcel.readInt();
        if (readInt > 0) {
            this.Vi = new int[readInt];
            parcel.readIntArray(this.Vi);
        }
    }

    final int bK(int i) {
        return this.Vi == null ? 0 : this.Vi[i];
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mPosition);
        parcel.writeInt(this.Vh);
        parcel.writeInt(this.Vj ? 1 : 0);
        if (this.Vi == null || this.Vi.length <= 0) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(this.Vi.length);
        parcel.writeIntArray(this.Vi);
    }

    public String toString() {
        return "FullSpanItem{mPosition=" + this.mPosition + ", mGapDir=" + this.Vh + ", mHasUnwantedGapAfter=" + this.Vj + ", mGapPerSpan=" + Arrays.toString(this.Vi) + '}';
    }
}
