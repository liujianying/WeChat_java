package com.tencent.wework.api.model;

import android.os.Bundle;
import com.tencent.wework.api.model.WWMediaMessage.WWMediaObject;

public class WWMediaLocation extends WWMediaObject {
    public String dRH;
    public double latitude;
    public double longitude;
    public double vzL;

    public final boolean checkArgs() {
        if (super.checkArgs() && this.dRH != null && this.dRH.length() != 0 && this.dRH.length() <= 10240) {
            return true;
        }
        return false;
    }

    public final void toBundle(Bundle bundle) {
        bundle.putString("_wwlocobject_address", this.dRH);
        bundle.putDouble("_wwlocobject_longitude", this.longitude);
        bundle.putDouble("_wwlocobject_latitude", this.latitude);
        bundle.putDouble("_wwlocobject_zoom", this.vzL);
        super.toBundle(bundle);
    }
}
