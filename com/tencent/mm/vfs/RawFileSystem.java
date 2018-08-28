package com.tencent.mm.vfs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class RawFileSystem extends FileBasedFileSystem {
    public static final Creator<RawFileSystem> CREATOR = new Creator<RawFileSystem>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new RawFileSystem(parcel, (byte) 0);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new RawFileSystem[i];
        }
    };
    private final boolean uSn;

    private static class a extends FileInputStream {
        private long eey = 0;

        a(String str) {
            super(str);
        }

        public final boolean markSupported() {
            return true;
        }

        public final void mark(int i) {
            try {
                this.eey = getChannel().position();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public final void reset() {
            getChannel().position(this.eey);
        }
    }

    /* synthetic */ RawFileSystem(Parcel parcel, byte b) {
        this(parcel);
    }

    public RawFileSystem(String str) {
        super(str);
        this.uSn = false;
    }

    private RawFileSystem(Parcel parcel) {
        super(parcel);
        this.uSn = parcel.readByte() != (byte) 0;
    }

    public final InputStream openRead(String str) {
        String abM = abM(str);
        if (abM != null) {
            return new a(abM);
        }
        throw new IOException("Invalid path: " + str);
    }

    public final OutputStream mG(String str) {
        if (this.mReadOnly) {
            throw new IOException("Cannot open files for writing on read-only file systems");
        }
        String abM = abM(str);
        if (abM != null) {
            return new FileOutputStream(abM);
        }
        throw new IOException("Invalid path: " + str);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeByte((byte) (this.uSn ? 1 : 0));
    }
}
