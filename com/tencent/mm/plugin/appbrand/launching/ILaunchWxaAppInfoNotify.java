package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;

public interface ILaunchWxaAppInfoNotify {
    public static final ILaunchWxaAppInfoNotify gfI = new 1();

    public static class LaunchInfoIpcWrapper implements Parcelable {
        public static final Creator<LaunchInfoIpcWrapper> CREATOR = new 1();
        public String appId;
        public int fmv;
        public AppRuntimeApiPermissionBundle fqP;
        public AppBrandLaunchErrorAction gfJ;

        LaunchInfoIpcWrapper() {
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.appId);
            parcel.writeInt(this.fmv);
            parcel.writeParcelable(this.fqP, i);
            parcel.writeParcelable(this.gfJ, i);
        }

        LaunchInfoIpcWrapper(Parcel parcel) {
            this.appId = parcel.readString();
            this.fmv = parcel.readInt();
            this.fqP = (AppRuntimeApiPermissionBundle) parcel.readParcelable(AppRuntimeApiPermissionBundle.class.getClassLoader());
            this.gfJ = (AppBrandLaunchErrorAction) parcel.readParcelable(AppBrandLaunchErrorAction.class.getClassLoader());
        }
    }

    public static class a {
    }

    void a(String str, int i, String str2, t tVar);
}
