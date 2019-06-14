package com.decepticons.assetManagement.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "inventory_info")
public class InventoryInfo {

	// define fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "INV_ID_SEQ", allocationSize = 1)
	@Column(name = "inventory_id")
	private int inv;
	
	@Column(name = "name_Of_Asset")
	private String nameOfAsset;

	@Column(name = "asset_status")
	private String assetStatus;

	@Column(name = "serial_no")
	private int serialNo;

	@Column(name = "purchase_date")
	private Date purchaseDate;
	
	@Column(name = "vendor_id")
	private int vId;

	@Column(name = "vendor_name")
	private String vName;
	
	// define toString
	@Override
	public String toString() {
		
		return "Inventory [getInv()=" + getInv() + ", getNameOfAsset()=" + getNameOfAsset() + ", getVendorId="
				+ getVId() + ", getAssetStatus()=" + getAssetStatus() + ", getSerialNo()=" + getSerialNo() + ", "
						+ "getPurchaseDate()=" + getPurchaseDate() + ", VendorName()=" + getVName()+"]";
	}

}