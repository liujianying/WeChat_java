package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

final class FragmentManagerState implements Parcelable {
    public static final Creator<FragmentManagerState> CREATOR = new Creator<FragmentManagerState>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new FragmentManagerState(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new FragmentManagerState[i];
        }
    };
    FragmentState[] or;
    int[] os;
    BackStackState[] ot;

    public FragmentManagerState(Parcel parcel) {
        this.or = (FragmentState[]) parcel.createTypedArray(FragmentState.CREATOR);
        this.os = parcel.createIntArray();
        this.ot = (BackStackState[]) parcel.createTypedArray(BackStackState.CREATOR);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.or, i);
        parcel.writeIntArray(this.os);
        parcel.writeTypedArray(this.ot, i);
    }
}
