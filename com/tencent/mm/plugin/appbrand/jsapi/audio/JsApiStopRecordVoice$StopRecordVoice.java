package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.r.c;

class JsApiStopRecordVoice$StopRecordVoice extends MainProcessTask {
    public static final Creator<JsApiStopRecordVoice$StopRecordVoice> CREATOR = new Creator<JsApiStopRecordVoice$StopRecordVoice>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new JsApiStopRecordVoice$StopRecordVoice();
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new JsApiStopRecordVoice$StopRecordVoice[i];
        }
    };

    private JsApiStopRecordVoice$StopRecordVoice() {
    }

    /* synthetic */ JsApiStopRecordVoice$StopRecordVoice(byte b) {
        this();
    }

    public final void aai() {
        c.Em().H(new 1(this));
    }
}
