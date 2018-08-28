package com.tencent.mm.plugin.gallery.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.sdk.platformtools.bi;

public class GalleryItem$AlbumItem implements Parcelable {
    public static final Creator<GalleryItem$AlbumItem> CREATOR = new 1();
    public int bMU;
    public String jAQ;
    public MediaItem jAR;

    public GalleryItem$AlbumItem(String str, int i) {
        this.jAQ = bi.oV(str);
        this.bMU = i;
    }

    protected GalleryItem$AlbumItem(Parcel parcel) {
        this.jAQ = parcel.readString();
        this.bMU = parcel.readInt();
        this.jAR = (MediaItem) parcel.readParcelable(MediaItem.class.getClassLoader());
    }

    public final String aRw() {
        if (this.jAR == null) {
            return null;
        }
        return this.jAR.aRw();
    }

    public final long aRx() {
        if (this.jAR == null) {
            return -1;
        }
        return this.jAR.jAU;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.jAQ);
        parcel.writeInt(this.bMU);
        parcel.writeParcelable(this.jAR, i);
    }
}
