package com.tencent.mm.plugin.gallery.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;

class GalleryItem$VideoMediaItem$1 implements Creator<MediaItem> {
    GalleryItem$VideoMediaItem$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        VideoMediaItem videoMediaItem = new VideoMediaItem();
        videoMediaItem.egA = parcel.readString();
        videoMediaItem.iSr = parcel.readString();
        videoMediaItem.jAU = parcel.readLong();
        videoMediaItem.mMimeType = parcel.readString();
        videoMediaItem.videoWidth = parcel.readInt();
        videoMediaItem.videoHeight = parcel.readInt();
        videoMediaItem.egD = parcel.readInt();
        videoMediaItem.egB = parcel.readString();
        videoMediaItem.egC = parcel.readString();
        videoMediaItem.egE = parcel.readInt();
        videoMediaItem.videoFrameRate = parcel.readInt();
        videoMediaItem.videoBitRate = parcel.readInt();
        return videoMediaItem;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new MediaItem[i];
    }
}
