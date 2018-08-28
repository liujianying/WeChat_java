package com.tencent.mm.plugin.gallery.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.bi;

public final class GalleryItem {

    public static class VideoMediaItem extends MediaItem {
        public static final Creator<MediaItem> CREATOR = new 1();
        public String egB;
        public String egC;
        public int egD = -1;
        public int egE = -1;
        public int videoBitRate = -1;
        public int videoFrameRate = -1;
        public int videoHeight = -1;
        public int videoWidth = -1;

        public VideoMediaItem(long j) {
            super(j);
        }

        public VideoMediaItem(long j, String str, String str2, String str3) {
            super(j, str, str2, str3);
        }

        public final int getType() {
            return 2;
        }

        public final String aRw() {
            if (bi.oW(this.iSr)) {
                return this.egA;
            }
            return this.iSr;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.egA);
            parcel.writeString(this.iSr);
            parcel.writeLong(this.jAU);
            parcel.writeString(this.mMimeType);
            parcel.writeInt(this.videoWidth);
            parcel.writeInt(this.videoHeight);
            parcel.writeInt(this.egD);
            parcel.writeString(this.egB);
            parcel.writeString(this.egC);
            parcel.writeInt(this.egE);
            parcel.writeInt(this.videoFrameRate);
            parcel.writeInt(this.videoBitRate);
        }

        public String toString() {
            return "VideoMediaItem{base=" + super.toString() + ", videoTrackMime='" + this.egB + '\'' + ", audioTrackMime='" + this.egC + '\'' + ", durationMs=" + this.egD + ", videoHeight=" + this.videoHeight + ", videoWidth=" + this.videoWidth + ", videoBitRate=" + this.videoBitRate + ", videoIFrameInterval=" + this.egE + ", videoFrameRate=" + this.videoFrameRate + '}';
        }
    }
}
