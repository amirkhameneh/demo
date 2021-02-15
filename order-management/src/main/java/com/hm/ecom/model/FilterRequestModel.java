package com.hm.ecom.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Quy Duong
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FilterRequestModel {
	long domain;
	long category;
	long campaign;
	long center;

}
