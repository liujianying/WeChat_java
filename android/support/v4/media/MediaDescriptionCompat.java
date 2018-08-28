package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.media.MediaDescription.Builder;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;

public final class MediaDescriptionCompat implements Parcelable {
    public static final Creator<MediaDescriptionCompat> CREATOR = new Creator<MediaDescriptionCompat>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return VERSION.SDK_INT < 21 ? new MediaDescriptionCompat(parcel, (byte) 0) : MediaDescriptionCompat.g(MediaDescription.CREATOR.createFromParcel(parcel));
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MediaDescriptionCompat[i];
        }
    };
    private final Bundle mExtras;
    private final String sm;
    private final CharSequence sn;
    private final CharSequence so;
    private final CharSequence sp;
    private final Bitmap sq;
    private final Uri sr;
    private final Uri ss;
    private Object st;

    public static final class a {
        Bundle mExtras;
        String sm;
        CharSequence sn;
        CharSequence so;
        CharSequence sp;
        Bitmap sq;
        Uri sr;
        Uri ss;
    }

    /* synthetic */ MediaDescriptionCompat(Parcel parcel, byte b) {
        this(parcel);
    }

    private /* synthetic */ MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2, byte b) {
        this(str, charSequence, charSequence2, charSequence3, bitmap, uri, bundle, uri2);
    }

    private MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.sm = str;
        this.sn = charSequence;
        this.so = charSequence2;
        this.sp = charSequence3;
        this.sq = bitmap;
        this.sr = uri;
        this.mExtras = bundle;
        this.ss = uri2;
    }

    private MediaDescriptionCompat(Parcel parcel) {
        this.sm = parcel.readString();
        this.sn = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.so = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.sp = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.sq = (Bitmap) parcel.readParcelable(null);
        this.sr = (Uri) parcel.readParcelable(null);
        this.mExtras = parcel.readBundle();
        this.ss = (Uri) parcel.readParcelable(null);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        if (VERSION.SDK_INT < 21) {
            parcel.writeString(this.sm);
            TextUtils.writeToParcel(this.sn, parcel, i);
            TextUtils.writeToParcel(this.so, parcel, i);
            TextUtils.writeToParcel(this.sp, parcel, i);
            parcel.writeParcelable(this.sq, i);
            parcel.writeParcelable(this.sr, i);
            parcel.writeBundle(this.mExtras);
            parcel.writeParcelable(this.ss, i);
            return;
        }
        Object obj;
        if (this.st != null || VERSION.SDK_INT < 21) {
            obj = this.st;
        } else {
            Bundle bundle;
            Builder builder = new Builder();
            builder.setMediaId(this.sm);
            builder.setTitle(this.sn);
            builder.setSubtitle(this.so);
            builder.setDescription(this.sp);
            builder.setIconBitmap(this.sq);
            builder.setIconUri(this.sr);
            Bundle bundle2 = this.mExtras;
            if (VERSION.SDK_INT >= 23 || this.ss == null) {
                bundle = bundle2;
            } else {
                if (bundle2 == null) {
                    bundle2 = new Bundle();
                    bundle2.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
                }
                bundle2.putParcelable("android.support.v4.media.description.MEDIA_URI", this.ss);
                bundle = bundle2;
            }
            builder.setExtras(bundle);
            if (VERSION.SDK_INT >= 23) {
                builder.setMediaUri(this.ss);
            }
            this.st = builder.build();
            obj = this.st;
        }
        ((MediaDescription) obj).writeToParcel(parcel, i);
    }

    public final String toString() {
        return this.sn + ", " + this.so + ", " + this.sp;
    }

    public static MediaDescriptionCompat g(Object obj) {
        if (obj == null || VERSION.SDK_INT < 21) {
            return null;
        }
        Uri uri;
        Bundle bundle;
        MediaDescriptionCompat mediaDescriptionCompat;
        a aVar = new a();
        aVar.sm = ((MediaDescription) obj).getMediaId();
        aVar.sn = ((MediaDescription) obj).getTitle();
        aVar.so = ((MediaDescription) obj).getSubtitle();
        aVar.sp = ((MediaDescription) obj).getDescription();
        aVar.sq = ((MediaDescription) obj).getIconBitmap();
        aVar.sr = ((MediaDescription) obj).getIconUri();
        Bundle extras = ((MediaDescription) obj).getExtras();
        if (extras == null) {
            uri = null;
        } else {
            uri = (Uri) extras.getParcelable("android.support.v4.media.description.MEDIA_URI");
        }
        if (uri != null) {
            if (extras.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG") && extras.size() == 2) {
                bundle = null;
                aVar.mExtras = bundle;
                if (uri != null) {
                    aVar.ss = uri;
                } else if (VERSION.SDK_INT >= 23) {
                    aVar.ss = ((MediaDescription) obj).getMediaUri();
                }
                mediaDescriptionCompat = new MediaDescriptionCompat(aVar.sm, aVar.sn, aVar.so, aVar.sp, aVar.sq, aVar.sr, aVar.mExtras, aVar.ss, (byte) 0);
                mediaDescriptionCompat.st = obj;
                return mediaDescriptionCompat;
            }
            extras.remove("android.support.v4.media.description.MEDIA_URI");
            extras.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
        }
        bundle = extras;
        aVar.mExtras = bundle;
        if (uri != null) {
            aVar.ss = uri;
        } else if (VERSION.SDK_INT >= 23) {
            aVar.ss = ((MediaDescription) obj).getMediaUri();
        }
        mediaDescriptionCompat = new MediaDescriptionCompat(aVar.sm, aVar.sn, aVar.so, aVar.sp, aVar.sq, aVar.sr, aVar.mExtras, aVar.ss, (byte) 0);
        mediaDescriptionCompat.st = obj;
        return mediaDescriptionCompat;
    }
}
