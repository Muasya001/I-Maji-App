package com.example.kplc2
import android.os.Parcel
import android.os.Parcelable

@Suppress("DEPRECATION")
data class ReportArgs(val report: PowerOutageReport) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readParcelable<PowerOutageReport>(PowerOutageReport::class.java.classLoader)!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(report, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ReportArgs> {
        override fun createFromParcel(parcel: Parcel): ReportArgs {
            return ReportArgs(parcel)
        }

        override fun newArray(size: Int): Array<ReportArgs?> {
            return arrayOfNulls(size)
        }
    }
}

