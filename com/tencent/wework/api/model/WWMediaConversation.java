package com.tencent.wework.api.model;

import android.os.Bundle;
import com.tencent.wework.api.model.WWMediaMessage.WWMediaObject;

public class WWMediaConversation extends WWMediaObject {
    public String jed;
    public long mEo;
    public String name;
    public byte[] vzJ;
    public WWMediaObject vzK;

    public final boolean checkArgs() {
        if (!super.checkArgs()) {
            return false;
        }
        if (this.vzJ != null && this.vzJ.length > 10485760) {
            return false;
        }
        if (this.jed != null && this.jed.length() > 10240) {
            return false;
        }
        if ((this.jed == null || getFileSize(this.jed) <= 10485760) && this.vzK != null && this.vzK.checkArgs()) {
            return true;
        }
        return false;
    }

    public final void toBundle(Bundle bundle) {
        super.toBundle(bundle);
        bundle.putString("_wwconvobject_name", this.name);
        bundle.putLong("_wwconvobject_date", this.mEo);
        bundle.putByteArray("_wwconvobject_avatarData", this.vzJ);
        bundle.putString("_wwconvobject_avatarPath", this.jed);
        bundle.putBundle("_wwconvobject_message", BaseMessage.b(this.vzK));
    }
}
