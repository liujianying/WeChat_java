package com.tencent.mm.modelcontrol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class VideoTransPara implements Parcelable {
    public static final Creator<VideoTransPara> CREATOR = new Creator<VideoTransPara>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new VideoTransPara(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new VideoTransPara[i];
        }
    };
    public int audioSampleRate;
    public int dQF;
    public int dQG;
    public int dQH;
    public int dQI;
    public int dQS = 0;
    public int duration;
    public int fps;
    public int height;
    public boolean isDefault;
    public int videoBitrate;
    public int width;

    protected VideoTransPara(Parcel parcel) {
        boolean z = false;
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.fps = parcel.readInt();
        this.videoBitrate = parcel.readInt();
        this.duration = parcel.readInt();
        this.dQG = parcel.readInt();
        this.dQF = parcel.readInt();
        this.audioSampleRate = parcel.readInt();
        this.dQH = parcel.readInt();
        this.dQI = parcel.readInt();
        if (parcel.readInt() > 0) {
            z = true;
        }
        this.isDefault = z;
        this.dQS = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeInt(this.fps);
        parcel.writeInt(this.videoBitrate);
        parcel.writeInt(this.duration);
        parcel.writeInt(this.dQG);
        parcel.writeInt(this.dQF);
        parcel.writeInt(this.audioSampleRate);
        parcel.writeInt(this.dQH);
        parcel.writeInt(this.dQI);
        parcel.writeInt(this.isDefault ? 1 : 0);
        parcel.writeInt(this.dQS);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "[isDefault " + this.isDefault + "width " + this.width + " height " + this.height + " fps " + this.fps + " video bitrate " + this.videoBitrate + " iFrame " + this.dQG + " audio bitrate " + this.dQF + " audioSampleRate " + this.audioSampleRate + " duration " + this.duration + " profile index " + this.dQH + " preset index " + this.dQI + " thumbSize " + this.dQS + "]";
    }
}
