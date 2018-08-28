package com.tencent.mm.plugin.gallery.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.sdk.platformtools.bi;

public class GalleryItem$ImageMediaItem extends MediaItem {
    public static final Creator<MediaItem> CREATOR = new Creator<MediaItem>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            GalleryItem$ImageMediaItem galleryItem$ImageMediaItem = new GalleryItem$ImageMediaItem();
            galleryItem$ImageMediaItem.egA = parcel.readString();
            galleryItem$ImageMediaItem.iSr = parcel.readString();
            galleryItem$ImageMediaItem.jAU = parcel.readLong();
            galleryItem$ImageMediaItem.jAV = parcel.readLong();
            galleryItem$ImageMediaItem.mMimeType = parcel.readString();
            return galleryItem$ImageMediaItem;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MediaItem[i];
        }
    };

    public GalleryItem$ImageMediaItem(long j) {
        super(j);
    }

    public GalleryItem$ImageMediaItem(long j, String str, String str2, String str3) {
        super(j, str, str2, str3);
    }

    public final int getType() {
        return 1;
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
        parcel.writeLong(this.jAV);
        parcel.writeString(this.mMimeType);
    }
}
