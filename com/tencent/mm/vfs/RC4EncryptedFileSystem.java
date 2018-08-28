package com.tencent.mm.vfs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;

public class RC4EncryptedFileSystem extends FileBasedFileSystem {
    public static final Creator<RC4EncryptedFileSystem> CREATOR = new Creator<RC4EncryptedFileSystem>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new RC4EncryptedFileSystem(parcel, (byte) 0);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new RC4EncryptedFileSystem[i];
        }
    };
    private final SecretKeySpec uSm;

    public RC4EncryptedFileSystem(String str, byte[] bArr) {
        super(str);
        this.uSm = new SecretKeySpec(bArr, "RC4");
    }

    private RC4EncryptedFileSystem(Parcel parcel) {
        super(parcel);
        int readInt = parcel.readInt();
        if (readInt > 256 || readInt < 0) {
            throw new IllegalStateException("Invalid parcel");
        }
        byte[] bArr = new byte[readInt];
        parcel.readByteArray(bArr);
        this.uSm = new SecretKeySpec(bArr, "RC4");
    }

    public final InputStream openRead(String str) {
        String abM = abM(str);
        if (abM == null) {
            throw new IOException("Invalid path: " + str);
        }
        try {
            Cipher instance = Cipher.getInstance("RC4");
            instance.init(2, this.uSm);
            return new CipherInputStream(new FileInputStream(abM), instance);
        } catch (Throwable e) {
            throw ((FileNotFoundException) new FileNotFoundException("Failed to initialize cipher: " + e.getMessage()).initCause(e));
        }
    }

    public final OutputStream mG(String str) {
        if (this.mReadOnly) {
            throw new IOException("Cannot open files for writing on read-only file systems");
        }
        String abM = abM(str);
        if (abM == null) {
            throw new IOException("Invalid path: " + str);
        }
        try {
            Cipher instance = Cipher.getInstance("RC4");
            instance.init(1, this.uSm);
            return new CipherOutputStream(new FileOutputStream(abM), instance);
        } catch (Throwable e) {
            throw ((FileNotFoundException) new FileNotFoundException("Failed to initialize cipher: " + e.getMessage()).initCause(e));
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        byte[] encoded = this.uSm.getEncoded();
        parcel.writeInt(encoded.length);
        parcel.writeByteArray(encoded);
    }
}
