package com.tencent.mm.plugin.gallery.model;

import android.os.Parcelable;
import com.tencent.mm.plugin.gallery.model.GalleryItem.ImageMediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;

public abstract class GalleryItem$MediaItem implements Parcelable, Comparable<GalleryItem$MediaItem> {
    public String egA;
    public String iSr;
    public String jAS;
    public String jAT;
    public long jAU;
    public long jAV;
    public String mMimeType;

    public abstract String aRw();

    public abstract int getType();

    public GalleryItem$MediaItem() {
        this(0, "", "", "");
    }

    public GalleryItem$MediaItem(long j) {
        this(j, "", "", "");
    }

    public GalleryItem$MediaItem(long j, String str, String str2, String str3) {
        this.jAU = j;
        this.egA = str;
        this.iSr = str2;
        this.mMimeType = str3;
    }

    public static GalleryItem$MediaItem a(int i, long j, String str, String str2, String str3) {
        if (i == 1) {
            return new ImageMediaItem(j, str, str2, str3);
        }
        return new VideoMediaItem(j, str, str2, str3);
    }

    public static GalleryItem$MediaItem x(int i, long j) {
        if (i == 1) {
            return new ImageMediaItem(j);
        }
        return new VideoMediaItem(j);
    }

    /* renamed from: a */
    public final int compareTo(GalleryItem$MediaItem galleryItem$MediaItem) {
        if (this.jAV > galleryItem$MediaItem.jAV) {
            return 1;
        }
        return this.jAV < galleryItem$MediaItem.jAV ? -1 : -1;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof GalleryItem$MediaItem)) {
            return false;
        }
        GalleryItem$MediaItem galleryItem$MediaItem = (GalleryItem$MediaItem) obj;
        if (this.egA == null || !this.egA.equals(galleryItem$MediaItem.egA)) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "MediaItem{mOrignalPath='" + this.egA + '\'' + ", mThumbPath='" + this.iSr + '\'' + ", origId=" + this.jAU + ", addDate=" + this.jAV + ", mMimeType='" + this.mMimeType + '\'' + '}';
    }
}
