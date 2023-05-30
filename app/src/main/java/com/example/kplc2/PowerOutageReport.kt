package com.example.kplc2

import android.os.Parcel
import android.os.Parcelable

data class PowerOutageReport(
    val location: String?,
    val description: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(location)
        parcel.writeString(description)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PowerOutageReport> {
        override fun createFromParcel(parcel: Parcel): PowerOutageReport {
            return PowerOutageReport(parcel)
        }

        override fun newArray(size: Int): Array<PowerOutageReport?> {
            return arrayOfNulls(size)
        }
    }
}

