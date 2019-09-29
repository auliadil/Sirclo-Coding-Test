package com.sirclo.service;

import java.util.LinkedList;

import com.sirclo.model.IklimModel;
import com.sirclo.model.RowModel;

public interface IklimService {
	IklimModel getIklimModel(long idKota);
	LinkedList<RowModel> getRowModel(IklimModel iklimModel);
	long getRataSuhu(LinkedList<RowModel> rowList);
	long getRataPerbedaan(LinkedList<RowModel> rowList);
}
