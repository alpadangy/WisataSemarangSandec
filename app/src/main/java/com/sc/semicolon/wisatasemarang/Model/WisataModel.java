package com.sc.semicolon.wisatasemarang.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ASUS on 13/07/2018.
 */

public class WisataModel implements Parcelable{
    @SerializedName("id_wisata")
    @Expose
    private String idWisata;
    @SerializedName("nama_wisata")
    @Expose
    private String namaWisata;
    @SerializedName("kota_wisata")
    @Expose
    private String kotaWisata;
    @SerializedName("jenis_wisata")
    @Expose
    private String jenisWisata;
    @SerializedName("gambar_wisata")
    @Expose
    private String gambarWisata;
    @SerializedName("deskripsi_wisata")
    @Expose
    private String deskripsiWisata;

    protected WisataModel(Parcel in) {
        idWisata = in.readString();
        namaWisata = in.readString();
        kotaWisata = in.readString();
        jenisWisata = in.readString();
        gambarWisata = in.readString();
        deskripsiWisata = in.readString();
    }

    public static final Creator<WisataModel> CREATOR = new Creator<WisataModel>() {
        @Override
        public WisataModel createFromParcel(Parcel in) {
            return new WisataModel(in);
        }

        @Override
        public WisataModel[] newArray(int size) {
            return new WisataModel[size];
        }
    };

    public String getIdWisata() {
        return idWisata;
    }

    public void setIdWisata(String idWisata) {
        this.idWisata = idWisata;
    }

    public String getNamaWisata() {
        return namaWisata;
    }

    public void setNamaWisata(String namaWisata) {
        this.namaWisata = namaWisata;
    }

    public String getKotaWisata() {
        return kotaWisata;
    }

    public void setKotaWisata(String kotaWisata) {
        this.kotaWisata = kotaWisata;
    }

    public String getJenisWisata() {
        return jenisWisata;
    }

    public void setJenisWisata(String jenisWisata) {
        this.jenisWisata = jenisWisata;
    }

    public String getGambarWisata() {
        return gambarWisata;
    }

    public void setGambarWisata(String gambarWisata) {
        this.gambarWisata = gambarWisata;
    }

    public String getDeskripsiWisata() {
        return deskripsiWisata;
    }

    public void setDeskripsiWisata(String deskripsiWisata) {
        this.deskripsiWisata = deskripsiWisata;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(idWisata);
        parcel.writeString(namaWisata);
        parcel.writeString(kotaWisata);
        parcel.writeString(jenisWisata);
        parcel.writeString(gambarWisata);
        parcel.writeString(deskripsiWisata);
    }
}
