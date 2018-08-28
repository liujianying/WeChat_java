package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

public class StaggeredGridLayoutManager$SavedState implements Parcelable {
    public static final Creator<StaggeredGridLayoutManager$SavedState> CREATOR = new 1();
    int PA;
    boolean PC;
    boolean Ph;
    boolean UW;
    List<StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem> Vg;
    int Vk;
    int Vl;
    int[] Vm;
    int Vn;
    int[] Vo;

    StaggeredGridLayoutManager$SavedState(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.PA = parcel.readInt();
        this.Vk = parcel.readInt();
        this.Vl = parcel.readInt();
        if (this.Vl > 0) {
            this.Vm = new int[this.Vl];
            parcel.readIntArray(this.Vm);
        }
        this.Vn = parcel.readInt();
        if (this.Vn > 0) {
            this.Vo = new int[this.Vn];
            parcel.readIntArray(this.Vo);
        }
        this.Ph = parcel.readInt() == 1;
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.PC = z;
        if (parcel.readInt() != 1) {
            z2 = false;
        }
        this.UW = z2;
        this.Vg = parcel.readArrayList(StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem.class.getClassLoader());
    }

    public StaggeredGridLayoutManager$SavedState(StaggeredGridLayoutManager$SavedState staggeredGridLayoutManager$SavedState) {
        this.Vl = staggeredGridLayoutManager$SavedState.Vl;
        this.PA = staggeredGridLayoutManager$SavedState.PA;
        this.Vk = staggeredGridLayoutManager$SavedState.Vk;
        this.Vm = staggeredGridLayoutManager$SavedState.Vm;
        this.Vn = staggeredGridLayoutManager$SavedState.Vn;
        this.Vo = staggeredGridLayoutManager$SavedState.Vo;
        this.Ph = staggeredGridLayoutManager$SavedState.Ph;
        this.PC = staggeredGridLayoutManager$SavedState.PC;
        this.UW = staggeredGridLayoutManager$SavedState.UW;
        this.Vg = staggeredGridLayoutManager$SavedState.Vg;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeInt(this.PA);
        parcel.writeInt(this.Vk);
        parcel.writeInt(this.Vl);
        if (this.Vl > 0) {
            parcel.writeIntArray(this.Vm);
        }
        parcel.writeInt(this.Vn);
        if (this.Vn > 0) {
            parcel.writeIntArray(this.Vo);
        }
        if (this.Ph) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.PC) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!this.UW) {
            i3 = 0;
        }
        parcel.writeInt(i3);
        parcel.writeList(this.Vg);
    }
}
