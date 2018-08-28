package android.support.v4.os;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ResultReceiver implements Parcelable {
    public static final Creator<ResultReceiver> CREATOR = new 1();
    public final Handler mHandler = null;
    public final boolean sW = false;
    public a sX;

    class a extends android.support.v4.os.a.a {
        a() {
        }

        public final void send(int i, Bundle bundle) {
            if (ResultReceiver.this.mHandler != null) {
                ResultReceiver.this.mHandler.post(new b(ResultReceiver.this, i, bundle));
            } else {
                ResultReceiver.this.onReceiveResult(i, bundle);
            }
        }
    }

    public void onReceiveResult(int i, Bundle bundle) {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        synchronized (this) {
            if (this.sX == null) {
                this.sX = new a();
            }
            parcel.writeStrongBinder(this.sX.asBinder());
        }
    }

    ResultReceiver(Parcel parcel) {
        this.sX = android.support.v4.os.a.a.b(parcel.readStrongBinder());
    }
}
