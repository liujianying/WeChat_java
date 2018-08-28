package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.modelappbrand.s;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.mm.plugin.appbrand.dynamic.j.d;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetRuntimeConfig;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetSysConfig;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import junit.framework.Assert;

public final class WxaWidgetInitializer {

    private static class WxaWidgetContextImpl implements WxaWidgetContext {
        public static final Creator<WxaWidgetContextImpl> CREATOR = new 1();
        String doU;
        WxaPkgWrappingInfo fuZ;
        WxaPkgWrappingInfo fva;
        byte[] fvb;
        int fvc;
        DebuggerInfo fvd;
        WidgetSysConfig fve;
        WidgetRuntimeConfig fvf;
        String mAppId;

        public WxaWidgetContextImpl(Parcel parcel) {
            ClassLoader classLoader = getClass().getClassLoader();
            this.doU = parcel.readString();
            this.mAppId = parcel.readString();
            this.fva = (WxaPkgWrappingInfo) parcel.readParcelable(classLoader);
            this.fuZ = (WxaPkgWrappingInfo) parcel.readParcelable(classLoader);
            this.fvb = parcel.createByteArray();
            this.fvc = parcel.readInt();
            this.fvd = (DebuggerInfo) parcel.readParcelable(classLoader);
            this.fve = (WidgetSysConfig) parcel.readParcelable(classLoader);
            this.fvf = (WidgetRuntimeConfig) parcel.readParcelable(classLoader);
        }

        public WxaWidgetContextImpl(WxaPkgWrappingInfo wxaPkgWrappingInfo, WxaPkgWrappingInfo wxaPkgWrappingInfo2) {
            Assert.assertNotNull(wxaPkgWrappingInfo);
            Assert.assertNotNull(wxaPkgWrappingInfo2);
            this.fva = wxaPkgWrappingInfo;
            this.fuZ = wxaPkgWrappingInfo2;
        }

        public final WxaPkgWrappingInfo aeW() {
            return this.fuZ;
        }

        public final WxaPkgWrappingInfo aeX() {
            return this.fva;
        }

        public final String getId() {
            return this.doU;
        }

        public final String getAppId() {
            return this.mAppId;
        }

        public final int aeY() {
            return this.fuZ != null ? this.fuZ.fih : 0;
        }

        public final int aeZ() {
            return this.fuZ != null ? this.fuZ.fii : 0;
        }

        public final byte[] afa() {
            return this.fvb;
        }

        public final int afb() {
            return this.fvc;
        }

        public final DebuggerInfo afc() {
            return this.fvd;
        }

        public final WidgetSysConfig afd() {
            return this.fve;
        }

        public final WidgetRuntimeConfig afe() {
            return this.fvf;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.doU);
            parcel.writeString(this.mAppId);
            parcel.writeParcelable(this.fva, i);
            parcel.writeParcelable(this.fuZ, i);
            parcel.writeByteArray(this.fvb);
            parcel.writeInt(this.fvc);
            parcel.writeParcelable(this.fvd, i);
            parcel.writeParcelable(this.fve, i);
            parcel.writeParcelable(this.fvf, i);
        }
    }

    static WxaWidgetContextImpl a(String str, String str2, WxaPkgWrappingInfo wxaPkgWrappingInfo, d dVar) {
        int i = 1;
        x.i("MicroMsg.WxaWidgetInitializer", "prepare(%s)", new Object[]{str});
        s.i("MicroMsg.WxaWidgetInitializer", "prepare(%s)", new Object[]{str});
        WxaPkgWrappingInfo abP = WxaCommLibRuntimeReader.abP();
        if (abP == null) {
            x.e("MicroMsg.WxaWidgetInitializer", "getLibPkgInfo return null.");
            return null;
        }
        WxaWidgetContextImpl wxaWidgetContextImpl = new WxaWidgetContextImpl(abP, wxaPkgWrappingInfo);
        wxaWidgetContextImpl.doU = str;
        wxaWidgetContextImpl.mAppId = str2;
        wxaWidgetContextImpl.fvd = dVar.fxI;
        if (wxaWidgetContextImpl.fvd == null) {
            wxaWidgetContextImpl.fvd = new DebuggerInfo();
        }
        wxaWidgetContextImpl.fve = dVar.fxJ;
        wxaWidgetContextImpl.fvf = dVar.fxK;
        try {
            byte[] toByteArray = (dVar.fxM == null || dVar.fxM.rsl == null) ? new byte[0] : dVar.fxM.rsl.toByteArray();
            wxaWidgetContextImpl.fvb = toByteArray;
        } catch (Throwable e) {
            x.e("MicroMsg.WxaWidgetInitializer", bi.i(e));
        }
        if (wxaWidgetContextImpl.fvd.fvF) {
            wxaWidgetContextImpl.fvc = 2;
            f.aeS().ax(str, 2101);
            j.aeV().C(str, 626, 5);
        } else {
            if (dVar.fxL != null) {
                i = dVar.fxL.qZk;
            }
            wxaWidgetContextImpl.fvc = i;
        }
        return wxaWidgetContextImpl;
    }

    public static String bh(String str, String str2) {
        return str + "#" + str2 + "#" + System.currentTimeMillis();
    }
}
