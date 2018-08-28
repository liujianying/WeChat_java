package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.util.ArrayList;

final class BackStackState implements Parcelable {
    public static final Creator<BackStackState> CREATOR = new Creator<BackStackState>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new BackStackState(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new BackStackState[i];
        }
    };
    final int mF;
    final int mG;
    final int mIndex;
    final int mK;
    final CharSequence mL;
    final int mM;
    final CharSequence mN;
    final String mName;
    final ArrayList<String> mO;
    final ArrayList<String> mP;
    final int[] nn;

    public BackStackState(e eVar) {
        int i = 0;
        for (a aVar = eVar.my; aVar != null; aVar = aVar.na) {
            if (aVar.ni != null) {
                i += aVar.ni.size();
            }
        }
        this.nn = new int[(i + (eVar.mA * 7))];
        if (eVar.mH) {
            a aVar2 = eVar.my;
            int i2 = 0;
            while (aVar2 != null) {
                int i3 = i2 + 1;
                this.nn[i2] = aVar2.nc;
                int i4 = i3 + 1;
                this.nn[i3] = aVar2.nd != null ? aVar2.nd.mIndex : -1;
                i3 = i4 + 1;
                this.nn[i4] = aVar2.ne;
                i2 = i3 + 1;
                this.nn[i3] = aVar2.nf;
                i3 = i2 + 1;
                this.nn[i2] = aVar2.ng;
                i2 = i3 + 1;
                this.nn[i3] = aVar2.nh;
                if (aVar2.ni != null) {
                    int size = aVar2.ni.size();
                    i3 = i2 + 1;
                    this.nn[i2] = size;
                    i2 = 0;
                    while (i2 < size) {
                        i4 = i3 + 1;
                        this.nn[i3] = ((Fragment) aVar2.ni.get(i2)).mIndex;
                        i2++;
                        i3 = i4;
                    }
                    i = i3;
                } else {
                    i = i2 + 1;
                    this.nn[i2] = 0;
                }
                aVar2 = aVar2.na;
                i2 = i;
            }
            this.mF = eVar.mF;
            this.mG = eVar.mG;
            this.mName = eVar.mName;
            this.mIndex = eVar.mIndex;
            this.mK = eVar.mK;
            this.mL = eVar.mL;
            this.mM = eVar.mM;
            this.mN = eVar.mN;
            this.mO = eVar.mO;
            this.mP = eVar.mP;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public BackStackState(Parcel parcel) {
        this.nn = parcel.createIntArray();
        this.mF = parcel.readInt();
        this.mG = parcel.readInt();
        this.mName = parcel.readString();
        this.mIndex = parcel.readInt();
        this.mK = parcel.readInt();
        this.mL = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mM = parcel.readInt();
        this.mN = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mO = parcel.createStringArrayList();
        this.mP = parcel.createStringArrayList();
    }

    public final e a(n nVar) {
        e eVar = new e(nVar);
        int i = 0;
        int i2 = 0;
        while (i2 < this.nn.length) {
            a aVar = new a();
            int i3 = i2 + 1;
            aVar.nc = this.nn[i2];
            if (n.DEBUG) {
                new StringBuilder("Instantiate ").append(eVar).append(" op #").append(i).append(" base fragment #").append(this.nn[i3]);
            }
            i2 = i3 + 1;
            int i4 = this.nn[i3];
            if (i4 >= 0) {
                aVar.nd = (Fragment) nVar.nK.get(i4);
            } else {
                aVar.nd = null;
            }
            i3 = i2 + 1;
            aVar.ne = this.nn[i2];
            i2 = i3 + 1;
            aVar.nf = this.nn[i3];
            i3 = i2 + 1;
            aVar.ng = this.nn[i2];
            int i5 = i3 + 1;
            aVar.nh = this.nn[i3];
            i2 = i5 + 1;
            int i6 = this.nn[i5];
            if (i6 > 0) {
                aVar.ni = new ArrayList(i6);
                i3 = 0;
                while (i3 < i6) {
                    if (n.DEBUG) {
                        new StringBuilder("Instantiate ").append(eVar).append(" set remove fragment #").append(this.nn[i2]);
                    }
                    i5 = i2 + 1;
                    aVar.ni.add((Fragment) nVar.nK.get(this.nn[i2]));
                    i3++;
                    i2 = i5;
                }
            }
            eVar.mB = aVar.ne;
            eVar.mC = aVar.nf;
            eVar.mD = aVar.ng;
            eVar.mE = aVar.nh;
            eVar.a(aVar);
            i++;
        }
        eVar.mF = this.mF;
        eVar.mG = this.mG;
        eVar.mName = this.mName;
        eVar.mIndex = this.mIndex;
        eVar.mH = true;
        eVar.mK = this.mK;
        eVar.mL = this.mL;
        eVar.mM = this.mM;
        eVar.mN = this.mN;
        eVar.mO = this.mO;
        eVar.mP = this.mP;
        eVar.Q(1);
        return eVar;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.nn);
        parcel.writeInt(this.mF);
        parcel.writeInt(this.mG);
        parcel.writeString(this.mName);
        parcel.writeInt(this.mIndex);
        parcel.writeInt(this.mK);
        TextUtils.writeToParcel(this.mL, parcel, 0);
        parcel.writeInt(this.mM);
        TextUtils.writeToParcel(this.mN, parcel, 0);
        parcel.writeStringList(this.mO);
        parcel.writeStringList(this.mP);
    }
}
