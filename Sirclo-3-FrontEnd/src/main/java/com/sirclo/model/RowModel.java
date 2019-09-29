package com.sirclo.model;

public class RowModel {
	
	private long tanggal;
	
	private long suhu;
	
	private long perbedaan;
	
	
	public RowModel(long dt, long temp, long temp_min, long temp_max) {
		this.tanggal = dt;
		this.suhu = temp;
		this.perbedaan = temp_max - temp_min;
	}

	public long getTanggal() {
		return tanggal;
	}

	public void setTanggal(long tanggal) {
		this.tanggal = tanggal;
	}

	public long getSuhu() {
		return suhu;
	}

	public void setSuhu(long suhu) {
		this.suhu = suhu;
	}

	public long getPerbedaan() {
		return perbedaan;
	}

	public void setPerbedaan(long perbedaan) {
		this.perbedaan = perbedaan;
	}
}
