package com.tencent.mm.protocal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Set;

public class JsapiPermissionWrapper implements Parcelable {
    public static final Creator<JsapiPermissionWrapper> CREATOR = new 1();
    public static final JsapiPermissionWrapper qWa = new JsapiPermissionWrapper(1);
    public static final JsapiPermissionWrapper qWb = new JsapiPermissionWrapper(2);
    public static final JsapiPermissionWrapper qWc = new JsapiPermissionWrapper(3);
    public static final JsapiPermissionWrapper qWd = new JsapiPermissionWrapper(4);
    public byte[] qWe;
    private int qWf;
    private Set<Integer> qWg;
    private Set<Integer> qWh;

    /* synthetic */ JsapiPermissionWrapper(Parcel parcel, byte b) {
        this(parcel);
    }

    public JsapiPermissionWrapper() {
        this.qWe = null;
        this.qWf = 0;
        this.qWe = null;
    }

    public JsapiPermissionWrapper(byte[] bArr) {
        this.qWe = null;
        this.qWf = 0;
        if (bArr == null) {
            this.qWe = null;
        } else {
            this.qWe = bArr;
        }
    }

    public JsapiPermissionWrapper(int i) {
        this.qWe = null;
        this.qWf = 0;
        this.qWf = i;
        this.qWe = new byte[0];
    }

    public final int CB(int i) {
        int i2;
        if (this.qWh == null || !this.qWh.contains(Integer.valueOf(i))) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        if (i2 != 0) {
            return 1;
        }
        if (this.qWg == null || !this.qWg.contains(Integer.valueOf(i))) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        if (i2 != 0) {
            return 0;
        }
        if (this.qWf == 1) {
            if (i != 34 && i != 75) {
                return 1;
            }
            x.i("MicroMsg.JsapiPermissionWrapper", "on reserved bytes control : %d", new Object[]{Integer.valueOf(i)});
            return 0;
        } else if (this.qWf == 2) {
            if (i != -3) {
                return 0;
            }
            return 1;
        } else if (this.qWf == 3) {
            if (i != 34 && i != 75 && i != 23) {
                return 1;
            }
            x.i("MicroMsg.JsapiPermissionWrapper", "on reserved bytes control : %d", new Object[]{Integer.valueOf(i)});
            return 0;
        } else if (this.qWf == 4) {
            if (i != 34 && i != 75) {
                return 1;
            }
            x.i("MicroMsg.JsapiPermissionWrapper", "hy: on reserved bytes control : %d", new Object[]{Integer.valueOf(i)});
            return 0;
        } else if (i == -2 || i == -3) {
            return 1;
        } else {
            if (this.qWe == null || i < 0 || i >= this.qWe.length) {
                return 0;
            }
            return this.qWe[i];
        }
    }

    public final void a(int i, byte b) {
        int i2 = 0;
        if (this.qWe == null || i < 0 || i >= this.qWe.length) {
            String str = "MicroMsg.JsapiPermissionWrapper";
            String str2 = "setPermission pos out of range, %s, %s";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(i);
            if (this.qWe != null) {
                i2 = this.qWe.length;
            }
            objArr[1] = Integer.valueOf(i2);
            x.e(str, str2, objArr);
            return;
        }
        this.qWe[i] = b;
    }

    public final boolean gu(int i) {
        if (CB(i) == 1) {
            return true;
        }
        return false;
    }

    public static boolean cgl() {
        return true;
    }

    public String toString() {
        if (this.qWe == null) {
            return "null";
        }
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder(180);
        for (byte append : this.qWe) {
            stringBuilder.append(append);
        }
        String stringBuilder2 = stringBuilder.toString();
        x.d("MicroMsg.JsapiPermissionWrapper", "toString cost %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        return stringBuilder2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(this.qWe);
        parcel.writeInt(this.qWf);
        parcel.writeIntArray(cgm());
        parcel.writeIntArray(cgn());
    }

    private JsapiPermissionWrapper(Parcel parcel) {
        this.qWe = null;
        this.qWf = 0;
        this.qWe = parcel.createByteArray();
        this.qWf = parcel.readInt();
        q(parcel.createIntArray());
        r(parcel.createIntArray());
    }

    public final void toBundle(Bundle bundle) {
        bundle.putByteArray("jsapi_perm_wrapper_bytes", this.qWe);
        bundle.putInt("jsapi_perm_wrapper_hardcodePermission", this.qWf);
        bundle.putIntArray("jsapi_perm_wrapper_blacklist", cgm());
        bundle.putIntArray("jsapi_perm_wrapper_whitelist", cgn());
    }

    public final void fromBundle(Bundle bundle) {
        this.qWe = bundle.getByteArray("jsapi_perm_wrapper_bytes");
        this.qWf = bundle.getInt("jsapi_perm_wrapper_hardcodePermission");
        q(bundle.getIntArray("jsapi_perm_wrapper_blacklist"));
        r(bundle.getIntArray("jsapi_perm_wrapper_whitelist"));
    }

    private int[] cgm() {
        if (this.qWg == null) {
            return new int[0];
        }
        int[] iArr = new int[this.qWg.size()];
        int i = 0;
        for (Integer num : this.qWg) {
            int i2 = i + 1;
            iArr[i] = num == null ? 0 : num.intValue();
            i = i2;
        }
        return iArr;
    }

    public final void q(int[] iArr) {
        if (this.qWg == null) {
            this.qWg = new HashSet();
        } else {
            this.qWg.clear();
        }
        if (iArr != null && iArr.length > 0) {
            for (int valueOf : iArr) {
                this.qWg.add(Integer.valueOf(valueOf));
            }
        }
    }

    private int[] cgn() {
        if (this.qWh == null) {
            return new int[0];
        }
        int[] iArr = new int[this.qWh.size()];
        int i = 0;
        for (Integer num : this.qWh) {
            int i2 = i + 1;
            iArr[i] = num == null ? 0 : num.intValue();
            i = i2;
        }
        return iArr;
    }

    public final void r(int[] iArr) {
        if (this.qWh == null) {
            this.qWh = new HashSet();
        } else {
            this.qWh.clear();
        }
        if (iArr != null && iArr.length > 0) {
            for (int valueOf : iArr) {
                this.qWh.add(Integer.valueOf(valueOf));
            }
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof JsapiPermissionWrapper)) {
            return false;
        }
        JsapiPermissionWrapper jsapiPermissionWrapper = (JsapiPermissionWrapper) obj;
        if (this.qWe == jsapiPermissionWrapper.qWe) {
            return true;
        }
        if (this.qWe == null || jsapiPermissionWrapper.qWe == null || this.qWe.length != jsapiPermissionWrapper.qWe.length) {
            return false;
        }
        for (int i = 0; i < this.qWe.length; i++) {
            if (this.qWe[i] != jsapiPermissionWrapper.qWe[i]) {
                return false;
            }
        }
        return true;
    }
}
